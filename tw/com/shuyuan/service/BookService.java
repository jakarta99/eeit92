package tw.com.shuyuan.service;

import java.util.Collection;

import tw.com.shuyuan.dao.BookDao;
import tw.com.shuyuan.entity.Book;

public class BookService {
	public Collection<Book> getAll() {
		BookDao bookDao = new BookDao();
		return bookDao.findAll();
	}
	public Book getById(long id){
		BookDao bookDao = new BookDao();
		return bookDao.findById(id);
	}
}
