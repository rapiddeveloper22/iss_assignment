package net.firstproject.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.firstproject.login.model.Login;

public class LoginDao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Karadi@2263";

    /**
     * Validates the provided login credentials against the database.
     * 
     * @param login The Login object containing username and password.
     * @return True if the credentials are valid, false otherwise.
     * @throws ClassNotFoundException If the MySQL JDBC driver is not found.
     */
    public boolean validate(Login login) throws ClassNotFoundException {
        boolean status = false;

        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Use a PreparedStatement to avoid SQL injection
            String query = "SELECT * FROM emp.employee WHERE username = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, login.getUsername());

                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        // If username exists, check if the password matches
                        String storedPassword = rs.getString("password");
                        if (storedPassword.equals(login.getPassword())) {
                            status = true; // Username and password match
                        }
                    }
                }
            }
        } catch (SQLException e) {
            // Handle SQL exceptions and print details
            printSQLException(e);
        }
        return status;
    }

    /**
     * Prints details of a SQLException to the console.
     * 
     * @param ex The SQLException to be printed.
     */
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
