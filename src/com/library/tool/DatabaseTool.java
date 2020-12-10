package com.library.tool;

import java.sql.*;

/**
 * get connect to mysql
 * @author MSI-NB
 */
public class DatabaseTool {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL&allowPublicKeyRetrieval=true";
	private static final String user="root";
	private static final String password="123456";
	public static Connection getConn() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}