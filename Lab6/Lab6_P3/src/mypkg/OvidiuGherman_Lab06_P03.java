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

/*
 *  ---- Class2 ----
	package mypkg;
	import int_Pkg.*;

	public class Class2 extends Class1 implements Int1, Int2{

		public Class2() {
			super();
		}
	
		@Override
		public int sum() {
			return (int) (this.getA() + this.getB());
		}
	
		@Override
		public double product() {
			return this.getA() * this.getB();
		}
	
		public void printDefault() {
			System.out.print("\nThe sum of the two numbers is(default): " + Int1.super.sum());	
			System.out.print("\nThe product of the two numbers is(default): " + Int2.super.product());
		}
	}
 *  ---- Class2 ----
 *  ---- Int1 ----
    package int_Pkg;

	public interface Int1 {
		int a = 5;
		int b = 4;
		default public int sum() {
			return a + b;
		}
	}
 *  ---- Int1 ----
 *  ---- Int2 ----
    package int_Pkg;

	public interface Int2 {
		double a = 4.3;
		double b = 3.4;
		default double product() {
			return a * b;
		}
	}	
 *  ---- Int2 ----
 *  ---- Class1 ----
   	package int_Pkg;

	public class Class1 {
		protected double a;
		protected double b;
		public Class1() {
			this.a = 0.0;
			this.b = 0.0;
		}
		public double getA() {
			return this.a;
		}
		public void setA(double a) {
			this.a = a;
		}
		public double getB() {
			return this.b;
		}
		public void setB(double b) {
			this.b = b;
		}
	}
 *  ---- Class1 ----
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
