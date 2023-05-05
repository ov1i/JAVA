package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/* 9. Read from a text file a grayscale image represented as a matrix of integer values. The image is followed by multiple
 * convolution filters (https://en.wikipedia.org/wiki/Kernel_(image_processing)). Apply these filters to the original image
 * and display both the original image, and the filtered results. 
 */


public class OvidiuGherman_Lab08_P09 {
	
	public static int[][] filterImage(int[][] originalImage, int[][]filter) {
		
		int[][] newImage = new int[originalImage.length][originalImage[0].length];
		for (int i = 1; i < originalImage.length - 1; i++) {
			for (int j = 1; j < originalImage[i].length - 1; j++) {
				int sum = 0;
				for (int k = -1; k <= 1; k++) {
					for (int l = -1; l <= 1; l++) {
						sum += originalImage[i + k][j + l] * filter[k + 1][l + 1];
					}
				}
				newImage[i][j] = sum;
			}
		}
		return newImage;
		
	}
	public static int[] computeNoOfRowsAndColumns(String line, int rows, int columns) {
		rows++;
		String[] values = line.split(" ");
		columns = Math.max(columns, values.length);
		
		return new int[] {rows, columns};
	}

	public static void main(String[] args) {

		Scanner scanner = null;

		int[] rowsAndColumns = new int [2];
		int imageMatrix[][] = null;
		try {
			scanner = new Scanner(new File("image.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		String line;
		while (true) {
			try {
				line = scanner.nextLine();
				rowsAndColumns = computeNoOfRowsAndColumns(line, rowsAndColumns[0], rowsAndColumns[1]);
			} catch(NoSuchElementException e) {
				System.out.println("End of stream");
				scanner.close();
                try {
                    scanner = new Scanner(new File("image.txt"));
                } catch (FileNotFoundException e1) {
                    System.out.println(e1.getMessage());
                    System.exit(-1);
                }
				break;
			}
		}
		
		imageMatrix = new int[rowsAndColumns[0]][rowsAndColumns[1]];
		for(int i = 0;i<imageMatrix.length;i++) {
			for(int j = 0;j<imageMatrix[i].length;j++) {
				imageMatrix[i][j] = scanner.nextInt();
			}
		}
		scanner.close();		

		System.out.println("Original Image: ");
		for(int i = 0; i < imageMatrix.length; i++) {
			for (int j = 0; j < imageMatrix[i].length; j++) {
				System.out.printf("%5d", imageMatrix[i][j]);
			}
			System.out.println();
		}
		
		int[][] filter = new int[][] {
			{-1, -1, -1},
	        {-1,  9, -1},
	        {-1, -1, -1}
		};
	
		int[][] filteredImage = filterImage(imageMatrix, filter);
		
		
		System.out.println("Filtered Image: ");
		for (int i = 0; i < filteredImage.length; i++) {
		    for (int j = 0; j < filteredImage[i].length; j++) {
		        System.out.printf("%5d", filteredImage[i][j]);
		    }
		    System.out.println();
		}
	}
}
