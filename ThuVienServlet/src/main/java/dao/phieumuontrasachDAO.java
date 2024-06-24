package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Util.HibernateUtil;

import java.sql.Date;
import java.sql.PreparedStatement;

import database.JDBCUtil;
import model.*;


public class phieumuontrasachDAO {

	public ArrayList<PhieuMuonTraSach> pmtss ;
	private String SortCondition = "";
	private String State = " '' OR 1 = 1 ";
	public phieumuontrasachDAO() {
		
	}
	public phieumuontrasachDAO(String sortCondition,String state) {
		if(state != "Tất cả") {
			State = "";
			State += "'" + state + "'";
		}
		SortCondition = sortCondition;
	}


	
	public static ArrayList<PhieuMuonTraSach> PhieuBanDoc(String id){
 
		try {
			ArrayList<PhieuMuonTraSach> pmts = new ArrayList<PhieuMuonTraSach>();		//*** GOI RA DE CLEAR ARRAY CU~ VA LAY DATA MOI
			ArrayList<PhieuMuonTraSach> Mainpmts = new ArrayList<PhieuMuonTraSach>();		
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			
			if(sessionFactory!=null) { // init sessionFactory success
				
				Session session = sessionFactory.openSession(); //open new Session 
				
				Transaction tr = session.beginTransaction(); // mo ra giao dich dam bao thuc hien thanh cong session
				
				String HQL = "From PhieuMuonTraSach" ;
				
				Query<PhieuMuonTraSach>query = session.createQuery(HQL,PhieuMuonTraSach.class); //chay query va lay ket qua ve danh sach instance
				
				
				pmts = (ArrayList<PhieuMuonTraSach>) query.getResultList(); /* query tra ve List nen phai ep kieu thanh Arraylist de thoa man*/
				
				for(PhieuMuonTraSach p : pmts) {
					if(p.getMaBanDoc().equals(id)) {
						Mainpmts.add(p);
					}
				}
				
					
				tr.commit();
				session.close();
			//	HibernateUtil.shutdown();
				return Mainpmts;
			}
		}finally {
			//HibernateUtil.shutdown();
			
		}
		//null if error 
		return null;

	}
	
	
	public ArrayList<PhieuMuonTraSach> SelectAll() {
		
		pmtss = new ArrayList<PhieuMuonTraSach>();
		try {
			//b1: tao connection
			Connection conn = JDBCUtil.getConnection();
			
			//b2: statement
			Statement st = conn.createStatement();
			
			//b3: execute
			String s = "";
			switch(SortCondition) {
			
			case "Mã phiếu mượn":
				s = "MAPHIEUMUON";
				break;
		
			case "Ngày mượn":
				s = "NGAYMUON";
				break;
			case "Ngày trả":
				s = "NGAYTRA";
				break;
			case "Hạn trả":
				s = "HANTRA";
				break;
			default: 
				s = "MAPHIEUMUON";
				break;
}
			String sql = "SELECT * FROM phieumuontrasach WHERE (TINHTRANG = " + State + ") ORDER BY "  + s;
			System.out.println(sql);
			//b4: xu li
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String MAPHIEUMUON  = rs.getString("MAPHIEUMUON");
				String MABANDOC		 = rs.getString("MABANDOC");
				String MASACH		 = rs.getString("MASACH");
				int    SOLUONG	 	= Integer.parseInt(rs.getString("SOLUONG"));
				Date NGAYMUON	 = rs.getDate("NGAYMUON");
				Date HANTRA		 = rs.getDate("HANTRA");
				Date NGAYTRA  = rs.getDate("NGAYTRA");
				String TINHTRANG	 = rs.getString("TINHTRANG");
				PhieuMuonTraSach phieumuontrasach = new PhieuMuonTraSach(MAPHIEUMUON, MABANDOC, MASACH, SOLUONG, NGAYMUON, HANTRA, NGAYTRA, TINHTRANG);
				pmtss.add(phieumuontrasach);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pmtss;
	}

	 
	public void Them(PhieuMuonTraSach t) {
		
			try {
				// b1: tao connect
				Connection conn = JDBCUtil.getConnection();

				// b2: tao doi tuong statement
				Statement st = conn.createStatement();
				
				// b3: execute query
				if(Check(t.getMaBanDoc(),t.getMaSach()) == false ){
					System.out.println("KHONG TON TAI MA SACH  HOAC MA BAN DOC");
					//JOptionPane.showMessageDialog(null, "Mã Sách Không Tồn Tại " , "ERROR EXIST", JOptionPane.YES_OPTION);
				}
				
				else {
					System.out.println("no hien ra o day");
				String sql = "INSERT INTO phieumuontrasach (MAPHIEUMUON,MABANDOC,MASACH,SOLUONG,NGAYMUON,HANTRA)"
						+ " VALUES (" + "'" + t.getMaPhieuMuon() + "'" + "," + "'" + t.getMaBanDoc() + "'" + "," + "'"
						+ t.getMaSach() + "'" + "," + "'" + t.getSoLuong() + "'" + "," + "'" + t.getNgayMuon() + "'" + ","
						+ "'" + t.getHanTra() + "'" + ")";
				// b4: execute
				System.out.println("ban da thuc thi  cau lenh: " + sql);
				int ketQua = st.executeUpdate(sql);

				if (ketQua > 0) {
					System.out.println("THEM ma phieu muon: " + t.getMaPhieuMuon() + " THANH CONG !");
					JOptionPane.showMessageDialog(null, "Thêm phiếu mượn thành công", "PHIẾU MƯỢN", JOptionPane.INFORMATION_MESSAGE);

				} else {
					System.out.println("THEM ma phieu muon" + t.getMaPhieuMuon() + " that bai");
				}
				
				}
				// b5: ngat ket noi
			} catch (SQLException e) {
				/***********/
				e.printStackTrace();
				int ErrorCode = e.getErrorCode();
				String ErrorMessage = e.getMessage();
				// Xây dựng thông điệp lỗi
				if(ErrorCode == 1062){
					ErrorMessage = " Tồn tại phiếu mượn";
				}
				else if(ErrorCode == 1406) {
					ErrorMessage = " Mã Bạn Đọc Hoặc Mã Sách Quá Dài";
				}
	            String errorMessage = "" + ErrorMessage + "        " ;//+  e.getErrorCode() 
	                                  
//	                                  +"\nError code: " + ErrorCode;

	            // Hiển thị thông điệp lỗi bằng JOptionPane
	            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
	            /***********/
			}


	}

	public void Luu(PhieuMuonTraSach t, String MPM) {
		try {
			//b1: tao connect
			Connection conn = JDBCUtil.getConnection();
			
			//b2: tao doi tuong statement
			if(Check(t.getMaBanDoc(),t.getMaSach()) == false ){
				System.out.println("KHONG TON TAI MA SACH  HOAC MA BAN DOC");
				//JOptionPane.showMessageDialog(null, "Mã Sách Không Tồn Tại " , "ERROR EXIST", JOptionPane.YES_OPTION);
			}
			else {
				Statement st = conn.createStatement();

				String sql =  "UPDATE phieumuontrasach "
						+ "SET                   "
						+ "MAPHIEUMUON        = '" + t.getMaPhieuMuon()   + "', "
						+ "MABANDOC        = '" + t.getMaBanDoc()         + "', "
						+ "MASACH             = '" + t.getMaSach()        + "', " 
						+ "SOLUONG            = '" + t.getSoLuong()       + "', "
						+ "NGAYMUON           = '" + t.getNgayMuon()      + "', "
						+ "HANTRA		      = '" + t.getHanTra()        + "', "
						+ "NGAYTRA		      = '" + t.getNgayTra()       + "', "
						+ "TINHTRANG		  = '" + t.getTinhTrang()     + "'  "
						+ "WHERE MAPHIEUMUON  = '" + MPM                       + "'  ";
						
				//b4: execute
				System.out.println(t.toString()); 
				
							System.out.println(sql);
				int ketQua = st.executeUpdate(sql);
				  JOptionPane.showMessageDialog(null, "Cập nhật mã sách thành công", "Cập nhật thông tin", JOptionPane.PLAIN_MESSAGE);
						if (ketQua == 0) {
				System.out.println("update CO ma phieu muon: " + t.getMaPhieuMuon() + " THANH CONG !");
						} else {
				//System.out.println("update CO ma phieu muon: " + t.getMaPhieuMuon() + " that bai");
	}
			}
		
			// b5: ngat ket noi

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
          

			/***********
			
			int ErrorCode = e.getErrorCode();
			String ErrorMessage = e.getMessage();
			// Xây dựng thông điệp lỗi
			if(ErrorCode == 1062){
				ErrorMessage = " trùng lặp giá trị Mã Sách Chung ";
			}
            String errorMessage = " Error: " + ErrorMessage +
                                  
                                  "\nError code: " + ErrorCode;

            // Hiển thị thông điệp lỗi bằng JOptionPane
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
            ***********/
		}
		
		
	}
	 
	public void Xoa(String t) {
		try {
			//b1: tao bien connection
			Connection conn = JDBCUtil.getConnection();
			//b2: tao bien statement
			Statement st = conn.createStatement();
			//b3: truy van
			String sql = "DELETE FROM `thuvien`.`phieumuontrasach` WHERE  `maphieumuon` = " + "'" + t + "'";
			//b4: thuc hien lenh
			System.out.println("ban da thuc thi  cau lenh: " + sql);
			int ketQua = st.executeUpdate(sql);
			if(ketQua > 0)
			System.out.println("xoa phieu muon thanh cong");
			else {
				System.out.println("that bai");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	////////////////////////
	public static void MuonSach(String MaSach, String Id) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    try {
	        // Bước 1: Tạo kết nối
	        conn = JDBCUtil.getConnection();

	        // Bước 2: Tính toán NgayMuon và HanTra
	        LocalDate NgayMuon = LocalDate.now(); // Ngày hiện tại
	        LocalDate HanTra = NgayMuon.plusDays(7); // Cộng thêm 7 ngày
	        Date NgayTra = null; // Giá trị null cho NgayTra

	        // Bước 3: Tạo câu lệnh SQL sử dụng PreparedStatement
	        String sql = "INSERT INTO `thuvien`.`phieumuontrasach` (MAPHIEUMUON, MABANDOC, MASACH, SOLUONG, NGAYMUON, HANTRA, NGAYTRA, TINHTRANG) " +
	                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, MaSach + Id);
	        pstmt.setString(2, Id);
	        pstmt.setString(3, MaSach);
	        pstmt.setInt(4, 1);
	        pstmt.setDate(5, Date.valueOf(NgayMuon)); // Chuyển LocalDate sang java.sql.Date
	        pstmt.setDate(6, Date.valueOf(HanTra)); // Chuyển LocalDate sang java.sql.Date
	        pstmt.setNull(7, java.sql.Types.DATE); // Set NgayTra là null
	        pstmt.setString(8, "Chưa trả");

	        // Bước 4: Thực hiện câu lệnh và kiểm tra kết quả
	        int ketQua = pstmt.executeUpdate();
	        if (ketQua > 0) {
	            System.out.println("Thêm phiếu mượn thành công");
	        } else {
	            System.out.println("Thất bại");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng các tài nguyên
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException ex) {
	        ex.printStackTrace();
	        }
	    }
	}
	public static void TraSach(String MaPhieuMuon) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    try {
	        // Bước 1: Tạo kết nối
	        conn = JDBCUtil.getConnection();

	        // Bước 2: Định dạng ngày hiện tại
	        LocalDate NgayTra = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String formattedDate = NgayTra.format(formatter);

	        // Bước 3: Tạo câu lệnh SQL sử dụng PreparedStatement
	        String sql = "UPDATE `thuvien`.`phieumuontrasach` "
	                   + "SET TINHTRANG = ?, NGAYTRA = ? "
	                   + "WHERE `maphieumuon` = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, "đã trả");
	        pstmt.setString(2, formattedDate);
	        pstmt.setString(3, MaPhieuMuon);

	        // Bước 4: Thực hiện câu lệnh
	        int ketQua = pstmt.executeUpdate();
	        if (ketQua > 0) {
	            System.out.println("Cập nhật phiếu mượn thành công");
	        } else {
	            System.out.println("Cập nhật phiếu mượn thất bại");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng các tài nguyên
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
public ArrayList<PhieuMuonTraSach> SelectResult(String t) {
		
		pmtss = new ArrayList<PhieuMuonTraSach>();
		try {
			//b1: tao connection
			Connection conn = JDBCUtil.getConnection();
			
			//b2: statement
			Statement st = conn.createStatement();
			
			//b3: execute
			String s = "";
			switch(SortCondition) {
			
			case "Mã phiếu mượn":
				s = "MAPHIEUMUON";
				break;
		
			case "Ngày mượn":
				s = "NGAYMUON";
				break;
			case "Ngày trả":
				s = "NGAYTRA";
				break;
			case "Hạn trả":
				s = "HANTRA";
				break;

			default: 
				s = "MAPHIEUMUON";
				break;
}
			String sql = "SELECT * FROM phieumuontrasach"
					+ " WHERE "
					+ "CONCAT_WS(' ', MAPHIEUMUON,MABANDOC,MASACH,SOLUONG,NGAYMUON,HANTRA,NGAYTRA,TINHTRANG) LIKE '%"+ t +"%'"
					+ "ORDER BY " + s;
					
			System.out.println(sql);
			//b4: xu li
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String MAPHIEUMUON  = rs.getString("MAPHIEUMUON");
				String MABANDOC		 = rs.getString("MABANDOC");
				String MASACH		 = rs.getString("MASACH");
				int    SOLUONG	 	= Integer.parseInt(rs.getString("SOLUONG"));
				Date NGAYMUON	 = rs.getDate("NGAYMUON");
				Date HANTRA		 = rs.getDate("HANTRA");
				Date NGAYTRA  = rs.getDate("NGAYTRA");
				String TINHTRANG	 = rs.getString("TINHTRANG");
				PhieuMuonTraSach phieumuontrasach = new PhieuMuonTraSach(MAPHIEUMUON, MABANDOC, MASACH, SOLUONG, NGAYMUON, HANTRA, NGAYTRA, TINHTRANG);
				pmtss.add(phieumuontrasach);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pmtss;
	}

	public boolean Check(String mbd,String ms) {
		try {
			//b1: tao connection
			Connection conn = JDBCUtil.getConnection();
			
			//b2: statement
			Statement st1 = conn.createStatement();
			Statement st2 = conn.createStatement();
			//b3: execute
			String sql1 = "SELECT * FROM bandoc WHERE MABANDOC = '" + mbd + "'";
			String sql2 = "SELECT * FROM sach WHERE MASACH = '" + ms    + "'";
			System.out.println(sql1);
			System.out.println(sql2);
			//b4: xu li
			ResultSet rs1 = st1.executeQuery(sql1);
			ResultSet rs2 = st2.executeQuery(sql2);
			String MABANDOC = "";
			while(rs1.next())
			 MABANDOC  = rs1.getString("MABANDOC");
			String MASACH = "";
			while(rs2.next())
			 MASACH  = rs2.getString("MASACH");
			if(MABANDOC.equals("")) {
				JOptionPane.showMessageDialog(null, "Không tồn tại Mã Bạn Đọc", "INVALID", JOptionPane.YES_OPTION);
				return false;
			}
			if(MASACH.equals("")) {
				JOptionPane.showMessageDialog(null, "Không tồn tại Mã Sách", "INVALID", JOptionPane.YES_OPTION);
				return false;
			}
			
			
			
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	 
	public void Clear(PhieuMuonTraSach t) {
		// TODO Auto-generated method stub

	}

	 
	public void Save(PhieuMuonTraSach t) {
		// TODO Auto-generated method stub

	}
}
