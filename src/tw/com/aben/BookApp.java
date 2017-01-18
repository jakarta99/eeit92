package src.tw.com.aben;

import java.util.Collection;
import java.util.Scanner;

import src.tw.com.aben.entity.Book;
import src.tw.com.aben.service.BookService;

public class BookApp {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		Collection<Book> books = bookService.getAll();
		//// before java 4
		// Iterator<Book> itr = books.iterator();
		// while (itr.hasNext()) {
		// Book book = itr.next();
		// System.out.println(book);
		// }

		//// after java5
//		for (Book book : books) {
//			System.out.println(book);
//		}
//		Book books2 = bookService.getById(2L);
//		System.out.println(books2);

		//// after java5
		for (Book book : books) {
			System.out.println(book);
		}
		

		// while (true) {//同理可寫insert update delete指令
		// Scanner scan = new Scanner(System.in);
		// Long inputId = scan.nextLong();
		//
		// if (inputId == 0l) {//0+L
		// scan.close();
		// System.out.println("exit");
		// System.exit(-1);
		// }
		// Book book = bookService.getById(inputId);
		// System.out.println(book);
		// }

		while (true) {// 同理可寫insert update delete指令
			          // while(true) 的目的在於可以一直輸入
			Scanner scan = new Scanner(System.in);//system.in是在開發模式console下輸入
			String inputString = scan.nextLine(); 
			if (inputString.equalsIgnoreCase("all")) {//String是要用equal不能用==這是指位置相等
				
				for (Book book : books) {
					System.out.println(book);
				}
				break; //while就要設break中斷 不然會無窮
			}
			
			scan.close();
		}
	}

}
