package Dao;
import Model.*;

public interface ManagerDao {
	public boolean Login(Manager manager);
	public boolean addBook(Book book);
	public boolean deleteBook(Book book);
	public boolean searchBook(Book book);
	public boolean addUser(User user);
	public boolean deleteBokk(User user);
}
