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
