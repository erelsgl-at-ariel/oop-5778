package lesson5;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
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
        server.createContext("/reverse", new ReversingHandler());
        System.out.println("ReversingServer is up. "+
        		"To reverse the string abc, go to http://127.0.0.1:"+port+"/reverse?abc");
        server.start();
    }
}


class ReversingHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange request) throws IOException {
    	String input = request.getRequestURI().getQuery();
    	System.out.println("Got new input: "+input);
    	String output = (input==null? 
    			null: 
    			new StringBuilder(input).reverse().toString()); 
    	System.out.println("   The output is: "+output);
    	
    	request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
    	request.getResponseHeaders().set("Content-Type", "text/plain");
        request.sendResponseHeaders(200, 0);
        OutputStream os = request.getResponseBody();
        os.write(output.getBytes());
        os.close();
    }
}
