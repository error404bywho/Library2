package ViewLogin;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import server.Server;
import view.QuanLiBanDocPanel;
import view.QuanLiMaSachChungPanel;
import view.QuanLiPhieuMuonTraSachPanel;
import view.QuanLiSachPanel;


public class QuanLiThuVien extends JFrame {

	public QuanLiThuVien() {

		init();
		setVisible(true);

	}

	public void init() {

		setTitle("Chương Trình Quản Lí Thư Viện ");
		setSize(1545, 1000);
		setLocation(-5, 0);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JTabbedPane tp = new JTabbedPane();
		tp.setBounds(10, 10, 1500, 900);

		QuanLiMaSachChungPanel JPQuanLiMaSachChung = new QuanLiMaSachChungPanel(); // QUẢN LÍ MÃ SÁCH CHUN
		QuanLiSachPanel JPQuanLiSach = new QuanLiSachPanel(); // QUẢN LÍ SÁCH
		QuanLiBanDocPanel JPQuanLiBanDoc = new QuanLiBanDocPanel(); // QUẢN LÍ BẠN ĐỌC
		QuanLiPhieuMuonTraSachPanel JPQuanLiPhieuMuonSach = new QuanLiPhieuMuonTraSachPanel(); // QUẢN LÍ PHIẾU MƯỢN
		/***new***/
		
		//tp.add("Quản lí mã sách chung", JPQuanLiMaSachChung);
		tp.add("Quản lí sách", JPQuanLiSach);
		tp.add("Quản lí bạn đọc", JPQuanLiBanDoc);                                                                   
		tp.add("Quản lí phiếu mượn trả sách", JPQuanLiPhieuMuonSach);
		
		add(tp);
	}
	public static void main(String[] args) throws Exception {
		try {
			// String src = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			String src = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
			// src = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
			// src = "com.jtattoo.plaf.noire.NoireLookAndFeel";  
			UIManager.setLookAndFeel(src);
			new QuanLiThuVien();
			new Server();
		
				
			
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

}
