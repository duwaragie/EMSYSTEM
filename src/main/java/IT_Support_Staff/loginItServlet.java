package IT_Support_Staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginItServlet")
public class loginItServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("ITusername");
		String password = request.getParameter("ITPassword");
		boolean isTrue;
		isTrue = ITStaffDButil.validate(username, password);
		
		
			if (isTrue == true) {
				List<ITSupportStaff> itDetails = ITStaffDButil.getITSupportStaff(username);
				request.setAttribute("itDetails", itDetails);
				
				RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
				dis.forward(request, response);
			}
			else {
				out.println("<script type='text/javascript'>");
				out.println("alert('Your username or password is incorrect');");
				out.println("location ='ITLogin.jsp'");
				out.println("</script>");
			}
	}

}
