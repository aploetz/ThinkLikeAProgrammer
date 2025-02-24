package chapter8;

import java.util.List;

public class Chapter8 {

	public static void main(String[] args) {

		String[] users = { "Lowell", "Jacobs", "Scott", "Tripp", "Gartman", "Francis",
				"Samuels, D.", "Samuels, B.", "Murphy", "Roberts", "Knutson", "Woods",
				"Banks" };
		//printArray(users);

		String[] usersBubbleSorted = bubbleSort(users);
		System.out.println("Bubble Sort:");
		printStringArray(usersBubbleSorted);
		
		System.out.println();
		
		String[] usersMergeSorted = mergeSort(users);
		System.out.println("Merge Sort:");
		printStringArray(usersMergeSorted);
		
		System.out.println();
		
		BinaryTree tree = new BinaryTree();
		
		tree.insert(new Player(66, "Lemieux", "Mario", "C"));
		tree.insert(new Player(25, "Stevens", "Kevin", "LW"));
		tree.insert(new Player(68, "Jagr", "Jaromir", "RW"));
		tree.insert(new Player(55, "Murphy", "Larry", "D"));
		tree.insert(new Player(5, "Samuelsson", "Ulf", "D"));
		tree.insert(new Player(30, "Barrasso", "Tom", "G"));
		tree.insert(new Player(10, "Francis", "Ron", "C"));
		tree.insert(new Player(7, "Mullen", "Joe", "RW"));
		tree.insert(new Player(15, "McEachern", "Shawn", "LW"));
		
		List<Player> playerList = tree.toList();
		
		printPlayerList(playerList);
		
		// System.out.println("Searching for Murphy... " + tree.find("MurphyLarry"));
	}
	
	private static void printStringArray(String[] array) {
		for (String item : array) {
			System.out.println(item);
		}
		
		System.out.println();
	}
	
	private static void printPlayerList(List<Player> list) {
		for (Player player : list) {
			System.out.println(player);
		}
		
		System.out.println();
	}

	private static String[] bubbleSort(String[] array) {
		
		// need to track whether or not we have "flipped" a pair of ints during the current pass.
		boolean flippedAPair = false;
		
		//for (int idx = 0; idx < returnVal.length; idx++) {
		int index = 0;
		while (index < array.length - 1) {
			// check current array value against the next value
			// if it's greater, then flip them
			if (array[index].compareTo(array[index + 1]) > 0) {
				String temp = array[index];
				array[index] = array[index + 1];
				array[index + 1] = temp;
				flippedAPair = true;
			}
		
			index++;
			
			// if we get to the end of the array, 
			// and we haven't had to "flip" a pair (flippedAPair == false),
			// then it is sorted! Otherwise, reset
			if (index >= (array.length - 1) && flippedAPair) {
				// reset conditions
				index = 0;
				flippedAPair = false;
			}
		}
		
		return array;
	}
	
	private static String[] splitArray(String[] array, int start, int end) {
		
		String[] returnVal = new String[end - start];
		int returnIndex = 0;
		
		for (int index = start; index < end; index++) {
			returnVal[returnIndex] = array[index];
			returnIndex++;
		}
		
		return returnVal;
	}
	
	private static String[] mergeSort(String[] array) {
		
		if (array.length > 1) {
			// find middle of array
			int middle = (array.length / 2);
			
			// split the array
			String[] leftArray = splitArray(array, 0, middle);
			String[] rightArray = splitArray(array, middle, array.length);
			
			// recursive call on each
			leftArray = mergeSort(leftArray);
			rightArray = mergeSort(rightArray);
			
			// initialize starting indexes
			int leftIndex = 0;
			int rightIndex = 0;
			int mergedIndex = 0;
			
			// merge leftArray and rightArray
			while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
				if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) < 0) {
					array[mergedIndex] = leftArray[leftIndex];
					leftIndex++;
				} else {
					array[mergedIndex] = rightArray[rightIndex];
					rightIndex++;
				}
				
				mergedIndex++;
			}
			
			// check for any remaining items from both arrays, and append
			for (int index = leftIndex; index < leftArray.length; index++) {
				array[mergedIndex] = leftArray[index];
				mergedIndex++;
			}
			
			for (int index = rightIndex; index < rightArray.length; index++) {
				array[mergedIndex] = rightArray[index];
				mergedIndex++;
			}
		}
		
		return array;
	}
}
