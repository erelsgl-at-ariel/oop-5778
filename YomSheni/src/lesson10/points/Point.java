package lesson10.points;

import java.io.Serializable;

/**
 * Point - a class with three versions 
 * @author erelsgl
 */
public class Point implements Serializable {

	double[] xy = new double[2];
	
	public Point(double x, double y) {
		this.xy[0] = x;
		this.xy[1] = y;
	}
	
	public String toString() {
		return "("+xy[0]+","+xy[1]+")";
	}
}
