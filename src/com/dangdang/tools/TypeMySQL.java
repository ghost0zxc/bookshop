package com.dangdang.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dangdang.dao.Conn;
import com.dangdang.object.Book;
import com.dangdang.object.BookType;

public class TypeMySQL {

	public static List<BookType> type() {
		Connection conn = Conn.getConn();
		List<BookType> list = new ArrayList<BookType>();

		String sql = "select * from type";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BookType bt = new BookType();
				bt.setId(rs.getInt(1));
				bt.setTypename(rs.getString(2));
				bt.setTypenum(rs.getInt(3));
				list.add(bt);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public static List<Book> book() {
		List<Book> blist = new ArrayList<Book>();
		Connection conn = Conn.getConn();

		String sql = "select * from book";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setBooktype(rs.getInt(3));
				b.setAuthor(rs.getString(4));
				b.setPress(rs.getString(5));
				b.setPrice(rs.getInt(6));
				b.setImage(rs.getString(7));
				b.setBriefintroduction(rs.getString(8));
				blist.add(b);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return blist;

	}

	public static List<Book> selectbook(int id) {
		List<Book> blist = new ArrayList<Book>();
		Connection conn = Conn.getConn();

		String sql = "select * from book where booktype=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setBooktype(rs.getInt(3));
				b.setAuthor(rs.getString(4));
				b.setPress(rs.getString(5));
				b.setPrice(rs.getInt(6));
				b.setImage(rs.getString(7));
				b.setBriefintroduction(rs.getString(8));
				blist.add(b);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return blist;
	}

	public static int getuserid(String username) {
		int id = 0;
		Connection conn = Conn.getConn();

		String sql = "select id from user where user=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public static List<Book> findbook(String name) {
		List<Book> blist = new ArrayList<Book>();
		Connection conn = Conn.getConn();

		// select * from book where bookname = %?%
		String sql = "select * from book where bookname like ? or author like ? or press like ? or briefintroduction like ?;";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ps.setString(2, "%" + name + "%");
			ps.setString(3, "%" + name + "%");
			ps.setString(4, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setBooktype(rs.getInt(3));
				b.setAuthor(rs.getString(4));
				b.setPress(rs.getString(5));
				b.setPrice(rs.getInt(6));
				b.setImage(rs.getString(7));
				b.setBriefintroduction(rs.getString(8));
				blist.add(b);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return blist;

	}
}
