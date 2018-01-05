package prototype;

public class PrototypeDemo {
	static void plotShapeFamily(Shape prototype, int fromSize, int toSize) {
		for (int size=fromSize; size<toSize; ++size) {
			Shape shape = prototype.clone();
			shape.setSize(size);
			shape.plot();
		}
	}
	
	public static void main(String[] args) {
		plotShapeFamily(new Square(5,"blue"), 10,20);
		plotShapeFamily(new Triangle(6,"green"), 10,20);
	}
}
