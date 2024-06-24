package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Util.HibernateUtil;
import model.BanDoc;

public class checkDAO {

	public static BanDoc CheckLogin(String StringData) {
		try {
//			data = "23CE.B030 LeDinhVu";

			String id 		= GetMabandoc(StringData);
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();

			BanDoc bandoc = session.get(BanDoc.class,id);
			System.out.println("select OK");
//			1. check if exist
			if(bandoc==null) return null;
		//	query.setParameter("id", id);
			System.out.println(bandoc.toString());
			
			System.out.println("select OK");
//			2. check if right password
			String password = GetPassword(StringData);
			System.out.println("select OK");
			System.out.println("pass selected : " + bandoc.getPassword());
			System.out.println("pass got : " + password);
			if((bandoc.getPassword()).equals(password)) return bandoc ;	//bandoc sai mk
			
			System.out.println("select OK");
			tr.commit();
		} catch (Exception e) {
			System.out.println("null vi loi");
			return null;
			
		}
		System.out.println("khong chay duoc");
		return null;
	}
	
	public static boolean CheckSignUp(String data) {
		
		
		return true;
		
	}
	public static boolean CheckExist(String id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		//bandoccu
		//BanDoc bandoc = session.get(BanDoc.class,data);
		String hib = "FROM BanDoc bd WHERE bd.MaBanDoc = " + id;

		Query query = session.createQuery(hib);
		
		tr.commit();
		
		if(query.getResultList().isEmpty()) return false;	//bandoccu khong ton tai 
			
		
		return true;
	}
	
	
	/////////////////////////////////////////////////////////////////////
	 private static  String GetPassword(String stringData) {
		 String s = stringData.trim();  // Xóa khoảng trắng đầu và cuối
		// stringData = "23CE.B030 123"
		String Password = "";
		int i = s.length()-1 ;
		while((s.charAt(i)) != ' ') {
			Password = s.charAt(i) + Password;
			i--;
		}
		System.out.println("password = \""+Password+"\"" );
		return Password;
	}
	
	private static  String GetMabandoc(String stringData) {
		String s = stringData.trim();  // Xóa khoảng trắng đầu và cuối
		
		// stringData = "23CE.B030 123"
		String mabandoc = "";
		int i = 0;
		while((s.charAt(i)) != ' ') {
			mabandoc = mabandoc + s.charAt(i);
			i++;
		}
		return mabandoc ;	
	}
	/////////////////////////////////////////////////////////////////////
	
}
