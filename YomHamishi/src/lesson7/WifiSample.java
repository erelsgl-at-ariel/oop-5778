package lesson7;

public class WifiSample {
	private double x,y,z;
	
	public WifiSample(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override public String toString() {
		return "("+x+","+y+","+z+")";
	}

	double getY() { return y; }
}
