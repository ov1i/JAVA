package lab9;

import java.util.Scanner;

/* 5.
 * Write a Java app which computes the greatest common divisor for large numbers (>100.000). The app will continuosly
 * read from the keyboard pairs of numbers and launch threads for each of the pairs. The results will be displayed in the
 * console as soon as they are available
 */

class GcdClass {
	private int a,b;
	private int res;

	public GcdClass(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int computeGCD() {
		for(int i = 1; i <= a && i <= b; i++)  
		{  
			if(a%i==0 && b%i==0) {		 
				this.res = i;
			}
		}
		return 1;
	}
	public void displayRes(String threadName) {
		System.out.println("\nThe result of the GCD(" + this.a + "," + this.b +"):" + this.res + "->" + threadName);
		System.out.print("Please enter a command(exit,new): ");
	}
}

public class OvidiuGherman_Lab09_P05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a,b;
		while(true) {
			System.out.print("Please enter a command(exit,new): ");
			String input = scanner.next();
			if(input.equalsIgnoreCase("exit")) {
				System.out.println("Goodbye!");
				break;
			}
			else if(input.equalsIgnoreCase("new")){
				do {
					System.out.print("Please enter a new pair of numbers(>100.000): ");
					a = scanner.nextInt();
					b = scanner.nextInt();
				} while(a <=100000 || b <=100000);
				GcdClass temp = new GcdClass(a, b);
				Thread threads = new Thread(() -> {
					temp.computeGCD();
					temp.displayRes(Thread.currentThread().getName());
				});
				threads.start();
			}
			else {
				System.out.println("Unknown command!");
			}
		}
		scanner.close();
	}

}
