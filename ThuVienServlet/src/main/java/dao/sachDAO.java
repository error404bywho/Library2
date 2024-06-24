package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.JDBCUtil;
import model.*;
public class sachDAO {
	
	public ArrayList<Sach> ss ;
	private String SortCondition = "";
	private String State = " '' OR 1 = 1 ";
	public sachDAO() {
		
	}
	public sachDAO(String sortCondition,String state) {
		if(state != "Tất cả") {
			State = "";
			State += "'" + state + "'";
			
		}
		SortCondition = sortCondition;
		System.out.println(State);
	}

	public ArrayList<Sach>SelectAll(){
			ss = new ArrayList<Sach>();
		try {
			//b1: tao connection
			Connection conn = JDBCUtil.getConnection();
			
			//b2: statement
			Statement st = conn.createStatement();
			
			//b3: execute
			String s = "";
			switch(SortCondition) {
			
			case "Mã sách":
				s = "MASACH";
				break;
		
			case "Tên sách":
				s = "TENSACH";
				break;
			case "Tác giả":
				s = "TACGIA";
				break;
			case "Thể loại":
				s = "THELOAI";
				break;
			default: 
				s = "MASACH";
				break;
}
			String sql = "SELECT * FROM sach WHERE TRANGTHAI = " +  State + " ORDER BY "  + s;
			System.out.println(sql);
			//b4: xu li
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String MASACHCHUNG  = rs.getString("MASACHCHUNG");
				String MASACH		 = rs.getString("MASACH");
				String TENSACH	 = rs.getString("TENSACH");
				String THELOAI		 = rs.getString("THELOAI");
				String TACGIA		 = rs.getString("TACGIA");
				String TRANGTHAI		 = rs.getString("TRANGTHAI");
				Sach sach = new Sach(MASACHCHUNG, MASACH, TENSACH, THELOAI, TACGIA, TRANGTHAI);
				ss.add(sach);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ss;
	}
	 
	public void Them(Sach t) {
		
		try {
			//b1: tao connect
			Connection conn = JDBCUtil.getConnection();
			
			//b2: tao doi tuong statement
			Statement st = conn.createStatement();
			
			
				//b3: execute query
				String sql =  "INSERT INTO sach (MASACHCHUNG,MASACH,TENSACH,THELOAI,TACGIA,TRANGTHAI)" + " VALUES (" + "'" + t.getMaSachChung() + "'"
						+ ","+ "'" + t.getMaSach() + "'" +","  + "'" + t.getTenSach() + "'" + "," + "'" + t.getTheLoai() + "'" + "," + "'" + t.getTacGia() + "'" + "," + "'" + t.getTrangThai() +"'" + ")";
				//b4: execute
							System.out.println("ban da thuc thi  cau lenh: " + sql);
				int ketQua = st.executeUpdate(sql);

						if (ketQua > 0) {
				System.out.println("THEM SACH CO ma sach: " + t.getMaSach() + " THANH CONG !");
					JOptionPane.showMessageDialog(null, "Thêm sách thành công", "THÊM SÁCH", JOptionPane.INFORMATION_MESSAGE);
			}
//			else {
//				//JOptionPane.showMessageDialog(null, "Mã sách chung không tồn tại","Error",JOptionPane.ERROR_MESSAGE);
//			}
			
			// b5: ngat ket noi
JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			/***********/
			e.printStackTrace();
			int ErrorCode = e.getErrorCode();
			String ErrorMessage = e.getMessage();
			// Xây dựng thông điệp lỗi
			if(ErrorCode == 1062){
				ErrorMessage = " Tồn tại Mã Sách ";
			}
			else {
				ErrorMessage = "Mã quá dài ! ";
			}
            String errorMessage = "" + ErrorMessage ;
                                  
//                                  +"\nError code: " + ErrorCode;

            // Hiển thị thông điệp lỗi bằng JOptionPane
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
            /***********/
		}
	}

	public void Luu(Sach t, String S) {
		try {
			//b1: tao connect
			Connection conn = JDBCUtil.getConnection();
			
			//b2: tao doi tuong statement
			Statement st = conn.createStatement();
			
			//b3: execute query
			String sql =  "UPDATE sach "
					+ "SET                   "
					+ "MASACHCHUNG        = '" + t.getMaSachChung()  + "', "
					+ "MASACH             = '" + t.getMaSach()       + "', "
					+ "TENSACH            = '" + t.getTenSach()      + "', "
					+ "THELOAI            = '" + t.getTheLoai()      + "', "
					+ "TACGIA             = '" + t.getTacGia()       + "', "
					+ "TRANGTHAI          = '" + t.getTrangThai()    + "' "
					+ "WHERE MASACH  	  = '" + S                   + "'";
					
			//b4: execute
						System.out.println("ban da thuc thi  cau lenh: " + sql);
			st.executeUpdate(sql);
			System.out.println("update sach co ma: " + t.getMaSachChung() + " THANH CONG !");
					 
//			String SqlCheckUpdate = "Select * from sach WHERE MASACHCHUNG = '" + S + "'";
//			ResultSet rs = st.executeQuery(SqlCheckUpdate);
//			String MASACHCHUNG  = rs.getString("MASACHCHUNG");
//			String MASACH		 = rs.getString("MASACH");
//			String TENSACH	 = rs.getString("TENSACH");
//			String THELOAI		 = rs.getString("THELOAI");
//			String TACGIA		 = rs.getString("TACGIA");
//			String TRANGTHAI		 = rs.getString("TRANGTHAI");
//			Sach sach = new Sach(MASACHCHUNG, MASACH, TENSACH, THELOAI, TACGIA, TRANGTHAI);
//			if(sach.toString().equals(t.toString())) {
//				
//			}
			// b5: ngat ket noi
		            JOptionPane.showMessageDialog(null, "Cập nhật mã sách thành công", "Cập nhật thông tin", JOptionPane.PLAIN_MESSAGE);

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			/***********/
			e.printStackTrace();
			int ErrorCode = e.getErrorCode();
			String ErrorMessage = e.getMessage();
			// Xây dựng thông điệp lỗi
			if(ErrorCode == 1062){
				ErrorMessage = " Tồn tại Mã Sách ";
			}
			else {
				ErrorMessage = "Mã quá dài ! ";
			}
            String errorMessage = "" + ErrorMessage ;
//                                 + "\nError code: " + ErrorCode;

            // Hiển thị thông điệp lỗi bằng JOptionPane
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
            /***********/
		}
		
	}
	public void Xoa(String t) {
		try {
			//b1: tao bien connection
			Connection conn = JDBCUtil.getConnection();
			//b2: tao bien statement
			Statement st = conn.createStatement();
			//b3: truy van
			String sql = "DELETE FROM `thuvien`.`sach` WHERE  `MASACH` = " + "'" + t + "'";
			//b4: thuc hien lenh
			System.out.println("ban da thuc thi  cau lenh: " + sql);
			int ketQua = st.executeUpdate(sql);
			if(ketQua > 0)
			System.out.println("xoa ma sach thanh cong");
			else {
				System.out.println("that bai");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Sach>SelectResult(String t){
		ss = new ArrayList<Sach>();
	try {
		//b1: tao connection
		Connection conn = JDBCUtil.getConnection();
		
		//b2: statement
		Statement st = conn.createStatement();
		
		//b3: execute
		String s = "";
		switch(SortCondition) {
		
		case "Mã sách":
			s = "MASACH";
			break;
	
		case "Tên sách":
			s = "TENSACH";
			break;
		case "Tác giả":
			s = "TACGIA";
			break;
		case "Thể loại":
			s = "THELOAI";
			break;
		default: 
			s = "MASACH";
			break;
}
		String sql = "SELECT * FROM sach "
				+ "WHERE CONCAT_WS(' ', MASACHCHUNG, MASACH, TENSACH, THELOAI,TACGIA,TRANGTHAI) LIKE '%" + t + "%'"
				+ " AND (TRANGTHAI = " +  State + ") ORDER BY "  + s;
		System.out.println(sql);
		//b4: xu li
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			String MASACHCHUNG  = rs.getString("MASACHCHUNG");
			String MASACH		 = rs.getString("MASACH");
			String TENSACH	 = rs.getString("TENSACH");
			String THELOAI		 = rs.getString("THELOAI");
			String TACGIA		 = rs.getString("TACGIA");
			String TRANGTHAI		 = rs.getString("TRANGTHAI");
			Sach sach = new Sach(MASACHCHUNG, MASACH, TENSACH, THELOAI, TACGIA, TRANGTHAI);
			ss.add(sach);
		}
		JDBCUtil.closeConnection(conn);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ss;
}

	
	
	
	
//	public boolean CheckExist(Sach t) {
//		try {
//			//b1: tao connection
//			Connection conn = JDBCUtil.getConnection();
//			
//			//b2: statement
//			Statement st = conn.createStatement();
//			
//			//b3: execute
//	
//			String sql = "SELECT * FROM sach " ;
//			System.out.println(sql);
//			//b4: xu li
//			ResultSet rs = st.executeQuery(sql);
//			
//			String masachchung = t.getMaSachChung();
//			while(rs.next()) {
//				String MASACHCHUNG  = rs.getString("MASACHCHUNG");
//				if(masachchung.equals(MASACHCHUNG));
//				return true;
//}
//			// b5: ngat ket noi
//			JDBCUtil.closeConnection(conn);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
	 
	public void ChinhSua(Sach t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void Clear(Sach t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void Save(Sach t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void SapXepTheoHanMuon(Sach t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void TimTheoMaSach(Sach t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void TimTheoTenSach(Sach t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void SapXepTheoTheLoai(Sach t) {
		// TODO Auto-generated method stub
		
	}




	
}