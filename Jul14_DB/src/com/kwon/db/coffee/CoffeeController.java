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

	// Ŀ�� ������ ó�� ���� ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CoffeeDAO.getCdao().getCoffee(1, request);
		request.setAttribute("contentPage", "coffee/bbs.jsp"); // �������� �Ἥ ������ �Ǵϱ� ���ϸ��� coffeeBBS.jsp�� �ʿ�� ����
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
