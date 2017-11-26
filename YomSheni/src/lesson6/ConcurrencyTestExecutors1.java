package lesson6;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstrate a BAD solution to the problem in ConcurrencyTest0 - using locks.
 * 
 * Why is it bad? Because it's easy to make mistakes that will cause deadlocks.
 * And because it is very inefficient.
 * 
 * @author erelsgl
 */
public class ConcurrencyTestExecutors1 {

	static final int SIZE=10000000;

	static Object lock = new Object();
	static volatile int sum;

	public static void main(String[] args) {
		int[] array = new int[4*SIZE];
		Arrays.fill(array, 1);

		sum = 0;

		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		Instant start = Instant.now();
		
		executor.execute( () -> {
			for (int i=0; i<SIZE; ++i) {
				int toAdd = (int)Math.pow(array[i],3);
				synchronized(lock) {
					sum += toAdd;
				}
			}
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} );
		
		executor.execute( () -> {
			for (int i=SIZE; i<SIZE*2; ++i) {
				int toAdd = (int)Math.pow(array[i],3);
				synchronized(lock) {
					sum += toAdd;
				}
			}
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} );
		
		executor.execute( () -> {
			for (int i=SIZE*2; i<SIZE*3; ++i){
				int toAdd = (int)Math.pow(array[i],3);
				synchronized(lock) {
					sum += toAdd;
				}
			}
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} );
		
		executor.execute( () -> {
			for (int i=SIZE*3; i<SIZE*4; ++i) {
				int toAdd = (int)Math.pow(array[i],3);
				synchronized(lock) {
					sum += toAdd;
				}
			}
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} );
		
		executor.shutdown();
	}

}
