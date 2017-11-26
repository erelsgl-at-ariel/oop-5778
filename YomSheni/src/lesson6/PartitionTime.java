package lesson6;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * A class for testing the execution time of Partition.best 
 *   for increasing input sizes.
 * @author erelsgl
 *
 */
public class PartitionTime {

	public static void main(String[] args) {
		List<Double> values = new ArrayList<>();
		for (int i=1; i<=31; ++i) {
			values.add(Math.random());  
			Instant start = Instant.now();
			Partition.best(values);
			double durationInMillis = Duration.between(start, Instant.now()).toMillis(); 
			System.out.println("Partitioning an array with "+i+" values takes "+durationInMillis+" [ms]");
		}
	}

}
