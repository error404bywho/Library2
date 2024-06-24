package ViewLogin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import action.ActionForLogin;
import dao.*;
public class Login extends JFrame{
	
	private JLabel JLAdmin;
	private JLabel JLUser;
	private JLabel JLPassword;
	private JTextField JTUser;
	private JTextField JTPassword;
	private JButton JBLogin;
	private JLabel JLLoginFalse;
	
	private Font font;
	
	private ActionForLogin ac;
	
	private loginDAO ldao;

	public Login() {
		
		ldao = new loginDAO();
		
		
		ac = new ActionForLogin(this);
		
		init();
		
		
		setVisible(true);
		
		
	}
	public void init() {
		
		setTitle("LOGIN");
		setSize(350,230);
		//setResizable(false);					//tranh phong to
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLAdmin = new JLabel("Admin");
		JLAdmin.setBounds(135, 0, 100, 50);
		font = new Font("nicolas", Font.ITALIC | Font.BOLD, 20);
		JLAdmin.setFont(font);
		add(JLAdmin);
		
		JLUser = new JLabel("User : ");
		JLUser.setBounds(70, 40, 110, 50);
		font = new Font("nicolas", Font.ITALIC | Font.BOLD, 20);
		JLUser.setFont(font);
		add(JLUser);
		
		JLPassword = new JLabel("Password : ");
		JLPassword.setBounds(20, 90, 120, 50);
		font = new Font("nicolas", Font.ITALIC | Font.BOLD, 20);
		JLPassword.setFont(font);
		add(JLPassword);
		
		JTUser = new JTextField();
		JTUser.setBounds(150, 50, 150, 30);
		font = new Font("nicolas", Font.ITALIC | Font.PLAIN, 20);
		JTUser.setFont(font);
		add(JTUser);
		
		JTPassword = new JTextField();
		JTPassword.setBounds(150,100,150,30);
		font = new Font("nicolas", Font.ITALIC | Font.PLAIN, 20);
		JTPassword.setFont(font);
		add(JTPassword);
		
		JBLogin = new JButton("Login");
		JBLogin.setBounds(100,150,150,30);
		font = new Font("nicolas", Font.ITALIC | Font.BOLD, 20);
		JBLogin.setFont(font);
		JBLogin.addActionListener(ac);
		add(JBLogin);
		
		
		//Wrong password or username
		JLLoginFalse = new JLabel("ERROR: Wrong password or username ! ");
		JLLoginFalse.setBounds(70, 130, 1000, 20);
		font = new Font("nicolas", Font.ITALIC | Font.BOLD, 10);
		JLLoginFalse.setFont(font);
		JLLoginFalse.setForeground(Color.RED);
		JLLoginFalse.setVisible(false);
		add(JLLoginFalse);
		
	//  JOptionPane.showMessageDialog(null, "sai tài khoảng hoặc mật khẩu !", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
		
	}	
	public void AccessDatabase() {
		
		String User = JTUser.getText();
		String Password = JTPassword.getText();
		System.out.println(User + "      " + Password);
		boolean check = ldao.Login(User, Password);
		if(check == false )
			JLLoginFalse.setVisible(true);
		else {
			JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULLY", "LOGIN",JOptionPane.PLAIN_MESSAGE);
			setVisible(false);
			new QuanLiThuVien();
		}
	}

	
}
