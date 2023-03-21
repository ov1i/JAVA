package mypkg;

import java.util.Scanner;

public class OvidiuGherman_Lab02_p4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = 0;
		
		do {
			System.out.print("Please enter a number: ");
			n = scanner.nextInt();
		}while(n <= 0);
		
		
		scanner.close();
		
		System.out.print("The dividers of " + n + " are: ");
		for(int i = 1 ;i <= n;i++) {
			if (n % i == 0) 
				System.out.print(i + " ");
		}
		
	}

}
