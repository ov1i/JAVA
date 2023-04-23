package main;


/* 1. 
 * Create an interface called Generator<T> with a single method next(T var). Implement the interface so that you can
 * generate the following values when applying it to certain data types (Integer, Character, etc.). The class will be
 * instantiated in the main( ) method, located in a separate class.
 */


interface Generator<T> {
	public T next(T var);
}

class myClass<T> implements Generator<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T next(T var) {
		if(var.getClass().equals(Integer.class)) {
			return (T)((Integer)((Integer)var + 1));			
		}
		else if(var.getClass().equals(Float.class)) {
			return (T)((Float)((Float)var + 0.01f));	
		}
		else if(var.getClass().equals(Double.class)) {
			return (T)((Double)((Double)var + 0.1));
		}
		else if(var.getClass().equals(Character.class)) {
			return (T)((Character)((char)((char)var + 1)));
		}
		throw new NullPointerException();
	}


	
}

public class OvidiuGherman_Lab07_P01 {

	public static void main(String[] args) {
		myClass<Integer> intObj = new myClass<>();
		myClass<Float> floatObj = new myClass<>();
		myClass<Double> doubleObj = new myClass<>();
		myClass<Character> charObj = new myClass<>();
		myClass<String> strObj = new myClass<>();		
		try {
			System.out.println("Next(INTEGER): 1->" + intObj.next(1));
			System.out.println("Next(FLOAT): 1.0f->" + floatObj.next(1.0f) + "f");
			System.out.println("Next(DOUBLE): 1.0->" + doubleObj.next(1.0));
			System.out.println("Next(CHARACTER): A->" + charObj.next('A'));
			System.out.println("Next(STRING): ASC->" + strObj.next("ASC"));
		}catch(NullPointerException except) {
			System.out.println("Invalid data type!");
		}finally {
			System.out.println("Finishing up!");
		}
	}
}
