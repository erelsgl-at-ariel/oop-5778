package yom2;

import java.time.*;
import java.util.*;

public class PartitionTest {
	
	static void testRunTime(Partition p, List<Double> values) {
		Instant start = Instant.now();

		List<Double>[] bestPartition = p.best(values);
		
    	double sum0 = bestPartition[0].stream().mapToDouble(x->x).sum();
    	double sum1 = bestPartition[1].stream().mapToDouble(x->x).sum();
		double durationInMillis = Duration.between(start, Instant.now()).toMillis(); 
		System.out.println("Difference = "+Math.abs(sum1-sum0)+ " time = "+durationInMillis);
	}

	
	public static void main(String[] args) throws InterruptedException {
		List<Double> values = new ArrayList<>();
		for (int i=1; i<=23; ++i)
			values.add(Math.random()*1000);
		testRunTime (new PartitionSerial(), values); 
		testRunTime (new PartitionThreads(), values); 
		testRunTime (new PartitionStreams(), values); 
	}

}
