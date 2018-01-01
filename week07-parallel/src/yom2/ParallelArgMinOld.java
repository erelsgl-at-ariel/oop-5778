package yom2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;


/**
 * An example of finding the arg-min of a function using streams.
 * 
 * @author erelsgl
 */
public class ParallelArgMinOld {
	static double f(int i) {
		return Math.sin(i/100.0);
	}
	
	public static void main(String[] args) {
		Comparator<Integer> sineComparator = (i,j) -> 
			Double.compare(f(i), f(j));
		int bestIndex = IntStream.range(1,1000)
		.mapToObj(i->i)
		.min(sineComparator)
		.get();
		System.out.println(bestIndex+ " " + f(bestIndex));
	}

}
