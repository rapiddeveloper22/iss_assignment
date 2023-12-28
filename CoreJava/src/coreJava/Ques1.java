package coreJava;

/**
 * This program demonstrates the usage of a simple class 'Vehicle' and creates two
 * objects ('Toyota' and 'Honda') from that class. Each object represents a vehicle
 * with attributes like 'modelName' and 'mileage'. The program sets values for these
 * attributes and then retrieves and prints them.
 */
public class Ques1 {

    /**
     * The main method where the program execution begins.
     *
     * @param args Command-line arguments (not used in this program)
     */
    public static void main(String[] args) {

        // Create two instances of the 'Vehicle' class representing Toyota and Honda
        Vehicle toyota = new Vehicle();
        Vehicle honda = new Vehicle();

        // Set the attributes (mileage and model name) for the Toyota object
        toyota.setMileage(100);
        toyota.setModelName("Fortuner");

        // Set the attributes for the Honda object
        honda.setMileage(100);
        honda.setModelName("City");

        // Retrieve and print information about the Toyota
        System.out.println("Mileage of Toyota: " + toyota.getMileage());
        System.out.println("Model name of Toyota: " + toyota.getModelName());

        // Retrieve and print information about the Honda
        System.out.println("Mileage of Honda: " + honda.getMileage());
        System.out.println("Model name of Honda: " + honda.getModelName());
    }

    /**
     * The 'Vehicle' class is a blueprint for creating vehicle objects. It has attributes
     * like 'modelName' and 'mileage', and methods to set and get these attributes.
     */
    static class Vehicle {

        // Instance variables to store model name and mileage
        String modelName;
        int mileage;

        /**
         * Sets the model name of the vehicle.
         *
         * @param modelName The model name to be set
         */
        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        /**
         * Sets the mileage of the vehicle.
         *
         * @param mileage The mileage to be set
         */
        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        /**
         * Retrieves the model name of the vehicle.
         *
         * @return The model name of the vehicle
         */
        public String getModelName() {
            return this.modelName;
        }

        /**
         * Retrieves the mileage of the vehicle.
         *
         * @return The mileage of the vehicle
         */
        public int getMileage() {
            return this.mileage;
        }
    }
}
