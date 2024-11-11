package com.employee;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManageLeaveServlet")
public class ManageLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    // Handles GET requests
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Fetch Leave Records from the database using EmpLeaveDBUtil
		List<EmpLeave> emp = EmpLeaveDBUtil.getLeaveDetails();
		
		// Set the leave records list as a request attribute
		request.setAttribute("emp", emp);
		
		// Forward the request to the JSP page (EmpLeave.jsp)
		RequestDispatcher dis = request.getRequestDispatcher("ManageLeaves.jsp");
		dis.forward(request, response);
	}

    // Handles POST requests (if needed)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);  // Forward POST requests to GET handler for simplicity
    }
}
