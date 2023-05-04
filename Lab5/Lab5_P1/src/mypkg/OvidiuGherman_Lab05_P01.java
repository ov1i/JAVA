package mypkg;

import java.util.Scanner;

/* 1.
 * Consider a Java interface that contains the prototypes of the methods of addition, subtraction, multiplication,
 * division, square root and raising a number to a certain power. All methods will have two double type parameters and
 * specify the returned double type. Implement the interface so that operations are defined within a class.
 * Instantiate the class and check the implemented operations.
 * 1’. Instead of an interface that contains all the aforementioned methods, implement 4 functional interfaces, one for each method.
 * The interfaces will be implemented within a single class. Instantiate the class and check the implemented operations.
 * 1’’. Use the structure used at 1’ and implement lambda expressions to define the arithmetic operations. Check the functionality.
 */


//M1
interface operations {
	double addition(double nr1 , double nr2);
	double substraction(double nr1 , double nr2);
	double multiplication(double nr1 , double nr2);
	double division(double nr1 , double nr2);
	double square_root(double nr1 , double p);
	double pow(double nr , double p);
}

class implementOperations implements operations {

	@Override
	public double addition(double nr1, double nr2) {	
		return nr1 + nr2;
	}

	@Override
	public double substraction(double nr1, double nr2) {
		return nr1 - nr2;
	}

	@Override
	public double multiplication(double nr1, double nr2) {
		return nr1 * nr2;
	}

	@Override
	public double division(double nr1, double nr2) {
		return nr1 / nr2;
	}

	@Override
	public double square_root(double nr1, double e) {
		return Math.pow(nr1, 1/e);
	}

	@Override
	public double pow(double nr, double e) {
		return Math.pow(nr, e);
	}
	
}

//M2
interface AddInterface {
	double addition(double nr1, double nr2);
}
interface SubInterface {
	double substraction(double nr1, double nr2);
}
interface MultInterface {
	double multiplication(double nr1, double nr2);
}
interface DivInterface {
	double division(double nr1, double nr2);
}
interface SqrtInterface {
	double square_root(double nr, double e);
}
interface PowInterface {
	double pow(double nr, double e);
}

class implementFunctionInterfaces implements AddInterface, SubInterface, MultInterface, DivInterface, SqrtInterface, PowInterface {

	@Override
	public double pow(double nr, double e) {
		return Math.pow(nr, e);
	}

	@Override
	public double square_root(double nr, double e) {
		return Math.pow(nr, 1/e);
	}

	@Override
	public double multiplication(double nr1, double nr2) {
		return nr1 * nr2;
	}

	@Override
	public double substraction(double nr1, double nr2) {
		return nr1 - nr2;
	}

	@Override
	public double addition(double nr1, double nr2) {
		return nr1 + nr2;
	}

	@Override
	public double division(double nr1, double nr2) {
		return nr1 / nr2;
	}
	
} 

interface OperationInterface {
	double action(double nr1, double nr2);
}


public class OvidiuGherman_Lab05_P01 {
	double opAdd(double n1, double n2, AddInterface operation) {
		return operation.addition(n1, n2);
	}
	double opSub(double n1, double n2, SubInterface operation) {
		return operation.substraction(n1, n2);
	}
	double opDiv(double n1, double n2, DivInterface operation) {
		return operation.division(n1, n2);
	}
	double opMult(double n1, double n2, MultInterface operation) {
		return operation.multiplication(n1, n2);
	}
	double op(double n1, double n2, OperationInterface operation) {
		return operation.action(n1,n2);
	}
	
	public static void main(String[] args) { 
		implementOperations obj1 = new implementOperations();
		
		System.out.print("Please enter 2 numbers: ");
		Scanner scanner = new Scanner(System.in);
		double nr1 = scanner.nextDouble();
		double nr2 = scanner.nextDouble();
		
		//OUTPUT M1
		System.out.println("\t::::M1::::\n");
		System.out.println("RESULT(+): " + obj1.addition(nr1, nr2));
		System.out.println("RESULT(-): " + obj1.substraction(nr1, nr2));
		System.out.println("RESULT(*): " + obj1.multiplication(nr1, nr2));
		if(nr2 != 0) {
			System.out.println("RESULT(/): " + obj1.division(nr1, nr2));
		}
		else {
			System.out.println("RESULT(/): INVALID NUMBER ->" + nr2);
		}
		
		System.out.print("Please enter a new number and a new value for the exponent: ");
		double nr3 = scanner.nextDouble();
		double e = scanner.nextDouble();
		scanner.close();
		
		System.out.println("RESULT(SQRT): " + obj1.square_root(nr3, e));
		System.out.println("RESULT(POW): " + obj1.pow(nr3, e));
		
		
		implementFunctionInterfaces obj2 = new implementFunctionInterfaces();
		
		//OUTPUT M2
		System.out.println("\n\n\t::::M2::::\n");
		System.out.println("RESULT(+): " + obj2.addition(nr1, nr2));
		System.out.println("RESULT(-): " + obj2.substraction(nr1, nr2));
		System.out.println("RESULT(*): " + obj2.multiplication(nr1, nr2));
		if(nr2 != 0) {
			System.out.println("RESULT(/): " + obj2.division(nr1, nr2));
		}
		else {
			System.out.println("RESULT(/): INVALID NUMBER ->" + nr2);
		}
		System.out.println("RESULT(SQRT): " + obj2.square_root(nr3, e));
		System.out.println("RESULT(POW): " + obj2.pow(nr3, e));
		
		//OUTPUT M3
		OvidiuGherman_Lab05_P01 app = new OvidiuGherman_Lab05_P01();
		AddInterface addObj = (double n1, double n2)-> n1 + n2;
		SubInterface subObj = (double n1, double n2)-> n1 - n2;
		DivInterface divObj = (double n1, double n2)-> n1 / n2;
		MultInterface multObj = (double n1, double n2)-> n1 * n2;	
		
		System.out.println("\n\n\t::::M3::::\n");
		System.out.println("RESULT(+): " + app.opAdd(nr1, nr2, addObj));
		System.out.println("RESULT(-): " + app.opSub(nr1, nr2, subObj));
		System.out.println("RESULT(*): " + app.opMult(nr1, nr2, multObj));
		if(nr2 != 0) {
			System.out.println("RESULT(/): " + app.opDiv(nr1,nr2,divObj));
		}
		else {
			System.out.println("RESULT(/): INVALID NUMBER ->" + nr2);
		}
		
		//MORE GENRAL CASE
		OperationInterface addOp = (double n1, double n2)-> n1 + n2;
		OperationInterface subOp = (double n1, double n2)-> n1 - n2;
		OperationInterface divOp = (double n1, double n2)-> n1 / n2;
		OperationInterface multOp = (double n1, double n2)-> n1 * n2;
		System.out.println("\n\n\t::::M-GENERAL::::\n");
		System.out.println("RESULT(+): " + addOp.action(nr1, nr2));
		System.out.println("RESULT(-): " + subOp.action(nr1, nr2));
		System.out.println("RESULT(*): " + multOp.action(nr1, nr2));
		if(nr2 != 0) {
			System.out.println("RESULT(/): " + divOp.action(nr1, nr2));
		}
		else {
			System.out.println("RESULT(/): INVALID NUMBER ->" + nr2);
		}
		
	}
}
