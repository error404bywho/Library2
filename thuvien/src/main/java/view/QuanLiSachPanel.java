package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Override.CustomTableModel;
import ViewLogin.QuanLiThuVien;
import action.ActionForSach;
import dao.phieumuontrasachDAO;
import dao.sachDAO;
import model.MaSachChung;
import model.Sach;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

public class QuanLiSachPanel extends JPanel implements MouseListener {

	private JLabel JLSach;
	private JLabel JLMaSachChung;
	private JLabel JLMaSach;
	private JLabel JLTenSach;
	private JLabel JLTheLoai;
	private JLabel JLTacGia;
	private JLabel JLTrangThai;
	
	private JLabel JLSoLuongSach;
	
	private JLabel lblNewLabel;
	
	private JTextField JTMaSachChung;
	private JTextField JTMaSach;
	private JTextField JTTenSach;
	private JTextField JTTacGia;
	private JTextField JTTimKiem;

	private JButton JBThem;
	private JButton JBNhapLai;
	private JButton JBTimKiem;
	private JButton JBLuu;
	private JButton JBXoa;
	private JButton JBReset;
	
	private JComboBox<String> JCTheLoai;
	private JComboBox<String> JCTrangThai;
	private JComboBox<String> JCSapXep;

	private Font fontTitle;
	private Font font;

	private JTable JTbSach ;
	private DefaultTableModel model;
	private ActionListener ac;

	private int xQLS ;
	private int yQLS ;

	private sachDAO sdao;
	
	private String S;
	private String MaSach;
	private JTextArea ContentBook;
	private JLabel lblNiDung;
	private JTextField path;
	
	private String filename = null;
	byte[] photo = null;
	
	
	public QuanLiSachPanel() {
		
		setLayout(null);
		
		sdao = new sachDAO();
		
		sdao.SelectAll();
		
		ac = new ActionForSach(this);
		
		ShowSachTable();
		
		init();
		setDisableForEdit();
		setEnableForAdd();
		
		this.addMouseListener(new MouseAdapter() { // MOUSE EVENT CHO JTABLE
			@Override
			public void mouseClicked(MouseEvent e) {
				// Xử lý sự kiện khi chuột được nhấn
				JTbSach.clearSelection(); // Bỏ chọn mọi hàng khi nhấn ở ngoài table
				setDisableForEdit();
				setEnableForAdd();
				// ClearInfo();
			}
		});
		
	}

	public void init() {
		
		fontTitle = new Font("consolas",Font.BOLD,20);
		font = new Font("consolas", Font.BOLD, 13);
		
		xQLS = 10;
		yQLS = 60;
		
		JLSach = new JLabel("SÁCH");		// LABEL
		JLSach.setBounds(200,5,200,50);
		JLSach.setFont(fontTitle);
		add(JLSach);
		JLMaSachChung = new JLabel("Mã sách chung        :"); 
		JLMaSachChung.setBounds(xQLS,yQLS,200,50);
		JLMaSachChung.setFont(font);
		add(JLMaSachChung);

		JLMaSach = new JLabel("Mã sách        		      :");
		JLMaSach.setBounds(xQLS,yQLS+ 40, yQLS + 140, 50);
		JLMaSach.setFont(font);
		add(JLMaSach);

		JLTenSach = new JLabel("Tên sách       	      :");
		JLTenSach.setBounds(xQLS,yQLS + 80, yQLS + 140, 50);
		JLTenSach.setFont(font);
		add(JLTenSach);
		
		JLTacGia = new JLabel("Tác giả              :");
		JLTacGia.setBounds(xQLS,yQLS + 120, yQLS+ 140, 50);
		JLTacGia.setFont(font);
		add(JLTacGia);
		
		JLTheLoai = new JLabel("Thể Loại   \t          :");
		JLTheLoai.setBounds(10, 221, 200, 50);
		JLTheLoai.setFont(font);
		add(JLTheLoai);
		
		JLSoLuongSach = new JLabel("Số lượng sách : " + sdao.SelectAll().size());
		JLSoLuongSach.setBounds(xQLS + 320, yQLS+ 250, 200, 50);
		JLSoLuongSach.setFont(font);
		JLSoLuongSach.setForeground(Color.gray);
		add(JLSoLuongSach);
		

		
		JLTrangThai = new JLabel("Trạng Thái :");
		JLTrangThai.setBounds(1121, 256,100,30);
		JLTrangThai.setFont(font);
		add(JLTrangThai);

		JTMaSachChung = new JTextField(); // TEXT FIELD
		JTMaSachChung.setBounds(xQLS + 190, yQLS + 10, 170 , 25);
		JTMaSachChung.setFont(font);
		add(JTMaSachChung);

		JTMaSach = new JTextField();
		JTMaSach.setBounds(xQLS + 190, yQLS + 10 + 40, 170, 25);
		JTMaSach.setFont(font);
		add(JTMaSach);

		JTTenSach = new JTextField();
		JTTenSach.setBounds(xQLS + 190,yQLS + 10 + 80, 170, 25);
		JTTenSach.setFont(font);
		add(JTTenSach);

		JTTacGia = new JTextField();
		JTTacGia.setBounds(xQLS + 190, yQLS + 10 + 120, 170, 25);
		JTTacGia.setFont(font);
		add(JTTacGia);

//		JTTrangThai = new JTextField();
//		JTTrangThai.setBounds(550,60,120,25);
//		JTTrangThai.setFont(font);
//		add(JTTrangThai);

		JTTimKiem = new JTextField();
		JTTimKiem.setBounds(768, 297, 582, 30);
		JTTimKiem.setFont(font);
		add(JTTimKiem);

		JBThem = new JButton("Thêm"); 			// BUTTON
		JBThem.setBounds(10,282,120,30);
		JBThem.setFont(font);
		JBThem.addActionListener(ac);
		add(JBThem);

		JBNhapLai = new JButton("Clear");
		JBNhapLai.setBounds(160, 282, 120, 30);
		JBNhapLai.setFont(font);
		JBNhapLai.addActionListener(ac);
		add(JBNhapLai); 

		 JBLuu = new JButton("Lưu");
		 JBLuu.setBounds(1350,160, 120, 30);
		 JBLuu.setFont(font);
		 JBLuu.addActionListener(ac);
		 add(JBLuu);
		 
			
		 JBXoa = new JButton("Xóa");
		 JBXoa.setBounds(1350,200 , 120, 30);
		 JBXoa.setFont(font);
		 JBXoa.addActionListener(ac);
		 add(JBXoa);

		 JBTimKiem = new JButton("Tìm kiếm");
		 JBTimKiem.setBounds(1360, 297, 100, 30);
		 JBTimKiem.setFont(font);
		 JBTimKiem.addActionListener(ac);
		 add(JBTimKiem);
		 
		 JBReset = new JButton("Reset");
		 JBReset.setBounds(310,282 , 100, 30);
		 JBReset.setFont(font);
		 JBReset.addActionListener(ac);
		 add(JBReset);
		
		String[] TrangThai = { "Tất cả", "Còn", "Đã Mượn" };
		JCTrangThai = new JComboBox<String>(TrangThai);
		JCTrangThai.setBounds(1221,256,100,30);
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

		String[] TheLoai = { "Thiếu nhi", "Giáo dục", "Tiểu thuyết","Trinh thám","Light novel","Học thuật","Văn Học nước ngoài","Văn Học Việt Nam" };
		JCTheLoai = new JComboBox<String>(TheLoai);
		JCTheLoai.setBounds(200, 231, 170, 30);
		JCTheLoai.setFont(font);
		add(JCTheLoai);

		String[] SapXep = { "Sắp xếp (A -> Z) ", "Mã sách", "Tên sách","Tác giả","Thể loại" };
		JCSapXep = new JComboBox<String>(SapXep);
		JCSapXep.setBounds(871, 256, 200, 30);
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
		
		lblNewLabel = new JLabel("Add Picture +");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(476, 11, 227, 260);
		lblNewLabel.setBorder(new CompoundBorder( // sets two borders
				BorderFactory.createMatteBorder(1,1,1,1, Color.WHITE), // outer border
				BorderFactory.createEmptyBorder(1, 1, 1, 1))); // inner invisible border as the margin
		lblNewLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				lblNewLabel.setIcon(new ImageIcon(file.toString()));
				filename = file.getAbsolutePath();
				path.setText(filename);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBorder(new CompoundBorder( // sets two borders
						BorderFactory.createMatteBorder(1,1,1,1, Color.WHITE), // outer border
						BorderFactory.createEmptyBorder(1,1,1,1))); // inner invisible border as the margin
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBorder(new CompoundBorder( // sets two borders
						BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK), // outer border
						BorderFactory.createEmptyBorder(1,1,1,1))); // inner invisible border as the margin
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		add(lblNewLabel);
		
		ContentBook = new JTextArea();
		ContentBook.setBounds(768, 85, 572, 160);
		add(ContentBook);
		ContentBook.setColumns(10);
		//2 thuoc tinh nay giup cho content fill day textArea
		ContentBook.setWrapStyleWord(true);
		ContentBook.setLineWrap(true);
		lblNiDung = new JLabel("Nội dung   :");
		lblNiDung.setFont(new Font("Consolas", Font.BOLD, 13));
		lblNiDung.setBounds(768, 32, 200, 50);
		add(lblNiDung);
		
		path = new JTextField();
		path.setEditable(false);
		path.setBounds(476, 279, 227, 25);
		add(path);
		path.setColumns(10);


	}

	public void ShowSachTable() {

		try {
			model = new CustomTableModel();
			
			String[] Column = { "Mã sách chung", "Mã sách", "Tên sách", "Thể loại", "Tác Giả", "Nội Dung" };
			for (int i = 0; i < Column.length; i++) {
				model.addColumn(Column[i]);
			}
			ShowData();

			JTbSach = new JTable(model);

			JScrollPane scrollPane = new JScrollPane(JTbSach);
			scrollPane.setBounds(0, 350, 1500, 440);
			scrollPane.createVerticalScrollBar();
			add(scrollPane);
			//JTbSach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			JTbSach.addMouseListener(this);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void ShowData() {
		model.setRowCount(0); 
		for (Sach sach : sdao.SelectAll()) {
			Object[] RowData = new Object[] { 
					sach.getMaSachChung(), sach.getMaSach(), sach.getTenSach(), 
					sach.getTheLoai()    ,sach.getTacGia() , sach.getTrangThai() 
					
			};
			model.addRow(RowData);
		}
		
	}
	public void Them() {

		try {
			if(JTMaSachChung.getText().equals("") || JTMaSach.getText().equals("") || JTTenSach.getText().equals("") || JTTacGia.getText().equals("") || path.getText().equals("") ) {
				 JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
			 }
			else {
			String MaSachChung = JTMaSachChung.getText();
			String MaSach = JTMaSach.getText();
			String TenSach = JTTenSach.getText();
			String TheLoai = JCTheLoai.getSelectedItem().toString();
			String TacGia = JTTacGia.getText();
			String NoiDung = ContentBook.getText();
			byte[] Anh = new byte[1024];
			Anh = Files.readAllBytes(Paths.get(path.getText()));
			Sach sach = new Sach(MaSachChung, MaSach, TenSach, TheLoai, TacGia, NoiDung,Anh);
			
			sdao.Them(sach);
			ShowData();//reset data
			}
			JLSoLuongSach.setText("Số lượng sách : " + sdao.SelectAll().size() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void Luu() {
		
		try {
			if(JTMaSachChung.getText().equals("") || JTMaSach.getText().equals("") || JTTenSach.getText().equals("") || JTTacGia.getText().equals("")  ) {
				 JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
			 }
			else {
			String MaSachChung = JTMaSachChung.getText();
			String MaSach = JTMaSach.getText();
			 String TenSach = JTTenSach.getText();
			 String TacGia  = JTTacGia.getText(); 
			 String TheLoai = JCTheLoai.getSelectedItem().toString();
			 String TrangThai = ContentBook.getText();
			 byte[] Anh = new byte[1024];
			 Sach sach = new Sach(MaSachChung, MaSach, TenSach, TheLoai, TacGia, TrangThai,Anh);
			 sdao.Luu(sach,S);
			 ShowData();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Xoa() {
		String MaSach = JTMaSach.getText();
		
		int response = JOptionPane.showConfirmDialog(null, "Bạn chắc muốn xóa sách ?", "Xóa sách ", JOptionPane.YES_NO_OPTION);
		 
        if (response == JOptionPane.YES_OPTION) {
        	sdao.Xoa(MaSach);
    		ShowData();
    		JLSoLuongSach.setText("Số lượng mã sách: " + sdao.SelectAll().size() );
        } else if (response == JOptionPane.NO_OPTION) {
            System.out.println("Người dùng chọn Không");
           
        } else {
            System.out.println("Người dùng đóng hộp thoại hoặc chọn Cancel");
        }
        
		

	}
	public void SapXep(String SortCondition,String State) {
		sdao = new sachDAO(SortCondition, State);
		ShowData();
	}
	public void TimKiem() {
		String Input = JTTimKiem.getText();
			model.setRowCount(0);
			for (Sach sach : sdao.SelectResult(Input)) {
				Object[] RowData = new Object[] { 
						sach.getMaSachChung(), sach.getMaSach(), sach.getTenSach(), 
						sach.getTheLoai()    ,sach.getTacGia() , sach.getTrangThai() 
						
				};
				model.addRow(RowData);
			}
			
	}
	public void Reset() {
		JOptionPane.showMessageDialog(null, "                        Đã tải lại bảng !", "Reset", JOptionPane.DEFAULT_OPTION);
		JTTimKiem.setText("");
		JCTrangThai.setSelectedIndex(0);
		JCSapXep.setSelectedIndex(0);
		ShowData();
	}
	public static void main(String[] args) {
		new QuanLiThuVien();
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
		JTMaSach.setText("");
		JTTenSach.setText("");
		JTTacGia.setText("");
		JCTheLoai.setSelectedIndex(0);
		System.out.println("you cleared i4");
	}

	/************************************************************************/ // MOUSE EVENT
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ClearInfo();
		
		Point point = e.getPoint();					//	1 "con tro"  mang toa do x y 
//		int x = point.getX();						//point.getX() se chi ra toa do
		int row = JTbSach.rowAtPoint(point);		// 		rowAtPoint se in ra hang tai point chi? toi. 	
													// ===> rowAtPoint(point) se chi ra row tai point do
		System.out.println("you clicked at row " + row);
		MaSach = JTMaSach.getText();
//		int row = JTbSach.rowAtPoint(point);
		ListSelectionModel selectionModel = JTbSach.getSelectionModel();

		/***************************************************************/ // lay ra du lieu cua cac row
		S = (String) JTbSach.getValueAt(row, 1);
		JTMaSachChung.setText((String) JTbSach.getValueAt(row, 0));
		JTMaSach.setText((String) JTbSach.getValueAt(row, 1));
		JTTenSach.setText((String) JTbSach.getValueAt(row, 2));
		JCTheLoai.setSelectedItem((String) JTbSach.getValueAt(row, 3));
		JTTacGia.setText((String) JTbSach.getValueAt(row, 4));
		
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
