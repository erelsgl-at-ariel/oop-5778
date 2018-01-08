package composite;

public class NodeTest {

	public static void main(String[] args) {
		InternalNode root = new InternalNode();
		Node n = new LeafNode();
		n.weight = 1;
		root.children.add(n);

		InternalNode i = new InternalNode();
		i.children.add(new LeafNode());
		
		System.out.println(root.sum());
	}

}
