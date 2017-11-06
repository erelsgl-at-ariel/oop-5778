package lesson3;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class TestUnion {
	
	static <T> Set<T> union(Set<T> a, Set<T> b) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Set<T> result = a.getClass().getConstructor().newInstance();
		result.addAll(a);
		result.addAll(b);
		return result;
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Set<Integer> a = new TreeSet<Integer>();
		Collections.addAll(a, 10,20,30,40);
		Set<Integer> b = new TreeSet<Integer>();
		Collections.addAll(b, 30,40,50,60);
		System.out.println(union(a,b));
	}
}
