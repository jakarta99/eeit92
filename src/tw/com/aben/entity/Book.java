package src.tw.com.aben.entity;

public class Book {	
	private Long id; //不能static否則無法toString();
	private String isbn_code;
	private String name;
	private Integer price;
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn_code=" + isbn_code + ", name=" + name + ", price=" + price + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsbn_code() {
		return isbn_code;
	}
	public void setIsbn_code(String isbn_code) {
		this.isbn_code = isbn_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
