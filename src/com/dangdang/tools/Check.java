package com.dangdang.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dangdang.dao.Conn;

public class Check {

	public static int check_jdbc(String username, String password) {
		Connection conn = Conn.getConn();
		String db_pass = null;
		String sql = "select * from user where user =?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				db_pass = rs.getString(3);
				if (password.equals(db_pass)) {
					int a = rs.getInt(1);
					conn.close();
					return a;
				} else
					return -1;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int check_cart(int userid, int bookid) {
		int num = 0;
		Connection conn = Conn.getConn();
		String sql = "select * from shoppingcart where userid =? and bookid =?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, bookid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				num = rs.getInt(3);
				return num;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
