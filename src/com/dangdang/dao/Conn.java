package com.dangdang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

	public static Connection getConn() {
		Connection conn = null;
		String user = "root";
		String password = "970116";
		String url = "jdbc:mysql://localhost:3306/dangdang?characterEncoding=utf-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
