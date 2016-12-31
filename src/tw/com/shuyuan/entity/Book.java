package tw.com.shuyuan.entity;

public class Book {
	private long id;
	private String isbn_book;
	private String name;
	private Integer price;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbn_book() {
		return isbn_book;
	}

	public void setIsbn_book(String isbn_book) {
		this.isbn_book = isbn_book;
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

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn_book=" + isbn_book + ", name=" + name + ", price=" + price + "]";
	}
}
