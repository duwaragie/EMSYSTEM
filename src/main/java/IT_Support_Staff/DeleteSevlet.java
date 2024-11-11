package IT_Support_Staff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/DeleteServlet")
public class DeleteSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		  String histid = request.getParameter("HisID");



	        boolean isUpdated = ITSupportStaffInsertDButil.DeleteTicket(histid);
	        
	        if(isUpdated == true) {
	        	
	        	request.setAttribute("message", "Deleted Successfully");
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("ITread");
	        	dispatcher.forward(request, response);
	        	
	        }else {
	        	
	        	request.setAttribute("message", "Failed to Delete the Ticket Details ");
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("ITread");
	        	dispatcher.forward(request, response);
	        	
	        }
		
	}

}
