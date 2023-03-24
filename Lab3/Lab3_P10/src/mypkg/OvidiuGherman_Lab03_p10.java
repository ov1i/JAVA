package mypkg;

import java.util.Random;
import java.util.Scanner;

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
