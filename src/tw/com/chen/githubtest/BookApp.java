package tw.com.chen.githubtest;

import java.util.Collection;
import java.util.Scanner;

import tw.com.chen.githubtest.entity.book.Book;
import tw.com.chen.githubtest.service.BookService;

//test2
public class BookApp {

	public static void main(String[] args) {
		BookService bookService = new BookService();
//		Collection<Book> books = bookService.getAll();
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
//		Scanner scan = new Scanner(System.in);
//		while (true) {
//
////			 Long inputId = scan.nextLong();                //only one
////			 if (inputId == 0)
////			 break;
////			 Book bookId = bookService.getId(inputId);
////			 System.out.println(bookId);
//			
////			String str = scan.next();						//all
////			if (str.equals("scan")) {
////				// Collection<Book> book = bookService.getAll();
////				for (Book book : books) {
////					System.out.println(book);
////				}
////
////				break;
////			}
//			
//
//
//		}
//		scan.close();
//		bookService
//		bookService.update(name, price, isbn_code, id);
//		Book updatebook=new Book();
		
		
	}

}
