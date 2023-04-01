package mypkg;

import java.util.Random;
import java.util.Scanner;

/*
 * Write a class named Methods having 3 methods: a method with a variable number of integer parameters, which
 * returns the arithmetic mean of the parameters; another method in which will be defined a one-dimensional
 * array of n double-type numbers (n being the parameter of the method and which will be read in main () from
 * the keyboard), its elements will receive randomly generated values and the method will return this array; a
 * static method that receives as a parameter a character array, converts the respective characters into uppercase
 * letters and forms a String object from this array, which wiil be returned by the function. From the main ()
 * method, defined in another class, call the methods of the Methods class and display the results on the screen
 * (the call values for the first method and the character string for the 3rd method will be defined in main ()).
 */

class Methods {
	public float arithmeticMean(int... vals) {
		float sum = 0;
		for (int val : vals) {
			sum += val;
		}
		return sum / vals.length;
	}
	public double[] arrayGen(int n) {
		double arr[] = new double[n];
		Random random = new Random();
		for (int i = 0;i<n;i++) {
			arr[i] = random.nextDouble();
		}
		return arr;
	}
	static String toUpperMethod(char[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= 'a' && arr[i]<= 'z') {
				arr[i] -= 32;
			}		
		}
		
		String result = String.valueOf(arr);
		return result;
	}
}

public class OvidiuGherman_Lab04_P01 {
	
	public static void main(String[] args) {
		Methods obj1 = new Methods();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the size of the array: ");
		int n = scanner.nextInt();
		scanner.close();
		
		System.out.println("The arithmetic mean of the parameters is: " + obj1.arithmeticMean(1,2,3,4));
		double arr[] = obj1.arrayGen(n);
		
		System.out.print("The array is: ");
		for (double val : arr) {
			System.out.print(val + " ");
		}
		char [] cArr = {'a', 'b', 'c', 'D', 'e', '.'}; 
		System.out.print("\nThe original character array is: ");
		for(char c : cArr) {
			System.out.print(c);
		}
		System.out.println("\nThe modified string is: " + Methods.toUpperMethod(cArr));
	}

}
