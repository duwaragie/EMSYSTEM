package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
		
	public static boolean addemployee(String name, String email, String phone, String hdate, String jtitle, String username, String password) {
		boolean isSuccess = false;
				
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();	
					String sql = "INSERT INTO Employee VALUES (0, '"+name+"', '"+email+"', '"+phone+"', '"+hdate+"', '"+jtitle+"', '"+username+"', '"+password+"')";
					int rs = stmt.executeUpdate(sql);
					
					if(rs > 0) {
						isSuccess = true;
						
					}else {
						isSuccess = false;
					}
					
				}catch(Exception e){
					e.printStackTrace();					
					
				}
		return isSuccess;
	}
	public static List<Employee> getEmployees() {
		
        List<Employee> employees = new ArrayList<>();

        try {
            
        	con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM Employee";
            rs = stmt.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                int empId = rs.getInt(1);
                String empName = rs.getString(2);
                String email = rs.getString(3);
                long phone = rs.getLong(4);
                String hireDate = rs.getString(5);
                String jobTitle = rs.getString(6);
                String usrnm = rs.getString(7);
                String pword = rs.getString(8);

                // Create an Employee object and add it to the list
                Employee employee = new Employee(empId, empName, email, phone, hireDate, jobTitle, usrnm, pword);
                employees.add(employee);
            }

            // Close the resources
            rs.close();
            stmt.close();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
	
	public static boolean updateEmployee(String empID, String name, String email, String phone, String hireDate, String jobTitle, String passwd) {
	    boolean isUpdated = false;

	    try {
	        Connection con = DBConnect.getConnection();
	        
	        String sql = "UPDATE Employee SET EmpName=?, Email=?, Phone=?, HireDate=?, JobTitle=?"
	                + (passwd != null && !passwd.isEmpty() ? ", password=?" : "") + " WHERE Emp_ID =?";
	        
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, name);
	        stmt.setString(2, email);
	        stmt.setString(3, phone);
	        stmt.setString(4, hireDate);
	        stmt.setString(5, jobTitle);
	        
	        if (passwd != null && !passwd.isEmpty()) {
	            stmt.setString(6, passwd); // Set password only if it is not empty
	            stmt.setString(7, empID);
	        } else {
	            stmt.setString(6, empID); // Set empID in the last parameter position
	        }

	        int rowsAffected = stmt.executeUpdate();
	        isUpdated = rowsAffected > 0;

	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return isUpdated;
	}

	
	public static boolean deleteEmployee(String empId) {
		boolean isDeleted = false;
		
		try {
			Connection con = DBConnect.getConnection();
			String sql = "DELETE FROM Employee WHERE Emp_ID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, empId);
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0) {
            	isDeleted = true;
            } else {
            	isDeleted = false;
            }
            
            con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isDeleted;
	}
	
	public static boolean validate(String usrname, String psword) {
		boolean isSuccess = false;
				
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();			
				String sql = "SELECT * FROM Employee WHERE username = '"+usrname+"' and password = '"+psword+"'";
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
			

		public static List<Employee> getEmployee(String username){
		
			ArrayList<Employee> employee = new ArrayList<>();
				
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();	
					String sql = "SELECT * FROM Employee WHERE username = '"+username+"'";
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int empid = rs.getInt(1);
						String name = rs.getString(2);
						String email = rs.getString(3);
						int phone = rs.getInt(4);
						String hdate = rs.getString(5);
						String jtitle = rs.getString(6);
						String unme = rs.getString(7);
						String pass = rs.getString(8);
						
						Employee em = new Employee(empid, name, email, phone, hdate, jtitle, unme, pass);
						employee.add(em);
					}
									
				}catch(Exception e){
					e.printStackTrace();
				}
				
				return employee;
		}
	public static ReadAdminName ReadName(String uname, String passwd) {
			
		ReadAdminName an = null;
					
	try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "select EmpName from Employee where username= '"+uname+"' and password = '"+passwd+"'";
				rs = stmt.executeQuery(sql);
				
				if (rs.next()) {
					String n = rs.getString(1);
					an = new ReadAdminName(n);	
				}
				
			}catch (Exception e) {
				}
			return an;
		}

}
