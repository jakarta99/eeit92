package tw.com.chen.githubtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import tw.com.chen.githubtest.entity.book.Book;

public class BookDao {
	private Connection conn;
	private final String url = "jdbc:sqlserver://softleader.com.tw:1433;databaseName=EEIT92DB";
	private final String user = "EEIT92";
	private final String finding = "select * from book_chen";

	public Collection<Book> findAll() {

		Collection<Book> books = new ArrayList<Book>();
//		String url = "jdbc:sqlserver://softleader.com.tw:1433;databaseName=EEIT92DB";
//		String user = "EEIT92";
//		String finding = "select * from book_chen";
//		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, user, user);
			stmt = conn.prepareStatement(finding);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getLong("id"));
				book.setSbn_code(rs.getString("isbn_code"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getInt("price"));
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return books;
	}

	public Book findById(Long id) {

		Book book = null;
		String url = "jdbc:sqlserver://softleader.com.tw:1433;databaseName=EEIT92DB";
		String user = "EEIT92";
		String finding = "select * from book_chen where id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, user, user);
			stmt = conn.prepareStatement(finding);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				book = new Book();
				book.setId(rs.getLong("id"));
				book.setSbn_code(rs.getString("isbn_code"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getInt("price"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return book;
	}

	public Book upDate(){
		Book result=null;
		return result;
	}
	public int delete(){
		int result=0;
		return result;
	}
//	public Book insert(){
//		Book result=null;
//		conn=DriverManager.getConnection(url, user, user); 
//		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO id()");
//		return result;
//	}
}
