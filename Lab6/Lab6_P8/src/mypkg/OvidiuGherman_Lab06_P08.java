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
