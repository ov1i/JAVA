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
