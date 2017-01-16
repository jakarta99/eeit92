package tw.com.iris.service;

import java.util.Collection;
import tw.com.iris.dao.BookDao;
import tw.com.iris.entity.Book;

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
