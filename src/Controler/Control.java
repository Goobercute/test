package Controler;

import java.util.ArrayList;
import java.util.List;

import Dao.Userdo;
import Model.Book;
import Model.User;

public class Control {
	public boolean UserLogin(User user) {
		boolean flag = false;
		Userdo userdo = new Userdo();
		flag = userdo.Login(user);
		return flag;
	}

	public boolean BorrowBook(Book book, User user) {
		boolean flag = false;
		Userdo userdo = new Userdo();
		flag = userdo.borrowBook(book, user);
		return flag;
	}

	public boolean BackBook(Book book, User user) {
		boolean flag = false;
		Userdo userdo = new Userdo();
		flag = userdo.getbackBook(book, user);
		return flag;
	}

	public List Search1(Book book, User user) { // 书名
		List<Book> list = new ArrayList<Book>();
		Userdo userdo = new Userdo();
		list = userdo.searchBook1(book, user);
		return list;
	}

	public List Search2(Book book, User user) { // 作者
		List<Book> list = new ArrayList<Book>();
		Userdo userdo = new Userdo();
		list = userdo.searchBook2(book, user);
		return list;
	}

	public List Search3(Book book, User user) { // 书号
		List<Book> list = new ArrayList<Book>();
		Userdo userdo = new Userdo();
		list = userdo.searchBook3(book, user);
		return list;
	}

	public List Search4(Book book, User user) { // 出版社
		List<Book> list = new ArrayList<Book>();
		Userdo userdo = new Userdo();
		list = userdo.searchBook4(book, user);
		return list;
	}

	public List SelfInfo(User user) {
		Userdo userdo = new Userdo();
		List<User> list = userdo.selfInfo(user);
		return list;
	}

	public boolean Change(User user) {
		boolean flag = false;
		Userdo userdo = new Userdo();
		flag = userdo.change(user);
		return flag;
	}
}
