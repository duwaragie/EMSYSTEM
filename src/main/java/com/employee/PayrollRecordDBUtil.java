package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PayrollRecordDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
		
	public static boolean insertPayroll(String empID, String basicSal, String allow, String deduc, String netSal, String date ) {
		boolean isSuccess = false;
		
		try {	

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO Payroll (EmpId, BasicSalary, Allowances, Deductions, NetSalary, PaymentDate) VALUES ('"+empID+"', '"+basicSal+"', '"+allow+"', '"+deduc+"', '"+netSal+"', '"+date+"')";
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
						
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	 return isSuccess;
	}

	
	public static List<PayrollRecord> getPayRecordDetails(){
		
		List<PayrollRecord> rec = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "Select * from Payroll";
			rs = stmt.executeQuery(sql);
			
			//Process the result set
			while (rs.next()) {
				int pRollID = rs.getInt(1);
				int emId = rs.getInt(2);
				String bSalary = rs.getString(3);
				String allows = rs.getString(4);
				String deducs = rs.getString(5);
				String nSalary = rs.getString(6);
				String Stus = rs.getString(7);
				String pyDate = rs.getString(8);
				
				//create an PayrollRecord object and add it to the list
				PayrollRecord payRec = new PayrollRecord(pRollID, emId, bSalary, allows, deducs, nSalary, Stus, pyDate );
				rec.add(payRec);
			}
			
			//close the resources
			rs.close();
			stmt.close();
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return rec;
	}
	
	  public static String updatePayroll(String pid, String bsal, String al, String de, String sts, String pdt){
		
	    double basicSalary = Double.parseDouble(bsal);
	    double allowances = Double.parseDouble(al);
	    double deductions = Double.parseDouble(de);

	    // Backend validations
	    if (basicSalary < 0) {
	        return "Basic salary cannot be negative.";
	    }

	    if (allowances < 0) {
	        return "Allowances cannot be negative.";
	    }

	    if (deductions < 0) {
	        return "Deductions cannot be negative.";
	    }

	    if (allowances > basicSalary) {
	        return "Allowances cannot be greater than basic salary.";
	    }

	    if (deductions > basicSalary) {
	        return "Deductions cannot be greater than basic salary.";
	    }

	    
	    
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
	        String sql = "UPDATE Payroll SET BasicSalary = '"+bsal+"', Allowances = '"+al+"', Deductions = '"+de+"', "+ "NetSalary = (BasicSalary + Allowances - Deductions), Status = '"+sts+"' , PaymentDate = '"+pdt+"', Status = '"+sts+"' "+ "WHERE PayrollID = '"+pid+"'";
			
			int rs = stmt.executeUpdate(sql);	
			
			if (rs > 0) {
	            return null;  // Indicates success
	        }
		        
		        // Close resources
		        stmt.close();
		        con.close();
			
		}catch (Exception e) {
            e.printStackTrace();
		}

		return "Failed to update the record.";
	}
	  
		public static boolean deletePayroll(String payId) {
			boolean isDeleted = false;
			
			try {
				con = DBConnect.getConnection();
				String sql = "DELETE FROM Payroll WHERE PayrollID = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, payId);
				
				int rowsDeleted = stmt.executeUpdate();
				
				if(rowsDeleted > 0) {
					isDeleted = true;
				} else {
					isDeleted = false;
				}

	         // Close resources
		        con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return isDeleted;
		}
	
}
		

