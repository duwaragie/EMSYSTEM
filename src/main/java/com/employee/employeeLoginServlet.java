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

@WebServlet("/employeeLoginServlet")
public class employeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String usnm = request.getParameter("unm");
		String pswrd = request.getParameter("pas");
		
		boolean isTrue = EmployeeDBUtil.validate(usnm, pswrd);
		
		if(isTrue == true) {
			
			  // Fetch the employee name after validation
			ReadAdminName rName = EmployeeDBUtil.ReadName(usnm, pswrd);

			    if (rName != null) {
			        // Store the name in the session
			        HttpSession session = request.getSession();
			        session.setAttribute("name", rName.getName());
	
					
					// Simulate fetching data from the database or a service 
			        String Leave = "98%"; 
			        int Reports = 3; 
			        int Tasks = 7; 
			        double payrollProcessed = 123500.00;
				  
			        // Set attributes to pass data to the JSP 
					  request.setAttribute("Leave",Leave); 
					  request.setAttribute("Reports", Reports);
					  request.setAttribute("Tasks", Tasks);
					  request.setAttribute("payrollProcessed", payrollProcessed);
						 
		       
				List<Employee> emp = EmployeeDBUtil.getEmployee(usnm);
				request.setAttribute("emp", emp);
				
				 // Forward the request to the Payroll dashboard
		        RequestDispatcher dis = request.getRequestDispatcher("employeeDashboard.jsp");
		        dis.forward(request, response);
		    } else {
		        // Invalid login, forward back to login page with an error message
		        request.setAttribute("errorMessage", "Invalid Username or Password");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("employeeLogin.jsp");
		        dispatcher.forward(request, response);
			}
		}else {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Your username OR password is incorrect');");
			out.println("location = 'employeeLogin.jsp'");
			out.println("</script>");
		}
		}
}