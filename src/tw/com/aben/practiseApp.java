package tw.com.aben;

import tw.com.aben.entity.Book;
import tw.com.aben.service.practiseService;

public class practiseApp {

	public static void main(String[] args) {
		practiseService practiseservice = new practiseService();
//		System.out.println(practiseservice.getAll());//�����L�X�O�@��Collection

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
