package chapter8;

public class Player {
	private int jersey;
	private String lastName;
	private String firstName;
	private String position;
	private Player leftNode;
	private Player rightNode;
	
	public Player(int jersey, String lName, String fName, String pos) {
		this.jersey = jersey;
		this.lastName = lName;
		this.firstName = fName;
		this.position = pos;
	}
	
	public void insert(Player newNode) {
		
		if ((newNode.getLastName() + newNode.getFirstName()).compareTo(getFullName()) < 0) {
			if (leftNode == null) {
				leftNode = newNode;
			} else {
				leftNode.insert(newNode);
			}
		} else if ((newNode.getLastName() + newNode.getFirstName()).compareTo(getFullName()) > 0) {
			if (rightNode == null) {
				rightNode = newNode;
			} else {
				rightNode.insert(newNode);
			}
		} else {
			// equal -- overwrite!
			this.jersey = newNode.getJersey();
			this.lastName = newNode.getLastName();
			this.firstName = newNode.getFirstName();
		}
	}
	
	public Player findByKey(String name) {
		
		if (name.compareTo(getFullName()) < 0) {
			if (leftNode == null) {
				return new Player(-1,"NOT FOUND", "NOT FOUND", "NF");
			} else {
				return leftNode.findByKey(name);
			}
		} else if (name.compareTo(getFullName()) > 0 ) {
			if (rightNode == null) {
				return new Player(-1,"NOT FOUND", "NOT FOUND", "NF");
			} else {
				return rightNode.findByKey(name);
			}
		} else {
			// equal -- return this
			return this;
		}
	}
	
	private String getFullName() {
		return this.lastName + this.firstName;
	}
	
	public int getJersey() {
		return jersey;
	}
	
	public void setJersey(int jersey) {
		this.jersey = jersey;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public Player getLeftNode() {
		return this.leftNode;
	}
	
	public Player getRightNode() {
		return this.rightNode;
	}
}
