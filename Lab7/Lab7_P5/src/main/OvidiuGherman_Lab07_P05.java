package main;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/* 5. 
 * Write a class named Student that has the private fields name, group, average_mark, and getter / setter methods for
 * all the attributes. In the main() method, placed in another class, create a sortedSet collection, with Student type objects,
 * initialized with values read from the keyboard, that will keep the elements in descending order by average_mark and in
 * ascending order by name (the students that have the same average will appear in alphabetic order). Browse the
 * collection using for-loop and display all the items. Then browse the collection with an iterator and display all students
 * with average_mark> = 8. Browse the collection with forEach () and display all student data in a particular group.
 */


class Student {
	private String name;
	private int group;
	private float average_mark;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public float getAverage_mark() {
		return average_mark;
	}
	public void setAverage_mark(float average_mark) {
		this.average_mark = average_mark;
	}
	
}


public class OvidiuGherman_Lab07_P05 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter the number of students: ");
		int n = scanner.nextInt();
		scanner.nextLine();
		
		Comparator<Student> comp = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getAverage_mark() > o2.getAverage_mark()){				
					return -1;
				}
				else if(o1.getAverage_mark() < o2.getAverage_mark()) {				
					return 1;
				}			
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		};
						
		SortedSet<Student> set = new TreeSet<>(comp);
		
		for(int i = 0; i < n;i ++) {
			Student tempStudent = new Student();
			System.out.println("Student " + (i+1) + ": ");
			System.out.print("Please enter the name of the student: "); 
			tempStudent.setName(scanner.nextLine());
			do {
				System.out.print("Please enter the average mark of the student: ");
				tempStudent.setAverage_mark(scanner.nextFloat());
			} while(tempStudent.getAverage_mark() > 10.0f || tempStudent.getAverage_mark() <= 0.0f);
			System.out.print("Please enter the group of the student: ");
			tempStudent.setGroup(scanner.nextInt());
			scanner.nextLine();
			set.add(tempStudent);
		}
		
		System.out.println("\nOutput(#1): ");
		for(Student obj : set) {
			System.out.println("Name: " + obj.getName());
			System.out.println("Average mark: " + obj.getAverage_mark());
			System.out.println("Group: " + obj.getGroup());
		}
		
		Iterator<Student> iterator = set.iterator();
		System.out.println("\nOutput(#2): ");
		System.out.println("->The students with average mark >= 8.0 are: ");
		while(iterator.hasNext()) {
			Student tempObj = iterator.next();
			if(tempObj.getAverage_mark() >= 8.0f ) {
				System.out.println("Name: " + tempObj.getName());
				System.out.println("Average mark: " + tempObj.getAverage_mark());
				System.out.println("Group: " + tempObj.getGroup());
			}
		}
		System.out.print("Please enter a desired group: ");
		int group = scanner.nextInt();
		scanner.close();
		
		System.out.println("\nOutput(#2): ");
		System.out.println("->The students within group " + group + " are: ");
		set.forEach(o -> {
			if(o.getGroup() == group) {
				System.out.println("Name: " + o.getName());
				System.out.println("Average mark: " + o.getAverage_mark());
				System.out.println("Group: " + o.getGroup());
			}
		});
	}

}
