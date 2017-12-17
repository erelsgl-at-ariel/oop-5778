package lesson9a;

import java.util.ArrayList;

/**
 * This is a BAD EXAMPLE of using inheritance -
 *      inheritance without "is-a" relationship.
 *      
 * @author erelsgl
 */
public class WifiSample extends ArrayList<String> {
	public String getTime() {
		return get(3);
	}
}
