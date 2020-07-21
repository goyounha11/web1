package com.kwon.db.coffee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CoffeeInfoController")
public class CoffeeInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (CoffeeDAO.getCdao().getCoffeeInfo(request)) {
			request.setAttribute("contentPage", "coffee/info.jsp");
		} else {
			CoffeeDAO.getCdao().getCoffee(1, request);
			request.setAttribute("contentPage", "coffee/bbs.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}



