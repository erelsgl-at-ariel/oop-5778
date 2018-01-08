package template;

import java.util.List;
import java.util.Random;

/**
 * A class with a Template Method
 * @author Student
 *
 */
public abstract class SearchSimulator {
	public abstract void sort(List<Integer> list);
	public abstract int find(List<Integer> haystack, int needle);
	static Random random = new Random();

	public void simulate(List<Integer> haystack, int numOfNeedles) {
		System.out.println(getClass().getName());
		long start = System.currentTimeMillis();
		sort(haystack);
		long middle = System.currentTimeMillis();
		System.out.println("\tTime to sort: "+(middle-start));
		for (int i=0; i<numOfNeedles; ++i) {
			find(haystack, random.nextInt());
		}
		long end = System.currentTimeMillis();
		System.out.println("\tTime to find "+numOfNeedles+" needles: "+(end-middle));
		System.out.println("\tTotal time: "+(end-start));
	}
}
