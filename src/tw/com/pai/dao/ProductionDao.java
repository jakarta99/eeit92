package tw.com.pai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tw.com.pai.entuty.ProductionBean;

public class ProductionDao {

	private final static String url = "jdbc:sqlserver://localhost:1433;database=MDhw";
	private final static String username = "sa";
	private final static String password = "sa123456";

	
	private final static String select_all = "select * from product";
	private final static String select_by_id ="select * from product where id=?";
	private final static String insert ="insert into product (id, name, price, make, expire) values (?, ?, ?, ?, ?)";
	private final static String update ="update product set name=?, price=?, make=?, expire=? where id=?";
	private final static String delete ="delete from product where id=?";

	public List<ProductionBean> select_All(){
		List<ProductionBean> result=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet res=null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			res = stmt.executeQuery(select_all);
			result=new ArrayList<ProductionBean>();
			while(res.next()){
				ProductionBean data= new ProductionBean();
				data.setId(res.getInt("id"));
				data.setName(res.getString("name"));
				data.setPrice(res.getDouble("price"));
				data.setMake(res.getDate("make"));
				data.setExpire(res.getInt("expire"));
				
				result.add(data);			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			if (res!=null) {
				try {
					res.close();
				} catch (SQLException e) {

					e.printStackTrace();
				} 
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				} 
			}
		}
		return result;
	}

	public ProductionBean select_by_id(int id){
		ProductionBean result =null;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet res=null;
		try {
			
			conn = DriverManager.getConnection(url, username, password);
			stmt=conn.prepareStatement(select_by_id);
			stmt.setInt(1,id);
			res=stmt.executeQuery();
			if(res.next()){
				result =new ProductionBean();
				result.setId(res.getInt("id"));
				result.setName(res.getString("name"));
				result.setPrice(res.getDouble("price"));
				result.setMake(res.getDate("make"));
				result.setExpire(res.getInt("expire"));
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally{
			if (res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (Exception e) {
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
		return result;
		
	} 

	public ProductionBean insert(ProductionBean data){
		ProductionBean result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.prepareStatement(insert);
			if (data!=null) {
				stmt.setInt(1, data.getId());
				stmt.setString(2, data.getName());
				stmt.setDouble(3, data.getPrice());
				java.util.Date make=data.getMake();
				if(make!=null) {
					stmt.setDate(4, new java.sql.Date(make.getTime()));
				} else {
					stmt.setDate(4, null);
				}
				stmt.setInt(5, data.getExpire());
			}
			
			int res=stmt.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally{
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	public ProductionBean update(String name,double price, java.util.Date make, int expire, int id){
		ProductionBean result=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt=conn.prepareStatement(update);
			stmt.setString(1, name);
			stmt.setDouble(2,price);
			if(make!=null) {
				stmt.setDate(3, new java.sql.Date(make.getTime()));
			} else {
				stmt.setDate(3, null);
			}
			stmt.setInt(4, expire);
			stmt.setInt(5, id);
			int res=stmt.executeUpdate();
			if(res==1){
				result = this.select_by_id(id);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally{
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	public int delete(int id){
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt=conn.prepareStatement(delete);
			stmt.setInt(1,id);
			int res=stmt.executeUpdate();
			if(res==1){
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			
		}	
		return 0;
	}
}
