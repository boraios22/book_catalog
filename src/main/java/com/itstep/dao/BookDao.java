package com.itstep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itstep.model.Book;

public class BookDao {
	
	private static Connection getConnection() {
		Connection connect = null;
		String urlConnect = "jdbc:mysql://localhost:3306/book_catalog?useSSL=false";
		String userName = "root";
		String password = "12345678aA";
		String driverClass = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driverClass);
			connect = DriverManager.getConnection(urlConnect, userName, password);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connect;
	}
	
	public static int saveBook(Book book) {
		String sql = "INSERT INTO tbl_books VALUES(?, ?, ?, ?, ?, ?)";
		Connection connect = getConnection();
		
		int status = 0;
		
		try {
			
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, book.getISBN());
			statement.setString(2, book.getTitle());
			statement.setString(3, book.getAuthor());
			statement.setString(4, book.getPublisher());
			statement.setInt(5, book.getYear());
			statement.setFloat(6, book.getPrice());
			
			status = statement.executeUpdate(); //0 failed, > 0 success
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {connect.close();} catch (SQLException e) {}
		}
		
		return status;
	}
	public static List<Book> getAllBooks() {
		String sql = "SELECT * FROM tbl_books";
		Connection connect = getConnection();
		
		List<Book> books = new ArrayList<Book>();
		ResultSet rs = null;
		try {
			
			Statement statement = connect.createStatement();
			rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Book book = new Book(
							rs.getString("ISBN"),
							rs.getString("title"),
							rs.getString("author"),
							rs.getString("publisher"),
							rs.getInt("year"),
							rs.getFloat("price")
						);
				
				books.add(book);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {connect.close();} catch (SQLException e) {}
			try {rs.close();} catch (SQLException e) {}
		}
		
		return books;
	}
}
