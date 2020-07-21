
package com.kwon.db.coffee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CoffeeRegController")
public class CoffeeRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 등록하러 올 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("contentPage", "coffee/reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	// 등록하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CoffeeDAO.getCdao().reg(request);
		CoffeeDAO.getCdao().getCoffee(1, request);
		request.setAttribute("contentPage", "coffee/bbs.jsp"); // 다시 등록 페이지로 or 게시판(나는 이걸로)으로
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
