package lesson2;

import java.io.IOException;
import java.io.PrintWriter;
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
	
	static void readFile(Path theFile) {
		try {
			Files.lines(theFile).forEach(
				line -> System.out.println(line)
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void writeFile(Path theFile) {
		try {
			PrintWriter writer = new PrintWriter(Files.newBufferedWriter(theFile));
			writer.println("Hello world");
			writer.close();
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
		readFile(file);
		
		Path outputFile = Paths.get("/home/erelsgl/Dropbox/ariel/OOP-JAVA/code/test.txt");
		writeFile(outputFile);
		
		// Relative path is relative to the project. 
		// It is better than absolute path.
		Path outputFile2 = Paths.get("test.kml"); 
		writeFileKML(outputFile2);
	}
}
