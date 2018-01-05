package adapter;

import java.util.Iterator;

public class IteratorIterableAdapter<T> implements Iterable<T> {
	private Iterator<T> it;
	IteratorIterableAdapter(Iterator<T> it) {
		this.it = it;
	}
	@Override
	public Iterator<T> iterator() {
		return this.it;
	}
}
