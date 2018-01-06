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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controler.Control;
import Model.User;

public class Change extends JFrame {
	private JPanel contentPane;

	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	JTextArea usercard0;
	JTextArea oldpassword0; // 旧密码
	JTextArea password1; // 新密码
	JTextArea password2; // 确认新密码
	JPasswordField oldpassword1; // 旧密码
	JPasswordField newpassword1; // 新密码
	JPasswordField newpassword2; // 确认新密码
	JTextField usercard1;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Change();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Change() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		usercard0 = new JTextArea("请输入用户名");

		usercard1 = new JTextField();
		oldpassword0 = new JTextArea("请输入旧密码");

		oldpassword1 = new JPasswordField();
		password1 = new JTextArea("请输入新密码");

		newpassword1 = new JPasswordField();
		password2 = new JTextArea("确认新密码");

		newpassword2 = new JPasswordField();
		JButton back = new JButton("返回");
		back.addActionListener(new BackHandeler());
		JButton change = new JButton("确认修改");
		change.addActionListener(new ChangeHandeler());

		GridLayout grid = new GridLayout(5, 2);
		contentPane.setLayout(grid);
		contentPane.add(usercard0);
		contentPane.add(usercard1);
		contentPane.add(oldpassword0);
		contentPane.add(oldpassword1);
		contentPane.add(password1);
		contentPane.add(newpassword1);
		contentPane.add(password2);
		contentPane.add(newpassword2);
		contentPane.add(back);
		contentPane.add(change);

		this.setResizable(false);
		this.setVisible(true);
	}

	class BackHandeler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method s
			Login login = new Login();
			login.setVisible(true);
			Change.this.dispose();
		}

	}

	class ChangeHandeler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			User user = new User();
			System.out.println(newpassword1.getPassword());
			System.out.println(newpassword2.getPassword());
			if (String.valueOf(newpassword1.getPassword()).equals(String.valueOf(newpassword2.getPassword()))) {
				user.setUsercard(usercard1.getText().toString());
				System.out.println(String.valueOf(oldpassword1.getPassword()));
				String old = String.valueOf(oldpassword1.getPassword());
				String new1 = String.valueOf(newpassword1.getPassword());
				user.setPassword(old);
				user.setNewpassword(new1);
				Control control = new Control();
				boolean flag = control.Change(user);
				if (flag == true) {
					JOptionPane.showMessageDialog(null, "【成功啦】", "修改成功", JOptionPane.PLAIN_MESSAGE);
					Login login = new Login();
					Change.this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误", "修改失败", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "【两次输入的新密码不同】", "修改失败", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

}
