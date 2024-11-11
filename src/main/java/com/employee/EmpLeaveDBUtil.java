package com.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmpLeaveDBUtil {

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

		public static List<EmpLeave> getLeaveDetails() {
		    List<EmpLeave> emp = new ArrayList<>();
		    
		    try {
		        con = DBConnect.getConnection();
		        stmt = con.createStatement();
		        String sql = "SELECT * FROM Emp_Leave";
		        rs = stmt.executeQuery(sql);
		        
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		              
		     // Process the result set
	            while (rs.next()) {
	                int levID = rs.getInt("LeaveId");
	                String levType = rs.getString("LeaveType");

	                // Fetch date fields as java.sql.Date
	                java.sql.Date startDate = rs.getDate("StartDate");
	                java.sql.Date endDate = rs.getDate("EndDate");
	                java.sql.Timestamp dateApproved = rs.getTimestamp("DateApproved");
	                java.sql.Timestamp dateRejected = rs.getTimestamp("DateRejected");
	                java.sql.Timestamp dateSubmitted = rs.getTimestamp("DateSubmitted");

	                // Convert dates and timestamps to String if needed
	                String startDateStr = (startDate != null) ? dateFormat.format(startDate) : "No Date";
	                String endDateStr = (endDate != null) ? dateFormat.format(endDate) : "No Date";
	                String dateApprovedStr = (dateApproved != null) ? dateFormat.format(dateApproved) : "Not Approved";
	                String dateRejectedStr = (dateRejected != null) ? dateFormat.format(dateRejected) : "Not Rejected";
	                String dateSubmittedStr = (dateSubmitted != null) ? dateFormat.format(dateSubmitted) : "No Submission Date";

	                String levStatus = rs.getString("LeaveStatus");
	                String reason = rs.getString("Reason");

	                int empId = rs.getInt("EmployeeId");
	                int approveRejBy = rs.getInt("ApprovedRejectedBy");

	                // Create an EmpLeave object and add it to the list
	                EmpLeave em = new EmpLeave(levID, levType, startDateStr, endDateStr, levStatus, reason, dateApprovedStr, dateRejectedStr, empId, approveRejBy, dateSubmittedStr);
	                emp.add(em);
	            }

	            // Close the resources
	            rs.close();
	            stmt.close();
	            con.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return emp;
	    }
	}

