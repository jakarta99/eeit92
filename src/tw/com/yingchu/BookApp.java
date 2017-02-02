package tw.com.yingchu;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import tw.com.iris.entity.Book;
import tw.com.iris.service.BookService;

public class BookApp {

	public static void main(String[] args) {

		BookService bookService = new BookService();
		Collection<Book> books = bookService.getAll();

		Iterator<Book> itr = books.iterator();
		while (itr.hasNext()) {
			Book book = itr.next();
			System.out.println(book);
		}

		// for (Book book : books) {
		// System.out.println(book);
		// }
		//
		// Scanner scanner = new Scanner(System.in);
		// while (true) {
		// Long inputid = scanner.nextLong();
		// if (inputid == 0) {
		// break;
		// }
		// Book bookValue = bookService.getByID(inputid);
		// System.out.println(bookValue);
		// }
		// scanner.close();

		// System.out.println(bookService.update((long) 8, "B-003", "Spring",
		// 72));
		// System.out.println(bookService.delete((long) 6));
		System.out.println(bookService.insert((long) 1, "A-001", "MVC", 888));
	}
}
