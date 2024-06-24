package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import view.QuanLiMaSachChungPanel;

public class ActionForMaSachChung implements ActionListener{

	private QuanLiMaSachChungPanel msc;
	public ActionForMaSachChung(QuanLiMaSachChungPanel msc) {
		this.msc = msc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Thêm")) {
			msc.Them();
			msc.setDisableForEdit();
			msc.setEnableForAdd();
			msc.ClearInfo();
		}
		if(src.equals("Lưu")) {
			msc.Luu();
			msc.setDisableForEdit();
			msc.setEnableForAdd();
			msc.ClearInfo();

		}
		if(src.equals("Xóa")) {
			msc.Xoa();
			msc.setDisableForEdit();
			msc.setEnableForAdd();
			msc.ClearInfo();
		}
		if(src.equals("Clear")) {
			msc.setDisableForEdit();
			msc.setEnableForAdd();
			msc.ClearInfo();
		}
		if(src.equals("Tìm kiếm")) {
			msc.TimKiem();
			msc.setDisableForEdit();
			msc.setEnableForAdd();
			msc.ClearInfo();
		}
		if(src.equals("Reset")) {
			msc.Reset();
			msc.setDisableForEdit();
			msc.setEnableForAdd();
			msc.ClearInfo();
		}
		
		
		

		
	}

}
