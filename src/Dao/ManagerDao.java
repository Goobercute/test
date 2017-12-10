package Dao;

import java.util.List;

import Model.*;

public interface ManagerDao {
	public boolean Login(Manager manager);

	public boolean BookCaibian(Book book);

	public boolean deleteBook(Book book);

	public boolean addUser(User user);

	public boolean deleteUser(User user);
	
	public List<User> SearchUser(User user);
}
