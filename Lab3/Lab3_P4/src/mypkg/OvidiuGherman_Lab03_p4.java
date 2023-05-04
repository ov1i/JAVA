package mypkg;

import java.util.Scanner;

/*
 * Write a Java application which defines an integer value and displays it as a binary, octal and hexadecimal string.
 * Write various bases convertion methods. 
 */

public class OvidiuGherman_Lab03_p4 {
	
    private static void baseConvM1(int nr) {
    	System.out.println("Decimal: " + nr);
		System.out.println("Binary: " + Integer.toBinaryString(nr));
		System.out.println("Hexadecimal: 0x" + Integer.toHexString(nr));
		System.out.println("Octal: " + Integer.toOctalString(nr));
    }
    
    private static void baseConvM2(int nr) {
		System.out.println("Base 2: " + Integer.toString(nr,2));
		System.out.println("Base 7: " + Integer.toString(nr,7));
		System.out.println("Base 8: " + Integer.toString(nr,8));
		System.out.println("Base 10: " + Integer.toString(nr,10));
		System.out.println("Base 16: 0x" + Integer.toString(nr,16));
    }
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nr = 10;
		System.out.println("Base Conversion(M1): ");
		baseConvM1(nr);
		
		
		System.out.println("Please enter a new number: ");
		nr = scanner.nextInt();
		
		scanner.close();
		
		System.out.println("Base Conversion(M2): ");
		baseConvM2(nr);
		
	}

}
