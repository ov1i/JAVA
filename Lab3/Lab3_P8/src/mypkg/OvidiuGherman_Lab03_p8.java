package mypkg;

import java.util.Scanner;

/*
 * Read from the keyboard the elements of a matrix of integer values with m lines (m taken from the command
 * line). For each line the number of elements will increase by 1 compared to the previous line, the first line having
 * only one element.
 * Implement the methods that:
 * 		- display the matrix, line by line and column by column;
 * 		- eliminate from the matrix (turns into 0) the values that are outside the interval defined by 2 specified limits;
 * 		- display the existent neighbour values of an element identified by its indexes (sent as parameters);
 */

public class OvidiuGherman_Lab03_p8 {

	static void printMatrix(int[][] matrix) {
		
		System.out.println("\nThe original matrix is: ");

		for(int i = 0;i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void removeElem(int[][] mat, int[] limits) {
		
		System.out.println("\nThe new matrix is: ");
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				if(!((mat[i][j] >= limits[0] && mat[i][j] <= limits[1]) || (mat[i][j] >= limits[1] && mat[i][j] <= limits[0]))) {
					mat[i][j] = 0;
				}
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void findNeighbours(int [][] matrix, int[] index) {
		int i = 1;
		System.out.println("The neighbours of the element[" + index[0] + "][" + index[1] + "]= " + matrix[index[0]][index[1]] + " are: ");
		try {
		System.out.println("Neighbour " + i++ + ": " + matrix[index[0]-1][index[1]]);
		} catch (ArrayIndexOutOfBoundsException ioe) { i--;}
		try {
		System.out.println("Neighbour " + i++ + ": " + matrix[index[0]][index[1]-1]);
		} catch (ArrayIndexOutOfBoundsException ioe) { i--;}
		try {
		System.out.println("Neighbour " + i++ + ": " + matrix[index[0]][index[1]+1]);
		} catch (ArrayIndexOutOfBoundsException ioe) { i--;}
		try {
		System.out.println("Neighbour " + i++ + ": " + matrix[index[0]+1][index[1]]); 
		} catch (ArrayIndexOutOfBoundsException ioe) {i--;}
	}
	
	public static void main(String[] args) {
		
		if(args.length == 0)
			System.exit(-1);	
		
		System.out.println("Please enter the elements of the matrix: ");
		
		if(!args[0].matches("\\d+")) {	
			System.exit(-1);
		}
		
		Scanner scanner = new Scanner(System.in);
		
		int m = Integer.parseInt(args[0]);
		
		int matrix[][] = new int[m][]; // we allocate the number of rows of the mat
		for(int i = 0;i < m; i++) {
			matrix[i] = new int[i+1]; // for each row we allocate a number of columns of i+1
			for(int j = 0; j < i + 1; j++) {
				System.out.print("Mat[" + i + "][" + j + "]= ");
				matrix[i][j] = scanner.nextInt();
			}
		}		
		
		
		//print original matrix to the screen
		printMatrix(matrix);
		
		int limits[] = new int[2];
		
		System.out.print("\nPlease enter the limits: ");
		for(int i = 0; i < limits.length;i++) {
			limits[i] = scanner.nextInt();	
		}
		
		int indexes[] = new int[2];
		
		System.out.print("Please enter the indexes: ");
		for(int i = 0; i < indexes.length; i++) {
			indexes[i] = scanner.nextInt();
			}
		
		if(matrix.length <= indexes[0]) {
			System.out.println("Invalid input!");
			System.exit(-1);
		}
		else if (matrix[indexes[0]].length <= indexes[1]) {
			System.out.println("Invalid input!");
			System.exit(-1);
		}
		else {
			findNeighbours(matrix, indexes);
		}
		
		removeElem(matrix, limits);
		
		scanner.close();
		
		
	}

}
