package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/session2"})
public class session2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		
		String name = "";
		
		HttpSession httpSession = req.getSession();
		
		//ten ben kia la abcde, ben day se lay ra abcde
		Object obj = httpSession.getAttribute("name");
		
		if(obj != null) {
			name = String.valueOf(obj);
		} else {
			resp.sendRedirect("/ThuvienServlet/hello-session");
		}
		
		writer.print("xin chao " + name);
	
	}
	
}
