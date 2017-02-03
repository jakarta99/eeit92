package tw.com.pai.application;

import java.util.Collection;
import java.util.Iterator;

import tw.com.pai.entuty.Book;
import tw.com.pai.service.BookService;

public class Application {

	public static void main(String[] args) {
		
		BookService bookService =new BookService ();
		Collection<Book> books=bookService.findAll();
		
		Iterator<Book> itr=books.iterator();
		while(itr.hasNext()){
			Book book=itr.next();
			System.out.println(book);
		}

	}

}
