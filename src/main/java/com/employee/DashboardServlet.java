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

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("uid");
		String password = request.getParameter("pwd");
		boolean isTrue;
		
		isTrue = AdminDBUtil.validate(username, password);
		
		
		if(isTrue) {
			
			  // Fetch the employee name after validation
			ReadAdminName readName = AdminDBUtil.ReadName(username, password);

		    if (readName != null) {
		        // Store the name in the session
		        HttpSession session = request.getSession();
		        session.setAttribute("name", readName.getName());

			// Simulate fetching data from the database or a service
	        int totalEmployees = 245;
	        int totalDepartments = 10;
	        int pendingLeaves = 7;
	        double payrollProcessed = 123500.00;

	        // Set attributes to pass data to the JSP
	        request.setAttribute("totalEmployees", totalEmployees);
	        request.setAttribute("totalDepartments", totalDepartments);
	        request.setAttribute("pendingLeaves", pendingLeaves);
	        request.setAttribute("payrollProcessed", payrollProcessed);
	       
			List<Admin> admin = AdminDBUtil.getAdmin(username);
			request.setAttribute("admin", admin);
			
			 // Forward the request to the Payroll dashboard
	        RequestDispatcher dis = request.getRequestDispatcher("DashboardAdmin.jsp");
	        dis.forward(request, response);
	    } else {
	        // Invalid login, forward back to login page with an error message
	        request.setAttribute("errorMessage", "Invalid Username or Password");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	        dispatcher.forward(request, response);
	    }

		} else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Your username OR password is incorrect');");
			out.println("location = 'login.jsp'");
			out.println("</script>");			
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalEmployees = 245;
        int totalDepartments = 10;
        int pendingLeaves = 7;
        double payrollProcessed = 123500.00;

        // Set attributes to pass data to the JSP
        request.setAttribute("totalEmployees", totalEmployees);
        request.setAttribute("totalDepartments", totalDepartments);
        request.setAttribute("pendingLeaves", pendingLeaves);
        request.setAttribute("payrollProcessed", payrollProcessed);
        
        RequestDispatcher dis = request.getRequestDispatcher("DashboardAdmin.jsp");
        dis.forward(request, response);
        
        
	}

}
