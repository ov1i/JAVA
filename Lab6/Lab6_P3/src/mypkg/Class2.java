package mypkg;
import int_Pkg.*;

public class Class2 extends Class1 implements Int1, Int2{

	public Class2() {
		super();
	}
	
	@Override
	public int sum() {
		return (int) (this.getA() + this.getB());
	}
	
	@Override
	public double product() {
		return this.getA() * this.getB();
	}
	
	public void printDefault() {
		System.out.print("\nThe sum of the two numbers is(default): " + Int1.super.sum());	
		System.out.print("\nThe product of the two numbers is(default): " + Int2.super.product());
	}
}
