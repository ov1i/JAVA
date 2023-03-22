package mypkg;

import java.util.Scanner;

public class OvidiuGherman_Lab03_p8 {

	public static void main(String[] args) {
		
		if(args.length == 0)
			System.exit(-1);	
		
		System.out.print("Please enter the elements of the matrix: ");
		
		if(args[0].matches("\\d+")) System.exit(-1);
		
		
		Scanner scanner = new Scanner(System.in);
		
		int m = Integer.parseInt(args[0]);
		
		int matrix[] = new int[m];
		for(int i = 0;i < m; i++) {
			matrix[i][] = new int[][i+1];
			for(int j = 0; j < i + 1; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		scanner.close();
		
		
		for(int i = 0;i < m; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.println(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
