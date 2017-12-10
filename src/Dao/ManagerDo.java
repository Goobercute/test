package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DatabaseConnection;
import Model.Book;
import Model.Manager;
import Model.User;

public class ManagerDo implements ManagerDao {

	DatabaseConnection datacon = new DatabaseConnection();
	Connection con = datacon.getConnection();
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	User user;
	Manager manager;

	public boolean Login(Manager manager) {
		String sql = "select * from manager where username='" + manager.getUsername() + "' and password" + "='"
				+ manager.getPassword() + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				con.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean BookCaibian(Book book) {
		String sql = "select * from book where booknumber='" + book.getBookNumber() + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				sql = "update book set bookshuliang='" + book.getBookShuliang() + "',bookname='" + book.getBookName()
						+ "',bookauthor='" + book.getBookAuthor() + "',publisher='" + book.getBookPublisher()
						+ "' where booknumber='" + book.getBookNumber() + "'";
				st.executeLargeUpdate(sql);
				return true;
			} else {
				sql = "insert into book(bookname,bookauthor,publisher,booknumber,bookshuliang) values('"
						+ book.getBookName() + "','" + book.getBookAuthor() + "','" + book.getBookPublisher() + "','"
						+ book.getBookPublisher() + "','" + book.getBookShuliang() + "')";
				st.executeUpdate(sql);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteBook(Book book) {
		String sql = "delete from book where booknumber='" + book.getBookNumber() + "'";
		try {
			st = con.createStatement();
			if (st.executeUpdate(sql) == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<User> SearchUser(User user) {
		String usercard = user.getUsercard();
		List<User> list = new ArrayList();
		String sql = "select * from user where usercard='" + usercard + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				User userres = new User();
				userres.setUsercard(rs.getString(1));
				userres.setName(rs.getString(3));
				userres.setBook1(rs.getString(4));
				userres.setBook2(rs.getString(5));
				userres.setBook3(rs.getString(5));
				userres.setBook1borrowtime(rs.getDate(10));
				userres.setBook2borrowtime(rs.getDate(12));
				userres.setBook3borrowtime(rs.getDate(14));
				userres.setBook1backtime(rs.getDate(11));
				userres.setBook2backtime(rs.getDate(13));
				userres.setBook3backtime(rs.getDate(15));
				list.add(userres);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean addUser(User user) {
		String sql = "select * from user where usercard='" + user.getUsercard() + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (!rs.next()) {
				sql = "insert into user(usercard,password,name,book1,book2,book3,book1num,book2num,book3num) values('"
						+ user.getUsercard() + "','" + user.getPassword() + "','" + user.getName()
						+ "','#','#','#','#','#','#')";
				st.executeUpdate(sql);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(User user) {
		String sql = "select * from user where usercard='" + user.getUsercard() + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				sql = "delete from user where usercard='" + user.getUsercard() + "'";
				if (st.executeUpdate(sql) == 1) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
