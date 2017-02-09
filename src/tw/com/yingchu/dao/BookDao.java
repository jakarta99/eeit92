package tw.com.yingchu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import tw.com.yingchu.entity.Book;

public class BookDao {
	String URL = "jdbc:sqlserver://softleader.com.tw:1433;databaseName=EEIT92DB";
	String USERNAME = "EEIT92";
	String PASSWORD = "EEIT92";

	public Collection<Book> findAll() {
		Collection<Book> books = new ArrayList<Book>(); 
		String select = "select * from book_iris";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(select);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				books.add(book);

				System.out.print(rs.getLong("id") + ",");
				System.out.print(rs.getString("name") + ",");
				System.out.print(rs.getString("author") + ",");
				System.out.println(rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return books;
	}

	public Book findByID(Long id) {

		String SELECT_BY_ID = "select * from book_iris where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book books = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				books = new Book();
				books.setId(rs.getLong("id"));
				books.setName(rs.getString("name"));
				books.setAuthor(rs.getString("author"));
				books.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return books;
	}

	public Book update(Long id, String name, String author, int price) {
		String UPDATE = "UPDATE book_iris set name=?,author=?,price=? where id=?";
		Book updateBook = new Book();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, name);
			pstmt.setString(2, author);
			pstmt.setInt(3, price);
			pstmt.setLong(4, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return updateBook;
	}

	public boolean delete(Long id) {
		String DELETE = "delete from book_iris where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setLong(1, id);
			int num = pstmt.executeUpdate();

			if (num == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public boolean insert(Long id, String name, String author, int price) {
		String INSERT = "Set Identity_Insert book_iris ON;insert into book_iris(id,name,author,price) values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setLong(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, author);
			pstmt.setInt(4, price);
			int num = pstmt.executeUpdate();

			if (num == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;

	}

}
