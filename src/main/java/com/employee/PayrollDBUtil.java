package com.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PayrollDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static boolean validate(String usname, String pass) {
		boolean isSuccess = false;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from Payroll_Officer where username= '"+usname+"' and password = '"+pass+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
				} else {
				isSuccess = false;
				}
						
		}catch(Exception e) {
			e.printStackTrace();
			}
		
		return isSuccess;
	}
	
	public static List<Payroll> getPayroll(String userName){
		
		ArrayList<Payroll> pay = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from Payroll_Officer where username= '"+userName+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int OfficerID = rs.getInt(1);
				String Name = rs.getString(2);
				int Phone= rs.getInt(3);
				String Email = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
			
				Payroll p = new Payroll(OfficerID,Name,Phone,Email,username,password);
				pay.add(p);
						
			}
			
		}catch (Exception e) {
			}
		
		return pay;
		
	}
	
	public static EmpName ReadName(String uname, String passwd) {
		
		EmpName en = null;
				
try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select Name from Payroll_Officer where username= '"+uname+"' and password = '"+passwd+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				String n = rs.getString(1);
				en = new EmpName(n);	
			}
			
		}catch (Exception e) {
			}
		return en;
	}
	
		
}
