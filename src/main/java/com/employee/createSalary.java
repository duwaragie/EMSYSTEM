package com.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	
@WebServlet("/createSalary")
public class createSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String EMid = request.getParameter("emID");
		String Bsal = request.getParameter("baSal");
		String All = request.getParameter("all");
		String DeD = request.getParameter("ded");
		String Nslry = request.getParameter("neSal");
		String Pdt = request.getParameter("paDt");
		
		
		
		boolean isTrue = PayrollRecordDBUtil.insertPayroll(EMid, Bsal, All, DeD, Nslry, Pdt);
		
		if(isTrue == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Record Updated');");
			out.println("window.location.href = 'createSalary.jsp';");
			out.println("</script>");
			
	    }else {
	    	out.println("<script type='text/javascript'>");
			out.println("alert('Record cannot be updated');");
			out.println("window.location.href = 'createSalary.jsp';");
			out.println("</script>");

		}
			
	}

}
