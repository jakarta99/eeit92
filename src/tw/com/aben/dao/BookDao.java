package src.tw.com.aben.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import src.tw.com.aben.entity.Book;

public class BookDao {
	private static final String URL = "jdbc:sqlserver://softleader.com.tw:1433;databaseName=EEIT92DB;";
	private static final String findAll = "select * from book_aben";
	private static final String find_By_Id = "select * from book_aben where id =?";

	public Collection<Book> findAll() {
		Collection<Book> books = null;
		try (Connection conn = DriverManager.getConnection(URL, "EEIT92", "EEIT92");
				PreparedStatement pstmt = conn.prepareStatement(findAll);
				ResultSet rs = pstmt.executeQuery();) {

			if (!rs.wasNull()) {
				books = new ArrayList<Book>();
				while (rs.next()) {
					Book book = new Book();
					book.setId(rs.getLong("id"));
					book.setIsbn_code(rs.getString("isbn_code"));
					book.setName(rs.getString("name"));
					book.setPrice(rs.getInt("price"));
					books.add(book);

				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return books;
	}

	public Book findById(Long id) {
		Book book = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://softleader.com.tw:1433;databaseName=EEIT92DB",
					"EEIT92", "EEIT92");
			pstmt = conn.prepareStatement(find_By_Id);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				book = new Book();
				book.setId(rs.getLong(1));
				book.setIsbn_code(rs.getString(2));
				book.setName(rs.getString(3));
				book.setPrice(rs.getInt(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
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
		}
		return book;
	}

}
