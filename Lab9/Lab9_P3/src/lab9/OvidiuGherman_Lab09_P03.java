package lab9;

import java.util.ArrayList;
import java.util.Scanner;

/* 3.
 * Write a class for determining a certain value from Fibonacci’s array. The class has 2 methods, one for calculating and
 * the other for displaying the desired value. Use a synchronized multi-threading mechanism in which one process displays
 * all the Fibonacci's numbers smaller than the desired value computed by the other process.
 */


class fibGenerator{
	private int value;
	private ArrayList<Integer> fibArray;

	public fibGenerator(int value) {
		this.value = value;
		fibArray = new ArrayList<>();
	}
	public synchronized void findFibAtValue() {
		if(this.value == 0 || this.value == 1) {
			return;
		}
		int nr0 = 0, nr1 = 1;
		int tempTerm;
		for (int i = 2; i <= this.value; i++) {
			tempTerm = nr0 + nr1;
			fibArray.add(nr1);
			nr0 = nr1;
			nr1 = tempTerm;
		}
		this.value = nr1;

		return;
	}
	public synchronized void printResult() {
		System.out.println("The desired fib number is: " + this.value);
	}
	public ArrayList<Integer> getFibArray() {
		return fibArray;
	}
	public int getValue() {
		return value;
	}
}

public class OvidiuGherman_Lab09_P03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter a desired value from the fib sequence: ");
		fibGenerator generator = new fibGenerator(scanner.nextInt());		 
		scanner.close();

		Thread computeAndDisplayThread = new Thread(() -> {
			generator.findFibAtValue();
			generator.printResult();
		});

		Thread displayArrayOfResultsThread = new Thread(() -> {
			ArrayList<Integer> tempArray = generator.getFibArray();
			System.out.print("The fib numbers smaller than " + generator.getValue() + " are: ");
			for(Integer obj : tempArray) {
				System.out.print(obj + " ");
			}
			System.out.println();
		});

		System.out.println("Threads created succesfully!");

		computeAndDisplayThread.start();
		System.out.println("computeAndDisplayThread started!");
		try {
			computeAndDisplayThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		displayArrayOfResultsThread.start();
		System.out.println("displayArrayOfResultsThread started!");
		try {
			displayArrayOfResultsThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Both threads finished their task!");
	}
}
