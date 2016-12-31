package tw.com.shuyuan;

import java.util.Collection;
import java.util.Scanner;

import tw.com.shuyuan.entity.Book;
import tw.com.shuyuan.service.BookService;

public class BookApp {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		// Collection<Book> books=bookService.getAll();
		// Iterator<Book> itr= books.iterator();
		//// before java 4
		// while(itr.hasNext()){
		// Book book=itr.next();
		// System.out.println(book);
		// }
		//// java5
		// for(Book book:books){
		// System.out.println(book);
		// }
		// Book books = bookService.getById(2L);
		while (true) {
			Scanner scan = new Scanner(System.in);
			Long inputId = scan.nextLong();
			if (inputId == 0l) {
				scan.close();
				System.out.println("exit");
				System.exit(-1);
			}
			Book book = bookService.getById(inputId);
			System.out.println(book);
		}
	}

}
