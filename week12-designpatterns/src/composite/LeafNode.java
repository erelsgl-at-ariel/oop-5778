package composite;

public class LeafNode extends Node {
	int sum() {
		return this.getWeight();
	}
}
