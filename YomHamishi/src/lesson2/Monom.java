/**
 * 
 */
package lesson2;

/**
 * Represents a function of the form a*x^b.
 * 
 * @author erelsgl
 *
 */
public class Monom implements Function {

	private double coefficient;
	private int power;

	public Monom(double coefficient, int power) {
		this.setCoefficient(coefficient);
		this.power = power;
	}

	@Override
	public String toString() {
		return (this.power==0? 
				this.getCoefficient() + "":
				this.getCoefficient() + "*x^" + this.power);
	}

	@Override
	public double apply(double x) {
		return this.getCoefficient() * Math.pow(x, power);
	}

	public Monom setToDerivative() {
		this.setCoefficient(this.getCoefficient() * this.power);
		this.power = this.power-1;
		if (this.power < 0) this.power = 0;
		return this;
	}

	public Monom getDerivative() {
		double newCoefficient = this.getCoefficient() * this.power;
		int newPower = this.power - 1;
		if (newPower < 0) newPower = 0;
		return new Monom(newCoefficient, newPower);
	}

	public Monom times(Monom m1) {
		return new Monom(this.getCoefficient()*m1.getCoefficient(), this.power+m1.power);
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if (power<0)
			throw new IllegalArgumentException("Power cannot be negative");
		this.power = power;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
}
