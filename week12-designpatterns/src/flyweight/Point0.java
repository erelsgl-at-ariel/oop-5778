package flyweight;

/**
 * A point without a flyweight
 * 
 * @author erelsgl
 */
public class Point0 {
    private final int x, y;

    public Point0(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public String toString() { return "(" + x + ", " + y + ")";  }
}

