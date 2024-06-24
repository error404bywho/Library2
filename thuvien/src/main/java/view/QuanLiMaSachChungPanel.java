package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Override.CustomTableModel;
import ViewLogin.QuanLiThuVien;
import action.ActionForMaSachChung;
import dao.masachchungDAO;
import model.MaSachChung;
import model.PhieuMuonTraSach;

public class QuanLiMaSachChungPanel extends JPanel implements MouseListener{
	
	private JLabel JLMaSachChungTT;
	
	private JLabel JLMaSachChung;
	private JLabel JLTenSach;
	private JLabel JLSoLuong;
	private JLabel JLTheLoai;
	private JLabel JLTacGia;
	private JLabel JLNhaXuatBan;
	private JLabel JLNamXuatBan;
	private JLabel JLSoMaSach;
	
	private JTextField JTMaSachChung;
	private JTextField JTTenSach;
	private JTextField JTSoLuong;
	private JTextField JTTacGia;
	private JTextField JTNhaXuatBan;
	private JTextField JTTimKiem;
	
	private JButton	JBThem;
	private JButton	JBNhapLai;
	private JButton	JBTimKiem;
	private JButton JBLuu;
	private JButton JBXoa;
	private JButton JBReset;
	
	JComboBox<String> JCTheLoai;
	JComboBox<String> JCNamXuatBan;
	JComboBox<String> JCSapXep;
	
	private JTable JTbMaSachChung;
	private DefaultTableModel model;
	
	private Font fontTitle;
	private Font font;
	
	private int xMSC;
	private int yMSC;
	private ActionListener ac;

	private masachchungDAO mscdao;
	
	private String MSC;
	public QuanLiMaSachChungPanel() {
		
		setLayout(null);
		
		mscdao = new masachchungDAO();
		
		mscdao.SelectAll();

		ac = new ActionForMaSachChung(this);
		
		ShowMaSachChungTable();
		
		init();
		setDisableForEdit();
		setEnableForAdd();
		
		this.addMouseListener(new MouseAdapter() { // MOUSE EVENT CHO JTABLE
			@Override
			public void mouseClicked(MouseEvent e) {
				// Xử lý sự kiện khi chuột được nhấn
				JTbMaSachChung.clearSelection(); // Bỏ chọn mọi hàng khi nhấn ở ngoài table
				setDisableForEdit();
				setEnableForAdd();
				// ClearInfo();
			}
		});
		
	}
	public void init() {
		
		setLayout(null);
		
		font = new Font("consolas",Font.BOLD,13);
		fontTitle = new Font("consolas",Font.BOLD,20);
		
		xMSC = 10;
		yMSC = 60;
		
		JLMaSachChungTT = new JLabel("MÃ SÁCH CHUNG");		
		JLMaSachChungTT.setBounds(200,5,200,50);
		JLMaSachChungTT.setFont(fontTitle);
		add(JLMaSachChungTT);
		
		JLMaSachChung = new JLabel("Mã sách chung   :");		// LABEL
		JLMaSachChung.setBounds(xMSC,yMSC,200,50);
		JLMaSachChung.setFont(font);
		add(JLMaSachChung);
		
		JLTenSach = new JLabel("Tên sách      		  :");
		JLTenSach.setBounds(xMSC,yMSC + 40,200,50);
		JLTenSach.setFont(font);
		add(JLTenSach);
		
		JLSoLuong = new JLabel("Số lượng     		   :");
		JLSoLuong.setBounds(xMSC,yMSC + 80,200,50);
		JLSoLuong.setFont(font);
		add(JLSoLuong);
		
		JLTheLoai = new JLabel("Thể Loại    	    :");
		JLTheLoai.setBounds(xMSC,yMSC + 120,200,50);
		JLTheLoai.setFont(font);
		add(JLTheLoai);
		
		JLTacGia = new JLabel("Tác giả         :");
		JLTacGia.setBounds(xMSC + 390,yMSC,200,50);
		JLTacGia.setFont(font);
		add(JLTacGia);
		
		JLNhaXuatBan = new JLabel("Nhà xuất bản		    :");
		JLNhaXuatBan.setBounds(xMSC + 390,yMSC + 40,200,50);
		JLNhaXuatBan.setFont(font);
		add(JLNhaXuatBan);
		
		JLNamXuatBan = new JLabel("Năm xuất bản    :");
		JLNamXuatBan.setBounds(xMSC + 390,yMSC + 80,200,50);
		JLNamXuatBan.setFont(font);
		add(JLNamXuatBan);
		
		JLSoMaSach = new JLabel("Số lượng mã sách: " + mscdao.SelectAll().size());
		JLSoMaSach.setBounds(xMSC + 320, yMSC + 250, 200, 50);
		JLSoMaSach.setFont(font);
		JLSoMaSach.setForeground(Color.gray);
		add(JLSoMaSach);
		
		JTMaSachChung = new JTextField();				// TEXT FIELD
		JTMaSachChung.setBounds(xMSC + 190,yMSC + 10,120,25);
		JTMaSachChung.setFont(font);
		add(JTMaSachChung);
		
		
		JTTenSach = new JTextField();
		JTTenSach.setBounds(xMSC + 190,yMSC + 50,120,25);
		JTTenSach.setFont(font);
		add(JTTenSach);
		
		JTSoLuong = new JTextField();
		JTSoLuong.setBounds(xMSC + 190,yMSC + 90,120,25);
		JTSoLuong.setFont(font);
		add(JTSoLuong);

		JTTacGia = new JTextField();
		JTTacGia.setBounds(xMSC + 540,yMSC + 10,120,25);
		JTTacGia.setFont(font);
		add(JTTacGia);
		
		JTNhaXuatBan = new JTextField();
		JTNhaXuatBan.setBounds(xMSC + 540,yMSC + 50,120,25);
		JTNhaXuatBan.setFont(font);
		add(JTNhaXuatBan);

		
		JTTimKiem = new JTextField();
		JTTimKiem.setBounds(xMSC + 790,yMSC + 190,550,30);
		JTTimKiem.setFont(font);
		add(JTTimKiem);
		
		 
		 JBThem = new JButton("Thêm");							//BUTTON
		 JBThem.setBounds(xMSC,yMSC + 190,120,30);
		 JBThem.setFont(font);
		 JBThem.addActionListener(ac);
		 add(JBThem);
		 
		 JBNhapLai = new JButton("Clear");
		 JBNhapLai.setBounds(xMSC + 150,yMSC + 190,120,30);
		 JBNhapLai.setFont(font);
		 JBNhapLai.addActionListener(ac);
		 add(JBNhapLai);


		 JBLuu = new JButton("Lưu");
		 JBLuu.setBounds(xMSC + 790,yMSC + 40, 120, 30);
		 JBLuu.setFont(font);
		 JBLuu.addActionListener(ac);
		 add(JBLuu);
		 
			
		 JBXoa = new JButton("Xóa");
		 JBXoa.setBounds(xMSC + 790,yMSC + 80 , 120, 30);
		 JBXoa.setFont(font);
		 JBXoa.addActionListener(ac);
		 add(JBXoa);
		 
		 JBTimKiem = new JButton("Tìm kiếm");
		 JBTimKiem.setBounds(xMSC + 1350,yMSC + 190,100,30);
		 JBTimKiem.setFont(font);
		 JBTimKiem.addActionListener(ac);
		 add(JBTimKiem);
		 

		 JBReset = new JButton("Reset");
		 JBReset.setBounds(xMSC + 550,yMSC + 190 , 100, 30);
		 JBReset.setFont(font);
		 JBReset.addActionListener(ac);
		 add(JBReset);

                          
		 String[] TheLoai = {"Thiếu nhi", "Giáo dục", "Tiểu thuyết"};		//ComboBox
		 JCTheLoai = new JComboBox<String>(TheLoai);
		 JCTheLoai.setBounds(xMSC + 190,yMSC + 130,120,25);
		 JCTheLoai.setFont(font);
		 add(JCTheLoai);
		 
		 String[] NamXuatBan = new String[2023-1980 + 1];		/*khoi tao cac NAM XUAT BAN */
		 int j = 2024;
		 for(int i=0;i<=2023-1980;i++) {
			 NamXuatBan[i] = j+ "" ;
			 j--;
		 }
		 JCNamXuatBan = new JComboBox<String>(NamXuatBan);
		 JCNamXuatBan.setBounds(xMSC + 540,yMSC + 90,120,25);
		 JCNamXuatBan.setFont(font);
		 add(JCNamXuatBan);
		 
		 String[] SapXep = {"Sắp xếp (A -> Z) ","Mã sách chung","Tên sách", "Thể loại","Năm xuất bản"};
		 JCSapXep = new JComboBox<String>(SapXep);
		 JCSapXep.setBounds(xMSC + 790,yMSC + 130,200,30);
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

	public void ShowMaSachChungTable() {
		try {
			model = new CustomTableModel();
			
			String[] Column = { "Mã sách chung" , "Tên Sách" , "Số lượng" , "Thể loại" , "Tác giả" , "Nhà xuất bản" , "Năm xuất bản" };
			for(int i=0;i<Column.length;i++) 
				model.addColumn(Column[i]);
			
		     ShowData();
		     
		     
			 JTbMaSachChung = new JTable(model);
			 
			 JScrollPane scrollpane = new JScrollPane(JTbMaSachChung);
			 scrollpane.setBounds(0, 350, 1500, 450);
			 scrollpane.createVerticalScrollBar();
			 add(scrollpane);
			 
			 JTbMaSachChung.addMouseListener(this); //mouse click
			 
		} catch (NumberFormatException e) {
				
			e.printStackTrace();
			
		}
	}
	public void ShowData() {
		model.setRowCount(0); 								// CLEAR DATA. /*WE CLEAR ROW AND ADD AGAIN, AVOID DUPLICATED ROW
		for(MaSachChung msc : mscdao.SelectAll()) {
			Object[] RowData = new Object[] {
				msc.getMaSachChung(),msc.getTenSach(),msc.getSoLuong(),
				msc.getTheLoai()	,msc.getTacGia() ,msc.getNhaXuatBan(),
				msc.getNamXuatBan()
				
			};
			model.addRow(RowData);
		}
	}
	public void Them() {
		try {
			if(JTMaSachChung.getText().equals("") || JTTenSach.getText().equals("") || JTSoLuong.getText().equals("") || JTTacGia.getText().equals("") || JTNhaXuatBan.getText().equals("") ) {
				 JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
			 }
			
			else {
				String MaSachChung = JTMaSachChung.getText();
				 String TenSach = JTTenSach.getText();
				 int    SoLuong = Integer.parseInt(JTSoLuong.getText()); 
				 String TheLoai = JCTheLoai.getSelectedItem().toString();
				 String TacGia  = JTTacGia.getText(); 
				 String NhaXuatBan = JTNhaXuatBan.getText();
				 String NamXuatBan = JCNamXuatBan.getSelectedItem().toString();
				 MaSachChung msc = new MaSachChung(MaSachChung, TenSach, SoLuong, TheLoai, TacGia, NhaXuatBan, NamXuatBan);
				 mscdao.Them(msc);
				 ShowData();
				 
				 JLSoMaSach.setText("Số lượng mã sách: " +mscdao.SelectAll().size() + "");
			}
				

//			 JOptionPane.showMessageDialog(null, "Thêm mã sách mới thành công !", "THÊM MÃ SÁCH CHUNG", JOptionPane.INFORMATION_MESSAGE);
		}  catch (NumberFormatException e) {
			 /***********/
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ ", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
			 /***********/
		}

			
		
	}
	public void Luu() {
		
		try {
			if(JTMaSachChung.getText().equals("") || JTTenSach.getText().equals("") || JTSoLuong.getText().equals("") || JTTacGia.getText().equals("") || JTNhaXuatBan.getText().equals("") ) {
				 JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
			 }
			
			else {
			String MaSachChung = JTMaSachChung.getText();
			 String TenSach = JTTenSach.getText();
			 int    SoLuong = Integer.parseInt(JTSoLuong.getText()); 
			 String TheLoai = JCTheLoai.getSelectedItem().toString();
			 String TacGia  = JTTacGia.getText(); 
			 String NhaXuatBan = JTNhaXuatBan.getText();
			 String NamXuatBan = JCNamXuatBan.getSelectedItem().toString();
			 
			 MaSachChung msc = new MaSachChung(MaSachChung, TenSach, SoLuong, TheLoai, TacGia, NhaXuatBan, NamXuatBan);
			 
	            mscdao.Luu(msc,MSC);	//luu object msc va 
   			 ShowData();
   			 JOptionPane.showMessageDialog(null, "Cập nhật người dùng thành công !","Lưu người dùng", JOptionPane.DEFAULT_OPTION);
			}
		} catch (NumberFormatException e) {
			/***********/
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ ", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
			 /***********/
		}
	}
	public void Xoa() {
		String MaSachChung = JTMaSachChung.getText();
		
		int response = JOptionPane.showConfirmDialog(null, "Bạn chắc muốn xóa người dùng ?", "Xóa Người Dùng ", JOptionPane.YES_NO_OPTION);
 
        if (response == JOptionPane.YES_OPTION) {
        	mscdao.Xoa(MaSachChung);
    		ShowData();
    		JLSoMaSach.setText("Số lượng mã sách: " + mscdao.SelectAll().size() + "");
        } else if (response == JOptionPane.NO_OPTION) {
            System.out.println("Người dùng chọn Không");
           
        } else {
            System.out.println("Người dùng đóng hộp thoại hoặc chọn Cancel");
        }
		

	}
	public void SapXep(String SortCondition) {
		mscdao = new masachchungDAO(SortCondition);
		ShowData();
	}
	public void TimKiem() {
		String Input = JTTimKiem.getText();
			model.setRowCount(0);
			for(MaSachChung msc : mscdao.SelectResult(Input)) {
				Object[] RowData = new Object[] {
					msc.getMaSachChung(),msc.getTenSach(),msc.getSoLuong(),
					msc.getTheLoai()	,msc.getTacGia() ,msc.getNhaXuatBan(),
					msc.getNamXuatBan()
					
				};
				model.addRow(RowData);
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
		JTMaSachChung.setText("");
		JTTenSach.setText("");
		JTSoLuong.setText("");
		JTTacGia.setText("");
		JTNhaXuatBan.setText("");
		JCTheLoai.setSelectedItem("Thiếu nhi");
		JCNamXuatBan.setSelectedItem("2024");
		System.out.println("you cleared i4");
	}
	/************************************************************************/ //MOUSE EVENT
	@Override
	public void mouseClicked(MouseEvent e) {
		ClearInfo();
		Point point = e.getPoint();					//	1 "con tro"  mang toa do x y 
//		int x = point.getX();						//point.getX() se chi ra toa do
		int row = JTbMaSachChung.rowAtPoint(point);		// 		rowAtPoint se in ra hang tai point chi? toi. 	
													// ===> rowAtPoint(point) se chi ra row tai point do
		System.out.println("you clicked at row " + row);
//		int row = JTbMaSachChung.rowAtPoint(point);
		ListSelectionModel selectionModel = JTbMaSachChung.getSelectionModel();

		/***************************************************************/ // lay ra du lieu cua cac row
		MSC = (String) JTbMaSachChung.getValueAt(row, 0);
		JTMaSachChung.setText((String) JTbMaSachChung.getValueAt(row, 0));
		JTTenSach.setText((String) JTbMaSachChung.getValueAt(row, 1));
		JTSoLuong.setText( JTbMaSachChung.getValueAt(row, 2) + "");
		JCTheLoai.setSelectedItem((String) JTbMaSachChung.getValueAt(row, 3));
		JTTacGia.setText((String) JTbMaSachChung.getValueAt(row, 4));
		JTNhaXuatBan.setText((String)JTbMaSachChung.getValueAt(row, 5));
		JCNamXuatBan.setSelectedItem((String) JTbMaSachChung.getValueAt(row, 6));
		/***************************************************************/
		if (!selectionModel.isSelectionEmpty()) { // select row
			setEnableForEdit();
			setDisableForAdd();
		}

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new QuanLiThuVien();
	}


}
