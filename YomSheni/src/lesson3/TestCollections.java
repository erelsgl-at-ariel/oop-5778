package lesson3;

import java.util.*;

public class TestCollections {
	
	static void testAdd(Collection<Integer> c) {
		Collections.addAll(c, 10, 90, 20, 80, 30, 70, 40, 60, 50, 50);
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
	
	static void testNCopies() {
		Collection<String> tenTimesAaa = new NCopies<String>(10, "aaa");
		for (String s: tenTimesAaa)
			System.out.print(s+" ");
	}
	
	static void testIntegerCollection() {
		testPrint(new HashSet<>());              // arbitrary order, no duplicates
		testPrint(new LinkedHashSet<Integer>()); // insertion order, no duplicates 
		testPrint(new TreeSet<Integer>());       // natural order, no duplicates
		testPrint(new TreeSet<Integer>((x,y)->y-x));      // reverse order, no duplicates

		testPrint(new ArrayList<Integer>());     // insertion order, with duplicates
		testPrint(new LinkedList<Integer>());    // insertion order, with duplicates
		
		testRemove(new ArrayDeque<Integer>());   // insertion order, with duplicates
		testRemove(new LinkedList<Integer>());   // insertion order, with duplicates
		testRemove(new PriorityQueue<Integer>());   // natural order, with duplicates
	}
	
	static void testStringCollection() {
		Collection<String> c = new ArrayList<>();
		c.add("xy");
		Collections.addAll(c, "bcde","abc","cdefg","de");
		System.out.println(c.contains("xy")); // true
		c.remove("xy");
		System.out.println(c.contains("xy")); // false
		
		c.removeIf(s->s.length()>=4);
		System.out.println(c); // [abc, de]
		
		String[] a = c.toArray(new String[0]);
		System.out.println(Arrays.toString(a)); // [abc, de]
		
		for (Iterator<String> i = c.iterator(); i.hasNext(); ) {
			String s = i.next();
			if (s.length()>=4) i.remove();
		}
		System.out.println(c); // [abc, de]

		for (String s: c) {
			// do something with s
			System.out.println(s);
		}
		
		c.forEach(x -> System.out.println(x) );
	}

		
	static void testStringList() {
		List<String> c = new ArrayList<>();
		Collections.addAll(c, "abc","de", "de");

		c.sort((x,y)->x.length()-y.length());
		System.out.println(c); // [de, de, abc]
		
		c.replaceAll(x -> x+x);
		System.out.println(c); // [dede, dede, abcabc]
		
		Collections.addAll(c, "xy", "zw");

		List<String> c1 = c.subList(1, 4);
		System.out.println(c1);  // dede, abcabc, xy
		Collections.shuffle(c1);
		System.out.println(c1);  // dede, abcabc, xy
		
		System.out.println(String.join("", Collections.nCopies(20, "*")));
	}

	static void testMap() {
		Map<String,Integer> phoneBook= new HashMap<>();
		phoneBook.put("Erel", 12);
		phoneBook.put("Galya", 34);
		phoneBook.put("Erel", 56);
		phoneBook.putIfAbsent("Galya", 78);
		System.out.println(phoneBook.get("Erel")); // 56
		System.out.println(phoneBook.get("Galya")); // 34
		System.out.println(phoneBook.get("xyz")); // null
		System.out.println(phoneBook.getOrDefault("xyz",99)); // 99

		Map<Character,Integer> charCounter = new TreeMap<>();
		String s = "a ab abc abcd abcde abcdef";
		for (char c: s.toCharArray()) 
			charCounter.merge(c, 1, (x,y)->x+y);
		System.out.println(charCounter);

		// Solution A: iterate over all keys
		for (String k: phoneBook.keySet())
			System.out.println(k+" === "+phoneBook.get(k));
		
		// Solution B: iterate over all entries
		for (Map.Entry<String,Integer> entry: phoneBook.entrySet())
			System.out.println(entry.getKey()+" === "+entry.getValue());
		
		// Solution C: use a Consumer
		phoneBook.forEach( (k,v) -> System.out.println(k+" === "+v) );
}
	
	public static void main(String[] args) {
		testStringCollection();
//		testIntegerCollection();
//		testStringList();
//		testMap();
	}
}
