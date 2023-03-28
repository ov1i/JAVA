package mypkg;

import java.util.Random;
import java.util.Scanner;

/*
 * Assume that there is a cryptographic algorithm which takes an input text ‘A’ composed of lower and upper case
 * characters. Separately a character string ‘B’ is defined. Each character from B has an associated random integer
 * value between 1 and 100. The algorithm checks if the letters from B are found in A and adds the associated
 * numerical values. To the final sum value, the algorithm also adds the positions from string A where characters
 * from string B were found. If the final sum is larger than 100, the encryption was valid. Display a message with the result.
 * 		Example:
 * 			String A = ”aTmPpDsst”
 * 			String B =”ams”
 * 			Associated numerical values for string B: 11 33 7
 * 			Sum: (11+33+7+7)+(1+3+7+8)=77 -> INVALID ENCRYPTION
 */

public class OvidiuGherman_Lab03_p10 {
	static boolean encrypt(String A, String B, int[] val) {
		int sum = 0;
		for(int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				if(A.charAt(i) == B.charAt(j)) {
					sum += val[j] + i;
				}
			}
		}
		
		System.out.println("\nThe sum is: " + sum);
		
		if(sum > 100) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		String A;
		String B = "ams";
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter string A: ");
		A = scanner.next();
		scanner.close();
		
		int val[] = new int[B.length()];
		Random random = new Random();
		
		for(int i = 0;i< B.length(); i++) {
			for(int j = 0; j < B.length(); j++) {
				if(i == j) {
					continue;
				}
				else if(B.charAt(i) == B.charAt(j) && val[i] != 0) {					
					val[j] = val[i];
					break;
				}else {
					do {
						val[i] = random.nextInt(1,100);
					}while(val[i] == val[j]);
				}
			}
		}
		System.out.println("String A: " + A + "\nString B: " + B);
		System.out.print("The associated numerical values for string B: ");
		for(int i = 0;i<val.length;i++) {
			System.out.print(val[i] + " ");
		}
		
		if(encrypt(A, B, val) == true) {
			System.out.println("VALID ENCRYPTION!");
		}
		else {
			System.out.println("INVALID ENCRYPTION!");
		}
	}

}
