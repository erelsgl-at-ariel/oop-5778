package flyweight;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A point made into a thread-safe flyweight.
 * 
 * @author erelsgl
 */
public class Point1 {
    private static Map<String, Point1> instances = 
            new ConcurrentHashMap<String, Point1>();

        public static Point1 get(int x, int y) {
            String key = x + "," + y;
            //instances.putIfAbsent(key, new Point1(x, y));
            if (!instances.containsKey(key))
            	instances.put(key, new Point1(x, y));
            return instances.get(key);
        }

        private final int x, y;

        private Point1(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public Point1 intern() {
        	return get(x, y);
        }

        public int getX() { return x; }
        public int getY() { return y; }
        public String toString() { return "(" + x + ", " + y + ")";  }
}

