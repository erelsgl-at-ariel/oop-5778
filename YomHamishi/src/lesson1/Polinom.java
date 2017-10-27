/**
 * 
 */
package lesson1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a function of the form coefficient1*x^power1  + coefficient2*x^power2 + ...
 * @author erelsgl
 * 
 * TODO: Order the monoms by their power.
 */
public class Polinom {
	List<Monom> monoms;
	
	public Polinom() {
		monoms = new ArrayList<Monom>();
	}

	public void AddMonom(Monom monom) {
		monoms.add(monom);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(); 
		for (Monom monom: this.monoms) {
			// TODO: don't add + at start of string.
			result.append(" + ");
			result.append(monom);
		}
		return result.toString();
	}
	
}
