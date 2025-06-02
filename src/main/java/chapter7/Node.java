package chapter7;

public class Node {

	private int key;
	private String name;
	
	private Node leftChild;
	private Node rightChild;
	private Node parent;
	
	public Node(int key, String name) {
		this.key = key;
		this.name = name;
	}
	
	public void insert(Node newNode) {
		
		if (newNode.getKey() < this.key) {
			if (leftChild == null) {
				newNode.setParent(this);
				leftChild = newNode;
			} else {
				leftChild.insert(newNode);
			}
		} else if (newNode.getKey() > this.key) {
			if (rightChild == null) {
				newNode.setParent(this);
				rightChild = newNode;
			} else {
				rightChild.insert(newNode);
			}
		} else {
			// equal -- overwrite!
			this.name = newNode.getName();
		}
	}
	
	public Node findByKey(int lookupKey) {
		
		if (lookupKey < this.key) {
			if (leftChild == null) {
				return new Node(-1,"NOT FOUND");
			} else {
				return leftChild.findByKey(lookupKey);
			}
		} else if (lookupKey > this.key ) {
			if (rightChild == null) {
				return new Node(-1,"NOT FOUND");
			} else {
				return rightChild.findByKey(lookupKey);
			}
		} else {
			// equal -- return this
			return this;
		}
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Node getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	
	public Node getRightChild() {
		return rightChild;
	}
	
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
}
