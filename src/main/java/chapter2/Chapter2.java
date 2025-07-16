package chapter2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Chapter2 {

	public static void main(String[] args) {

		String dataFile1 = "data1.txt";
		List<String> atariGames = Stream.of(
				"Pac-Man", "Space Invaders", "Donkey Kong",
				"Pitfall!", "Frogger"
				).toList();
		writeListToFile(dataFile1, atariGames);
		System.out.println();

		readTextFile(dataFile1);
		System.out.println();
		
		String csvFile1 = "arcadeScores.csv";
		List<String> arcadeScores = Stream.of(
				"Game,Player,Score", 
				"Pac-Man,Aaron,188870", "Donkey Kong Jr.,Emily,63000",
				"BurgerTime,Aaron,313650", "Galaga,Avery,34520",
				"Super Mario Brothers,Coriene,239400"
				).toList();
		writeListToFile(csvFile1, arcadeScores);
		System.out.println();
		
		readCSVFile(csvFile1);
		System.out.println();
		
		writeToPasswordFile("aaron", "Brewers82");
		writeToPasswordFile("coriene", "loveBug22");
		writeToPasswordFile("avery", "rumbleBoy58");
		writeToPasswordFile("christian", "BHappy42");
		writeToPasswordFile("emily", "chimPoKoMon58");
		writeToPasswordFile("victoria", "ethanIsAwesome77");
		
		validateUserFromFile("aaron","Brewers82");
		validateUserFromFile("avery","blahblahblah");
		System.out.println();
		
		writeToPasswordFileUnique("aaron", "Brewers82");
		writeToPasswordFileUnique("coriene", "loveBug22");
		writeToPasswordFileUnique("avery", "rumbleBoy58");
		writeToPasswordFileUnique("coriene", "loveBug22");
		writeToPasswordFileUnique("emily", "chimPoKoMon58");
		writeToPasswordFileUnique("victoria", "ethanIsAwesome77");
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
	
	private static void writeToPasswordFile(String username, String password) {
		try {
			// open file with append == true
			BufferedWriter writer = new BufferedWriter(new FileWriter("data/password.csv",true));

	    	// Hash the password
	    	BCryptPasswordEncoder pEncoder = new BCryptPasswordEncoder();
	    	String hashedPassword = pEncoder.encode(password);
			
			writer.write(username + "," + hashedPassword + "\n");

			writer.close();
		} catch (IOException ioex) {
			System.out.println("Error occurred while writing:");
			ioex.printStackTrace();
		}

		System.out.println(username + " written to password file.");
	}

	private static void validateUserFromFile(String username, String password) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/password.csv"));
	    	BCryptPasswordEncoder pEncoder = new BCryptPasswordEncoder();
	    	boolean found = false;
	    	String line = reader.readLine();
	    	
	    	while (line != null) {
		    	String[] columns = line.split("[,]");
	    		String fileUser = columns[0];
	    		
	    		if (fileUser.equals(username)) {
	    			found = true;
	    			String fileHashedPwd = columns[1];
	    			
	    			if (pEncoder.matches(password, fileHashedPwd)) {
	    				System.out.printf("User %s has valid credentials.\n", username);
	    			} else {
	    				System.out.printf("User %s could not be authenticated.\n", username);
	    			}
	    			break;
	    		}
	    		line = reader.readLine();
	    	}
	    	
	    	if (!found) {
	    		System.out.printf("User %s was not found.\n", username);
	    	}
	    	
			reader.close();
		} catch (IOException ioex) {
			System.out.println("Error occurred while reading:");
			ioex.printStackTrace();			
		}
	}
	
	private static void writeToPasswordFileUnique(String username, String password) {

		List<String> currentUsers = new ArrayList<>();

		try (BufferedReader reader =
				new BufferedReader(new FileReader("data/passwordU.csv"))) {
			
			// open file reader
			
			String line = reader.readLine();
			
			while (line != null) {
				String[] columns = line.split("[,]");
				
				currentUsers.add(columns[0]);
				line = reader.readLine();
			}
			
			reader.close();
		} catch (FileNotFoundException fnfex) {
			System.out.println("File was not found; must be first user. Adding...");
		} catch (IOException ioex) {
			System.out.println("Error occurred while writing:");
			ioex.printStackTrace();
		}
		
		try (BufferedWriter writer =
				new BufferedWriter(new FileWriter("data/passwordU.csv",true))) {

			if (currentUsers.contains(username)) {
				System.out.printf("User %s exists, credentials not written.\n", username);
			} else {
				// open file with append == true
	
		    	// Hash the password
		    	BCryptPasswordEncoder pEncoder = new BCryptPasswordEncoder();
		    	String hashedPassword = pEncoder.encode(password);
				
				writer.write(username + "," + hashedPassword + "\n");
				writer.close();
				
				System.out.println(username + " written to password file.");
			}
		} catch (IOException ioex) {
			System.out.println("Error occurred while writing:");
			ioex.printStackTrace();
		}
	}
}
