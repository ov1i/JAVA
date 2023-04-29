package mypkg;

import java.util.Random;
import java.util.Scanner;
import imageProcessor.*;

/* 7.
 *  Define a Java package named imageProcessor which contains a class called MyImage. The class has all the necessary
 *  methods used for initializing and modifying the values from a m x n pixels matrix. Each pixel is an instance of another
 *  class named Pixel (also included in the package) which contains 3 integer variables R, G and B with possible values between 0 and 255.
 *  The class MyImage defines methods for:
 *  	- canceling the pixels that have the RGB values below some values received as parameters
 *  	- deleting the R G or B components from all the pixels
 *  	- transforming the pixels into gray-scale tones by using the formula 0.21 R + 0.71 G + 0.07 B. The new R G and B
 *  	  components will be equal with this formula’s results.
 *  Note: each operation is timed.
 *  Import the defined package into a Java application that creates a MyImage instance. The program generates randomly
 *  the values for the pixels’ components. Apply the methods stored inside the class upon the created instance. Display the
 *  results and the necessary amount of time specific to each operation.
 */


/* ---- MyImage ----
package imageProcessor;

class Pixels {
	private int R,G,B;  
	public Pixels() {
		R = 0;
		G = 0;
		B = 0;
	}
	public Pixels(int R, int G, int B) {
		this.R = R;
		this.G = G;
		this.B = B;
	}
	public int getR() {
		return R;
	}
	public void setR(int r) {
		R = r;
	}
	public int getG() {
		return G;
	}
	public void setG(int g) {
		G = g;
	}
	public int getB() {
		return B;
	}
	public void setB(int b) {
		B = b;
	}
}

public class MyImage {
	private int m,n;
	 private Pixels[][] matrix;
	 public MyImage() {
		 this.matrix = null;
		 this.m = 0;
		 this.n = 0;
	 }
	 public MyImage(int m, int n) {
		 this.m = m;
		 this.n = n;
		 matrix = new Pixels[this.m][this.n];
		 
		 for(int i = 0;i < matrix.length;i ++) {
			 for(int j = 0; j < matrix[i].length;j++) {
				 matrix[i][j] = new Pixels();
			 }
		 }
	 }
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public void setElement(int arr[], int i, int j) {
		matrix[i][j].setR(arr[0]);
		matrix[i][j].setG(arr[1]);
		matrix[i][j].setB(arr[2]);
	}
	public Pixels getElement(int i, int j) {
		return matrix[i][j];
	}
	public void genMatrix() {
		matrix = new Pixels[m][n];
		for(int i = 0;i < matrix.length;i ++) {
			 for(int j = 0; j < matrix[i].length;j++) {
				 matrix[i][j] = new Pixels();
			 }
		 }
	}
	public void checkPixels(int R, int G, int B) {
		long start = System.nanoTime();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				if(matrix[i][j].getR() < R && matrix[i][j].getG() < G && matrix[i][j].getB() < B) {
					matrix[i][j].setR(0);
					matrix[i][j].setG(0);
					matrix[i][j].setB(0);
				}
			}
		}
		long end = System.nanoTime();
		
		System.out.println("New Image Matrix( ->Smaller than:  [" + R + "," + G + "," + B + "]): ");
		printImage();
		System.out.println("Duration: " + ((double)(end-start)/10000) + " ms");
	}
	public void canceledPixel(String val) {
		long start = System.nanoTime();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				if(val.toUpperCase().equals("R")) {
					matrix[i][j].setR(0);			
				}
				else if(val.toUpperCase().equals("G")) {
					matrix[i][j].setG(0);
				}
				else if(val.toUpperCase().equals("B")) {
					matrix[i][j].setB(0);
				}
			}
		}
		long end = System.nanoTime();
		
		System.out.println("New Image Matrix(Canceled channel " + val.toUpperCase() +"): ");
		printImage();
		System.out.println("Duration: " + ((double)(end-start)/10000) + " ms");
	}
	public void grayScaleTransform() {
		long start = System.nanoTime();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				int gScale = (int) (0.21 * matrix[i][j].getR() + 0.71 * matrix[i][j].getG() + 0.07 * matrix[i][j].getB());
 				matrix[i][j].setR(gScale);
				matrix[i][j].setG(gScale);
				matrix[i][j].setB(gScale);
			}
		}
		long end = System.nanoTime();
		
		System.out.println("GrayScale Image Matrix: ");
		printImage();
		System.out.println("Duration: " + ((double)(end-start)/10000) + " ms");
	}
	public void deletedImage() {
		long start = System.nanoTime();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length;j++) {
					matrix[i][j].setR(0);
					matrix[i][j].setG(0);
					matrix[i][j].setB(0);
				}
			}
		
		long end = System.nanoTime();
		
		System.out.println("Deleted Image Matrix: ");
		printImage();
		System.out.println("Duration: " + ((double)(end-start)/10000) + " ms");
	}
	public void printImage() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				System.out.print("[" + String.format("%03d", matrix[i][j].getR()) +  "," + String.format("%03d", matrix[i][j].getG()) + "," + String.format("%03d", matrix[i][j].getB()) + "]	");
			}
			System.out.println();
		}
	}
}
 * ---- MyImage ----
 * 
 */

public class OvidiuGherman_Lab06_P07 {

	public static void main(String[] args) {
		 MyImage obj = new MyImage();
		 Random random = new Random();
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Please enter the size of the image: ");
		 obj.setM(scanner.nextInt());
		 obj.setN(scanner.nextInt());
		 obj.genMatrix();
		 
		 String input;
		 do {
			 System.out.print("Please enter the channel that will be canceled: ");
			 input = scanner.next();
		 }while(!input.toUpperCase().equals("R") && !input.toUpperCase().equals("G") && !input.toUpperCase().equals("B"));
		 
		 scanner.close();
		 
		 for(int i = 0; i < obj.getM(); i++) {
			 for (int j = 0; j < obj.getN(); j++) {
				 obj.setElement(new int[]{random.nextInt(0, 255), random.nextInt(0, 255), random.nextInt(0, 255)} , i, j);
			 }
		 }
		 System.out.println("Original Image: ");
		 obj.printImage();
		 
		 obj.grayScaleTransform();
		 obj.checkPixels(random.nextInt(0,255), random.nextInt(0,255), random.nextInt(0,255));
		 
		 obj.canceledPixel(input);
		 obj.deletedImage();
		 
	}

}
