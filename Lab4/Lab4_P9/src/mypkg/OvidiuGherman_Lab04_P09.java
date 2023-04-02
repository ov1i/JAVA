package mypkg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Define a class named Student that has as private attributes the name, tel. number and average mark (constructors, setters, getters).
 * In the main method create an uni-dimensional array of Student objects with the dimension specified by the user.
 * The data corresponding to each object is read from the keyboard, respecting the format name^^^tel.
 * number^^^average mark. If the data specific to the telephone number is not valid (10 numeric characters, with
 * or without special characters like blank, - or .), the user is asked to re-enter the entire array of characters.
 * Display the students ordered by name and by average mark.
 */

class Student {
	private String name;
	private String tel_number;
	private float avg_mark;
	
	Student() {
		name = null;
		tel_number = null;
		avg_mark = -1.0f;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel_number() {
		return this.tel_number;
	}

	public void setTel_number(String tel_number) {
		this.tel_number = tel_number;
	}

	public float getAvg_mark() {
		return this.avg_mark;
	}

	public void setAvg_mark(float avg_mark) {
		this.avg_mark = avg_mark;
	}
	
	static public boolean telValidation(String val) {
		if(val.matches("[0-9]{10}")) {
			return true;
		}
		else if(val.matches("[0-9]{3}[-. ]{1}[0-9]{3}[-. ]{1}[0-9]{4}")){
			return true;
		}
		return false;
	}
	static void checkValidAndSetData(Student[] students, Scanner scanner) {
		int i = 0, j = 0;
		boolean ok = true;
		while(i < students.length) {
			if(students[i] == null)
				students[i] = new Student();
			
			ok = true;
			System.out.print("Please enter the student data(Ex: name^^^telephone^^^avg. mark)(Student " + (i+1) + "): ");
			StringTokenizer data = new StringTokenizer(scanner.nextLine(), "^^^");
			
			while(data.hasMoreTokens()) {
				String token = data.nextToken();
				if(j == 0 && token.matches("[a-zA-Z ]+")) {
					students[i].setName(token);			
				}
				else if(j == 1 && Student.telValidation(token)) {
					students[i].setTel_number(token);
				}
				else if(j == 2 && token.matches("[0-9.]+")) {
					float avg_mark = Float.parseFloat(token);
					if(avg_mark >= 0.0f && avg_mark <= 10.0f) {					
						students[i].setAvg_mark(avg_mark);
					}
				}
				else {
					System.out.println("Error!" + "\nPlease try again!");
					ok = false;
					j = 0;
					break;
				}
				j++;
			}
			if(ok == true) {
				i++;
				j = 0;
			}
			
		}
	}
	static void displayData(Student[] students) {
		System.out.println(":::STUDENTS DATA:::");
		for(Student s : students) {
			System.out.println("Student: " + s.getName());
			System.out.println("->Telephone number: " + s.getTel_number());
			System.out.println("->Average mark: " + s.getAvg_mark());
		}
	}
}
public class OvidiuGherman_Lab04_P09 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter how many students we will have: ");
		int no_of_students = scanner.nextInt();
		scanner.nextLine();
		
		Student students[] = new Student[no_of_students];				
		Student.checkValidAndSetData(students, scanner);
		scanner.close();
		
		Arrays.sort(students, Comparator.comparing(Student::getName));
		Arrays.sort(students, Comparator.comparing(Student::getAvg_mark).reversed());
		
		Student.displayData(students);
	}

}
