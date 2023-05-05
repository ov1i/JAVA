package lab9;

import java.util.Scanner;

/* 1. 
 * Write a Java application which contains a class which implements the Runnable interface. The class' constructor sets
 * the name of the instantiated object. Also, there is a class variable which counts the number of instantiated objects from
 * that class. The run( ) method of the class will print the object's name for a number of times equal to the counter's value,
 * each printing being delayed 1000 Ms.
 * In a distinct class, create multiple threads built from separate objects of the previously described class. Analyze the results
 */


class MyClass implements Runnable {
	private String name;
	private static int counter = 0;
	public MyClass(String name) {
		this.name = name;
		MyClass.counter++;
	}

	@Override
	public void run() {
		for(int i = 0; i < MyClass.counter; i++) {
			System.out.println("Name: " + this.name + " ->" + (i+1));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class OvidiuGherman_Lab09_P01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the number of objects: ");
		int size = scanner.nextInt();


		for(int i = 0; i < size;i++) {
			System.out.print("Please enter the name of this thread: "); 
			MyClass task = new MyClass(scanner.next()); 
			Thread thread = new Thread(task);
			thread.start(); 
			try { thread.join(); 
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			} 
		}
		scanner.close();


		System.out.println("All threads finished their task!");
	}

}
