package mypkg;

import java.util.Scanner;

/* 1.
 * Write a Java program that defines an array of double values and read the appropriate data from the keyboard. Handle
 * the exception produced when the code tries to access an element that has a negative index or an index greater than the
 * maximum number of elements (ArrayIndexOutOfBoundsException). Display a significant message when the exception occurs.
 * Consider a matrix with a fixed number of elements for each line and protect the code against the exception mentioned
 * above. Consider also the case if each line has a different number of elements.
 */
public class OvidiuGherman_Lab06_P01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the size of the array: ");
		int size = scanner.nextInt();
		double []array = new double[size];
		
		System.out.print("Please enter the array: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = scanner.nextDouble();
		}
		
		int index;
		try {
			System.out.print("Please enter which element you want to print form the array: ");
			index = scanner.nextInt();
			System.out.println("The element is " + array[index]);
		}catch(ArrayIndexOutOfBoundsException except) {
			System.out.println("Invalid index(array)!");
		}
		
		int [][] matrix = new int[4][];
		
		for(int i = 1;i< matrix.length;i++) {
			try {
				matrix[i] = new int[matrix.length-1];
				for(int j = 0; j <matrix[i].length;j++) {
					try {
						matrix[i][j] = i+j;	
					} catch(ArrayIndexOutOfBoundsException except) {
					System.out.println("Invalid index (row|column:" + i + " " + j + ")");
					}
				}
			} catch(ArrayIndexOutOfBoundsException except) {
				System.out.println("Invalid index (row: " + i + ")");
			}
		}
		
		
		System.out.println("The matrix is: ");
		for(int i = 0; i < matrix.length;i++) {
			try {
				for(int j = 0; j < matrix[i].length + 1; j++) {
					System.out.print(matrix[i][j] + " ");
				}
			}catch(ArrayIndexOutOfBoundsException | NullPointerException except) {
				System.out.print("null ");
			}
			finally {
				System.out.println();
			}
		}
		
		scanner.close();
	}

}
