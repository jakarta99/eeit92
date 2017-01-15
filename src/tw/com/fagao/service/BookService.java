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

}
