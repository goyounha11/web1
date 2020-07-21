package com.kwon.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// OracleDriver
// Java : url이 Oracle형태면 알아서 OracleDriver를 사용함
// JSP : 알아서 못함
public class DBManager {

	// 톰캣이 제공하는 ConnectionPool : 설정파일(META-INF/context.xml)
	// 미리 Connection객체를 몇 개 만들어 놓고
	// DB서버에 연결을 시도하면 만들어져 있는거 제공 => 빠름
	public static Connection connect() throws Exception {
		// META-INF/context.xml
		Context ctx = new InitialContext();

		// 튜브대여소
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/kwonPool");

		return ds.getConnection();
	}

	// DB서버에 연결을 시도하면 그 때 부터 연결시작 => 느림
	public static Connection connectOld() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.81:1521:xe";
		return DriverManager.getConnection(url, "kwon", "kwon");
	}

	// 역순으로 닫는 이유
	// rs -> pstmt -> con
	// con을 먼저 닫으면 pstmt를 닫지 못함
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
