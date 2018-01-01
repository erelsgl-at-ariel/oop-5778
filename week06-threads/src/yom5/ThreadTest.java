package yom5;

/**
 * Demonstrate concurrent threads.
 * @author erelsgl
 */
public class ThreadTest {

	public static void main(String[] args) {
		Runnable r1 = () -> 
		{
			for (int i=0;i<1000;++i) System.out.print("1");
		};
		Thread t1 = new Thread(r1);
		t1.start();
		new Thread( ()-> {for (int i=0;i<1000;++i) System.out.print("2");} ).start();
		for (int i=0;i<1000;++i) System.out.print("3");

		new Thread( ()-> {for (int i=0;i<1000;++i) System.out.print("2");} ).start();
		new Thread( ()-> {for (int i=0;i<1000;++i) System.out.print("*");} ).start();
	}

}
