package prototype;

public class Triangle implements Shape {
	private int size;
	private String color;
	
	public Triangle(int size, String color) {
		this.size = size;
		this.color = color;
	}
	
	@Override public void plot() {
		System.out.println("plot a "+color+" triangle of size "+size);
	}

	@Override public Shape clone() {
		return new Triangle(size, color);
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}
}
