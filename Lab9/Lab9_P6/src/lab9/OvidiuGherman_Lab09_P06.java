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
	static String input = null;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		File file = new File("output.txt");
		try {
			writer = new BufferedWriter(new FileWriter(file));
			reader = new BufferedReader(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		while(true) {
			input = scanner.next();
			if(input.equalsIgnoreCase("end")) {
				try {
					writer.close();
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			else {
				Thread writingThread = new Thread(() -> {
					synchronized (file) {
						try {
							writer = new BufferedWriter(new FileWriter(file));
							writer.write(input + "\n");
						} catch (IOException e) {						
							e.printStackTrace();
						}
					}
				});
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
				writingThread.start();
				readingThred.start();
			}
		}
		scanner.close();	
	}

}
