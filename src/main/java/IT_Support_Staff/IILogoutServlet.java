package IT_Support_Staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/IILogoutServlet")
public class IILogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 // Invalidate the user session
        HttpSession session = request.getSession(false); // Get current session
        if (session != null) {
            session.invalidate(); // Invalidate session
        }

        // Redirect to the login page or home page
        response.sendRedirect(request.getContextPath() + "/home.jsp");
		
	}

}
