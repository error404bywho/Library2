package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Login;

public class ActionForLogin implements ActionListener {
	
	private Login lg;
	
	public ActionForLogin(Login lg) {
		this.lg = lg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
	}

}
