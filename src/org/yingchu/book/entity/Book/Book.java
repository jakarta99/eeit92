package org.yingchu.book.entity.Book;

public class Book {

	private  Long id;
	private  String name;
	private  String author;
	private  Integer price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void name(String Name) {
		this.name = Name;
	}
	public String getAuthor() {
		return author;
	}
	public void setName(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", Name=" + name + ", Author=" + author + ", price=" + price + "]";
	}

}
