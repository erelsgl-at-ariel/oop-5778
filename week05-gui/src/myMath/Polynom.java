package myMath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riman Integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements cont_function{

	/** return an empty (zero) polynom */
	public Polynom() {
		_polynom  = new  ArrayList<Monom>();
	}
	/** deep copy */
	public Polynom(Polynom p1) {
		this();
		Iterator<Monom> iter = p1.iteretor();
		while(iter.hasNext()) {
			Monom m = iter.next();
			this.add(new Monom(m));
		}
	}
	public Polynom(String s) {
		this();
		Polynom th = init_from_string(s);
		Iterator<Monom> iter = th.iteretor();
		while(iter.hasNext()) {
			this.add(iter.next());
		}
	}
	private static Polynom init_from_string(String s) {
		if(s==null) {throw new RuntimeException("Wrong parameter for the Monom Constractor - should not be NULL!!!");}
		String[] params = s.split(" ");
		Polynom ans = new Polynom();
		for(int i=0;i<params.length;i++) {
			String t = params[i];
			if(!t.contains("+") || t.length()>1) {
				Monom c = new Monom(t);
				ans.add(c);
			}
		}
		return ans;
	}
	public void add(Monom m1) {
		boolean found_power = false;
		Iterator<Monom> iter = this.iteretor();
		while(!found_power && iter.hasNext()) {
			Monom m = iter.next();
			if(m.get_power()==m1.get_power()) { // same power
				m.add(m1);
				found_power = true;
				if(!m.is_valid()) { // 	if(m.get_coefficient()==0)
					iter.remove();
				}
			}
		}
		if(!found_power) {
			_polynom.add(m1);
			this._polynom.sort(COMP);
		}
	}
	private void add_tricky(Monom m) {
		boolean found = false;
		for (Monom monom : this._polynom) {
			if (m.get_power() == monom.get_power()) {
				monom.add(m);
				found = true;
				break;
			}
		}
		if (!found) {
			this._polynom.add(m);
			this._polynom.sort(COMP);
		}
		Predicate<Monom> monomIsZero = a -> a.get_coefficient()==0.0;
		this._polynom.removeIf(monomIsZero);	
	}
	
	public void add(Polynom p1) {
		Iterator<Monom> iter = p1.iteretor();
		while(iter.hasNext()) {
			Monom m = iter.next();
			this.add(m);
		}
	}
	
	public void multiply(Monom m1) {
		if(m1.get_coefficient()==0) {
			this._polynom.clear();
		}
		else {
			Iterator<Monom> iter = this.iteretor();
			while(iter.hasNext()) {
				Monom m = iter.next();
				m.multiply(m1);
			}
		}
	}
	public static Polynom multiply(Polynom p0, Polynom p1) {
		Polynom ans = new Polynom();
		if(!p0.isZero() && !p1.isZero()) {
			Iterator<Monom> iter = p0.iteretor();
			while(iter.hasNext()) {
				Monom m = iter.next();
				Polynom p2 = new Polynom(p1);
				p2.multiply(m);
				ans.add(p2);
			}
		}
		return ans;
	}
	public void multiply(Polynom p1) {
		Polynom p2 = Polynom.multiply(this, p1);
		this._polynom = p2._polynom;
	}
	public int size() {
		return this._polynom.size();
	}
	/** Assumes both polynoms are sorted and have no duplications */
	public boolean equals (Polynom p1) {
		boolean ans = false;
		if(this.size() == p1.size()) {
			ans = true;
			Iterator<Monom> iter0 = this.iteretor();
			Iterator<Monom> iter1 = p1.iteretor();
			while(ans && iter0.hasNext()) {
				Monom m0 = iter0.next();
				Monom m1 = iter1.next();
				if(!m0.equals(m1)) {
					ans = false;
				}
			}
		}
		return ans;
	}
	public String toString() {
		String ans = "";
		if(this.isZero()) {
			return "0";
		}
		Iterator<Monom> iter = this.iteretor();
		while(iter.hasNext()) {
			Monom m0 = iter.next();
			ans += m0 +" + ";
		}
		return ans;
	}
	/**
	 * Return true iff this is an empty polygon ==> zero for any value;
	 * @return
	 */
	public boolean isZero() {
		boolean ans = false;
		if(this._polynom.size() ==0) {
			ans = true;
		}
		return ans;
	}

/**
 * This function computes the value of this polynom at f(x), as a sum of monoms.
 */
	public double f(double x) {
		double ans = 0;
		Iterator<Monom> iter = this.iteretor();
		while(iter.hasNext()) {
			Monom m = iter.next();
			ans += m.f(x);
		}
		return ans;
	}
	public Iterator<Monom> iteretor(){
		return this._polynom.iterator();
	}
	
	public double root(double x0, double x1, double eps, boolean debug) {
		double y0 = this.f(x0);
		double y1 = this.f(x1);
		
		if(y0*y1>0) {
			throw new RuntimeException("Error: f(x0) and f(x1) should be on oposite sides of the X asix");
		}
		
		double delta_x = Math.abs(x0-x1);
		double delta_y = Math.abs(y0-y1);
		if(debug) {
			System.out.println("f("+x0+") = "+y0+"    f("+x1+") = "+y1+"   dx = "+delta_x);
		}
		if (delta_x>eps || delta_y>eps) {
			double x_mid = (x0+x1)/2;
			double y_mid = this.f(x_mid);
			double dir = y0*y_mid;
			if(dir<0) {
				return root(x0,x_mid, eps, debug);
			}
			else {
				return root(x_mid, x1, eps, debug);
			}
		}
		return x0;
	}
	
	// ************** Private *******************
	private ArrayList<Monom> _polynom;
	private static final Monom_Comperator COMP = new Monom_Comperator();
}
