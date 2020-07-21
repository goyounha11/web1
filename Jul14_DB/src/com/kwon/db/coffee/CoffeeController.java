package com.kwon.db.coffee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CoffeeController")
public class CoffeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 커피 페이지 처음 들어올 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CoffeeDAO.getCdao().getCoffee(1, request);
		request.setAttribute("contentPage", "coffee/bbs.jsp"); // 폴더명을 써서 구별이 되니까 파일명이 coffeeBBS.jsp일 필요는 없음
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
