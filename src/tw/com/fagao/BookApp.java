package tw.com.fagao;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import tw.com.fagao.entity.Book;
import tw.com.fagao.service.BookService;

public class BookApp {

	public static void main(String[] args) {

		BookService bookService = new BookService();
		//測試findAll
//		Collection<Book> books = bookService.getAll();
//
//		Iterator<Book> itr = books.iterator();
//		while (itr.hasNext()) {
//			Book book = itr.next();
//			System.out.println(book);
//		}

		// for (Book book : books) {
		// System.out.println(book);
		// }

		//測試getByID
//		Scanner scanner = new Scanner(System.in);
//		while (true) {
//			Long inputid = scanner.nextLong();
//			if (inputid == 0) {
//				break;
//			}
//			Book theBook = bookService.getByID(inputid);
//			System.out.println(theBook);
//		}
//		scanner.close();
		
		//測試insertBook
		Book bookInsert=new Book("JavaBook", "Micky", 300);
		bookService.insertBook(bookInsert);
		
		//測試updateBook
//		bookService.updateBook("MickyBook", "Micky", 50, 1L);
		
		//測試deleteBook
//		bookService.deleteBookById(1);
		
	}
}
