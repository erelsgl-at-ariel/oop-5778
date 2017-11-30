package lesson7;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstrate the disaster that might happen when multiple threads change the same variable.
 * 
 * @author erelsgl
 */
public class ConcurrencyTestExecutors0 {
	
	static int sum;
	static final int SIZE=10000000;
	public static void main(String[] args) {
		int[] array = new int[4*SIZE];
		Arrays.fill(array, 1);

		sum = 0;

		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		Instant start = Instant.now();
		
		executor.execute( () -> {
			for (int i=0; i<SIZE; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} );
		
		executor.execute( () -> {
			for (int i=SIZE; i<SIZE*2; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} );
		
		executor.execute( () -> {
			for (int i=SIZE*2; i<SIZE*3; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} );
		
		executor.execute( () -> {
			for (int i=SIZE*3; i<SIZE*4; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} );
		
		executor.shutdown();
	}

}
