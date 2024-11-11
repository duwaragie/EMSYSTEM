package main.hr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmpStatusServlet")
public class UpdateEmpStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String Eid = request.getParameter("employeeId");
        String EmpStatus = request.getParameter("employeeStatus");

  
        boolean isUpdated  = EmpStatusDBUtil.updateEmpStats(Eid, EmpStatus);

     
        if (isUpdated == true) {
            // If updated, forward to the employee list page with success message
            request.setAttribute("message", " updated successfully!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("ReadStat");
            dispatcher.forward(request, response);
        } else {
            // If update failed, forward to the employee list page with error message
            request.setAttribute("message", "Failed to update the record.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("ReadStat");
            dispatcher.forward(request, response);
            }
        }

	}
