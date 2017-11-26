package lesson6;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Demonstrate a GOOD solution to the problem in ConcurrencyTest0 - using futures.
 * 
 * No need to use dangerous locks.
 * 
 * @author erelsgl
 */
public class ConcurrencyTestExecutors2 {

	static final int SIZE=10000000;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] array = new int[4*SIZE];
		Arrays.fill(array, 1);

		ExecutorService executor = Executors.newFixedThreadPool(4);
		Instant start = Instant.now();
		
		Callable<Integer> c1 = () -> {
			int sum=0;
			for (int i=0; i<SIZE; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
			return sum;
		};
		Callable<Integer> c2 = () -> {
			int sum=0;
			for (int i=SIZE; i<2*SIZE; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
			return sum;
		};
		Callable<Integer> c3 = () -> {
			int sum=0;
			for (int i=2*SIZE; i<3*SIZE; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
			return sum;
		};
		Callable<Integer> c4 = () -> {
			int sum=0;
			for (int i=3*SIZE; i<4*SIZE; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
			return sum;
		};
		
		List<Future<Integer>> futures = executor.invokeAll(Arrays.asList(c1,c2,c3,c4));
		int totalSum=0;
		for (Future<Integer> f: futures)
			totalSum += f.get();
		System.out.println("total sum = "+totalSum);
		
		executor.shutdown();
	}

}
