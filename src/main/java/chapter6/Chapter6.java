package chapter6;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Chapter6 {

	public static void main(String[] args) {
		String phoneNumber = "4144524824";
		String phoneNumber2 = "(313)472-3929";
		String phoneNumber3 = "313-459-7199";
		String phoneNumber4 = "331234567";
		String phoneNumber5 = "414.458.1556";
		String phoneNumber6 = "44-458-3831";
		String phoneNumber7 = "(414)882-113";
		
		Pattern phonePattern = Pattern.compile("[(.]*[0-9]{3}[)-.]*[0-9]{3}[-.]*[0-9]{4}");

		System.out.printf("is %s valid? %b\n", phoneNumber, isValidPhoneNumber(phoneNumber, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber2, isValidPhoneNumber(phoneNumber2, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber3, isValidPhoneNumber(phoneNumber3, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber4, isValidPhoneNumber(phoneNumber4, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber5, isValidPhoneNumber(phoneNumber5, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber6, isValidPhoneNumber(phoneNumber6, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber7, isValidPhoneNumber(phoneNumber7, phonePattern));

	}
	
	private static boolean isValidPhoneNumber(String number, Pattern pattern) {
		
		Matcher phoneMatcher = pattern.matcher(number);
		return phoneMatcher.find();
	}

}
