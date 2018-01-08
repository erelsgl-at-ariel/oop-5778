package flyweight;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A point made into a flyweight using list.
 * 
 * Based on idea by Paz Chederman.
 */
public class Point2 {
    private static List<Point2> instances = 
        new ArrayList<Point2>();

    public static Point2 get(int x, int y) {
    	for (Point2 p: instances) {
    		if (p.getX()==x && p.getY()==y)
    			return p;
    	}
    	Point2 p = new Point2(x, y);
    	instances.add(p);
    	return p;
    }

    private final int x, y;

    private Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point2 intern() {
    	return get(x, y);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public String toString() { return "(" + x + ", " + y + ")";  }
}

