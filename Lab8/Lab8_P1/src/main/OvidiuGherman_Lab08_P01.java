package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/* 1.
 * Using a KB reading mechanism (BufferedReader/InputStreamReader) input: a message of String type, a day as an
 * integer, a month as a String and a year as an integer variable. The process will end by passing to a new line, or by typing
 * a special String. Separate and display the tokens on different rows. Display all fields extracted from the stream as appeared.
 * Recommendation: use the StreamTokenizer class, the attributes sval, nval and the TT_EOL constant.
 * Consider the case in which the application is not aware of the entered data type (numbers, words). Use the constants
 * TT_NUMBER, TT_WORD.
 */

public class OvidiuGherman_Lab08_P01 {
	public static void main(String[] args) {
		BufferedReader buffer = null;
		StreamTokenizer tokens = null;
		System.out.print("Please enter something(such as: String->Message, Integer->Day, String->Month): ");
		buffer = new BufferedReader(new InputStreamReader(System.in));
		tokens = new StreamTokenizer(buffer);  
		tokens.eolIsSignificant(true);

		try {
			while (tokens.nextToken() != StreamTokenizer.TT_EOL) {
				if(tokens.ttype == StreamTokenizer.TT_WORD) {
					if(tokens.sval.toLowerCase().equals("end")) {
						System.out.println("Ending String found! ");					
						break;
					}
					else if(tokens.ttype == StreamTokenizer.TT_EOL) {
						System.out.println("End of line/stream reached!");
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