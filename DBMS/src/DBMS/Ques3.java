package DBMS;

import java.sql.*;

public class Ques3 {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Karadi@2263";

    // Database and table names
    private static final String DATABASE_NAME = "emp";
    private static final String EMPLOYEES_TABLE = "Employees";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Connect to MySQL server
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create the database
            createDatabase(connection);

            // Connect to the emp database
            connection = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);

            // Create the Employees table
            createEmployeesTable(connection);

            // Insert data using PreparedStatement
            insertDataUsingPreparedStatement(connection);

            // Execute stored procedure using CallableStatement
            callStoredProcedure(connection);

            System.out.println("Tables created and data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection in the finally block to ensure it's always closed
            closeConnection(connection);
        }
    }

    private static void createDatabase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            // Create the emp database if it doesn't exist
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME);
            System.out.println("Database created: " + DATABASE_NAME);
        }
    }

    private static void createEmployeesTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            // Create the Employees table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + EMPLOYEES_TABLE + " ("
                    + "EmployeeID INT AUTO_INCREMENT PRIMARY KEY,"
                    + "FirstName VARCHAR(255) NOT NULL,"
                    + "LastName VARCHAR(255) NOT NULL,"
                    + "DepartmentID INT,"
                    + "Salary DECIMAL(10, 2)"
                    + ")");
            System.out.println("Table created: " + EMPLOYEES_TABLE);
        }
    }

    private static void insertDataUsingPreparedStatement(Connection connection) throws SQLException {
        // Example using PreparedStatement to insert data
        String insertQuery = "INSERT INTO Employees(FirstName, LastName, DepartmentID, Salary) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // Set values for placeholders
            preparedStatement.setString(1, "John");
            preparedStatement.setString(2, "Doe");
            preparedStatement.setInt(3, 1);
            preparedStatement.setBigDecimal(4, new java.math.BigDecimal("60000.00"));

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected");
        }
    }

    private static void callStoredProcedure(Connection connection) throws SQLException {
        // Example using CallableStatement to call a stored procedure
        // StoredProcedure SQL syntax is included as StoredProcedure.sql file.
        String callStoredProcedure = "{CALL GetEmployeeDetails(?)}";
        try (CallableStatement callableStatement = connection.prepareCall(callStoredProcedure)) {
            // Set parameter for stored procedure
            callableStatement.setInt(1, 1);

            // Execute the stored procedure
            ResultSet resultSet = callableStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                System.out.println("EmployeeID: " + resultSet.getInt("EmployeeID"));
                System.out.println("FirstName: " + resultSet.getString("FirstName"));
                System.out.println("LastName: " + resultSet.getString("LastName"));
                System.out.println("DepartmentID: " + resultSet.getInt("DepartmentID"));
                System.out.println("Salary: " + resultSet.getBigDecimal("Salary"));
            }
        }
    }

    private static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
