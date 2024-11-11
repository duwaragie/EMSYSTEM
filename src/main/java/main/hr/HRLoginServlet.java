package main.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class HRLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String username=request.getParameter("usrnm");
		String password=request.getParameter("pwrd");
		
		boolean isTrue;
		
		isTrue = HrDBUtil.validate(username, password);
		
		// Fetch the employee name after validation
		ReadHRName readName = HrDBUtil.ReadName(username, password);

	    if (readName != null) {
	        // Store the name in the session
	        HttpSession session = request.getSession();
	        session.setAttribute("name", readName.getName());
	    }
		
		if (isTrue == true) {
			List<HR> hrDetails = HrDBUtil.getHR(username);
			request.setAttribute("hrDetails", hrDetails);
			RequestDispatcher dis = request.getRequestDispatcher("Nilu.jsp");
			dis.forward(request, response);
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location ='HRLogin.jsp'");
			out.println("</script>");
		}
	}
}


