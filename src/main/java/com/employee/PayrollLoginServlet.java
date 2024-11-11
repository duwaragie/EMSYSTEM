package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PayrollLoginServlet")
public class PayrollLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String username = request.getParameter("Rname");
		String password = request.getParameter("pass");
		boolean isTrue;

		// Validate username and password
		isTrue = PayrollDBUtil.validate(username, password);

		if (isTrue) {
		    // Fetch the employee name after validation
		    EmpName empName = PayrollDBUtil.ReadName(username, password);

		    if (empName != null) {
		        // Store the name in the session
		        HttpSession session = request.getSession();
		        session.setAttribute("name", empName.getName());

		        // Simulate fetching data from the database or a service
		        int totalEmployees = 245;
		        int pendingSalaries = 15;
		        int generatedReports = 150;

		        // Set attributes to pass data to the JSP
		        request.setAttribute("totalEmployees", totalEmployees);
		        request.setAttribute("pendingSalaries", pendingSalaries);
		        request.setAttribute("generatedReports", generatedReports);

		        // Fetch payroll details
		        List<Payroll> offDetails = PayrollDBUtil.getPayroll(username);
		        request.setAttribute("offDetails", offDetails);

		        // Forward the request to the Payroll dashboard
		        RequestDispatcher dis = request.getRequestDispatcher("PayrollUI.jsp");
		        dis.forward(request, response);
		    } else {
		        // Invalid login, forward back to login page with an error message
		        request.setAttribute("errorMessage", "Invalid Username or Password");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("payrollLogin.jsp");
		        dispatcher.forward(request, response);
		    }
		} else {
		    // Display error if validation fails
		    out.println("<script type='text/javascript'>");
		    out.println("alert('Your username or password is incorrect');");
		    out.println("location= 'home.jsp'");
		    out.println("</script>");
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Simulate fetching data from the database or a service
		int totalEmployees = 245;
		int pendingSalaries = 15;
		int generatedReports = 150;
		
		//Set attributes to pass data to the JSP
		request.setAttribute("totalEmployees", totalEmployees);
		request.setAttribute("pendingSalaries", pendingSalaries);
		request.setAttribute("generatedReports", generatedReports);
		
		
		RequestDispatcher dis1 = request.getRequestDispatcher("PayrollUI.jsp");
		dis1.forward(request, response);
	}

}
