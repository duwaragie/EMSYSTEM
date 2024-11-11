package IT_Support_Staff;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ITSupportStaffInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter out=response.getWriter();
		response.setContentType("text/html");

        String Ticketid = request.getParameter("ticketid");
        String Itsupportid = request.getParameter("itsupportid");
        String Actiontaken = request.getParameter("actiontaken");

        boolean isTrue; 

    //    try {
            // Inserting the ticket data
    	isTrue = ITSupportStaffInsertDButil.insertTicketDetails(Ticketid, Itsupportid, Actiontaken);


            if (isTrue) {
            	out.println("<script type='text/javascript'>");
	            out.println("alert('successfully Insert the Details.');");
	            out.println("window.location.href='Insert.jsp';"); // Redirect back to the form page
	            out.println("</script>");
            } else {
              
            	out.println("<script type='text/javascript'>");
	            out.println("alert('Failed to Insert the Details. Please try again.');");
	            out.println("window.location.href='Insert.jsp';"); // Redirect back to the form page
	            out.println("</script>");
            }
      
    }
}
