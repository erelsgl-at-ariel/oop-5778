package lesson6;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.invoke.MethodHandles;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.net.httpserver.HttpServer;

/**
 * A web-server that solves the Partition problem.
 * 
 * Version 0 - no threads. Might get stuck if a user tries to partition a large set.
 * 
 * @author erelsgl
 */
public class PartitionServer0 {
    public static void main(String[] args) throws Exception {
    	int port = 8003;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        server.createContext("/partition", request -> {
        	// The input is a list of values separated by commas, e.g, "1,2,3".
        	String output = null;
        	try {
            	String input = request.getRequestURI().getQuery();
            	System.out.println("The input is: "+input);
            	
            	List<Double> values = 
            		Arrays.stream(input.split(","))
            	      .map(s -> Double.valueOf(s))
            	      .collect(Collectors.toList());
            	
    			Instant start = Instant.now();
            	List<Double>[] bestPartition = Partition.best(values);
    			System.out.println("  Action took " + Duration.between(start, Instant.now()).toMillis() + "[ms]"); 
            	double sum0 = bestPartition[0].stream().mapToDouble(x->x).sum();
            	double sum1 = bestPartition[1].stream().mapToDouble(x->x).sum();
            	output = "<div>Set 0 = "+bestPartition[0] + ", sum="+sum0+"</div>" 
            	       + "<div>Set 1 = "+bestPartition[1] + ", sum="+sum1+"</div>";
        	} catch (Throwable ex) {
        		output = "Sorry, an error occured: "+ex;
        	}
        	System.out.println("  The output is: "+output);

        	request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        	request.getResponseHeaders().set("Content-Type", "text/plain");
            request.sendResponseHeaders(200, 0);
            try (PrintStream os = new PrintStream(request.getResponseBody())) {
            	os.println(output);
            }
        });
        
        server.createContext("/file", request -> {
        	String fileName = request.getRequestURI().getPath().replaceAll("/file/", "");
        	System.out.println("Got new file-request: "+fileName);
        	Path path = Paths.get("client", "lesson6", fileName);
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
        		"Try http://127.0.0.1:"+port+"/partition?1,2,3 or http://127.0.0.1:"+port+"/file/partition.html");
        server.start();
    }
}
