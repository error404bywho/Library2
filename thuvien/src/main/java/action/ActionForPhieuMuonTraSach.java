package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QuanLiMaSachChungPanel;
import view.QuanLiPhieuMuonTraSachPanel;
import view.QuanLiSachPanel;

public class ActionForPhieuMuonTraSach implements ActionListener{

	private QuanLiPhieuMuonTraSachPanel mts;
	public ActionForPhieuMuonTraSach(QuanLiPhieuMuonTraSachPanel mts) {
		this.mts = mts;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Thêm")) {
			mts.Them();
			//new QuanLiBanDocPanel();
		}
		if(src.equals("Lưu")) {
			mts.Luu();
			mts.setDisableForEdit();
			mts.setEnableForAdd();
//			mts.ClearInfo();

		}
		if(src.equals("Xóa")) {
			mts.Xoa();
			mts.setDisableForEdit();
			mts.setEnableForAdd();
//			mts.ClearInfo();
		}
		if(src.equals("Clear")) {
			mts.setDisableForEdit();
			mts.setEnableForAdd();
			mts.ClearInfo();
		}
		if(src.equals("Tìm kiếm")) {
			mts.TimKiem();
			mts.setDisableForEdit();
			mts.setEnableForAdd();
			mts.ClearInfo();
		}
		if(src.equals("Reset")) {
			mts.Reset();
			mts.setDisableForEdit();
			mts.setEnableForAdd();
			mts.ClearInfo();
		}
		if(src.equals("Trả sách")) {
			mts.TraSach();
			mts.setDisableForEdit();
			mts.setEnableForAdd();
//			mts.ClearInfo();
		}
	}

}
