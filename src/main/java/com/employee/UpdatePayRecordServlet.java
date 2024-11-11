package com.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdatePayRecordServlet")
public class UpdatePayRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String pid = request.getParameter("payrollid");
        String bsal = request.getParameter("basicsalary");
        String al = request.getParameter("allowance");
        String de = request.getParameter("deduction");
        String sts = request.getParameter("status");
        String pdt = request.getParameter("paydate");

        
     // Call the PayrollRecordDBUtil to update payroll information with validation
        String errorMessage = PayrollRecordDBUtil.updatePayroll(pid, bsal, al, de, sts, pdt);

        // Redirect or display appropriate message based on the result
        if (errorMessage == null) {
            // If no error message, update was successful
            request.setAttribute("message", "Record updated successfully!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("rd");
            dispatcher.forward(request, response);
        } else {
            // If there's an error message, forward it to the JSP
            request.setAttribute("message", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("rd");
            dispatcher.forward(request, response);
        }
        
        
	}

} 
	