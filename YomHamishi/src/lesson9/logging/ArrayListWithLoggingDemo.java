package lesson9.logging;

import java.util.ArrayList;
import java.util.List;

import lesson9.logging.ArrayListWithLogging;

/**
 * Based on code by Cay S. Horstmann.
 * @author erelsgl
 */
public class ArrayListWithLoggingDemo {
    public static void main(String[] args) {
    	{
	        ArrayList<String> names = new ArrayListWithLogging<String>();
	        names.add(0, "A");
	        names.add(1, "B");
	        names.add(0, "C");
	        System.out.println(names);
    	}
    	{
	        @SuppressWarnings("serial")
			List<String> names = new ArrayList<String>() {
	            @Override public void add(int index, String element) {
	                super.add(index, element);
	                System.out.printf("Adding %s at %d\n", element, index);
	            }
	        };
	        names.add(0, "A");
	        names.add(1, "B");
	        names.add(0, "C");
	        System.out.println(names);
    	}
    }
}
