package chapter1;

public class Chapter1 {

	public static void main(String[] args) {
		
		Integer[] numbers = {1, 2, 3, 4, 5};
		printArray(numbers);
		
		Integer[] reversed = reverseArray(numbers);
		printArray(reversed);
	
		fizzBuzz(20);
		
		printDiamond(5);
	}

	private static void printArray(Integer[] array) {
		
		for (Integer number: array) {
			System.out.println(number);
		}
		System.out.println();
	}
	
	private static Integer[] reverseArray(Integer[] array) {
		
		Integer[] reversedArray = new Integer[array.length];
		int reversedIndex = 0;
		
		for (int arrayIndex = array.length; arrayIndex > 0; arrayIndex--) {
			reversedArray[reversedIndex] = array[arrayIndex - 1];
			reversedIndex++;
		}
		
		return reversedArray;
	}
	
	private static void fizzBuzz(int maxCount) {
		
		for (int counter = 1; counter < maxCount + 1; counter++) {
			if (counter % 3 == 0 && counter % 5 == 0) {
				System.out.print(counter);
				System.out.println(" = FizzBuzz");
			} else if (counter % 3 == 0) {
				System.out.print(counter);
				System.out.println(" = Fizz");
			} else if (counter % 5 == 0) {
				System.out.print(counter);
				System.out.println(" = Buzz");
			}
		}
		System.out.println();
	}
	
	private static void printDiamond(int size) {
		
		// upper half
		for (int topCounter = 1; topCounter <= size; topCounter++) {
			// compute and print leading spaces
			for (int spaceCounter = 0; spaceCounter < (size - topCounter); spaceCounter++) {
				System.out.print(" ");
			}
			// print number(s)
			if (topCounter > 1) {
				// filler spaces, not needed for the first iteration
				System.out.print(topCounter);
				for (int fillCounter = 0; fillCounter < ((topCounter * 2) - 3); fillCounter++) {
					System.out.print(" ");
				}
			}
			System.out.println(topCounter);
		}
		// bottom half
		for (int bottomCounter = (size - 1); bottomCounter > 0; bottomCounter--) {
			// compute and print leading spaces
			for (int spaceCounter2 = 0; spaceCounter2 < (size - bottomCounter); spaceCounter2++) {
				System.out.print(" ");
			}
			// print number(s)
			if (bottomCounter > 1) {
				// filler spaces, not needed for the first iteration
				System.out.print(bottomCounter);
				for (int fillCounter2 = 0; fillCounter2 < ((bottomCounter * 2) - 3); fillCounter2++) {
					System.out.print(" ");
				}
			}
			System.out.println(bottomCounter);
		}
	}
}
