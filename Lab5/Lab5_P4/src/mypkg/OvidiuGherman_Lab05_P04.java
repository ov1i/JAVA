package mypkg;

import java.util.Scanner;

/* 4.
 * Consider the Fraction class that has two protected attributes a and b for the counter and denominator, two set () and
 * get () methods for each of the class attributes. Define an explicit constructor without parameters that initiates a with 0
 * and b with 1, and an explicit constructor with two parameters that can be called if it is checked whether a fraction can
 * be defined (b! = 0). Define a method simplify () that simplifies and returns a Fraction object by calling the int
 * greatestCommonDivider (int, int) method (based on divisions). Define a method for adding two Fraction objects, which
 * returns a Fraction object. Define a ExtendedFraction class derived from Fraction, which will have a constructor with
 * parameters (which calls the constructor from the base class) and which will redefine the method simplify() using an int
 * greatestCommonDivider (int, int) algorithm based on subtractions. Add a method for subtracting two fractions.
 * Instantiate two Fraction objects without parameters. Set the attributes of the data objects read from the keyboard.
 * Display the original attributes of the objects and the new defined attributes. Simplify, add and display results. Instantiate
 * two ExtendedFraction objects with data read from the keyboard. Simplify, add and subtract objects and display results.
 * Make an upcast from ExtendedFraction to Fraction and try to subtract the items. All operations will be called from the main() method.
 */


class Fraction {
	protected int a;
	protected int b;
	
	Fraction() {
		this.a = 0;
		this.b = 1;
	}
	Fraction(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int getA() {
		return this.a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return this.b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	
	private int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		else return gcd(b,a%b);
	}
	public Fraction simplify() {
		Fraction tempRes = new Fraction();
		
		tempRes.setA(this.a < 0 ? -this.a : this.a);
		tempRes.setB(this.b < 0 ? -this.b : this.b);
		
		int gcd_val = gcd(tempRes.getA(), tempRes.getB());
		
		tempRes.setA(tempRes.getA()/gcd_val);
		tempRes.setB(tempRes.getB()/gcd_val);
		
		if(this.a < 0) {
			tempRes.setA(-tempRes.getA());
		}
		if(this.b < 0) {
			tempRes.setB(-tempRes.getB());
		}		
		return tempRes;
	}
	
	public Fraction addition(Fraction obj1) {
		Fraction tempRes = new Fraction();
		
		tempRes.setA(obj1.getA() + this.getA());
		tempRes.setB(obj1.getB() + this.getB());
		
		return tempRes;
	}
}

class ExtendedFraction extends Fraction {
	public ExtendedFraction() {
		super();
	}
	public ExtendedFraction(int a, int b) {
		super(a,b);
	}
		
	private int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		else return gcd(b, Math.abs(a - b));
	}

	public ExtendedFraction simplify() {
		ExtendedFraction tempRes = new ExtendedFraction();
		
		tempRes.setA(this.a < 0 ? -this.a : this.a);
		tempRes.setB(this.b < 0 ? -this.b : this.b);
		
		int gcd_val = gcd(tempRes.getA(), tempRes.getB());
		
		tempRes.setA(tempRes.getA()/gcd_val);
		tempRes.setB(tempRes.getB()/gcd_val);
		
		if(this.a < 0) {
			tempRes.setA(-tempRes.getA());
		}
		if(this.b < 0) {
			tempRes.setB(-tempRes.getB());
		}		
		return tempRes;
	}
	
	public ExtendedFraction subtraction(ExtendedFraction obj1) {
		ExtendedFraction tempRes = new ExtendedFraction();
		
		tempRes.setA(obj1.getA() - this.getA());
		tempRes.setB(obj1.getB() - this.getB());
		
		return tempRes;
	}
}

public class OvidiuGherman_Lab05_P04 {

	public static void main(String[] args) {
		Fraction obj1 = new Fraction();
		Fraction obj2 = new Fraction();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("The first fraction is: " + obj1.getA() + "/" + obj1.getB());
		System.out.print("Please enter the first fration(a/b): ");
		obj1.setA(scanner.nextInt());
		obj1.setB(scanner.nextInt());
		System.out.println("The new values of the first fraction is: " + obj1.getA() + "/" + obj1.getB());
		System.out.println("The second fraction is: " + obj2.getA() + "/" + obj2.getB());
		System.out.print("Please enter the second fration(a/b): ");
		obj2.setA(scanner.nextInt());
		obj2.setB(scanner.nextInt());
		System.out.println("The new values of the second fraction is: " + obj2.getA() + "/" + obj2.getB());
		
		
		Fraction simplified_obj1 = obj1.simplify();
		Fraction simplified_obj2 = obj2.simplify();
		
		System.out.println("The first simplified fraction is: " + simplified_obj1.getA() + "/" + simplified_obj1.getB());
		System.out.println("The second simplified fraction is: " + simplified_obj2.getA() + "/" + simplified_obj2.getB());
		
		Fraction additionObj = obj1.addition(obj2);
		System.out.println("The result of the addition is: " + additionObj.getA() + "/" + additionObj.getB());
		
		
		System.out.print("Please enter a third fraction(a/b): ");
		ExtendedFraction obj3 = new ExtendedFraction(scanner.nextInt(), scanner.nextInt());
		System.out.print("Please enter a fourth fraction(a/b): ");
		ExtendedFraction obj4 = new ExtendedFraction(scanner.nextInt(), scanner.nextInt());
		
		scanner.close();
		
		System.out.println("The third simplified fraction is: " + obj3.getA() + "/" + obj3.getB());
		System.out.println("The fourth simplified fraction is: " + obj4.getA() + "/23" + obj4.getB());
		
		ExtendedFraction subtractionObj = obj3.subtraction(obj4);
		System.out.println("The result of the subtraction is: " + subtractionObj.getA() + "/" + subtractionObj.getB());
		
		Fraction castedObj1 = (Fraction)obj3;
		Fraction castedObj2 = (Fraction)obj4;
		
		//Fraction subtractioncastedObj = castedObj1.subtraction(castedObj2);
		Fraction additionCastedObj = castedObj1.addition(castedObj2);
		
		System.out.println("The result of the addition of 2 casted object: " + additionCastedObj.getA() + "/" + additionCastedObj.getB());
	}

}
