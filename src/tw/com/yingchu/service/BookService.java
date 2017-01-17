package tw.com.yingchu.service;

import java.util.Collection;
import tw.com.yingchu.dao.BookDao;
import tw.com.yingchu.entity.Book;

public class BookService {

	public Collection<Book> getAll() {
		BookDao bookDao = new BookDao();
		return bookDao.findAll();
	}

	public Book getByID(Long id) {
		BookDao bookDao = new BookDao();
		return bookDao.findByID(id);
	}
	
	public Book getByInsert(Book book){
		BookDao bookDao=new BookDao();
		return bookDao.findByInster(book);
	}

}
