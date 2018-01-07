package yom2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class TestFiles {
	
	static void readFolder(Path folder) {
		try {
			Files.newDirectoryStream(folder).forEach(
				file -> System.out.println(file)
			);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * An example of reading a file using Stream<String>
	 * @param theFile
	 * @throws IOException 
	 */
	static void readFile(Path theFile) throws IOException {
		// Wrong solution - might not close the file in case of exception.
		Stream<String> lines = Files.lines(theFile);
		lines.forEach(
				line -> System.out.println(line)
		);
		lines.close(); 
		
		// Correct solution - always closes the file
		try (Stream<String> lines2 = Files.lines(theFile)) {
			lines2.forEach(
				line -> System.out.println(line)
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * An example of reading a file using BufferedReader
	 * @param theFile
	 */
	static void readFile2(Path theFile) {
		try (BufferedReader reader = Files.newBufferedReader(theFile)) {
			for (;;) {
				String line = reader.readLine();
				if (line==null) break;
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void writeFile(Path theFile) {
		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(theFile))) {
			writer.println("Hello world");
			// writer.close(); // NOT NEEDED - done automatically by "try"
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	static void writeFileKML(Path theFile) {
		try {
			PrintWriter writer = new PrintWriter(Files.newBufferedWriter(theFile));
			writer.println("<kml>Hello world</kml>");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args) {
		Path folder = Paths.get("/home/erelsgl/Dropbox/ariel/OOP-JAVA/code/wigle/28.10");
		readFolder(folder);

		Path file = Paths.get("/home/erelsgl/Dropbox/ariel/OOP-JAVA/code/wigle/28.10/WigleWifi_20171029092312.csv");
		
		try {
			readFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path outputFile = Paths.get("/home/erelsgl/Dropbox/ariel/OOP-JAVA/code/test.txt");
		writeFile(outputFile);
		
		// Relative path is relative to the project. 
		// It is better than absolute path.
		Path outputFile2 = Paths.get("test.kml"); 
		writeFileKML(outputFile2);
	}
}
