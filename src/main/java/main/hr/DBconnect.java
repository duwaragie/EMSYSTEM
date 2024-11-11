package main.hr;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	private static String url="jdbc:mysql://localhost:3306/emsystem";
    private  static String userName="root";
	private static  String passWord ="admin";
	private static Connection con;
 
	public static  Connection getConnection() {
	 
	 try {
		 
	 Class.forName("com.mysql.jdbc.Driver");
	  con = DriverManager.getConnection(url, userName, passWord);
	 }
	 
	 catch(Exception e) {
		 System.out.println("Database connection is not successful!");
	 }
	 return con;
	
	}	
}
