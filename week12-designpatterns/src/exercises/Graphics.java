package exercises;

import java.util.*;

/**
 * A program for plotting some graphics objects.
 * 
 * NOTE: The program works, but it can handle 
 *       only flat lists of squares.
 *       We would like it to handle recursive sets,
 *       e.g, lists of lists of squares.
 *       
 * EXERCISE: Refactor it using the Composite pattern.
 * 
 * @author erelsgl
 */
public class Graphics {
	public static void main(String[] args) {
		Picture p = new Picture();
		p.addSquare(new Square(5,"blue"));
		p.addSquare(new Square(6,"green"));
		p.paint();
	}
}

class Picture {
	private List<Square> squares = new ArrayList<Square>();
	public void addSquare(Square s) {
		squares.add(s);
	}
	public void paint() {
		for (Square s: squares) {
			s.paint();
		}
	}
}

class Square {
	int size;
	String color;
	public Square(int size, String color) {
		this.size = size;
		this.color = color;
	}
	public void paint() {	
		/// code to paint a square
	}
}
