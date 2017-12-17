package lesson9;

import java.util.ArrayList;

/**
 * @author Cay S. Horstmann
 */
public class AnonymousSubclassDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>(100) {
            public void add(int index, String element) {
                super.add(index, element);
                System.out.printf("Adding %s at %d\n", element, index);
            }
        };
        
        names.add(0, "Peter");
        names.add(1, "Paul");
        names.add(0, "Mary");
        System.out.println(names);
        
        invite(new ArrayList<String>() {{ add("Harry"); add("Sally"); }});
    }
    
    public static void invite(ArrayList<String> friends) {
        System.out.println("Guest list: " + friends);
    }
}
