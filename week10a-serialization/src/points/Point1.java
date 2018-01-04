package points;

import java.io.Serializable;

/**
 * Point - first version
 * @author erelsgl
 *
 */
public class Point1 implements Serializable {
	private static final long serialVersionUID = 1L;
	double x, y;
	
	public Point1(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
}
