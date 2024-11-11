package com.employee;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadEmployeeServlet")
public class ReadEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET requests to retrieve and display employee data
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch employees from the database using the EmployeeDBUtil
        List<Employee> employees = EmployeeDBUtil.getEmployees();

        // Set the employee list as a request attribute
        request.setAttribute("employees", employees);

        // Forward the request to the JSP page to display the data
        RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
        dispatcher.forward(request, response);
    }

    // Handle POST requests (if needed in the future)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // You can handle POST requests here if necessary (e.g., form submissions)
        doGet(request, response);  // Forwarding POST requests to doGet for now
    }
}
