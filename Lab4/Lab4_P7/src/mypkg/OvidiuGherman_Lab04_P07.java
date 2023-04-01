package mypkg;

import java.util.Date;
import java.util.Scanner;

/*
 * Write an application which defines a class named Child. Define the methods and member variables for this class
 * which enble a Child object to store/do the following:
 * 		- the name of the child
 * 		- the child’s birthday
 * 		- the child can introduce him/herself by „saying”: Hello my name is ...
 * 		- the child can tell his/her age
 * 		- the child can add two numbers smaller than 10 and return the result like so: The sum of X and Y is equal to Z
 * 		- the child knows how to say Goodbye!
 * 		- the child can speak the alphabet both in direct and inverse order
 * 		- the child can color a chess board given its dimensions by using alternative colors (for the colors use the symbols 1 and 0)
 * 		- the child can play dots and crosses (X-0) by him/herself 😊 (use the application developed in the previous homework)
 * Remarks: the child’s name and birthday cannot be accessed from outside the class.
 * All the information about a Child will be filled-in using a Child object and its associated methods and variables.
 * The interaction with the child will be done through an object which is instantiated in the main method.
 */

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
	public void sayAlphabet() {
		char i = 'a';
		System.out.println("Child: Yes sure I do: ");
		System.out.print("Child: ->Direct order: ");
		while(i <= 'z') {
			System.out.print(i + " ");
			i++;
		}
		System.out.print("\nChild: ->Inverse order: ");
		i = 'z';
		while(i >= 'a') {
			System.out.print(i + " ");
			i--;
		}
		System.out.println();
	}
	public void colorChessBoard(int rows, int columns) {
		System.out.println("Child: This is how the chessboard will look for the dimensions you mentioned: ");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(i % 2 == 0)
					System.out.print((j % 2) + " ");
				else System.out.print((i % 2 - j % 2) + " ");
			}
			System.out.println();
		}
	}
	public void playXandO(int dim) {
		System.out.println("Child: Yes I know how to play X and O: ");
		String[] str = new String[1];
		str[0] = Integer.toString(dim);
		OvidiuGherman_Lab03_p11.main(str);
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
		System.out.print("(Type \"Questions\" to see evey question you can ask the child)\n");
		scanner.nextLine();
		while(true) {
			System.out.print("INPUT: ");
			String command = scanner.nextLine();
			
			if(command.toLowerCase().equals("hi")) {
				obj.sayHello();
			}
			else if(command.toLowerCase().equals("bye")) {
				obj.sayGoodbye();
				break;
			}
			else if (command.toLowerCase().equals("how old are you?")) {
				obj.sayAge(today.getYear() + 1900, today.getMonth(), today.getDate());
			}
			else if (command.toLowerCase().equals("do you have any skills?")) {
				System.out.println("Yes I know how to add numbers!\nPlease give me 2 numbers to add: ");
				int nr1 = scanner.nextInt();
				int nr2 = scanner.nextInt();
				System.out.println(obj.skill(nr1, nr2));
				scanner.nextLine();
			}
			else if(command.toLowerCase().equals("do you know the alphabet?")) {
				obj.sayAlphabet();
			}
			else if(command.toLowerCase().equals("do you know how to play dots and cross?")) {
				System.out.println("Yes, but first give me the dimensions: ");
				int nr = scanner.nextInt();
				obj.playXandO(nr);
				scanner.nextLine();
			}
			else if(command.toLowerCase().equals("do you know how a chessboard looks like?")) {
				System.out.println("Yes, but first give me some dimensions: ");
				int rows = scanner.nextInt();
				int columns = scanner.nextInt();
				obj.colorChessBoard(rows, columns);
				scanner.nextLine();
			}
			else if(command.toLowerCase().equals("questions")) {
				System.out.println("QUESTIONS: \n->\"Hi\": Find the name of the child\n->\"Bye\": End the conversation\n->\"How old are you?\": Ask how old is the child");
				System.out.println("->\"Do you have any skills?\": Ask the child if he has any specific skills\n->\"Do you know the alphabet?\": Ask the child to spell the alphabet");
				System.out.println("->\"Do you know how to play dots and cross?\": Ask the child if he knows how the X and O game is played\n->\"Do you know how a chessboard looks like?\": Ask the child if he knows how a chessboard looks like");
			}
			
			else {
				System.out.println("Child: Sorry I do not understand the questions!");
			}
		}
		scanner.close();
	}

}
