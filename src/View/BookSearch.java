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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.User;
import View.Back.BackBookHandeler;
import View.Back.BackHandeler;

public class BookSearch extends JFrame {

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
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookSearch booksearch=new BookSearch(user1);
					booksearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public BookSearch(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);

		// 设置按钮
		JButton Search1 = new JButton("书名查找");
		JButton Search2 = new JButton("作者查找");
		JButton Search3 = new JButton("书号查找");
		JButton Search4 = new JButton("出版社查找");
		Search1.addActionListener(new Search1Handeler());

		
		JButton back = new JButton("返回");
		back.addActionListener(new BackHandeler());
		// 布局
		GridLayout grid = new GridLayout(3, 2);
		contentPane.setLayout(grid);
		// 添加
		contentPane.add(Search1);
		contentPane.add(Search2);
		contentPane.add(Search3);
		contentPane.add(Search4);
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
			BookSearch.this.dispose();
		}

	}
	//书名查找
	class Search1Handeler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			BookNameSearch booknamesearch = new BookNameSearch(user1);
			booknamesearch.setVisible(true);
			BookSearch.this.dispose();
		}
		
	}
	
	//作者查找 
	class Search2Handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
		
	}
	
}
