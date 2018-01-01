package yom5;

public class TestRepeat {
	static void repeat(int n, Runnable action) {
		for (int i=0; i<n; ++i)
			action.run();
	}
	
	public static void main(String[] args) {
		repeat(10, new PrintX('*'));
		
		
	}
}
