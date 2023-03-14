package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn = null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLKhachSan;user=sa;password=1234567@;encrypt=false");
				} catch (ClassNotFoundException  | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}						
		return conn;
	}
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}  
	public static void main(String[] args) {
		System.out.println(JDBCUtil.getConnection());
	}
}
