package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.JDBCUtil;
import model.*;
import stuff.QLMaSachChung_interface;
public class masachchungDAO {
	
	private String SortCondition = "";
	
	public masachchungDAO() {
		
	}
	public masachchungDAO(String SortCondition) {
		this.SortCondition = SortCondition;
	}


	public ArrayList<MaSachChung> mscs;
	public ArrayList<MaSachChung> SelectAll() {
		mscs = new ArrayList<MaSachChung>();
		try {
			//b1: tao connection
			Connection conn = JDBCUtil.getConnection();
			
			//b2: statement
			Statement st = conn.createStatement();
			
			//b3: execute
			String s = "";
			switch(SortCondition) {
			
			case "Mã sách chung":
				s = "MASACHCHUNG";
				break;
		
			case "Tên sách":
				s = "TENSACH";
				break;

			case "Thể loại":
				s = "THELOAI";
				break;
		
			case "Năm xuất bản":
				s = "NAMXUATBAN";
				break;
			default: 
				s = "MASACHCHUNG";
				break;
}
			String sql = "SELECT * FROM masachchung ORDER BY " + s;
			
			//b4: xu li
			ResultSet rs = st.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				String MASACHCHUNG  = rs.getString("MASACHCHUNG");
				String TENSACH		 = rs.getString("TENSACH");
				int    SOLUONG	 	= Integer.parseInt(rs.getString("SOLUONG"));
				String THELOAI	 = rs.getString("THELOAI");
				String TACGIA		 = rs.getString("TACGIA");
				String NAMXUATBAN		 = rs.getString("NAMXUATBAN");
				String NHAXUATBAN		 = rs.getString("NHAXUATBAN");
				MaSachChung masachchung = new MaSachChung(MASACHCHUNG, TENSACH, SOLUONG, THELOAI, TACGIA, NHAXUATBAN, NAMXUATBAN);
				mscs.add(masachchung);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mscs;
	}
	 
	public void Them(MaSachChung t) {
		try {
			//b1: tao connect
			Connection conn = JDBCUtil.getConnection();
			
			//b2: tao doi tuong statement
			Statement st = conn.createStatement();
			
			//b3: execute query
			String sql =  "INSERT INTO masachchung (MASACHCHUNG,TENSACH,SOLUONG,THELOAI,TACGIA,NHAXUATBAN,NAMXUATBAN)" + " VALUES (" 
					+  "'" + t.getMaSachChung() + "'" +","  + "'" + t.getTenSach() + "'" + "," +  t.getSoLuong() + "," + 
					"'" + t.getTheLoai() + "'" + "," + "'" + t.getTacGia() +"'" + "," + "'" + t.getNhaXuatBan() + "'" + "," + "'" + t.getNamXuatBan() + "'"  + ")";
			//b4: execute
				System.out.println("ban da thuc thi  cau lenh: " + sql);
			int ketQua = st.executeUpdate(sql);

					if (ketQua > 0) {
			System.out.println("THEM SACH CO ma sach chung: " + t.getMaSachChung() + " THANH CONG !");
					} else {
			System.out.println("THEM SACH CO ma sach chung" + t.getMaSachChung() + " that bai");
}
			// b5: ngat ket noi
JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			/***********/
			e.printStackTrace();
			int ErrorCode = e.getErrorCode();
			String ErrorMessage = e.getMessage();
			// Xây dựng thông điệp lỗi
			if(ErrorCode == 1062){
				ErrorMessage = " trùng lặp giá trị Mã Sách Chung ";
			}
			else if(ErrorCode == 1406) {
				ErrorMessage = " Giá trị quá dài ! ";
			}
            String errorMessage = "" + ErrorMessage ;
                                  
//                                  +"\nError code: " + ErrorCode;

            // Hiển thị thông điệp lỗi bằng JOptionPane
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
            /***********/
		}
		
	}
	public void Luu(MaSachChung t, String MSC) {
		try {
			//b1: tao connect
			Connection conn = JDBCUtil.getConnection();
			
			//b2: tao doi tuong statement
			Statement st = conn.createStatement();
			
			//b3: execute query
			String sql =  "UPDATE masachchung "
					+ "SET                   "
					+ "MASACHCHUNG        = '" + t.getMaSachChung()  + "', "
					+ "TENSACH            = '" + t.getTenSach()      + "', "
					+ "SOLUONG            =  " + t.getSoLuong()      + " , " 
					+ "THELOAI            = '" + t.getTheLoai()      + "', "
					+ "TACGIA             = '" + t.getTacGia()       + "', "
					+ "NHAXUATBAN		  = '" + t.getNhaXuatBan()   + "', "
					+ "NAMXUATBAN		  = '" + t.getNamXuatBan()   + "'  "
					+ "WHERE MASACHCHUNG  = '" + MSC                 +"'";
					
			//b4: execute
						System.out.println("ban da thuc thi  cau lenh: " + sql);
			int ketQua = st.executeUpdate(sql);

//					if (ketQua > 0) {
//			System.out.println("update CO ma ban doc: " + t.getMaSachChung() + " THANH CONG !");
//					} else {
//			System.out.println("update CO ma ban doc" + t.getMaSachChung() + " that bai");
//}
			// b5: ngat ket noi
            JOptionPane.showMessageDialog(null, "Cập nhật mã sách thành công", "Cập nhật thông tin", JOptionPane.ERROR_MESSAGE);

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			/***********/
			e.printStackTrace();
			int ErrorCode = e.getErrorCode();
			String ErrorMessage = e.getMessage();
			// Xây dựng thông điệp lỗi
			if(ErrorCode == 1062){
				ErrorMessage = " trùng lặp giá trị Mã Sách ";
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
			String sql = "DELETE FROM `thuvien`.`masachchung` WHERE  `MASACHCHUNG` = " + "'" + t + "'";
			//b4: thuc hien lenh
			System.out.println("ban da thuc thi  cau lenh: " + sql);
			int ketQua = st.executeUpdate(sql);
			if(ketQua > 0)
			System.out.println("xoa ma sach thanh cong");
			else {
				System.out.println("that bai");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		}
		
	}
	public ArrayList<MaSachChung> SelectResult(String t) {
		mscs = new ArrayList<MaSachChung>();
		try {
			//b1: tao connection
			Connection conn = JDBCUtil.getConnection();
			
			//b2: statement
			Statement st = conn.createStatement();
			
			//b3: execute
			String s = "";
			switch(SortCondition) {
			
			case "Mã sách chung":
				s = "MASACHCHUNG";
				break;
		
			case "Tên sách":
				s = "TENSACH";
				break;

			case "Thể loại":
				s = "THELOAI";
				break;
		
			case "Năm xuất bản":
				s = "NAMXUATBAN";
				break;
			default: 
				s = "MASACHCHUNG";
				break;
}
			String sql = "SELECT * FROM masachchung " 
					+ "WHERE CONCAT_WS(' ', MASACHCHUNG, TENSACH, SOLUONG, THELOAI,TACGIA,NAMXUATBAN,NHAXUATBAN) LIKE '%" + t +"%'"
					+ " ORDER BY " + s;
			System.out.println(sql);
			//b4: xu li
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String MASACHCHUNG  = rs.getString("MASACHCHUNG");
				String TENSACH		 = rs.getString("TENSACH");
				int    SOLUONG	 	= Integer.parseInt(rs.getString("SOLUONG"));
				String THELOAI	 = rs.getString("THELOAI");
				String TACGIA		 = rs.getString("TACGIA");
				String NAMXUATBAN		 = rs.getString("NAMXUATBAN");
				String NHAXUATBAN		 = rs.getString("NHAXUATBAN");
				MaSachChung masachchung = new MaSachChung(MASACHCHUNG, TENSACH, SOLUONG, THELOAI, TACGIA, NHAXUATBAN, NAMXUATBAN);
				mscs.add(masachchung);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mscs;
	}
	 

	 
	public void SapXepTheoTenSach(MaSachChung t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void SapXepTheoTheLoai(MaSachChung t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void SapXepTheoNamXuatBan(MaSachChung t) {
		// TODO Auto-generated method stub
		
	}




}
