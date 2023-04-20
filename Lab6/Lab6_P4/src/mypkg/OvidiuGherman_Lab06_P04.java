package mypkg;

import java.util.Optional;

/* 4. Write a Java class derived from the Exception class, called SuperException. Another class, called SmallerException is
 * derived from SuperException. Within the classes' constructors print a message which indicates which exception was
 * generated. In a third class create a method a() which throws an exception of type SmallerException, and a method b()
 * which throws a SuperException.
 * In the main() method call these two methods and try to determine the type of exception which occurs, as well as if the
 * corresponding catch block for the SmallerException can catch a SuperException.
 */

class SuperException extends Exception {
	public SuperException() {
		super("Super Excpetion generated!");
	}
	public SuperException(Optional<String> msg) {
		super(msg.orElse("Super Excpetion generated!"));
	}
}

class SmallerException extends SuperException {
	public SmallerException() {
		super(Optional.of("Smaller Exception generated"));
	}
}
class myClass {
	public void a() throws SmallerException {
		throw new SmallerException();
	}
	
	public void b() throws SuperException {
		throw new SuperException();
	}
}
public class OvidiuGherman_Lab06_P04 {

	public static void main(String[] args) {
		myClass obj = new myClass();
		
		try {
			obj.a();
		} catch(SuperException except ) {
			System.out.println(except.getLocalizedMessage());
		}
		
		try {
			obj.a();
		} catch (SmallerException except) {
			System.out.println(except.getLocalizedMessage());
		}
		
		try {
			obj.b();
		} catch (SuperException except) {
			System.out.println(except.getLocalizedMessage());
		}

		/*
		 * try { obj.b(); } catch (SmallerException except) {
		 * System.out.println(except.getLocalizedMessage());
		 * }
		 */
		
	}

}
