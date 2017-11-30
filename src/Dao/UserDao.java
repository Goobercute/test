package Dao;

import java.util.List;

import Model.Book;
import Model.User;

public interface UserDao {
	public boolean Login(User user);
	public boolean getbackBook(Book book,User user);
	public boolean borrowBook(Book book,User user);
	public List searchBook1(Book book,User user);   //name

	public boolean selfInfo(User user);
}
