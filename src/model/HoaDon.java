package model;

public class HoaDon {

	private int soHD;
	private String soPhong;
	private String ngayDat;
	private String ngayTra;
	private String ghiChu;
	private double thanhTien;
	private int maKH;
	
	
	public HoaDon() {
		
	}
	


	public HoaDon(int soHD, String soPhong, int maKH, String ngayDat, String ngayTra, double thanhTien, String ghiChu) {
		super();
		this.soHD = soHD;
		this.soPhong = soPhong;
		this.ngayDat = ngayDat;
		this.ngayTra = ngayTra;
		this.ghiChu = ghiChu;
		this.thanhTien = thanhTien;
		this.maKH = maKH;
	}




	public HoaDon(int soHD, String soPhong, String ngayTra, double thanhTien, String ghiChu) {
		super();
		this.soHD = soHD;
		this.soPhong = soPhong;
		this.ngayTra = ngayTra;
		this.ghiChu = ghiChu;
		this.thanhTien = thanhTien;
	}


	public int getSoHD() {
		return soHD;
	}


	public void setSoHD(int soHD) {
		this.soHD = soHD;
	}


	public String getSoPhong() {
		return soPhong;
	}


	public void setSoPhong(String soPhong) {
		this.soPhong = soPhong;
	}


	public String getNgayTra() {
		return ngayTra;
	}


	public void setNgayTra(String ngayTra) {
		this.ngayTra = ngayTra;
	}


	public String getGhiChu() {
		return ghiChu;
	}


	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}


	public double getThanhTien() {
		return thanhTien;
	}


	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
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
		return "HoaDon [soHD=" + soHD + ", soPhong=" + soPhong + ", ngayTra=" + ngayTra + ", ghiChu=" + ghiChu
				+ ", thanhTien=" + thanhTien + "]";
	}
	
	
}
