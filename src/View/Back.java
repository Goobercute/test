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
import View.Borrow.BackHandeler;
import View.Borrow.BorrowHandeler;

public class Back extends JFrame {

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
					Back back=new Back(user1);
					back.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public Back(User user) {
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

		// 设置按钮
		JButton borrow = new JButton("确认归还");
		borrow.addActionListener(new BackBookHandeler());
		JButton back = new JButton("返回");
		back.addActionListener(new BackHandeler());
		// 布局
		GridLayout grid = new GridLayout(3, 2);
		contentPane.setLayout(grid);
		// 添加
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
	
	class BackHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method s
			UserMenu usermenu = new UserMenu(user1);
			usermenu.setVisible(true);
			Back.this.dispose();
		}

	}
	
	class BackBookHandeler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method s
			Control control = new Control();
			Book book=new Book();
	
			book.setBookName(bookname.getText().toString());
			book.setBookNumber(booknumber.getText().toString());
			boolean flag = control.BackBook(book,user1);
			if (flag == true) {
				JOptionPane.showMessageDialog(null, "【成功啦】", "还书成功", JOptionPane.PLAIN_MESSAGE);
				UserMenu usermenu = new UserMenu(user1);
				Back.this.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "【失败啦】", "还书失败", JOptionPane.ERROR_MESSAGE);
			}
		}
			
	
		
	}

}
