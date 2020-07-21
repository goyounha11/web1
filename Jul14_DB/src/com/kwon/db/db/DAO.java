package com.kwon.db.db;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import com.kwon.db.main.DBManager;

public class DAO {
	public static void connectTest(HttpServletRequest request) {
		Connection con = null;
		try {
			con = DBManager.connect();
			System.out.println("¼º°ø");
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBManager.close(con, null, null);
	}

}
