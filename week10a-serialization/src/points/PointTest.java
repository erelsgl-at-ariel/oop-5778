package points;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {
	@Test
	public void test() {
		Point p = new Point(10,20);
		assertEquals("(10,20)", p.toString());
	}
}
