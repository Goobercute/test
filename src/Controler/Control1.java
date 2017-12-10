package Controler;

import java.util.ArrayList;
import java.util.List;

import Dao.ManagerDo;
import Model.Book;
import Model.Manager;
import Model.User;

public class Control1 {
	public boolean ManagerLogin(Manager manager) {
		boolean flag = false;
		ManagerDo managerdo = new ManagerDo();
		flag = managerdo.Login(manager);
		return flag;
	}
	public boolean BookCaibian(Book book) {
		boolean flag = false;
		ManagerDo managerdo = new ManagerDo();
		flag=managerdo.BookCaibian(book);
		return flag;
	}
	public boolean Delete(Book book) {
		boolean flag = false;
		ManagerDo managerdo = new ManagerDo();
		flag = managerdo.deleteBook(book);
		return flag;
	}
	public List Search(User user) {
		List<User> list = new ArrayList();
		ManagerDo managerdo = new ManagerDo();
		list = managerdo.SearchUser(user);
		return list;
	}
	public boolean Adduser(User user) {
		boolean flag = false;
		ManagerDo managerdo = new ManagerDo();
		flag = managerdo.addUser(user);
		return flag;
	}
	public boolean DeleteUser(User user) {
		boolean flag = false;
		ManagerDo managerdo = new ManagerDo();
		flag = managerdo.deleteUser(user);
		return flag;
	}
	
}
