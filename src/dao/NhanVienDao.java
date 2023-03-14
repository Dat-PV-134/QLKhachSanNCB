package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.NhanVien;



public class NhanVienDao {
	public static NhanVienDao getInstance() {
		return new NhanVienDao();
	}
	public int insert(NhanVien t)  {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();
			
			//Bước 2: tạo đối tượng statement
			Statement st = conn.createStatement();
			
			//Bước 3: thực thi câu lệnh sql
			String sql = "INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, DiaChi, SDT, CaLam, Luong, SoNgayNghi, TinhTrang)"
					+"VALUES ('"+t.getMaNV()+"' , N'" + t.getTenNV()+"' , N'" +t.getGioiTinh()+"' , N'"+t.getDiaChi()+"' , '"+t.getSDT()+"', N'"
							+ t.getCaLam()+"' , "+ t.getLuong() + ", " + t.getSoNgayNghi() + ",N'" + t.getTinhTrang()+"')";
			
			
			
			 ketQua = st.executeUpdate(sql);
			
			// Bước 4: Xử lý kết quả			
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + "dòng bị thay đổi!");
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return ketQua;
	}
	public int delete(NhanVien t)  {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();
			
			//Bước 2: tạo đối tượng statement
			Statement st = conn.createStatement();
			
			//Bước 3: thực thi câu lệnh sql
			String sql = "Delete NhanVien where MaNV = '" + t.getMaNV()+ "'";
			
			
			
			 ketQua = st.executeUpdate(sql);
			
			// Bước 4: Xử lý kết quả			
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + "dòng bị thay đổi!");
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return ketQua;
	}
	public int update(NhanVien t) {
		int ketQua = 0;
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();
			
			//Bước 2: tạo đối tượng statement
			Statement st = conn.createStatement();
			
			//Bước 3: thực thi câu lệnh sql
			String sql = "UPDATE NhanVien SET TenNV = N'" + t.getTenNV() + "', GioiTinh = N'" + t.getGioiTinh() + "', DiaChi = N'" + t.getDiaChi() +"', SDT = N'"+ t.getSDT() 
					+ "', CaLam = N'" +t.getCaLam()+"', Luong = " + t.getLuong()+ ", SoNgayNghi = " + t.getSoNgayNghi() + ", TinhTrang = N'" + t.getTinhTrang()+"' WHERE MaNV = '" + t.getMaNV()+"'";
			
			
			
			 ketQua = st.executeUpdate(sql);
			
			// Bước 4: Xử lý kết quả			
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + "dòng bị thay đổi!");
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;	
	}
	public NhanVien SelectedByID(String t) {
		// TODO Auto-generated method stub
		NhanVien ketQua = null;
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();
			
			//Bước 2: tạo đối tượng statement
			Statement st = conn.createStatement();
			
			//Bước 3: thực thi câu lệnh sql
			String sql = "Select * from NhanVien where MaNV = '" + t+ "'";
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String tenNV = rs.getString("TenNV");
				String gioiTinh = rs.getString("GioiTinh");
				String diaChi = rs.getString("DiaChi");
				String sdt = rs.getString("SDT");
				String caLam = rs.getString("CaLam");
				double luong = rs.getDouble("Luong");
				int soNgayNghi = rs.getInt("SoNgayNghi");
				String tinhTrang = rs.getString("TinhTrang");
				ketQua = new NhanVien(maNV, tenNV, gioiTinh, diaChi, sdt, caLam, luong, soNgayNghi, tinhTrang);
			}
			
			// Bước 4: Xử lý kết quả			
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + "dòng bị thay đổi!");
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;	
	}
	public ArrayList<NhanVien> timKiemTheoMaHoacTen(String con2) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "Select * from NhanVien where TenNV like N'%" + con2 + "%'"  ;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(5);
				NhanVien nv = new NhanVien(rs.getString("MaNV").trim(), rs.getString("TenNV").trim(), rs.getString("GioiTinh").trim(), rs.getString("DiaChi").trim(), rs.getString("SDT").trim(), rs.getString("CaLam").trim(), rs.getDouble("Luong"), rs.getInt("SoNgayNghi"), rs.getString("TinhTrang"));
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	
	public ArrayList<NhanVien> SelectAll() {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "Select * from NhanVien";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				NhanVien nv = new NhanVien(rs.getString("MaNV").trim(), rs.getString("TenNV").trim(), rs.getString("GioiTinh").trim(), rs.getString("DiaChi").trim(), rs.getString("SDT").trim(), rs.getString("CaLam").trim(), rs.getDouble("Luong"), rs.getInt("SoNgayNghi"), rs.getString("TinhTrang"));
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
}
