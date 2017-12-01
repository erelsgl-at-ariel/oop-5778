package lesson7;

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
	static final int SIZE = 4_000_000; 
	public static void main(String[] args) throws Exception {
		{   /* VERSION 1 - SERIAL: */
			Map<String,Integer> map = new HashMap<>();			
			Instant startTime = Instant.now();
			for (int i=0; i<SIZE; ++i)
				map.put(String.valueOf(i), i);
			System.out.println("Serial map size="+map.size()+"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
			// with SIZE=4_000_000, this takes ~2500 ms.
		}

		{   /* VERSION 2 - PARALLEL - RACE CONDITION! */
			Map<String,Integer> map = new HashMap<>();			
			Instant startTime = Instant.now();
			Thread t1 = new Thread(() -> {
		        for (int i = 0; i < SIZE/2; ++i)
		            map.put(String.valueOf(i), i);
		    });
		    t1.start();
	
		    Thread t2 = new Thread(() -> {
		        for (int i = SIZE/2; i < SIZE; ++i)
		            map.put(String.valueOf(i), i);
		    });
		    t2.start();
	
		    t1.join();
		    t2.join();
			System.out.println("Thread map size="+map.size()+"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}

		{   /* VERSION 3 - PARALLEL WITH synchronized */
			Map<String,Integer> map = new HashMap<>();			
			Instant startTime = Instant.now();
			Thread t1 = new Thread(() -> {
		        for (int i = 0; i < SIZE/2; ++i)
		        	synchronized(map) {
		        		map.put(String.valueOf(i), i);
		        	}
		    });
		    t1.start();
	
		    Thread t2 = new Thread(() -> {
		        for (int i = SIZE/2; i < SIZE; ++i)
		        	synchronized(map) {
		        		map.put(String.valueOf(i), i);
		        	}
		    });
		    t2.start();
	
		    t1.join();
		    t2.join();
			System.out.println("Synchronized map size="+map.size()+"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}
		
		{   /* VERSION 4 - PARALLEL with ConcurrentHashMap */
			Map<String,Integer> map = new ConcurrentHashMap<>();			
			Instant startTime = Instant.now();
			Thread t1 = new Thread(() -> {
		        for (int i = 0; i < SIZE/2; ++i)
		            map.put(String.valueOf(i), i);
		    });
		    t1.start();
	
		    Thread t2 = new Thread(() -> {
		        for (int i = SIZE/2; i < SIZE; ++i)
		            map.put(String.valueOf(i), i);
		    });
		    t2.start();
	
		    t1.join();
		    t2.join();
			System.out.println("Concurrent map size="+map.size()+"   "+Duration.between(startTime, Instant.now()).toMillis()+" [ms]");
		}
    }
}
