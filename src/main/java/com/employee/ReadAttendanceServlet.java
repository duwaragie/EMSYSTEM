package com.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadAttendanceServlet")
public class ReadAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//fetch AttendanceRecords from database using AttendanceDBUtil
				List<Attendance> att = AttendanceDBUtil.getAttendanceDetails(); 
				
				//set the AttendanceRecords list as a request attribute
				request.setAttribute("att", att);
				
				// Forward the request to the Payroll dashboard
				RequestDispatcher dis = request.getRequestDispatcher("Attendance.jsp");
		        dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
