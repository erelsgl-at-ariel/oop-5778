package yom2;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class NonAssociativeReduce {

	static final int SIZE = 10_000_000; 
	public static void main(String[] args) {
		double[] array = new double[SIZE];
		Arrays.fill(array, 1);

		{   // Associative operation, parallel
			Instant startTime = Instant.now();
			double sum = Arrays.stream(array)
			.parallel()
			.map(x->Math.pow(x,3))
			.reduce((x,y)->x+y)
			.getAsDouble();
			System.out.println("parallel streams sum="+sum +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}
		{   // Associative operation, serial
			Instant startTime = Instant.now();
			double sum = Arrays.stream(array)
			.map(x->Math.pow(x,3))
			.reduce((x,y)->x+y)
			.getAsDouble();
			System.out.println("serial streams sum="+sum +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}
		

		{   // Non-associative operation, parallel
			Instant startTime = Instant.now();
			double sum = Arrays.stream(array)
			.parallel()
			.map(x->Math.pow(x,3))
			.reduce((x,y)->x-y)
			.getAsDouble();
			System.out.println("\nparallel streams diff="+sum +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}
		{   // Non-associative operation, serial
			Instant startTime = Instant.now();
			double sum = Arrays.stream(array)
			.map(x->Math.pow(x,3))
			.reduce((x,y)->x-y)
			.getAsDouble();
			System.out.println("serial streams diff="+sum +"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}
		
	}

}
