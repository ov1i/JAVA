package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

/* 2. 
 * Implement the previous problem using a file as input source.
 */

public class OvidiuGherman_Lab08_P02 {
	public static void main(String[] args) {
		StreamTokenizer str = null;
		BufferedReader buffer = null;
		
		try {
			buffer =new BufferedReader (new FileReader ("input.txt"));
		} catch (FileNotFoundException e1) {
			System.out.println("Failed to read the file!");
			System.exit(-1);
		}
		str = new StreamTokenizer(buffer);
		try {
			while (str.nextToken() != StreamTokenizer.TT_EOF && str.nextToken() != StreamTokenizer.TT_EOL) {
				if (str.ttype == StreamTokenizer.TT_NUMBER) {
					System.out.println("Number: " + (int)str.nval);
				} else if (str.ttype == StreamTokenizer.TT_WORD) {
					System.out.println("String: " + str.sval);
				} else {
					System.out.println("Unrecognized input!");
				}
			}
		} catch (IOException e) {
				e.printStackTrace();
		} 
	}

}
