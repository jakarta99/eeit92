package src.tw.com.aben.service;

import java.util.Collection;

import src.tw.com.aben.dao.practiseDao;
import src.tw.com.aben.entity.Book;

public class practiseService {
	public Collection<Book> getAll(){
	practiseDao practisedao=new practiseDao();
	return practisedao.findALL();
	}
	
	public Book getById(Long id){
		practiseDao practisedao=new practiseDao();
		return practisedao.findById(id);//findById方法定義已給型別此處不能再加
		
	}
	public Book add(Book book){
		practiseDao practisedao=new practiseDao();
		return practisedao.insert(book);
	}
	
//	public Book up(Book book){
//		practiseDao practisedao=new practiseDao();
//		return practisedao.update(id,isbn_code,name,price);
//	}
}
