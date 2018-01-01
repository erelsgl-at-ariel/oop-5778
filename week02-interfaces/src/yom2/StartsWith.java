package yom2;

public class StartsWith implements Condition<String> {
	
	private char c;
	public StartsWith(char c) { 
		this.c = c;
	}

	@Override
	public boolean test(String s) {
		return s.charAt(0)==c;
	}

}
