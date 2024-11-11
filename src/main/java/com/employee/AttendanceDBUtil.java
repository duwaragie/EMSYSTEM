package com.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

		public static List<Attendance> getAttendanceDetails() {
		    List<Attendance> att = new ArrayList<>();
		    
		    try {
		        con = DBConnect.getConnection();
		        stmt = con.createStatement();
		        String sql = "SELECT * FROM Attendance";
		        rs = stmt.executeQuery(sql);
		        
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        
		        // Process the result set
		        while (rs.next()) {
		            int attID = rs.getInt(1);
		            int emId = rs.getInt(2);
		            
		            // Use getDate to fetch the date
		            java.sql.Date date = rs.getDate(3);
		            // Convert to String if needed
		            String dateString = (date != null) ? dateFormat.format(date) : "No Date";
		            String Stus = rs.getString(4);
		            String ckIN = rs.getString(5);
		            String ckOUT = rs.getString(6);

		            // Create an Attendance object and add it to the list
		            Attendance a = new Attendance(attID, emId, dateString, Stus, ckIN, ckOUT);
		            att.add(a);
		        }
		        
		        // Close the resources
		        rs.close();
		        stmt.close();
		        con.close();
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return att;
		}
}
