package chapter7;

public class Patient {

	private String name;
	private int priority;

	public Patient(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
