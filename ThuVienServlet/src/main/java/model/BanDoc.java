package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BanDoc {		/* sua khong con email */

	@Column(name = "MABANDOC")
	private String MaBanDoc ="" ;
	@Column(name = "TEN")
	private String Ten  ="";
	@Column(name = "EMAIL")
	private String Email="";
	@Column(name = "PASSWORD")
	private String Password ="";
	@Column(name = "SDT")
	private String Sdt="";
	@Column(name = "CHUCVU")
	private String ChucVu="";
	public BanDoc(String maBanDoc, String ten, String Email, String Password, String sdt, String chucVu) {
		super();
		this.MaBanDoc = maBanDoc;
		this.Ten = ten;
		this.Email = Email;
		this.Password = Password;
		this.Sdt = sdt;
		this.ChucVu = chucVu;
	}
	public BanDoc() {
		
	}

	/**
	 * @return the maBanDoc
	 */
	@Id
	public String getMaBanDoc() {
		return MaBanDoc;
	}
	/**
	 * @param maBanDoc the maBanDoc to set
	 */
	public void setMaBanDoc(String maBanDoc) {
		MaBanDoc = maBanDoc;
	}
	/**
	 * @return the ten
	 */
	public String getTen() {
		return Ten;
	}
	/**
	 * @param ten the ten to set
	 */
	public void setTen(String ten) {
		Ten = ten;
	}
	/**
	 * @return the Email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * @param Email the Email to set
	 */
	public void setEmail(String Email) {
		this.Email = Email;
	}
	/**
	 * @return the Password
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * @param Password the Password to set
	 */
	public void setPassword(String Password) {
		this.Password = Password;
	}
	/**
	 * @return the sdt
	 */
	public String getSdt() {
		return Sdt;
	}
	/**
	 * @param sdt the sdt to set
	 */
	public void setSdt(String sdt) {
		Sdt = sdt;
	}
	/**
	 * @return the chucVu
	 */
	public String getChucVu() {
		return ChucVu;
	}
	/**
	 * @param chucVu the chucVu to set
	 */
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	@Override
	public String toString() {
		return "BanDoc [MaBanDoc=" + MaBanDoc + ", Ten=" + Ten + ", Email=" + Email + ", Password=" + Password + ", Sdt="
				+ Sdt + ", ChucVu=" + ChucVu + "]";
	}
	
	
	
}