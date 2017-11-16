package lesson5;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

import com.sun.net.httpserver.HttpServer;

/**
 * A web-server that reverses strings. Uses com.sun.net.httpserver package.
 * @author erelsgl
 * @see https://stackoverflow.com/a/3732328/827927
 */
public class PlottingServer {
    public static void main(String[] args) throws Exception {
    	int port = 8002;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/polynom/", request -> {
        	String input = request.getRequestURI().getPath().replaceAll("/polynom/", "");
        	List<Double> coefficients =
        			Arrays.stream(input.split("/"))
	        	        .map(s -> Double.valueOf(s))
	        	        .collect(Collectors.toList());         	
        	System.out.println("   The coefficients are: "+coefficients);
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
        		output = new String(Files.readAllBytes(path));
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
        System.out.println("PolynomServer is up. "+
        		"To calculate the values for a + b x + c x^2, go to http://127.0.0.1:"+port+"/polynom/a/b/c");
        server.start();
    }
}
