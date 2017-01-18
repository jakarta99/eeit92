package src.tw.com.aben;

import src.tw.com.aben.entity.Book;
import src.tw.com.aben.service.practiseService;

public class practiseApp {

	public static void main(String[] args) {
		practiseService practiseservice = new practiseService();
//		System.out.println(practiseservice.getAll());//直接印出是一個Collection

		Book book=new Book();		
		book.setIsbn_code("AAA-0005");
		book.setName("SQL");
		book.setPrice(100);
		
		
		try {
			practiseservice.add(book);
		} catch (NullPointerException e) {
			
			e.printStackTrace();
		}
		
	}

}
