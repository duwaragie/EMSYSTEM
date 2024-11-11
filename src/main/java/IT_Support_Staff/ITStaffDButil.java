package IT_Support_Staff;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ITStaffDButil {
	
  private static Connection con = null;
  private static Statement stmt = null;
  private static ResultSet rs = null;
	
	private static boolean isSuccess;
	
	public static boolean validate(String user, String pass ) {
	
		
		try {
			
	        con = DBConnect.getConnection();
	        stmt=con.createStatement();
			 
			String sql = "select * from IT_Support_Staff where username='"+user+"' and password='"+pass+"'";
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 if(rs.next()) {
				 isSuccess = true;
			 }
			 else {
				 isSuccess = false;
			 }
		}
			 catch (Exception e ) {
				 e.printStackTrace();
			 }
			   
		return isSuccess;
	}
	
 	public static List<ITSupportStaff> getITSupportStaff(String userName){
		
		ArrayList<ITSupportStaff> itstaff = new ArrayList<>();
	
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * IT_Support_Staff where username = '"+userName+"'";
			 rs = stmt.executeQuery(sql);
			 
			 while (rs.next()) {
					int ITSupportId = rs.getInt(1);
					String name = rs.getString(2);
					String email= rs.getString(3);
					int  phone = rs.getInt(4);
					String username = rs.getString(5);
					String password = rs.getString(6);
				
					ITSupportStaff it = new ITSupportStaff(ITSupportId, name, email, phone, username,password);		
					itstaff.add(it);
		}
			
		
		}catch(Exception e) {
			
		}
		
		return itstaff;
 	} 
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
