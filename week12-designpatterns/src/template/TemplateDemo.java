package template;

import java.util.*;

public class TemplateDemo {

	public static void main(String[] args) {
		Random r = new Random();
		List<Integer> haystack = new ArrayList<>();
		for (int i=0; i<1_000_000; ++i)
			haystack.add(r.nextInt());
		int numOfNeedles = 100;
		new LinearSearchSimulator().simulate(haystack, numOfNeedles);
		new SortAndBinarySearchSimulator().simulate(haystack, numOfNeedles);
	}

}
