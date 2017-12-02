package lesson7;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Calculating the sum of elements in an array using parallel computation.
 * @author erelsgl
 */
public class ParallelSum {

	static final int SIZE = 100_000_000; 
	public static void main(String[] args) throws InterruptedException {
		double[] array = new double[SIZE];
		Arrays.fill(array, 2);
		
		
		{   /* SOLUTION 1 - SERIAL: */
			Instant startTime = Instant.now();
			double sum = 0;
			for (int i=0; i<array.length; ++i)
				sum += Math.pow(array[i], 3);
			System.out.println("serial sum="+sum +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
			// with SIZE=100_000_000, this takes ~8000 ms.
		}
//		System.exit(0);
		
		{   /* SOLUTION 2 - PRODUCER-CONSUMER APP: */
			Instant startTime = Instant.now();
			double[] sums = new double[2];
			Thread t1 = new Thread(() -> {
				int sum = 0;
				for (int i=0; i<array.length/2; ++i)
					sum += Math.pow(array[i], 3);
				sums[0] = sum;
			});
			t1.start();
			Thread t2 = new Thread(() -> {
				int sum = 0;
				for (int i=array.length/2; i<array.length; ++i)
					sum += Math.pow(array[i], 3);
				sums[1] = sum;
			});
			t2.start();
			
			t1.join();
			t2.join();
			double sum = sums[0]+sums[1];
			System.out.println("threads sum="+sum +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}
		
		{   /* SOLUTION 2.5 - PRODUCER-CONSUMER APP with BLOCKING QUEUE: */
			Instant startTime = Instant.now();
			BlockingQueue<Integer> sums = new ArrayBlockingQueue<>(2);
			new Thread(() -> {
				int sum = 0;
				for (int i=0; i<array.length/2; ++i)
					sum += Math.pow(array[i], 3);
				sums.offer(sum);
			}).start();
			new Thread(() -> {
				int sum = 0;
				for (int i=array.length/2; i<array.length; ++i)
					sum += Math.pow(array[i], 3);
				sums.offer(sum);
			}).start();
			double sum = sums.take() + sums.take();
			System.out.println("threads queue sum="+sum +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}
		
		{   /* SOLUTION 3 - MAP-REDUCE APP with PARALLEL STREAMS: */
			Instant startTime = Instant.now();
			double sum = Arrays.stream(array)
			.parallel()
			.map(x -> Math.pow(x, 3))
			.reduce((x,y)->x+y)
			.getAsDouble();
			System.out.println("streams sum="+sum +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}
		
	}

}
