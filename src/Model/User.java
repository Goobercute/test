package Model;

public class User {
	private String usercard;
	private String password;
	private String name;
	private String book1;
	private String book2;
	private String book3;
	private int booknum;
	public String getUsercard() {
		return usercard;
	}
	public void setUsercard(String usercard) {
		this.usercard = usercard;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBook1() {
		return book1;
	}
	public void setBook1(String book1) {
		this.book1 = book1;
	}
	public String getBook2() {
		return book2;
	}
	public void setBook2(String book2) {
		this.book2 = book2;
	}
	public String getBook3() {
		return book3;
	}
	public void setBook3(String book3) {
		this.book3 = book3;
	}
	public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
}
