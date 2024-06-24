package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/hello-session"})
public class session1 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//tao session moi neu moi va doc lai session cu neu da ton tai
		HttpSession httpSession = req.getSession();
		
		//name la key xac dinh de ben session2 se chon va lay ra va abcde la ten cua session minh dat 
		httpSession.setAttribute("name","ABCDE");
		
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("XIN CHAO LE DINH VU");
	}
	
	
}
