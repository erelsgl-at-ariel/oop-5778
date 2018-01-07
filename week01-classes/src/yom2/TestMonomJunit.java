package yom2;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author erelsgl
 */
public class TestMonomJunit {
	
	Monom m;
	
	@Before
	public void init() {
		m = new Monom(6,2);
	}

	@Test
	public void testPower() {
		assertThat(m.getPower(), is(2));
	}

	@Test
	public void testSetPower() {
		assertThat(m.getPower(), is(2));
		m.setPower(3);
		assertThat(m.getPower(), is(3));
	}
	
	@Test
	public void testToString() {
		assertThat(m.toString(), is("6.0x^2"));
	}

}
