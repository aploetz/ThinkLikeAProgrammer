package chapter8;

public class BinaryTree {

	private Player root;
	
	public void insert(Player newNode) {
		if (root == null) {
			root = newNode;
		} else {
			root.insert(newNode);
		}
	}
	
	public Player find(String key) {
		return root.findByKey(key);
	}
	
	public String toString() {
		return getNodesAsString(root);
	}
	
	private String getNodesAsString(Player node) {
		StringBuilder returnVal = new StringBuilder();
		
		if (node != null) {
			returnVal.append(getNodesAsString(node.getLeftNode()));
			returnVal.append(node.getLastName());
			returnVal.append(" ");
			returnVal.append(node.getFirstName());
			returnVal.append(", ");
			returnVal.append(getNodesAsString(node.getRightNode()));
		}
		
		return returnVal.toString();
	}
}
