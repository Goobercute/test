package Controler;
import java.util.ArrayList;
import java.util.List;

import Dao.Userdo;
import Model.Book;
import Model.User;
public class Control {
	public boolean UserLogin(User user) {
		boolean flag=false;
		Userdo userdo= new Userdo();
		flag=userdo.Login(user);
		return flag;
	}
	
	public boolean BorrowBook(Book book,User user) {
		boolean flag=false;
		Userdo userdo= new Userdo();
		flag=userdo.borrowBook(book,user);
		return flag;
	}
	public boolean BackBook(Book book,User user){
		boolean flag=false;
		Userdo userdo= new Userdo();
		flag=userdo.getbackBook(book, user);
		return flag;
	}
	public List Search1(Book book,User user) {
		List<Book> list = new ArrayList<Book>();
		Userdo userdo= new Userdo();
		list=userdo.searchBook1(book,user);
		return list;
	}
}
