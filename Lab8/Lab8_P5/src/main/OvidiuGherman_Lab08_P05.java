package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

/* 5. 
 * Write a Java application which reads a set of text files that contain students data (CSV files). The files are stored on the
 * local machine under the names Year_Y_Group_XXXX.txt . Aggregate the information in these files using a
 * SequenceInputStream and generate a new file which contains all the students ordered alphabetically.
 */

public class OvidiuGherman_Lab08_P05 {

	public static void main(String[] args) 
	{
		Comparator<String> comparator = new Comparator<>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);		
			}
		};	

		Vector<FileInputStream> files = new Vector<>();
		Scanner scanner = new Scanner(System.in);
		String input = null;
		while(true) {
			System.out.print("Please enter a CSV file(end->to exit): ");
			input = scanner.nextLine();
			if(input.equalsIgnoreCase("end")) {
				break;
			}
			else {
				try {
					files.add(new FileInputStream(input));
				} catch (FileNotFoundException e) {
					System.out.println("Invalid input!");
				}
			}
		}
		scanner.close();

		Enumeration<FileInputStream> inputStreamEnum = files.elements();
		SequenceInputStream sequenceStream = new SequenceInputStream(inputStreamEnum);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(sequenceStream));
		ArrayList<String> data = new ArrayList<>();
		String line = null;
		try {
			while((line = buffer.readLine()) != null) {
				data.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(FileInputStream obj : files) {
			try {
				obj.close();
			} catch (IOException e) {			
				e.printStackTrace();
			}	
		}

		try {
			data.sort(comparator);
			BufferedWriter newFile = new BufferedWriter(new FileWriter("output.csv"));
			for(String obj : data) {
				newFile.write(obj + "\n");
			}
			System.out.println("Output filed created succesfully!");
			newFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
