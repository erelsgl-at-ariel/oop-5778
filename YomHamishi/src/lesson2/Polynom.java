/**
 * 
 */
package lesson2;

import java.util.*;
import java.util.function.Predicate;

/**
 * Implements a function of the form a1*x^b1 + a2*x^b2 ... 
 * Contains a collection of objects of type Monom.
 * 
 * @author erelsgl
 *
 */
public class Polynom {
	
	private static final Comparator<Monom> MONOM_COMPARATOR = 
			(m1,m2) -> Integer.compare(m2.getPower(), m1.getPower());
	
	private Collection<Monom> monoms = new TreeSet<>(MONOM_COMPARATOR);

	@Override
	public String toString() {
		if (monoms.size()==0)
			return "0.0";

		StringBuffer ans = new StringBuffer();
		for (Monom monom : monoms) {
			if (ans.length()>0)
				ans.append(" + ");
			ans.append(monom);
		}
		return ans.toString();
	}

	public void add(Monom toAdd) {
		boolean found = false;
		for (Monom monom : monoms) {
			if (toAdd.getPower() == monom.getPower()) {
				monom.setCoefficient(monom.getCoefficient() + toAdd.getCoefficient());
				found = true;
				break;
			}
		}
		
		Predicate<Monom> monomIsZero = m -> m.getCoefficient()==0.0;
		monoms.removeIf(monomIsZero);
		if (!found)
			monoms.add(toAdd);
	}

	public Polynom plus(Polynom p2) {
		Polynom ans = new Polynom();
		for (Monom m: this.monoms)
			ans.add(m);
		for (Monom m: p2.monoms)
			ans.add(m);
		return ans;
	}

	public Polynom times(Monom toMult) {
		Polynom ans = new Polynom();
		for (Monom m: this.monoms)
			ans.add(m.times(toMult));
		return ans;
	}

	public Polynom times(Polynom toMult) {
		Polynom ans = new Polynom();
		for (Monom m: toMult.monoms)
			ans = ans.plus(this.times(m));
		return ans;
	}
}
