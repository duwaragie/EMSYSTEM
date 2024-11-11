package main.hr;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeViewServlet")
public class EmployeeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  List<EmpStatus> emp = EmpStatusDBUtil.getEmpStatusDetails();
        request.setAttribute("emp", emp);

        // Forward the request to the JSP page to display the data
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewEmpStatus.jsp");
        dispatcher.forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
