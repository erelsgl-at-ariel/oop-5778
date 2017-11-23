
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (suumed a none nagetive), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements funcation and support simple oparations as: constaruction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements cont_function{
	
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	/**
	 * This constructor init a Monom from a String representation (as if it was created by the to String
	 * @param s
	 */
	public Monom(String s) {
		Monom th = init_from_string(s);
		this.set_coefficient(th.get_coefficient());
		this.set_power(th.get_power());
	}
	private static Monom init_from_string(String s) {
		if(s==null) {throw new RuntimeException("Wrong parameter for the Monom Constractor - should not be NULL!!!");}
		double  coef = 1;
		int pow = 0;
		Monom ans = null;
		if(s.contains("x")) {
			int ind = s.indexOf("x");
			String co = s.substring(0, ind);
			
			try{
				double c = Double.parseDouble(co);
				coef = c;
			}
			catch(Exception e) {coef = 1;}
			if(s.length()>ind+2) {
				String po = s.substring(ind+2);
				try{
					int p = Integer.parseInt(po);
					pow = p;
				}
				catch(Exception e) {pow = 0;}
			}
		}
		else {  // just number ==> power = 0;
			coef = Double.parseDouble(s);
		}
		
		ans = new Monom(coef, pow);	
		return ans;
	}
	
	public int get_power() {return this._power;}
	public double get_coefficient() {return _coefficient;}
	
	public String toString() {
		return ""+this.get_coefficient()+"x^"+this.get_power();
	}
	/**
	 * This method computes this Monom value in x.
	 */
	public double f(double x) {
		double a = get_coefficient();
		int b = get_power();
		double ans = a*Math.pow(x, b);
		return ans;
	}
	/** This method test if this Monom is none zero and haz a none negerive power **/
	public boolean is_valid() {
		boolean ans = true;
		if(this.get_power()<0) {
			ans = false;
		}
		if(this.get_coefficient()==0) {
			ans = false;
		}
		 return ans;
	}
	public Monom derivative() {
		double a = this.get_coefficient()*this.get_power();
		int b = this.get_power() - 1;
		return new Monom(a,b);
	}
	public void add(Monom m) {
		if(m.get_power()!=this.get_power()) {
			throw new RuntimeException("Error: can not add two monoms with different coefficients");
		}
		this.set_coefficient(m.get_coefficient() + this.get_coefficient());
	}
	
	public void multiply(Monom m) {
		this.set_coefficient(this.get_coefficient() * m.get_coefficient());
		this.set_power(this.get_power() + m.get_power());
	}
	public boolean equals(Monom m) {
		boolean ans = false;
		if(m!=null) {
			if(this.get_coefficient() == m.get_coefficient() && this.get_power() == m.get_power()) {
				ans = true;
			}
		}
		return ans;
	}

	//****************** Private Methods and Data *****************
	
	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		this._power = p;
	}
	
	private double _coefficient; // 
	private int _power;
}
