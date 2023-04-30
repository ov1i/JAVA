package main;

import java.util.Scanner;

/* 2.
 * Write a class called Calculator which has the methods to do addition, subtraction, multiplication and division. The
 * methods will take generic input variables and will return the corresponding type. For example, the sum of two integers
 * should return an integer, and for floats it should return a float. Same for division. Adding and subtracting is allowed for
 * String variables as well, but the multiplication and division will print an error message.
 * Write the same class, but use method overloading.
 */


class Calculator {
	@SuppressWarnings("unchecked")
	public static <T> T addition(T val1, T val2) throws Exception {
		if(val1.getClass().equals(Integer.class) && val2.getClass().equals(Integer.class)) {
			return (T)(Integer)((int)val1 + (int) val2);
		}
		else if(val1.getClass().equals(Double.class) && val2.getClass().equals(Double.class)) {
			return (T)(Double)((double)val1 + (double) val2);
		}
		else if(val1.getClass().equals(Float.class) && val2.getClass().equals(Float.class)) {
			return (T)(Float)((float)val1 + (float) val2);
		}
		else if(val1 instanceof String && val2 instanceof String) {
			return (T)(String)((String)val1 + (String) val2);
		}
		throw new Exception("Invalid data type!");
	}
	@SuppressWarnings("unchecked")
	public static <T> T subtraction(T val1, T val2) throws Exception {
		if(val1.getClass().equals(Integer.class) && val2.getClass().equals(Integer.class)) {
			return (T)(Integer)((int)val1 - (int) val2);
		}
		else if(val1.getClass().equals(Double.class) && val2.getClass().equals(Double.class)) {
			return (T)(Double)((double)val1 - (double) val2);
		}
		else if(val1.getClass().equals(Float.class) && val2.getClass().equals(Float.class)) {
			return (T)(Float)((float)val1 - (float) val2);
		}
		else if(val1.getClass().equals(String.class) && val2.getClass().equals(String.class)) {
			return (T)((String) val1).replaceAll((String)val2, "");
		}
		throw new Exception("Invalid data type!");
	}
	@SuppressWarnings("unchecked")
	public static <T> T multiplication(T val1, T val2) throws Exception {
		if(val1.getClass().equals(Integer.class) && val2.getClass().equals(Integer.class)) {
			return (T)(Integer)((int)val1 * (int) val2);
		}
		else if(val1.getClass().equals(Double.class) && val2.getClass().equals(Double.class)) {
			return (T)(Double)((double)val1 * (double) val2);
		}
		else if(val1.getClass().equals(Float.class) && val2.getClass().equals(Float.class)) {
			return (T)(Float)((float)val1 * (float) val2);
		}
		else if(val1.getClass().equals(String.class) && val2.getClass().equals(String.class)) {
			throw new Exception("String multiplication unavailable!");
		}
		throw new Exception("Invalid data type!");
	}
	@SuppressWarnings("unchecked")
	public static <T> T division(T val1, T val2) throws ArithmeticException, Exception {
		if(val1.getClass().equals(Integer.class) && val2.getClass().equals(Integer.class)) {
			return (T)(Integer)((int)val1 / (int) val2);
		}
		else if(val1.getClass().equals(Double.class) && val2.getClass().equals(Double.class)) {
			return (T)(Double)((double)val1 / (double) val2);
		}
		else if(val1.getClass().equals(Float.class) && val2.getClass().equals(Float.class)) {
			return (T)(Float)((float)val1 / (float) val2);
		}
		else if(val1.getClass().equals(String.class) && val2.getClass().equals(String.class)) {
			throw new Exception("String division unavailable!");
		}
		throw new Exception("Invalid data type!");
	}
}


class CalculatorByOL {
	public static int addition(int a, int b) {
		return a + b;
	}
	public static double addition(double a, double b) {
		return a + b;
	}
	public static String addition(String a, String b) {
		return a + b;
	}
	public static float addition(float a, float b) {
		return a + b;
	}
	public static int subtraction(int a, int b) {
		return a - b;
	}
	public static double subtraction(double a, double b) {
		return a - b;
	}
	public static String subtraction(String a, String b) {
		return a.replaceAll(b, "");
	}
	public static float subtraction(float a, float b) {
		return a - b;
	}
	public static int multiplication(int a, int b) {
		return a*b;
	}
	public static double multiplication(double a, double b) {
		return a*b;
	}
	public static float multiplication(float a, float b) {
		return a*b;
	}
	public static String multiplication(String a, String b) throws Exception {
		throw new Exception("String multiplication unavailable(OL Method)!");
	}
	public static int division(int a, int b) throws ArithmeticException{
		return a/b;
	}
	public static double division(double a, double b) throws ArithmeticException{
		return a/b;
	}
	public static float division(float a, float b) throws ArithmeticException{
		return a/b;
	}
	public static String division(String a, String b) throws Exception {
		throw new Exception("String division unavailable(OL Method)!");
	}            
}

public class OvidiuGherman_Lab07_P02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Please enter 2 integers: ");
			Integer nr1 = scanner.nextInt();
			Integer nr2 = scanner.nextInt();
			System.out.println("(Generic)->SUM(INT): " + Calculator.addition(nr1, nr2));
			System.out.println("(Overload)->SUM(INT): " + CalculatorByOL.addition(nr1, nr2));
			System.out.println("(Generic)->MULTIPLY(INT): " + Calculator.multiplication(nr1, nr2));
			System.out.println("(Overload)->MULTIPLY(INT): " + CalculatorByOL.multiplication(nr1, nr2));
			System.out.println("(Generic)->SUBTRACTION(INT): " + Calculator.subtraction(nr1, nr2));
			System.out.println("(Overload)->SUBTRACTION(INT): " + CalculatorByOL.subtraction(nr1, nr2));
			System.out.println("(Generic)->DIVISION(INT): " + Calculator.division(nr1, nr2));
			System.out.println("(Overload)->DIVISION(INT): " + CalculatorByOL.division(nr1, nr2));

		} catch(ArithmeticException except) {
			System.out.println("Division by 0 undefined!");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.print("Please enter 2 doubles: ");
			Double nr3 = scanner.nextDouble();
			Double nr4 = scanner.nextDouble();
			System.out.println("(Generic)->SUM(DOUBLE): " + Calculator.addition(nr3, nr4));
			System.out.println("(Overload)->SUM(DOUBLE): " + CalculatorByOL.addition(nr3, nr4));
			System.out.println("(Generic)->MULTIPLY(DOUBLE): " + Calculator.multiplication(nr3, nr4));
			System.out.println("(Overload)->MULTIPLY(DOUBLE): " + CalculatorByOL.multiplication(nr3, nr4));
			System.out.println("(Generic)->SUBTRACTION(DOUBLE): " + Calculator.subtraction(nr3, nr4));
			System.out.println("(Overload)->SUBTRACTION(DOUBLE): " + CalculatorByOL.subtraction(nr3, nr4));
			System.out.println("(Generic)->DIVISION(DOUBLE): " + Calculator.division(nr3, nr4));
			System.out.println("(Overload)->DIVISION(DOUBLE): " + CalculatorByOL.division(nr3, nr4));
		} catch(ArithmeticException except) {
			System.out.println("Division by 0 undefined!");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.print("Please enter 2 floats: ");
			Float nr5 = scanner.nextFloat();
			Float nr6 = scanner.nextFloat();
			System.out.println("(Generic)->SUM(FLOAT): " + Calculator.addition(nr5, nr6));
			System.out.println("(Overload)->SUM(FLOAT): " + CalculatorByOL.addition(nr5, nr6));
			System.out.println("(Generic)->MULTIPLY(FLOAT): " + Calculator.multiplication(nr5, nr6));
			System.out.println("(Overload)->MULTIPLY(FLOAT): " + CalculatorByOL.multiplication(nr5, nr6));
			System.out.println("(Generic)->SUBTRACTION(FLOAT): " + Calculator.subtraction(nr5, nr6));
			System.out.println("(Overload)->SUBTRACTION(FLOAT): " + CalculatorByOL.subtraction(nr5, nr6));
			System.out.println("(Generic)->DIVISION(FLOAT): " + Calculator.division(nr5, nr6));
			System.out.println("(Overload)->DIVISION(FLOAT): " + CalculatorByOL.division(nr5, nr6));
		} catch (ArithmeticException except) {
			System.out.println("Division by 0 undefined!");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.print("Please enter 2 strings: ");
		scanner.nextLine();
		String str1 = scanner.next();
		String str2 = scanner.next();
		scanner.close();


		try {        
			System.out.println("(Generic)->SUM(STRING): " + Calculator.addition(str1, str2));
			System.out.println("(Overload)->SUM(STRING): " + CalculatorByOL.addition(str1, str2));
			System.out.println("(Generic)->MULTIPLY(STRING): " + Calculator.multiplication(str1, str2));
			System.out.println("(Overload)->MULTIPLY(STRING): " + CalculatorByOL.multiplication(str1, str2));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {        
			System.out.println("(Generic)->SUBTRACTION(STRING): " + Calculator.subtraction(str1, str2));
			System.out.println("(Overload)->SUBTRACTION(STRING): " + CalculatorByOL.subtraction(str1, str2));
			System.out.println("(Generic)->DIVISION(STRING): " + Calculator.division(str1,str2));
			System.out.println("(Overload)->DIVISION(STRING): " + CalculatorByOL.division(str1, str2));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
