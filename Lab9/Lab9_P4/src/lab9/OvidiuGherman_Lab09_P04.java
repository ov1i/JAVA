package lab9;

import java.util.Scanner;

/* 4. 
 * Write a Java app which uses the synchronized method access for mutual exclusion. Create 3 separate threads which
 * simultaneously call methods to increment and decrement a separate class' class variable. Check if the results are what
 * you expect them to be. Remove the synchronized blocks and reevaluate the results. 
 */

class incrementClass {
	private int value;

	public incrementClass(int value) {
		this.value = value;
	}

	public synchronized void incrementValue(String threadName) {
		this.value++;
		System.out.println(threadName + " incremented the value: " + value);
	}
	public  void decrementValue(String threadName) {
		this.value--;
		System.out.println(threadName + " decremented the value: " + value);
	}

	public int getValue() {
		return value;
	}
}

public class OvidiuGherman_Lab09_P04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the value that will be incremeneted/decremented: ");
		incrementClass task = new incrementClass(scanner.nextInt());
		scanner.close();
		Thread mt = null;
		for(int i = 0; i < 3;i++) {
			mt = new Thread(() -> {
				task.incrementValue(Thread.currentThread().getName());
				task.decrementValue(Thread.currentThread().getName());
			});
			mt.start();
		}
		
		//If we remove the synchronization from the methods the data will be corrupted due to the missing lock on the common resource, meaning the threads can access that data while other threads are using it already.
	}
}
