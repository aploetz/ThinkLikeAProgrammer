package chapter3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chapter3 {

	private static final int STATE_LENGTH = 2;
	
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

		String state1 = "Ia";
		String state2 = "MN";
		String state3 = "Wis";
		String state4 = "AK";
		String state5 = "TEX";
		String state6 = "nD";
		
		System.out.printf("Is %s valid? %b\n",state1,isStateCodeValid(state1));
		System.out.printf("Is %s valid? %b\n",state2,isStateCodeValid(state2));
		System.out.printf("Is %s valid? %b\n",state3,isStateCodeValid(state3));
		System.out.printf("Is %s valid? %b\n",state4,isStateCodeValid(state4));
		System.out.printf("Is %s valid? %b\n",state5,isStateCodeValid(state5));
		System.out.printf("Is %s valid? %b\n",state6,isStateCodeValid(state6));

		System.out.println();
		
		System.out.printf("Is %s valid? %b\n",state1,isStateCodeValidRegex(state1));
		System.out.printf("Is %s valid? %b\n",state2,isStateCodeValidRegex(state2));
		System.out.printf("Is %s valid? %b\n",state3,isStateCodeValidRegex(state3));
		System.out.printf("Is %s valid? %b\n",state4,isStateCodeValidRegex(state4));
		System.out.printf("Is %s valid? %b\n",state5,isStateCodeValidRegex(state5));
		System.out.printf("Is %s valid? %b\n",state6,isStateCodeValidRegex(state6));

		System.out.println();
		
		String hockeyTeam1 = "city: St. Paul, MN | team: Wild | location: Minnesota | colors: Green, White, Red";
		String hockeyTeam2 = "city: Toronto, ON | team: Maple Leafs | location: Toronto | colors: Blue, White";
		String hockeyTeam3 = "city: Sunrise, FL | team: Panthers | location: Florida | colors: Red, Blue, Brown";
		String hockeyTeam4 = "city: Dallas, TX | team: Stars | location: Dallas | colors: Green, Black, Silver";
		String hockeyTeam5 = "city: Pittsburgh, PA | team: Penguins | location: Pittsburgh | colors: Yellow, White, Black";
		
		System.out.println(getFullTeamName(hockeyTeam1));
		System.out.println(getFullTeamName(hockeyTeam2));
		System.out.println(getFullTeamName(hockeyTeam3));
		System.out.println(getFullTeamName(hockeyTeam4));
		System.out.println(getFullTeamName(hockeyTeam5));
		
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
	
	private static boolean isStateCodeValid(String state) {
		// US state codes are only valid if they are:
		//  - 2 characters in length
		//  - all uppercase
		boolean returnVal = false;
		
		if (state.length() == STATE_LENGTH) {
			for (int counter = 0; counter < STATE_LENGTH; counter++) {
				if (Character.isUpperCase(state.charAt(counter))) {
					returnVal = true;
				} else {
					returnVal = false;
					break;
				}
			}
		}

		return returnVal;
	}
	
	private static boolean isStateCodeValidRegex(String state) {

		Pattern statePattern = Pattern.compile("[A-Z]{2}");
		Matcher stateMatcher = statePattern.matcher(state);
		
		return stateMatcher.matches();
	}
	
	private static String getValue(String kvPair) {
		int colonPosition = kvPair.indexOf(':');
		
		return kvPair.substring(colonPosition + 2).trim();
	}
	
	private static String getFullTeamName(String teamData) {
		StringBuilder returnVal = new StringBuilder();
		String[] teamDataArray = teamData.split("[|]");
		String name = "";
		String location = "";
		
		for (int index = 0; index < teamDataArray.length; index++) {
			if (teamDataArray[index].contains("team:")) {
				name = getValue(teamDataArray[index]);
			}
			
			if (teamDataArray[index].contains("location:")) {
				location = getValue(teamDataArray[index]);
			}
		}
		
		returnVal.append(location);
		returnVal.append(" ");
		returnVal.append(name);
		
		return returnVal.toString();
	}
}
