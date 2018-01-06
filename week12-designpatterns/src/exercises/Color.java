package exercises;

/**
 * Represents a color in Red-Green-Blue notation.
 * 
 * NOTE: Currently our application can handle only colors that are 
 *       shades of red, shades of green or shades of blue.
 *       
 * EXERCISE: refactor this class using the Factory pattern.
 */
public class Color {
	private int red, green, blue;
	
	public Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
}
