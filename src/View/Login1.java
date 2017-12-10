package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controler.Control;
import Controler.Control1;
import Model.Manager;

public class Login1 extends JFrame {
	JLabel bCenterCard;
	JLabel bCenterPassword;
	JTextField usercard;
	JPasswordField password;
	static Manager manager = new Manager();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 login1 = new Login1();
					login1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login1() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		// 窗口显示在整个屏幕的中央位置
		this.setLocation((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		this.setSize(d.width / 3, d.height / 3);
		this.setIconImage(tk.getImage("images/Login.jpeg"));
		// 设置窗口尺寸不可以调整
		this.setResizable(false);
		this.setLayout(null);
		bCenterCard = new JLabel("用户名：");
		bCenterPassword = new JLabel("密码：");
		bCenterCard.setBounds(50, 40, 100, 30);
		bCenterPassword.setBounds(50, 80, 100, 30);
		usercard = new JTextField();
		usercard.setBounds(100, 40, 150, 30);
		password = new JPasswordField();
		password.setBounds(100, 80, 150, 30);
		JButton jb = new JButton("登录");
		jb.setBounds(300, 60, 100, 30);
		JLabel lb = new JLabel("管理员登录");
		lb.setForeground(Color.red);
		lb.setFont(new Font("宋体", 0, 30));
		lb.setBounds(250, 150, 400, 100);
		
		jb.addActionListener(new LoginHandeler());
		this.add(usercard);
		this.add(bCenterCard);
		this.add(bCenterPassword);
		this.add(password);
		this.add(jb);
		this.add(lb);
		this.setVisible(true);
	}

	class LoginHandeler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Control1 control1 = new Control1();

			manager.setUsername(usercard.getText().toString());
			manager.setPassword(String.valueOf(password.getPassword())); // password返回的是一个Char数组
																			// 要用String.valueof转换为string

			boolean flag = control1.ManagerLogin(manager);
			if (flag == true) {
				JOptionPane.showMessageDialog(null, "【成功啦】", "登录成功", JOptionPane.PLAIN_MESSAGE);
				ManagerMenu managermenu = new ManagerMenu();
				Login1.this.dispose();
				
			} else {
				JOptionPane.showMessageDialog(null, "【失败啦】", "登录失败", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
