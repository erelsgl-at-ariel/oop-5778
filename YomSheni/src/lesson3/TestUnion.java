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
		Set<Integer> a = new LinkedHashSet<Integer>();
		Collections.addAll(a, 10,30,20,40);
		Set<Integer> b = new LinkedHashSet<Integer>();
		Collections.addAll(b, 30,50,40,60);
		System.out.println(union(a,b));
	}
}
