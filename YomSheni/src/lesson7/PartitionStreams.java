package lesson7;

import java.util.*;
import java.util.stream.IntStream;

/**
 * An implementation of the brute-force partition algorithm using parallel streams.
 * 
 * @author erelsgl
 */
public class PartitionStreams implements Partition {
	
	private double diff(List<Double> values, int index) {
		double sum1 = Partition.subsetSumByBinaryRepresentation(values, index);
		double sum0 = Partition.subsetSumByBinaryRepresentation(values, ~index);
		return Math.abs(sum1-sum0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Double>[] best(List<Double> values) {
			// Check that there aren't too many values in the input.
			final int MAX_VALUES = 31;
			if (values.size()>MAX_VALUES)
				throw new IllegalArgumentException(
					"You asked me to handle "+values.size()+" values, but I can handle at most "+MAX_VALUES);
			
			int numOfPartitions = 1 << values.size();

			Comparator<Integer> compareByDiff = 
				Comparator.comparingDouble(i -> diff(values,i));

			// Loop over all partitions. Find the partition with the smallest difference.
			int bestIndex = IntStream.range(0, numOfPartitions)
			.parallel()
//			.mapToObj(i->i)
			.boxed()
			.min(compareByDiff)
			.get();
		
			// Create the result partition.
			return new List[] {
				Partition.subsetByBinaryRepresentation(values,bestIndex),
				Partition.subsetByBinaryRepresentation(values,~bestIndex)
				};
	}
}
