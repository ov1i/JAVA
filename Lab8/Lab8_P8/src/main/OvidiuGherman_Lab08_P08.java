package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//8. 
//	Write a Java application which reads a file with the following format:
//	*/rnd1_001.lab
//	A 0001
//	C 0003
//	D 0004
//	F 0003
//	A 0006
//	.
//	*/rnd2_002.lab
//	C 0003
//	F 0001
//	Z 0010
//	M 0011
//	.
//	…..
//	Separate the information from the file into distinct files which are named according to the line which starts with */ .

public class OvidiuGherman_Lab08_P08 {
	public static boolean checkNewFile(String line) {
		if(line.contains("*/")) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		BufferedReader buffer = null;				
		BufferedWriter outputFile = null;
		try {
			buffer = new BufferedReader(new FileReader("input.txt"));	
		} catch (FileNotFoundException e) {
			System.out.println("Failed to read the file!");
		} finally {
			System.out.println("Original input file read succesfully!");
		}
		
		String line = null;
		int counter = 0;
		System.out.println("Starting to split the input file into individual files!");
		try {
			while((line = buffer.readLine()) != null) {
				if(checkNewFile(line) && counter == 0) {
					outputFile = new BufferedWriter(new FileWriter(line.replace("*/", "")));
					counter++;
					continue;
				}
				else if(checkNewFile(line) && counter != 0) {
					outputFile.close();
					outputFile = new BufferedWriter(new FileWriter(line.replace("*/", "")));
					continue;
				}
				outputFile.write(line + "\n");
			}
			outputFile.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished splitting the origianl file into individual files!");
		}
	}

}
