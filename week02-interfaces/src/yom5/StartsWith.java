package yom5;

public class StartsWith implements Predicate<String> {
	
	private char c;
	public StartsWith(char c) { 
		this.c = c;
	}
	
	//@Override
	public boolean test(String s) {
		return s.charAt(0)==c;
	}

}
