package model;

public class NhanVien {
	String maNV;
	String tenNV;
	String gioiTinh;
	String diaChi;
	String SDT;
	String caLam;
	double Luong;
	int soNgayNghi;
	String tinhTrang;	
	public NhanVien() {
		super();
	}
	public NhanVien(String maNV, String tenNV, String gioiTinh, String diaChi, String sDT, String caLam, double luong,
			int soNgayNghi, String tinhTrang) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		SDT = sDT;
		this.caLam = caLam;
		Luong = luong;
		this.soNgayNghi = soNgayNghi;
		this.tinhTrang = tinhTrang;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTeNNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getCaLam() {
		return caLam;
	}
	public void setCaLam(String caLam) {
		this.caLam = caLam;
	}
	public double getLuong() {
		return Luong;
	}
	public void setLuong(double luong) {
		Luong = luong;
	}
	public int getSoNgayNghi() {
		return soNgayNghi;
	}
	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	
	
	
}
