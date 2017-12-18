package lesson9a.logging;

import java.util.*;

public class TestArrays {
	public static void func(List<String> names) {
		names.add("b");
	}

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("a");
		func(names);
		names.add("c");
		System.out.println(names);
	}

}
