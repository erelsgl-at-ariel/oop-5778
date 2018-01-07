/**
 * 
 */
package yom2;

import java.util.Arrays;

/**
 * A monom is a function of the form coefficient*x^power.
 * 
 * @author erelsgl
 */
public class Monom {
	public Monom(double coefficient2, int power2) {
		this.coefficient = coefficient2;
		this.power = power2;
	}
	
	@Override
	public String toString() {
		if (power==1)
			return coefficient + "x";
		else if (power==0)
			return coefficient + "";
		else
			return coefficient + "x^" + power;
	}
	
	public int getDegree() {
		return this.power;
	}
	
	

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if (power < 0) {
			RuntimeException ex = 
				new RuntimeException("power cannot be negative");
			throw ex;
		}
		this.power = power;
	}



	private double coefficient;
	private int power;
	
	public Monom getDerivative() {
		if (this.power==0) {
			return new Monom(0,0);
		} else {
			double newCoefficient = this.coefficient*this.power;
			int newPower = this.power - 1;
			return new Monom(newCoefficient,newPower);
		}
	}

	public void plot(double fromX, double toX, int numXValues) {
		double[] xValues = new double[numXValues];
		double[] yValues = new double[numXValues];
		double deltaX = (toX-fromX)/numXValues;
		int i=0;
		for (double x=fromX; x<toX; x+=deltaX) {
			xValues[i] = x;
			yValues[i] = this.valueAt(x);
			i++;
		}
		System.out.println(Arrays.toString(yValues));
	}
	
	/**
	 * @param  x
	 * @return the value of this monom at point x.
	 */
	public double valueAt(double x) {
		return this.coefficient*Math.pow(x, this.power);		
	}
}
