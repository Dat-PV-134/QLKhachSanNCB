package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;
import model.Phong;

public class PhongDao {
	// Code cua Dat
	public static PhongDao getInstance() {
		return new PhongDao();
	}
	
	public Phong selectBySoPhong(String soPhong) {
		Phong phong = null;
		try {
			Connection conn = JDBCUtil.getConnection();	
			Statement st = conn.createStatement();
			
			String query = "SELECT * FROM Phong WHERE SoPhong = " + "'" + soPhong + "'";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			phong = new Phong(rs.getString("SoPhong").trim(), rs.getDouble("GiaPhong"), rs.getString("TinhTrang").trim(), rs.getInt("MaKH"), rs.getString("NgayDat").trim());
			JDBCUtil.closeConnection(conn);
		} catch (Exception e) {
			
		}
		return phong;
	}
	
	public int update(Phong phong, int maKhach) {
		int kt = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			Statement st = conn.createStatement();
			
			String query = "UPDATE Phong SET TinhTrang = N'Đã đặt', MaKH = " + maKhach + ", NgayDat = '" + phong.getNgayDat() + "'" + "WHERE SoPhong = '" + phong.getSoPhong() + "'";
			kt = st.executeUpdate(query);
			JDBCUtil.closeConnection(conn);
		} catch (Exception e) {
			
		}
		return kt;
	}
	
	//Code cua Dai
	public Phong SelectPhongByID(String ID) {
		Phong phong = null;
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM Phong WHERE SoPhong = '" + ID + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				phong = new Phong(rs.getString("SoPhong"), rs.getDouble("GiaPhong"), rs.getString("TinhTrang"), rs.getInt("MaKH"), rs.getString("NgayDat"));

			}
			JDBCUtil.closeConnection(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phong;
	}
	
	public int UpdatePhong(Phong p) {
		int kt = 0;
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "UPDATE Phong SET TinhTrang = N'" + p.getTinhTrang() + "', MaKH = " + null + ", NgayDat = null WHERE SoPhong = '" + p.getSoPhong() + "'";
			kt = st.executeUpdate(sql);
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kt;
	}

}
