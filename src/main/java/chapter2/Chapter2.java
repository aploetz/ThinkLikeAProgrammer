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
		
		String csvFile1 = "arcadeScores.csv";
		List<String> arcadeScores = Stream.of(
				"Game,Player,Score", 
				"Pac-Man,Aaron,188870", "Donkey Kong Jr.,Emily,63000",
				"BurgerTime,Aaron,313650", "Galaga,Avery,34520",
				"Super Mario Brothers,Coriene,239400"
				).toList();
		writeListToFile(csvFile1, arcadeScores);
		
		readCSVFile(csvFile1);
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

	private static void readCSVFile(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/" + filename));
			String line = reader.readLine();
			// the first line in the file should be the header row
			boolean header = true;
			
			while (line != null) {
				if (!header) {
					String[] columns = line.split("[,]");
					String game = columns[0];
					String player = columns[1];
					String score = columns[2];
					
					System.out.printf("High score for %s ", game);
					System.out.printf("by player %s of ", player);
					System.out.printf("%s points\n", score);
				} else {
					// print header row
					System.out.println(line);
					header = false;
				}
				
				line = reader.readLine();
			}
			
			reader.close();
		} catch (IOException ioex) {
			System.out.println("Error occurred while reading:");
			ioex.printStackTrace();
		}
	}
}
