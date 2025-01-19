package chapter5;

public class Queue {

	private String[] aircraft;
	private int currentCount = 0;
	
	public Queue(int maxCount) {
		
		aircraft = new String[maxCount];
	}
	
	public String enqueue(String name) {
		
		aircraft[currentCount] = name;
		currentCount++;
		
		return name;
	}
	
	public String getFront() {
		
		if (currentCount > 0) {
			return aircraft[0];
		} else {
			return "Queue is empty";
		}
	}

	public String dequeue() {
		
		if (currentCount > 0) {
			String front = getFront();
			
			for (int counter = 1; counter < currentCount; counter++) {
				aircraft[counter - 1] = aircraft[counter];
			}
			
			currentCount--;
			return front;
		} else {
			return "Queue is empty";
		}
	}	
}
