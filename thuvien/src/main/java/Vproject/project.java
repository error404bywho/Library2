package Vproject;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ViewLogin.*;

public class project {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try { 
		
		String src = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
		UIManager.setLookAndFeel(src);
		Login l = new Login();
	} catch (UnsupportedLookAndFeelException e) {
		e.printStackTrace();
	}
}
}
