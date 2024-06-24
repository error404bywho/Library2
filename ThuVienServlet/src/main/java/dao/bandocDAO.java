package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import database.JDBCUtil;
import model.BanDoc;

public class bandocDAO {
	
	//public QuanLiBanDocPanel bdpn ;
		
	public ArrayList<BanDoc> bds ;
	private String SortCondition = "";
	public bandocDAO() {

		
	}
	public bandocDAO(String sortCondition) {

		SortCondition = sortCondition;
	}

//	public QuanLiBanDocPanel bd = new QuanLiBanDocPanel();
	
	public ArrayList<BanDoc> SelectAll(){
		
		bds = new ArrayList<BanDoc>();		//*** GOI RA DE CLEAR ARRAY CU~ VA LAY DATA MOI
		
		try {
			//b1: tao connection
			Connection conn = JDBCUtil.getConnection();
			
			//b2: statement
			Statement st = conn.createStatement();
			
			//b3: execute
			String s = "";
			switch(SortCondition) {
			
			case "Mã bạn đọc":
				s = "MABANDOC";
				break;
		
			case "Tên bạn đọc":
				s = "TEN";
				break;

			case "Chức vụ":
				s = "CHUCVU";
				break;
			default: 
				s = "MABANDOC";
				break;
}
			String sql = "SELECT * FROM bandoc  ORDER BY " + s;
	
			
			//b4: xu li
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String MABANDOC  = rs.getString("MABANDOC");
				String TEN		 = rs.getString("TEN");
				String DIACHI	 = rs.getString("EMAIL");
				String CCCD		 = rs.getString("PASSWORD");
				String SDT		 = rs.getString("SDT");
				String CHUCVU	 = rs.getString("CHUCVU");
				BanDoc bandoc = new BanDoc(MABANDOC, TEN, DIACHI, CCCD, SDT, CHUCVU);
				bds.add(bandoc);
				
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bds;
		
	}
		//bdpn.getArrayBanDoc(bds);
	 
	public void Them(BanDoc t) {
		try {
			//b1: tao connect
			Connection conn = JDBCUtil.getConnection();
			
			//b2: tao doi tuong statement
			Statement st = conn.createStatement();
			
			//b3: execute query
			String sql =  "INSERT INTO bandoc (MABANDOC,TEN,DIACHI,CCCD,SDT,CHUCVU)" + " VALUES (" 
					+  "'" + t.getMaBanDoc() + "'" +","  + "'" + t.getTen() + "'" + "," + "'" + t.getEmail() + "'" + "," + 
					"'" + t.getPassword() + "'" + "," + "'" + t.getSdt() +"'" + "," + "'" + t.getChucVu() +"'" + ")";
			//b4: execute
						System.out.println("ban da thuc thi  cau lenh: " + sql);
			int ketQua = st.executeUpdate(sql);
			SelectAll();  //lay ra du lieu 1 lan nua va tra ve array chua du lieu
//			bd.model.setRowCount(0);
//			bd.ShowBanDocTable(bds);
			//SelectAll().add(t);
			
					if (ketQua > 0) {
			System.out.println("THEM ban doc CO ma ban doc: " + t.getMaBanDoc() + " THANH CONG !");
			JOptionPane.showMessageDialog(null, "Thêm bạn đọc thành công", "BẠN ĐỌC", JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, " LỖI ","Error",JOptionPane.ERROR_MESSAGE);
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
				ErrorMessage = " Tồn tại Bạn Đọc ";
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
		
	public void Luu(BanDoc t, String MBD) {
		try {
			//b1: tao connect
			Connection conn = JDBCUtil.getConnection();
			
			//b2: tao doi tuong statement
			Statement st = conn.createStatement();
			
			//b3: execute query
			String sql =  "UPDATE bandoc "
					+ "SET               "
					+ "MABANDOC       = '" + t.getMaBanDoc() + "', "
					+ "TEN            = '" + t.getTen()      + "', "
					+ "EMAIL         = '" + t.getEmail()   + "', " 
					+ "PASSWORD          = '" + t.getPassword()     + "', "
					+ "SDT            = '" + t.getSdt()      + "', "
					+ "CHUCVU		  = '" + t.getChucVu()   + "'  "
					+ "WHERE MaBanDoc = '" + MBD              +"'";
					
			//b4: execute
						System.out.println("ban da thuc thi  cau lenh: " + sql);
			int ketQua = st.executeUpdate(sql);

					if (ketQua > 0) {
			System.out.println("update CO ma ban doc: " + t.getMaBanDoc() + " THANH CONG !");
					} else {
			System.out.println("update CO ma ban doc" + t.getMaBanDoc() + " that bai");
}
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
				ErrorMessage = " Tồn tại Mã Bạn Đọc";
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
			String sql = "DELETE FROM `thuvien`.`bandoc` WHERE  `MABANDOC` = '" + t +"'";
			//b4: thuc hien lenh
			System.out.println("ban da thuc thi  cau lenh: " + sql);
			int ketQua = st.executeUpdate(sql);
			if(ketQua > 0)
			System.out.println("xoa ban doc thanh cong");
			else {
				System.out.println("that bai");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public ArrayList<BanDoc> SelectReSult(String t){
		
		bds = new ArrayList<BanDoc>();		//*** GOI RA DE CLEAR ARRAY CU~ VA LAY DATA MOI
		
		try {
			//b1: tao connection
			Connection conn = JDBCUtil.getConnection();
			
			//b2: statement
			Statement st = conn.createStatement();
			
			//b3: execute
			String s = "";
			switch(SortCondition) {
			
			case "Mã bạn đọc":
				s = "MABANDOC";
				break;
		
			case "Tên bạn đọc":
				s = "TEN";
				break;

			case "Chức vụ":
				s = "CHUCVU";
				break;
			default: 
				s = "MABANDOC";
				break;
}
			String sql = "SELECT * FROM bandoc "
					+ "WHERE "
					+ "CONCAT_WS(' ', MABANDOC,TEN,DIACHI,CCCD,SDT,CHUCVU) LIKE '%"+ t +"%'"
					+ "ORDER BY " + s;
			
			//b4: xu li
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String MABANDOC  = rs.getString("MABANDOC");
				String TEN		 = rs.getString("TEN");
				String DIACHI	 = rs.getString("DIACHI");
				String CCCD		 = rs.getString("CCCD");
				String SDT		 = rs.getString("SDT");
				String CHUCVU	 = rs.getString("CHUCVU");
				BanDoc bandoc = new BanDoc(MABANDOC, TEN, DIACHI, CCCD, SDT, CHUCVU);
				bds.add(bandoc);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bds;
		
	}
	 
	public void ChinhSua(BanDoc t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void Clear(BanDoc t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void Save(BanDoc t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void SapXepTheoMaNguoiDung(BanDoc t) {
		// TODO Auto-generated method stub
		
	}

	 
	public void SapXepTheoTenBanDoc(BanDoc t) {
		// TODO Auto-generated method stub
		
	}
	public void Reset() {
		SelectAll();
	}
	 
	public void Xoa(BanDoc t) {
		// TODO Auto-generated method stub
		
	}
	public class Sach {
		private String tensach;
		public Sach (String tensach) {
			this.tensach = tensach;
		}
		public void sach (String sach) {
			this.tensach = sach;
		}
	}
	
}