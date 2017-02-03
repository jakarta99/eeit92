package tw.com.pai.service;

import java.util.Collection;

import tw.com.pai.dao.Bookdao;
import tw.com.pai.entuty.Book;


public class BookService {

	public Collection<Book> findAll() {
		Bookdao bookdao= new Bookdao();
		return bookdao.findAll();
	}
	
	public Book select_by_id(Long id){
		Bookdao bookdao= new Bookdao();
		return bookdao.select_by_id(id);
	}
	
	public Book insert(Book data){
		Bookdao bookdao= new Bookdao();
		return bookdao.insert(data);
	}
	
	public Book update(Long id,String name,String author,int version, double price){
		Bookdao bookdao= new Bookdao();
		return bookdao.update(id, name, author, version, price);
	}
	
	public int delete(int id){
		Bookdao bookdao= new Bookdao();
		return bookdao.delete(id);
	}
	
}
