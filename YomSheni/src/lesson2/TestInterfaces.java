package lesson2;

public class TestInterfaces {
	
	static void repeat(int n, Runnable action) {
		for (int i=0; i<n; i++)
			action.run();
	}
	
	public static void main(String[] args) {
		// Solution A: named class
		repeat(100, new PrintX());
		System.out.println();
		
		// Solution B: anonymous class
		repeat(10, new Runnable() {
			public void run() {System.out.print("y");}
		});
		System.out.println();
		
		// Solution C: one-line class
		Runnable r = () -> System.out.print("z"); 
		repeat(5, r);
		
		
		
		List<String> strings = new ArrayList<>();
		Collections.addAll(strings, "aaa","cc","bbbb","abc");
		Condition condition = /* the string starts with a */;
		filteredStrings = filter(strings, condition);
		System.out.println(filteredStrings); // aaa,abc (only strings that start with a)

	}
}
