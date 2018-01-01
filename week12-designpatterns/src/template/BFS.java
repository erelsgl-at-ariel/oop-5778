package template;

import java.util.*;

abstract class BFS<T> {
	/**
	 * Returns the initial node in the graph.
	 */
	abstract T initial();

	/**
	 * Given a current node, returns the nodes that it is connected to.
	 */
	abstract Iterable<T> neighbors(T current); 

	/**
	 * Returns true if the current node is the last 
	 */
	abstract boolean isFinal(T current);

	public boolean find() {
		Queue<T> open = new LinkedList<>();
		Set<T> closed = new HashSet<>();
		T current = this.initial();
		open.add(current);
		while(!open.isEmpty()) {
			current = open.remove();
			System.out.println(current);
			if (this.isFinal(current))
				return true;
			for (T child: this.neighbors(current)) {
				if (closed.contains(child))
					continue;
				if (!open.contains(child))
					open.add(child);
			}
			closed.add(current);
		}
		return false;
	}
}