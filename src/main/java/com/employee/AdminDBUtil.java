package com.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
public static boolean validate(String uname, String pword) {
	boolean isSuccess = false;
			
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();			
			String sql = "SELECT * FROM Admin WHERE username = '"+uname+"' and password = '"+pword+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				isSuccess = true;
				}else {
					isSuccess = false;
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public static List<Admin> getAdmin(String username){
	
		ArrayList<Admin> admin = new ArrayList<>();
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();	
				String sql = "SELECT * FROM Admin WHERE username = '"+username+"'";
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int adminid = rs.getInt(1);
					String name = rs.getString(2);
					String email = rs.getString(3);
					int phone = rs.getInt(4);
					String usename = rs.getString(5);
					String psswrd = rs.getString(6);
					
					Admin ad = new Admin(adminid, name, email, phone, usename, psswrd);
					admin.add(ad);
				}
								
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return admin;
	}
public static ReadAdminName ReadName(String uname, String passwd) {
		
	ReadAdminName an = null;
				
try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select Name from Admin where username= '"+uname+"' and password = '"+passwd+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				String n = rs.getString(1);
				an = new ReadAdminName(n);	
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			}
		return an;
	}
}