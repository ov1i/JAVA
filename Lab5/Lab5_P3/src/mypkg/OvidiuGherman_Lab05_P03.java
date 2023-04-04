package mypkg;

import java.util.Scanner;

/* 3.
 *  Develop a class hierarchy of shapes and write a program that computes the amount of paint needed to paint different
 *  objects. The hierarchy will consist of a parent class Shape with three derived classes - Sphere, Rectangle, and Cylinder.
 *  For the purposes of this exercise, the only attribute a shape will have is a name and the method of interest will be one
 *  that computes the area of the shape (surface area in the case of three-dimensional shapes). Do the following.
 *  A. Write an abstract class Shape with the following members:
 *  	- an instance variable shapeName of String type
 *  	- an abstract method area()
 *  	- a toString() method that returns the name of the shape
 *  B. The file Sphere.java contains the Sphere class which is a descendant of Shape. A sphere has a radius as a private
 *  integer variable and implements the body of the inherited abstract method area().
 *  C. Define similar classes for a rectangle and a cylinder. The classes Rectangle and Cylinder are also derived from the
 *  Shape class. A rectangle is defined by its length and width. A cylinder is defined by a radius and height.
 *  Note: Each of the derived classes override the toString method and define specific mutator and accessor methods.
 *  D. The file Paint.java contains an interface that has a float constant paintPerSurfaceUnit.
 *  E. The file PaintThings.java implements the Paint interface and contains a program that computes the amount of paint
 *  needed to paint various shapes.
 *  Instantiate the three shape objects: deck <- Rectangle, bigBall <- Sphere and tank <- Cylinder. Make the appropriate
 *  method calls to assign each object’s specific attributes with data read from the keyboard.
 *  Compute the amount of paint needed for covering each created shape
 */

/*
 *  CODE:
 *  
 *  ----SHAPE----
 package mypkg;

public abstract class Shape {
	private String shapeName;
	abstract float area();
	Shape(String name) {
		this.shapeName = name;
	}
	public String toString() {
		return this.shapeName;
	}
}
*	----SHAPE----
*	----SPHERE----
package mypkg;

public class Sphere extends Shape{
	private int radius;
	Sphere(String name) {
		super(name);
		this.radius = 0;
	}
	
	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	float area() {
		return (float)(4* Math.PI * Math.pow(this.radius, 2));
	}
	
	@Override
	public String toString() {
		return super.toString() + ": \n\t-> radius" + this.radius;
	}
}
*	----SPHERE----
* 	----RECTANGLE----
package mypkg;

public class Rectangle extends Shape {
	private int length;
	private int width;
	
	public Rectangle(String name) {
		super(name);
		this.length = 0;
		this.width = 0;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	float area() {
		return (float)(this.length*this.width);
	}
	
	@Override
	public String toString() {
		return super.toString() + ": \n\t-> Width: " + this.width + "\n\t-> Length: " + this.length;
	}
}
*	----RECTANGLE----
*	----Cylinder----
package mypkg;

public class Cylinder extends Shape{
	private int radius;
	private int height;
	
	public Cylinder(String name) {
		super(name);
		this.radius = 0;
		this.height = 0;
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	float area() {
		return (float) (2 * Math.PI * Math.pow(this.radius, 2) + 2 * Math.PI * this.radius * this.height);
	}
	
	@Override
	public String toString() {
		return super.toString() + ": \n\t-> Radius: " + this.radius + "\n\t ->Height: " + this.height;
	}
	
}
*	----Cylinder----
*	----PAINT----
package mypkg;

public interface Paint {
	public float paintPerSurfaceUnit = 0.5f;
}
*	----PAINT----
* 	----PAINTTHINGS----
package mypkg;

public class PaintThings implements Paint{
	static public float computePaint(float surface) {
		return surface * Paint.paintPerSurfaceUnit;
	}
}
* 	----PAINTTHINGS----
 */

public class OvidiuGherman_Lab05_P03 {

	public static void main(String[] args) {	
		Rectangle deck = new Rectangle("My Deck");
		Sphere bigBall = new Sphere("My ball");
		Cylinder tank = new Cylinder("My tank");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter the length and the width of the deck: ");
		deck.setLength(scanner.nextInt());
		deck.setWidth(scanner.nextInt());
		
		System.out.print("Please enter the radius of the ball:  ");
		bigBall.setRadius(scanner.nextInt());
		
		System.out.print("Please enter the height and the radius of the tank: ");
		tank.setHeight(scanner.nextInt());
		tank.setRadius(scanner.nextInt());
		
		scanner.close();
		
		float temp = deck.area();
		System.out.println("\n\nELEMENT: \n" + deck.toString());
		System.out.println("The area/surface of the deck is "  + temp);
		System.out.println("The necessary paint to cover the entier deck is " + PaintThings.computePaint(temp) + " units");
	
		temp = bigBall.area();
		System.out.println("\n\nELEMENT: \n" + bigBall.toString());
		System.out.println("The area/surface of the ball is "  + temp);
		System.out.println("The necessary paint to cover the entier ball is " + PaintThings.computePaint(temp) + " units");
		
		temp = tank.area();
		System.out.println("\n\nELEMENT: \n" + tank.toString());
		System.out.println("The area/surface of the tank is "  + temp);
		System.out.println("The necessary paint to cover the entier tank is " + PaintThings.computePaint(temp) + " units");
	}

}
