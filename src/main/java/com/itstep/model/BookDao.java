package com.itstep.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao {

	private static Connection getConnection () {
		Connection connect = null;
		String urlConnect = "jdbc:mysql://localhost:3306/db_name?useSSL=false";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(urlConnect, "username", "password");
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connect;
	}
	
	public static void saveBook() {
		PreparedStatement statement = null;
		Connection connect = getConnection();
		try {
			statement = connect.prepareStatement("INSERT INTO tbl_books VALUES(?, ?, ?)");
			int status = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
