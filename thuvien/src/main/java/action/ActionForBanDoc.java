package action;

import model.BanDoc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import view.QuanLiBanDocPanel;

public class ActionForBanDoc implements ActionListener{

	private QuanLiBanDocPanel bd;
	public ActionForBanDoc(QuanLiBanDocPanel bd) {
		this.bd = bd;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Thêm")) {
			bd.Them();
			//new QuanLiBanDocPanel();
		}
		if(src.equals("Lưu")) {
			bd.setDisableForEdit();
			bd.setEnableForAdd();
			bd.Luu();
			bd.ClearInfo();

		}
		if(src.equals("Xóa")) {
			bd.setDisableForEdit();
			bd.setEnableForAdd();
			bd.Xoa();
			bd.ClearInfo();
		}
		if(src.equals("Clear")) {
			bd.setDisableForEdit();
			bd.setEnableForAdd();
			bd.ClearInfo();
		}
		if(src.equals("Tìm kiếm")) {
			bd.TimKiem();
			bd.setDisableForEdit();
			bd.setEnableForAdd();
			bd.ClearInfo();
		}
		if(src.equals("Reset")) {
			bd.Reset();
			bd.setDisableForEdit();
			bd.setEnableForAdd();
			bd.ClearInfo();
		}
//		if(src.equals("Reset")) {
//			bd.Reset();
//		}
		
	}

}
