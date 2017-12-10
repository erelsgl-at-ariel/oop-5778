package lesson5;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

import com.sun.net.httpserver.HttpServer;

/**
 * A web-server that reverses strings. Uses com.sun.net.httpserver package.
 * @author erelsgl
 * @see https://stackoverflow.com/a/3732328/827927
 */
public class ReversingServer {
    public static void main(String[] args) throws Exception {
    	int port = 8001;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
//        HttpHandler handler = new HttpHandler() {
//			public void handle(HttpExchange request) throws IOException {
//				// TODO Auto-generated method stub
//			}
//        };
//        server.createContext("/reverse", handler);
        
        
        server.createContext("/reverse", request -> {
        	String output = null;
        	try {
	        	String input = request.getRequestURI().getQuery();
	        	if (input != null) { 
		        	System.out.println("GET input: "+input);
	        	} else {
	                 InputStreamReader isr = new InputStreamReader(request.getRequestBody(), "utf-8");
	                 BufferedReader br = new BufferedReader(isr);
	                 input = br.readLine();	        		
	                 System.out.println("POST input: "+input);
	        	}
	        	output = new StringBuilder(input).reverse().toString();
        	} catch (Throwable ex) {
        		output = "Sorry, there was an error: "+ex;
        	}
        	System.out.println("   The output is: "+output);
        	
        	request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        	request.getResponseHeaders().set("Content-Type", "text/plain");
            request.sendResponseHeaders(200 /* OK */, 0);
            try (OutputStream os = request.getResponseBody()) {
            	os.write(output.getBytes());
            } catch (Exception ex) {
            	System.out.println("Error while sending response to client");
            	ex.printStackTrace();
            }
        });
        
        server.createContext("/file", request -> {
        	String fileName = request.getRequestURI().getPath().replaceAll("/file/", "");
        	System.out.println("Got new file-request: "+fileName);
        	Path path = Paths.get("client", "lesson5", fileName);
        	String output = null;
        	try {
        		output = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        	} catch (NoSuchFileException ex) {
        		output = "Dear user, the file '"+fileName+"' does not exist. I am sorry.";
        	} catch (Exception ex) {
        		output = "Error: "+ex;
        	}

        	String contentType = (
        		fileName.endsWith(".html")? "text/html":
           		fileName.endsWith(".js")? "text/javascript":
               	fileName.endsWith(".css")? "text/css":
               	"text/plain"
        		);
        	
        	request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        	request.getResponseHeaders().set("Content-Type", contentType);
            request.sendResponseHeaders(200, 0);
            try (OutputStream os = request.getResponseBody()) {
            	os.write(output.getBytes());
            }
        });
        String url = "http://127.0.0.1:"+port;
        System.out.println("ReversingServer is up. "+
        		"Try "+url+"/reverse?abc   or   "+url+"/file/reverse3.html   or   "+url+"/file/reverse4post.html");
        server.start();
    }
}
