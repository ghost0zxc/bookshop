package com.dangdang.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dangdang.dao.Conn;
import com.dangdang.object.Cart;

public class SelectMySQL {
	public static List<com.dangdang.object.Cart> cart(int userid) {
		List<Cart> list = new ArrayList<Cart>();
		Connection conn = Conn.getConn();
		String sql = "select * from shoppingcart";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart c = new Cart();
				c.setId(rs.getInt(1));
				c.setUserid(rs.getInt(2));
				c.setBookid(rs.getInt(3));
				c.setNum(rs.getInt(4));
				list.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
