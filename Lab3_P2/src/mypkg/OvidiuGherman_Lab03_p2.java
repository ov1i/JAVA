package mypkg;

import java.util.Scanner;

/*
 * Read a string from the standard input. Turn the string into a character array. Look for in this array a character
 * specified in the program. Display the number of occurrences.
 */

public class OvidiuGherman_Lab03_p2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Please enter a string and a key: ");
		
		String str = scanner.next();	
		char k = scanner.next().charAt(0);
		scanner.close();
		
		System.out.println("The original string is: " + str + "\nThe key is: " + k);
		
		char c_array[] = str.toCharArray();
		
		
		int counter = 0;
		for(char i : c_array) {
			if(i == k)
				counter++;
		}
		
		
		System.out.println("The key has appeard " + counter + " times in the string!");
		
	}

}
