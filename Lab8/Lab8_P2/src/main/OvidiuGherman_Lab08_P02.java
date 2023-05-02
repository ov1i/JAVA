package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/* 2. 
 * Implement the previous problem using a file as input source.
 */

public class OvidiuGherman_Lab08_P02 {
	public static void main(String[] args) {
		StreamTokenizer tokens = null;
		BufferedReader buffer = null;
		
		try {
			buffer =new BufferedReader (new FileReader ("input.txt"));
			tokens = new StreamTokenizer(buffer);
			tokens.eolIsSignificant(true);
		} catch (FileNotFoundException e1) {
			System.out.println("Failed to read the file!");
			System.exit(-1);
		}

			try {
				while (tokens.nextToken() != StreamTokenizer.TT_EOF) {
					if(tokens.ttype == StreamTokenizer.TT_WORD) {
						if(tokens.sval.toLowerCase().equals("end")) {
							System.out.println("Ending String found! ");					
							break;
						}					
						else {
							System.out.println("Word: " + tokens.sval);
						}
					}
					else if(tokens.ttype == StreamTokenizer.TT_NUMBER) {
						System.out.println("Number: " + (int)tokens.nval);
					}

					else {
						System.out.println("Unknown data type!");
					}			
				}
				
				buffer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
	}
}
