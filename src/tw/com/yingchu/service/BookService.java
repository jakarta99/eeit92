package tw.com.yingchu.service;

import java.util.Collection;
import tw.com.iris.dao.BookDao;
import tw.com.iris.entity.Book;

public class BookService {

	private static final String author = null;

	public Collection<Book> getAll() {
		BookDao bookDao = new BookDao();
		return bookDao.findAll();

	}

	public Book getByID(Long id) {
		BookDao bookDao = new BookDao();
		return bookDao.findByID(id);
	}

	public Book update(Long id, String name, String author, int price) {
		BookDao bookDao = new BookDao();
		return bookDao.update(id, name, author, price);
	}

	public boolean delete(Long id) {
		BookDao bookDao = new BookDao();
		return bookDao.delete(id);

	}

	public Book insert(Long id, String name, String author, int price) {
		BookDao bookDao = new BookDao();
		return bookDao.insert(id, name, author, price);

	}

}
