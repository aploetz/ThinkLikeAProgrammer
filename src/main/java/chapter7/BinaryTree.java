package chapter7;

public class BinaryTree {

	private Node root;
	
	public BinaryTree() {
	}
	
	public BinaryTree(Node[] nodes) {
		for (Node node : nodes) {
			insert(node);
		}
	}
	
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
	
	public void deleteByKey(int key) {
		Node nodeToDelete = find(key);
		
		// save off the parent and children of the node to delete
		Node leftChild = nodeToDelete.getLeftChild();
		Node rightChild = nodeToDelete.getRightChild();
		Node parent = nodeToDelete.getParent();

		// delete the node
		if (parent.getLeftChild() == nodeToDelete) {
			parent.setLeftChild(null);
		} else {
			parent.setRightChild(null);
		}
		
		// re-add the deleted node's children to the binary tree
		if (leftChild != null) {
			insert(leftChild);
		}
		if (rightChild != null) {
			insert(rightChild);
		}
	}
	
	public void traverse() {
		traverseInOrder(root);
	}
	
	private void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.getLeftChild());
			System.out.printf("%s\n", node.getName());
			traverseInOrder(node.getRightChild());
		}
	}
}
