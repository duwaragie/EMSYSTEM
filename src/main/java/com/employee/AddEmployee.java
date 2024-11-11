package com.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("empName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String hireDate = request.getParameter("hireDate");
		String jobTitle = request.getParameter("jobTitle");
		String uname = request.getParameter("username");
		String pword = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.addemployee(name, email, phone, hireDate, jobTitle, uname, pword);
		
		if(isTrue == true) {
			 out.println("<script type='text/javascript'>");
	         out.println("alert('Record Updated');");
	         out.println("window.location.href = 'addemployee.jsp';");
	         out.println("</script>");
			
		}else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Record cannot be updated');");
            out.println("window.location.href = 'addemployee.jsp';");
            out.println("</script>");
		}
	}

}
