package tw.com.aben.service;

import java.util.Collection;

import tw.com.aben.dao.BookDao;
import tw.com.aben.entity.Book;

public class BookService {
	public Collection<Book> getAll(){
		BookDao bookDao=new BookDao();
		return bookDao.findAll();
	}
	
	
	public Book getById(Long id){
		BookDao bookDao=new BookDao();
		return bookDao.findById(id);
		
	}

}
