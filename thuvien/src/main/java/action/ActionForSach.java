package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.sachDAO;
import view.QuanLiMaSachChungPanel;
import view.QuanLiSachPanel;

public class ActionForSach implements ActionListener{

	private QuanLiSachPanel s;
	
	public ActionForSach(QuanLiSachPanel s) {
		this.s = s;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		
		if(src.equals("Thêm")) {
			s.Them();
			//new QuanLiBanDocPanel();
		}
		if(src.equals("Lưu")) {
			s.setDisableForEdit();
			s.setEnableForAdd();
			s.Luu();
			s.ClearInfo();

		}
		if(src.equals("Xóa")) {
			s.Xoa();
			s.setDisableForEdit();
			s.setEnableForAdd();
			s.ClearInfo();
		}
		if(src.equals("Clear")) {
			s.setDisableForEdit();
			s.setEnableForAdd();
			s.ClearInfo();
		}
		if(src.equals("Tìm kiếm")) {
			s.TimKiem();
			s.setDisableForEdit();
			s.setEnableForAdd();
			s.ClearInfo();
		}
		if(src.equals("Reset")) {
			s.Reset();
			s.setDisableForEdit();
			s.setEnableForAdd();
			s.ClearInfo();
		}
		
	}

}
