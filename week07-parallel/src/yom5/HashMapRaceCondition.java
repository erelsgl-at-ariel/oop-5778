package yom5;

import java.time.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Demonstrates how race conditions can destroy a hashmap.
 * 
 * Based on code by Ivan: https://stackoverflow.com/a/47586668/827927
 *  
 * @author erelsgl
 */
public class HashMapRaceCondition {
	static final int SIZE = 9_000_000; 
	public static void main(String[] args) throws Exception {
		{   /* VERSION 1 - SERIAL: */
			Set<String> set = new HashSet<>();			
			Instant startTime = Instant.now();
			for (int i=0; i<SIZE; ++i)
				set.add(String.valueOf(i));
			System.out.println("Serial map size="+set.size()+"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
			// with SIZE=4_000_000, this takes ~2500 ms.
		}

		{   /* VERSION 2 - PARALLEL - RACE CONDITION! */
			Set<String> set = new HashSet<>();			
			Instant startTime = Instant.now();
			Thread t1 = new Thread(() -> {
		        for (int i = 0; i < SIZE/2; ++i)
					set.add(String.valueOf(i));
		    });
		    t1.start();
	
		    Thread t2 = new Thread(() -> {
		        for (int i = SIZE/2; i < SIZE; ++i)
					set.add(String.valueOf(i));
		    });
		    t2.start();
	
		    t1.join();
		    t2.join();
			System.out.println("Thread map size="+set.size()+"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}

		{   /* VERSION 3 - PARALLEL WITH synchronized */
			Set<String> set = new HashSet<>();			
			Instant startTime = Instant.now();
			Thread t1 = new Thread(() -> {
		        for (int i = 0; i < SIZE/2; ++i)
		        	synchronized(set) {
		        		set.add(String.valueOf(i));
		        	}
		    });
		    t1.start();
	
		    Thread t2 = new Thread(() -> {
		        for (int i = SIZE/2; i < SIZE; ++i)
		        	synchronized(set) {
		        		set.add(String.valueOf(i));
		        	}
		    });
		    t2.start();
	
		    t1.join();
		    t2.join();
			System.out.println("Synchronized map size="+set.size()+"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}
		
		{   /* VERSION 4 - PARALLEL with ConcurrentHashMap */
			Set<String> set = Collections.newSetFromMap(new ConcurrentHashMap<String,Boolean>());
			// See here for why we do not have ConcurrentHashSet: https://stackoverflow.com/q/6992608/827927
			Instant startTime = Instant.now();
			Thread t1 = new Thread(() -> {
		        for (int i = 0; i < SIZE/2; ++i)
		            set.add(String.valueOf(i));
		    });
		    t1.start();
	
		    Thread t2 = new Thread(() -> {
		        for (int i = SIZE/2; i < SIZE; ++i)
		            set.add(String.valueOf(i));
		    });
		    t2.start();
	
		    t1.join();
		    t2.join();
			System.out.println("Concurrent map size="+set.size()+"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}
    }
}
