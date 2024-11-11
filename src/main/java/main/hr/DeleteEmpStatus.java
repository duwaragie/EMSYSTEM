package main.hr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteEmpStatus")
public class DeleteEmpStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String Eid = request.getParameter("employeeId");

  
        boolean isUpdated  = EmpStatusDBUtil.deleteEmpStats(Eid);

     
        if (isUpdated == true) {
            // If updated, forward to the employee list page with success message
            request.setAttribute("message", " deleted successfully!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("ReadStat");
            dispatcher.forward(request, response);
        } else {
            // If update failed, forward to the employee list page with error message
            request.setAttribute("message", "Failed to delete the record.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("ReadStat");
            dispatcher.forward(request, response);
            }
        }
	}
