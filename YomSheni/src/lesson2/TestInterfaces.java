package lesson2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestInterfaces {
	
	static void repeat(int n, Runnable action) {
		for (int i=0; i<n; i++)
			action.run();
	}
	
	
	
	
	static List<String> filter(List<String> strings, Condition condition) {
		List<String> output = new ArrayList<>();  // initialize empty list
		for (int i=0; i<strings.size(); i++) {
			String s = strings.get(i);
			if (condition.test(s)==true) {
				output.add(s);
			}
		}
		return output;
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		/*
		// Solution A: named class
		repeat(100, new PrintX());
		System.out.println();
		
		// Solution B: anonymous class
		repeat(10, new Runnable() {
			public void run() {System.out.print("y");}
		});
		System.out.println();
		
		// Solution C: one-line class
		Runnable r = () -> System.out.print("z"); 
		repeat(5, r);
		*/
		
		
		List<String> strings = new ArrayList<>();
		Collections.addAll(strings, "aaa","cc","bbbb","abc");

		Condition condition1 = new StartsWith('a');
		List<String> filteredStrings = filter(strings, condition1);
		System.out.println(filteredStrings); // aaa,abc (only strings that start with a)
		
		Condition condition2 = new Condition() {
			public boolean test(String s) {
				if (s.charAt(0)=='b') return true;
				else return false;
			}
		};
		filteredStrings = filter(strings, condition2);
		System.out.println(filteredStrings); // aaa,abc (only strings that start with a)
		
		Condition condition3 = s -> s.charAt(0)=='c'; /* the string starts with  */;

		
		
	
	}
}
