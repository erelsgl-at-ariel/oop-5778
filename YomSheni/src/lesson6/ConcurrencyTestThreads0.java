package lesson6;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Demonstrate the disaster that might happen when multiple threads change the same variable.
 * 
 * @author erelsgl
 */
public class ConcurrencyTestThreads0 {
	
	static int sum;
	static final int SIZE=10000000;
	public static void main(String[] args) {
		int[] array = new int[4*SIZE];
		Arrays.fill(array, 1);

		sum = 0;
		Instant start = Instant.now();
		
		new Thread( () -> {
			for (int i=0; i<SIZE; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} ).start();
		
		new Thread( () -> {
			for (int i=SIZE; i<SIZE*2; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} ).start();
		
		new Thread( () -> {
			for (int i=SIZE*2; i<SIZE*3; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} ).start();
		
		new Thread( () -> {
			for (int i=SIZE*3; i<SIZE*4; ++i) 
				sum += Math.pow(array[i],3);
			System.out.println(sum + 
					"   "+Duration.between(start, Instant.now()).toMillis()+" [ms]");
		} ).start();
	}

}
