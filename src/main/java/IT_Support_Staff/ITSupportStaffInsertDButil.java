package IT_Support_Staff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ITSupportStaffInsertDButil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	// Connecting the insert-----------------------------------------------------------------------------------------------
	
	
		public static boolean insertTicketDetails(String ticketId, String  itsupportId, String actionTaken){
			
			boolean isSuccess = false;
			
			// Create DB connection 
	
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "INSERT INTO Ticket_History VALUES (0, '"+ticketId+"','"+itsupportId+"', '"+actionTaken+"')";
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					isSuccess = true;
				}
				
				else {
					isSuccess = false;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
			return isSuccess;
			
		}
			
		

	public static  List<TicketRead> getTicketReadDetails(){

		List<TicketRead> itsup = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from Ticket_History";
			  rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int historyId = rs.getInt(1);
				 int ticketId = rs.getInt(2);
				 int itsupportId = rs.getInt(3);
			 String actionTaken = rs.getString(4);
			 
			 TicketRead tr = new TicketRead(historyId, ticketId, itsupportId, actionTaken);
			 itsup.add(tr);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return itsup;
		
	}

public static boolean updateTicket(String hisid, String itSupportId, String actionTaken) {
    boolean isUpdated = false;
    

    // Manually constructing the SQL query by concatenating parameters
   

    try {
    	con = DBConnect.getConnection();
         stmt = con.createStatement();
    	 String sql = "UPDATE Ticket_History SET ITSupportId = '" + itSupportId + "', ActionTaken = '" + actionTaken + "' WHERE HistoryId = '" + hisid + "'";

        int rs = stmt.executeUpdate(sql);
        if(rs > 0) {
        	isUpdated = true;
         }
        
        else {
        	
        	isUpdated = false;
        }
        
        con.close();
        
    } catch (Exception e) {
        e.printStackTrace();
    }

    return isUpdated;
}

	public static boolean DeleteTicket(String histid) {
		
		boolean isDeleted = false;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM Ticket_History WHERE HistoryId = '"+histid+"'";
			
			int rs = stmt.executeUpdate(sql);
			if(rs > 0) {
				isDeleted = true;
			}
			else {
				isDeleted = false;
			}
			con.close();
			
			}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isDeleted;	
		
		}
	}
	
