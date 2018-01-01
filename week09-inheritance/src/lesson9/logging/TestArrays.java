package lesson9.logging;

import java.util.*;

import lesson9.logging.ArrayListWithLogging;

public class TestArrays {
	public static void func(List<String> names) {
		names.add("b");
	}

	void add(String s) {
		System.out.println("adding "+s);
	}
	
	public static void main(String[] args) {
		List<String> names = new ArrayListWithLogging<>();
		names.add("a");
		func(names);
		names.add("c");
		System.out.println(names);
	}

}
