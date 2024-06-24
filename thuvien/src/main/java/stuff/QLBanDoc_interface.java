package stuff;

import java.util.ArrayList;

import model.BanDoc;

public interface QLBanDoc_interface<T> {

	public ArrayList<BanDoc> bds = new ArrayList<BanDoc>();

	public void Them(T t);

	public void Xoa(T t);
	
	public void ChinhSua(T t);

	public void Clear(T t);

	public void Save(T t);
	
	public void SapXepTheoMaNguoiDung(T t);

	public void SapXepTheoTenBanDoc(T t);

}
