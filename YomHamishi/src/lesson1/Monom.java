/**
 * 
 */
package lesson1;

/**
 * Monom is a function of the form coefficient*x^power.
 *  
 * @author erelsgl
 * @since  2017-10
 */
public class Monom {
	public Monom(double coefficient2, int power2) {
		this.coefficient = coefficient2;
		this.power = power2;
	}
	
	@Override
	public String toString() {
		return (power==0?
				coefficient+"":
					(power==1 ?
					coefficient + "x" :
					coefficient + "x^" + power));
	}

	private double coefficient;
	private int power;
	
	/**
	 * Sets this object to its derivative.
	 */
	void setToDerivative() {	
		if (power==0) {
			this.coefficient = 0;
		} else {
			this.coefficient *= this.power;
			this.power -= 1;
		}
	}
	
	/**
	 * @return a monom that is the derivative of this monom.
	 */
	public Monom getDerivative() {
		if (power==0)
			return new Monom(0,0);
		else
			return new Monom(coefficient*power, power-1);
	}

	public double getValue(double i) {
		return this.coefficient * Math.pow(i, power);
	}
}
