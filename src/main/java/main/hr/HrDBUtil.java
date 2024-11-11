package main.hr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HrDBUtil {
	
	
	public static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static boolean validate(String usrname, String pword){
      
	
		try {
			con= DBconnect.getConnection();
			stmt=con.createStatement();
			String Sql="select * from HR where username ='"+usrname+"'and password ='"+pword+"'";
			rs = stmt.executeQuery(Sql);
		    	 		    	 
		    	 if (rs.next()) {
		    		 isSuccess=true;
		    	 }
		    	 else {
		    		 isSuccess= false;
		    	 }
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
    }
	public static List<HR> getHR(String userName){
	
		ArrayList<HR> hr = new ArrayList<>();

		try {
		
			con = DBconnect.getConnection();
			stmt= con.createStatement();
	     
			String sql = "select * from HR where username ='"+userName+"'";
			rs = stmt.executeQuery(sql);
	     
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String uname = rs.getString(5);
				String passwd = rs.getString(6);
	    	 
				HR h = new HR(id,name,phone,email,uname,passwd);
				hr.add(h);
			}
		}catch (Exception e) {
	     
		}
	    return hr;
	}
	
	public static ReadHRName ReadName(String uname, String passwd) {
		
		ReadHRName hr = null;
					
	try {
				
				con = DBconnect.getConnection();
				stmt = con.createStatement();
				String sql = "select Name from HR where username= '"+uname+"' and password = '"+passwd+"'";
				rs = stmt.executeQuery(sql);
				
				if (rs.next()) {
					String nm = rs.getString(1);
					hr = new ReadHRName(nm);	
				}
				
			}catch (Exception e) {
				e.printStackTrace();
				}
			return hr;
		}
}