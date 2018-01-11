package composite;

import java.util.List;

public class InternalNode extends Node {
	List<Node> children;
	int sum() {
		return this.getWeight() + 
			children
			.stream()
			.mapToInt(n -> n.sum())
			.reduce((x,y)->x+y).getAsInt();
	}
}
