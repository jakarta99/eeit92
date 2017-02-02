package tw.com.pai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import tw.com.pai.entuty.Book;

public class Bookdao {
	private final static String url = "jdbc:sqlserver://softleader.com.tw:1433;databaseName=EEIT92DB";
	private final static String username = "EEIT92";
	private final static String password = "EEIT92";

	
	private final static String select_all = "select * from book_pai";
	private final static String select_by_id ="select * from book_pai where id=?";
	private final static String insert ="insert into book_pai (id, name, author,version , price) values (?, ?, ?, ?, ?)";
	private final static String update ="update book_pai set name=?, author=?, version=?, price=? where id=?";
	private final static String delete ="delete from book_pai where id=?";
	
	public Collection<Book> findAll(){ 
		Collection<Book> book=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet res=null;
		try {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn=DriverManager.getConnection(url, username, password);
			stmt=conn.createStatement();
			res=stmt.executeQuery(select_all);
			book=new ArrayList<Book>();
			while(res.next()){
				Book books =new Book();
				books.setId(res.getLong("id"));
				books.setName(res.getString("name"));
				books.setAuthor(res.getString("author"));
				books.setVersion(res.getInt("version"));
				books.setPrice(res.getDouble("price"));
				book.add(books);
				
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally{
			if (res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
		}
		return book;	
	}
}
