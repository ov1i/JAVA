package mypkg;

import java.util.Scanner;

public class OvidiuGherman_Lab02_p5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		int [] arr;
		
		System.out.print("Please enter the size of the array: ");
		arr = new int[scanner.nextInt()];
		
		
		System.out.print("\nPlease enter the elemens of the array: ");
		for(int i = 0;i<arr.length;i++)
			arr[i] = scanner.nextInt();
		
		scanner.close();
		
		System.out.print("The array is: ");
		for(int i = 0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		
		System.out.println("\n\n\n\tRESULT");
		for(int i = 0;i<arr.length;i++) {
			boolean prime = true;
			if((arr[i] == 0 || arr[i] == 1)) {
				System.out.println("Number: " + arr[i] + " is not a prime one");
				continue;
			}
			else {
				for(int j = 2; j<= arr[i]/2; j++) {
					if(arr[i] % j == 0) {
						System.out.println("Number: " + arr[i] + " is not a prime one");
						prime = false;
						break;
					}
				 
				}
				if(prime == true)
					System.out.println("Number: " + arr[i] + " is a prime one");
			}
			
		}
			
	}
	
}
