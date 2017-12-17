package lesson9b;

import java.util.*;

/**
 * An example of a singleton object.
 * 
 * @author erelsgl
 */
public class Translator1 {
	public static final Translator1 INSTANCE = new Translator1();
	
	public String translateToEnglish(String hebrew) {
		return dictionary.get(hebrew);
	}
	
	private Translator1() {
		this.dictionary = new HashMap<>();
		dictionary.put("פרה", "cow");
		dictionary.put("סוס", "horse");
		// ...
	}
	
	private Map<String,String> dictionary;
}
