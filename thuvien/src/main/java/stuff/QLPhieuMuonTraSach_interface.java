package stuff;

import java.util.ArrayList;

import model.PhieuMuonTraSach;

public interface QLPhieuMuonTraSach_interface<T> {

	public ArrayList<PhieuMuonTraSach> pmtss = new ArrayList<PhieuMuonTraSach>();

	public void Them(T t);

	public void Xoa(T t);
	
	public void ChinhSua(T t);

	public void Clear(T t);
	
	public void Save(T t);
	
	public void SapXepTheoMaPhieuMuon(T t);

	public void SapXepTheoMaNguoiMuon(T t);

	public void SapXepTheoNgayMuon(T t);

	public void SapXepTheoHanTra(T t);
}
