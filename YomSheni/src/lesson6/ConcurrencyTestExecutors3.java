package lesson6;

import java.time.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Demonstrate an even BETTER solution to the problem in ConcurrencyTest0 - using CompletableFutures.
 * 
 * No need to use dangerous locks.
 * 
 * @author erelsgl
 */
public class ConcurrencyTestExecutors3 {

	static final int SIZE = 10000000;
	static final int NUM_OF_THREADS = 4;

	static int iThread;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] array = new int[NUM_OF_THREADS*SIZE];
		Arrays.fill(array, 1);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		Instant startTime = Instant.now();

		CompletableFuture<Integer>[] futures = new CompletableFuture[NUM_OF_THREADS];
		for (iThread=0; iThread<NUM_OF_THREADS; ++iThread) {
			final int iThreadLocal = iThread;
			futures[iThread] = CompletableFuture.supplyAsync( () -> {
				int sum=0;
				int start = iThreadLocal*SIZE;
				int end = (iThreadLocal+1)*SIZE;
				for (int i=start; i<end; ++i) {
					Thread.yield();
					sum += Math.pow(Math.pow(Math.pow(array[i],0.3),0.4),0.5);
				}
				System.out.println(iThreadLocal+": "+sum + 
						"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
				return sum;
			}, executor);
		}

		CompletableFuture.allOf(futures).thenRun(
				() -> {
					try {
						Arrays.stream(new int[] {1,2,3}).sum();
						int totalSum = 0;
						for (iThread=0; iThread<NUM_OF_THREADS; ++iThread)
							totalSum += futures[iThread].get();
						System.out.println("Total: "+totalSum+ 
								"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				}
		);
		
		executor.shutdown();
	}
}
