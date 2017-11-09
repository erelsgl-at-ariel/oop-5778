package lesson2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestInterfaces {
	
	static void repeat(int n, Runnable action) {
		for (int i=0; i<n; i++)
			action.run();
	}
	
	
	
	
	static <T> List<T> filter(List<T> strings, Predicate<T> condition) {
		List<T> output = new ArrayList<>();  // initialize empty list
		for (int i=0; i<strings.size(); i++) {
			T item = strings.get(i);
			if (condition.test(item)) {
				output.add(item);
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
//		List<String> strings = new ArrayList<>();
//		Collections.addAll(strings, "aaa","cc","bbbb","abc");
//		
//		System.out.println(strings);
//		strings.sort(  (o1,o2) -> o1.length() - o2.length() );
//		System.out.println(strings);
//		strings.sort(  (o1,o2) -> {
//			if (o1.equals("bbbb")) return -1;
//			if (o2.equals("bbbb")) return 1;
//			return o1.compareTo(o2);
//		});
//		System.out.println(strings);

		List<String> strings = new ArrayList<>();
		Collections.addAll(strings, "aaa","cc","bbbb","abc");

		// Solution A: named class "StartsWith"
		Predicate<String> condition1 = new StartsWith('a');
		List<String> filteredStrings = filter(strings, condition1);
		System.out.println(filteredStrings); // aaa,abc (only strings that start with a)

		// Solution B: anonymous
		Predicate<String> condition2 = new Predicate<String>() {
			public boolean test(String s) {
				if (s.charAt(0)=='b') return true;
				else return false;
			}
		};
		filteredStrings = filter(strings, condition2);
		System.out.println(filteredStrings); // aaa,abc (only strings that start with a)
		
		// Solution C: anonymous
		Predicate<String> condition3 = x -> x.charAt(0)=='c';
	
		
		List<Integer> ints = new ArrayList<>();
		Collections.addAll(ints,  1,2,3,4,5,6,7);
		Predicate<Integer> condition4 = new Predicate<Integer>() {
			public boolean test(Integer i) {
				return (i<3 || i>5);
			}
		};
		System.out.println(filter(ints, condition4));
	}
}
