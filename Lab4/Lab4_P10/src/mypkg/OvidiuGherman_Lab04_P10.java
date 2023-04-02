package mypkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Implement a class named Circle with the private attributes color (int), radius (float), planar position (2 integer).
 * Define the specific constructors and setter getter methods. The color is divided in 4 bytes, each of them
 * representing the transparency and the quantities of R, G and B.
 * In the main method (included in another class), read from the keyboard the data for n Circle objects.
 * Implement the methods that receive as parameter the array of objects and display:
 * 			- the circles whose center is included in one of the 4 quadrants
 * 			- the circles that are included entirely in one of the 4 quadrants
 * 			- the circles that have the centers on the same horizontal or vertical line
 * 			- the circles that have the R, G or B quantities in a certain specified interval
 */

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
	static public void checkCenterQuadrant(Circle[] circles) {
		System.out.println(":::CENTER CHECK:::");
		for(int i = 0; i < circles.length; i++ ) {
			if(circles[i].getX() > 0 && circles[i].getY() > 0) {
				System.out.println("The center of circle " + (i+1) + " is in the 1st Quadrant");
			}
			else if(circles[i].getX() < 0 && circles[i].getY() > 0) {
				System.out.println("The center of circle " + (i+1) + " is in the 2nd Quadrant");
			}
			else if(circles[i].getX() < 0 && circles[i].getY() < 0) {
				System.out.println("The center of circle " + (i+1) + " is in the 3rd Quadrant");
			}
			else if(circles[i].getX() > 0 && circles[i].getY() < 0) {
				System.out.println("The center of circle " + (i+1) + " is in the 4th Quadrant");		
			}
		}
	}
	static public void checkCircleQuadrant(Circle[] circles) {
		System.out.println(":::CIRCLE CHECK:::");
		for(int i = 0 ; i < circles.length; i++) {
			if((circles[i].getX() - circles[i].getRadius() >= 0 || circles[i].getY() - circles[i].getRadius()  >= 0) && (circles[i].getX() > 0 && circles[i].getY() > 0)) {
				System.out.println("The circle " + (i+1) + " is entirely in the 1st Quadrant");
			}
			else if((circles[i].getX() + circles[i].getRadius() <= 0 && circles[i].getY()  - circles[i].getRadius() >= 0) && (circles[i].getX() < 0 && circles[i].getY() > 0)){
				System.out.println("The circle " + (i+1)+ " is entirely in the 2nd Quadrant");
			}
			else if((circles[i].getX() + circles[i].getRadius() <= 0 && circles[i].getY() + circles[i].getRadius() <= 0) && (circles[i].getX() < 0 && circles[i].getY() < 0)){
				System.out.println("The circle " + (i+1) + " is entirely in the 3rd Quadrant");
			}
			else if((circles[i].getX() - circles[i].getRadius() >= 0 && circles[i].getY() + circles[i].getRadius() <= 0) && (circles[i].getX() > 0 && circles[i].getY() < 0)){
				System.out.println("The circle " + (i+1) + " is entirely in the 4th Quadrant");
			}
		}
	}
	public static void getCirclesOnSameHorizontalLine(Circle[] circles) {     	
		 List<Circle> tempCircles = new ArrayList<>();
		 boolean firstDisplay = true;
		 System.out.println("\n\n:::CIRCLE ON THE SAME HORIZONTAL LINE:::");
        for (int i = 0; i < circles.length; i++) {
        	firstDisplay = true;
        	for(int j = 0; j < circles.length; j++ ) {
        		if (Float.compare(circles[j].y, circles[i].y) == 0 && i != j&& !tempCircles.contains(circles[j])) {
        			if(firstDisplay == true) {
        				System.out.print("\nCircle" + (i+1));
        				tempCircles.add(circles[i]);
        				firstDisplay = false;;
        			}
        			tempCircles.add(circles[j]);
        			System.out.print("-> Circle" + (j+1));
        		}
        	}
        	
        }
        tempCircles = null;
    }
	public static void getCirclesOnSameVerticalLine(Circle[] circles) {     	
		 List<Circle> tempCircles = new ArrayList<>();
		 boolean firstDisplay = true;
		 System.out.println("\n\n:::CIRCLE ON THE SAME VERTICAL LINE:::");
		 for (int i = 0; i < circles.length; i++) {
			 firstDisplay = true;	
			 for(int j = 0; j < circles.length; j++ ) {
				 	if (Float.compare(circles[j].x, circles[i].x) == 0 && i != j && !tempCircles.contains(circles[j])) {
				 		if(firstDisplay == true) {
	        				System.out.print("\nCircle" + (i+1));
	        				tempCircles.add(circles[i]);
	        				firstDisplay = false;;
	        			}
				 		tempCircles.add(circles[j]);
				 		System.out.print("-> Circle" + (j+1));
				 	}
			 }	
		 }
	tempCircles = null;
	}
	public static void displayColor(Circle[] circles, int lowLimit, int highLimit) {
		System.out.println("\n\n:::CIRCLE COLOR:::");
		int currByte = 1;
		boolean print = true;
		for(int i = 0; i < circles.length; i++) {
			int []currColor = new int[4];
			currByte = 1;
			print = true;
			while(currByte <= 4) { 
				if(currByte == 1) {
					currColor[currByte-1] = circles[i].getColor() & 0xFF;
				}
				else {
					currColor[currByte-1] = (circles[i].getColor() >> 8 * (currByte - 1))& 0xFF;
				}
				currByte++;
			}
			
			for(int j = 0; j < currColor.length; j++) {
				
				if(currColor[j] < lowLimit || currColor[j] > highLimit || highLimit > 255) {
					print = false;
					break;
				}
			}
			if(print) {
				System.out.println("Circle " + (i+1) + " has the color in the [" + lowLimit + "," + highLimit + "] interval" );
			}
		}
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
			System.out.println("Please enter the coord. of circle " + (i+1) + ": "); 		
			System.out.print("x: "); 
			circles[i].setX(scanner.nextInt());
			System.out.print("y: "); 	
			circles[i].setY(scanner.nextInt());
			do {
				System.out.print("Please enter the radius of the circle: ");
				circles[i].setRadius(scanner.nextFloat());
			}while(circles[i].getRadius() < 0.0f);
			
			do {
				System.out.print("Please enter the color of the circle: ");
				circles[i].setColor(scanner.nextInt());
			}while(circles[i].getColor() < 0);
		}
		
		Circle.checkCenterQuadrant(circles);
		Circle.checkCircleQuadrant(circles);
		Circle.getCirclesOnSameHorizontalLine(circles);
		Circle.getCirclesOnSameVerticalLine(circles);
		System.out.println();
		int lowLimit, highLimit;
		do {
			System.out.print("Please enter the low and high limit of the interval: ");
			lowLimit = scanner.nextInt();
			highLimit = scanner.nextInt();
		}while(lowLimit < 0 || lowLimit > highLimit || highLimit > 255);		 
		
		scanner.close();
		
		Circle.displayColor(circles, lowLimit, highLimit);
		}

}
