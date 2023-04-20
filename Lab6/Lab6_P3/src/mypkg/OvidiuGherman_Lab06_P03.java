package mypkg;

import java.util.Scanner;

/* 3. 
 * Define a package that declares an interface named Int1 (2 integer variables and a sum() method that returns the sum
 * of 2 integer values). Include in the same package a class named Class1 (2 protected double variables, constructor, setters
 * and getters). In another source file, add in the same package a new interface named Int2 (2 double variables and a
 * method named product() that returns the product of 2 double values).
 * Implement a distinct source file and import everything from the defined package. Define a class named Class2 that is
 * derived from Class1 and implements both interfaces Int1 and Int2.
 * Instantiate Class2 and call the defined methods for determining the sum and product of some values read from the keyboard.
 */

public class OvidiuGherman_Lab06_P03 {

	public static void main(String[] args) {
		Class2 obj = new Class2();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter 2 integer values: ");
		obj.setA(scanner.nextDouble());
		obj.setB(scanner.nextDouble());
		scanner.close();
		
		System.out.print("\nThe sum of the two numbers is: " + obj.sum());
		System.out.print("\nThe product of the two numbers is: " + obj.product());
		
		obj.printDefault();
		
	}

}
