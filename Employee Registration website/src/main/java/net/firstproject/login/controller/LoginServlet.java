package net.firstproject.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.firstproject.login.model.Login;
import net.firstproject.login.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao = new LoginDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Handles HTTP GET requests. It is used to display the login form.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the login.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles HTTP POST requests. It is used to process the login form submission.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username and password from the form submission
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a Login object to hold the submitted credentials
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

        try {
            // Validate the login credentials using the LoginDao
            boolean res = loginDao.validate(login);

            // Forward to success or failure page based on validation result
            if (res) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginsuccess.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginfailure.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            // Handle any exceptions (typically database-related)
            e.printStackTrace();
        }
    }
}
