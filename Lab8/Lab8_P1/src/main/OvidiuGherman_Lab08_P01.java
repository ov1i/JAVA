package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.text.DateFormatSymbols;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;
//Read from the keyboard some strings representing dates formatted as DD/MM/YYYY.
// Print the dates as DD month YYYY, where month is the expanded version of the MM,
// and also display messages if the year is leap. The program exits when the user types in X or
// x from KB. You may use DateFormatSymbols class for month conversion.
public class OvidiuGherman_Lab08_P01 {
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		BufferedReader inputStream;


		// DateFormatSymbols day = new DateFormatSymbols();

		try {
			inputStream = new BufferedReader(new InputStreamReader(System.in));
			StreamTokenizer st = new StreamTokenizer(inputStream);
			System.out.println("Enter a day, a month and a year in the format DD/MM/YYYY or X, x to exit: ");
			while (st.nextToken()!= StreamTokenizer.TT_EOL) {
				if (st.ttype == StreamTokenizer.TT_WORD && st.sval.contains("/")) {
					st.sval = st.sval.replace("o", "*");
					System.out.println("The new string is: "+st.sval);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}  
	}
}