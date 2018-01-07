package exceptions;

import java.util.logging.*;

import java.io.*;

public class TestException2 {
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
			System.out.println("Did you use a null object? "+ex);
		} catch (ArithmeticException ex) {
			System.out.println("Did you divide by zero? "+ex);
		} catch (RuntimeException ex) {
//			System.out.println("What did you do? "+ex);
//			Logger.getGlobal().severe(ex.toString());
			StringWriter w = new StringWriter();
			ex.printStackTrace(new PrintWriter(w));
			Logger.getGlobal().severe(w.toString());
		}
		p("a2");
	}
	
	static void b() {
		p("b1"); 
		c();	
		p("b2"); 
	}
	
	static void c() {
//		Object x = null;
//		String s = x.toString();
//		int i = 5/0;
//		throw new IllegalArgumentException("hah!");
//		throw new Error();
		throw new IllegalColorException("I do not know what is mahagony color");
	}
}
