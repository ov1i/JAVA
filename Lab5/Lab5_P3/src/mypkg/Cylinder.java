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
