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

import Model.Manager;
import Model.User;

public class ManagerMenu extends JFrame {
	private JPanel contentPane;

	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();

	static Manager manager1 = new Manager();

	public static void main(String[] args) {
		Manager manager = new Manager();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMenu managermenu = new ManagerMenu();
					managermenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManagerMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout());

		JButton button1 = new JButton("采编入库");
		button1.setSize(dbutton);
		button1.addActionListener(new BookCaiBianhandler());
		contentPane.add(button1);

		JButton button2 = new JButton("清除库存");
		button2.setSize(dbutton);
		contentPane.add(button2);

		JButton button3 = new JButton("图书信息查询");
		button3.setSize(dbutton);
		button3.addActionListener(new BookSearchhandler());
		contentPane.add(button3);

		JButton button4 = new JButton("读者管理");
		button4.setSize(dbutton);
		button4.addActionListener(new UserManagehandler());
		contentPane.add(button4);

		// 窗口大小无法改变
		this.setResizable(false);
		setVisible(true);
	}

	class BookCaiBianhandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			BookCaiBian bookcaibian = new BookCaiBian();
			ManagerMenu.this.dispose();
		}

	}

	class BookSearchhandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			User user = new User();
			BookSearch1 booksearch1 = new BookSearch1(user);
			ManagerMenu.this.dispose();

		}

	}

	class UserManagehandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			UserManage booksearch1 = new UserManage();
			ManagerMenu.this.dispose();

		}

	}

}
