package mypkg;

import java.util.Scanner;

public class OvidiuGherman_Lab01_p4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		int n = scanner.nextInt();
		
		scanner.close();
		
		System.out.print("The dividers of " + n + " are: ");
		for(int i = 1 ;i <= n;i++) {
			if (n % i == 0) 
				System.out.print(i + " ");
		}
		
	}

}
