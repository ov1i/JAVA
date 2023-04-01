package mypkg;

import java.util.Scanner;

class Circle {
	private int color;
	private float radius;
	private Integer x,y;
	
	Circle() {
		color = 0;
		radius = 0.0f;
		x = y = 0;	
	}

	public int getColor() {
		return this.color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public float getRadius() {
		return this.radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public Integer getX() {
		return this.x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return this.y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
}
public class OvidiuGherman_Lab04_P10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter how many circles we will have: ");
		int no_of_circles = scanner.nextInt();
		
		Circle circles[] = new Circle[no_of_circles];
		
		for(int i = 0; i < circles.length; i++) {
			circles[i] = new Circle();
			System.out.println("Please enter the coord. of the circle: "); 		
			System.out.print("x: "); 
			circles[i].setX(scanner.nextInt());
			System.out.print("y: "); 	
			circles[i].setY(scanner.nextInt());
			System.out.print("Please enter the radius of the circle: ");
			circles[i].setRadius(scanner.nextFloat());
			System.out.print("Please enter the color of the circle: ");
			circles[i].setColor(scanner.nextInt());
		}
		scanner.close();
		}

}
