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
