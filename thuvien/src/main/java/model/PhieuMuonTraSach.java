package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class PhieuMuonTraSach {
	
	private String MaPhieuMuon;
	private String MaBanDoc;
	private String MaSach;
	private int    SoLuong;
	private Date   NgayMuon;
	private Date   HanTra;
	private Date   NgayTra;
	private String TinhTrang = "";


	public PhieuMuonTraSach(String maPhieuMuon, String maBanDoc, String maSach, int soLuong, Date ngayMuon,
			Date hanTra) {
		super();
		MaPhieuMuon = maPhieuMuon;
		MaBanDoc = maBanDoc;
		MaSach = maSach;
		SoLuong = soLuong;
		NgayMuon = ngayMuon;
		HanTra = hanTra;
	}
	public PhieuMuonTraSach(String maPhieuMuon, String maBanDoc, String maSach, int soLuong, Date ngayMuon, Date hanTra,
			Date ngayTra, String tinhTrang) {
		super();
		MaPhieuMuon = maPhieuMuon;
		MaBanDoc = maBanDoc;
		MaSach = maSach;
		SoLuong = soLuong;
		NgayMuon = ngayMuon;
		HanTra = hanTra;
		NgayTra = ngayTra;
		TinhTrang = tinhTrang;
	}
	public PhieuMuonTraSach() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	public String getMaPhieuMuon() {
		return MaPhieuMuon;
	}
	public void setMaPhieuMuon(String maPhieuMuon) {
		MaPhieuMuon = maPhieuMuon;
	}
	public String getMaBanDoc() {
		return MaBanDoc;
	}
	public void setMaBanDoc(String maBanDoc) {
		MaBanDoc = maBanDoc;
	}
	public String getMaSach() {
		return MaSach;
	}
	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public Date getNgayMuon() {
		return NgayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		NgayMuon = ngayMuon;
	}
	public Date getHanTra() {
		return HanTra;
	}
	public void setHanTra(Date hanTra) {
		HanTra = hanTra;
	}
	public Date getNgayTra() {
		return NgayTra;
	}
	public void setNgayTra(Date ngayTra) {
		NgayTra = ngayTra;
	}
	public String getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(String TinhTrang) {
		this.TinhTrang = TinhTrang;
	}
	@Override
	public String toString() {
		return "PhieuMuonSach [MaPhieuMuon=" + MaPhieuMuon + ", MaBanDoc=" + MaBanDoc + ", MaSach=" + MaSach
				+ ", SoLuong=" + SoLuong + ", NgayMuon=" + NgayMuon + ", HanTra=" + HanTra + ", NgayTra=" + NgayTra
				+ ", TinhTrang=" + TinhTrang + "]";
	}
	
	
}