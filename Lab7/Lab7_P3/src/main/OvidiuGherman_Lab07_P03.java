package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 3.
 *  Build an application which contains a generic class SetterGetter which allows the user to set() and get() the attribute
 *  values for different types of objects. For example, given the classes Kid, Adult and Retired, enable the class to set and get
 *  the names and ages of the associated objects. Create collections with unique entries of type Kid, Adult and Retired, and
 *  which are populated with data read from the console. Print the read data using different methods.
 */

class SetterGetter<T extends Human>  {

	private T obj;
	public SetterGetter(T obj) {
		this.obj = obj;
	}
	public String getName() {
		return obj.name;
	}

	public void setName(String name) {
		this.obj.name = name;
	}

	public int getAge() {
		return this.obj.age;
	}

	public void setAge(int age) {
		this.obj.age = age;
	}
	public T getObj() {
		return obj;
	}
}
abstract class Human {
	protected String name;
	protected int age;
}
class Kid extends Human {}
class Adult extends Human {}
class Retired extends Human {}


public class OvidiuGherman_Lab07_P03 {
	private static void extracted(Object tObj) {
		SetterGetter<?> obj = null;
		if(tObj instanceof Kid) {
			obj = new SetterGetter<Kid>((Kid)tObj);
		}
		else if(tObj instanceof Adult) {
			obj = new SetterGetter<Adult>((Adult)tObj);
		}
		else if(tObj instanceof Retired) {
			obj = new SetterGetter<Retired>((Retired)tObj);
		}	
		System.out.print("\t" + tObj.getClass().getSimpleName() + ": Name-> " + obj.getName() + ", Age -> " + obj.getAge() + "\n");
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SetterGetter<?> obj = null;
		System.out.print("Please enter the number of Kids, Adults and Retired persons: ");
		int kids = scanner.nextInt();
		int adults = scanner.nextInt();
		int retired_people = scanner.nextInt();
		scanner.nextLine();

		List<Object> objects = new ArrayList<>();

		while(!(kids == 0 && adults == 0 && retired_people == 0)) {
			if(kids != 0) {
				obj = new SetterGetter<Kid>(new Kid());
				System.out.print("Please enter the name of the child: ");
				obj.setName(scanner.nextLine());
				System.out.print("Please enter the age of the child: ");
				obj.setAge(scanner.nextInt());
				scanner.nextLine();
				objects.add(obj.getObj());
				kids--;
			}
			if(adults != 0) {
				obj = new SetterGetter<Adult>(new Adult());
				System.out.print("Please enter the name of the adult: ");
				obj.setName(scanner.nextLine());
				System.out.print("Please enter the age of the adult: ");
				obj.setAge(scanner.nextInt());
				scanner.nextLine();
				objects.add(obj.getObj());
				adults--;
			}
			if(retired_people != 0) {
				obj = new SetterGetter<Retired>(new Retired());
				System.out.print("Please enter the name of the retired person: ");
				obj.setName(scanner.nextLine());
				System.out.print("Please enter the age of the retired person: ");
				obj.setAge(scanner.nextInt());
				scanner.nextLine();
				objects.add(obj.getObj());
				retired_people--;
			}
		}	
		scanner.close();

		System.out.println("Output(#1):");
		for (Object tempObj: objects) {
			if(tempObj instanceof Kid) {
				obj = new SetterGetter<Kid>((Kid)tempObj);	   
				System.out.print("\tKid: ");
			}
			else if(tempObj instanceof Adult) {
				obj = new SetterGetter<Adult>((Adult)tempObj);
				System.out.print("\tAdult: ");
			}
			else if(tempObj instanceof Retired) {
				obj = new SetterGetter<Retired>((Retired)tempObj);
				System.out.print("\tRetired person: ");
			}    	 
			System.out.print("Name-> " + obj.getName() + ", Age -> " + obj.getAge() + "\n");
		}   

		System.out.println("Output(#2):");
		objects.forEach(tObj -> extracted(tObj));
	}

}
