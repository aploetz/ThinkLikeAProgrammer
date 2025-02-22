package chapter8;

public class Chapter8 {

	public static void main(String[] args) {

		String[] users = { "Lowell", "Jacobs", "Scott", "Tripp", "Gartman", "Francis",
				"Samuels, B.", "Samuels, D.", "Murphy", "Roberts", "Knutson", "Woods",
				"Banks" };
		//printArray(users);

		String[] usersSorted = bubbleSort(users);
		printArray(usersSorted);
		
		System.out.println();
		
		Player mario = new Player(66, "Lemieux", "Mario", "C");
		Player kevin = new Player(25, "Stevens", "Kevin", "LW");
		Player jaromir = new Player(68, "Jagr", "Jaromir", "RW");
		Player larry = new Player(55, "Murphy", "Larry", "D");
		Player ulf = new Player(5, "Samuelsson", "Ulf", "D");
		Player tom = new Player(30, "Barrasso", "Tom", "G");
		Player ron = new Player(10, "Francis", "Ron", "C");
		Player joe = new Player(7, "Mullen", "Joe", "RW");
		Player shawn = new Player(15, "McEachern", "Shawn", "LW");
		
		BinaryTree tree = new BinaryTree();
		
		tree.insert(mario);
		tree.insert(kevin);
		tree.insert(jaromir);
		tree.insert(larry);
		tree.insert(ulf);
		tree.insert(tom);
		tree.insert(ron);
		tree.insert(joe);
		tree.insert(shawn);
		
		System.out.println(tree.toString());
		
		System.out.println(tree.find("MurphyLarry").getLastName());
	}
	
	private static void printArray(String[] array) {
		for (String item : array) {
			System.out.println(item);
		}
		
		System.out.println();
	}

	private static String[] bubbleSort(String[] array) {
		
		// need to track whether or not we have "flipped" a pair of ints during the current pass.
		boolean flippedAPair = false;
		
		//for (int idx = 0; idx < returnVal.length; idx++) {
		int index = 0;
		while (flippedAPair || index < array.length - 1) {
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
