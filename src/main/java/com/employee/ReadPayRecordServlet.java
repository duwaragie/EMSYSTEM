package com.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadPayRecordServlet")
public class ReadPayRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetchPayrollRecords from database using PayrollRecordDBUtil
		List<PayrollRecord> rec = PayrollRecordDBUtil.getPayRecordDetails(); 
		
		//set the payrollrecord list as a request attribute
		request.setAttribute("rec", rec);
		
		// Forward the request to the Payroll dashboard
		RequestDispatcher dis = request.getRequestDispatcher("payrollRecord.jsp");
        dis.forward(request, response);
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
