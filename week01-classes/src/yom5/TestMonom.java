package yom5;

/**
 * A main program for testing the Monom class.
 * @author erelsgl
 */
public class TestMonom {
	public static void main (String[] args) {
		System.out.println("Start test Monom");
		
		try {
			Monom m = new Monom(10,5);
			System.out.println(m);
			m = new Monom(10,-5);
			System.out.println(m);
			m = new Monom(10,3);
			System.out.println(m);
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
		
//		double coefficient = 5;
//		int power = 3;
//		Monom m = new Monom(coefficient, power);
//		System.out.println(m);   // should print 5x^3
//		testDerivative();		
//		double value = m.getValue(2);  // 40
//		System.out.println(value);
//		
		System.out.println("End test Monom");
	}
	
	static void testDerivative() {
		double coefficient = 5;
		int power = 3;
		Monom m = new Monom(coefficient, power);
		Monom mDerivative = m.getDerivative();
		System.out.println(mDerivative); // 15x^2
		System.out.println(mDerivative.getDerivative()); // 30x
		System.out.println(mDerivative.getDerivative().getDerivative()); // 30
		System.out.println(mDerivative.getDerivative().getDerivative().getDerivative()); // 0
	}
}
