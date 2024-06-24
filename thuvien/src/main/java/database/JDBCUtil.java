package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/*
 * b1: dang ki driver: registerDriver
 * b2: xay dung 1 url ket noi
 */
public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
	
		
		try {
			//b1: dki driver
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			//cac thong so
			String url ="jdbc:mysql://localhost:3306/thuvien";
			String username = "root";
			String password = "";
			
			//tao ket noi
			c = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}
	public static void closeConnection(Connection c) {
		try {
			if(c != null) {
				c.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
