package chapter1;

public class Chapter1 {

	public static void main(String[] args) {
		
		Integer[] numbers = {1, 2, 3, 4, 5};
		printArray(numbers);
		
		Integer[] reversed = reverseArray(numbers);
		printArray(reversed);
	
		fizzBuzz(20);
		
		printDiamond(5);
		
		printDiamondOutline(5);
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
				System.out.print("FizzBuzz = ");
				System.out.println(counter);
			} else if (counter % 3 == 0) {
				System.out.print("Fizz = ");
				System.out.println(counter);
			} else if (counter % 5 == 0) {
				System.out.print("Buzz = ");
				System.out.println(counter);
			}
		}
		System.out.println();
	}
	
	private static void printDiamond(int size) {
		
		if (size < 10) {
			// upper half
			for (int topCounter = 1; topCounter <= size; topCounter++) {
				// compute and print leading spaces
				for (int spaceCounter = 0; spaceCounter < (size - topCounter); spaceCounter++) {
					System.out.print(" ");
				}
				// print number(s)
				for (int numCounter = 0; numCounter < ((topCounter * 2) - 1); numCounter++) {
					System.out.print(topCounter);
				}
				System.out.println();
			}
			// bottom half
			for (int bottomCounter = (size - 1); bottomCounter > 0; bottomCounter--) {
				// compute and print leading spaces
				for (int spaceCounter2 = 0; spaceCounter2 < (size - bottomCounter); spaceCounter2++) {
					System.out.print(" ");
				}
				// print number(s)
				for (int numCounter2 = 0; numCounter2 < ((bottomCounter * 2) - 1); numCounter2++) {
					System.out.print(bottomCounter);
				}
				System.out.println();
			}
		} else {
			System.out.println("Please provide a single-digit number.");
		}
		System.out.println();
	}
	
	private static void printDiamondOutline(int size) {
		
		if (size < 10) {
			// upper half
			for (int topCounter = 1; topCounter <= size; topCounter++) {
				// compute and print leading spaces
				for (int spaceCounter = 0; spaceCounter < (size - topCounter); spaceCounter++) {
					System.out.print(" ");
				}
				// print number(s)
				if (topCounter > 1) {
					System.out.print(topCounter);
					// filler spaces, not needed for the first iteration
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
					System.out.print(bottomCounter);
					// filler spaces, not needed for the first iteration
					for (int fillCounter2 = 0; fillCounter2 < ((bottomCounter * 2) - 3); fillCounter2++) {
						System.out.print(" ");
					}
				}
				System.out.println(bottomCounter);
			}
		} else {
			System.out.println("Please provide a single-digit number.");
		}
		System.out.println();
	}
}
