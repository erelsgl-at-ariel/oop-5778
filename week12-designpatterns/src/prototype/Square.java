package prototype;

public class Square implements Shape {
	private int size;
	private String color;
	
	public Square(int size, String color) {
		this.size = size;
		this.color = color;
	}
	
	@Override public void plot() {
		System.out.println("plot a "+color+" square of size "+size);
	}

	@Override public Shape clone() {
		return new Square(size, color);
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}
}
