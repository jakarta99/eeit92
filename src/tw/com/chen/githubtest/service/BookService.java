package tw.com.chen.githubtest.service;

import java.util.Collection;

import tw.com.chen.githubtest.dao.BookDao;
import tw.com.chen.githubtest.entity.book.Book;

public class BookService {
	public Collection<Book> getAll(){

		return new BookDao().findAll();
	}
	public Book getId(Long id){
		
		return new BookDao().findById(id);
	}
	public Book update(String name, Integer price,  String isbn_code, Long id){
		return new BookDao().update(name, price, isbn_code, id);
		
	}
	public Book insert(Book book){
		return new BookDao().insert(book);
		
	}
	public boolean delete(Long id){
		return new BookDao().delete(id);
		
	}
}
