package chapter1;

public class ReverseAnArray {

	public static void main(String[] args) {
		Integer[] numbers = {1, 2, 3, 4, 5};
		
		Integer[] reversed = reverseArray(numbers);
		
		for (Integer number: reversed) {
			System.out.println(number);
		}

	}

	private static Integer[] reverseArray(Integer[] array) {
		
		Integer[] returnVal = new Integer[array.length];
		int counter = 0;
		
		for (int index = array.length; index > 0; index--) {
			returnVal[counter] = array[index - 1];
			counter++;
		}
		
		return returnVal;
	}
}
