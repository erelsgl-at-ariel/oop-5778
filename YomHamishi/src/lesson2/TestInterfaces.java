package lesson2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestInterfaces {
	
	static void repeat(int n, Runnable action) {
		for (int i=0; i<n; i++)
			action.run();
	}
	
	
	
	
	static List<String> filter(List<String> strings, Predicate condition) {
		List<String> output = new ArrayList<>();  // initialize empty list
		for (int i=0; i<strings.size(); i++) {
			String s = strings.get(i);
			if (condition.test(s)) {
				output.add(s);
			}
		}
		return output;
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
//		// Solution A: named class
//		repeat(100, new PrintX('*'));
//		System.out.println();
//		
//		// Solution B: anonymous class
//		repeat(10, new Runnable() {
//			public void run() {System.out.print("y");}
//		});
//		System.out.println();
//		
//		// Solution C: one-line class
//		Runnable r = () -> System.out.print("z"); 
//		repeat(5, r);
//		
//		repeat(20, ()->System.out.print("%"));
//		repeat(20, ()->System.out.print("^"));
//		
		List<String> strings = new ArrayList<>();
		Collections.addAll(strings, "aaa","cc","bbbb","abc");
		
		System.out.println(strings);
		strings.sort(  (o1,o2) -> o1.length() - o2.length() );
		System.out.println(strings);
		strings.sort(  (o1,o2) -> {
			if (o1.equals("bbbb")) return -1;
			if (o2.equals("bbbb")) return 1;
			return o1.compareTo(o2);
		});
		System.out.println(strings);
/*
		aStrings = filter (strings, condition???);
		Predicate condition1 = new StartsWith('a');
		List<String> filteredStrings = filter(strings, condition1);
		System.out.println(filteredStrings); // aaa,abc (only strings that start with a)

		Predicate condition2 = new Predicate() {
			public boolean test(String s) {
				if (s.charAt(0)=='b') return true;
				else return false;
			}
		};
		filteredStrings = filter(strings, condition2);
		System.out.println(filteredStrings); // aaa,abc (only strings that start with a)
		
		Predicate condition3 = x -> x.charAt(0)=='c';
	*/
	}
}
