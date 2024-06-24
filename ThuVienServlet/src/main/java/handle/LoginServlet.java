package handle;

import java.io.*;
import java.util.*;
import model.*;
import dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.loginDAO;
import database.JDBCUtil;
import model.Login;
import model.Sach;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private ArrayList<Sach> ss = new ArrayList<Sach>();
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 

	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    // response.getWriter().append("Served at: ").append(request.getContextPath());
	    
	 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		 response.setContentType("text/html");
                    
		 String username = request.getParameter("username");
                 String password = request.getParameter("password");
		  
                 Boolean direct = loginDAO.Login(username, password);
                 
                 if(direct)
                     response.sendRedirect("http://localhost:8080/ThuVienServlet/library.jsp");
                 else 
                     response.sendRedirect("http://localhost:8080/ThuVienServlet/index.jsp");
                 
	     //   response.getWriter().append("POST request received.");
        }
}
