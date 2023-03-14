package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.HoaDon;

public class HoaDonDao {
	
	public int InsertHoaDon(HoaDon hd) {
		int kt = 0;
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql ="INSERT INTO HoaDon VALUES ('" + hd.getSoPhong() + "', " + hd.getMaKH() + ", '" + hd.getNgayDat() + "', '" + hd.getNgayTra() + "', " + hd.getThanhTien() + ", N'" + hd.getGhiChu() + "')";
			kt = st.executeUpdate(sql);
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kt;
	}
	
	public ArrayList<HoaDon> SelectAllHoaDon(){
		ArrayList<HoaDon> dshd= new ArrayList<HoaDon>();
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM HoaDon";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				HoaDon hoaDon = new HoaDon(rs.getInt("MaHD"), rs.getString("SoPhong"), rs.getInt("MaKH"), rs.getString("NgayDat"), rs.getString("NgayTra"), rs.getDouble("ThanhTien"), rs.getString("GhiChu"));
				dshd.add(hoaDon);
				
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dshd;
	}
	
	public HoaDon SelectHoaDonByID(int ID) {
		HoaDon hoaDon = null;
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM HoaDon WHERE MaHD = " + ID;
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				hoaDon = new HoaDon(rs.getInt("MaHD"), rs.getString("SoPhong"), rs.getInt("MaKH"), rs.getString("NgayDat"), rs.getString("NgayTra"), rs.getDouble("ThanhTien"), rs.getString("GhiChu"));
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return hoaDon;
	}
	
	public ArrayList<HoaDon> SelectHoaDonByIDSoPhong(int ID, String sp) {
		ArrayList<HoaDon> dshoaDon = new ArrayList<HoaDon>();
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM HoaDon WHERE MaHD = " + ID + " OR SoPhong = '" + sp + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				HoaDon hoaDon = new HoaDon(rs.getInt("MaHD"), rs.getString("SoPhong"), rs.getInt("MaKH"), rs.getString("NgayDat"), rs.getString("NgayTra"), rs.getDouble("ThanhTien"), rs.getString("GhiChu"));
				dshoaDon.add(hoaDon);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dshoaDon;
	}
	
	public int CapNhatGhiChu(int ID) {
		int kt = 0;
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "UPDATE HoaDon SET GhiChu = N'Đã thanh toán' WHERE MaHD = " + ID;
			kt = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kt;
	}

}
