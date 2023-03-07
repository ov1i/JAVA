package mypkg;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.Console;



public class OvidiuGherman_Lab02_p1 {

	public static void main(String[] args) {
			BufferedReader buffer;
			Scanner scanner;			
			Console console;
			String str = "-";
			int nr1 = 0, nr2 = 0;
			
			
			buffer = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Please enter a text: ");
			System.out.flush();
	
			try {
				str = buffer.readLine();
			} catch (IOException ioe) {
				System.out.println(ioe.toString());
				System.exit(1);
			}
			
			str = str.toUpperCase();
			System.out.println("The text with uppercase letter is: " + str);
			
			
			System.out.println("Please enter two numbers: ");
			System.out.flush();
			
			scanner = new Scanner(System.in);
			
			nr1 = scanner.nextInt();
			nr2 = scanner.nextInt();			
			
			scanner.close();
			
			System.out.println("The sum of the numbers is: " + (nr1 + nr2));
			
			console = System.console( );
					
			
			try {				
				str = console.readLine();
			} catch (NullPointerException ioe) {
				System.out.println("ERROR: NO CONSOLE INPUT!");
				str = null;
			}  
				
			
			if(str != null) {
				nr1 = Integer.parseInt(str.replaceAll("[^0-9]", ""));
				if(nr1 < 0)
					System.out.println("The number " + nr1 + " is a negative one!");
				else if(nr1 > 0) 
					System.out.println("The number " + nr1 + " is a positive one!");
				else 
					System.out.println("The number is: " + nr1);
			}			
	}

}
