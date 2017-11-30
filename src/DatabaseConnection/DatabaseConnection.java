package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF8";
	private static final String user="root";
	private static final String psw="123456";
	Connection con;
	public DatabaseConnection() {
	try {
		Class.forName(driver);
		con= DriverManager.getConnection(url, user, psw);
		if(con!=null) {
			System.out.println("成功连接数据库！");
		}else {
			System.out.println("连接数据库失败！");
		}
	}catch(ClassNotFoundException e) {   
		 System.out.println("Sorry,can`t find the Driver!");   
	  e.printStackTrace();   
		} catch(SQLException e) {
	     e.printStackTrace();  
	  }catch (Exception e) {
		 // TODO: handle exception
          e.printStackTrace();
	  }
	}
	public Connection getConnection() {
		return con;
	}
	public void closeConnection() {
		if(con!=null) {
		try{
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}		
	}
}
