package stuff;

import java.util.ArrayList;

import model.MaSachChung;

public interface QLMaSachChung_interface<T> {
	
	public ArrayList<MaSachChung> mscs = new ArrayList<MaSachChung>();

	public void Them(T t);

	public void Xoa(T t);
	
	public void ChinhSua(T t);

	public void Clear(T t);
	
	public void Save(T t);
	
	public void SapXepTheoMaSachChung(T t);

	public void SapXepTheoTenSach(T t);

	public void SapXepTheoTheLoai(T t);

	public void SapXepTheoNamXuatBan(T t);

}
