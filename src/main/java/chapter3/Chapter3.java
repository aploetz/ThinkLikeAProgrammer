package chapter3;

public class Chapter3 {

	public static void main(String[] args) {

		String phrase = "Minnesota Wild Hockey";
		System.out.println(reverseString(phrase));
		
		System.out.println();
		
		Character character1 = 'g';
		System.out.printf("Is %c uppercase? %b\n", character1, isReferenceUppercase(character1));
		Character character2 = 'T';
		System.out.printf("Is %c uppercase? %b\n", character2, isReferenceUppercase(character2));

		System.out.println();

		char char1 = 'a';
		System.out.printf("Is %c uppercase? %b\n", char1, isPrimitiveUppercase(char1));
		char char2 = 'P';
		System.out.printf("Is %c uppercase? %b\n", char2, isPrimitiveUppercase(char2));

		System.out.println();
		
		String phone1 = " 882-411-4834";
		String phone2 = "(414)458-3831 ";
		String phone3 = "  920.472.1773  ";
		String phone4 = "608 458 1556";
		String phone5 = "459-7199";
		
		System.out.println(formatPhoneNumber(phone1));
		System.out.println(formatPhoneNumber(phone2));
		System.out.println(formatPhoneNumber(phone3));
		System.out.println(formatPhoneNumber(phone4));
		System.out.println(formatPhoneNumber(phone5));

		System.out.println();

	}
	
	private static String reverseString(String inputStr) {
		
		StringBuilder reversed = new StringBuilder();
		
		for (int arrayIndex = inputStr.length(); arrayIndex > 0; arrayIndex--) {
			reversed.append(inputStr.charAt(arrayIndex - 1));
		}
		
		return reversed.toString();
	}
	
	private static boolean isPrimitiveUppercase(char inputChar) {
		
		int asciiCode = (int) inputChar;
		
		if (asciiCode > 64 && asciiCode < 91) {
			return true;
		}
		
		return false; 
	}

	private static boolean isReferenceUppercase(Character inputChar) {
		
		return Character.isUpperCase(inputChar);
	}

	private static String formatPhoneNumber(String phoneNumber) {
		// remove leading and trailing spaces
		String number = phoneNumber.trim();
		// remove extra characters () -.
		number = number.replace("-","");
		number = number.replace(".","");
		number = number.replace(")","");
		number = number.replace("(","");
		number = number.replace(" ","");
		
		// at this point, number should be 10 characters, otherwise number is invalid
		if (number.length() == 10) {
			// AREACODE-PREFIX-LINENUMBER
			String areaCode = number.substring(0,3);
			String prefixCode = number.substring(3,6);
			String lineCode = number.substring(6);
			
			StringBuilder returnVal = new StringBuilder("(");
			returnVal.append(areaCode);
			returnVal.append(")");
			returnVal.append(prefixCode);
			returnVal.append("-");
			returnVal.append(lineCode);
			
			return returnVal.toString();
		} else {
			return "INVALID NUMBER, 10 digits only!";			
		}
	}
}
