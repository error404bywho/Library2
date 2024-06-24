package view;

import java.awt.EventQueue;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import action.ActionForLogin;
import connection.Connector;
import model.BanDoc;
import model.PhieuMuonTraSach;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import model.Sach;
public class Login {

	JFrame frame;
	private JTextField EmailTextField;
	private JPasswordField PasswordTextField;
	private JTextField EmailSignUp;
	private JPasswordField PasswordSignUp;
	private JPasswordField ConPasswordSignUp;
	
	private JButton OpenPanelButton ;
	private JButton ClosePanelButton;
	private JButton SignUpButton;
	private JButton LoginButton;
	private JButton SignupNavigate;
	
	private JPanel panel;
	
	private JTextField IDSignUp;
	private JTextField FullnameSignUp;
	
	private ArrayList<Sach> ss  = new ArrayList<Sach>(); 
	private ArrayList<PhieuMuonTraSach> pmts  = new ArrayList<PhieuMuonTraSach>(); 
	
	private BanDoc bd;
	private ButtonGroup BGChucVu;

	private Connector connector = new Connector(true);

	private JTextField PhoneSignUp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					String src = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
					UIManager.setLookAndFeel(src);
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(128, 128, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 939, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);					//tranh phong to
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		this.panel = new JPanel();
		this.panel.setBackground(new Color(128, 128, 255));
		this.panel.setBounds(0, 0, 378, 662);
		frame.getContentPane().add(panel);
		this.panel.setLayout(null);
		//basic : 0, 0, 347, 662 
		//full :  0, 0, 1000, 1000
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(93, 474, 53, 49);
		panel.add(panel_1);
//		128,128,255
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(199, 474, 53, 49);
		panel.add(panel_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(146, 521, 53, 49);
		panel.add(panel_1_2);
		
		JLabel Copyright = new JLabel("No Copyright © 2024 VKU University");
		Copyright.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Copyright.setHorizontalAlignment(SwingConstants.CENTER);
		Copyright.setForeground(new Color(255, 255, 255));
		Copyright.setBounds(31, 601, 257, 21);
		panel.add(Copyright);
		
		JLabel lblNewLabel_1 = new JLabel("LIBRARY");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 32));
		lblNewLabel_1.setBounds(19, 233, 269, 138);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBounds(317, 474, 53, 49);
		panel.add(panel_1_2_1);
		
		JPanel panel_1_2_1_1 = new JPanel();
		panel_1_2_1_1.setBounds(10, 427, 53, 49);
		panel.add(panel_1_2_1_1);
		
		JPanel panel_1_2_1_2 = new JPanel();
		panel_1_2_1_2.setBounds(61, 382, 53, 49);
		panel.add(panel_1_2_1_2);
		
		JPanel panel_1_2_1_3_1 = new JPanel();
		panel_1_2_1_3_1.setBounds(244, 342, 53, 49);
		panel.add(panel_1_2_1_3_1);
		
		JPanel panel_1_2_1_3_1_1 = new JPanel();
		panel_1_2_1_3_1_1.setBounds(-19, 36, 53, 49);
		panel.add(panel_1_2_1_3_1_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Email:");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(505, 291, 51, 37);
		panel.add(lblNewLabel_2_3);
		
		EmailSignUp = new JTextField();
		EmailSignUp.setColumns(10);
		EmailSignUp.setBounds(575, 298, 223, 26);
		panel.add(EmailSignUp);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password:");
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(472, 394, 84, 37);
		panel.add(lblNewLabel_2_1_1);
		
		PasswordSignUp = new JPasswordField();
		PasswordSignUp.setColumns(10);
		PasswordSignUp.setBounds(575, 401, 223, 26);
		panel.add(PasswordSignUp);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Confirm Password:");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(411, 439, 148, 37);
		panel.add(lblNewLabel_2_1_1_1);
		
		ConPasswordSignUp = new JPasswordField();
		ConPasswordSignUp.setColumns(10);
		ConPasswordSignUp.setBounds(575, 446, 223, 26);
		panel.add(ConPasswordSignUp);
		
		this.SignUpButton = new JButton("Sign Up");
		
		this.SignUpButton.setForeground(Color.WHITE);
		this.SignUpButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		this.SignUpButton.setBackground(new Color(128, 128, 255));
		this.SignUpButton.setBounds(608, 534, 138, 36);
		this.panel.add(SignUpButton);
		
		
		JLabel VKULabel = new JLabel("");
		 // Tải ảnh từ resources
        ImageIcon originalIcon1 = new ImageIcon(Login.class.getResource("/assets/vku.png"));
        Image originalImage1 = originalIcon1.getImage();

        // Thay đổi kích thước ảnh
        Image scaledImage1 = originalImage1.getScaledInstance(250, 250, Image.SCALE_SMOOTH);  // Adjust the width and height as needed
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        
     // Đặt icon cho JLabel
     		VKULabel.setIcon(scaledIcon1);
    		VKULabel.setBounds(31, 95, 250, 187);
    		panel.add(VKULabel);
    		
    		
    		
    		this.OpenPanelButton = new JButton(">");
    		this.OpenPanelButton.setBounds(248, 24, 77, 49);
    		panel.add(OpenPanelButton);
    		
    		this.ClosePanelButton = new JButton("<");
    		this.ClosePanelButton.setBounds(787, 36, 77, 49);
    		panel.add(ClosePanelButton);
    		
    	
    		
    		JPanel panel_1_1_1_5_1 = new JPanel();
    		panel_1_1_1_5_1.setBounds(562, 36, 53, 49);
    		panel.add(panel_1_1_1_5_1);
    		panel_1_1_1_5_1.setLayout(null);
    		panel_1_1_1_5_1.setBackground(new Color(128, 128, 255));
    		
    		JPanel panel_1_2_1_6 = new JPanel();
    		panel_1_2_1_6.setBounds(0, 0, 53, 49);
    		panel_1_1_1_5_1.add(panel_1_2_1_6);
    		
    		JLabel lblNewLabel_3 = new JLabel("SIGN UP");
    		lblNewLabel_3.setBounds(572, 99, 208, 122);
    		panel.add(lblNewLabel_3);
    		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
    		lblNewLabel_3.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 27));
    		lblNewLabel_3.setForeground(new Color(255, 255, 255));
    		
    		JPanel panel_1_2_1_3 = new JPanel();
    		panel_1_2_1_3.setBounds(405, 550, 53, 49);
    		panel.add(panel_1_2_1_3);
    		
    		JPanel panel_1_2_1_4 = new JPanel();
    		panel_1_2_1_4.setBounds(834, 584, 53, 49);
    		panel.add(panel_1_2_1_4);
    		
    		JPanel panel_1_2_1_6_1 = new JPanel();
    		panel_1_2_1_6_1.setBounds(888, 184, 53, 49);
    		panel.add(panel_1_2_1_6_1);
    		
    		JPanel panel_1_2_1_6_2 = new JPanel();
    		panel_1_2_1_6_2.setBounds(780, 530, 53, 49);
    		panel.add(panel_1_2_1_6_2);
    		
    		JPanel panel_1_2_1_6_3 = new JPanel();
    		panel_1_2_1_6_3.setBounds(725, 584, 53, 49);
    		panel.add(panel_1_2_1_6_3);
    		
    		JLabel lblNewLabel_2_3_1 = new JLabel("ID:");
    		lblNewLabel_2_3_1.setForeground(Color.WHITE);
    		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
    		lblNewLabel_2_3_1.setBounds(522, 194, 35, 37);
    		panel.add(lblNewLabel_2_3_1);
    		
    		IDSignUp = new JTextField();
    		IDSignUp.setColumns(10);
    		IDSignUp.setBounds(575, 201, 223, 26);
    		panel.add(IDSignUp);
    		
    		JLabel lblNewLabel_2_3_2 = new JLabel("Full Name:");
    		lblNewLabel_2_3_2.setForeground(Color.WHITE);
    		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
    		lblNewLabel_2_3_2.setBounds(472, 243, 84, 37);
    		panel.add(lblNewLabel_2_3_2);
    		
    		FullnameSignUp = new JTextField();
    		FullnameSignUp.setColumns(10);
    		FullnameSignUp.setBounds(575, 250, 223, 26);
    		panel.add(FullnameSignUp);
    		
    		JRadioButton StudentRadioButton = new JRadioButton("Student");
    		StudentRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
    		StudentRadioButton.setSelected(true);
    		StudentRadioButton.setBackground(new Color(128, 128, 255));
    		StudentRadioButton.setForeground(new Color(255, 255, 255));
    		StudentRadioButton.setBounds(576, 496, 109, 23);
    		panel.add(StudentRadioButton);
    		
    		JRadioButton TeacherRadioButton = new JRadioButton("Teacher");
    		TeacherRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
    		TeacherRadioButton.setBackground(new Color(128, 128, 255));
    		TeacherRadioButton.setForeground(new Color(255, 255, 255));
    		TeacherRadioButton.setBounds(700, 496, 109, 23);
    		panel.add(TeacherRadioButton);
    		
    		BGChucVu = new ButtonGroup();
    		BGChucVu.add(StudentRadioButton);
    		BGChucVu.add(TeacherRadioButton);
    		
    		JLabel Position = new JLabel("Position:");
    		Position.setForeground(Color.WHITE);
    		Position.setFont(new Font("Tahoma", Font.BOLD, 14));
    		Position.setBounds(481, 487, 77, 32);
    		panel.add(Position);
    		
    		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Phone Number:");
    		lblNewLabel_2_1_1_1_1.setForeground(Color.WHITE);
    		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
    		lblNewLabel_2_1_1_1_1.setBounds(433, 339, 123, 37);
    		panel.add(lblNewLabel_2_1_1_1_1);
    		
    		PhoneSignUp = new JTextField();
    		PhoneSignUp.setColumns(10);
    		PhoneSignUp.setBounds(575, 349, 223, 26);
    		panel.add(PhoneSignUp);
    		

	//----------------------------------------
        
        JLabel lblNewLabel = new JLabel("");
		 // Tải ảnh từ resources
        ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/assets/user.png"));
        Image originalImage = originalIcon.getImage();

        // Thay đổi kích thước ảnh
        Image scaledImage = originalImage.getScaledInstance(600, 400, Image.SCALE_SMOOTH);  // Adjust the width and height as needed
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        
        // Đặt icon cho JLabel
        lblNewLabel.setIcon(scaledIcon);
		lblNewLabel.setBounds(309, 88, 413, 145);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setForeground(new Color(128, 128, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(440, 276, 51, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		EmailTextField = 	new JTextField();
		EmailTextField.setBounds(510, 283, 223, 26);
		frame.getContentPane().add(EmailTextField);
		EmailTextField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setForeground(new Color(128, 128, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(407, 329, 84, 37);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		PasswordTextField = new JPasswordField();
		PasswordTextField.setColumns(10);
		PasswordTextField.setBounds(510, 336, 223, 26);
		frame.getContentPane().add(PasswordTextField);
		
		LoginButton = new JButton("Login");
		LoginButton.setBackground(new Color(128, 128, 255));
		LoginButton.setForeground(new Color(255, 255, 255));
		LoginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		LoginButton.setBounds(534, 390, 162, 37);
		//LoginButton.addActionListener(ac);
		frame.getContentPane().add(LoginButton);
		
		SignupNavigate = new JButton("Sign Up");
		SignupNavigate.setBackground(new Color(128, 128, 255));
		SignupNavigate.setForeground(new Color(255, 255, 255));
		
		SignupNavigate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		SignupNavigate.setBounds(653, 504, 138, 36);
		frame.getContentPane().add(SignupNavigate);
		
		JLabel lblNewLabel_2_2 = new JLabel("Welcome back !");
		lblNewLabel_2_2.setForeground(new Color(128, 128, 255));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2_2.setBounds(449, 230, 337, 37);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel(" Looking for some books ? ");
		lblNewLabel_2_2_1.setForeground(new Color(128, 128, 255));
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2_2_1.setBounds(407, 504, 277, 37);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 255));
		panel_2.setBounds(436, 473, 385, 2);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(new Color(128, 128, 255));
		panel_1_1_1_1.setBounds(889, 184, 53, 49);
		frame.getContentPane().add(panel_1_1_1_1);
		
		JPanel panel_1_1_1_2 = new JPanel();
		panel_1_1_1_2.setLayout(null);
		panel_1_1_1_2.setBackground(new Color(128, 128, 255));
		panel_1_1_1_2.setBounds(827, 560, 53, 49);
		frame.getContentPane().add(panel_1_1_1_2);
		
		JPanel panel_1_1_1_3 = new JPanel();
		panel_1_1_1_3.setLayout(null);
		panel_1_1_1_3.setBackground(new Color(128, 128, 255));
		panel_1_1_1_3.setBounds(757, 68, 53, 49);
		frame.getContentPane().add(panel_1_1_1_3);
		
		JPanel panel_1_1_1_4 = new JPanel();
		panel_1_1_1_4.setLayout(null);
		panel_1_1_1_4.setBackground(new Color(128, 128, 255));
		panel_1_1_1_4.setBounds(757, 390, 53, 49);
		frame.getContentPane().add(panel_1_1_1_4);
		
		JPanel panel_1_1_1_5 = new JPanel();
		panel_1_1_1_5.setLayout(null);
		panel_1_1_1_5.setBackground(new Color(128, 128, 255));
		panel_1_1_1_5.setBounds(405, 552, 53, 49);
		frame.getContentPane().add(panel_1_1_1_5);
		
		/*****************Button Actions******************************/
		
		/*************************SIGN UP**********************/
		SignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Id = IDSignUp.getText();
				String Fullname = FullnameSignUp.getText();
				String Email = EmailSignUp.getText();
				String PhoneNumber = PhoneSignUp.getText();
				char[] Password = PasswordSignUp.getPassword();
				char[] ConPassword = ConPasswordSignUp.getPassword();
				String ChucVu = BGChucVu.getSelection().getActionCommand();
				
				/*
				 * khong duoc bo trong 
				 * mat khau phai trung nhau
				 */
				 boolean Matched = Arrays.equals(Password, ConPassword);
				 if(Id.equals("") || Fullname.equals("") || Email.equals("") || PhoneNumber.equals("") || Password.equals("") || ConPassword.equals("")) {
					 JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);	 
				 }
				 else if(Matched) {
					 BanDoc bd = new BanDoc(Fullname, PhoneNumber, Email, Email, PhoneNumber, ChucVu);
					 
					 String Data = connector.SignUp(bd);
					 
					 if(Data.equals("false")) {
						 JOptionPane.showMessageDialog(null, "Người Dùng Tồn Tại", "Người Dùng", JOptionPane.ERROR_MESSAGE);
					 }
					 else {
						 //new Home(connector,Data);
					 }
					 
					 JOptionPane.showMessageDialog(null,"Đăng Kí Thành Công","Register",JOptionPane.PLAIN_MESSAGE);
					 
				 } 
				 else {
					 JOptionPane.showMessageDialog(null, "Mật Khẩu Không Khớp", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);
					 }
			}
		});
		/***************************************************/
		
		/*************************LOGIN**********************/
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				
//					String Email = EmailTextField.getText();
//					String Password = PasswordTextField.getText();

					String Email = "1111";
					String Password = "1";					
					
					if(Email.equals("") || Password.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin", "Lỗi Dữ Liệu", JOptionPane.ERROR_MESSAGE);	 
					}
					else {
						String DataLogin = Email + " " +Password;
						try {
								String DataSach = connector.Login(DataLogin);
							//false or OK
							if(DataSach.equals("OK")) {	//1
								JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "Login", JOptionPane.PLAIN_MESSAGE);	 
								
								//nhan tung cuon sach
								String gSach = "";
								String gPhieuBanDoc = "";
								while(true) {
									
									//nhan gson
									gSach = connector.GetRespond(); //2
									if(gSach.equals("done")) break;
									//bien doi gson
									Sach sach = ConvertToSach(gSach);
									//System.out.println(sach.toString());
									ss.add(sach);
									System.out.println("szdjkfbsd");
									
									
								}
								
								//
								System.out.println("you got number of books : " + ss.size());
								//convert to jpg not get data
								getAllPicture();
								
								String BanDoc = connector.GetRespond(); //3
								BanDoc bd = ConvertToBanDoc(BanDoc);
								
								
								while(true) {
									
									//nhan gson
									gPhieuBanDoc = connector.GetRespond(); //2
									if(gPhieuBanDoc.equals("done")) break;
									//bien doi gson
									PhieuMuonTraSach PhieuMuonTraSach = ConvertToPhieuMuonTraSach(gPhieuBanDoc);
									//System.out.println(sach.toString());
									pmts.add(PhieuMuonTraSach);
									System.out.println("szdjkfbsd");
									
									
								}
								System.out.println("you got number of Phieu muon: " + pmts.size());
			
								
								frame.setVisible(false);
								Thread.sleep(2000);
								Home home = new Home(connector,ss,bd,pmts);
								System.out.println("you got number of books : " + ss.size());
								
								//new getData(ss);
							}
							else 
							JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mk", "Login", JOptionPane.ERROR_MESSAGE);
							//do something
						}catch (Exception error) {
							System.out.println("skedbfvskdjbfsdkjfbsdkfb");
							System.out.println(error.getMessage());
							error.getStackTrace();
						}
					}
				
				
			}

			private Sach ConvertToSach(String dataSach) {
				Gson gson = new Gson();
				Type objectType = new TypeToken<Sach>(){}.getType();
				Sach sach = gson.fromJson(dataSach,objectType);
				return sach;
			}
			private PhieuMuonTraSach ConvertToPhieuMuonTraSach(String dataPMTS) {
				Gson gson = new Gson();
				Type objectType = new TypeToken<PhieuMuonTraSach>(){}.getType();
				PhieuMuonTraSach pmts= gson.fromJson(dataPMTS,objectType);
				return pmts;
			}
			private BanDoc ConvertToBanDoc(String dataBanDoc) {
				Gson gson = new Gson();
				Type objectType = new TypeToken<BanDoc>(){}.getType();
				BanDoc bd= gson.fromJson(dataBanDoc,objectType);
				return bd;
			}
		});
		
		
		/***************************************************/
		SignupNavigate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setSize(1000,1000);
				OpenPanelButton.setVisible(false);
			}
		});
		OpenPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setSize(1000, 1000);
				OpenPanelButton.setVisible(false);
				EmailTextField.setVisible(false);
				PasswordTextField.setVisible(false);
				//ClosePannelButton.setVisible(false);
			}
		});
		ClosePanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setSize(347, 662 );
				OpenPanelButton.setVisible(true);
				EmailTextField.setVisible(true);
				PasswordTextField.setVisible(true);
//				OpenPanelButton
			}
		});
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					Connector.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
 			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void getAllPicture() {
		for(int i=0;i<ss.size();i++) {
			//decode thanh chuoi byte tu dau
			
			
			try {
				
				File file = new File("/assets/" + ss.get(i).getMaSach() + ".jpg");
				
				if(!file.exists()) {
					
					FileOutputStream pic = new FileOutputStream("src/main/java/assets/" + ss.get(i).getMaSach() + ".jpg");
					System.out.println("aaaaaaaaaaaaaaaaaaaaa");
					pic.write(ss.get(i).getAnh());
					
					System.out.println("get picture "+i+" success");
				}
				
			} catch (Exception e) {
				 
				e.getStackTrace();
			}
		}
	}
}
