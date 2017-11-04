package lesson2;

import java.util.*;

public class TestMap {
	public static void main(String[] args) {
		Map<String,Integer> phoneBook =
			new HashMap<>();

		phoneBook.put("Alice", 12345678);
		phoneBook.put("Erel", 1231);

		phoneBook.put("Alice", 34);
		phoneBook.put("Matan", 333);
		
		System.out.println(phoneBook.get("Erel"));
		System.out.println(phoneBook.get("Alice"));
		
		Map<String, int[]> bigPhoneBook
			= new HashMap<>();
		bigPhoneBook.put("Matan", new int[] {1,2,3});
		System.out.println(Arrays.toString(bigPhoneBook.get("Matan")));
		
		
	}
}
