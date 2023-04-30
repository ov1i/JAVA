package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/* 6.
 * Write an Employee class with the private fields name, age, salary and getter / setter methods for the fields. In the
 * main () method, placed in another class, create a list of Employee type objects, initialized with values read from the
 * keyboard. Sort the list in:
 * 		- ascending order by name, using the Comparable interface
 *		- descending order by age, using the Comparable interface and a lambda expression
 *		- ascending order by name and descending order by salary, using the Comparator interface
 */


class Employee implements Comparable<Employee>{
	private String name;
	private int age;
	private double salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public int compareTo(Employee o) {
		return name.compareToIgnoreCase(o.getName());
	}
	
	public static Comparator<Employee> comparator = new Comparator<>() {
		public int compare(Employee o1, Employee o2) {
			if(o1.getName().compareTo(o2.getName()) == 0){				
				if(o1.getSalary() < o2.getSalary()) {
					return 1;
				}
				else if(o1.getSalary() > o2.getSalary()) {
					return -1;
				}
			}
				return o1.getName().compareToIgnoreCase(o2.getName());		
		}
	};	
}

public class OvidiuGherman_Lab07_P06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		System.out.print("Please enter the number of employees: ");
		int size = scanner.nextInt();
		scanner.nextLine();

		for(int i = 0; i<size;i++) {
			Employee tempObj = new Employee();
			System.out.println("Employee " + (i+1) + ": ");
			System.out.print("Please enter the name of the employee: "); 
			tempObj.setName(scanner.nextLine());
			do {
				System.out.print("Please enter the employee's age: ");
				tempObj.setAge(scanner.nextInt());
			} while(tempObj.getAge() <= 0.0f);
			System.out.print("Please enter the salary of the employee: ");
			tempObj.setSalary(scanner.nextDouble());
			scanner.nextLine();
			list.add(tempObj);
		}
		scanner.close();

		Collections.sort(list);

		System.out.println("Output(#1 - Ordered ascending by name): ");
		for(Employee obj : list) {
			System.out.println("Name: " + obj.getName());
			System.out.println("Age: " + obj.getAge());
			System.out.println("Salary: " + obj.getSalary());
		}

		list.sort(
				(o1,o2) -> 
				{	
					Comparable<Employee> comp = (o) -> o2.getAge() - o.getAge();
				    return comp.compareTo(o1);	
					}
				);
		
		//list.sort((o1,o2) -> Integer.compare(o2.getAge(), o1.getAge()));

		System.out.println("Output(#2 - Ordered descending by age): ");
		for(Employee obj : list) {
			System.out.println("Name: " + obj.getName());
			System.out.println("Age: " + obj.getAge());
			System.out.println("Salary: " + obj.getSalary());
		}
		
		list.sort(Employee.comparator);
		System.out.println("Output(#3 - ascending by name and descending by salary using a comparator): ");
		for(Employee obj : list) {
			System.out.println("Name: " + obj.getName());
			System.out.println("Age: " + obj.getAge());
			System.out.println("Salary: " + obj.getSalary());
		}
		
	}

}
