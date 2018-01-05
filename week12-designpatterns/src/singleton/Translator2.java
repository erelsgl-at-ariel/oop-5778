package singleton;

import java.util.*;

/**
 * A singleton class implemented as enum.
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
		dictionary.put("כבש", "lamb");
		// ...
	}
	
	private Map<String,String> dictionary;
}
