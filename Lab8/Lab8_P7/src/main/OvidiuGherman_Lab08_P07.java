package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/* 7. 
 * Write a Java application which enables the serialization and deserialization of objects that represent arrays of int
 * values. Populate an object with keyboard entered data, order the values and store the object in a file. Read the file and
 * display the reconstructed array of values.
 */

public class OvidiuGherman_Lab08_P07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.print("Please enter a command(serialize,deserialize,exit): ");
			String input = scanner.next();

			if(input.equalsIgnoreCase("serialize")) {
				System.out.print("Please enter the size of the integer array :");
				int size = scanner.nextInt();
				Integer array[] = new Integer[size];

				System.out.print("Please enter the elements of the array: ");

				for(int i = 0; i < array.length;i++) {
					array[i] = scanner.nextInt();
				}

				System.out.println("Serialization started!");

				FileOutputStream outFile;
				try {
					outFile = new FileOutputStream("output.bin");
					ObjectOutputStream outputSerializedStreamObj = new ObjectOutputStream (outFile);
					outputSerializedStreamObj.writeObject(array);
					outputSerializedStreamObj.close();
					outFile.close();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
					continue;
				}

				System.out.println("Serialization finished!");

			} else if(input.equalsIgnoreCase("deserialize")) {
				try {
					FileInputStream inputFile =new FileInputStream ("output.bin");
					ObjectInputStream inputSerializedStreamObj = new ObjectInputStream (inputFile);
					Integer deserializedIntData[] = (Integer[]) inputSerializedStreamObj.readObject();
					System.out.print("Deserialized data: ");
					for(Integer obj : deserializedIntData) {
						System.out.print(obj + " ");
					}
					inputSerializedStreamObj.close();
					inputFile.close();
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage() + "\nPlease create a serialized file first!");
					continue;
				} catch (IOException e) {
					System.out.println(e.getMessage());
					continue;
				} catch (ClassNotFoundException e) {					
					System.out.println(e.getMessage());
					continue;
				}
				System.out.println("\nDeserialization finished!");
			} else if(input.equalsIgnoreCase("exit")) {
				System.out.println("Goodbye!");
				break;
			} else { 
				System.out.println("UNKOWN COMMAND!");
			}		
		}
		scanner.close();
	}

}
