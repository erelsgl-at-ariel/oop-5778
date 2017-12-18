package lesson9a.logging;

import java.util.ArrayList;

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
			ArrayList<String> names = new ArrayList<String>() {
	            public void add(int index, String element) {
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
