package com.kwon.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// OracleDriver
// Java : url�� Oracle���¸� �˾Ƽ� OracleDriver�� �����
// JSP : �˾Ƽ� ����
public class DBManager {

	// ��Ĺ�� �����ϴ� ConnectionPool : ��������(META-INF/context.xml)
	// �̸� Connection��ü�� �� �� ����� ����
	// DB������ ������ �õ��ϸ� ������� �ִ°� ���� => ����
	public static Connection connect() throws Exception {
		// META-INF/context.xml
		Context ctx = new InitialContext();

		// Ʃ��뿩��
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/kwonPool");

		return ds.getConnection();
	}

	// DB������ ������ �õ��ϸ� �� �� ���� ������� => ����
	public static Connection connectOld() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.81:1521:xe";
		return DriverManager.getConnection(url, "kwon", "kwon");
	}

	// �������� �ݴ� ����
	// rs -> pstmt -> con
	// con�� ���� ������ pstmt�� ���� ����
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
