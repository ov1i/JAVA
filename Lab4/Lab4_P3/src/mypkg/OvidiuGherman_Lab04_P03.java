package mypkg;

import java.util.Scanner;

/*
 * Write a Java class that models a matrix of integer values. The dimensions and the array of elements are private
 * attributes and are controlled using appropriate setter-getter methods. Write the methods for displaying the
 * matrix, for determining and returning the number of 9 adjacent elements cells that don’t differ with more than 
 * 5% from a threshold value.
 */

class myClass {
	private int rows, columns;
	private int[][] matrix;
	
	public int getRows() {
		return this.rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return this.columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public int[][] getMatrixElements() {
		return this.matrix;
	}
	public int getMatrixElement(int row, int column){
		return this.matrix[row][column];
	}
	
	public void setMatrixElements(int matrix[][]) {
		this.matrix = new int[this.rows][this.columns];
		this.matrix = matrix;
	}
	public void displayMatrix() {
		System.out.println("The matrix is: ");
		for(int i = 0; i < this.rows;i++) {
			for (int j = 0; j < this.columns;j++) {
				System.out.print(this.matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public int adjacentElements(int threshHold) {
		int counter = 0, tempCounter = 0;
		int thVal = Math.round((threshHold * (5.0f/100.0f)));	
		if(rows*columns >= 9) {
			for(int i = 0; i < this.rows;i++) {	
				for (int j = 0; j < this.columns;j++) {
					try {
						if(matrix[i-1][j] >= -thVal && matrix[i-1][j] <= thVal ){
							tempCounter++;			
						}
						if (matrix[i-1][j-1] >= -thVal && matrix[i-1][j-1] <= thVal) {
							tempCounter++;	
						}
						if (matrix[i-1][j+1] >= -thVal && matrix[i-1][j+1] <= thVal) {
							tempCounter++;	
						}
						if (matrix[i][j+1] >= -thVal && matrix[i][j+1] <= thVal) {
							tempCounter++;	
						}
						if (matrix[i][j-1] >= -thVal && matrix[i][j-1] <= thVal) {
							tempCounter++;	
						}
						if (matrix[i+1][j] >= -thVal && matrix[i+1][j] <= thVal) {
							tempCounter++;	
						}
						if (matrix[i+1][j-1] >= -thVal && matrix[i+1][j-1] <= thVal) {
							tempCounter++;
						}
						if (matrix[i+1][j+1] >= -thVal && matrix[i+1][j+1] <= thVal) {
							tempCounter++;	
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						tempCounter = 0;
						continue;
					}					
					if(tempCounter >= 8) {
						counter++;
						tempCounter = 0;
					}
					else tempCounter= 0;
				}		
			}
		}
		
		return counter;
	}
}

public class OvidiuGherman_Lab04_P03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter the number of rows and columns of the matrix: ");
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();		
		myClass obj = new myClass();
		obj.setRows(rows); obj.setColumns(columns);
		
		
		System.out.println("Please enter the matrix elements: ");
		int [][]tempMatr = new int[obj.getRows()][obj.getColumns()];
		for(int i = 0; i < obj.getRows(); i++) {
			for (int j = 0; j < obj.getColumns(); j++) {
				tempMatr[i][j] = scanner.nextInt();			}
		}
		obj.setMatrixElements(tempMatr);
		obj.displayMatrix();
		System.out.print("Please enter the threshhold value: ");
		int thVal = scanner.nextInt();
		scanner.close();
		System.out.println("The number of groups with elements bigger than " + Math.round(thVal * (5.0f/100.0f)) + " (5% from " + thVal + ") is: " + obj.adjacentElements(thVal));
	}

}
