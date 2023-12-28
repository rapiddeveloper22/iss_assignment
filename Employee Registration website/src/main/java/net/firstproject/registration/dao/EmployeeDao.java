package net.firstproject.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import net.firstproject.registration.model.Employee;

public class EmployeeDao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Karadi@2263";

    /**
     * Registers an employee by inserting their details into the database.
     * 
     * @param employee The Employee object containing employee details.
     * @return The result of the registration (1 for success, 0 for failure).
     * @throws ClassNotFoundException If the MySQL JDBC driver is not found.
     */
    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO emp.employee" +
            "  (id, first_name, last_name, username, password, city, state, contact) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            Statement stmt = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

            // Count the number of existing employees to determine the new employee's ID
            int count = 1;
            ResultSet rs = stmt.executeQuery("SELECT * FROM emp.employee");
            while (rs.next()) {
                count++;
            }

            preparedStatement.setInt(1, count);
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getUserName());
            preparedStatement.setString(5, employee.getPassword());
            preparedStatement.setString(6, employee.getCity());
            preparedStatement.setString(7, employee.getState());
            preparedStatement.setString(8, employee.getContact());

            System.out.println(preparedStatement);

            // Execute the query to insert the new employee
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Handle SQL exception and print details
            printSQLException(e);
        } finally {
            // Close the connection in the finally block to ensure it is always closed
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
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
