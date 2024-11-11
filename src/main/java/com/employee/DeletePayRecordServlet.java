package com.employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeletePayRecordServlet")
public class DeletePayRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String PAYID = request.getParameter("payrollid");

        boolean isTrue = PayrollRecordDBUtil.deletePayroll(PAYID);
        
        if (isTrue) {
            request.setAttribute("message", "Payroll record deleted successfully.");
        } else {
            request.setAttribute("message", "Failed to delete payroll record.");
        }

        // Redirect back to the employee list page
        request.getRequestDispatcher("rd").forward(request, response);
		
	}

}
