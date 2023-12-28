package coreJava;

/**
 * This program demonstrates the use of variables, data types, and access modifiers in Java.
 */
public class Ques2 {
	
	/**
	 * Instance variables:
	 */
	
	/**
	 * salary is an instance variable with public access.
	 */
	public int salary = 100000;
	
	/**
	 * profit is a static private variable.
	 */
	private static double profit = 1000;
	
	
	public void localVariable() {
		/**
		 * localVar is a local variable within the localVariable method.
		 */
		int localVar = 50;
		System.out.println(localVar);
	}

	/**
	 * employed is a final variable acting like a constant.
	 */
	public static final boolean employed = true; 
	
	/**
	 * Constructor initializes the object when called.
	 */
	public Ques2() {
		salary = 10;
	}

	
	public static void main(String[] args) {
		/**
		 * Basic data types in Java.
		 */
		byte byteValue1 = 2;
		System.out.println("Byte: " + byteValue1);

		short shortValue1 = 2;
		System.out.println("Short: " + shortValue1);

		int intValue1 = 2;
		System.out.println("Int: " + intValue1);

		long longValue1 = 2L;
		System.out.println("Long: " + longValue1);

		float floatValue1 = 2.0f;
		System.out.println("Float: " + floatValue1);

		double doubleValue1 = 2.0;
		System.out.println("Double: " + doubleValue1);

		boolean booleanValue = true;
		System.out.println("Boolean: " + booleanValue);

		char charValue = 'A';
		System.out.println("Char: " + charValue); 
	}
	
	/**
	 * Access modifier examples:
	 */
	
	/**
	 * Public variable can be accessed from anywhere.
	 */
	public int publicVariable = 10;
	
	/**
	 * Private variable can only be accessed within the class.
	 */
	private int privateVariable = 10;
	
	/**
	 * Protected variable can only be accessed within the package or by a child class.
	 */
	protected int protectedVariable = 10;

}
