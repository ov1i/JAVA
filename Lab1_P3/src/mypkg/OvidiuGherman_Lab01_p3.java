package mypkg;

import java.util.Scanner;


public class OvidiuGherman_Lab01_p3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] nrs = new int[2];
		
		System.out.print("Please enter 2 numbers: ");
		for (int i = 0 ;i < nrs.length;i++)	{
			int n = scanner.nextInt();
			nrs[i] = n;
		}
		
		scanner.close();
		
		System.out.print("The 2 numbers are: ");
		for(int i = 0;i<nrs.length;i++) {
			System.out.print(nrs[i] + " ");
		}
		
		while(nrs[0] != nrs[1])
	    {
	        if(nrs[0] > nrs[1])
	        	nrs[0]=nrs[0] - nrs[1];
	        else
	        	nrs[1] = nrs[1] - nrs[0];
	    }
		
		
		System.out.println("\nThe GCD of the two numbers is: " + nrs[0]);
	}

}
