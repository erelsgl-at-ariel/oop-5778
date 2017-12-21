package lesson9a.wait;

import java.util.*;

/**
 * A demo of using wait and notify.
 * Based on Cay S. Horstmann, Core Java SE 9 for the impatient, 10.7.3
 * @author erelsgl
 */
public class WaitDemo {
	public static void main(String[] args) throws InterruptedException {
		Queue<String> queue = new LinkedList<>();
		
		// In Thread A:
		
		synchronized (queue) {
			while (queue.isEmpty())
				queue.wait();
			String top = queue.remove();
		}

		// In Thread B:
		
		
		synchronized (queue) {
			queue.add("abc");
			queue.notifyAll();
		}
		
		Object o;
	}
}
