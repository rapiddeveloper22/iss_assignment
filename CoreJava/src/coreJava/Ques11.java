package coreJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This program demonstrates connecting to a MySQL database using JDBC (Java Database Connectivity).
 */
public class Ques11 {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/emp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Karadi@2263";

    /**
     * The main method where the program execution begins.
     *
     * @param args Command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                System.out.println("Connection to the database successful!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: Unable to connect to the database.");
            e.printStackTrace();
        }
    }
}
