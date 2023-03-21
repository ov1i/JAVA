package mypkg;

import java.util.Random;
import java.util.random.RandomGenerator;

/*
 * Write a Java program that generates 2 random values and performs some mathematical operations on them.
 */

public class OvidiuGherman_Lab03_p6 {

	public static void main(String[] args) {
		Random random = new Random();
		
		int nr1 = random.nextInt(0,10000);
		float nr2 = random.nextFloat(0.0f,10000.0f); 
		System.out.println("The first number(int) is: " + nr1 + "\nThe second number(float) is: " + nr2);
		
		System.out.println("The sum of the two numbers is: " + (nr1+nr2));
		
		System.out.println("The difference of the two numbers is: " + (nr1-nr2));
		
		System.out.println("The product of the two numbers is: " + (nr1*nr2));
		
		System.out.println("The division of the two numbers is: " + (nr1/nr2));
		}

}
