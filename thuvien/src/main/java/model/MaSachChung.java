 	package model;

public class MaSachChung {
	private String MaSachChung;
	private String TenSach;
	private int    SoLuong;
	private String TheLoai;
	private String TacGia;
	private String NhaXuatBan;
	private String NamXuatBan;
	public MaSachChung() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MaSachChung(String maSachChung, String tenSach, int soLuong, String theLoai, String tacGia,
			String nhaXuatBan, String namXuatBan) {
		super();
		MaSachChung = maSachChung;
		TenSach     = tenSach;
		SoLuong     = soLuong;
		TheLoai     = theLoai;
		TacGia      = tacGia;
		NhaXuatBan  = nhaXuatBan;
		NamXuatBan  = namXuatBan;
	}
	public String getMaSachChung() {
		return MaSachChung;
	}
	public void setMaSachChung(String maSachChung) {
		MaSachChung = maSachChung;
	}
	public String getTenSach() {
		return TenSach;
	}
	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public String getTheLoai() {
		return TheLoai;
	}
	public void setTheLoai(String theLoai) {
		TheLoai = theLoai;
	}
	public String getTacGia() {
		return TacGia;
	}
	public void setTacGia(String tacGia) {
		TacGia = tacGia;
	}
	public String getNhaXuatBan() {
		return NhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		NhaXuatBan = nhaXuatBan;
	}
	public String getNamXuatBan() {
		return NamXuatBan;
	}
	public void setNamXuatBan(String namXuatBan) {
		NamXuatBan = namXuatBan;
	}
	@Override
	public String toString() {
		return "MaSachChung [MaSachChung=" + MaSachChung + ", TenSach=" + TenSach + ", SoLuong=" + SoLuong
				+ ", TheLoai=" + TheLoai + ", TacGia=" + TacGia + ", NhaXuatBan=" + NhaXuatBan + ", NamXuatBan="
				+ NamXuatBan + "]";
	}
}
	