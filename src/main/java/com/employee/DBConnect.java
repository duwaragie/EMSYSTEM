package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static String url = "jdbc:mysql://localhost:3306/emsystem";
	private static String usrname = "root";
	private static String passwd = "admin";
	
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usrname, passwd);
		} catch (Exception e){
			System.out.println("DataBase connection failed !!!");
			
		}
		return con;
	}
	

}
