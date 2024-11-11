package IT_Support_Staff;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static String url =  "jdbc:mysql://localhost:3306/emsystem";
	private static String user = "root";
	private static String pass = "admin";
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch(Exception e) {
			System.out.println("Database connection was not successful!");
			e.printStackTrace();  // To show the actual error
		}
		return con;
	}
}
