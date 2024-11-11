package IT_Support_Staff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	response.setContentType("text/html");
   
        String histId = request.getParameter("HisID");
        String itSupportId = request.getParameter("SupID");
        String actionTaken = request.getParameter("ActTTaken");

       
            boolean isUpdated = ITSupportStaffInsertDButil.updateTicket(histId, itSupportId, actionTaken);
            
            // Send response based on the update result
            if (isUpdated == true ) {
                request.setAttribute("message", "Details Updated Successfully.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("ITread");
                dispatcher.forward(request, response);
                
                
            } else {
            	  request.setAttribute("message", "Details Updated UnSuccessfully.");
                  RequestDispatcher dispatcher = request.getRequestDispatcher("ITread");
                  dispatcher.forward(request, response);
                
            }
        
        
    }
}
