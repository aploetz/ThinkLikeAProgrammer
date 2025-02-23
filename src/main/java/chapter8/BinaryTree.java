package chapter8;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	private Player root;
	
	public void insert(Player newNode) {
		if (root == null) {
			root = newNode;
		} else {
			root.insert(newNode);
		}
	}
	
	public Player find(String name) {
		return root.findByName(name);
	}
	
	public String toString() {
		return getNodesAsString(root);
	}
	
	public List<Player> toList() {
		return getNodesAsList(root);
	}
	
	private List<Player> getNodesAsList(Player node) {
		List<Player> tempList = new ArrayList<>();
		
		if (node != null) {
			tempList.addAll(getNodesAsList(node.getLeftNode()));
			tempList.add(node);
			tempList.addAll(getNodesAsList(node.getRightNode()));
		}
		
		return tempList;
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
