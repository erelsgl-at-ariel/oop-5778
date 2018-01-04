package points;

import java.io.Serializable;

/**
 * Point - version 1b - only a minor change over version 1
 * @author erelsgl
 *
 */
public class Point1b implements Serializable {
	//private static final long serialVersionUID = 1L;
	double x, y;
	
	public Point1b(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
	
	public double getX() { return x; }
}
