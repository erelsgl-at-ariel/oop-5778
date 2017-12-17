package lesson9;

import java.util.ArrayList;

/**
 * @author Cay S. Horstmann, erelsgl
 */
public class ArrayListWithLoggingDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayListWithLogging<String>();
        names.add(0, "Peter");
        names.add(1, "Paul");
        names.add(0, "Mary");
        System.out.println(names);
    }
}
