package src.tw.com.aben.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import src.tw.com.aben.entity.Book;

public class practiseDao {

	private static final String URL = "jdbc:sqlserver://softleader.com.tw:1433;databaseName=EEIT92DB;";// 用private
	private static final String User = "EEIT92";
	private static final String Password = "EEIT92";
	private static final String FIND_BY_ID = "select * from book_aben where id =?";
	private static final String FINDALL = "select * from book_aben";
	private static final String INSERT = "insert into book_aben (isbn_code,name,price) values (?,?,?)";
	// insert 指令不熟
	private static final String UPDATE="update book_aben set id=?,isbn=?,name=?,price=? where id =? ";
	
	public Collection<Book> findALL() {
		Collection<Book> books = null;// 要外提才可return 不然遇到例外就停住
										// 把拿到的多筆Book存入books
		try (Connection conn = DriverManager.getConnection(URL, User, Password);
				PreparedStatement pstmt = conn.prepareStatement(FINDALL);
				ResultSet rs = pstmt.executeQuery();) {
			if (!rs.wasNull()) {
				books = new ArrayList<Book>();// 有才new 節省記憶體
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
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(URL, User, Password);
				PreparedStatement pstmt = conn.prepareStatement(FIND_BY_ID);) {
			pstmt.setLong(1, id);// 易漏這行動態需要給問號參數，1代表第一個問號
			rs = pstmt.executeQuery();// 新close方法 這兩句要一起
										// 所以無法放到try(裡面要放宣告的)
			if (rs.next()) {
				book = new Book();
				book.setId(rs.getLong(1));
				book.setIsbn_code(rs.getString(2));
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

	public Book insert(Book book) {

		Book books = null;
		try (Connection conn = DriverManager.getConnection(URL, User, Password);
			 PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			if (book != null) {
				
				
				//pstmt.setLong(1, book.getId()); //流水號ID會自動加入所以不寫
				pstmt.setString(1, book.getIsbn_code());//id拿掉順序要變
				pstmt.setString(2, book.getName());
				pstmt.setInt(3, book.getPrice());
			}
			int update = pstmt.executeUpdate();
			if (update == 1) {
				books = this.findById(book.getId());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	public Book update(Long id ,String isbn_code,String name,int price){
		Book result=null;
		try(Connection conn = DriverManager.getConnection(URL, User, Password);
			PreparedStatement pstmt = conn.prepareStatement(UPDATE);){
			pstmt.setLong(1, id);
			pstmt.setString(2, isbn_code);
			pstmt.setString(3, name);
			pstmt.setInt(4, price);
			
			int i =pstmt.executeUpdate();
			if(i==1){
				result=this.findById(id);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int delete(){
		// Connection conn =DriverManager.getConnection(URL,User,Password);
		int result=0;
		return result;
		
	}
}
