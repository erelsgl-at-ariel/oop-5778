package yom5;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import com.sun.net.httpserver.HttpServer;

import myMath.Polynom;

/**
 * A web-server that reverses strings. Uses com.sun.net.httpserver package.
 * @author erelsgl
 * @see https://stackoverflow.com/a/3732328/827927
 */
public class PolynomServer {
    public static void main(String[] args) throws Exception {
    	int port = 8002;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/points", request -> {
        	try {
	        	String[] inputs = request.getRequestURI().getQuery().split(",");
	        	System.out.println(inputs.length+" inputs: "+Arrays.toString(inputs));
	        	Polynom polynom = new Polynom(inputs[0]);
	        	double xFrom = Double.valueOf(inputs[1]);
	        	double xTo = Double.valueOf(inputs[2]);
	        	
	        	System.out.println("Plotting the polynom "+polynom+" from "+xFrom+" to "+xTo);
	        	double delta = (xTo-xFrom)/100;
	        	StringBuilder output = new StringBuilder();
	        	for (double x=xFrom; x<=xTo; x+=delta) {
	        		double y = polynom.f(x);
	        		if (output.length()>0)
	        			output.append(",\n");
	        		output.append("{\"x\": "+x+", \"y\": "+y+"}");
	        	}
	        	String outputString = "[\n"+output.toString()+"\n]";
	        	System.out.println("   The output is: "+outputString);
	        	
	        	request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
	        	request.getResponseHeaders().set("Content-Type", "text/plain");
	            request.sendResponseHeaders(200, 0);
	            try (PrintStream os = new PrintStream(request.getResponseBody())) {
	            	os.println(outputString);
	            }
        	} catch (Throwable ex) {
        		ex.printStackTrace();
	        	request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
	        	request.getResponseHeaders().set("Content-Type", "text/plain");
	            request.sendResponseHeaders(500, 0);
	            try (PrintStream os = new PrintStream(request.getResponseBody())) {
	            	os.println("There was an exception: "+ ex);
	            }
        		
        	}
        });
        
        server.createContext("/file", request -> {
        	String fileName = request.getRequestURI().getPath().replaceAll("/file/", "");
        	System.out.println("Got new file-request: "+fileName);
        	Path path = Paths.get("client", "lesson5", fileName);
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
        		"To calculate 100 points for 2x+1 between 0 and 10, go to http://127.0.0.1:"+port+"/points?2x+1,0,10");
        server.start();
    }
}
