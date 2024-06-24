package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Util.HibernateUtil;
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
		

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			String HQL = "From Sach";
			
			Query<Sach>query = session.createQuery(HQL);
			
			ss = (ArrayList<Sach>) query.getResultList();
			
			tr.commit();
			
			return ss;
		
		
	}
	 
	public void Them(Sach t) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		session.save(t);
		
		tr.commit();
		
		JOptionPane.showMessageDialog(null, "Cập nhật sách thành công", "THÊM SÁCH", JOptionPane.INFORMATION_MESSAGE);
	}

	public void Luu(Sach t, String S) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		//sachcu
		Sach sach = session.get(Sach.class,S);
		
		if(sach!=null) {	//sachcu ton tai thi update
			
			sach.setMaSachChung(t.getMaSachChung());
			sach.setMaSach(t.getMaSach());
			sach.setTenSach(t.getTenSach());
			sach.setTheLoai(t.getTheLoai());
			sach.setTacGia(t.getTacGia());
			sach.setTrangThai(t.getTrangThai());
			
			session.update(sach);
		}
		
		tr.commit();
            // Hiển thị thông điệp lỗi bằng JOptionPane
		JOptionPane.showMessageDialog(null, " Thêm Sách Thành Công", SortCondition, JOptionPane.PLAIN_MESSAGE);
        /***********/
		
		
	}
	public void Xoa(String t) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		Sach sach = session.get(Sach.class,t);
		
		session.delete(sach);
		
		tr.commit();
		
		JOptionPane.showMessageDialog(null, "Xóa Thành Công", SortCondition, JOptionPane.PLAIN_MESSAGE);
		
		
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
			byte[] ANH = rs.getBytes("ANH");
			Sach sach = new Sach(MASACHCHUNG, MASACH, TENSACH, THELOAI, TACGIA, TRANGTHAI,ANH);
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
