package tw.com.fagao.service;

import java.util.Collection;

import tw.com.fagao.dao.BookDao;
import tw.com.fagao.entity.Book;

public class BookService {

	public Collection<Book> getAll() {
		BookDao bookDao = new BookDao();
		return bookDao.findAll();

	}

	public Book getByID(Long id) {
		BookDao bookDao = new BookDao();
		return bookDao.findByID(id);
	}
	
	public int insertBook(Book book) { 
		BookDao bookDao = new BookDao();
		return bookDao.insertBook(book);
	}

	public int updateBook(String name, String author, Integer price, Long id){
		BookDao bookDao = new BookDao();
		return bookDao.updateBook(name, author, price, id);
	}
	
	public boolean deleteBookById(int id){
		BookDao bookDao = new BookDao();
		return bookDao.deleteBookById(id);
	}
}
