package mypkg;

import java.util.Scanner;

/*
 * Starting from the previous problem, copy the first 3 characters of the array to another array and display the
 * obtained result(use the arraycopy () method from the System class).
 */

public class OvidiuGherman_Lab03_p3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter a string: ");
		String str = scanner.next();	
		
		scanner.close();
		
		System.out.println("The original string is(array 1): " + str);
		
		char c_array[] = str.toCharArray();
		char c1_array[] = new char[3];
		
		try {
			System.arraycopy(c_array, 0, c1_array, 0, 3);
		} catch(ArrayIndexOutOfBoundsException ioe) {
			System.arraycopy(c_array, 0, c1_array, 0, c_array.length);
		}
		
		
		System.out.print("The result is(array 2): ");
		for(char i : c1_array) {
			System.out.print(i);
		}
	}

}
