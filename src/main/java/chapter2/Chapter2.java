package chapter2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Chapter2 {

	public static void main(String[] args) {

		String dataFile1 = "data1.txt";
		List<String> atariGames = Stream.of(
				"Pac-Man", "Space Invaders", "Donkey Kong",
				"Pitfall!", "Frogger"
				).toList();
		
		writeListToFile(dataFile1, atariGames);
		
		readTextFile(dataFile1);
		
	}
	
	private static void writeListToFile(String filename, List<String> list) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data/" + filename));
			
			for (String item: list) {
				writer.write(item + "\n");
			}

			writer.close();
		} catch (IOException ioex) {
			System.out.println("Error occurred while writing:");
			ioex.printStackTrace();
		}

		System.out.println(filename + " written!");
	}

	private static void readTextFile(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/" + filename));
			String line = reader.readLine();
			
			while (line != null) {
				System.out.println(line);
				
				line = reader.readLine();
			}
			
			reader.close();
		} catch (IOException ioex) {
			System.out.println("Error occurred while reading:");
			ioex.printStackTrace();
		}
	}
}
