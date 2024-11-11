package main.hr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertEmpStatusServlet")
public class InsertEmpStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 PrintWriter out = response.getWriter();
  	     response.setContentType("text/html");
         
		
		String empId = request.getParameter("employeeId");
	    String empName = request.getParameter("employeeName");
	    String EmployeeStatus= request.getParameter("employeeStatus");
	   
	
                       
	     boolean isTrue;
	     
	    isTrue=  EmpStatusDBUtil.insertemStatus(empId, empName, EmployeeStatus);
	    
	    if(isTrue == true) {
	    	
	    	
	    	 out.println("<script type='text/javascript'>");
	            out.println("alert('successfully submitted the form.');");
	            out.println("window.location.href='ApproveLeave.jsp';"); // Redirect back to the form page
	            out.println("</script>");

	    	
	    }
	    
	     else {
	            out.println("<script type='text/javascript'>");
	            out.println("alert('Failed to submit form. Please try again.');");
	            out.println("window.location.href='ApproveLeave.jsp';"); // Redirect back to the form page
	            out.println("</script>");

	    }
	
	}
	
}

