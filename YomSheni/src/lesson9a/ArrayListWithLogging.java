package lesson9a;

import java.util.ArrayList;

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
}
