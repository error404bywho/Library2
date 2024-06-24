package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Point;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

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

import com.google.protobuf.TextFormat.ParseException;

import Override.CustomTableModel;
import ViewLogin.QuanLiThuVien;
import action.ActionForMaSachChung;
import action.ActionForPhieuMuonTraSach;
import dao.masachchungDAO;
import dao.phieumuontrasachDAO;
import model.BanDoc;
import model.MaSachChung;
import model.PhieuMuonTraSach;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class QuanLiPhieuMuonTraSachPanel extends JPanel implements MouseListener{
	
	
	private JLabel JLPhieuMuonSach;
	
	private JLabel JLMaPhieuMuon;
	private JLabel JLMaNguoiMuon;
	private JLabel JLMaSach;
	private JLabel JLSoLuong;
	private JLabel JLNgayMuon;
	private JLabel JLHanTra;
	private JLabel JLTrangThai;
	private JLabel JLSoMaPhieuMuon;
	
	private JLabel JLFormat;

	
	private JTextField JTMaPhieuMuon;
	private JTextField JTMaNguoiMuon;
	private JTextField JTMaSach;
	private JTextField JTNgayMuon;
	private JTextField JTHanTra;
	private JTextField JTTimKiem;
	
	private JButton	JBThem;
	private JButton	JBNhapLai;
	private JButton	JBTimKiem;
	private JButton JBReset;
	private JButton JBLuu;
	private JButton JBXoa;

	private JButton JBTraSach;
	
	private JComboBox<String> JCSapXep;
	private JComboBox<Integer>JCSoLuong; 
	private JComboBox<String>JCTrangThai;
	
	private Font fontTitle;
	private Font font;
	
	private JTable JTbPhieuMuonTraSach;
	private DefaultTableModel model;
	
	private int xPMTS;
	private int yPMTS;
	
	phieumuontrasachDAO pmtsdao;
	
	private ActionListener ac;

	private String MPM;
	public QuanLiPhieuMuonTraSachPanel() {
		
		setLayout(null);
		
		pmtsdao = new phieumuontrasachDAO();

		pmtsdao.SelectAll();
		
		ac = new ActionForPhieuMuonTraSach(this);
		
		ShowPhieuMuonSachTable();
		
		init();
		setDisableForEdit();
		setEnableForAdd();
		
		this.addMouseListener(new MouseAdapter() { // MOUSE EVENT CHO JTABLE
			@Override
			public void mouseClicked(MouseEvent e) {
				// Xử lý sự kiện khi chuột được nhấn
				JTbPhieuMuonTraSach.clearSelection(); // Bỏ chọn mọi hàng khi nhấn ở ngoài table
				setDisableForEdit();
				setEnableForAdd();
				JBTraSach.setVisible(false);
				// ClearInfo();
			}
		});
		
	}
	public void init() {
		
		xPMTS = 10;
		yPMTS = 60;
		
		setLayout(null);
		fontTitle = new Font("consolas",Font.BOLD,20);
		font = new Font("consolas",Font.BOLD,13);
		
		JLPhieuMuonSach = new JLabel("PHIẾU MƯỢN SÁCH");		
		JLPhieuMuonSach.setBounds(200,5,200,50);
		JLPhieuMuonSach.setFont(fontTitle);
		add(JLPhieuMuonSach);
		
		JLMaPhieuMuon = new JLabel("Mã phiếu mượn      :");		// LABEL
		JLMaPhieuMuon.setBounds(xPMTS,yPMTS,200,50);
		JLMaPhieuMuon.setFont(font);
		add(JLMaPhieuMuon);
		
		JLMaNguoiMuon = new JLabel("Mã người mượn      :");
		JLMaNguoiMuon.setBounds(xPMTS,yPMTS + 40,200,50);
		JLMaNguoiMuon.setFont(font);
		add(JLMaNguoiMuon);
		
		JLMaSach = new JLabel("Mã sách            :");
		JLMaSach.setBounds(xPMTS,yPMTS + 80,200,50);
		JLMaSach.setFont(font);
		add(JLMaSach);

		JLSoLuong = new JLabel("Số Lượng           :");
		JLSoLuong.setBounds(xPMTS,yPMTS + 120,200,50);
		JLSoLuong.setFont(font);
		add(JLSoLuong);
		
		JLNgayMuon = new JLabel("Ngày mượn     :");
		JLNgayMuon.setBounds(xPMTS + 390,yPMTS,200,50);
		JLNgayMuon.setFont(font);
		add(JLNgayMuon);
		
		JLHanTra = new JLabel("Hạn trả    	   :");
		JLHanTra.setBounds(xPMTS + 390,yPMTS+ 40,200,50);
		JLHanTra.setFont(font);
		add(JLHanTra);
		
		JLTrangThai = new JLabel("Tình trạng :");
		JLTrangThai.setBounds(xPMTS + 1040,yPMTS+ 140,100,30);
		JLTrangThai.setFont(font);
		add(JLTrangThai);
		
		JLSoMaPhieuMuon = new JLabel("Số lượng phiếu mượn : " + pmtsdao.SelectAll().size());
		JLSoMaPhieuMuon.setBounds(xPMTS + 320, yPMTS + 200, 200, 50);
		JLSoMaPhieuMuon.setForeground(Color.gray);
		JLSoMaPhieuMuon.setFont(font);
		add(JLSoMaPhieuMuon);
		
		JTMaPhieuMuon = new JTextField();						// TEXT FIELD
		JTMaPhieuMuon.setBounds(xPMTS + 190,yPMTS+ 10,120,25);
		JTMaPhieuMuon.setFont(font);
		add(JTMaPhieuMuon);
		
		
		JTMaNguoiMuon = new JTextField();
		JTMaNguoiMuon.setBounds(xPMTS + 190,yPMTS+ 50,120,25);
		JTMaNguoiMuon.setFont(font);
		add(JTMaNguoiMuon);
		
		JTMaSach = new JTextField();
		JTMaSach.setBounds(xPMTS + 190,yPMTS+90,120,25);
		JTMaSach.setFont(font);
		add(JTMaSach);
		
		JTNgayMuon = new JTextField();
		JTNgayMuon.setBounds(xPMTS + 540,yPMTS + 10,120,25);
		JTNgayMuon.setFont(font);
		add(JTNgayMuon);
		
		JLFormat = new JLabel("YYYY-MM-dd");
		JLFormat.setBounds(xPMTS + 680, yPMTS + 13, 200, 25);
		JLFormat.setForeground(Color.gray);
		JLFormat.setFont(font);
		add(JLFormat);
		
		JTHanTra = new JTextField();
		JTHanTra.setBounds(xPMTS + 540,yPMTS + 50,120,25);
		JTHanTra.setFont(font);
		add(JTHanTra);
		
		JLFormat = new JLabel("YYYY-MM-dd");
		JLFormat.setBounds(xPMTS + 680, yPMTS + 53, 200, 25);
		JLFormat.setForeground(Color.gray);
		JLFormat.setFont(font);
		add(JLFormat);
		
		JTTimKiem = new JTextField();
		JTTimKiem.setBounds(xPMTS + 790,yPMTS+ 190,550,30);
		JTTimKiem.setFont(font);
		add(JTTimKiem);
		
		
		 JBThem = new JButton("Thêm");						//BUTTON
		 JBThem.setBounds(xPMTS,yPMTS + 190,120,30);
		 JBThem.setFont(font);
		 JBThem.addActionListener(ac);
		 add(JBThem);

		 
		 JBNhapLai = new JButton("Clear");
		 JBNhapLai.setBounds(xPMTS + 150,yPMTS+ 190,120,30);
		 JBNhapLai.setFont(font);
		 JBNhapLai.addActionListener(ac);
		 add(JBNhapLai);
		 
		 JBLuu = new JButton("Lưu");
		 JBLuu.setBounds(xPMTS + 790,yPMTS + 40, 120, 30);
		 JBLuu.setFont(font);
		 JBLuu.setVisible(false);
		 JBLuu.addActionListener(ac);
		 add(JBLuu);
		 
		JBTraSach = new JButton("Trả sách");
		JBTraSach.setBounds(xPMTS + 790,yPMTS + 40, 120, 30);		//old locate: xPMTS + 960,yPMTS + 40, 120, 30
		JBTraSach.setFont(font);
		JBTraSach.setVisible(false);
		JBTraSach.addActionListener(ac);
			add(JBTraSach);
			 
		 JBTimKiem = new JButton("Tìm kiếm");
		 JBTimKiem.setBounds(xPMTS + 1350,yPMTS + 190,100,30);
		 JBTimKiem.setFont(font);
		 JBTimKiem.addActionListener(ac);
		 add(JBTimKiem);
		 
			
		 JBXoa = new JButton("Xóa");
		 JBXoa.setBounds(xPMTS + 790,yPMTS + 80 , 120, 30);
		 JBXoa.setFont(font);
		 JBXoa.addActionListener(ac);
		 add(JBXoa);
		 
		 JBReset = new JButton("Reset");
		 JBReset.setBounds(xPMTS + 550,yPMTS + 190 , 100, 30);
		 JBReset.setFont(font);
		 JBReset.addActionListener(ac);
		 add(JBReset);
		
		 String[] SapXep = {"Sắp xếp (A -> Z)","Mã phiếu mượn","Ngày mượn","Hạn trả"};		//Combobox
		 JCSapXep = new JComboBox<String>(SapXep);
		 JCSapXep.setBounds(xPMTS + 790,yPMTS + 140,200,30);
		 JCSapXep.setFont(font);
		 JCSapXep.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String SortCondition = (String) JCSapXep.getSelectedItem();
					String State = (String) JCTrangThai.getSelectedItem();
					SapXep(SortCondition,State);
	}
		
			});
		 add(JCSapXep);

		 
		 Integer[] SoLuong = new Integer[3];
		 for(int i=0;i<=2;i++) {
			 SoLuong[i] = i + 1 ;
		 }
		 JCSoLuong = new JComboBox<Integer>(SoLuong);
		 JCSoLuong.setBounds(xPMTS + 190,yPMTS+ 130,60,25);
		 JCSoLuong.setFont(font);
		 add(JCSoLuong);
		 
		 
		 String[] TrangThai = {"Tất cả","Còn hạn" ,"Đã trả","Chưa trả"};
		 JCTrangThai = new JComboBox<String>(TrangThai);
		 JCTrangThai.setBounds(xPMTS+ 1140,yPMTS+ 140,100,30);
		 JCTrangThai.setFont(font);
		 JCTrangThai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String SortCondition = (String) JCSapXep.getSelectedItem();
				String State = (String) JCTrangThai.getSelectedItem();
;				SapXep(SortCondition, State);
			}
		});
		 add(JCTrangThai);

			
	}

	public void ShowPhieuMuonSachTable() {
		
		try {
			model = new CustomTableModel();
			
			String[] Column = {"Mã Phiếu mượn", "Mã người mượn","Mã sách" ,"Số lượng",
							   "Ngày mượn"    ,"Hạn trả"       ,"Ngày trả","Tình trạng"};
			for(int i=0;i<Column.length;i++) {
				model.addColumn(Column[i]);
			}
			
			ShowData();
			JTbPhieuMuonTraSach = new JTable(model);
			
			JScrollPane scrollpane = new JScrollPane(JTbPhieuMuonTraSach);
			scrollpane.setBounds(0, 320, 1500, 440);
			 scrollpane.createVerticalScrollBar();
			 add(scrollpane);
			 
			 JTbPhieuMuonTraSach.addMouseListener(this);
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void ShowData() {
		model.setRowCount(0);
		for(PhieuMuonTraSach pmts : pmtsdao.SelectAll()) {
			Object[] RowData = new Object[] {
			pmts.getMaPhieuMuon(),pmts.getMaBanDoc(),pmts.getMaSach(),pmts.getSoLuong(),
			pmts.getNgayMuon(),pmts.getHanTra(),pmts.getNgayTra(),pmts.getTinhTrang()
			};
			model.addRow(RowData);
		}
	}	

	public void Them() {

			try {
				if(JTMaPhieuMuon.getText().equals("") || JTMaNguoiMuon.getText().equals("") || JTMaSach.getText().equals("") || JTNgayMuon.getText().equals("") || JTHanTra.getText().equals("") ) {
					 JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String dateNgayMuonString = JTNgayMuon.getText();
					String dateHanTraString   = JTHanTra.getText();
					
					String 			MaPhieuMuon = JTMaPhieuMuon.getText();
					String 			MaNguoiMuon = JTMaNguoiMuon.getText();
					String 			MaSach = JTMaSach.getText();
					int 			SoLuong =  (int) JCSoLuong.getSelectedItem();
					
					
					java.sql.Date   NgayMuon = java.sql.Date.valueOf(dateNgayMuonString);
					java.sql.Date	HanTra   = java.sql.Date.valueOf(dateHanTraString);
					
						PhieuMuonTraSach pmts = new PhieuMuonTraSach(MaPhieuMuon,MaNguoiMuon, MaSach, SoLuong, NgayMuon, HanTra);
						pmtsdao.Them(pmts);
						ShowData();
						JLSoMaPhieuMuon.setText("Số lượng phiếu mượn: " + pmtsdao.SelectAll().size());

							System.out.println(pmts.toString());
							System.out.println("Them phieu thanh cong !");
					
					
				}
				
			} catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng \n"
	            		+ "Format: YYYY-MM-dd", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);

				e.printStackTrace();
			}

	}
		public void Luu()  {
			
	     
		 //String NgayTraString   = JTHanTra.getText();
		    // Chuyển đổi định dạng từ "dd/MM/yyyy" sang "yyyy-MM-dd"
		    try {
		    	if(JTMaPhieuMuon.getText().equals("") || JTMaNguoiMuon.getText().equals("") || JTMaSach.getText().equals("") || JTNgayMuon.getText().equals("") || JTHanTra.getText().equals("") ) {
					 JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
				 }
				else {
					
					String MaPhieuMuon = JTMaPhieuMuon.getText();
					 String MaNguoiMuon = JTMaNguoiMuon.getText();
					 String MaSach  = JTMaSach.getText();
					 int 	SoLuong =  (int) JCSoLuong.getSelectedItem();
					 String NgayMuonString  = JTNgayMuon.getText(); 
					 String HanTraToString  = JTHanTra.getText();
					 java.sql.Date NgayMuon;
					 java.sql.Date HanTra;
					 System.out.println(NgayMuonString + "     " + HanTraToString);
					 
					 SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
					 SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date NgayMuonDate = inputFormat.parse(NgayMuonString);
					String formattedDateStr1 = outputFormat.format(NgayMuonDate);
					
					java.util.Date HanTraDate = inputFormat.parse(HanTraToString);
					String formattedDateStr2 = outputFormat.format(HanTraDate);

					// Tạo đối tượng java.sql.Date từ chuỗi đã định dạng
					 NgayMuon = java.sql.Date.valueOf(formattedDateStr1);
					 HanTra  = java.sql.Date.valueOf(formattedDateStr2);
	   
					System.out.println("Đối tượng java.sql.Date đầu ra NGAYMUON: " + NgayMuon);
					System.out.println("Đối tượng java.sql.Date đầu ra HANTRA: "   + HanTra);
					System.out.println("ra o day");
					PhieuMuonTraSach pmts = new PhieuMuonTraSach(MaPhieuMuon, MaNguoiMuon, MaSach, SoLuong, NgayMuon, HanTra);
	 				System.out.println(pmts.toString());
	 				pmtsdao.Luu(pmts,MPM);
	 				JBTraSach.setVisible(false);
	 				ShowData();
				}
		    	
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//		 java.sql.Date  NgayMuon = java.sql.Date.valueOf(NgayMuonString);
//		 java.sql.Date	HanTra   = java.sql.Date.valueOf(HanTraToString);
		 
	}
	public void Xoa() {
		String PhieuMuonTraSach = JTMaPhieuMuon.getText();
		
		int response = JOptionPane.showConfirmDialog(null, "Bạn chắc muốn phiếu mượn?", "Xóa phiếu mượn ", JOptionPane.YES_NO_OPTION);
		 
        if (response == JOptionPane.YES_OPTION) {
        	pmtsdao.Xoa(PhieuMuonTraSach);	
    		ShowData();
    		JLSoMaPhieuMuon.setText("Số lượng phiếu mượn: " + pmtsdao.SelectAll().size() + "");
        } else if (response == JOptionPane.NO_OPTION) {
            System.out.println("Người dùng chọn Không");
           
        } else {
            System.out.println("Người dùng đóng hộp thoại hoặc chọn Cancel");
        }
        
		

	}
	public void SapXep(String SortCondition,String State) {
		pmtsdao = new phieumuontrasachDAO(SortCondition, State);
		ShowData();
	}
	public void TimKiem() {
		String Input = JTTimKiem.getText();
			model.setRowCount(0);
			for(PhieuMuonTraSach pmts : pmtsdao.SelectResult(Input)) {
				Object[] RowData = new Object[] {
				pmts.getMaPhieuMuon(),pmts.getMaBanDoc(),pmts.getMaSach(),pmts.getSoLuong(),
				pmts.getNgayMuon(),pmts.getHanTra(),pmts.getNgayTra(),pmts.getTinhTrang()
				};
				JLSoMaPhieuMuon.setText("Số lượng phiếu mượn: " + pmtsdao.SelectResult(Input).size());
				model.addRow(RowData);
			}
	}
	public void TraSach() {
		
		 //String NgayTraString   = JTHanTra.getText();
		    // Chuyển đổi định dạng từ "dd/MM/yyyy" sang "yyyy-MM-dd"
		    try {
		    	JBTraSach.setVisible(false);
				
				MPM = JTMaPhieuMuon.getText();
			String MaPhieuMuon = JTMaPhieuMuon.getText();
			 String MaNguoiMuon = JTMaNguoiMuon.getText();
			 String MaSach  = JTMaSach.getText();
			 int 	SoLuong =  (int) JCSoLuong.getSelectedItem();
			 String NgayMuonString  = JTNgayMuon.getText(); 
			 String HanTraString  = JTHanTra.getText();
			 java.sql.Date NgayTra = new java.sql.Date(System.currentTimeMillis());	//Lấy ra thời gian hiện tại
			 
//			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
//			   LocalDateTime NgayTra = LocalDateTime.now();  
//			   Date   NgayTra =dtf.format(NgayTra);  
			 String TinhTrang = "Đã trả";
			 java.sql.Date NgayMuon;
			 java.sql.Date HanTra;
		//	 java.sql.Date NgayTra = NgayTraString;
			 
			 System.out.println(NgayMuonString + "     " + HanTraString);
			/************* 
			 SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
			 SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
			 
			 
				java.util.Date NgayMuonDate = inputFormat.parse(NgayMuonString);
				String formattedDateStr1 = outputFormat.format(NgayMuonDate);
				
				java.util.Date HanTraDate = inputFormat.parse(HanTraToString);
				String formattedDateStr2 = outputFormat.format(HanTraDate);

				String formattedDateStr3 = outputFormat.format(NgayTraString);
				// Tạo đối tượng java.sql.Date từ chuỗi đã định dạng
				 NgayMuon = java.sql.Date.valueOf(formattedDateStr1);
				 HanTra  = java.sql.Date.valueOf(formattedDateStr2);
				 NgayTra = java.sql.Date.valueOf(formattedDateStr3);
			********/ 
			 NgayMuon = java.sql.Date.valueOf(NgayMuonString);
			 HanTra  = java.sql.Date.valueOf(HanTraString);
			// NgayTra = java.sql.Date.valueOf(formattedDateStr3);
				System.out.println("Đối tượng java.sql.Date đầu ra NGAYMUON: " + NgayMuon);
				System.out.println("Đối tượng java.sql.Date đầu ra HANTRA: "   + HanTra);
				//System.out.println("Đối tượng java.sql.Date đầu ra NGAYTRA: "   + NgayTra);
				System.out.println("ra o day");
 PhieuMuonTraSach pmts = new PhieuMuonTraSach(MaPhieuMuon, MaNguoiMuon, MaSach, SoLuong, NgayMuon, HanTra, NgayTra, TinhTrang);
 System.out.println(pmts.toString());
 pmtsdao.Luu(pmts,MPM);
 ShowData();
 //JOptionPane.showMessageDialog(null, "Cập nhật mã sách thành công", "Cập nhật thông tin", JOptionPane.PLAIN_MESSAGE);

			} 
		    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void Reset() {
		JTTimKiem.setText("");
		JCTrangThai.setSelectedIndex(0);
		JCSapXep.setSelectedIndex(0);
		ShowData();
		JBTraSach.setVisible(false);
		JOptionPane.showMessageDialog(null, "                        Đã tải lại bảng !", "Reset", JOptionPane.DEFAULT_OPTION);

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
		JTMaPhieuMuon.setText("");
		JTMaNguoiMuon.setText("");
		JTMaSach.setText("");
		JCSoLuong.setSelectedItem("1");
		JTNgayMuon.setText("");
		JTHanTra.setText("");
		System.out.println("you cleared i4");
	}
	/************************************************************************/

	public static void main(String[] args) {
		new QuanLiThuVien();
	}
	/************************************************************************/ //MOUSE EVENT
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		//ClearInfo();
		MPM = JTMaPhieuMuon.getText();
		Point point = e.getPoint();					//	1 "con tro"  mang toa do x y 
//		int x = point.getX();						//point.getX() se chi ra toa do
		int row = JTbPhieuMuonTraSach.rowAtPoint(point);		// 		rowAtPoint se in ra hang tai point chi? toi. 	
													// ===> rowAtPoint(point) se chi ra row tai point do
		System.out.println("you clicked at row " + row);
		System.out.println("u click column " + JTbPhieuMuonTraSach.columnAtPoint(point));
//		int row = JTbPhieuMuonTraSach.rowAtPoint(point);
		ListSelectionModel selectionModel = JTbPhieuMuonTraSach.getSelectionModel();

		JBTraSach.setVisible(true);
		/***************************************************************/ // lay ra du lieu cua cac row
//		MSC = (String) JTbPhieuMuonTraSach.getValueAt(row, 0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		
		
		Date DateNgayMuon = (Date) JTbPhieuMuonTraSach.getValueAt(row, 4);
		Date DateHanTra   = (Date) JTbPhieuMuonTraSach.getValueAt(row, 5);
		String NgayMuon   = dateFormat.format(DateNgayMuon);
		String HanTra     = dateFormat.format(DateHanTra);
		
		JTMaPhieuMuon.setText((String) JTbPhieuMuonTraSach.getValueAt(row, 0));
		JTMaNguoiMuon.setText((String) JTbPhieuMuonTraSach.getValueAt(row, 1));
		JTMaSach.setText((String) JTbPhieuMuonTraSach.getValueAt(row, 2) );
		JCSoLuong.setSelectedItem((Integer)JTbPhieuMuonTraSach.getValueAt(row, 3));
		JTNgayMuon.setText(NgayMuon);
		JTHanTra.setText(HanTra);
//		JTNgayMuon.setText((String) JTbPhieuMuonTraSach.getValueAt(row, 4));
//		JTHanTra.setText((String) JTbPhieuMuonTraSach.getValueAt(row, 5));
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

}
