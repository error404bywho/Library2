package dao;

import model.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;

public class loginDAO {
	
	private ArrayList<Login>admin = new ArrayList<Login>();
	
	public  loginDAO() {
		this.setAdmin(SelectAll());
	}
	 



	public static boolean Login(String user,String password) {
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
				
				if(USER.equals(user) && PASSWORD.equals(password)) {
					//JOptionPane.showMessageDialog(null, "Không tồn tại Mã Bạn Đọc", "ERROR", JOptionPane.YES_OPTION);
					System.out.println("LOGIN THANH CONG");
					return true;
				}
				
			}
			
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	public static ArrayList<Login> SelectAll() {
		
		ArrayList<Login>admin = new ArrayList<Login>();
		
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
				admin.add(l);
			}

			
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return admin;
		
	}

	public ArrayList<Login> getAdmin() {
		return admin;
	}


	public void setAdmin(ArrayList<Login> admin) {
		this.admin = admin;
	}
}
