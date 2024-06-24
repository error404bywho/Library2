package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ViewLogin.Login;

public class ActionForLogin implements ActionListener{

	private Login login;
	public ActionForLogin(Login login) {
		this.login = login;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Login")) {
			System.out.println("BAN DA NHAN LOGIN");
			login.AccessDatabase();
		}
		
		
	}

}
