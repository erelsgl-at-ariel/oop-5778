package adapter;

import java.util.Iterator;

/**
 * From slides created by Marty Stepp
 * based on materials by M. Ernst, S. Reges, D. Notkin, R. Mercer
 * http://www.cs.washington.edu/331/ 
 *
 * @author erelsgl
 */
public class IteratorIterableAdapter<T> implements Iterable<T> {
	private Iterator<T> it;
	IteratorIterableAdapter(Iterator<T> it) {
		this.it = it;
	}
	@Override public Iterator<T> iterator() {
		return this.it;
	}
}
