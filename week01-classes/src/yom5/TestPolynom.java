package yom5;

/**
 * A main program for testing the Polynom class.
 * 
 * @author Moshe 
 */
public class TestPolynom {

	/**
	 * @param args
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polinom function = new Polinom();
		
		//Insertion into function 
		
		function.AddMonom(new Monom(10,4));
		function.AddMonom(new Monom(1,7));
		function.AddMonom(new Monom(4,1));
		
		System.out.println(function.toString()); // x^7 + 10x^4 + 4X
		
		//Value in one point
		
		//function.getValue(2); // 296
		
		//Derivative
		
		//function.GetDerivative(); // 7x^6 + 40x^3 + 4
		
		//Addition
		
		//function.AddFunction(new Polinom());
		
		
		
		
	}



}
