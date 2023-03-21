package mypkg;

import java.util.Scanner;

public class OvidiuGherman_Lab02_p2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		int val = scanner.nextInt();
		
		scanner.close();
			
		System.out.println("The integer number is: " + val);
		
		
		int result = 1;
		for(int i = val;i> 0;i--)
		{
			result *= i;
		}
		
		System.out.flush();
		System.out.println("The factorial of the integer number is: " + result);
	}

}
