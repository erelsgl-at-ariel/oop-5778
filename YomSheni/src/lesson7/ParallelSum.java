package lesson7;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Calculating the sum of elements in an array using parallel computation.
 * @author erelsgl
 */
public class ParallelSum {

	static final int SIZE = 10_000_000; 
	public static void main(String[] args) throws InterruptedException {
		int[] array = new int[SIZE];
		Arrays.fill(array, 2);
		
		
		{   /* VERSION 1 - SERIAL: */
			Instant startTime = Instant.now();
			int sum = 0;
			for (int i=0; i<array.length; ++i)
				sum += Math.pow(array[i], 3);
			System.out.println("serial sum="+sum +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
			// with SIZE=100_000_000, this takes ~8000 ms.
		}
		
		{   /* VERSION 2 - THREADS: */
			Instant startTime = Instant.now();
			int[] sums = new int[2];
			Thread t1 = new Thread(() -> {
				for (int i=0; i<array.length/2; ++i)
					sums[0] += Math.pow(array[i], 3);
			});
			t1.start();
			Thread t2 = new Thread(() -> {
				for (int i=array.length/2; i<array.length; ++i)
					sums[1] += Math.pow(array[i], 3);
			});
			t2.start();
			
			t1.join();
			t2.join();
			int sum = sums[0]+sums[1];
			System.out.println("threads sum="+sum +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
			// with SIZE=100_000_000, this takes ~5000 ms.
		}
		
		{   /* VERSION 3 - STREAMS: */
			Instant startTime = Instant.now();
			int sum = Arrays.stream(array)
			.parallel()
			.map(x -> (int)Math.pow(x, 3))
			.reduce((x,y)->x+y)
			.getAsInt();
			System.out.println("streams sum="+sum +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
			// with SIZE=100_000_000, this takes ~2500 ms.
		}
		
	}

}
