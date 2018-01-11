package singleton;

public class ColorTest {
	public static void main(String[] args) {
		Color c = Color.BLUE;
		System.out.println(c);
		
		c = Color.valueOf("GREEN");
		System.out.println(c == Color.GREEN);
		
		Color.GREEN.paintSquare();
	}
}
