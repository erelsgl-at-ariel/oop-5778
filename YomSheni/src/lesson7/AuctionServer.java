package lesson7;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.net.InetSocketAddress;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.*;

import com.sun.net.httpserver.HttpServer;

/**
 * A web-server that solves the Partition problem.
 * 
 * Version 2 - uses an executor and a thread pool.
 * This is more efficient than using raw threads.
 *
 * @author erelsgl
 */
public class AuctionServer {
    public static void main(String[] args) throws Exception {
    	int port = 8003;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    	ExecutorService executor = Executors.newCachedThreadPool();
    	
    	// Map each bid (in agorot) to the set of users with that bid.
    	// Order the bids in decreasing order.
    	Map<Integer, Set<String>> bids;
    	//bids = new ConcurrentSkipListMap<>(
    	bids = new TreeMap<>(
    		(x,y) -> y-x  
    	);
    	//Map<Integer, Set<String>> bids = new TreeMap<>();
        
        server.createContext("/bid", request -> {
        	// The input is a list of values separated by commas, e.g, "1,2,3".
        	Runnable runnable = () -> {
	        	String output = null;
	        	try {
	            	final String input = request.getRequestURI().getQuery();
	            	System.out.println("The input is: "+input);
	        		String[] inputs = input.split(",");
	        		String name = inputs[0];
	        		int bid = Integer.valueOf(inputs[1]);
	        		
	        		synchronized(bids) {
		        		bids.putIfAbsent(bid, new ConcurrentSkipListSet<>()); // ATOMIC
		        		bids.get(bid).add(name);
		        		StringBuilder outputBuilder = new StringBuilder();
		        		for (int b: bids.keySet())
		        			outputBuilder.append("<div>"+b+": "+bids.get(b)+"</div>");
		        		output = outputBuilder.toString();
	        		}
	        	} catch (Throwable ex) {
	        		output = "Sorry, an error occured: "+ex;
		        	System.out.println("  The output is: "+output);
	        	}
	        	
	        	try {
		        	request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
		        	request.getResponseHeaders().set("Content-Type", "text/plain");
		            request.sendResponseHeaders(200, 0);
		            try (PrintStream os = new PrintStream(request.getResponseBody())) {
		            	os.println(output);
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
        System.out.println(MethodHandles.lookup().lookupClass().getSimpleName()+" is up. "+
        		"Try http://127.0.0.1:"+port+"/bid?aaa,123 or http://127.0.0.1:"+port+"/file/auction.html");
        server.start();
    }
}
