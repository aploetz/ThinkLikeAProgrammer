package chapter8;

import java.util.List;

public class Chapter8 {

	public static void main(String[] args) {

		String[] users = { "Lowell", "Jacobs", "Scott", "Tripp", "Gartman", "Francis",
				"Samuels, D.", "Samuels, B.", "Murphy", "Roberts", "Knutson", "Woods",
				"Banks" };
		//printArray(users);

		String[] usersSorted = bubbleSort(users);
		printStringArray(usersSorted);
		
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
}
