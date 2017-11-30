package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controler.Control;
import Model.Book;
import Model.User;
import View.Login.LoginHandeler;


public class Borrow extends JFrame {
	private JPanel contentPane;
	public static int choice;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	Runnable runnable;
	JTextArea bookname0;
	JTextArea booknumber0;
	JTextField bookname;
	JTextField booknumber;
	static User user1 = new User();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrow borrow=new Borrow(user1);
					borrow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Borrow(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		// 设置文本域组件
		bookname0 = new JTextArea("书名：");
		booknumber0 = new JTextArea("书号：");
		bookname = new JTextField();
		booknumber = new JTextField();
		
		//设置按钮
		JButton borrow = new JButton("确认借阅");
		borrow.addActionListener(new BorrowHandeler());
		JButton back = new JButton("返回");
		back.addActionListener(new  BackHandeler());
		//布局
		GridLayout grid=new GridLayout(3,2);
		contentPane.setLayout(grid);
		//添加
		contentPane.add(bookname0);
		contentPane.add(bookname);
		contentPane.add(booknumber0);
		contentPane.add(booknumber);
		contentPane.add(borrow);
		contentPane.add(back);
		this.setResizable(false);
		this.setVisible(true);
		
		user1.setPassword(user.getPassword());
		user1.setUsercard(user.getUsercard());
		System.out.println(user1.getUsercard());
	}
	
	class BorrowHandeler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Control control = new Control();
			Book book=new Book();
	
			book.setBookName(bookname.getText().toString());
			book.setBookNumber(booknumber.getText().toString());
			boolean flag = control.BorrowBook(book,user1);
			if (flag == true) {
				JOptionPane.showMessageDialog(null, "【成功啦】", "借书成功", JOptionPane.PLAIN_MESSAGE);
				UserMenu usermenu = new UserMenu(user1);
				Borrow.this.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "【失败啦】", "借书失败", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	
	class BackHandeler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method s
			UserMenu usermenu = new UserMenu(user1);
			usermenu.setVisible(true);
			Borrow.this.dispose();
		}
		
	}
		

}
