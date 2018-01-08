package adapter;

import java.util.*;

public class AdapterDemo {
	public static <T> void print(Iterator<T> iterator) {
		//for (T item: iterator) // ERROR!
		for (T item: new IteratorIterableAdapter<T>(iterator))
			System.out.println(item);
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3);
		Iterator<Integer> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		print(iterator);
	}
}
