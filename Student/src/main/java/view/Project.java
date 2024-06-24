package view;

import javax.swing.UIManager;

public class Project {
	public static void main(String[] args) {
		try {
			String src = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
			UIManager.setLookAndFeel(src);
			Login window = new Login();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
