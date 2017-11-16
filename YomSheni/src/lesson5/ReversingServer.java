package lesson5;

import java.io.OutputStream;
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
        server.createContext("/reverse/", request -> {
        	String path = request.getRequestURI().getPath();
        	System.out.println("The path is: "+path);
        	String input = path.replaceAll("/reverse/", "");
        	System.out.println("   The input is: "+input);
        	String output = new StringBuilder(input).reverse().toString(); 
        	System.out.println("   The output is: "+output);
        	request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        	request.getResponseHeaders().set("Content-Type", "text/plain");
            request.sendResponseHeaders(200, 0);
            try (OutputStream os = request.getResponseBody()) {
            	os.write(output.getBytes());
            }
        });
        
        server.createContext("/file", request -> {
        	String fileName = request.getRequestURI().getPath().replaceAll("/file/", "");
        	System.out.println("Got new file-request: "+fileName);
        	Path path = Paths.get("client", fileName);
        	String output = null;
        	if (Files.exists(path)) {
        		byte[] bytes = Files.readAllBytes(path);
        		output = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        	} else {
        		output = "File "+path+" not found!";
        	}
        	
        	request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        	request.getResponseHeaders().set("Content-Type", "text/html");
            request.sendResponseHeaders(200, 0);
            try (OutputStream os = request.getResponseBody()) {
            	os.write(output.getBytes());
            }
        });
        System.out.println("ReversingServer is up. "+
        		"To reverse the string abc, go to http://127.0.0.1:"+port+"/reverse/abc");
        server.start();
    }
}
