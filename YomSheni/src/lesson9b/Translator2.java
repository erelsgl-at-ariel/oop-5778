package lesson9b;

import java.util.*;

/**
 * An example of a singleton object.
 * 
 * @author erelsgl
 */
enum Translator2 {
	INSTANCE;
	
	public String translateToEnglish(String hebrew) {
		return dictionary.get(hebrew);
	}
	
	private Translator2() {
		this.dictionary = new HashMap<>();
		dictionary.put("פרה", "cow");
		dictionary.put("סוס", "horse");
		// ...
	}
	
	private Map<String,String> dictionary;
}
