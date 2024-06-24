package model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sach {
	private String MaSachChung;
	private String MaSach;
	private String TenSach;
	private String TheLoai;
	private String TacGia;
	private String TrangThai ;
	private byte[] Anh;
	
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sach(String maSachChung, String maSach, String tenSach, String theLoai, String tacGia, String trangThai,
			byte[] anh) {
		super();
		MaSachChung = maSachChung;
		MaSach = maSach;
		TenSach = tenSach;
		TheLoai = theLoai;
		TacGia = tacGia;
		TrangThai = trangThai;
		Anh = anh;
	}
	public Sach(String maSachChung, String maSach, String tenSach, String theLoai, String tacGia, String trangThai) {
		super();
		MaSachChung = maSachChung;
		MaSach = maSach;
		TenSach = tenSach;
		TheLoai = theLoai;
		TacGia = tacGia;
		TrangThai = trangThai;
	}
	public String getMaSachChung() {
		return MaSachChung;
	}
	public void setMaSachChung(String maSachChung) {
		MaSachChung = maSachChung;
	}
	@Id
	public String getMaSach() {
		return MaSach;
	}
	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	public String getTenSach() {
		return TenSach;
	}
	public void setTenSach(String tenSach) {
		TenSach = tenSach;
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
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	public byte[] getAnh() {
		return Anh;
	}
	public void setAnh(byte[] anh) {
		Anh = anh;
	}
	@Override
	public String toString() {
		return "Sach [MaSachChung=" + MaSachChung + ", MaSach=" + MaSach + ", TenSach=" + TenSach + ", TheLoai="
				+ TheLoai + ", TacGia=" + TacGia + ", TrangThai=" + TrangThai + ", Anh=" + Arrays.toString(Anh) + "]";
	}
}