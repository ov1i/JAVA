package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.text.DateFormatSymbols;
import java.util.Locale;

/* 3.
 * Read from the keyboard some strings representing dates formated as DD/MM/YYYY. Print the dates as DD month
 * YYYY, where month is the expanded version of the MM, and also display messages if the year is leap. The program exits
 * when the user types in X or x from KB. You may use DateFormatSymbols class for month conversion.
 */

public class OvidiuGherman_Lab08_P03 {

	public static void main(String[] args) {
		BufferedReader buffer = null;
		StreamTokenizer tokens = null;
		System.out.print("Please enter a date(DD/MM/YYYY): ");
		buffer = new BufferedReader(new InputStreamReader(System.in));
		tokens = new StreamTokenizer(buffer);  
		tokens.eolIsSignificant(true);
		tokens.ordinaryChar('/');
		DateFormatSymbols format = new DateFormatSymbols(new Locale("en", "RO"));
		int counter = 0;
		String[] months = format.getMonths();
		try {
			while (true) {

				tokens.nextToken();
				if(tokens.ttype == StreamTokenizer.TT_WORD && (tokens.sval.equals("x") || tokens.sval.equals("X"))) {
					System.out.println("Exiting the program!");
					break;
				}
				else {
					if(tokens.ttype == StreamTokenizer.TT_NUMBER) {
						if(counter == 1) {
							if((int)tokens.nval <= 0 || (int)tokens.nval > 12) {
								System.out.print("- ");
							}	
							else 
								System.out.print(months[(int)tokens.nval - 1] + " ");
						}
						else if(counter == 2) {
							if((int)tokens.nval <= 0 || (int)tokens.nval > 2023) {
								System.out.print("- ");
							}
							else {
								System.out.print((int)tokens.nval + " ");
								if((int)tokens.nval % 400 == 0 || ((int)tokens.nval % 4 == 0 && (int)tokens.nval % 100 != 0)){				
									System.out.print("->Leap Year");
								}
							}
						}						
						else {
							if((int)tokens.nval <= 31 && (int)tokens.nval > 0)
								System.out.print((int)tokens.nval + " ");
							else System.out.print("- ");
						}
						counter++;
					}		
				}

				if(tokens.ttype == StreamTokenizer.TT_EOL) {
					System.out.println();
					counter = 0;
					System.out.print("Please enter a date(DD/MM/YYYY): ");
				}		

			}
			buffer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
