package view;

import java.util.ArrayList;
import model.Sach;
public class getData {
	ArrayList<Sach> ss;
	public getData(ArrayList<Sach> s) {
		ss=s;
		init();
	}
	private void init() {
		for(Sach sach : ss) 
			System.out.println(sach.toString());
	}
	

	
	
}
