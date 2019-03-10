package kr.or.connet.jdbcexam2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul";
	private static String dbuser = "connectuser";
	private static String dbpassword = "connect123!@#";

	public Connection getConn(){
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpassword);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public PreparedStatement getPs(Connection conn, String sql) {
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ps;
		
	}
	
	public ResultSet getRs(PreparedStatement ps) {
		ResultSet rs = null;
		
		try {
			rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
}
