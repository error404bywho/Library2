package handle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCUtil;
import model.Login;

/**
 * Servlet implementation class newServlet
 */
@WebServlet("/newServlet")
public class newServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		
		writer.print("<h1>Hello Servlet</h1>");
		
		ArrayList<Login>admin = new ArrayList<Login>();
		
    	 
    	
    	writer.println("Hello Servlet");
    	
		try {
		 
			//b1: tao connection
			Connection conn = JDBCUtil.getConnection();
		 
			//b2: statement
			Statement st = conn.createStatement();
			
			//b3: execute
			String sql = "SELECT * FROM login ";
			
			System.out.println(sql);
		
			//b4: xu li
			ResultSet rs = st.executeQuery(sql);
			
			String USER = "";
			String PASSWORD = "";
			
			while(rs.next()) {
				USER  = rs.getString("USER");
				PASSWORD = rs.getString("PASSWORD");
				Login l = new Login(USER, PASSWORD);
				System.out.println(l.toString());
				writer.print(l.toString());
				admin.add(l);
			}

			
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		writer.print("select done !");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
