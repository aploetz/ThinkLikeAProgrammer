package chapter3;

public class Chapter3 {

	public static void main(String[] args) {

		String phrase = "Minnesota Wild Hockey";
		System.out.println(reverseString(phrase));
		
		System.out.println();
		
		Character character1 = 'g';
		System.out.printf("Is %c uppercase? %b\n", character1, isUppercaseReference(character1));
		Character character2 = 'T';
		System.out.printf("Is %c uppercase? %b\n", character2, isUppercaseReference(character2));

		System.out.println();

		char char1 = 'a';
		System.out.printf("Is %c uppercase? %b\n", char1, isUppercasePrimitive(char1));
		char char2 = 'P';
		System.out.printf("Is %c uppercase? %b\n", char2, isUppercasePrimitive(char2));

		System.out.println();
		
	}
	
	private static String reverseString(String inputStr) {
		
		StringBuilder reversed = new StringBuilder();
		
		for (int arrayIndex = inputStr.length(); arrayIndex > 0; arrayIndex--) {
			reversed.append(inputStr.charAt(arrayIndex - 1));
		}
		
		return reversed.toString();
	}
	
	private static boolean isUppercasePrimitive(char inputChar) {
		
		int asciiCode = (int) inputChar;
		
		if (asciiCode > 64 && asciiCode < 91) {
			return true;
		}
		
		return false; 
	}

	private static boolean isUppercaseReference(Character inputChar) {
		
		return Character.isUpperCase(inputChar);
	}

}
