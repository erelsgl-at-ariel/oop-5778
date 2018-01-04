package yom2;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.*;

import com.sun.net.httpserver.HttpServer;

/**
 * A web-server that solves the Partition problem.
 * 
 * Uses an executor and a thread pool.
 * This is more efficient than using raw threads.
 *
 * @author erelsgl
 */
public class AuctionServer {
   	// Map each bid (in agorot) to the set of users with that bid.
	// Order the bids in decreasing order.
	private static Map<Integer, Set<String>> bids = new TreeMap<>(
   		(x,y) -> Integer.compare(y, x)
   	);
	
	private static String bidsToString() {
		StringBuilder outputBuilder = new StringBuilder();
		for (int b: bids.keySet())
			outputBuilder.append("<div>"+b+": "+bids.get(b)+"</div>");
		return outputBuilder.toString();
	}
	
    public static void main(String[] args) throws Exception {
    	int port = 8003;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    	ExecutorService executor = Executors.newCachedThreadPool();
        
        server.createContext("/bid", request -> {
        	// The input is a list of values separated by commas, e.g, "1,2,3".
        	Runnable runnable = () -> {
	        	String output = null;
	        	try {
	            	final String input = request.getRequestURI().getQuery();
	            	System.out.println("The input is: "+input);
	            	if (input.equals("getBids")) {   
		        		output = bidsToString();
	            	} else {
		        		String[] inputs = input.split(",");
		        		String name = inputs[0];
		        		int bid = Integer.valueOf(inputs[1]);
		        		
		        		synchronized(bids) {
			        		bids.putIfAbsent(bid, new LinkedHashSet<>());
			        		bids.get(bid).add(name);
			        		StringBuilder outputBuilder = new StringBuilder();
			        		for (int b: bids.keySet())
			        			outputBuilder.append("<div>"+b+": "+bids.get(b)+"</div>");
			        		output = bidsToString();
		        		}
	            	}
	        	} catch (Throwable ex) {
	        		output = "Sorry, an error occured: "+ex;
		        	System.out.println("  The output is: "+output);
	        	}
	        	
	        	try {
		        	request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
		        	request.getResponseHeaders().set("Content-Type", "text/plain");
		            request.sendResponseHeaders(200, 0);
		            try (OutputStream os = request.getResponseBody()) {
		            	os.write(output.getBytes(StandardCharsets.UTF_8));
		            }
	        	} catch (Exception ex) {
	        		System.out.println("Cannot send response to client");
	        		ex.printStackTrace();
	        	}
        	};
        	
        	executor.execute(runnable);
        });
        
        
        
        
        server.createContext("/file", request -> {
        	String fileName = request.getRequestURI().getPath().replaceAll("/file/", "");
        	System.out.println("Got new file-request: "+fileName);
        	Path path = Paths.get("client", "lesson7", fileName);
        	String output = null;
        	if (Files.exists(path)) {
        		output = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        	} else {
        		output = "File "+path+" not found!";
        	}
        	
        	request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        	request.getResponseHeaders().set("Content-Type", "text/html");
            request.sendResponseHeaders(200, 0);
            try (OutputStream os = request.getResponseBody()) {
            	os.write(output.getBytes(StandardCharsets.UTF_8));
            }
        });
        System.out.println(MethodHandles.lookup().lookupClass().getSimpleName()+" is up. "+
        		"Try http://127.0.0.1:"+port+"/bid?aaa,123 or http://127.0.0.1:"+port+"/file/auction.html");
        server.start();
    }
}
