package lesson9.logging;

import java.util.*;

/**
 * @author erelsgl
 * @param <T>
 */
@SuppressWarnings("serial")
public class ArrayListWithLogging<T> extends ArrayList<T> {
	@Override
    public void add(int index, T element) {
        super.add(index, element);
        System.out.printf("Adding %s at %d\n", element, index);
    }
	
	@Override
    public boolean add(T element) {
        System.out.printf("Adding %s\n", element);
        return super.add(element);
    }
}
