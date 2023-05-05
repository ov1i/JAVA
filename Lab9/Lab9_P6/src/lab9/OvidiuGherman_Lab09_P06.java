package lab9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* 6. 
 * Write a Java application with a thread that writes some information into a file while another thread reads the written
 * data and displays it on the screen. Synchronize the threads.
 */


public class OvidiuGherman_Lab09_P06 {
	static BufferedWriter writer = null;
	static BufferedReader reader = null;
	static String input = "";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File file = new File("output.txt");	

		try {
			writer = new BufferedWriter(new FileWriter(file));
			reader = new BufferedReader(new FileReader(file));
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		System.out.println("Please enter some information(type end to stop gathering information): ");
		while(true) {
			String line = scanner.nextLine();
			if(line.equalsIgnoreCase("end")) {
				break;
			}
			input += line + "\n";
		}
		scanner.close();	
		Thread readingThred = new Thread(() -> {
			synchronized (file) {
				try {
					String line = null;
					while((line = reader.readLine()) != null) {
						System.out.println(line);
					}
				} catch (IOException e) {						
					e.printStackTrace();
				} 
			}
		});		
		Thread writingThread = new Thread(() -> {
			synchronized (file) {
				try {
					writer.write(input);
				} catch (IOException e) {						
					e.printStackTrace();
				}
			}

		});		


		writingThread.start();

		try {
			writingThread.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		readingThred.start();
		System.out.println("File data: ");
		try {
			readingThred.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
