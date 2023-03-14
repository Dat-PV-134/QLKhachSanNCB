package model;

public class TaiKhoan {
	String TenTK;
	String matKhau;
	
	public TaiKhoan() {
		super();
	}
	public TaiKhoan(String TenTK, String matKhau) {
		super();
		this.TenTK = TenTK;
		this.matKhau = matKhau;
	}
	
	public String getTenTK() {
		return TenTK;
	}
	public void setTenTK(String tenTK) {
		TenTK = tenTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
}
