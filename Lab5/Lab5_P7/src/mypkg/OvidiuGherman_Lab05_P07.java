package mypkg;

import java.util.Scanner;

/*	7.
 *  Define a class called Vehicle which has as attributes the maximum number of passengers, its color and the maximum
 *  speed. Extend the Vehicle class within the MotorizedVehicle class which also includes the geo-location attributes (GPS
 *  coordonates – create a class for this type of object GeoLoc) and the moving speed of the vehicle. MotorizedVehicle can
 *  move from point A to point B (the points are specified using a Point object which has two GeoLoc attributes) by using the
 *  move(Point B) method and which returns the total duration of the trip.
 *  Create a new class called Airplane which extends the MotorizedVehicle class and which add the attribute altitude to the
 *  move(Point B) method. This method will return the time needed to take the trip by taking into account that the plane
 *  will travel on arc of a circle specified through points A and B and the maximum altitude reached by the plane (the
 *  maximum altitude is reached half-way between A and B).
 */
interface ability {
	public double move(Point B);
}

class Point{
	private GeoLoc startLoc;
	private GeoLoc endLoc;
	
	Point() {
		startLoc = new GeoLoc();
		endLoc = new GeoLoc();
	}
	Point(GeoLoc startLoc, GeoLoc endLoc) {
		this.startLoc = startLoc;
		this.endLoc = endLoc;
	}
	public GeoLoc getStartLoc() {
		return this.startLoc;
	}
	public void setStartLoc(GeoLoc startLoc) {
		this.startLoc = startLoc;
	}
	public GeoLoc getEndLoc() {
		return this.endLoc;
	}
	public void setEndLoc(GeoLoc endLoc) {
		this.endLoc = endLoc;
	}
}

class GeoLoc {
	private double x;
	private double y;
	
	GeoLoc() {
		this.x = 0.0;
		this.y = 0.0;
	}
	GeoLoc(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return this.x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return this.y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
}

abstract class Vehicle implements ability{
	private int max_no_of_passangers;
	private String color;
	private double max_speed;
	
	Vehicle() {
		this.max_no_of_passangers = 0;
		this.color = null;
		this.max_speed = 0.0;
	}
	Vehicle(int passangers, double speed, String color) {
		this.max_no_of_passangers = passangers;
		this.max_speed = speed;
		this.color = color;
	}
	public int getMax_no_of_passangers() {
		return this.max_no_of_passangers;
	}
	public void setMax_no_of_passangers(int max_no_of_passangers) {
		this.max_no_of_passangers = max_no_of_passangers;
	}
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getMax_speed() {
		return this.max_speed;
	}
	public void setMax_speed(double max_speed) {
		this.max_speed = max_speed;
	}
}
class MotorizedVehicle extends Vehicle {
	private double moving_speed;
	private GeoLoc location;
	
	public MotorizedVehicle() {
		super();
		this.moving_speed = 0.0;
		this.location = new GeoLoc();
	}
	
	public MotorizedVehicle(int passangers, double maxSpeed, double movingSpeed, double lat, double lon, String color) {
		super(passangers, maxSpeed, color);
		this.moving_speed = movingSpeed;
		this.location = new GeoLoc(lat,lon);
	}

	public double getMoving_speed() {
		return moving_speed;
	}

	public void setMoving_speed(double moving_speed) {
		this.moving_speed = moving_speed;
	}

	public GeoLoc getLocation() {
		return this.location;
	}

	public void setLocation(double [] position) {
		this.location.setX(position[0]);
		this.location.setY(position[1]);
	}
	public double move(Point B ) {
		final double earth_rad = 6371; // Radius of the earth in km	
		double distLat, distLon, a, c, distance;
		
		distLat = Math.toRadians(B.getEndLoc().getX() - B.getStartLoc().getX());
		distLon = Math.toRadians(B.getEndLoc().getY() - B.getStartLoc().getY());
		
		a = Math.pow(Math.sin(distLat / 2),2) + Math.cos(Math.toRadians(B.getStartLoc().getX())) * Math.cos(Math.toRadians(B.getEndLoc().getX())) * Math.pow(Math.sin(distLon / 2), 2);
		c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		
		distance = earth_rad * c;
		
		
		return distance/this.moving_speed;
	}
}

class Airplane extends MotorizedVehicle { 
	private double z;
	
	Airplane() {
		super();
		this.z = 0;
	}
	
	Airplane(int passangers, double maxSpeed, double movingSpeed, double lat, double lon, double z, String color) {
		super(passangers, maxSpeed, movingSpeed, lat, lon, color);
		this.z = z;
	}

	public double getZ() {
		return this.z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	@Override
	public double move(Point B) {
		final double earth_rad = 6371; // Radius of the earth(KM)
		double distLat, distLon, a, c, distance, totalDistanceWithAltitude;
		
		distLat = Math.toRadians(B.getEndLoc().getX() - B.getStartLoc().getX());
		distLon = Math.toRadians(B.getEndLoc().getY() - B.getStartLoc().getY());
		
		a = Math.pow(Math.sin(distLat / 2),2) + Math.cos(Math.toRadians(B.getStartLoc().getX())) * Math.cos(Math.toRadians(B.getEndLoc().getX())) * Math.pow(Math.sin(distLon / 2), 2);
		c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		
		distance = earth_rad * c * 1000;
        totalDistanceWithAltitude = Math.sqrt(Math.pow(distance, 2) + Math.pow(this.z * 2, 2)) / 1000;

        return totalDistanceWithAltitude / this.getMoving_speed();
	}
}

public class OvidiuGherman_Lab05_P07 {
	
	public static <T> void displayData(T obj, Point B) {
		if(obj.getClass() == MotorizedVehicle.class) {
			System.out.println("\n:::Motorized Vehicle Data:::");
			System.out.println("Current Position: " + ((MotorizedVehicle) obj).getLocation().getX() + "|" + ((MotorizedVehicle) obj).getLocation().getY());
			System.out.println("Destination: " + B.getEndLoc().getX() + "|" + B.getEndLoc().getY());
			System.out.println("Max no. of passangers: " + ((MotorizedVehicle) obj).getMax_no_of_passangers());
			System.out.println("Color: " + ((MotorizedVehicle) obj).getColor());
			System.out.println("Max speed: " + ((MotorizedVehicle) obj).getMax_speed());
			System.out.println("Current speed: " + ((MotorizedVehicle) obj).getMoving_speed());
			System.out.println("Trip duration: " + ((MotorizedVehicle) obj).move(B) + " hours");
			return;
		}
		if(obj.getClass() == Airplane.class) {
			System.out.println("\n:::Airplane Data:::");
			System.out.println("Current Position: " + ((Airplane) obj).getLocation().getX() + "|" + ((Airplane) obj).getLocation().getY() + "|" + ((Airplane) obj).getZ()+ " (ALTITUDE)");
			System.out.println("Destination: " + B.getEndLoc().getX() + "|" + B.getEndLoc().getY());
			System.out.println("Max no. of passangers: " + ((Airplane) obj).getMax_no_of_passangers());
			System.out.println("Color: " + ((Airplane) obj).getColor());
			System.out.println("Max speed: " + ((Airplane) obj).getMax_speed());
			System.out.println("Current speed: " + ((Airplane) obj).getMoving_speed());
			System.out.println("Trip duration: " + ((Airplane) obj).move(B) + " hours");
			return;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//INPUT:MOTORIZED VEHICLE
		System.out.println("Please enter the data for the vehicle: ");
		System.out.print("Latitude(deg): ");
		double lat = scanner.nextDouble();
		System.out.print("Longitude(deg): ");
		double lon = scanner.nextDouble();
		System.out.print("Max no. of passangers: ");
		int max_no_of_passangers = scanner.nextInt();
		System.out.print("Max speed: ");
		double maxSpeed = scanner.nextDouble();
		double movingSpeed;
		do {
			System.out.print("Moving speed: ");
			movingSpeed = scanner.nextDouble();
		} while(movingSpeed > maxSpeed || movingSpeed < 0);
		
		System.out.print("Color: "); 
		scanner.nextLine();
		String color = scanner.nextLine();
		
		MotorizedVehicle car = new MotorizedVehicle(max_no_of_passangers, maxSpeed, movingSpeed, lat, lon, color);
		
		System.out.print("Please enter the destination(Lon,Lat): ");
		GeoLoc destination = new GeoLoc(scanner.nextDouble(), scanner.nextDouble());
		Point B = new Point();
		B.setStartLoc(car.getLocation());
		B.setEndLoc(destination);
		
		//OUTPUT:MOTORIZED VEHICLE
		displayData(car, B);
		
		//INPUT:AIRPLANE
		System.out.println("\n\nPlease enter the data for the airplane: ");
		System.out.print("Latitude(deg): ");
		lat = scanner.nextDouble();
		System.out.print("Longitude(deg): ");
		lon = scanner.nextDouble();
		System.out.print("Altitude(m): ");
		double altitude = scanner.nextDouble();
		System.out.print("Max no. of passangers: ");
		max_no_of_passangers = scanner.nextInt();
		System.out.print("Max speed: ");
		maxSpeed = scanner.nextDouble();
		do {
			System.out.print("Moving speed: ");
			movingSpeed = scanner.nextDouble();
		} while(movingSpeed > maxSpeed || movingSpeed < 0);
		
		System.out.print("Color: "); 
		scanner.nextLine();
		color = scanner.nextLine();
		
		Airplane plane = new Airplane(max_no_of_passangers, maxSpeed, movingSpeed, lat, lon, altitude, color);
		
		System.out.print("Please enter the destination(Lon,Lat): ");
		destination = new GeoLoc(scanner.nextDouble(), scanner.nextDouble());
		B.setStartLoc(plane.getLocation());
		B.setEndLoc(destination);
		
		//OUTPUT:AIRPLANE
		displayData(plane, B);
		
		scanner.close();
	}

}
