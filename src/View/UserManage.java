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

public class UserManage extends JFrame {
	private JPanel contentPane;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManage u1 = new UserManage();
					u1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public UserManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		setLayout(null);
		contentPane.setLayout(new GridLayout(2, 2));
		JButton jb1 = new JButton("读者信息查询");
		jb1.addActionListener(new SearchuserHandeler());
		JButton jb2 = new JButton("删除读者");
		jb2.addActionListener(new DeleteUserHandeler());
		JButton jb3 = new JButton("增添读者");
		jb3.addActionListener(new AddUserHandler());
		JButton jb4 = new JButton("返回");
		jb4.addActionListener(new BackHandeler());
		contentPane.add(jb1);
		contentPane.add(jb2);
		contentPane.add(jb3);
		contentPane.add(jb4);
		setVisible(true);
	}

	class BackHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			ManagerMenu managermenu = new ManagerMenu();
			managermenu.setVisible(true);
			UserManage.this.dispose();
		}
	}

	class SearchuserHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			SearchUser s1 = new SearchUser();
			UserManage.this.dispose();
		}
	}

	class AddUserHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			AddUser s1 = new AddUser();
			s1.setVisible(true);
			UserManage.this.dispose();

		}

	}

	class DeleteUserHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			DeleteUser s1 = new DeleteUser();
			s1.setVisible(true);
			UserManage.this.dispose();

		}

	}
}
