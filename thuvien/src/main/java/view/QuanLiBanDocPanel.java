package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Override.CustomTableModel;
import ViewLogin.QuanLiThuVien;
import action.*;
import model.BanDoc;
import model.PhieuMuonTraSach;
import dao.bandocDAO;
import dao.masachchungDAO;

public class QuanLiBanDocPanel extends JPanel implements MouseListener {

	private JLabel JLTenBanDoc;

	private JLabel JLBanDoc;
	private JLabel JLMaBanDoc;

	private JLabel JLEmail;
	private JLabel JLPassword;
	private JLabel JLSdt;
	private JLabel JLChucVu;
	private JLabel JLSoBanDoc;


	private JTextField JTMaBanDoc;
	private JTextField JTTen;
	private JTextField JTEmail;
	private JTextField JTPassword;
	private JTextField JTSdt;

	private JRadioButton JRGiangVien;
	private JRadioButton JRSinhVien;
	private JTextField JTTimKiem;

	private JButton JBThem;
	private JButton JBNhapLai;
	private JButton JBTimKiem;
	private JButton JBLuu;
	private JButton JBXoa;
	private JButton JBReset;

	private JComboBox<String> JCSapXep;
	private ButtonGroup BGChucVu;

	private Font font;
	private Font fontTitle;
	private JTable JTbBanDoc = new JTable();
	public DefaultTableModel model = new CustomTableModel();

	private int xMBD;
	private int yMBD;
	private ActionListener ac;

	private bandocDAO bddao;

	private String MBD;

	public QuanLiBanDocPanel() {

		setLayout(null);

		bddao = new bandocDAO();

		ac = new ActionForBanDoc(this);

		ShowBanDocTable();

		init();
		setDisableForEdit();
		setEnableForAdd();
		
		this.addMouseListener(new MouseAdapter() { // MOUSE EVENT CHO JTABLE
			@Override
			public void mouseClicked(MouseEvent e) {
				// Xử lý sự kiện khi chuột được nhấn
				JTbBanDoc.clearSelection(); // Bỏ chọn mọi hàng khi nhấn ở ngoài table
				setDisableForEdit();
				setEnableForAdd();
				// ClearInfo();
			}
		});
	}

	public void init() {

		fontTitle = new Font("consolas", Font.BOLD, 20);
		font = new Font("consolas", Font.BOLD, 13);

		xMBD = 10;
		yMBD = 50;

		JLBanDoc = new JLabel("BẠN ĐỌC"); // LABEL
		JLBanDoc.setBounds(200, 5, 200, 50);
		JLBanDoc.setFont(fontTitle);
		add(JLBanDoc);

		JLMaBanDoc = new JLabel("Mã bạn đọc         :");
		JLMaBanDoc.setBounds(xMBD, yMBD, 200, 50);
		JLMaBanDoc.setFont(font);
		add(JLMaBanDoc);

		JLTenBanDoc = new JLabel("Tên bạn đọc      		  :");
		JLTenBanDoc.setBounds(xMBD, yMBD + 40, 200, 50);
		JLTenBanDoc.setFont(font);
		add(JLTenBanDoc);

		JLEmail = new JLabel("Địa Chỉ      	      :");
		JLEmail.setBounds(xMBD, yMBD + 80, 200, 50);
		JLEmail.setFont(font);
		add(JLEmail);

		JLPassword = new JLabel("Password      		         :");
		JLPassword.setBounds(xMBD, yMBD + 120, 200, 50);
		JLPassword.setFont(font);
		add(JLPassword);

		JLSdt = new JLabel("Số điện thoại      :");
		JLSdt.setBounds(xMBD, yMBD + 160, 200, 50);
		JLSdt.setFont(font);
		add(JLSdt);

		JLChucVu = new JLabel("Chức vụ            :");
		JLChucVu.setBounds(xMBD, yMBD + 200, 200, 50);
		JLChucVu.setFont(font);
		add(JLChucVu);

		JLSoBanDoc = new JLabel("Số lượng bạn đọc: " + bddao.SelectAll().size());
		JLSoBanDoc.setBounds(xMBD + 320, yMBD + 250, 200, 50);
		JLSoBanDoc.setFont(font);
		JLSoBanDoc.setForeground(Color.gray);
		add(JLSoBanDoc);
		JTMaBanDoc = new JTextField(); // TEXT FIELD
		JTMaBanDoc.setBounds(xMBD + 190, yMBD + 10, 300, 25);
		JTMaBanDoc.setFont(font);
		add(JTMaBanDoc);

		JTTen = new JTextField();
		JTTen.setBounds(xMBD + 190, yMBD + 50, 300, 25);
		JTTen.setFont(font);
		add(JTTen);

		JTEmail = new JTextField();
		JTEmail.setBounds(xMBD + 190, yMBD + 90, 300, 25);
		JTEmail.setFont(font);
		add(JTEmail);

		JTPassword = new JTextField();
		JTPassword.setBounds(xMBD + 190, yMBD + 130, 300, 25);
		JTPassword.setFont(font);
		add(JTPassword);

		JTSdt = new JTextField();
		JTSdt.setBounds(xMBD + 190, yMBD + 170, 300, 25);
		JTSdt.setFont(font);
		add(JTSdt);

		JTTimKiem = new JTextField();
		JTTimKiem.setBounds(xMBD + 790, yMBD + 260, 550, 30);
		JTTimKiem.setFont(font);
		add(JTTimKiem);

		JBThem = new JButton("Thêm"); // BUTTON
		JBThem.setBounds(xMBD, yMBD + 260, 120, 30);
		JBThem.setFont(font);
		JBThem.addActionListener(ac);
		add(JBThem);

		JBNhapLai = new JButton("Clear");
		JBNhapLai.setBounds(xMBD + 150, yMBD + 260, 120, 30);
		JBNhapLai.setFont(font);
		JBNhapLai.addActionListener(ac);
		add(JBNhapLai);

//		JBReset = new JButton("Reset");
//		JBReset.setBounds(xMBD + 550, yMBD + 260, 100, 30);
//		JBReset.setFont(font);
//		JBReset.addActionListener(ac);
//		add(JBReset);

//		JBChinhSua = new JButton("Chỉnh Sửa");
//		 JBChinhSua.setBounds(xMBD + 790,yMBD , 120, 30);
//		 JBChinhSua.setFont(font);
//		 JBChinhSua.setEnabled(false);
//		 JBChinhSua.addActionListener(ac);
//		 add(JBChinhSua);

		JBLuu = new JButton("Lưu");
		JBLuu.setBounds(xMBD + 790, yMBD + 40, 120, 30);
		JBLuu.setFont(font);
		JBLuu.addActionListener(ac);
		add(JBLuu);

		JBXoa = new JButton("Xóa");
		JBXoa.setBounds(xMBD + 790, yMBD + 80, 120, 30);
		JBXoa.setFont(font);
		JBXoa.addActionListener(ac);
		add(JBXoa);

		JBTimKiem = new JButton("Tìm kiếm");
		JBTimKiem.setBounds(xMBD + 1350, yMBD + 260, 100, 30);
		JBTimKiem.setFont(font);
		JBTimKiem.addActionListener(ac);
		add(JBTimKiem);
		
		 JBReset = new JButton("Reset");
		 JBReset.setBounds(xMBD + 550,yMBD + 190 , 100, 30);
		 JBReset.setFont(font);
		 JBReset.addActionListener(ac);
		 add(JBReset);

		JRGiangVien = new JRadioButton("Giảng viên");
		JRGiangVien.setBounds(xMBD + 180, yMBD + 200, 150, 50);
		JRGiangVien.setFont(font);
		JRGiangVien.setActionCommand("Giảng viên");
		add(JRGiangVien);

		JRSinhVien = new JRadioButton("Sinh viên");
		JRSinhVien.setBounds(xMBD + 340, yMBD + 200, 120, 50);
		JRSinhVien.setFont(font);
		JRSinhVien.setActionCommand("Sinh viên");
		add(JRSinhVien);

		BGChucVu = new ButtonGroup();
		BGChucVu.add(JRGiangVien);
		BGChucVu.add(JRSinhVien);

		String[] SapXep = { "Sắp xếp (A -> Z)", "Mã bạn đọc", "Tên bạn đọc","Chức vụ" };
		JCSapXep = new JComboBox<String>(SapXep);
		JCSapXep.setBounds(xMBD + 790, yMBD + 210, 200, 30);
		JCSapXep.setFont(font);
		JCSapXep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String SortCondition = (String) JCSapXep.getSelectedItem();
				SapXep(SortCondition);
}
	
		});
		add(JCSapXep);

	}

	public void ShowBanDocTable() {

		try {

			String[] Column = { "Mã bạn đọc", "Tên bạn đọc", "Email", "Password", "Số điện thoại", "Chức Vụ" }; // ADD COLUMN
																												
			for (int i = 0; i < Column.length; i++)
				model.addColumn(Column[i]);
			ShowData(); 								// ADD ROW

			JTbBanDoc.setModel(model); 					// JUST SET MODEL FOR TABLE

			JScrollPane scrollPane = new JScrollPane(JTbBanDoc); // SCROLLPANE
			scrollPane.setBounds(0, 350, 1500, 440);
			scrollPane.createVerticalScrollBar();
			add(scrollPane);

			JTbBanDoc.addMouseListener(this); // MOUSE CLICK

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void ShowData() {
		model.setRowCount(0); 								// CLEAR DATA. /*WE CLEAR ROW AND ADD AGAIN, AVOID DUPLICATED ROW
		for (BanDoc bd : bddao.SelectAll()) { 				// ADD ROW // SelectAll TO GET DATABASE'S DATA /*CTRL FOR MORE*/
			Object[] row = { bd.getMaBanDoc(), bd.getTen(), bd.getEmail(), bd.getPassword(), bd.getSdt(), bd.getChucVu() };
			model.addRow(row);
		}
	}

	public void Them() {
		try {
			if( BGChucVu.getSelection().getActionCommand()==null|| JTMaBanDoc.getText().equals("") || JTTen.getText().equals("") || JTPassword.getText().equals("") ) {
				 JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
			 }
		else {
			ButtonModel LuaChon = BGChucVu.getSelection();

			String MaBanDoc = JTMaBanDoc.getText();
			String Ten = JTTen.getText();
			String Password = JTPassword.getText();
			String Email = JTEmail.getText();
			String Sdt = JTSdt.getText();
			String ChucVu = LuaChon.getActionCommand();

			BanDoc bd = new BanDoc(MaBanDoc, Ten, Email, Password, Sdt, ChucVu);
			bddao.Them(bd);									 						// THEM VAO DATABASE
			ShowData(); 															// SHOWDATA() CUNG DA LA DA RESET DATA
			JLSoBanDoc.setText("Số lượng bạn đọc: " + bddao.SelectAll().size());
			}
		} catch (Exception e) {
			e.printStackTrace();
			 JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void Luu() {
		try {
			if( BGChucVu.getSelection().getActionCommand()==null|| JTMaBanDoc.getText().equals("") || JTTen.getText().equals("") || JTPassword.getText().equals("") ) {
				 JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
			 }
			else {
				ButtonModel LuaChon = BGChucVu.getSelection();
				String MaBanDoc = JTMaBanDoc.getText();
				String Ten = JTTen.getText();
				String Password = JTPassword.getText();
				String Email = JTEmail.getText();
				String Sdt = JTSdt.getText();
				String ChucVu = LuaChon.getActionCommand();

				BanDoc bd = new BanDoc(MaBanDoc, Ten, Email, Password, Sdt, ChucVu);
				bddao.Luu(bd, MBD);
				ShowData();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Xoa() {
			String MaBanDoc = JTMaBanDoc.getText();
			int response = JOptionPane.showConfirmDialog(null, "Bạn chắc muốn xóa bạn đọc ?", "Xóa Bạn Dọc ", JOptionPane.YES_NO_OPTION);
			 
	        if (response == JOptionPane.YES_OPTION) {
	        	bddao.Xoa(MaBanDoc);
				ShowData();
				JLSoBanDoc.setText("Số lượng bạn đọc: " + bddao.SelectAll().size());
	        } else if (response == JOptionPane.NO_OPTION) {
	            System.out.println("Người dùng chọn Không");
	           
	        } else {
	            System.out.println("Người dùng đóng hộp thoại hoặc chọn Cancel");
	        }
			
		
	}
	public void SapXep(String SortCondition) {
		bddao = new bandocDAO(SortCondition);
		ShowData();
	}
	public void TimKiem() {
		String Input = JTTimKiem.getText();
			model.setRowCount(0);
			model.setRowCount(0); 								// CLEAR DATA. /*WE CLEAR ROW AND ADD AGAIN, AVOID DUPLICATED ROW
			for (BanDoc bd : bddao.SelectReSult(Input)) { 				// ADD ROW // SelectAll TO GET DATABASE'S DATA /*CTRL FOR MORE*/
				Object[] row = { bd.getMaBanDoc(), bd.getTen(), bd.getEmail(), bd.getPassword(), bd.getSdt(), bd.getChucVu() };
				model.addRow(row);
			}
	}
	public void Reset() {
		JOptionPane.showMessageDialog(null, "                        Đã tải lại bảng !", "Reset", JOptionPane.DEFAULT_OPTION);
		JTTimKiem.setText("");
		JCSapXep.setSelectedIndex(0);
		ShowData();
	}
	/************************************************************************/ // ENABLE AND DISABLE BUTTONS
	public void setDisableForAdd() {
		JBThem.setEnabled(false);
		JBNhapLai.setEnabled(false);
	}

	public void setEnableForAdd() {
		JBThem.setEnabled(true);
		JBNhapLai.setEnabled(true);
	}

	public void setEnableForEdit() {
		JBXoa.setEnabled(true);
		JBLuu.setEnabled(true);
	}

	public void setDisableForEdit() {
		JBXoa.setEnabled(false);
		JBLuu.setEnabled(false);
	}

	public void ClearInfo() {
		JTMaBanDoc.setText("");
		JTPassword.setText("");
		JTEmail.setText("");
		JTSdt.setText("");
		JTTen.setText("");
		BGChucVu.clearSelection();
		System.out.println("you cleared i4");
	}

	/************************************************************************/ // MOUSE EVENT
	@Override
	public void mouseClicked(MouseEvent e) {

		Point point = e.getPoint();					//	1 "con tro"  mang toa do x y 
//		int x = point.getX();						//point.getX() se chi ra toa do
		int row = JTbBanDoc.rowAtPoint(point);		// 		rowAtPoint se in ra hang tai point chi? toi. 	
													// ===> rowAtPoint(point) se chi ra row tai point do
		System.out.println("you clicked at row " + row);
//		int row = JTbBanDoc.rowAtPoint(point);
		ListSelectionModel selectionModel = JTbBanDoc.getSelectionModel();

		/***************************************************************/ // lay ra du lieu cua cac row
		MBD = (String) JTbBanDoc.getValueAt(row, 0);
		JTMaBanDoc.setText((String) JTbBanDoc.getValueAt(row, 0));
		JTTen.setText((String) JTbBanDoc.getValueAt(row, 1));
		JTEmail.setText((String) JTbBanDoc.getValueAt(row, 2));
		JTPassword.setText((String) JTbBanDoc.getValueAt(row, 3));
		JTSdt.setText((String) JTbBanDoc.getValueAt(row, 4));
		BGChucVu.clearSelection();
		//chuc vu la RadioButton
		String chucVu = (String)JTbBanDoc.getValueAt(row, 5);
		if (chucVu.equals("Giảng viên")) {
			BGChucVu.setSelected(JRGiangVien.getModel(), true);
		} else if (chucVu.equals("Sinh viên")) {
			BGChucVu.setSelected(JRSinhVien.getModel(), true);
		}
		/***************************************************************/

		if (!selectionModel.isSelectionEmpty()) { // select row
			setEnableForEdit();
			setDisableForAdd();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.println("you pressed ");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		System.out.println("you released ");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("you entered ");
	}

	@Override
	public void mouseExited(MouseEvent e) {
//		System.out.println("you exited ");

	}

	/************************************************************************/
	public static void main(String[] args) {
		new QuanLiThuVien();
	}

}