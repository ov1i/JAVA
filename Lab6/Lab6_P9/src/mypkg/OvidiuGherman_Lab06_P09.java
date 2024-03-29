package mypkg;

import java.util.Scanner;

/* 9. 
 * Define a class called Position which controls the position of a point in space (point_name (String), X,Y,Z coordinates
 * (Integer), constructors, setters, getters). Declare an array of maximum 3 objects of type Position. The user is then asked
 * to enter from the keyboard the number of desired objects. In the initialization sequence handle the
 * ArrayIndexOutOfBoundsException generated by an incorrect number of points asked for by the user.
 * Test all the coordinates of the entered points, and if any of these are closer to another point hard-coded in the program,
 * an exception of type PointTooClose is thrown. In the corresponding catch block the user is asked to re-enter the point's
 * coordinates until the data is considered to be correct. 
 */

class PointToClose extends Exception {
	public PointToClose() {
		super("Point to close exception!");
	}
}

class Position {
	private String point_name;
	private Integer x;
	private Integer y;
	private Integer z;
	public Position() {
		this.point_name = null;
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	public Position(String name, Integer x, Integer y, Integer z) {
		this.point_name = name;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public String getPoint_name() {
		return this.point_name;
	}
	public void setPoint_name(String point_name) {
		this.point_name = point_name;
	}
	public Integer getX() {
		return this.x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getZ() {
		return z;
	}
	public void setZ(Integer z) {
		this.z = z;
	}
	public void toClose(Position refPoint, double th, Scanner scanner) {
		boolean ok = false;
		while(!ok) {
			try {
				double distance = Math.sqrt(Math.pow(refPoint.getX()-this.getX(), 2) + Math.pow(refPoint.getY()-this.getY(), 2) + Math.pow(refPoint.getZ()-this.getZ(), 2));
				if(distance <= th) {
					throw new PointToClose(); 
				}
				else ok = true;
			}catch(PointToClose except) {
				System.out.println(except.getMessage() + "\nDistance <=" + th + "\nPlease try again: ");
				System.out.print("Please enter the name of the point: ");
				scanner.nextLine();
				this.setPoint_name(scanner.nextLine());
				System.out.print("Please enter the x,y,z coord.: ");
				this.setX(scanner.nextInt());
				this.setY(scanner.nextInt());
				this.setZ(scanner.nextInt());
			}		
		}
	}
}

public class OvidiuGherman_Lab06_P09 {

	public static void main(String[] args) {
		int size;
		Scanner scanner = new Scanner(System.in);
		Position objArr[] = new Position[3];
		Position refPoint = new Position("Reference Point", 0, 0, 0);
		
		System.out.print("Please enter the desired size of the array: ");
		size = scanner.nextInt();
		
		System.out.print("Please enter the threshold distance: ");
		double th = scanner.nextDouble();
		
		try {
			for(int i = 0;i<size;i++) {
				objArr[i] = new Position();
				System.out.print("Please enter the name of the point " + (i+1) + ": ");
				scanner.nextLine();
				objArr[i].setPoint_name(scanner.nextLine());
				System.out.print("Please enter the x,y,z coord.: ");
				objArr[i].setX(scanner.nextInt());
				objArr[i].setY(scanner.nextInt());
				objArr[i].setZ(scanner.nextInt());
				objArr[i].toClose(refPoint, th, scanner);
			}
		}catch(ArrayIndexOutOfBoundsException except) {
			System.out.println("Invalid desired size(MAX size reached)!");
			System.out.println("Execution continuing!");
		}
		
		
		System.out.println("->Reference point:Name->" + refPoint.getPoint_name() + ": [" + refPoint.getX() + "," + refPoint.getY() + "," + refPoint.getZ() + "]");
	
		System.out.println("The object array is: ");
		try {
			for(int i = 0; i < size;i++) {
				System.out.println("->Point " + (i+1) + ":Name->" + objArr[i].getPoint_name() + ": [" + objArr[i].getX() + "," + objArr[i].getY() + "," + objArr[i].getZ() + "]");
			}
		}catch(ArrayIndexOutOfBoundsException except) {
			System.out.println("Invalid desired size(MAX size reached)!");
			System.out.println("Execution will stop soon!");
		}
		scanner.close();
	}

}
