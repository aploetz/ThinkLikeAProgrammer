package chapter4;

import java.util.ArrayList;
import java.util.List;

public class Chapter4 {

	public static void main(String[] args) {

		int numberA = 2;
		int numberB = 5;
		int numberC = 3;
		int numberD = -4;
		int numberE = -6;
		int numberF = 9;
		int numberG = -8;
		int numberH = -10;
		
		int productAB = multiply(numberA, numberB);
		int productCD = multiply(numberC, numberD);
		int productEF = multiply(numberE, numberF);
		int productGH = multiply(numberG, numberH);

		System.out.printf("%d x %d == %d\n", numberA, numberB, productAB);
		System.out.printf("%d x %d == %d\n", numberC, numberD, productCD);
		System.out.printf("%d x %d == %d\n", numberE, numberF, productEF);
		System.out.printf("%d x %d == %d\n", numberG, numberH, productGH);
		
		System.out.println();

		int negativeA = applyNegative(numberA);
		int negativeC = applyNegative(numberC);
		int negativeE = applyNegative(numberE);
		
		System.out.printf("applyNegative(%d) == %d\n", numberA, negativeA);
		System.out.printf("applyNegative(%d) == %d\n", numberC, negativeC);
		System.out.printf("applyNegative(%d) == %d\n", numberE, negativeE);

		System.out.println();

		int aMinusB = subtract(numberA, numberB);
		int bMinusA = subtract(numberB, numberA);
		int cMinusD = subtract(numberC, numberD);
		int dMinusC = subtract(numberD, numberC);
		
		System.out.printf("%d - %d == %d\n", numberA, numberB, aMinusB);
		System.out.printf("%d - %d == %d\n", numberB, numberA, bMinusA);
		System.out.printf("%d - %d == %d\n", numberC, numberD, cMinusD);
		System.out.printf("%d - %d == %d\n", numberD, numberC, dMinusC);
		
		System.out.println();

		int fDividedByC = divide(numberF, numberC);
		int gDividedByA = divide(numberG, numberA);
		int gDividedByD = divide(numberG, numberD);
		int bDividedByA = divide(numberB, numberA);
		
		System.out.printf("%d %c %d == %d\n", numberF, (char)247, numberC, fDividedByC);
		System.out.printf("%d %c %d == %d\n", numberG, (char)247, numberA, gDividedByA);
		System.out.printf("%d %c %d == %d\n", numberG, (char)247, numberD, gDividedByD);
		System.out.printf("%d %c %d == %d\n", numberB, (char)247, numberA, bDividedByA);
		
		System.out.println();

		System.out.printf("Is %d even? %b\n", 3, isEven(3));
		System.out.printf("Is %d even? %b\n", 48, isEven(48));
		System.out.printf("Is %d even? %b\n", 16, isEven(16));
		System.out.printf("Is %d even? %b\n", 62, isEven(62));
		System.out.printf("Is %d even? %b\n", 64, isEven(64));

		System.out.println();
		
		System.out.printf("Is %d a valid power of 2? %b\n", 3, isPowerOfTwo(3));
		System.out.printf("Is %d a valid power of 2? %b\n", 48, isPowerOfTwo(48));
		System.out.printf("Is %d a valid power of 2? %b\n", 16, isPowerOfTwo(16));
		System.out.printf("Is %d a valid power of 2? %b\n", 62, isPowerOfTwo(62));
		System.out.printf("Is %d a valid power of 2? %b\n", 64, isPowerOfTwo(64));

		System.out.println();

		System.out.printf("The highest order bit of %d is %d\n", 7, highestOrderBit(7));
		System.out.printf("The highest order bit of %d is %d\n", 12, highestOrderBit(12));
		System.out.printf("The highest order bit of %d is %d\n", 17, highestOrderBit(17));
		
		System.out.println();

		System.out.printf("The %d bit of %d is %b\n", 4, 12, isBitFlipped(12, 4));
		System.out.printf("The %d bit of %d is %b\n", 2, 12, isBitFlipped(12, 2));
		System.out.printf("The %d bit of %d is %b\n", 4, 12, isBitFlipped2(12, 4));
		System.out.printf("The %d bit of %d is %b\n", 2, 12, isBitFlipped2(12, 2));
		System.out.printf("The %d bit of %d is %b\n", 8, 12, isBitFlipped2(12, 8));
		System.out.printf("The %d bit of %d is %b\n", 1, 13, isBitFlipped2(13, 1));
		System.out.printf("The %d bit of %d is %b\n", 2, 13, isBitFlipped2(13, 2));
		
		System.out.println();

		System.out.printf("Error# %d - %s\n", 2, getErrorMessages(2));
		System.out.printf("Error# %d - %s\n", 8, getErrorMessages(8));
		System.out.printf("Error# %d - %s\n", 10, getErrorMessages(10));
		System.out.printf("Error# %d - %s\n", 5, getErrorMessages(5));
		
		System.out.println();
		
		System.out.println("5 + 7 = " + add(5, 7));
		
		System.out.println("8 mod 2 = " + modulo(8, 2));
		System.out.println("7 mod 2 = " + modulo(7, 2));
		System.out.println("9 mod 3 = " + modulo(9, 3));
		System.out.println("8 mod 3 = " + modulo(8, 3));
		System.out.println("11 mod 5 = " + modulo(11, 5));
		
	}

	public static int add(int numX, int numY) {
	
		int returnVal = numX;
		
		for (int counter = 0; counter < numY; counter++) {
			returnVal++;
		}
		
		return returnVal;
	}
	
	public static int multiply(int numX, int numY) {

		// if either numX or numY are 0, then short-circuit the method
		if (numX == 0 || numY == 0) {
			return 0;
		}
		
		boolean isYNegative = false;
		int returnVal = 0;
		
		if (numY < 0) {
			isYNegative = true;
		}
		
		if (isYNegative) {
			for (int counter = 0; counter > numY; counter--) {
				returnVal -= numX;
			}
		} else {
			// Y is positive
			for (int counter = 0; counter < numY; counter++) {
				returnVal += numX;
			}
		}
		
		return returnVal;
	}
	
	private static int applyNegative(int number) {
		
		return multiply(number,-1);
	}
	
	private static int subtract(int numX, int numY) {
		
		return numX + applyNegative(numY);
	}
	
	// absolute value
	private static int abs(int number) {
		
		if (number < 0) {
			return applyNegative(number);
		}
		
		return number;
	}
	
	private static int divide(int dividend, int divisor) {
		
		boolean resultShouldBeNegative = true;
		// determine ahead of time if the quotient (result) should be negative
		if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
			resultShouldBeNegative = false;
		}
		
		// for our division calculations we only want to work with positive numbers
		int absoluteDividend = abs(dividend);
		int absoluteDivisor = abs(divisor);
		
		int total = 0;
		int quotient = 0;
		
		while ((total + absoluteDivisor) <= absoluteDividend) {
			total = total + absoluteDivisor;
			quotient++;
		}
		
		if (resultShouldBeNegative) {
			return applyNegative(quotient);
		}
		
		return quotient;
	}
	
	private static int modulo(int dividend, int divisor) {
		
		int absoluteDividend = abs(dividend);
		int absoluteDivisor = abs(divisor);
		
		int total = 0;
		
		while ((total + absoluteDivisor) <= absoluteDividend) {
			total = total + absoluteDivisor;
		}
		
		return subtract(absoluteDividend, total);
	}
	
	private static boolean isEven(int number) {
		
		if (number % 2 == 0) {
			return true;
		}
		
		return false;
	}

	private static boolean isPowerOfTwo(int number) {

		boolean returnVal = false;
		
		if (number == 2) {
			// number is equal to 2
			returnVal = true;
		} else if (!isEven(number)) {
			// number is odd
			returnVal = false;
		} else {
			// number is not 2 and is not odd,
			// divide number by 2 and check again
			returnVal = isPowerOfTwo(divide(number,2));
		}
		
		return returnVal;
	}

	public static int highestOrderBit(int number) {
		int value = 0;
		int divisor = 1;
		
		if (number == 0 || number == 1) {
			return number;
		}
		
		while (value != 1) {
			divisor = multiply(divisor, 2);
			value = divide(number, divisor);
		}
		
		return divisor;
	}
	
	public static boolean isBitFlipped(int number, int bit) {
		boolean returnVal = false;
		int value = number;
		int highBit = 0;
		//String num = Integer.toBinaryString(number);
		
		do {
			value -= highBit;
			highBit = highestOrderBit(value);
		} while (highBit > bit);
		
		if (highBit == bit) {
			returnVal = true;
		}
		
		return returnVal;
	}
	
	public static boolean isBitFlipped2(int number, int bit) {
		
		String num = Integer.toBinaryString(number);
		int length = num.length();
		
		for (int index = 0; index < length; index++) {
			if (Math.pow(2, index) == bit) {
				// if the index is equal to the bit we are looking for
				char currentChar = num.charAt(length - (index + 1));
				if (currentChar == '1') {
					return true; // bit is flipped
				} else {
					return false; // bit is not flipped				
				}
			}
		}
		
		return false;
	}
	
	private static String getErrorMessages(int errorNumber) {
		
		final int UNKNOWN_ERROR = 1;
		final int DIVIDE_BY_ZERO_ERROR = 2;
		final int INVALID_DATA_TYPE = 4;
		final int PARSING_ERROR = 8;

		//StringBuilder returnVal = new StringBuilder();
		List<String> returnVal = new ArrayList<>();
		
		if (isBitFlipped(errorNumber, PARSING_ERROR)) {
			returnVal.add("PARSING_ERROR");
		}

		if (isBitFlipped(errorNumber, INVALID_DATA_TYPE)) {
			returnVal.add("INVALID_DATA_TYPE");
		}

		if (isBitFlipped(errorNumber, DIVIDE_BY_ZERO_ERROR)) {
			returnVal.add("DIVIDE_BY_ZERO_ERROR");
		}

		if (isBitFlipped(errorNumber, UNKNOWN_ERROR)) {
			returnVal.add("UNKNOWN_ERROR");
		}

		// remove last comma and add a line break
		//if (returnVal.length() > 0) {
		//	if (returnVal.charAt(returnVal.length() - 2) == ',') {
		//		return returnVal.substring(0,returnVal.length() - 2) + "\n";
		//	} else {
		//		returnVal.append("\n");
		//	}
		//} else {
		//	returnVal.append("\n");
		//}
		
		return String.join(", ", returnVal);
	}
	
	public static long computeFibonacci(long number) {
		
		if (number == 0 || number == 1) {
			return number;
		} else {
			return computeFibonacci(number - 1) + computeFibonacci(number - 2);
		}
	}
}
