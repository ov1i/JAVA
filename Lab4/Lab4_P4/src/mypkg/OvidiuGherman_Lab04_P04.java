package mypkg;

import java.util.Scanner;

/*
 * Develop a Java program which defines a class named Person that contains as private attributes: name
 * (String), latitude and longitude (float). The class contains an explicit constructor without parameters that
 * will initialize the latitude and longitude with 0 and the string with null. A finalize() method will be used
 * as a destructor from C++ and will display a message. The mutator methods, setName(), setLongitude() and
 * setLatitude() will be defined to modify the attributes of the class. Define appropriate accesor methods.
 * Instantiate n objects, read the corresponding data from the keyboard and display the information related to all the objects.
 */

class Person {
	private String name;
	private float latitude, longitude;
	Person() {
		this.name = null;
		this.latitude = 0;
		this.longitude = 0;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getLatitude() {
		return this.latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return this.longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	
	@Override
	public void finalize() {
		this.name = null;
		this.latitude = 0.0f;
		this.longitude = 0.0f;
		System.out.println("Finalize method called succesfully!");
	}
}

public class OvidiuGherman_Lab04_P04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter the number of objects: ");
		int no_of_objects = scanner.nextInt();
		
		Person objs[] = new Person[no_of_objects];
		
		System.out.println("Objects DATA: ");
		for(int i = 0;i < objs.length;i++) {
			objs[i] = new Person();
			
			System.out.println("OBJ " + (i+1));
			System.out.print("Name: ");
			scanner.nextLine(); // we clear the input stream
			objs[i].setName(scanner.nextLine());
			System.out.print("Latitude: ");
			objs[i].setLatitude(scanner.nextFloat());
			System.out.print("Longitude: ");
			objs[i].setLongitude(scanner.nextFloat());
		}	
		scanner.close();
		
		//DISPLAY VIA GETTERS
		// Method 1
		for(int i = 0;i < objs.length;i++) {
			System.out.println("NAME: " + objs[i].getName() + "\n\t->LATITUDE: " + objs[i].getLatitude() + "\n\t->LONGITUDE: " + objs[i].getLongitude());
			objs[i] = null; // we force the object to be eligible for collection
		}
		
		/* Method 2 -> This will not show the message from the finalize method due to the fact, that the objects are not eligible for collection sooner yet.
		 * System.out.println("\n::Output::"); for(Person obj : objs) {
		 * System.out.println("NAME: " + obj.getName() + "\n\t->LATITUDE: " +
		 * obj.getLatitude() + "\n\t->LONGITUDE: " + obj.getLongitude()); }
		 */
		
		System.gc();
	}

}
