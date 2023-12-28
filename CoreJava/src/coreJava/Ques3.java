package coreJava;

/**
 * This program demonstrates the use of loops and decision-making structures in Java.
 */
public class Ques3 {

	public static void main(String[] args) {
		// Array of numbers
		int[] arrayOfNumbers = {10, 20, 30, 40, 50};
		
		/**
		 * Looping examples
		 */
		System.out.println("For loop output");
		// For loop
		for(int pointer = 0; pointer < arrayOfNumbers.length; pointer++) {
			System.out.println(arrayOfNumbers[pointer]);
		}
		
		System.out.println("While loop output");
		// While loop
		int pointer = 0;
		while(pointer != arrayOfNumbers.length) {
			System.out.println(arrayOfNumbers[pointer++]);
		}
		
		System.out.println("Do while loop output");
		// Do-while loop
		pointer = 0;
		do {
			System.out.println(arrayOfNumbers[pointer++]);
		} while(pointer != arrayOfNumbers.length);
		
		
		/**
		 * Decision-making examples
		 */
		int age = 10;
		// If-else statement
		if(age < 18) {
			System.out.println("Child");
		}
		else {
			System.out.println("Adult");
		}
		
		
		int number = 4;
		
		// Switch statement
		switch(number) {
		case 1:
			System.out.println("One");
		case 2:
			System.out.println("Two");
		case 3:
			System.out.println("Three");
		case 4:
			System.out.println("Four");
		default:
			break;
		}
		
	}

}
