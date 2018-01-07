package lesson10.points;

import java.io.*;
import java.nio.file.*;
import java.util.*;


/**
 * Demonstrates serialization and de-serialization using ObjectInput/OutputStream,
 *    into a file, when the version of an object changes. 
 *
 * @author erelsgl
 */
public class ReadPoint {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		System.out.println("reading a point");
		InputStream fis = Files.newInputStream(Paths.get("point.bin"));
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object p = ois.readObject();
		System.out.println(p.getClass().getName());
		System.out.println(p);
    }
}
