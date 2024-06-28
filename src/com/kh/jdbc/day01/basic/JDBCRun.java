package com.kh.jdbc.day01.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCRun {
	public static void main(String[] args) {
/*
 * JDBC 코딩 절차
 * 1. 드라이버 등록		(jar)
 * 2. DBMS 연결 생성	(KH/KH 확인)
 * 3. Statement 객체 생성	(워크시트, 쿼리문 실행 준비)
 * 4. SQL 전송				(CTRL+ENTER)
 * 5. 결과 받기				(ResultSet)
 * 6. 자원 해제
 * */
		try {			
			// 1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DBMS 연결 생성
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KH", "KH");
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM DEPARTMENT";
			// 4. SQL 전송, 5. 결과 받기
			ResultSet rset = stmt.executeQuery(query);
			// 후처리
			while(rset.next()) { 				// 다음 값이 있는 지 체크
				System.out.println("부서명 : " + rset.getString("DEPT_TITLE")); //컬럼명 오타 없이 적기
			}
			// 6. 자원해제
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
