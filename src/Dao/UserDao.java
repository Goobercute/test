package Dao;

import java.util.List;

import Model.Book;
import Model.User;

public interface UserDao {
	public boolean Login(User user);
	public boolean getbackBook(Book book,User user);
	public boolean borrowBook(Book book,User user);
	public List searchBook1(Book book,User user);   //name
	public List searchBook2(Book book,User user);   //author
	public List searchBook3(Book book,User user);  //number
	public List searchBook4(Book book,User user);  //publisher
	public boolean selfInfo(User user);
}
