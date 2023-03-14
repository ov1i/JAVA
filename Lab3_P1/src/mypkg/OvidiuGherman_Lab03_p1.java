package mypkg;

import java.util.Scanner;

/*
 * Write a Java application that reads an int value. If the int value is between 1-12, the corresponding string month
will be displayed. If the value entered is a string and if it corresponds to a month of the year, display the numeric
value of the month.
 */


public class OvidiuGherman_Lab03_p1 {

	public enum months {
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		
		scanner.close();
		
		if(input.matches("\\d")) {
			int index = Integer.parseInt(input);
			if(index < 0 || index > 12) 
				System.out.println("Invalid index!");
			else 
				System.out.println("The month for the index " + input + " is: " + months.values()[index - 1]);				
		}
		else {
			int index;
			try{
				index = months.valueOf(input.toUpperCase()).ordinal() + 1;
				System.out.println("The corresponding number of the month: " + input + " is: " +  index);
			} catch (IllegalArgumentException ioe){
				 System.out.println("Invalid month name!");
			}
		}
	}

}
