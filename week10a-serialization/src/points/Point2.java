package points;

import java.io.Serializable;

/**
 * Point - version 2 - a major change from version 1
 * @author erelsgl
 */
public class Point2 implements Serializable {
	//private static final long serialVersionUID = 2L;
	double[] xy = new double[2];
	
	public Point2(double x, double y) {
		this.xy[0] = x;
		this.xy[1] = y;
	}
	
	public String toString() {
		return "("+xy[0]+","+xy[1]+")";
	}
}
