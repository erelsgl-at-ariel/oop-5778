package yom5;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.invoke.MethodHandles;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.*;

import com.sun.net.httpserver.HttpServer;

/**
 * A multi-threaded web-server for handling a multi-user auction.
 * 
 * NOT DONE YET
 */
public class AuctionServer {
	public static void main(String[] args) throws Exception {
		int port = 8004;
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
		ExecutorService executor = Executors.newCachedThreadPool();

		server.createContext("/bid", request -> {
			executor.execute ( () -> {
				String output = null;

				// Read the input and create the output:
				try {
					String input = request.getRequestURI().getQuery();
					System.out.println("The input is: "+input);
					output = "--- dummy output ---";
					System.out.println(output);
				} catch (Throwable ex) {
					output = "Sorry, an error occured: "+ex;
					System.out.println(output);
				}

				// Send the output to the client:
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
			});
		});




		server.createContext("/file", request -> {
			String output = null;

			try {
				String fileName = request.getRequestURI().getPath().replaceAll("/file/", "");
				System.out.println("Got new file-request: "+fileName);
				Path path = Paths.get("client", "lesson7", fileName);
				if (Files.exists(path)) {
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
						os.write(Files.readAllBytes(path));
					}
					return;
				} else {
					output = "File "+path+" not found!";
				}
			} catch (Throwable ex) {
				output = "Sorry, an error occured: "+ex;
			}
			System.out.println(output);
			request.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
			request.getResponseHeaders().set("Content-Type", "text/plain");
			request.sendResponseHeaders(200, 0);
			try (OutputStream os = request.getResponseBody()) {
				os.write(output.getBytes(StandardCharsets.UTF_8));
			} catch (Exception ex) {
				System.out.println("Cannot send response to client");
				ex.printStackTrace();
			}
		});


		System.out.println(MethodHandles.lookup().lookupClass().getSimpleName()+" is up. "+
				"Try http://127.0.0.1:"+port+"/bid?name,50 or http://127.0.0.1:"+port+"/file/auction.html");
		server.start();
	}
}
