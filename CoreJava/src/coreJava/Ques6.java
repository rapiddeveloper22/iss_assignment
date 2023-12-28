package coreJava;

import java.io.*;

public class Ques6 {

    /**
     * The main method throws IOException to indicate that it might throw an IOException.
     *
     * @param args Command line arguments
     * @throws IOException If an I/O error occurs
     */
    public static void main(String[] args) throws IOException {
        // Handling ArrayIndexOutOfBoundsException
        try {
            int arrayOfNumbers[] = new int[2];
            System.out.println("Access element three: " + arrayOfNumbers[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown: " + e);
        }

        // Handling custom exception
        try {
            int age = 18;
            if (age < 18) {
                // Using throw to throw a new exception if age is below 18
                throw new Exception("Age is below 18");
            }
        } catch (Exception exceptionName) {
            System.out.println("Exception is " + exceptionName);
        }
    }
}
