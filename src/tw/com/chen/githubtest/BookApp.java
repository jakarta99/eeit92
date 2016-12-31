package tw.com.chen.githubtest;

import java.util.Collection;
import java.util.Scanner;

import tw.com.chen.githubtest.entity.book.Book;
import tw.com.chen.githubtest.service.BookService;

public class BookApp {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		// Collection<Book> books = bookService.getAll();
		// JAVA 4以前
		// Iterator<Book> itr=books.iterator();
		// while(itr.hasNext()){
		// Book book = itr.next();
		// System.out.println(book);
		// }
		// JAVA 5以後
		// for(Book book: books){
		// System.out.println(book);
		// }
		Scanner scan = new Scanner(System.in);
		while (true) {

			Long inputId = scan.nextLong();
			if (inputId == 0)
				break;
			Book bookId = bookService.getId(inputId);
			System.out.println(bookId);

		}
		scan.close();

	}

}
