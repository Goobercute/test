package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import DatabaseConnection.DatabaseConnection;
import Model.Book;
import Model.User;

public class Userdo implements UserDao {
	DatabaseConnection datacon = new DatabaseConnection();
	Connection con = datacon.getConnection();
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	User user;

	public boolean Login(User user) {
		String sql = "select * from user where usercard='" + user.getUsercard() + "' and password" + "='"
				+ user.getPassword() + "'";
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

	public boolean getbackBook(Book book, User user) {
		String sql = "select * from book where booknumber='" + book.getBookNumber() + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				int num = rs.getInt(5) + 1;
				sql = "select * from user where book1num='" + book.getBookNumber() + "' and usercard='"
						+ user.getUsercard() + "'";
				rs = st.executeQuery(sql);
				if (rs.next()) {
					sql = "update user set book1='#',book1borrowtime=null,book1backtime=null,book1num='#' where usercard='"
							+ user.getUsercard() + "' and book1num='" + book.getBookNumber() + "'";
					st.executeUpdate(sql);
					sql = "update book set bookshuliang='" + num + "' where booknumber='" + book.getBookNumber() + "'";
					st.executeUpdate(sql);
					return true;
				} else {
					sql = "select * from user where book2num='" + book.getBookNumber() + "' and usercard='"
							+ user.getUsercard() + "'";
					rs = st.executeQuery(sql);

					if (rs.next()) {
						sql = "update user set book2='#',book2borrowtime=null,book2backtime=null,book2num='#' where usercard='"
								+ user.getUsercard() + "' and book2num='" + book.getBookNumber() + "'";
						st.executeUpdate(sql);
						sql = "update book set bookshuliang='" + num + "' where booknumber='" + book.getBookNumber()
								+ "'";
						st.executeUpdate(sql);
						return true;
					} else {
						sql = "select * from user where book3num='" + book.getBookNumber() + "' and usercard='"
								+ user.getUsercard() + "'";
						rs = st.executeQuery(sql);
						if (rs.next()) {
							sql = "update user set book3='#',book3borrowtime=null,book3backtime=null,book3num='#' where usercard='"
									+ user.getUsercard() + "' and book3num='" + book.getBookNumber() + "'";
							st.executeUpdate(sql);
							sql = "update book set bookshuliang='" + num + "' where booknumber='" + book.getBookNumber()
									+ "'";
							st.executeUpdate(sql);
							return true;
						} else {
							System.out.println("没有借阅该书");
						}
					}
				}

			} else {
				System.out.println("书籍信息错误");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean borrowBook(Book book, User user) {
		String sql = "select * from book where booknumber='" + book.getBookNumber() + "'";
		Calendar calendar = new GregorianCalendar();

		Date day = new Date(calendar.getTimeInMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("今天的日期：" + df.format(day));
		calendar.add(2, 1);
		Date day1 = (new Date(calendar.getTimeInMillis()));
		System.out.println(day);
		System.out.println(day1);

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				int num = rs.getInt(5) - 1;

				System.out.println(num);
				System.out.println(user.getUsercard());
				sql = "select * from book where booknumber='" + book.getBookNumber() + "' and bookshuliang>0";
				st = con.createStatement();
				rs = st.executeQuery(sql);
				if (rs.next()) {
					sql = "select * from user where book1='#' and usercard='" + user.getUsercard() + "' and book2num!='"
							+ book.getBookNumber() + "' and book3num!='" + book.getBookName() + "'";
					rs = st.executeQuery(sql);
					if (rs.next()) {
						sql = "update user set book1='" + book.getBookName() + "',book1num='" + book.getBookNumber()
								+ "' where usercard='" + user.getUsercard() + "'";
						st.executeUpdate(sql);

						sql = "update book set bookshuliang='" + num + "'where booknumber='" + book.getBookNumber()
								+ "'";
						st.executeUpdate(sql);
						sql = "update user set book1borrowtime='" + day + "',book1backtime='" + day1
								+ "' where usercard='" + user.getUsercard() + "'";
						st.executeUpdate(sql);
						return true;
					} else {
						sql = "select * from user where book2='#' and usercard='" + user.getUsercard()
								+ "' and book1num!='" + book.getBookNumber() + "' and book3num!='" + book.getBookName()
								+ "'";
						rs = st.executeQuery(sql);
						if (rs.next()) {
							sql = "update user set book2='" + book.getBookName() + "',book2num='" + book.getBookNumber()
									+ "' where usercard='" + user.getUsercard() + "'";
							st.executeUpdate(sql);

							sql = "update book set bookshuliang='" + num + "'where booknumber='" + book.getBookNumber()
									+ "'";
							st.executeUpdate(sql);
							sql = "update user set book2borrowtime='" + day + "',book2backtime='" + day1
									+ "' where usercard='" + user.getUsercard() + "'";
							st.executeUpdate(sql);
							return true;
						} else {
							sql = "select * from user where book3='#' and usercard='" + user.getUsercard()
									+ "' and book2num!='" + book.getBookNumber() + "' and book1num!='"
									+ book.getBookName() + "'";
							rs = st.executeQuery(sql);
							if (rs.next()) {
								sql = "update user set book3='" + book.getBookName() + "',book3num='"
										+ book.getBookNumber() + "' where usercard='" + user.getUsercard() + "'";
								st.executeUpdate(sql);

								sql = "update book set bookshuliang='" + num + "'where booknumber='"
										+ book.getBookNumber() + "'";
								st.executeUpdate(sql);
								sql = "update user set book1borrowtime='" + day + "',book3backtime='" + day1
										+ "' where usercard='" + user.getUsercard() + "'";
								st.executeUpdate(sql);
								return true;
							} else {
								System.out.println("借阅书籍数量不能超过三本,或者已经借阅过一本该书");
								return false;
							}
						}
					}
				} else {
					System.out.println("库存不足");

				}
			} else {
				System.out.println("书籍信息错误");
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

	public List searchBook1(Book book,User user) {
		String bookname = book.getBookName();
		List<Book> list = new ArrayList();
		String sql = "select * from book where bookname='" + bookname + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
		     while(rs.next())
             { 
               Book bookres=new Book();
               bookres.setBookName(rs.getString(1));
               bookres.setBookAuthor(rs.getString(2));
               bookres.setBookPublisher(rs.getString(3));
               bookres.setBookNumber(rs.getString(4));
               bookres.setBookShuliang(rs.getInt(5));
        
              list.add(bookres);
              }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean selfInfo(User user) {

		return false;

	}

}
