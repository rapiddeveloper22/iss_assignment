package net.firstproject.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.firstproject.registration.model.Employee;
import net.firstproject.registration.dao.EmployeeDao;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao = new EmployeeDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Handles HTTP GET requests. It is used to display the employee registration form.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the employeeregister.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles HTTP POST requests. It is used to process the employee registration form submission.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve employee details from the form submission
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String contact = request.getParameter("contact");

        // Create an Employee object to hold the submitted details
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUserName(userName);
        employee.setPassword(password);
        employee.setCity(city);
        employee.setState(state);
        employee.setContact(contact);

        try {
            // Register the employee using the EmployeeDao
            employeeDao.registerEmployee(employee);
        } catch (ClassNotFoundException e) {
            // Handle any exceptions (typically database-related)
            e.printStackTrace();
        }

        // Forward to the employeedetails.jsp page after successful registration
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
        dispatcher.forward(request, response);
    }
}
