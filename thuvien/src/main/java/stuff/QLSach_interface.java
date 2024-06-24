package stuff;

import java.util.ArrayList;

import model.Sach;

public interface QLSach_interface<T> {

	public ArrayList<Sach> s = new ArrayList<Sach>();

	public void Them(T t);

	public void Xoa(T t);
	
	public void ChinhSua(T t);

	public void Clear(T t);

	public void Save(T t);
	
	public void SapXepTheoHanMuon(T t);

	public void TimTheoMaSach(T t);

	public void TimTheoTenSach(T t);

	public void SapXepTheoTheLoai(T t);


}
