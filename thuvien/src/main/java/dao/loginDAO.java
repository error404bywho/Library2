package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import database.JDBCUtil;

import ViewLogin.Login;
public class loginDAO {
	
	private Login l ;

	public boolean Login(String user,String password) {
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

}
