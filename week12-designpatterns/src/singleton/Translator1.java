package singleton;

import java.util.*;

/**
 * A singleton class with a public INSTANCE
 * 
 * @author erelsgl
 */
public final class Translator1 {
	public static final Translator1 INSTANCE = new Translator1();
	
	public String translateToEnglish(String hebrew) {
		return dictionary.get(hebrew);
	}
	
	private Translator1() {
		this.dictionary = new HashMap<>();
		dictionary.put("פרה", "cow");
		dictionary.put("כבש", "lamb");
		// ...
	}
	
	private Map<String,String> dictionary;
}
