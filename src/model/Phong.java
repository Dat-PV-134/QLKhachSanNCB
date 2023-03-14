package model;

public class Phong {
	

	private String soPhong;
	private double giaPhong;
	private String tinhTrang;
	private int maKH;
	private String ngayDat;
	
	public Phong() {
		
	}
	
	public Phong(String soPhong, double giaPhong, String tinhTrang, int maKH, String ngayDat) {
		this.soPhong = soPhong;
		this.giaPhong = giaPhong;
		this.tinhTrang = tinhTrang;
		this.maKH = maKH;
		this.ngayDat = ngayDat;
	}

	public String getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(String soPhong) {
		this.soPhong = soPhong;
	}

	public double getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}
	
	@Override
	public String toString() {
		return "Phong [soPhong=" + soPhong + ", giaPhong=" + giaPhong + ", tinhTrang=" + tinhTrang + ", maKH=" + maKH
				+ ", ngayDat=" + ngayDat + "]";
	}
	
	

}
