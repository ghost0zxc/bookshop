package com.dangdang.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.tools.Check;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int a = 0;
		a = Check.check_jdbc(username, password);

		if (a > 0) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60 * 5);
			session.setAttribute("username", username);
			session.setAttribute("userid", a);
			RequestDispatcher rd = request.getRequestDispatcher("Type");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("forgetpassword.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
