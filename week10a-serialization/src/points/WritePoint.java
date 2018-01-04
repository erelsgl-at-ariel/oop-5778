package points;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Demonstrates serialization and de-serialization using ObjectInput/OutputStream,
 *    into a file, when the version of an object changes. 
 *
 * @author erelsgl
 */
public class WritePoint {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		System.out.println("writing a point");
		Point p1 = new Point(10,20);
		System.out.println(p1 instanceof Serializable);
		System.out.println(p1);

		OutputStream fos = Files.newOutputStream(Paths.get("point.bin"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p1);
    }
}
