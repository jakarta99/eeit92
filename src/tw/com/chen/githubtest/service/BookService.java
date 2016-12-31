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
}
