package yom2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class TestInterfaces {
	
	static void repeat(int n, Runnable action) {
		for (int i=0; i<n; i++)
			action.run();
	}
	
	
	
	
	static <T> List<T> filter(List<T> strings, Condition<T> condition) {
		List<T> output = new ArrayList<>();  // initialize empty list
		for (int i=0; i<strings.size(); i++) {
			T s = strings.get(i);
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

		Condition<String> condition1 = new StartsWith('a');
		List<String> filteredStrings = filter(strings, condition1);
		System.out.println(filteredStrings); // aaa,abc (only strings that start with a)
		
		Condition<String> condition2 = new Condition<String>() {
			public boolean test(String s) {
				if (s.charAt(1)=='b') return true;
				else return false;
			}
		};
		filteredStrings = filter(strings, condition2);
		System.out.println(filteredStrings); // aaa,abc (only strings that start with a)
		
		//Condition<String> condition3 = s -> s.charAt(0)=='c'; /* the string starts with  */;
		
		System.out.println(condition1.test("abc"));
		System.out.println(condition2.test("abc"));
		System.out.println(condition1.test("abc") && condition2.test("abc"));
		
		// Solution 1: inline
		Condition<String> condition4 = s -> 
			condition1.test(s) && condition2.test(s);
		
			
		System.out.println(filter(strings, condition4));
		
		// Solution 2: class
		System.out.println(filter(strings, new AndCondition<String>(condition1,condition2)));
		
		// Solution 3: Use Java's Predicate class
		Predicate<String> predicate1 = s -> s.charAt(0)=='a';
		Predicate<String> predicate2 = s -> s.charAt(1)=='b';
		Predicate<String> predicate3 = predicate1.and(predicate2);
		
	}
}
