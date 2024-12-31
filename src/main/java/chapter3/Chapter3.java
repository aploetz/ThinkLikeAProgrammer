package chapter3;

public class Chapter3 {

	public static void main(String[] args) {

		String phrase = "Minnesota Wild Hockey";
		System.out.println(reverseString(phrase));
		
	}
	
	private static String reverseString(String inputStr) {
		
		StringBuilder reversed = new StringBuilder();
		
		for (int arrayIndex = inputStr.length(); arrayIndex > 0; arrayIndex--) {
			reversed.append(inputStr.charAt(arrayIndex - 1));
		}
		
		return reversed.toString();
	}
}
