package com.dangdang.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.object.Book;
import com.dangdang.tools.Check;
import com.dangdang.tools.InsertMySQL;
import com.dangdang.tools.SelectMySQL;
import com.dangdang.tools.TypeMySQL;

public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null)
			response.sendRedirect("Start");
		int bookid = Integer.parseInt(request.getParameter("id"));
		String username = (String) session.getAttribute("username");
		int userid = TypeMySQL.getuserid(username);
		int num = 0, f = 0;
		num = Check.check_cart(userid, bookid);
		if (num > 0)
			f = 1;
		else
			f = InsertMySQL.insertCart(userid, bookid, 1);
		if (f == 1) {

			List<com.dangdang.object.Cart> clist = new ArrayList<>();
			clist = SelectMySQL.cart(userid);
			request.setAttribute("clist", clist);
			List<Book> blist = new ArrayList<Book>();

			blist = TypeMySQL.book();

			request.setAttribute("blist", blist);
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("Type");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
