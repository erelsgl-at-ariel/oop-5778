package lesson9.stacks;

import java.util.ArrayList;

/**
 * This is a BAD EXAMPLE of using inheritance -
 *      inheritance without "is-a" relationship.
 *      
 * @author erelsgl
 */
public class WifiSample1  {
	private ArrayList<String> list;
	
	public void addLat(Integer lat) {
		list.add(0, lat.toString());
	}
	
	public String getTime() {
		return list.get(3);
	}
}
