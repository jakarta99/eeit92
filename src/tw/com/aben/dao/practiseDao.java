package tw.com.aben.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import tw.com.aben.entity.Book;

public class practiseDao {

	private static final String URL = "jdbc:sqlserver://softleader.com.tw:1433;databaseName=EEIT92DB;";// ��private
	private static final String User = "EEIT92";
	private static final String Password = "EEIT92";
	private static final String FIND_BY_ID = "select * from book_aben where id =?";
	private static final String FINDALL = "select * from book_aben";
	private static final String INSERT = "insert into book_aben (isbn_code,name,price) values (?,?,?)";
	// insert ���O����
	private static final String UPDATE="update book_aben set id=?,isbn=?,name=?,price=? where id =? ";
	
	public Collection<Book> findALL() {
		Collection<Book> books = null;// �n�~���~�ireturn ���M�J��ҥ~�N����
										// �⮳�쪺�h��Book�s�Jbooks
		try (Connection conn = DriverManager.getConnection(URL, User, Password);
				PreparedStatement pstmt = conn.prepareStatement(FINDALL);
				ResultSet rs = pstmt.executeQuery();) {
			if (!rs.wasNull()) {
				books = new ArrayList<Book>();// ���~new �`�ٰO����
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
			pstmt.setLong(1, id);// ���|�o��ʺA�ݭn���ݸ��ѼơA1�N��Ĥ@�Ӱݸ�
			rs = pstmt.executeQuery();// �sclose��k �o��y�n�@�_
										// �ҥH�L�k���try(�̭��n��ŧi��)
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
				
				
				//pstmt.setLong(1, book.getId()); //�y����ID�|�۰ʥ[�J�ҥH���g
				pstmt.setString(1, book.getIsbn_code());//id�������ǭn��
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
