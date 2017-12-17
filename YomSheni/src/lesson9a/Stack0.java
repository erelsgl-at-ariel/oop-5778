package lesson9a;

import java.util.ArrayList;

/**
 * A WRONG way to define a stack.
 * It is wrong to use inheritance here, 
 * since a stack is NOT an arraylist.
 * For a better way, see Stack1.
 *
 * @author erelsgl
 *
 * @param <T>
 */
public class Stack0<T> extends ArrayList<T> {
	public void push (T item) {
		add(item);
	}
	
	public T pop() {
		return remove(size()-1);
	}
}
