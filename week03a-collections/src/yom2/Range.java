package yom2;

import java.util.Collection;
import java.util.Iterator;

/**
 * Represents the set of integers between two given integers.
 * @author erelsgl
 *
 */
public class Range implements Collection<Integer> {
	
	private int from;
	private int to;

	public Range(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public boolean add(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object item) {
		if (item instanceof Integer) {
			int itemInt = (int)item;
			return itemInt >= this.from && itemInt<=this.to;
		} else {
			return false;
		}
	}

	@Override
	public boolean containsAll(Collection<?> coll) {
		for (Object item: coll) {
			if (!this.contains(item))
				return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.to < this.from;
	}

	@Override
	public Iterator<Integer> iterator() {
		int from = this.from;
		int to   = this.to;
		return new Iterator<Integer>() {
			int current = from;
			@Override public boolean hasNext() {
				return current <= to; 
			}
			@Override public Integer next() {
				return current++;
			}
		};
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return this.to-this.from+1;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
