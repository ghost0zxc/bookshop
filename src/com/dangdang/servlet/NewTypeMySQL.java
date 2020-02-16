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
import com.dangdang.tools.TypeMySQL;

public class NewTypeMySQL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<BookType> list = new ArrayList<BookType>();
		List<Book> blist = new ArrayList<Book>();
		list = TypeMySQL.type();
		blist = TypeMySQL.selectbook(id);
		request.setAttribute("typelist", list);
		request.setAttribute("booklist", blist);
		request.setAttribute("username", request.getAttribute("username"));
		RequestDispatcher rd = request.getRequestDispatcher("page01.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
