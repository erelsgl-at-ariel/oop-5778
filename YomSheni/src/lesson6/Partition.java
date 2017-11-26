package lesson6;

import java.util.*;

/**
 * An exact solution to the partition problem -- partition a set of numbers to two subsets with almost-equal sum.
 * 
 * @author erelsgl
 */
public class Partition {
	
	/**
	 * Return a subset of "values" determined by the binary representation of "index".
	 */
	public static List<Double> subsetByBinaryRepresentation(List<Double> values, int index) {
		List<Double> result = new ArrayList<>();
		for (int i=0; i<values.size(); ++i)
			if ((index & (1 << i)) > 0)   // If bit i is set in index, then -
				result.add(values.get(i));
		return result;
	}
	
	
	/**
	 * Return a subset of "values" determined by the binary representation of "index".
	 */
	public static double subsetSumByBinaryRepresentation(List<Double> values, int index) {
		double result = 0;
		for (int i=0; i<values.size(); ++i)
			if ((index & (1 << i)) > 0)   // If bit i is set in index, then -
				result += values.get(i);
		return result;
	}
	
	/**
	 * Return a partition of the input to two lists 
	 *     such that the difference between their sums is minimized.
	 *     
	 * @return an array with exactly 2 items.  
	 */
	public static List<Double>[] best(List<Double> values) {
		// Check that there aren't too many values in the input.
		final int MAX_VALUES = 31;
		if (values.size()>MAX_VALUES)
			throw new IllegalArgumentException(
				"You asked me to handle "+values.size()+" values, but I can handle at most "+MAX_VALUES);
		
		// Loop over all partitions. Find the partition with the smallest difference.
		int numOfPartitions = 1 << values.size();
		int bestIndex = 0;
		double smallestDiff = Double.MAX_VALUE;
		for (int index=0; index<numOfPartitions; ++index) {
			Thread.yield();
			double sum1 = subsetSumByBinaryRepresentation(values, index);
			double sum0 = subsetSumByBinaryRepresentation(values, ~index);
			double diff = Math.abs(sum1-sum0);
			if (diff < smallestDiff) {
				bestIndex = index;
				smallestDiff = diff;
			}
		}
		
		// Create the result partition.
		return new List[] {
			subsetByBinaryRepresentation(values,bestIndex),
			subsetByBinaryRepresentation(values,~bestIndex)
			};
	}

}
