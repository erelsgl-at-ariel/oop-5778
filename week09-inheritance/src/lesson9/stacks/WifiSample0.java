package lesson9.stacks;

import java.util.ArrayList;

/**
 * This is a BAD EXAMPLE of using inheritance -
 *      inheritance without "is-a" relationship.
 *      
 * @author erelsgl
 */
public class WifiSample0 {
	private ArrayList<String> list;
	static final int TIME = 3;
	public void add(String s) {
		list.add(s);
	}
	public String getTime() {
		return list.get(TIME);
	}
}
