package com.employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 	String EMPID = request.getParameter("employeeid");

	        boolean isTrue = EmployeeDBUtil.deleteEmployee(EMPID);
	        
	        if (isTrue) {
	            request.setAttribute("message", "Employee deleted successfully.");
	        } else {
	            request.setAttribute("message", "Failed to delete employee.");
	        }

	        // Redirect back to the employee list page
	        request.getRequestDispatcher("Read").forward(request, response);

	}

}
