package lesson3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

/**
 * A unitest for Monom. Requires JUnit 4.
 * @author erelsgl
 */
public class MonomTest4 {
	Monom m;

	@Before
	public void setUp() throws Exception {
		m = new Monom(5,2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetCoefficient() {
		m.setCoefficient(16.2);
		assertThat(m.toString(), is("16.32x^2"));
	}

	@Test
	public void test() {
		
	}

}
