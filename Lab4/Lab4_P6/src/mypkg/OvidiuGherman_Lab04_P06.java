package mypkg;

import java.util.Random;
import java.util.Scanner;

/*
 * Define a one-dimensional array of char type, less than a value n introduced from the keyboard. Each value
 * contains some randomly generated alpha-numerical characters. Generate a String object using the array.
 * Display the initial content of the array and after that, process all the elements so that all numbers will be
 * replaced with ‘*’. Display the result.
 */

public class OvidiuGherman_Lab04_P06 {
	static void genArray(char [] arr, int size, Random random) {
		for(int i = 0; i < size; i++)
		{
			int type = random.nextInt(0,3);
			
			if(type == 0) {
				arr[i] = (char)random.nextInt(48,58);
			}
			else if(type == 1) {
				arr[i] = (char)random.nextInt(65,91);
			}
			else if(type == 2) {
				arr[i] = (char)random.nextInt(97,123);
			}		
		}
	}
	static void displayArray(char []arr) {
		
			for(char c : arr) {
				System.out.print(c);
			}
	}
	static void modifyArray(char []arr) {
		for (int i = 0 ; i < arr.length; i++) {
			if(Character.isDigit(arr[i])) {
				arr[i] = '*';
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		System.out.print("Please enter the maximum value of the char array: ");
		int max_size = scanner.nextInt();
		scanner.close();
		
		int size = random.nextInt(1,max_size);
		
		char [] arr = new char[size];
		System.out.println("The size of the array is: " + size);
		
		//Generate array
		genArray(arr, size, random);
		
		String str = String.valueOf(arr);
		
		System.out.print("The original character array is: ");
		displayArray(arr);
		
		System.out.println("\nThe generated string from the array is: " + str);
		
		modifyArray(arr);
		System.out.print("The modified character array is: ");
		displayArray(arr);
		
		System.out.println("\nThe modified string is: " + str.replaceAll("\\d+", "*"));
		
		}

}
