package lesson3;

public class TestException1 {
	static void p(String s) {System.out.println(s);}
	
	public static void main(String[] args) { 
		p("main1"); 
		a(); 
		p("main2"); 
	}
	
	static void a() { 
		p("a1");
		try {
			b();
		} catch (NullPointerException ex) {
			System.out.println(ex);
		}
		p("a2");
	}
	
	static void b() { 
		p("b1"); 
		c();	
		p("b2"); 
	}
	
	static Object x;
	static void c() { 
		String s = x.toString();
	}
}
