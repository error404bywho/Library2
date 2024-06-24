package view;

import model.BanDoc;
import model.PhieuMuonTraSach;
import model.Sach;

import custom.*;
import custom.MyTabbedPane;
import custom.RoundJTextField;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import connection.Connector;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import custom.CustomTableModel;

public class Home {

	private JFrame frame;

	private JLabel PictureContentLeft ;
	private JTextArea ContentLeft ;
	private JLabel BookTitleLeft ;
	private JLabel LabelAuthorLeft;
	private JButton JBtTraSach;

	private Connector connector = new Connector();
	private ArrayList<Sach> ss = new ArrayList<Sach>();
	private ArrayList<PhieuMuonTraSach> pmts = new ArrayList<PhieuMuonTraSach>();
	private BanDoc bd = new BanDoc();
	private JPanel jtp2 ;
	private JTable JTbPhieuMuonTraSach;
	private DefaultTableModel model;
	
	private JLabel fiveStarLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					//
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home(Connector connector,ArrayList<Sach> ss,BanDoc bd,ArrayList<PhieuMuonTraSach> pmts) {
		 this.connector = connector;
		this.ss = ss;
		this.bd = bd;
		this.pmts = pmts;
		initialize();
	}
	public Home(Connector connector,ArrayList<Sach> ss,BanDoc bd) {
		 this.connector = connector;
		this.ss = ss;
		this.bd = bd;
		initialize();
	}
	public Home(Connector connector) {
		 this.connector = connector;
		
		initialize();
	}
	public Home(ArrayList<Sach> ss) {
		this.ss = ss;
		initialize();
	}
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
///////////////////////// 5 STARS
// Tải ảnh từ resources
ImageIcon star = new ImageIcon(Home.class.getResource("/assets/5star.png"));
Image starImg = star.getImage();
// Thay đổi kích thước ảnh
Image scaledImage1 = starImg.getScaledInstance(100,30, Image.SCALE_SMOOTH);  // Adjust the width and height as needed
ImageIcon fiveStar = new ImageIcon(scaledImage1);

ImageIcon starb = new ImageIcon(Home.class.getResource("/assets/5starbluenew.png"));
Image starImgb = starb.getImage();
// Thay đổi kích thước ảnh
Image scaledImage1b = starImgb.getScaledInstance(150,40, Image.SCALE_SMOOTH);  // Adjust the width and height as needed
ImageIcon fiveStarb = new ImageIcon(scaledImage1b);
//////////////////////////////

//Tải ảnh từ resources
ImageIcon book = new ImageIcon(Home.class.getResource("/assets/icons8-book-24.png"));
Image book1 = book.getImage();
//Thay đổi kích thước ảnh
Image book2 = book1.getScaledInstance(20,20, Image.SCALE_SMOOTH);  // Adjust the width and height as needed
ImageIcon book3 = new ImageIcon(book2);
//////////////////////////////
ImageIcon home = new ImageIcon(Home.class.getResource("/assets/icons8-home-48.png"));
Image home1 = home.getImage();
//Thay đổi kích thước ảnh
Image home2 = home1.getScaledInstance(20,20, Image.SCALE_SMOOTH);  // Adjust the width and height as needed
ImageIcon home3 = new ImageIcon(home2);
//////////////////////////////
//Tải ảnh từ resources
ImageIcon user = new ImageIcon(Home.class.getResource("/assets/icons8-user-48.png"));
Image user1 = user.getImage();
//Thay đổi kích thước ảnh
Image user2 = user1.getScaledInstance(20,20, Image.SCALE_SMOOTH);  // Adjust the width and height as needed
ImageIcon user3 = new ImageIcon(user2);
//////////////////////////////


//		Sach sach = new Sach("asjn", "asjn", "asjn", "asjn", "asjn", null);
//		for(int i = 0;i<14;i++)
//			ss.add(sach);

		JTabbedPane tabbedPane = new JTabbedPane() ;
		TextBubbleBorder brdrLeft = new TextBubbleBorder(Color.GRAY,1,50,10);
		//TextBubbleBorder brdrRight = new TextBubbleBorder(Color.GRAY,2,16,16,false);
		
		frame = new JFrame();
		frame.setBackground(new Color(216, 216, 216));
		frame.getContentPane().setBackground(new Color(235, 238, 244));
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
 	
		 JPanel panel_2 = new JPanel();
		 panel_2.setBackground(new Color(0, 22, 67));
		 panel_2.setBounds(1290, 69, 294, 910);
		 frame.getContentPane().add(panel_2);
		 panel_2.setLayout(null);
		 
		  PictureContentLeft = new JLabel();
		  PictureContentLeft.setForeground(new Color(255, 255, 255));
		  PictureContentLeft.setHorizontalAlignment(SwingConstants.CENTER);
		  PictureContentLeft.setBounds(47, 23, 204, 299);
		  panel_2.add(PictureContentLeft);
		  
		   ContentLeft = new JTextArea();
		   ContentLeft.setBackground(panel_2.getBackground());
		   ContentLeft.setForeground(new Color(255, 255, 255));
		   ContentLeft.setCaretColor(panel_2.getBackground());
		   ContentLeft.setFont(new Font("SansSerif", Font.PLAIN, 16));
		   ContentLeft.setText("");
		   ContentLeft.setBounds(24, 464, 260, 412);
		   ContentLeft.setEditable(false);
		   //2 thuoc tinh nay giup cho content fill day textArea
		   ContentLeft.setWrapStyleWord(true);
		   ContentLeft.setLineWrap(true);
		   panel_2.add(ContentLeft);
		   
		    BookTitleLeft = new JLabel();
		    BookTitleLeft.setText(" ");
		    BookTitleLeft.setHorizontalAlignment(SwingConstants.CENTER);
		    BookTitleLeft.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 22));
		    BookTitleLeft.setForeground(new Color(255, 255, 255));
		    BookTitleLeft.setBounds(10, 320, 290, 43);
		    panel_2.add(BookTitleLeft);
		    
		    LabelAuthorLeft = new JLabel("asldhvcsjdvnhs");
		    LabelAuthorLeft.setHorizontalAlignment(SwingConstants.CENTER);
		    LabelAuthorLeft.setForeground(new Color(100, 123, 173));
		    LabelAuthorLeft.setFont(new Font("SansSerif", Font.ITALIC, 15));
		    LabelAuthorLeft.setBounds(24, 353, 260, 50);
		    panel_2.add(LabelAuthorLeft);
		    
		    fiveStarLabel = new JLabel("");
		    fiveStarLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
		    fiveStarLabel.setForeground(new Color(128, 136, 160));
		    fiveStarLabel.setVisible(false);
		    fiveStarLabel.setBounds(79, 400, 187, 50);
		    fiveStarLabel.setIcon(fiveStarb);
		    panel_2.add(fiveStarLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(251, 252, 253));
		panel_1.setBounds(272, 0, 1312, 90);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(235, 238, 244));
		panel_5.setBounds(10, 69, 1008, 21);
		panel_1.add(panel_5);
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBorder(null);
		panel_8.setBounds(985, 21, 288, 33);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		
				
				JLabel lblNewLabel_1_1 = new JLabel("Lack Of Knowledge, huh ? " + getLastName(bd.getTen()));
				lblNewLabel_1_1.setBackground(new Color(235, 238, 244));
				lblNewLabel_1_1.setBounds(-28, 0, 316, 33);
				lblNewLabel_1_1.setBorder(brdrLeft);
				panel_8.add(lblNewLabel_1_1);
				lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
				lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 283, 979);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Logo VKU");
		// Tải ảnh từ resources
        ImageIcon originalIconLogo = new ImageIcon(Home.class.getResource("/assets/vku2.jpg"));
        Image originalImageLogo = originalIconLogo.getImage();
		 // Thay đổi kích thước ảnh
        Image scaledImageLogo = originalImageLogo.getScaledInstance(700, 700, Image.SCALE_SMOOTH);  // Adjust the width and height as needed
        ImageIcon scaledIconLogo = new ImageIcon(scaledImageLogo);
        
		lblNewLabel.setIcon(scaledIconLogo);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(41, 38, 232, 183);
		panel.add(lblNewLabel);
		
		JButton DiscoverButton = new JButton("Discover");
		DiscoverButton.setHorizontalAlignment(SwingConstants.LEFT);
		DiscoverButton.setIcon(home3);
		DiscoverButton.setForeground(new Color(192, 192, 192));
		DiscoverButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		DiscoverButton.setBorder(null);
		DiscoverButton.setBackground(new Color(255, 255, 255));
		DiscoverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		DiscoverButton.setBounds(62, 242, 166, 76);
		panel.add(DiscoverButton);
		
		JButton BorrowingCardButton = new JButton("Borrowing Card");
		BorrowingCardButton.setHorizontalAlignment(SwingConstants.LEFT);
		BorrowingCardButton.setIcon(book3);
		BorrowingCardButton.setForeground(new Color(192, 192, 192));
		BorrowingCardButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		BorrowingCardButton.setBorder(null);
		BorrowingCardButton.setBackground(new Color(255, 255, 255));
		BorrowingCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		BorrowingCardButton.setBounds(62, 370, 166, 76);
		panel.add(BorrowingCardButton);
		
		JButton ProfileButton = new JButton("Profile");
		ProfileButton.setHorizontalAlignment(SwingConstants.LEFT);
		ProfileButton.setIcon(user3);
		ProfileButton.setForeground(new Color(192, 192, 192));
		ProfileButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		ProfileButton.setBorder(null);
		ProfileButton.setBackground(new Color(255, 255, 255));
		ProfileButton.setBounds(62, 499, 166, 76);
		ProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		panel.add(ProfileButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(235, 238, 244));
		panel_4.setBounds(10, 656, 263, 2);
		panel.add(panel_4);
		
		JButton introduction = new JButton("introduction");
		introduction.setForeground(new Color(192, 192, 192));
		introduction.setFont(new Font("SansSerif", Font.PLAIN, 16));
		introduction.setBorder(null);
		introduction.setBackground(new Color(255, 255, 255));
		introduction.setBounds(40, 703, 171, 87);
		introduction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		panel.add(introduction);
		
		JButton btnAboutMe = new JButton("About me");
		btnAboutMe.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnAboutMe.setForeground(new Color(192, 192, 192));
		btnAboutMe.setBorder(null);
		btnAboutMe.setBackground(new Color(255, 255, 255));
		btnAboutMe.setBounds(45, 814, 166, 87);
		btnAboutMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		//panel.add(btnAboutMe);
		
	
		tabbedPane.setBackground(new Color(235, 238, 244));
		tabbedPane.setBorder(BorderFactory.createEmptyBorder()); // Removes the default border
		
		
		tabbedPane.setBounds(293, 51, 987, 899);
		frame.getContentPane().add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane()  {
			@Override
		    protected void paintComponent(Graphics g) {
		       super.paintComponent(g);
		       Dimension arcs = new Dimension(15,15);
		       int width = getWidth();
		       int height = getHeight();
		       Graphics2D graphics = (Graphics2D) g;
		       graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


		       //Draws the rounded opaque panel with borders.
		       graphics.setColor(new Color(255,255,255));
		       graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
		       graphics.setColor(new Color(216,216,216));
		       graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
		    }
			 @Override
			public JScrollBar createVerticalScrollBar() {
	                return new CustomScrollBar();
	            }
			 @Override
			 public JScrollBar createHorizontalScrollBar() {
	                return new CustomScrollBar();
	            }
		};
		scrollPane.setBackground(new Color(235, 238, 244));
		scrollPane.setBorder(null);
		
		tabbedPane.addTab("1", null, scrollPane, null);
		
		  jtp2 = new JPanel();
			jtp2.setBackground(new Color(255, 255, 255));
			tabbedPane.addTab("2", null,jtp2 , null);
			jtp2.setLayout(null);
			
			 JBtTraSach = new JButton("Trả Sách");
			JBtTraSach.setBounds(349, 712, 149, 93);
			JBtTraSach.setVisible(false);
			jtp2.add(JBtTraSach);
			
			jtp2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// Xử lý sự kiện khi chuột được nhấn
					JTbPhieuMuonTraSach.clearSelection(); // Bỏ chọn mọi hàng khi nhấn ở ngoài table
					// ClearInfo();
				}
			});
			
			JButton btnRefreshTable = new JButton("Refresh");
			btnRefreshTable.setBounds(773, 44, 117, 38);
			btnRefreshTable.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"Refresh","Đã tải lại bảng",JOptionPane.PLAIN_MESSAGE);
					ShowData(connector.Refresh());
					
				}
			});
			jtp2.add(btnRefreshTable);
			
		JPanel jtp3 = new JPanel();
		tabbedPane.addTab("3", null,jtp3 , null);
		jtp3.setLayout(null);
		jtp3.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("Mã Bạn Đọc :");
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3.setBounds(52, 92, 197, 84);
		jtp3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Họ Và Tên :");
		lblNewLabel_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3_1.setBounds(52, 187, 197, 84);
		jtp3.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Email :");
		lblNewLabel_3_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3_2.setBounds(52, 294, 197, 84);
		jtp3.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Password :");
		lblNewLabel_3_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3_3.setBounds(52, 397, 197, 84);
		jtp3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Số Điện Thoại :");
		lblNewLabel_3_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3_4.setBounds(52, 504, 197, 84);
		jtp3.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Chức Vụ :");
		lblNewLabel_3_4_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3_4_1.setBounds(52, 618, 197, 84);
		jtp3.add(lblNewLabel_3_4_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText(bd.getMaBanDoc());
		textArea_1.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textArea_1.setBounds(275, 110, 522, 37);
		jtp3.add(textArea_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setText(bd.getTen());
		textArea_1_1.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textArea_1_1.setBounds(275, 216, 522, 37);
		jtp3.add(textArea_1_1);
		
		JTextArea textArea_1_2 = new JTextArea();
		textArea_1_2.setText(bd.getEmail());
		textArea_1_2.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textArea_1_2.setBounds(275, 325, 522, 37);
		jtp3.add(textArea_1_2);
		
		JTextArea textArea_1_3 = new JTextArea();
		textArea_1_3.setText(bd.getPassword());
		textArea_1_3.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textArea_1_3.setBounds(275, 428, 522, 37);
		jtp3.add(textArea_1_3);
		
		JTextArea textArea_1_4 = new JTextArea();
		textArea_1_4.setText(bd.getSdt());
		textArea_1_4.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textArea_1_4.setBounds(275, 522, 522, 37);
		jtp3.add(textArea_1_4);
		
		JTextArea textArea_1_5 = new JTextArea();
		textArea_1_5.setText(bd.getChucVu());
		textArea_1_5.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textArea_1_5.setBounds(275, 635, 522, 37);
		jtp3.add(textArea_1_5);
		
		
		
		 
		
		
		JPanel jtp4 = new JPanel();
		tabbedPane.addTab("4", null,jtp4 , null);
		jtp4.setLayout(null);
		jtp4.setBackground(new Color(255, 255, 255));
		
		JTextArea txtrDiscoverTo_1_2_1_1 = new JTextArea();
		txtrDiscoverTo_1_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtrDiscoverTo_1_2_1_1.setBackground(new Color(255, 255, 255));
		txtrDiscoverTo_1_2_1_1.setWrapStyleWord(true);
		txtrDiscoverTo_1_2_1_1.setText("About me \t: To See Who Code This App");
		txtrDiscoverTo_1_2_1_1.setLineWrap(true);
		txtrDiscoverTo_1_2_1_1.setEditable(false);
		txtrDiscoverTo_1_2_1_1.setCaretColor(Color.WHITE);
		txtrDiscoverTo_1_2_1_1.setBounds(83, 641, 779, 41);
		jtp4.add(txtrDiscoverTo_1_2_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Introduction :");
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(83, 136, 151, 56);
		jtp4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("VKU LIBRARY :");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(192, 33, 544, 83);
		jtp4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("Usage  :");
		lblNewLabel_4_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_4_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setForeground(Color.BLACK);
		lblNewLabel_4_2.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_4_2.setBounds(58, 333, 151, 56);
		jtp4.add(lblNewLabel_4_2);
		
		JTextArea txtrThanksForEnter = new JTextArea();
		txtrThanksForEnter.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtrThanksForEnter.setBackground(new Color(255, 255, 255));
		txtrThanksForEnter.setText("Thanks for enter here. This is LIBRARY of Korea VietNam Friendship IT University -  Đại Học Đà Nẵng CNTT Hữu Nghị Việt - Hàn. Welcome to our library app, your digital gateway to a world of knowledge. With our user-friendly interface and extensive collection of books, you can explore, borrow, and enjoy literature from the comfort of your device. Whether you're an avid reader or just starting your literary journey, our app offers a seamless experience to discover and dive into captivating stories, educational resources, and much more. Start your reading adventure today with our library app.");
		txtrThanksForEnter.setBounds(93, 188, 842, 151);
		//2 thuoc tinh nay giup cho content fill day textArea
				txtrThanksForEnter.setWrapStyleWord(true);
				txtrThanksForEnter.setLineWrap(true);
				//uneditable
				txtrThanksForEnter.setEditable(false);
				//lam con tro thanh mau nen cua textArea
				txtrThanksForEnter.setCaretColor(txtrThanksForEnter.getBackground());
				jtp4.add(txtrThanksForEnter);
				
				JTextArea txtrDiscoverTo_1 = new JTextArea();
				txtrDiscoverTo_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
				txtrDiscoverTo_1.setBackground(new Color(255, 255, 255));
				txtrDiscoverTo_1.setWrapStyleWord(true);
				txtrDiscoverTo_1.setText("Discover \t: To see the latest books in library.");
				txtrDiscoverTo_1.setLineWrap(true);
				txtrDiscoverTo_1.setEditable(false);
				txtrDiscoverTo_1.setCaretColor(Color.WHITE);
				txtrDiscoverTo_1.setBounds(83, 385, 779, 41);
				jtp4.add(txtrDiscoverTo_1);
				
				JTextArea txtrDiscoverTo_1_1 = new JTextArea();
				txtrDiscoverTo_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
				txtrDiscoverTo_1_1.setBackground(new Color(255, 255, 255));
				txtrDiscoverTo_1_1.setWrapStyleWord(true);
				txtrDiscoverTo_1_1.setText("- Click into any book to see more information.");
				txtrDiscoverTo_1_1.setLineWrap(true);
				txtrDiscoverTo_1_1.setEditable(false);
				txtrDiscoverTo_1_1.setCaretColor(Color.WHITE);
				txtrDiscoverTo_1_1.setBounds(177, 424, 779, 41);
				jtp4.add(txtrDiscoverTo_1_1);
				
				JTextArea txtrDiscoverTo_1_2 = new JTextArea();
				txtrDiscoverTo_1_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
				txtrDiscoverTo_1_2.setBackground(new Color(255, 255, 255));
				txtrDiscoverTo_1_2.setWrapStyleWord(true);
				txtrDiscoverTo_1_2.setText("Profile \t: Your Profile");
				txtrDiscoverTo_1_2.setLineWrap(true);
				txtrDiscoverTo_1_2.setEditable(false);
				txtrDiscoverTo_1_2.setCaretColor(Color.WHITE);
				txtrDiscoverTo_1_2.setBounds(83, 566, 779, 41);
				jtp4.add(txtrDiscoverTo_1_2);
				
				JTextArea txtrDiscoverTo_1_3 = new JTextArea();
				txtrDiscoverTo_1_3.setFont(new Font("SansSerif", Font.PLAIN, 15));
				txtrDiscoverTo_1_3.setBackground(new Color(255, 255, 255));
				txtrDiscoverTo_1_3.setWrapStyleWord(true);
				txtrDiscoverTo_1_3.setText("- Borrow Button to borrow book");
				txtrDiscoverTo_1_3.setLineWrap(true);
				txtrDiscoverTo_1_3.setEditable(false);
				txtrDiscoverTo_1_3.setCaretColor(Color.WHITE);
				txtrDiscoverTo_1_3.setBounds(177, 462, 779, 32);
				jtp4.add(txtrDiscoverTo_1_3);
				
				JTextArea txtrDiscoverTo_1_4 = new JTextArea();
				txtrDiscoverTo_1_4.setFont(new Font("SansSerif", Font.PLAIN, 15));
				txtrDiscoverTo_1_4.setBackground(new Color(255, 255, 255));
				txtrDiscoverTo_1_4.setWrapStyleWord(true);
				txtrDiscoverTo_1_4.setText("Borrowing Card  : You can see all your book you've borrowed");
				txtrDiscoverTo_1_4.setLineWrap(true);
				txtrDiscoverTo_1_4.setEditable(false);
				txtrDiscoverTo_1_4.setCaretColor(Color.WHITE);
				txtrDiscoverTo_1_4.setBounds(83, 497, 779, 32);
				jtp4.add(txtrDiscoverTo_1_4);
				
				JTextArea txtrDiscoverTo_1_5 = new JTextArea();
				txtrDiscoverTo_1_5.setFont(new Font("SansSerif", Font.PLAIN, 15));
				txtrDiscoverTo_1_5.setBackground(new Color(255, 255, 255));
				txtrDiscoverTo_1_5.setWrapStyleWord(true);
				txtrDiscoverTo_1_5.setText("Discover \t: To see the latest books in library.");
				txtrDiscoverTo_1_5.setLineWrap(true);
				txtrDiscoverTo_1_5.setEditable(false);
				txtrDiscoverTo_1_5.setCaretColor(Color.WHITE);
				txtrDiscoverTo_1_5.setBounds(83, 530, 779, 41);
				jtp4.add(txtrDiscoverTo_1_5);
				
				JTextArea txtrDiscoverTo_1_2_1 = new JTextArea();
				txtrDiscoverTo_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
				txtrDiscoverTo_1_2_1.setBackground(new Color(255, 255, 255));
				txtrDiscoverTo_1_2_1.setWrapStyleWord(true);
				txtrDiscoverTo_1_2_1.setText("Introduction\t: Here ");
				txtrDiscoverTo_1_2_1.setLineWrap(true);
				txtrDiscoverTo_1_2_1.setEditable(false);
				txtrDiscoverTo_1_2_1.setCaretColor(Color.WHITE);
				txtrDiscoverTo_1_2_1.setBounds(83, 606, 779, 41);
				jtp4.add(txtrDiscoverTo_1_2_1);
				
				JTextArea txtrDiscoverTo = new JTextArea();
				txtrDiscoverTo.setDisabledTextColor(new Color(255, 255, 255));
				txtrDiscoverTo.setBackground(new Color(255, 255, 255));
				txtrDiscoverTo.setBounds(48, 110, 867, 625);
				txtrDiscoverTo.setCaretColor(Color.WHITE);
				jtp4.add(txtrDiscoverTo);
				
				JPanel jtp5 = new JPanel();
				jtp5.setLayout(null);
				jtp5.setBackground(new Color(255, 255, 255));
				tabbedPane.addTab("5", null,jtp5 , null);
				
				JTextArea textArea_2 = new JTextArea();
				textArea_2.setBounds(52, 71, 865, 681);
				jtp5.add(textArea_2);
				
				JPanel panel_3 = new JPanel()  ;
				panel_3.setBackground(new Color(235, 238, 244));
				panel_3.setForeground(new Color(235, 238, 244));
				panel_3.setBorder(null);
				//	panel_3.setBorder(null);
					scrollPane.setViewportView(panel_3);
					panel_3.setBackground(new Color(235, 238, 244));
					panel_3.setLayout(null);;
		
		///////////////////////////
		
	//	panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 25, true));


		/****************************************************************************/
		//////////////////////////////
		/*
		 * Locate : X = 10, Y = 32
		 * size to Move : X=10; y+=254
		 * size Panel : 951,173
		 * 
		 * prepare : 
		 * list PanelBook
		 * list LabelPicture 
		 * list LabelTitle
		 * list LabelContent
		 * list Button
		 */
		int xPanel = 10;
		int yPanel = 34;
		int xLabelPicture = 5;
		int yLabelPicture = 6 + 20;
		int xLabelTitle = 122 + 20;
		int yLabelTitle = 0+30 - 10;
		int xAuthor = 132 + 10;
		int yAuthor = 45 - 10+30 - 10;
		int xRating = 852 + 10 - 10 - 10 ;
		int yRating = 30 + 10;
		int xTextAreaContent = 132 + 10;
		int yTextAreaContent = 90 - 10;
		int xButtonBorrow = 852;
		int yButtonBorrow = 11;
		int yPanelPlus =  210;
		
		
		int range = ss.size();
		JPanel[] PanelBook = new JPanel[range];
		JLabel[] labelPicture = new JLabel[range];
		JLabel[] LabelTitle = new JLabel[range];
		JLabel[] LabelAuthor = new JLabel[range];
		JLabel[] LabelRating = new JLabel[range];
		JTextArea[] TextAreaContent = new JTextArea[range];
		JButton[] ButtonBorrow = new JButton[range];
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		
        
        
		for(int i=0;i<ss.size();i++) {
			
			PanelBook[i] = new CustomPanel();
			PanelBook[i].setBackground(new Color(235,238,244));
			PanelBook[i].setLayout(null);
			PanelBook[i].setBounds(xPanel,yPanel, 951,210);
			
			
			labelPicture[i] = new JLabel( );
			
	        labelPicture[i].setBounds(xLabelPicture, yLabelPicture, 132, 175);
	    	// Tải ảnh từ resources
	        ImageIcon originalIcon = new ImageIcon(Home.class.getResource("/assets/" + ss.get(i).getMaSach() + ".jpg"));
	        Image originalImage = originalIcon.getImage();
			 // Thay đổi kích thước ảnh
	        Image scaledImage = originalImage.getScaledInstance(250, 250, Image.SCALE_SMOOTH);  // Adjust the width and height as needed
	        ImageIcon scaledIcon = new ImageIcon(scaledImage);
	        labelPicture[i].setIcon(scaledIcon);
	        ///////////////////////////
			PanelBook[i].add(labelPicture[i]);
			
			LabelTitle[i] = new JLabel( ss.get(i).getTenSach() );
			LabelTitle[i].setFont(new Font("SansSerif", Font.BOLD, 18));
			LabelTitle[i].setBounds(xLabelTitle, yLabelTitle, 819, 34);
			PanelBook[i].add(LabelTitle[i]);
			
			LabelAuthor[i] = new JLabel(ss.get(i).getTacGia());
			LabelAuthor[i].setBounds(xAuthor,yAuthor,100,18);
			LabelAuthor[i].setFont(new Font("Times New Roman", Font.PLAIN, 14));
			LabelAuthor[i].setForeground(Color.GRAY);
			PanelBook[i].add(LabelAuthor[i]);
			
			LabelRating[i] = new JLabel("4.9");
			LabelRating[i].setFont(new Font("SansSerif", Font.BOLD, 15));
			LabelRating[i].setForeground(Color.GRAY);
			LabelRating[i].setBounds(xRating,yRating,100,20);
			LabelRating[i].setIcon(fiveStar);
	        ///////////////////////////
			PanelBook[i].add(LabelRating[i]);
			
			TextAreaContent[i] = new JTextArea(ss.get(i).getTrangThai());
			TextAreaContent[i].setBounds(xTextAreaContent, yTextAreaContent,  809, 300);
			TextAreaContent[i].setFont(new Font("SansSerif", Font.PLAIN, 14));
			
			//2 thuoc tinh nay giup cho content fill day textArea
			TextAreaContent[i].setWrapStyleWord(true);
			TextAreaContent[i].setLineWrap(true);
			TextAreaContent[i].setEditable(false);
			TextAreaContent[i].setBackground(Color.white);
			TextAreaContent[i].setForeground(Color.BLACK);
			TextAreaContent[i].setCaretColor(Color.white);
			String content = TextAreaContent[i].getText();
			String title   = LabelTitle[i].getText();
			String author  = LabelAuthor[i].getText();
			TextAreaContent[i].addMouseListener(new MouseListener() {
				
				
				public void mouseReleased(MouseEvent e) {
					
					
				}
				
				public void mousePressed(MouseEvent e) {
					 
					
				}
				
				public void mouseExited(MouseEvent e) {
					 
					
				}
				
				public void mouseEntered(MouseEvent e) {
					 
							
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					PictureContentLeft.setIcon(scaledIcon);
					BookTitleLeft.setText(title);
					ContentLeft.setText(content);
					LabelAuthorLeft.setText(author);
					fiveStarLabel.setVisible(true);;
					
				}
			});
			PanelBook[i].add(TextAreaContent[i]);
			
			ButtonBorrow[i] = new JButton("Borrow") ;
			ButtonBorrow[i].setBounds(xButtonBorrow, yButtonBorrow, 89, 23);
			String MaSach = ss.get(i).getMaSach();
			ButtonBorrow[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						pmts = connector.MuonSach(MaSach);
						JOptionPane.showMessageDialog(null,"mượn thành công","Mượn Sách",JOptionPane.PLAIN_MESSAGE);
				}
			});
			PanelBook[i].add(ButtonBorrow[i]);
//			
			
			yPanel+=yPanelPlus + 15;

			panel_3.add(PanelBook[i]);
			//auto resize main panel and add scrollpane
			panel_3.setPreferredSize(new Dimension(951, yPanel));
			
				PanelBook[i].addMouseListener(new MouseListener() {
				
				
				public void mouseReleased(MouseEvent e) {
					
					
				}
				
				public void mousePressed(MouseEvent e) {
					 
					
				}
				
				public void mouseExited(MouseEvent e) {
					 
					
				}
				
				public void mouseEntered(MouseEvent e) {
					 
							
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					PictureContentLeft.setIcon(scaledIcon);
					BookTitleLeft.setText(title);
					ContentLeft.setText(content);
					LabelAuthorLeft.setText(author);
					fiveStarLabel.setVisible(true);;
					
				}
			});
		}
		ShowPhieuMuonSachTable();
	/****************************************************************************/
		frame.setSize(1600,1000);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//System.out.println("you got data on screen : " + dataSach);
		
		/////////////////////////////////////////////////////////////////////////////
		
frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				 
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				 
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				 
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				 
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					Connector.close();
				} catch (Exception e2) {
					
				}
				
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				 
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				
				
			}
		});
			 
	}
	
	
public void ShowPhieuMuonSachTable() {
	 
		try {
			model = new CustomTableModel();
			
			String[] Column = {"Mã Phiếu mượn",  "Mã sách" , 
							   "Ngày mượn"    ,"Hạn trả" ,"Ngày trả","Tình trạng"};
			for(int i=0;i<Column.length;i++) {
				model.addColumn(Column[i]);
			}
			System.out.println("using ShowPHIEADJGFCHJKASDBKFGKJDFBJK");
			ShowData(pmts);
			JTbPhieuMuonTraSach = new JTable(model);
			
			JScrollPane scrollpane = new JScrollPane(JTbPhieuMuonTraSach);
			scrollpane.setBounds(44, 147, 882, 480);
			 scrollpane.createVerticalScrollBar();
			 jtp2.add(scrollpane);
			 
			 JTbPhieuMuonTraSach.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					 
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					 
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					 
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					 
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					
					Point point = e.getPoint();					//	1 "con tro"  mang toa do x y 
//					int x = point.getX();						//point.getX() se chi ra toa do
					int row = JTbPhieuMuonTraSach.rowAtPoint(point);		// 		rowAtPoint se in ra hang tai point chi? toi. 	
																// ===> rowAtPoint(point) se chi ra row tai point do
					System.out.println("you clicked at row " + row);
					System.out.println("u click column " + JTbPhieuMuonTraSach.columnAtPoint(point));
					String TrangThai =(String) JTbPhieuMuonTraSach.getValueAt(row, 5);
					if(TrangThai.equals("Chưa trả")) {
						String IDCard = (String) JTbPhieuMuonTraSach.getValueAt(row, 0); //column 0 = id card
						JBtTraSach.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								pmts = connector.TraSach(IDCard);
								JOptionPane.showMessageDialog(null,"Trả Sách Thành Công", "Trả Sách",JOptionPane.PLAIN_MESSAGE);
								
								ShowData(connector.Refresh()); //reset table
								JBtTraSach.removeActionListener(this);
							}
						});
						JBtTraSach.setVisible(true);
					}
					
					else
					JBtTraSach.setVisible(false);
						
//					int row = JTbPhieuMuonTraSach.rowAtPoint(point);
					//ListSelectionModel selectionModel = JTbPhieuMuonTraSach.getSelectionModel();

					 
					
					/***************************************************************/
					
				}
			});;
			 
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public void ShowData(ArrayList<PhieuMuonTraSach> data) {
		model.setRowCount(0);
		for(PhieuMuonTraSach pmts : data) {
			System.out.println(pmts.toString()); 
			Object[] RowData = new Object[] {
			pmts.getMaPhieuMuon(), pmts.getMaSach(), 
			pmts.getNgayMuon(),pmts.getHanTra(),pmts.getNgayTra(),pmts.getTinhTrang()
			};
			System.out.println("refreshing");
			model.addRow(RowData);
			System.out.println(model.getRowCount());
		}

	}
	////////////////////////////////////////////////////////////////////////////

	public void CloseLeftContent() {
		PictureContentLeft.setVisible(false);
		ContentLeft.setVisible(false);
		BookTitleLeft.setVisible(false);
	}
	public void OpenLeftContent() {
		PictureContentLeft.setVisible(true);
		ContentLeft.setVisible(true);
		BookTitleLeft.setVisible(true);
		fiveStarLabel.setVisible(true);
	}
	
	public void SetLeftContent() {
		PictureContentLeft.setText("nsjadkf");;
		ContentLeft.setText("nsjadkf");
		BookTitleLeft.setText("nsjadkf");
		
	}
	public String getLastName(String fullName) {
	    // Tách chuỗi thành các phần dựa trên khoảng trắng
	    String[] parts = fullName.split(" ");

	    // Trả về phần tử cuối cùng trong mảng (tên)
	    return parts[parts.length - 1];
	}
	////////////////////////////////////////////////////////////////////////////

	public Connector getConnector() {
		return connector;
	}

	public void setConnector(Connector connector) {
		this.connector = connector;
	}
}
