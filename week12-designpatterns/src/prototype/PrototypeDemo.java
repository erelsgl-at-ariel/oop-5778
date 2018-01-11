package prototype;

import java.util.ArrayList;

public class PrototypeDemo {
	static void plotShapeFamily(Shape prototype, int fromSize, int toSize) {
		for (int size=fromSize; size<toSize; ++size) {
			Shape shape = prototype.clone();
			shape.setSize(size);
			shape.plot();
		}
	}
	
	static void simpleTest() {
		Shape s = new Square(5,"blue");
		plotShapeFamily(s, 10,20);
		plotShapeFamily(new Triangle(6,"green"), 10,20);
		s.plot();
	}
	
	static void complexTest() {
		SquareList prototype = new SquareList(new ArrayList<Square>());
		prototype.addSquare(new Square(5,"green"));
		prototype.plot();
		System.out.println();
		
		SquareList c = (SquareList)prototype.clone();
		c.addSquare(new Square(10,"green"));
		c.getSquares().get(0).setSize(100);
		c.plot();
		System.out.println();
		
		prototype.plot();
		System.out.println();
	}
	
	public static void main(String[] args) {
		complexTest();
	}
}
