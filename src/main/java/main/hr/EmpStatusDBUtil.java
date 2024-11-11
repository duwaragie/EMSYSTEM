package main.hr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpStatusDBUtil {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean insertemStatus( String EmpId, String EmpName, String employeeStatus) {
		boolean isSuccess = false;
		
		try {
			
			con = DBconnect.getConnection();
			stmt= con.createStatement();
	     
			String sql ="INSERT INTO Emp_Status VALUES('"+EmpId+"','"+EmpName+"','"+employeeStatus+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess= true;
			}else {
				isSuccess=false;
			}
		} catch (Exception e) {
				e.printStackTrace();
			}
		
		return isSuccess;
	}
		
     
     public static List<EmpStatus> getEmpStatusDetails(){
    	 
    	 List<EmpStatus> emp= new ArrayList<>();
	  
	  try {
		  	con = DBconnect.getConnection();
			stmt= con.createStatement();
			String sql="select * from Emp_Status";
			rs = stmt.executeQuery(sql);
	     
			
			while(rs.next()) {
				int EmpID = rs.getInt(1);
				String EmpName = rs.getString(2);
				String EmpStatus = rs.getString(3);
				
			 EmpStatus es= new EmpStatus(EmpID,EmpName,EmpStatus);
			 emp.add(es);
	          }
			
			//close the resources
			rs.close();
			stmt.close();
			con.close();
			
			
	  } catch (Exception e){
		  e.printStackTrace();
	  }
	   return emp;
	  }
     
     public static boolean updateEmpStats(String Eid, String emSTATS) {
 		boolean isUpdated = false;
 		
 		
 		try {
 			
 			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "Update Emp_Status SET EmpStatus ='"+emSTATS+"' WHERE EmpID = '"+Eid+"'";
			
			 int rs = stmt.executeUpdate(sql);
	            if(rs > 0) {
	            	isUpdated = true;
	            } else {
	            	isUpdated = false;
	            }

	            con.close();

 			
 		}catch(Exception e){
 			  e.printStackTrace();
 		  }

     return isUpdated;
     }
   

public static boolean deleteEmpStats(String Eid) {
		boolean isDeleted = false;
		
		
		try {
			
			con = DBconnect.getConnection();
		stmt = con.createStatement();
		String sql = "DELETE FROM Emp_Status WHERE EmpID = '"+Eid+"'";
		
		 int rs = stmt.executeUpdate(sql);
            if(rs > 0) {
            	isDeleted = true;
            } else {
            	isDeleted = false;
            }

            con.close();

			
		}catch(Exception e){
			  e.printStackTrace();
		  }

 return isDeleted;
 }  
   

public static List<HRticket> getHRticketDetails(){
	 
	 List<HRticket> HR= new ArrayList<>();
 
 try {
	  	con = DBconnect.getConnection();
		stmt= con.createStatement();
		String sql="select * from HR_Ticket";
		rs = stmt.executeQuery(sql);

			 
				while(rs.next()) {
					int ticketId = rs.getInt(1);
					int employeeId = rs.getInt(2);
					String ticketStatus = rs.getString(3);
					ticketStatus = (ticketStatus == null) ? "Not Resolved" : ticketStatus; 
					
					String dateSubmitted = rs.getString(4);
					dateSubmitted = (dateSubmitted == null) ? "Not Submitted" : dateSubmitted;
	
					String response = rs.getString(5);
					response = (response == null) ? "Not yet responded" : response; 
					
					String resolvedby = rs.getString(6);
					resolvedby = (resolvedby == null) ? "Not Resolved " : resolvedby; 
					
					String dateResponded = rs.getString(7);
					dateResponded = (dateResponded == null) ? "Not Responded" : dateResponded;
				
			

		 HRticket hr= new HRticket(ticketId,employeeId,ticketStatus,dateSubmitted,response,resolvedby,dateResponded);
		 HR.add(hr);
         }
		
		//close the resources
		rs.close();
		stmt.close();
		con.close();
		
		
 } catch (Exception e){
	  e.printStackTrace();
 }
  return HR;
   }



public static List<Leave> getLeaveDetails(){
	 
	 List<Leave> leave= new ArrayList<>();

try {
	  	con = DBconnect.getConnection();
		stmt= con.createStatement();
		String sql="select * from Emp_Leave";
		rs = stmt.executeQuery(sql);
   
		
			
					while(rs.next()) {
						int leaveId = rs.getInt(1);
						String LeaveType = rs.getString(2);
						
						String StartDate = rs.getString(3);
						String EndDate = rs.getString(4);
					
						String LeaveStatus = rs.getString(5);
					
						String Reason = rs.getString(6);
						
						String DateApproved = rs.getString(7);
						DateApproved = (DateApproved == null) ? "Not Approved" : DateApproved; 
						
						String DateRejected = rs.getString(8);
						DateRejected = (DateRejected == null) ? "Not Rejected" : DateRejected; 
						
						int EmployeeId = rs.getInt(9);
						
						String ApprovedRejectedBy = rs.getString(10);
						ApprovedRejectedBy = (ApprovedRejectedBy == null) ? "Pending " : ApprovedRejectedBy; 
						
						String DateSubmitted = rs.getString(11);
						DateSubmitted = (DateSubmitted == null) ? "Not Submitted" : DateSubmitted; 
		

		 Leave lev= new Leave( leaveId, LeaveType , StartDate , EndDate , LeaveStatus,Reason,DateApproved, DateRejected , EmployeeId , ApprovedRejectedBy , DateSubmitted    ) ;
		 leave.add(lev);
        }
		
		//close the resources
		rs.close();
		stmt.close();
		con.close();
		
		
} catch (Exception e){
	  e.printStackTrace();
}
 return leave;
  }



public static List<Attendance> getAttendancetDetails(){
	 
	 List<Attendance> attendance= new ArrayList<>();

try {
	  	con = DBconnect.getConnection();
		stmt= con.createStatement();
		String sql="select * from attendance";
		rs = stmt.executeQuery(sql);

			 
				while(rs.next()) {
					int attendanceId = rs.getInt(1);
					int empId = rs.getInt(2);
					String date = rs.getString(3);
					String status = rs.getString(4);
	
					String checkInTime= rs.getString(5);
					checkInTime = (checkInTime == null) ? "Absent" :  checkInTime;
					
					String checkOutTime= rs.getString(6);
					checkOutTime = (checkOutTime == null) ? " Absent" : checkOutTime; 
					

		 Attendance atty= new Attendance(attendanceId,empId,date,status,checkInTime,checkOutTime);
		 attendance.add(atty);
        }
				
		//close the resources
		rs.close();
		stmt.close();
		con.close();
		
		
} catch (Exception e){
	  e.printStackTrace();
}
 return attendance;
  }
}