package com.dangdang.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dangdang.dao.Conn;

public class InsertMySQL {
	public static int register(String user, String password) {
		Connection conn = Conn.getConn();
		if (Check.check_jdbc(user, "password") != 0)
			return 0;
		String sql = "insert into user values(null,?,?,null,null,null,null) ;";
		int a = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, password);
			a = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	public static int insertCart(int userid, int bookid, int num) {
		Connection conn = Conn.getConn();

		String sql = "insert into shoppingcart values(null,?,?,?) ;";
		int a = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, bookid);
			ps.setInt(3, num);
			a = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;

	}

	public static int updateCart(int userid, int bookid, int num) {
		Connection conn = Conn.getConn();

		String sql = "UPDATE shoppingcart SET num=? WHERE userid = ? and bookid =?";
		int a = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num + 1);
			ps.setInt(2, userid);
			ps.setInt(3, bookid);
			a = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;

	}

	public static int deleteCart(int userid, int bookid) {
		Connection conn = Conn.getConn();

		String sql = "DELETE FROM shoppingcart WHERE userid = ? and bookid =?";
		int a = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, bookid);
			a = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;

	}
}
