package lesson3;

import java.util.*;

public class TestRange {

	public static void main(String[] args) {
		Range r = new Range(5,10);
		
		// Solution A: long loop
		for (Iterator<Integer> iter = r.iterator(); iter.hasNext();)
			System.out.println(iter.next());

		// Solution B: short loop
		for (Integer i: r)
			System.out.println(i);
		
		// Solution C:
		r.forEach( x -> System.out.println(x) );
	}

}
