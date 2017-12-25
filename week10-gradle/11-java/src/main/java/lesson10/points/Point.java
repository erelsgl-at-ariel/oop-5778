package lesson10.points;

import java.io.Serializable;

/**
 * Point - a class with three versions 
 * @author erelsgl
 */
 
public class Point implements Serializable {
	private static final long serialVersionUID = 2L;

	double[] xy = new double[2];
	
	public Point(double x, double y) {
		this.xy[0] = x;
		this.xy[1] = y;
	}
	
	public String toString() {
		return "("+(int)xy[0]+","+(int)xy[1]+")";
	}
}
