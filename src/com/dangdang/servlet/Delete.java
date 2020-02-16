package com.dangdang.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.object.Book;
import com.dangdang.object.BookType;
import com.dangdang.tools.InsertMySQL;
import com.dangdang.tools.SelectMySQL;
import com.dangdang.tools.TypeMySQL;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		int userid = Integer.parseInt(request.getParameter("userid"));

		InsertMySQL.deleteCart(userid, bookid);
		List<com.dangdang.object.Cart> clist = new ArrayList<>();
		clist = SelectMySQL.cart(userid);
		request.setAttribute("clist", clist);
		List<Book> blist = new ArrayList<Book>();
		blist = TypeMySQL.book();
		request.setAttribute("blist", blist);

		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
