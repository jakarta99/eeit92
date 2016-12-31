package tw.com.chen.githubtest.entity.book;

public class Book {

	private  Long id;
	private  String sbn_code;
	private  String name;
	private  Integer price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSbn_code() {
		return sbn_code;
	}
	public void setSbn_code(String sbn_code) {
		this.sbn_code = sbn_code;
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
		return "Book [id=" + id + ", sbn_code=" + sbn_code + ", name=" + name + ", price=" + price + "]";
	}

}
