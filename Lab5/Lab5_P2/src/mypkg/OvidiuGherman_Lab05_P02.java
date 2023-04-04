package mypkg;

import java.util.Scanner;

/* 2.
 * Define an interface called GeometricForm that contains methods which return the area and perimeter of the
 * geometric form. Implement the interface for: squares, rectangles, circles, equilateral triangles and isosceles triangles.
 * Read from the keyboard N distinct geometric forms specified by their type and specific parameters (for example for a
 * circle, you would need to read its radius). Compute the total area and perimeter of all the geometric forms, taking into
 * account the fact that they do not overlap.
 */

interface GeometricForm {
	float formArea();
	float formPerimeter();
}

class Squares implements GeometricForm {
	private float sideLength;

	public void setSideLength(float sideLength) {
		this.sideLength = sideLength;
	}
	public float getSideLength() {
		return this.sideLength;
	}
	
	@Override
	public float formArea() {
		return (float) Math.pow(this.sideLength, 2);
	}

	@Override
	public float formPerimeter() {
		return  4.0f * sideLength;
	}
}

class Circles implements GeometricForm {
	private float radius;

	public void setRadius(float radius) {
		this.radius = radius;
	}
	public float getRadius() {
		return this.radius;
	}
	
	@Override
	public float formArea() {
		return (float) (Math.PI * Math.pow(this.radius, 2));
	}

	@Override
	public float formPerimeter() {
		return (float)(Math.PI * 2.0f * this.radius);
	}
}

class Rectangles implements GeometricForm {
	private float length;
	private float width;
	public void setLength(float length) {
		this.length = length;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getLength() {
		return this.length;
	}
	public float getWidth() {
		return this.width;
	}
	
	@Override
	public float formArea() {
		return this.length*this.width;
	}
	@Override
	public float formPerimeter() {
		return 2.0f * this.length + 2.0f * this.width;
	}
}

abstract class Triangles implements GeometricForm {
	protected float side;

	public void setSides(float side) {
		this.side = side;
	}
	public float getSides() {
		return this.side;
	}
	
}

class EquilateralTriangle extends Triangles {
	@Override
	public float formArea() {
		return  (float) ((Math.pow(side, 2) * Math.sqrt(3))/4);
	}

	@Override
	public float formPerimeter() {
		return 3.0f * side;
	}
}
class IsoscelTriangle extends Triangles {
	private float base;
	
	public void setBase(float base) {
		this.base = base;
	}
	public float getBase() {
		return this.base;
	}
	
	@Override
	public float formArea() {
		return (float) ((base/4) * Math.sqrt((4*Math.pow(side, 2) - Math.pow(base, 2))));
	}

	@Override
	public float formPerimeter() {
		return 2.0f * side + base;
	}
	
	
}
public class OvidiuGherman_Lab05_P02 {
	static int checkForm(String input) {
		if(input.toLowerCase().equals("square")) {
			return 0;
		}
		else if (input.toLowerCase().equals("circle")) {
			return 1;
		}
		else if (input.toLowerCase().equals("rectangle")) {
			return 2;
		}
		else if (input.toLowerCase().equals("equilateral triangle")) {
			return 3;
		}
		else if (input.toLowerCase().equals("isoscel triangle")) {
			return 4;
		}
		else if (input.toLowerCase().equals("help")) {
			return 5;
		}
		return -1;
	}
	static float totalArea = 0;
	static float totalPeriemeter = 0;
	static <T> void display(String form, T obj) {
		
		if(form.toLowerCase().equals("square")) {
			float temp = ((GeometricForm) obj).formArea();	
			totalArea += temp;
			System.out.println("The area of the square is: " +  temp);
			temp = ((GeometricForm) obj).formPerimeter();
			totalPeriemeter += temp;
			System.out.println("The perimeter of the square is: " + temp);
			
			return;
		}
		if (form.toLowerCase().equals("circle")) {
			float temp = ((GeometricForm) obj).formArea();	
			totalArea += temp;
			System.out.println("The area of the circle is: " + temp);
			temp = ((GeometricForm) obj).formPerimeter();
			totalPeriemeter += temp;
			System.out.println("The perimeter of the circle is: " + temp);
			return;
		}
		if (form.toLowerCase().equals("rectangle")) {
			float temp = ((GeometricForm) obj).formArea();	
			totalArea += temp;
			System.out.println("The area of the rectangle is: " + temp);
			temp = ((GeometricForm) obj).formPerimeter();
			totalPeriemeter += temp;
			System.out.println("The perimeter of the rectangle is: " + temp);
			return;
		}
		if (form.toLowerCase().equals("equilateral triangle")) {
			float temp = ((GeometricForm) obj).formArea();	
			totalArea += temp;
			System.out.println("The area of the equilateral triangle is: " + temp);
			temp = ((GeometricForm) obj).formPerimeter();
			totalPeriemeter += temp;
			System.out.println("The perimeter of the equilateral triangle is: " + temp);
			return;
		}
		if (form.toLowerCase().equals("isoscel triangle")) {
			float temp = ((GeometricForm) obj).formArea();	
			totalArea += temp;
			System.out.println("The area of the isoscel triangle is: " + temp);
			temp = ((GeometricForm) obj).formPerimeter();
			totalPeriemeter += temp;
			System.out.println("The perimeter of the isoscel triangle is: " + temp);
			return;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter how many geometric forms we will have: ");		
		int n = scanner.nextInt();
		scanner.nextLine(); System.out.println("TYPE HELP TO SEE WHAT GEOMETRIC FORMS ARE AVAILABLE");
		while(n > 0) {
			System.out.print("Please enter a command: ");
			String input = scanner.nextLine();
			
			switch (checkForm(input)) {
			case 0:
			{
				Squares obj = new Squares();
				do {
					System.out.print("Please enter the side of the square: ");
					obj.setSideLength(scanner.nextFloat());
				} while(obj.getSideLength() < 0);	
				scanner.nextLine();
				display(input,obj);
				n--;
				break;
			}
			case 1:
			{
				Circles obj = new Circles();
				do {
					System.out.print("Please enter the radius of the circle: ");
					obj.setRadius(scanner.nextFloat());
				} while(obj.getRadius() < 0);	
				scanner.nextLine();
				display(input,obj);
				n--;
				break;
			}
			case 2:
			{
				Rectangles obj = new Rectangles();
				do {
					System.out.print("Please enter the sides of the rectangle: ");
					obj.setLength(scanner.nextFloat());
					obj.setWidth(scanner.nextFloat());
				} while(obj.getWidth() < 0 || obj.getLength() < 0);	
				scanner.nextLine();
				display(input,obj);
				n--;
				break;
			}
			case 3: 
			{
				EquilateralTriangle obj = new EquilateralTriangle();
				do {
					System.out.print("Please enter the two equal sides of the equilateral triangle: ");
					obj.setSides(scanner.nextFloat());
				} while(obj.getSides() < 0);	
				scanner.nextLine();
				display(input,obj);
				n--;
				break;
			}
			case 4:
			{
				IsoscelTriangle obj = new IsoscelTriangle();
				do {
					System.out.print("Please enter the two equal sides and the base of the isoscel triangle: ");
					obj.setSides(scanner.nextFloat());
					obj.setBase(scanner.nextFloat());		
				} while(obj.getSides() < 0 || obj.getBase() < 0);	
				scanner.nextLine();
				display(input,obj);
				n--;
				break;
			}
			case 5: 
			{
				System.out.println("::HELP::\nFor square type: \"Square\"");
				System.out.println("For rectangle type: \"Rectangle\"");
				System.out.println("For circle type \"Circle\"");
				System.out.println("For equilateral triangle type: \"Equilateral triangle\"");
				System.out.println("For isoscel triangle type: \"Isoscel triangle\"");
				System.out.println("For help type: \"Help\"");
				break;
			}
			case -1:
			{
				System.out.println("Invalid input!\nTry again!");
				break;
			}
			}
		}
		scanner.close();	
		
		
		System.out.println("\n\nTotal area: " + totalArea);
		System.out.println("Total perimeter: " + totalPeriemeter);
		System.out.println("\nProgram closed succesfully!");
	}
}
