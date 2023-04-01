package mypkg;

import java.util.Date;
import java.util.Scanner;


class Child {
	private String name;
	private int day, month,year;
	
	Child(String name, int day, int month, int year) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public void sayHello() {
		System.out.println("Child: Hello my name is " + this.name);
	}
	public void sayAge(int currentYear, int currentMonth, int currentDay) {
		int age =  currentYear - this.year;
		
		if(currentMonth < this.month && currentYear == this.year) {
			age--;
			System.out.println("Child: I am " + age + " years old!");
		}
		else if(currentMonth == this.month && currentDay < this.day && currentYear == this.year) {
			age--;
			System.out.println("Child: I am " + age + " years old!");
		}
		else {
			System.out.println("Child: I am " + age + " years old!");
		}
	}
	public StringBuilder skill(int nr1 , int nr2) {
		if (nr1 > 10 || nr2 > 10) {
			return new StringBuilder("Child :I'm sorry I don't know how to add this numbers");
		}
		else return new StringBuilder("Child: The sum of "  + nr1 + " and " + nr2 + " is equal to " + (nr1+nr2));
	}
	public void sayGoodbye() {
		System.out.println("Child: Goodbye!");
	}
	public void sayAlphabeth() {
		int i = 'a';
		System.out.println("Child: Yes sure I can: ");
		System.out.print("Child: ->Direct order: ");
		while(i <= 'z') {
			System.out.print((char)i + " ");
			i++;
		}
		System.out.print("\nChild: ->Inverse order: ");
		i = 'z';
		while(i >= 'a') {
			System.out.print((char)i + " ");
			i--;
		}
	}
	public void colorChessBoard(int rows, int columns) {
		System.out.println("Child: This is how the chessboard will look: ");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(i % 2 == 0)
					System.out.print((j % 2) + " ");
				else System.out.print((i % 2 - j % 2) + " ");
			}
			System.out.println();
		}
	}
	public void playXandO() {
		System.out.println("Child: Yes I know how to play X and O: ");
		OvidiuGherman_Lab03_p11.main(null);
	}
}
public class OvidiuGherman_Lab04_P07 {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date today = new Date();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the name and the birthday of the child: ");
		System.out.print("\nName:");
		String name = scanner.nextLine();

		int year, month, day;	
		do{ 
			System.out.print("Year: ");
			year = scanner.nextInt();
		} while (year >= today.getYear() + 1900 || year <= 1900);
		
		do {
			System.out.print("Month: ");
			month = scanner.nextInt();
		} while(month > 12);
		
		do {
			System.out.print("Day: ");
			day = scanner.nextInt();
			if(month == 2 & day > 29) {
				day = 30;
			}
		}while(day > 31);
		
		Child obj = new Child(name, day, month, year);
		
		while(true) {
			String command = scanner.nextLine();
			
			if(string)
		}
		
		obj.colorChessBoard(4, 4);
		obj.playXandO();
		obj.sayAge(today.getYear() + 1900, today.getMonth(), today.getDate());
		scanner.close();
	}

}
