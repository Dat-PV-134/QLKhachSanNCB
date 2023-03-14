package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;


import model.TaiKhoan;

public class TaiKhoanDao {
	public static TaiKhoanDao getInstance() {
		return new TaiKhoanDao();
	}
	public ArrayList<TaiKhoan> SelectAll() {
		ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
		try {
			Connection conn = JDBCUtil.getConnection();
			
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM TaiKhoan";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				TaiKhoan taiKhoan = new TaiKhoan(rs.getString("TenTK").trim(), rs.getString("MatKhau").trim());
				dstk.add(taiKhoan);
			}
			JDBCUtil.closeConnection(conn);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dstk;
	}
}
