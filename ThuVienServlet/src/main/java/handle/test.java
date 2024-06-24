package handle;

import java.util.ArrayList;

import dao.bandocDAO;
import dao.loginDAO;
import dao.phieumuontrasachDAO;
import dao.sachDAO;
import model.BanDoc;
import model.Login;
import model.PhieuMuonTraSach;
import model.Sach;

public class test {
	public static void main(String[] args) {
		
		 
		phieumuontrasachDAO p1 = new phieumuontrasachDAO();
		ArrayList<PhieuMuonTraSach>p2 = p1.SelectAll();

		
		bandocDAO b1 = new bandocDAO();
		ArrayList<BanDoc>b2 = b1.SelectAll();
		
	    sachDAO s1 = new sachDAO();
	    ArrayList<Sach> s2 = s1.SelectAll();
	    
	    loginDAO l1 = new loginDAO();
		ArrayList<Login> l2 = l1.SelectAll();
	    
		for(PhieuMuonTraSach p : p2)
			System.out.println(p.toString());
		
		for(BanDoc b : b2)
			System.out.println(b.toString());
		
		for(Sach s : s2)
			System.out.println(s.toString());
		
		for(Login l : l2)
			System.out.println(l.toString());
		
		//System.out.println(loginDAO.Login("admin", "admin123"));
	}
}
