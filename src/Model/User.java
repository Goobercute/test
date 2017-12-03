package Model;

import java.sql.Date;

public class User {
	private String usercard;
	private String password;
	private String newpassword;
	private String name;
	private String book1;
	private String book2;
	private String book3;
	private String book1num;
	private String book2num;
	private String book3num;
	private Date book1borrowtime;
	private Date book1backtime;
	private Date book2borrowtime;
	private Date book2backtime;
	private Date book3borrowtime;
	private Date book3backtime;
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

	public String getBook1num() {
		return book1num;
	}
	public void setBook1num(String book1num) {
		this.book1num = book1num;
	}
	public String getBook2num() {
		return book2num;
	}
	public void setBook2num(String book2num) {
		this.book2num = book2num;
	}
	public String getBook3num() {
		return book3num;
	}
	public void setBook3num(String book3num) {
		this.book3num = book3num;
	}

	public void setBook1borrowtime(Date book1borrowtime) {
		this.book1borrowtime = book1borrowtime;
	}
	public void setBook1backtime(Date book1backtime) {
		this.book1backtime = book1backtime;
	}
	public void setBook2borrowtime(Date book2borrowtime) {
		this.book2borrowtime = book2borrowtime;
	}
	public void setBook2backtime(Date book2backtime) {
		this.book2backtime = book2backtime;
	}
	public void setBook3borrowtime(Date book3borrowtime) {
		this.book3borrowtime = book3borrowtime;
	}
	public void setBook3backtime(Date book3backtime) {
		this.book3backtime = book3backtime;
	}
	public Date getBook1borrowtime() {
		return book1borrowtime;
	}
	public Date getBook1backtime() {
		return book1backtime;
	}
	public Date getBook2borrowtime() {
		return book2borrowtime;
	}
	public Date getBook2backtime() {
		return book2backtime;
	}
	public Date getBook3borrowtime() {
		return book3borrowtime;
	}
	public Date getBook3backtime() {
		return book3backtime;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
}
