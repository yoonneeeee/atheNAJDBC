package com.kh.jdbc.day04.pstmt.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 연결의 역할을 위임할 예정
public class JDBCTemplate_Old {
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "ATHENAJDBC";
	private static final String PASSWORD = "ATHENAJDBC";
	
	private static Connection conn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(conn == null||conn.isClosed()) {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		return conn;
	}
}
