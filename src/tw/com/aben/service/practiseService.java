package tw.com.aben.service;

import java.util.Collection;

import tw.com.aben.dao.practiseDao;
import tw.com.aben.entity.Book;

public class practiseService {
	public Collection<Book> getAll(){
	practiseDao practisedao=new practiseDao();
	return practisedao.findALL();
	}
	
	public Book getById(Long id){
		practiseDao practisedao=new practiseDao();
		return practisedao.findById(id);//findById��k�w�q�w�����O���B����A�[
		
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
