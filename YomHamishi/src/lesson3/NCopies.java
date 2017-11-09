package lesson3;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NCopies<T> implements Collection<T> {
	private T object;
	private int n;
	
	public NCopies(int n, T theObject) {
		this.n = n;
		this.object = theObject;
	}
	
	@Override
	public boolean add(T arg0) {
		throw new UnsupportedOperationException();
	}

	@Override public boolean addAll(Collection<? extends T> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override public boolean contains(Object arg0) {
		return object.equals(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		for (Object item: arg0) {
			if (!object.equals(item))
				return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		int n = this.n;
		T object = this.object;
		return new Iterator<T>() {
			int i = 0;
			@Override public boolean hasNext() {
				return i < n;
			}
			@Override public T next() {
				if (i < n) {
					i++;
					return object;
				} else {
					throw new NoSuchElementException();
				}
			}
		};
	}

	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		return this.n;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[this.n];
		for (int i=0; i<n; ++i)
			result[i] = this.object;
		return result;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
