package yom5;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.*;

/**
 * This test requires JUNIT 5.
 * @author erelsgl
 */
class MonomTest {
	Monom m;

	@BeforeEach
	void setUp() throws Exception {
		m = new Monom(5,2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSetCoefficient() {
		m.setCoefficient(16.2);
		assertThat(m.toString(), is("16.2x^2"));
	}

	@Test
	void testToString() {
		assertThat(m.toString(), is("5.0x^2"));
	}

	@Test
	void testGetDegree() {
		assertThat(m.getDegree(), is(2));
	}

	@Test
	void testGetDerivative() {
		assertThat(m.getDerivative().toString(), is("10.0x"));
	}
	
	@Disabled @Test
	void testSetPowerNegative() {
		assertThrows(IllegalArgumentException.class, () -> m.setPower(-2));
	}
}
