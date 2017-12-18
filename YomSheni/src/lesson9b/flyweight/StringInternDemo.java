package lesson9b.flyweight;

import java.io.*;

/**
 * Demonstrates the flyweight pattern in Java strings.
 * @author erelsgl
 */
public class StringInternDemo {
	
	public static void main(String[] args) throws IOException {
		String a = "xyz";

		String b = "xyz";
		System.out.println("a.equals(b): "+a.equals(b));
		System.out.println("a==b: "+(a==b));

		b = "x" + "y" + "z";
		System.out.println("a.equals(b): "+a.equals(b));
		System.out.println("a==b: "+(a==b));
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		b = br.readLine();
		System.out.println("a.equals(b): "+a.equals(b));
		System.out.println("a==b: "+(a==b));
		System.out.println("a.equals(b.intern()): "+a.equals(b.intern()));
	}
}
