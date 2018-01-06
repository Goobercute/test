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

import Model.User;

public class UserMenu extends JFrame {
	private JPanel contentPane;
	public static int choice;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	Runnable runnable;
	static User user1 = new User();

	public static void main(String[] args) {
		User user = new User();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMenu usermenu = new UserMenu(user);
					usermenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserMenu(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout());
		// 查询书籍按钮
		// 借书按钮
		JButton button1 = new JButton("借书");
		button1.setSize(dbutton);
		contentPane.add(button1);

		JButton button2 = new JButton("还书");
		button2.setSize(dbutton);
		contentPane.add(button2);

		JButton button3 = new JButton("图书信息查询");
		button3.setSize(dbutton);
		contentPane.add(button3);

		JButton button4 = new JButton("个人信息查询");
		button4.setSize(dbutton);
		contentPane.add(button4);
		JButton button5 = new JButton("注销");
		button5.setSize(dbutton);
		contentPane.add(button5);
		// 窗口大小无法改变
		this.setResizable(false);

		// 设置事件
		button1.addActionListener(new borrowBookhandler());
		button2.addActionListener(new backBookhandler());
		button3.addActionListener(new bookSearchHandler());
		button4.addActionListener(new SelfInfoHandler());
		button5.addActionListener(new BackHandler());
		user1.setUsercard(user.getUsercard());
		user1.setPassword(user.getPassword());
		setVisible(true);
	}
	class BackHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			Login lg = new Login();
			lg.setVisible(true);
			UserMenu.this.dispose();
		}
		
	}
	// 借书按钮事件
	class borrowBookhandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Borrow borrow = new Borrow(user1);
			borrow.setVisible(true);
			UserMenu.this.dispose();
		}

	}

	class backBookhandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Back back = new Back(user1);
			back.setVisible(true);
			UserMenu.this.dispose();
		}

	}

	class bookSearchHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			BookSearch booksearch = new BookSearch(user1);
			booksearch.setVisible(true);
			UserMenu.this.dispose();

		}

	}
	class SelfInfoHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			SelfInfo selfinfo = new SelfInfo(user1);
			selfinfo.setVisible(true);
			UserMenu.this.dispose();

		}

	}
}
