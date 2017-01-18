package src.tw.com.aben.service;

import java.util.Collection;

import src.tw.com.aben.dao.BookDao;
import src.tw.com.aben.entity.Book;

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
