package mypkg;

import registrationPlates.registrationPlateHandler;

import java.util.Scanner;

import registrationPlates.InvalidFormatException;

/* 8. 
 * Write an application which checks the Romanian vehicle registration numbers. Their format is the following:
 * [L{L}][NN{N}][LLL], where L represents a letter, N a digit, and the curly braces represent the fact that for Bucharest the
 * number is composed of a single letter in the first group, and the digit group can be composed of 3 digits. Implement a
 * method which checks the registration numbers and throw exceptions (instances of specialized exception classes) specific
 * to each error which may occur upon check-up (specialized messages). For example, if the county letters group is
 * composed of 2 letters, the digit group cannot be of size 3. The last letters group cannot contain "I" and "O" on the first
 * and last position.
 */

/* 
 *  ---- InvalidFormatException ---- 
package registrationPlates;

public class InvalidFormatException extends Exception {
	public InvalidFormatException(String msg) {
		super(msg);
	}
}
 *  ---- InvalidFormatException ----
 *  ---- registrationPlateHandler ----
package registrationPlates;

import java.util.StringTokenizer;

abstract class registrationPlate {
	private String licensePlate;
	
	public registrationPlate() {
		this.licensePlate = null;
	}
	public registrationPlate(String licesnsePlate) {
		this.licensePlate = new String(licesnsePlate);
	}
	public String getLicensePlate() {
		return this.licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = new String(licensePlate);
	}
}

public class registrationPlateHandler extends registrationPlate {
	public registrationPlateHandler() {
		super();
	}
	public registrationPlateHandler(String plate) {
		super(plate);
	}
	public boolean checkPlate() throws InvalidFormatException {
		String plate = getLicensePlate();
		if(plate.length() != 9) {
			throw new InvalidFormatException("Invalid size");
		}
		else {
			StringTokenizer str = new StringTokenizer(plate," -");
			int country = checkCountry(str.nextToken());
			boolean no = checkNo(str.nextToken(),country);
			boolean letters = checkLetters(str.nextToken());			
			
			if(no == true && letters == true) {
				return true;
			}
		}
		throw new InvalidFormatException("Invalid license plate(UNKNOWN REASON)!");
	}
	private int checkCountry(String countyStr) throws InvalidFormatException {
		String county[] = {"AB", "AG", "AR", "BC", "BH", "BN", "BR", "BT", "BV", "BZ", "CJ", "CL", "CS", "CT", "CV", "DB", "DJ"
				, "GJ", "GL", "GR", "HD", "HR", "IF", "IL", "IS", "MH", "MM", "MS", "NT", "OT", "PH", "SB", "SJ", "SM", "SV"
				, "TL", "TM", "VL", "VN", "VS"};
		countyStr = countyStr.toUpperCase();
		if(countyStr.length() != 2 && countyStr.length() != 1) {
			throw new InvalidFormatException("Invalid county name size!");
		}
		else { 
			if(countyStr.equals("B")) {
				return 0;
			}
			for(int i = 0; i < county.length; i++) {
				if(countyStr.equals(county[i])) {					
					return 1;
				}		
			}
		}
		throw new InvalidFormatException("Invalid county name!");
	}
	
	private boolean checkNo(String noStr, int isB) throws InvalidFormatException {
		noStr = noStr.toUpperCase();
		
		if(isB == 0 && noStr.length() != 3) {
			throw new InvalidFormatException("Invalid count of numbers(B county)!");			
		}
		else if(isB == 1 && noStr.length() != 2) {
			throw new InvalidFormatException("Invalid count of numbers!");			
		}
		else if(isB == 0 && noStr.length() == 3 && noStr.matches("\\d+")) {
			return true;
		}
		else if(isB == 1 && noStr.length() == 2 && noStr.matches("\\d+")){
			return true;
		}
		throw new InvalidFormatException("Invalid format of numbers section(NON-DIGIT Characters present)!");
			
	}
	private boolean checkLetters(String letterStr) throws InvalidFormatException {
		if(letterStr.length() != 3) {
			throw new InvalidFormatException("Invalid count of letters!");
		}
		else if(letterStr.charAt(0) == 'I' || letterStr.charAt(0) == 'O' || letterStr.charAt(2) == 'I' || letterStr.charAt(2) == 'O') {
			throw new InvalidFormatException("Invalid beggining/ending character(I or O present on the starting or ending position)!");
		}
		else if(letterStr.matches("[A-Z]+")) {
			return true;
		}
		throw new InvalidFormatException("Invalid letter section(UNKNOWN REASON)!");
	}
}
 *  ---- registrationPlateHandler ----
 */

public class OvidiuGherman_Lab06_P08 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the license plate(ex.: MM-12-ASD): ");
		String input = scanner.nextLine();
		scanner.close();
		System.out.print("The license plate is: " + input + "\nChecking license plate: ->");
		registrationPlateHandler obj = new registrationPlateHandler(input);
		try {
			if(obj.checkPlate()) {
				System.out.println("The licesnse plate is valid!");
			}
		} catch(InvalidFormatException except) {
			System.out.println(except.getMessage());
		}
	}

}
