package mypkg;

import java.util.Random;

/* 5. Write an application which checks if 3 random points form an obtuse triangle. If the condition is not met, a specific
 * exception is thrown: AcuteTriangle, RightTriangle. If the 3 points are on the same line or if the segments determined by
 * the 3 points cannot make up a triangle, throw an ImpossibleTriangle exception, and within the corresponding catch
 * block print a warning and throw a RuntimeException.
 */
interface checkShape {
	public void check() throws RightTriangle, AcuteTriangle, ImpossibleTriangle ;
}

class Point {
	private int x;
	private int y;
	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public double distance(Point other) {
        return Math.sqrt(((double)x - (double)other.x) * ((double)x - (double)other.x) + ((double)y - (double)other.y) * ((double)y - (double)other.y));
    }
}

class Shape implements checkShape{
	private Point a,b,c;
	
	
	public Shape() {
		this.a = null;
		this.b = null;
		this.c = null;
	}
	
	public Point getA() {
		return this.a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return this.b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return this.c;
	}

	public void setC(Point c) {
		this.c = c;
	}

	
	@Override
	public void check() throws RightTriangle, AcuteTriangle, ImpossibleTriangle {
		 double AB = a.distance(b);
	     double AC = a.distance(c);
	     double BC = b.distance(c);
	     
	     if(a.getX() == b.getX() && c.getX() == b.getX() && a.getX() == c.getX() || a.getY() == b.getY() && c.getY() == b.getY() && a.getY() == c.getY()) {
	    	 throw new ImpossibleTriangle();
	     }
	     else if(AB == 0 || AC == 0 || BC == 0) {
	    	 throw new ImpossibleTriangle();
	     }
	     if (Math.pow(AB, 2) == Math.pow(AC, 2) + Math.pow(BC, 2)) {
	    	 throw new RightTriangle();
	     } 
	     else if (Math.pow(AB, 2) < Math.pow(AC, 2) + Math.pow(BC, 2)) {
	    	 throw new AcuteTriangle();
	     }
	     else {
	    	 System.out.println("The given points form an obtuse triangle.");
	     }
	 }
}

class RightTriangle extends Exception {
	public RightTriangle() {
		super("Right Triangle exception generated!");
	}
}

class AcuteTriangle extends Exception {
	public AcuteTriangle() {
		super("Acute Triangle exception generated!");
	}
}

class ImpossibleTriangle extends Exception {
	public ImpossibleTriangle() {
		super("Impossible Triangle exception generated!");
	}
}

public class OvidiuGherman_Lab06_P05 {
	
	public static void main(String[] args) {
		Random random = new Random();
		Shape obj = new Shape();
		Point a = new Point(random.nextInt(0,50),random.nextInt(0,50));
		Point b = new Point(random.nextInt(0,50),random.nextInt(0,50));
		Point c = new Point(random.nextInt(0,50),random.nextInt(0,50));
		
		obj.setA(a);
		obj.setB(b);
		obj.setC(c);
		
		try {
			obj.check();			
		} catch(ImpossibleTriangle except) {
			try {
				System.out.println(except.getLocalizedMessage());
				throw new RuntimeException("Runtime exception for the following coord. :");
			} catch(RuntimeException e) {
				System.out.println(" -> " + e.getMessage() + "\nA(" + obj.getA().getX() + ", " + obj.getA().getY() + ")");
				System.out.println("B(" + obj.getB().getX() + ", " + obj.getB().getY() + ")");
				System.out.println("C(" + obj.getC().getX() + ", " + obj.getC().getY() + ")");
			}
		} catch(AcuteTriangle except) {
			System.out.println(except.getLocalizedMessage());
		} catch(RightTriangle except) {
			System.out.println(except.getLocalizedMessage());
		} 
	}
}
