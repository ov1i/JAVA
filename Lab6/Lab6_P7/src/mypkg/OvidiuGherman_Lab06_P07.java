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
