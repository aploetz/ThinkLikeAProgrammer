package chapter7;

public class BinaryTree {

	private Node root;
	
	public void insert(Node newNode) {
		if (root == null) {
			root = newNode;
		} else {
			root.insert(newNode);
		}
	}
	
	public Node find(int key) {
		return root.findByKey(key);
	}
}
