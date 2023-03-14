package model;

public class KhachHang {
	private int maKH;
	private String tenKH;
	private String gioiTinh;
	private String CCCD;
	private String diaChi;
	private String SDT;
	private String ngaySinh;
	
	public KhachHang() {
		
	}
	
	public KhachHang(int maKH, String tenKH, String gioiTinh, String cCCD, String diaChi, String sDT, String ngaySinh) {
		
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		this.CCCD = cCCD;
		this.diaChi = diaChi;
		this.SDT = sDT;
		this.ngaySinh = ngaySinh;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
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

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", CCCD=" + CCCD
				+ ", diaChi=" + diaChi + ", SDT=" + SDT + ", ngaySinh=" + ngaySinh + "]";
	}
	
	
	
	
}
