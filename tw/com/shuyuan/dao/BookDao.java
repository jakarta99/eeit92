package tw.com.shuyuan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import tw.com.shuyuan.entity.Book;

public class BookDao {
	private String URL = "jdbc:sqlserver://softleader.com.tw:1433;databaseName=EEIT92DB;";
	private String USER = "EEIT92";
	private String PASSWORD = "EEIT92";
	private String Find_BY_ID = "select * from book_shuyuan where id=?";
	private String Find_ALL = "select * from book_shuyuan";

	public Collection<Book> findAll() {
		Collection<Book> books = null;
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();) {
			rs = stmt.executeQuery(Find_ALL);
			if (!rs.wasNull()) {
				books = new ArrayList<Book>();
				while (rs.next()) {
					Book book = new Book();
					book.setId(rs.getLong(1));
					book.setIsbn_book(rs.getString(2));
					book.setName(rs.getString(3));
					book.setPrice(rs.getInt(4));
					books.add(book);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return books;
	}

	public Book findById(long id) {
		Book book = null;
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(Find_BY_ID);) {
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setId(rs.getLong(1));
				book.setIsbn_book(rs.getString(2));
				book.setName(rs.getString(3));
				book.setPrice(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return book;
	}
}
