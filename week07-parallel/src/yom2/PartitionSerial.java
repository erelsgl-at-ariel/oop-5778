package yom2;

import java.util.*;

/**
 * A serial implementation of the brute-force partition algorithm.
 * 
 * @author erelsgl
 */
public class PartitionSerial implements Partition {

	@Override
	@SuppressWarnings("unchecked")
	public List<Double>[] best(List<Double> values) {
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
				Thread.yield(); // RETURN LATER
				double sum1 = Partition.subsetSumByBinaryRepresentation(values, index);
				double sum0 = Partition.subsetSumByBinaryRepresentation(values, ~index);
				double diff = Math.abs(sum1-sum0);
				if (diff < smallestDiff) {
					bestIndex = index;
					smallestDiff = diff;
				}
			}
			
			// Create the result partition.
			return new List[] {
				Partition.subsetByBinaryRepresentation(values,bestIndex),
				Partition.subsetByBinaryRepresentation(values,~bestIndex)
				};
	}
}
