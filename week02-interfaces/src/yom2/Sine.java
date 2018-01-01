package yom2;

/**
 * Represents the function y = sin(x)
 * @author erelsgl
 */
public class Sine implements Function {

	@Override
	public double apply(double x) {
		return Math.sin(x);
	}

}
