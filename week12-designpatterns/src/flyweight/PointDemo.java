package flyweight;

/**
 * Demonstrates the difference between a class with or without flyweight.
 * 
 * @author erelsgl
 */
public class PointDemo {
	public static void main(String[] args) {
		System.out.println(new Point0(1,2) == new Point0(1,2));
		System.out.println(Point1.get(1,2) == Point1.get(1,2));
	}
}
