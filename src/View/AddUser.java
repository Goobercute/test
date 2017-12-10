package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controler.Control;
import Controler.Control1;
import Model.User;

public class AddUser extends JFrame {
	private JPanel contentPane;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	JTextField usercard;
	JTextField password;
	JTextField name;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser b1 = new AddUser();
					b1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public AddUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		setLayout(null);
		JLabel usercard0 = new JLabel("输入卡号：");
		JLabel password0 = new JLabel("输入密码：");
		JLabel name0 = new JLabel("输入姓名：");
		JLabel title = new JLabel("新增用户");
		usercard = new JTextField();
		password = new JTextField();
		name = new JTextField();
		JButton jb1 = new JButton("确认");
		jb1.setBounds(330, 125, 100, 30);
		jb1.addActionListener(new SureHandeler());
		JButton jb2 = new JButton("返回");
		jb2.setBounds(330, 175, 100, 30);
		jb2.addActionListener(new BackHandeler());
		usercard0.setBounds(100, 100, 100, 30);
		usercard.setBounds(180, 100, 100, 30);
		password0.setBounds(100, 150, 100, 30);
		password.setBounds(180, 150, 100, 30);
		name0.setBounds(100, 200, 100, 30);
		name.setBounds(180, 200, 100, 30);
		contentPane.add(usercard0);
		contentPane.add(password0);
		contentPane.add(name0);
		contentPane.add(usercard);
		contentPane.add(password);
		contentPane.add(name);
		contentPane.add(jb1);
		contentPane.add(jb2);
		setVisible(true);
	}

	class SureHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			User user = new User();
			user.setName(name.getText());
			user.setUsercard(usercard.getText());
			user.setPassword(password.getText());
			System.out.println(usercard.getText());
			if (!name.getText().equals("") && !usercard.getText().equals("") &&!password.getText().equals("")) {
				Control1 control1 = new Control1();
				if (control1.Adduser(user)) {
					JOptionPane.showMessageDialog(null, "【成功啦】", "入库成功", JOptionPane.PLAIN_MESSAGE);
					AddUser.this.dispose();
					new AddUser();
				} else {
					JOptionPane.showMessageDialog(null, "【失败啦】", "已存在该用户", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "【失败啦】", "格式输入错误", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	class BackHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			UserManage usermanage = new UserManage();
			usermanage.setVisible(true);
			AddUser.this.dispose();
		}

	}

}
