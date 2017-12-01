package lesson7;

import java.util.*;

/**
 * An implementation of the brute-force partition algorithm using two threads.
 * 
 * @author erelsgl
 */
public class PartitionThreads implements Partition {

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
			int[] bestIndexes = new int[2];
			double[] smallestDiff = new double[] {Double.MAX_VALUE,Double.MAX_VALUE};
			Thread t1 = new Thread(() -> {
				for (int index=0; index<numOfPartitions/2; ++index) {
					double sum1 = Partition.subsetSumByBinaryRepresentation(values, index);
					double sum0 = Partition.subsetSumByBinaryRepresentation(values, ~index);
					double diff = Math.abs(sum1-sum0);
					if (diff < smallestDiff[0]) {
						bestIndexes[0] = index;
						smallestDiff[0] = diff;
					}
				}
			});
			t1.start();
			Thread t2 = new Thread(() -> {
				for (int index=numOfPartitions/2; index<numOfPartitions; ++index) {
					double sum1 = Partition.subsetSumByBinaryRepresentation(values, index);
					double sum0 = Partition.subsetSumByBinaryRepresentation(values, ~index);
					double diff = Math.abs(sum1-sum0);
					if (diff < smallestDiff[1]) {
						bestIndexes[1] = index;
						smallestDiff[1] = diff;
					}
				}
			});
			t2.start();
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {	}
			int bestIndex = (
					smallestDiff[0] < smallestDiff[1]?
					bestIndexes[0]    : bestIndexes[1]
					);
			
			// Create the result partition.
			return new List[] {
				Partition.subsetByBinaryRepresentation(values,bestIndex),
				Partition.subsetByBinaryRepresentation(values,~bestIndex)
				};
	}
}
