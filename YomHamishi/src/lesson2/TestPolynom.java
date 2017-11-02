package lesson2;

/**
 * A test for class Polynom
 * @author erelsgl
 */
public class TestPolynom {

	public static void main(String[] args) {
		testAddMonom();
		testAddPolynom();
		testMultiply();
	}
	
	private static void testMultiply() {
		System.out.println("testMultiply start");
		Polynom p1 = new Polynom();
		p1.add(new Monom(2, 6));
		p1.add(new Monom(4, 3));

		Polynom p2 = new Polynom();
		p2.add(new Monom(3, 6));
		p2.add(new Monom(7, 9));
		
		Polynom p3 = p1.times(p2);
		System.out.println(p3);   // should be 34*x^12 + 12*x^9 + 14*x^15
		System.out.println(p1);   // should be 2.0*x^6 + 4.0*x^3
		System.out.println(p2);   // should be 3.0*x^6 + 7.0*x^9
		System.out.println("testMultiply end");
	}

	public static void testAddPolynom() {
		System.out.println("testAddPolynom start");
		Polynom p1 = new Polynom();
		p1.add(new Monom(2.5, 6));
		p1.add(new Monom(2,3));

		Polynom p2 = new Polynom();
		p2.add(new Monom(3.5, 6));
		p2.add(new Monom(4,9));
		
		Polynom p3 = p1.plus(p2);
		System.out.println(p3);   // 6.0*x^6 + 2.0*x^3 + 4.0*x^9
		System.out.println(p1);   // should be 2.5*x^6 + 2.0*x^3
		System.out.println(p2);   // should be 3.5*x^6 + 4.0*x^9
		System.out.println("testAddPolynom end");
	}
	
	public static void testAddMonom() {
		System.out.println("testAddMonom start");
		Polynom p = new Polynom();
		System.out.println(p);  // should print 0.0
		
		Monom m1 = new Monom(2.5, 6);
		p.add(m1);
		System.out.println(p);  // should print 2.5*x^6
		
		p.add(new Monom(2,3));
		System.out.println(p);  // should print 2.5*x^6 + 2.0*x^3
		
		p.add(new Monom(7,3));
		System.out.println(p);  // should print 2.5*x^6 + 9.0*x^3
		
		p.add(new Monom(-9,3));
		System.out.println(p);  // should print 2.5*x^6
		System.out.println("testAddMonom end");
	}

}
