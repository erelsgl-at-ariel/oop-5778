package yom5;

import java.util.*;

/**
 * An interface for the partition problem.
 * 
 * @author erelsgl
 */
public interface Partition {
	
	/**
	 * Return a partition of the input to two lists 
	 *     such that the difference between their sums is minimized.
	 *     
	 * @return an array with exactly 2 items.  
	 */
	public List<Double>[] best(List<Double> values);

	
	/**
	 * Return a subset of "values" determined by the binary representation of "index".
	 */
	static List<Double> subsetByBinaryRepresentation(List<Double> values, int index) {
		List<Double> result = new ArrayList<>();
		for (int i=0; i<values.size(); ++i)
			if ((index & (1 << i)) > 0)   // If bit i is set in index, then -
				result.add(values.get(i));
		return result;
	}
	
	
	/**
	 * Return the sum of the subset of "values" determined by the binary representation of "index".
	 */
	static double subsetSumByBinaryRepresentation(List<Double> values, int index) {
		double result = 0;
		for (int i=0; i<values.size(); ++i)
			if ((index & (1 << i)) > 0)   // If bit i is set in index, then -
				result += values.get(i);
		return result;
	}
}
