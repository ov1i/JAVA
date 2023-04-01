package mypkg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
 * 	Implement the naive dots and crosses game (X-O) as an automated game. The application will randomly select
 * at each step a position from the board at which to place the next symbol, alternating between X and O. The
 * selected position cannot be an already filled square. The game ends when either there are no more empty
 * squares on the board, or one of the symbols wins by completing a line, a column or a diagonal. Display on the
 * screen each step of the algorithm as a matrix. Unfilled squares will be represented by the * character.
 * 		Example:
					X * *
 					* * *
 					* * *
					--
					X * *
 					* 0 *
 					* * *
					--
					X * *
 					* 0 *
					X * *
					--
					X * 0
					* 0 *
					X * *
					X * 0
					X 0 *
					X * *
					Game over!
					--------
*	Extend the application so that the dimensions of the board (number of rows and columns) can be changed. 
 */

public class OvidiuGherman_Lab03_p11 {
	static int k = 0;
	static boolean checkD1EndGame(Map<Integer,Character> hashMap, int rows, int columns, char c) {
		//case 1 (diagonal 1)
		for(int i = 0; i < columns; i++) {
			if(hashMap.get(i * (rows + 1)) == null || !hashMap.get(i * (rows + 1)).equals(c)) {
				return false;
			}
		}
		return true;
		
	}
	static boolean checkD2EndGame(Map<Integer,Character> hashMap, int rows, int columns, char c) {
		//case 2 (diagonal 1)
		for(int i = 1; i < columns+1; i++) {
			if(hashMap.get(i * (rows - 1)) == null || !hashMap.get(i * (rows - 1)).equals(c)) {
				return false;
			}
		}
		return true;
		
	}
	static boolean checkLEndGame(Map<Integer,Character> hashMap, int rows, int columns, char c, int row) {
		//case 3 (Lines)
		for(int i = row*columns; i < (row + 1) * columns; i++) {
			if(hashMap.get(i) == null || !hashMap.get(i).equals(c)) {
				return false;
			}
		}
		return true;
	}
	static boolean checkCEndGame(Map<Integer,Character> hashMap, int rows, int columns, char c, int row) {
		//case 4 (Columns)
		int i = 0;
		while(i< columns){
			if(hashMap.get(row +  i * rows) == null || !hashMap.get(row +  i * rows).equals(c)) { 
				return false; 
			}
			i++;
		}
		return true;
		
	}
	static void gameElementsGeneration(Map<Integer, Character> hashMap, Random random, int rows, int columns) {
		while(true) {
			int key = random.nextInt(0,rows*columns);
			char val;
			
			if(k%2 == 0) {
				val = 'x';
			}
			else {
				val = 'o';
			}
			
			for(int i = 0;i<rows*columns + 1;i++) {
					int try_index = (i + key) % (rows*columns);
					if(hashMap.get(try_index) == null) {
						hashMap.put(try_index, val);
						k++;
						break;
					}
			}
			/* 
			 * if(hashMap.get(key) == null) { hashMap.put(key, val); k++; } -> Method 2
			 */	
			
			//*Lines&Columns
			for(int i = 0;i < rows; i++) {
				if(checkLEndGame(hashMap,rows, columns, 'x', i) && k >= 3) {
					System.out.println("Winner Winner Chicken Dinner: \"x\"");
					return;
				}
				if(checkLEndGame(hashMap,rows, columns, 'o', i) && k >= 3) {
					System.out.println("Winner Winner Chicken Dinner: \"o\"");
					return;
				}
				
				if(checkCEndGame(hashMap,rows, columns, 'x', i) && k >= 3) {
					System.out.println("Winner Winner Chicken Dinner: \"x\"");
					return;
				}
				
				if(checkCEndGame(hashMap,rows, columns, 'o', i) && k >= 3) {
					System.out.println("Winner Winner Chicken Dinner: \"o\"");
					return;
				}
				
			}
			
			//*Diagonals
			if(checkD1EndGame(hashMap,rows, columns, 'o') && k >= 3) {
				System.out.println("Winner Winner Chicken Dinner: \"o\"");
				break;
			}
			else if(checkD1EndGame(hashMap,rows, columns, 'x') && k >= 3) {
				System.out.println("Winner Winner Chicken Dinner: \"x\"");
				break;
			}
			else if(checkD2EndGame(hashMap,rows, columns, 'o') && k >= 3) {
				System.out.println("Winner Winner Chicken Dinner: \"o\"");
				break;
			}
			else if(checkD2EndGame(hashMap,rows, columns, 'x') && k >= 3) {
				System.out.println("Winner Winner Chicken Dinner: \"x\"");
				break;
			}
			else if(k == columns*rows) break;
			
			{
				int i = 1;
				for(int key1 = 0; key1 < rows*columns; key1++) {
					
				if(i*rows == key1) {
					i++;
					System.out.println();
				}	
				if(hashMap.get(key1) == null) {
					System.out.print("*" + "\t");
					continue;
				}
				
				System.out.print(hashMap.get(key1) + "\t");
				}
				
				System.out.println("\n     --"+ k + "--");
			}
		}
	}
	public static void main(String[] args) {
		Map<Integer,Character> hashMap = new HashMap<Integer, Character>();
		Random random = new Random();
		int rows;
		int columns;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter the number of rows and columns: ");
		rows = columns = scanner.nextInt();
		
		scanner.close();
		gameElementsGeneration(hashMap,random,rows,columns);
		int i = 1;
		for(int key = 0; key < rows*columns; key++) {
			
			if(hashMap.get(key) == null) {
				hashMap.put(key, '*');
			}
			if(i*rows == key) {
				i++;
				System.out.println();
			}
			System.out.print(hashMap.get(key) + "\t");
		}
			System.out.println("\n\n--GAME OVER--");
	}
}


