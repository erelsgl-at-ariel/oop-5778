package yom2;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * Calculating the sum of elements in an array using parallel computation.
 * @author erelsgl
 */
public class ParallelArgMin {

	static final int SIZE = 10_000_000; 
	static LongAdder ftimes = new LongAdder();
	static double f(double x) {
		ftimes.increment();
		return Math.pow(x,3);
	}
	public static void main(String[] args) throws InterruptedException {
		double[] array = new double[SIZE];
		Arrays.fill(array, 2);
		array[12345]= 1.5;
		
		
		{   /* SOLUTION 1 - SERIAL: */
			ftimes.reset();
			Instant startTime = Instant.now();
			int argmin = 0;
			for (int i=0; i<array.length; ++i)
				if (f(array[i])<f(array[argmin]))
					argmin = i;
			System.out.println("serial argmin="+argmin+"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms], ftimes="+ftimes);
			// with SIZE=100_000_000, this takes ~8000 ms.
		}
//		System.exit(0);
		
		{   /* SOLUTION 2 - PRODUCER-CONSUMER APP: */
			ftimes.reset();
			Instant startTime = Instant.now();
			BlockingQueue<Integer> argmins = new ArrayBlockingQueue<>(2);
			new Thread(() -> {
				int argmin = 0;
				for (int i=0; i<array.length/2; ++i)
					if (f(array[i])<f(array[argmin]))
						argmin = i;
				argmins.offer(argmin);
			}).start();
			new Thread(() -> {
				int argmin = 0;
				for (int i=array.length/2; i<array.length; ++i)
					if (f(array[i])<f(array[argmin]))
						argmin = i;
				argmins.offer(argmin);
			}).start();
			int argmin1 = argmins.take(), argmin2 = argmins.take();
			int argmin = (array[argmin1]<array[argmin2]? argmin1: argmin2);
			System.out.println("threads argmin="+argmin +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms], ftimes="+ftimes);
		}
		
		{   /* SOLUTION 3 - MAP-REDUCE APP with PARALLEL STREAMS: */
			ftimes.reset();
			Instant startTime = Instant.now();
			int argmin = IntStream.range(0,array.length)
			.parallel()
			.reduce((i,j) -> f(array[i])<f(array[j])? i: j)
			.getAsInt();
			System.out.println("streams argmin="+argmin +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms], ftimes="+ftimes);
		}
		
	}

}
