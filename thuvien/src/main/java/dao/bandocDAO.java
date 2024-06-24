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
		
		try {
			bds = new ArrayList<BanDoc>();		//*** GOI RA DE CLEAR ARRAY CU~ VA LAY DATA MOI
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			
			if(sessionFactory!=null) { // init sessionFactory success
				
				Session session = sessionFactory.openSession(); //open new Session 
				
				Transaction tr = session.beginTransaction(); // mo ra giao dich dam bao thuc hien thanh cong session
				
				String HQL = "From BanDoc";
				
				Query<BanDoc>query = session.createQuery(HQL,BanDoc.class); //chay query va lay ket qua ve danh sach instance
				
				
				
				bds = (ArrayList<BanDoc>) query.getResultList(); /* query tra ve List nen phai ep kieu thanh Arraylist de thoa man*/
					
				tr.commit();
			//	HibernateUtil.shutdown();
				return bds;
			}
		}finally {
			//HibernateUtil.shutdown();
			
		}
		//null if error 
		return null;
		
		
	}
		//bdpn.getArrayBanDoc(bds);
	 
	public void Them(BanDoc t) {
		
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(t);
			
			tr.commit();
	
		 // Hiển thị thông điệp lỗi bằng JOptionPane
        JOptionPane.showMessageDialog( null, "Thêm Bạn Đọc Thành Công", SortCondition, JOptionPane.PLAIN_MESSAGE);
        /***********/
	}
		
	public void Luu(BanDoc t, String MBD) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			//bandoccu
			BanDoc bandoc = session.get(BanDoc.class,MBD);
			
			if(bandoc!=null) {	//bandoccu ton tai thi update
				
				bandoc.setMaBanDoc(t.getMaBanDoc());
				bandoc.setTen(t.getTen());
				bandoc.setEmail(t.getEmail());
				bandoc.setPassword(t.getPassword());
				bandoc.setSdt(t.getSdt());
				bandoc.setChucVu(t.getChucVu());
				
				session.update(bandoc);
				
			}
			
			tr.commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, " error to save bandoc", SortCondition, JOptionPane.ERROR_MESSAGE);
	        /***********/
		}
		JOptionPane.showMessageDialog( null, "Thêm Bạn Đọc Thành Công", SortCondition, JOptionPane.PLAIN_MESSAGE);
        /***********/
	}


	public void Xoa(String t) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		BanDoc bandoc = session.get(BanDoc.class, t);
		
		if(bandoc!=null) 
			
		session.delete(bandoc);
		
		tr.commit();
		
		JOptionPane.showMessageDialog( null, "Xóa Bạn Đọc Thành Công", SortCondition, JOptionPane.PLAIN_MESSAGE);
        /***********/
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
					+ "CONCAT_WS(' ', MABANDOC,TEN,EMAIL,PASSWORD,SDT,CHUCVU) LIKE '%"+ t +"%'"
					+ "ORDER BY " + s;
			//noi cac thuoc tinh lai thanh chuoi va loc ra yeu to "t" co ton tai trong chuoi hay khong
			//b4: xu li
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String MABANDOC  = rs.getString("MABANDOC");
				String TEN		 = rs.getString("TEN");
				String EMAIL	 = rs.getString("EMAIL");
				String PASSWORD		 = rs.getString("PASSWORD");
				String SDT		 = rs
						.getString("SDT");
				String CHUCVU	 = rs.getString("CHUCVU");
				BanDoc bandoc = new BanDoc(MABANDOC, TEN, EMAIL, PASSWORD, SDT, CHUCVU);
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
