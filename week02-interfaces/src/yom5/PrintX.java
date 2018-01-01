package yom5;

public class PrintX implements Runnable {
	private char c;
	public PrintX(char c) {
		this.c = c;
	}
	
	public void run() {
		System.out.print(c);
	}
}

