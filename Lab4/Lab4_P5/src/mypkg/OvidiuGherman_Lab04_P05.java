package mypkg;

import java.util.Scanner;

/*
 * Build a Java application that tests the new methods of the String class, introduced in Java11.
 */

public class OvidiuGherman_Lab04_P05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter a string: ");
		String str = scanner.nextLine();
		System.out.print("Please enter the number of times the original string will be repeated(M1): ");
		int n = scanner.nextInt();
	
		//M1
		System.out.println("Method 1 //repeat(): " + str.repeat(n));
		
		System.out.print("Please enter a new string with whitespaces: ");
		scanner.nextLine();
		str = scanner.nextLine();
		scanner.close();
		//M2
		System.out.println("Original string: "  + str);
		System.out.println("Method 2 //strip(): " + str.strip()); //removes the leading and trailing white-spaces
		
		//M3
		System.out.println("Method 3 //stripLeading(): " + str.stripLeading()); //removes the leading white-spaces
		
		//M4
		System.out.println("Method 4 //stripTrailing(): " + str.stripTrailing()); //removes the trailing white-spaces
		
		//M5
		if(str.isBlank()) {
			System.out.println("Method 5 //isBlank(): ->The string is blank!");
		}
		else {
			System.out.println("Method 5 //isBlank(): ->The string is not blank!");
		}
		
		String str1 = "First line\n Second line\n Third line\n";
		
		//M6
		System.out.println("Original string: \n \"\n" + str1 + " \"");
		System.out.println("Method 6 //lines(): ->we have " + str1.lines().count() + " elements");
		System.out.println("Method 6 //lines(): ->the elements  are: ");
		for(Object s : str1.lines().toArray()) {
			System.out.println(s.toString());
		}
	}

}
