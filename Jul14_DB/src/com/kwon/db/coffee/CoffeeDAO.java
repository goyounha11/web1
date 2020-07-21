package com.kwon.db.coffee;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.kwon.db.main.DBManager;
import com.kwon.db.main.DBManager2;
import com.kwon.db.main.DataSelector;

public class CoffeeDAO {
	private int allCoffeeCount;

	private static final CoffeeDAO CDAO = new CoffeeDAO();

	public CoffeeDAO() {
		// TODO Auto-generated constructor stub
	}

	public static CoffeeDAO getCdao() {
		return CDAO;
	}

	public void setAllCoffeeCount() {
		try {
			SqlSession ss = DBManager2.connect();
			allCoffeeCount = ss.selectOne("cm.getAllCoffeeCount");
			System.out.println(allCoffeeCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reg(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("euc-kr");
			String n = request.getParameter("name");
			int p = Integer.parseInt(request.getParameter("price"));

			Coffee2 c = new Coffee2(n, new BigDecimal(p));
			SqlSession ss = DBManager2.connect(); 
			if (ss.insert("cm.reg", c) == 1) {
				ss.commit();
				request.setAttribute("r", "Ŀ�� ��� ����");
				allCoffeeCount++;
				System.out.println(allCoffeeCount);
			} else {
				request.setAttribute("r", "Ŀ�� ��� ����");
			}
		} catch (Exception e) {
			request.setAttribute("r", "Ŀ�� ��� ����");
		}
	}

	public void getCoffee(int page, HttpServletRequest request) {
		try {
			int coffeePerPage = 7;
			int pageCount = (int) Math.ceil(allCoffeeCount / (double) coffeePerPage);
			request.setAttribute("pageCount", pageCount);
			int start = (page - 1) * coffeePerPage + 1;
			int end = (page == pageCount) ? allCoffeeCount : start + coffeePerPage - 1;
			
			DataSelector ds = new DataSelector(
					new BigDecimal(start), new BigDecimal(end));
			
			List<Coffee2> coffees
				= DBManager2.connect().selectList("cm.getCoffee", ds);
			
			request.setAttribute("coffees", coffees);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean getCoffeeInfo(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			// %2A  -utf-8->  ???
			String n = request.getParameter("name");
			
			System.out.println(n);
			// sql(�̿ϼ�)
			String sql = "select * from JUL15_COFFEE " + "where c_name = ?";

			// pstmt
			pstmt = con.prepareStatement(sql);

			// sql�ϼ�
			pstmt.setString(1, n);

			// ���� & ���� & ��� : select
			rs = pstmt.executeQuery();

			Coffee c = null;
			if (rs.next()) {
				c = new Coffee();
				c.setName(rs.getString("c_name"));
				c.setPrice(rs.getInt("c_price"));
				request.setAttribute("c", c);
				return true;
			}
			return false; // �̹� ���� ��������
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	// �ڵ��ϼ� �ƴ� �κ��� ��� ���� ������
	public void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			request.setCharacterEncoding("euc-kr");
			String n = request.getParameter("name");

			String sql = "delete from jul15_coffee where c_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "Ŀ�� ���� ����");
				allCoffeeCount--;
				System.out.println(allCoffeeCount);
			} else {
				request.setAttribute("r", "Ŀ�� ���� ����");
			}
		} catch (Exception e) {
			request.setAttribute("r", "Ŀ�� ���� ����");
		}
		DBManager.close(con, pstmt, null);
	}

	public void update(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String n = request.getParameter("name");
			int p = Integer.parseInt(request.getParameter("price"));

			String sql = "update jul15_coffee " 
					+ "set c_price = ? " 
					+ "where c_name = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p);
			pstmt.setString(2, n);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "Ŀ�� ���� ����");
			} else {
				request.setAttribute("r", "Ŀ�� ���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "Ŀ�� ���� ����");
		}
		DBManager.close(con, pstmt, null);
	}
}
