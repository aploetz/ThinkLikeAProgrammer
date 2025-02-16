package chapter7;

public class Node {

	private int key;
	private String name;
	
	private Node leftChild;
	private Node rightChild;
	
	public Node(int key, String name) {
		this.key = key;
		this.name = name;
	}
	
	public void insert(Node newNode) {
		
		if (newNode.getKey() < this.key) {
			if (leftChild == null) {
				leftChild = newNode;
			} else {
				leftChild.insert(newNode);
			}
		} else if (newNode.getKey() > this.key) {
			if (rightChild == null) {
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
}
