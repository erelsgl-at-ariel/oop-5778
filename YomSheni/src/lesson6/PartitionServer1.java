package lesson6;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
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
public class PartitionServer1 {
    public static void main(String[] args) throws Exception {
    	int port = 8003;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        server.createContext("/partition", request -> {
        	// The input is a list of values separated by commas, e.g, "1,2,3".
        	final String input = request.getRequestURI().getQuery();
        	System.out.println("The input is: "+input);
        	
        	Runnable task = () -> {
	        	String output = null;
	        	try {
	            	List<Double> values = 
	            		Arrays.stream(input.split(","))
	            	      .map(s -> Double.valueOf(s))
	            	      .collect(Collectors.toList());
	    			Instant start = Instant.now();
	            	List<Double>[] bestPartition = Partition.best(values);
	    			System.out.println("    Action took " + Duration.between(start, Instant.now()).toMillis() + "[ms]"); 
	            	double sum0 = bestPartition[0].stream().mapToDouble(x->x).sum();
	            	double sum1 = bestPartition[1].stream().mapToDouble(x->x).sum();
		        	System.out.println("    The sums are: "+sum0+" and "+sum1);
	            	output = "<div>Set 0 = "+bestPartition[0] + ", sum="+sum0+"</div>" 
	            	       + "<div>Set 1 = "+bestPartition[1] + ", sum="+sum1+"</div>";
	        	} catch (Throwable ex) {
	        		output = "Sorry, an error occured: "+ex;
		        	System.out.println("    The output is: "+output);
	        	}
	        	System.out.println("  Thread "+Thread.currentThread().getId()+" is done");
	        	
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
        	
        	Thread worker = new Thread(task);
        	worker.start();
        	System.out.println("  Thread "+worker.getId()+" starts working");
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
        System.out.println("PartitionServer is up. "+
        		"Try http://127.0.0.1:"+port+"/partition?1,2,3 or http://127.0.0.1:"+port+"/file/partition.html");
        server.start();
    }
}
