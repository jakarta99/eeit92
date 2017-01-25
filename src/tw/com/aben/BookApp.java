package tw.com.aben;

import java.util.Collection;
import java.util.Scanner;

import tw.com.aben.entity.Book;
import tw.com.aben.service.BookService;

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
		

		// while (true) {//�P�z�i�ginsert update delete���O
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

		while (true) {// �P�z�i�ginsert update delete���O
			          // while(true) ���ت��b��i�H�@����J
			Scanner scan = new Scanner(System.in);//system.in�O�b�}�o�Ҧ�console�U��J
			String inputString = scan.nextLine(); 
			if (inputString.equalsIgnoreCase("all")) {//String�O�n��equal�����==�o�O����m�۵�
				
				for (Book book : books) {
					System.out.println(book);
				}
				break; //while�N�n�]break���_ ���M�|�L�a
			}
			
			scan.close();
		}
	}

}
