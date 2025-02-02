package chapter6;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chapter6 {

	public final static BigDecimal TOLL_PER_AXLE = new BigDecimal(7.8);
	
	public static void main(String[] args) {
		String phoneNumber = "4144524824";
		String phoneNumber2 = "(313)472-3929";
		String phoneNumber3 = "313-459-7199";
		String phoneNumber4 = "331234567";
		String phoneNumber5 = "414.458.1556";
		String phoneNumber6 = "44-458-3831";
		String phoneNumber7 = "(414)882-113";
		
		Pattern phonePattern = Pattern.compile("[(]*[0-9]{3}[)-.]*[0-9]{3}[-.]*[0-9]{4}");

		System.out.printf("is %s valid? %b\n", phoneNumber, isValidPhoneNumber(phoneNumber, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber2, isValidPhoneNumber(phoneNumber2, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber3, isValidPhoneNumber(phoneNumber3, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber4, isValidPhoneNumber(phoneNumber4, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber5, isValidPhoneNumber(phoneNumber5, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber6, isValidPhoneNumber(phoneNumber6, phonePattern));
		System.out.printf("is %s valid? %b\n", phoneNumber7, isValidPhoneNumber(phoneNumber7, phonePattern));

		System.out.println();
		
		String password1 = "blahblah";
		String password2 = "blahBlah@1218";
		String password3 = "correctHorseBattery";
		String password4 = "corr3ctHors3Batt3ry";

		Pattern passwordPattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{12,25}");

		System.out.printf("is %s a valid password? %b\n", password1,
				isValidPassword(password1, passwordPattern));
		System.out.printf("is %s a valid password? %b\n", password2,
				isValidPassword(password2, passwordPattern));
		System.out.printf("is %s a valid password? %b\n", password3,
				isValidPassword(password3, passwordPattern));
		System.out.printf("is %s a valid password? %b\n", password4,
				isValidPassword(password4, passwordPattern));
		
		System.out.println();
		
		Car car1 = new Car("ABM-223", "Ford", "Mustang");
		Car car2 = new Car("ILVBEER", "Hyundai", "Ioniq 5");
		Car car3 = new Car("TSD-915", "Ford", "Fusion");
		Motorcycle cycle1 = new Motorcycle("NP-2112", "BMW", "R1200");
		Truck truck1 = new Truck("JLV-925", "Dodge", "Ram 2500", 2, 4000);
		Truck truck2 = new Truck("TRO-227", "Volvo", "VNL64760", 5, 46000);
		
		System.out.printf("The toll for the %s %s is $%s\n", car1.getMake(), car1.getModel(),
				computeToll(car1));
		System.out.printf("The toll for the %s %s is $%s\n", car2.getMake(), car2.getModel(),
				computeToll(car2));
		System.out.printf("The toll for the %s %s is $%s\n", truck1.getMake(), truck1.getModel(),
				computeToll(truck1));
		System.out.printf("The toll for the %s %s is $%s\n", truck2.getMake(), truck2.getModel(),
				computeToll(truck2));
		System.out.printf("The toll for the %s %s is $%s\n", car3.getMake(), car3.getModel(),
				computeToll(car3));
		System.out.printf("The toll for the %s %s is $%s\n", cycle1.getMake(), cycle1.getModel(),
				computeToll(cycle1));
	}
	
	private static boolean isValidPhoneNumber(String number, Pattern pattern) {
		
		Matcher phoneMatcher = pattern.matcher(number);
		return phoneMatcher.matches();
	}
	
	private static boolean isValidPassword(String password, Pattern pattern) {
		Matcher passwordMatcher = pattern.matcher(password);
		return passwordMatcher.matches();
	}

	private static BigDecimal computeToll(MotorVehicle vehicle) {
		
		switch (vehicle) {
			case Motorcycle m:
				return new BigDecimal(2);
			case Car c:
				return new BigDecimal(4);
			case Truck t:
				int axels = t.getAxels();
				if (axels > 2) {
					return TOLL_PER_AXLE.multiply(BigDecimal.valueOf(axels))
							.setScale(2, RoundingMode.HALF_EVEN);
				} else {
					return new BigDecimal(4);
				}
			default:
				return new BigDecimal(3);
		}	
	}
}
