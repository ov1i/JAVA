package mypkg;

/*
 * Define a class X that will have the following attributes: a private array of characters, a protected String object
 * and an integer without access specifier. The class will contain an explicit constructor, which will initialize the
 * attributes, accessor and mutator methods for fields that cannot be accessed outside the class and redefine the
 * finalize () method inherited from the Object class, which will display an appropriate message.
 * In the main() method, placed in another class, create an object of X class, display the attribute values, and then
 * prepare the object to be removed by garbage collector. Then create a new X object, change the attribute values,
 * and display their attribute values.
 */

class X{
	private char[] arr;
	private String str;
	Integer nr;
	X() {
		arr = null;
		str = null;
		nr = null;
	}
	public char[] getArr() {
		return arr;
	}
	public void setArr(char[] arr) {
		this.arr = arr;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	@Override
	public void finalize() {
		arr = null;
		str = null;
		nr = null;
		System.out.println("The finalize method called succesfully!");
	}
}

public class OvidiuGherman_Lab04_P02 {

	public static void main(String[] args) {
		X obj1 = new X();
		
		System.out.println("Object 1: \nString: "  + obj1.getStr() + "\nInteger: " + obj1.nr);
		System.out.print("Char array: ");
		try {
			char []tempArr = obj1.getArr();
			for(char c : tempArr) {
			System.out.print(c);
		}
		} catch (NullPointerException ex) {
			System.out.print("-Array empty-\n");
		}
		
		obj1 = null;
		System.gc();
		
		X obj2 = new X();
		obj2.setArr(new char[]{'s', 's', 'b'});
		obj2.setStr("Hello");
		obj2.nr = 10;
		
		System.out.println("\nObject 2: \nString: "  + obj2.getStr() + "\nInteger: " + obj2.nr);
		System.out.print("Char array: ");
		try {
			char []tempArr = obj2.getArr();
			for(char c : tempArr) {
			System.out.print(c);
		}
		} catch (NullPointerException ex) {
			System.out.print("-Array empty-\n");
		}
		System.out.println("\n\n");
	}

}
