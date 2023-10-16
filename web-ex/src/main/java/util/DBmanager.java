package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;

public class DBmanager {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/web_ex";
			String user = "root";
			String password = "root";
			
			conn = DriverManager.getConnection(url,user,password);
			
			System.out.println("연결 성공");
		} catch (Exception e) {
			System.out.println("연결 실패");
		}
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement pstat) {
		try {
			conn.close();
			pstat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn,PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.cancel();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
