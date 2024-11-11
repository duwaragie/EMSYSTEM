package com.employee;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");

	    String eid = request.getParameter("employeeid");
	    String empname = request.getParameter("employeename");
	    String empemail = request.getParameter("employeeemail");
	    String empphone = request.getParameter("employeephone");
	    String emphireDate = request.getParameter("employeehireDate");
	    String empjobTitle = request.getParameter("employeejobTitle");
	    String emppasswd = request.getParameter("employeepasswd");

	    // If password is not provided, don't update it (or handle it accordingly)
	    if (emppasswd == null || emppasswd.trim().isEmpty()) {
	        emppasswd = "ems123"; // Set a default value if you don't want to change the password
	    }

	    // Call the EmployeeDBUtil to update the employee information
	    boolean isUpdated = EmployeeDBUtil.updateEmployee(eid, empname, empemail, empphone, emphireDate, empjobTitle, emppasswd);

	    // Redirect or display appropriate message based on the update result
	    if (isUpdated) {
	        request.setAttribute("message", "Record updated successfully!");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Read");
	        dispatcher.forward(request, response);
	    } else {
	        request.setAttribute("message", "Failed to update the record.");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Read");
	        dispatcher.forward(request, response);
	    }
	}

}
