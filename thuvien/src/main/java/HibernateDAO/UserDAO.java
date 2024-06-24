package HibernateDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Util.HibernateUtil;
import model.BanDoc;


public class UserDAO {
	
	//lop ma hoa
	public static void main(String[] args) {
		/*
		 * select
		 * insert
		 * delete
		 */
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					BanDoc bd = new BanDoc("23CE2.B030","Le Dinh Vu", "vuld.23ceb@vku.udn.vn","password123","0905376235","Sinh viên");
					session.save(bd);			//insert
					tr.commit();
				} finally {
					// TODO: handle finally clause
				}
			}
		} 
		
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void SignUp(BanDoc bd) {
		
	}
	
	
}
