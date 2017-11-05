package lesson3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitestMonom {
	@Test void testToString() {
		Monom m = new Monom(5,2);
		assert m.toString().equals("5.0x^2"): m;
	}
	@Test void testDegree() {
		Monom m = new Monom(5,2);
		assert m.getDegree()==2: m;
	}
}

