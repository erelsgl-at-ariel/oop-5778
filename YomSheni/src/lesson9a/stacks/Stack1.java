package lesson9a.stacks;


import java.util.*;

/**
 * A better way to define a stack - using composition instead of inheritance.
 * @author erelsgl
 *
 * @param <T>
 */
public class Stack1<T> {
	private List<T> list = new ArrayList<>();
	
	public void push (T item) {
		list.add(item);
	}
	
	public T pop() {
		return list.remove(list.size()-1);
	}
	
	@Override public String toString() {
		return "Stack: "+list.toString();
	}
}
