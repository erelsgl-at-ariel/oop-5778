package lesson2;

import java.util.*;

public class TestCollections {
	
	static void testAdd(Collection<Integer> c) {
		c.add(10);
		c.add(90);
		Collections.addAll(c, 20, 80, 30, 70, 40, 60, 50, 50);
	}
	
	static void testPrint(Collection<Integer> c) {
		testAdd(c);
		System.out.println(c);
	}
	
	static void testRemove(Queue<Integer> c) {
		testAdd(c);
		while (!c.isEmpty())
			System.out.print(c.remove()+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Collection<Integer> c;

		c = new HashSet<>();
		testPrint(c);                            // arbitrary order, no duplicates
		testPrint(new LinkedHashSet<Integer>()); // insertion order, no duplicates 
		testPrint(new TreeSet<Integer>());       // natural order, no duplicates

		testPrint(new ArrayList<Integer>());     // insertion order, with duplicates
		testPrint(new LinkedList<Integer>());    // insertion order, with duplicates
		
		testRemove(new ArrayDeque<Integer>());   // insertion order, with duplicates
		testRemove(new LinkedList<Integer>());   // insertion order, with duplicates
		testRemove(new PriorityQueue<Integer>());   // natural order, with duplicates
		
		Collection<String> tenTimesAaa = new NCopies<String>(10, "aaa");
		for (String s: tenTimesAaa)
			System.out.print(s+" ");
		
	}
}
