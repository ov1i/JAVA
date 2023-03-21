package mypkg;

import java.util.Scanner;

/*
 * Read from the keyboard an integer value bigger than 16.777.216. Use bit masks for isolating each of the 4 bytes
 * of the read value. Display the initial and the isolated values as decimal, binary and hexadecimal strings.
 */

public class OvidiuGherman_Lab03_p7 {
	static void printResult(int res, int b) {
		System.out.println("The isolated byte(" + b + ") in binary is:" + Integer.toBinaryString(res));
		System.out.println("The isolated byte(" + b + ") in decimal is: " + res);
		System.out.println("The isolated byte(" + b + ") in hexdecimal is: 0x" + Integer.toHexString(res));
	}
	static void isolatedByte(int nr, int b) {
		int res;
		if(b == 1) {
			res = nr & 0xFF;
			printResult(res, b);
		}
		else {
			res = (nr >> 8 * (b - 1)) & 0xFF;
			printResult(res , b);
		}
		
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nr;
			
		do {
			System.out.print("Please enter a value(>16777216): ");
		    nr = scanner.nextInt();		
		} while(nr < 16777216);
		scanner.close();
		
		System.out.println("The original number in binary is: " + Integer.toBinaryString(nr));
		System.out.println("The original number in decimal is: " + nr);
		System.out.println("The original number in hexadecimal is: 0x" + Integer.toHexString(nr));
		for(int i = 1;i < 5;i++) {
			isolatedByte(nr, i);
		}
	}
}
