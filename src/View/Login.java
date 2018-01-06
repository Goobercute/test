package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controler.Control;
import Model.User;

public class Login extends JFrame {
	JLabel bCenterCard;
	JLabel bCenterPassword;
	JTextField usercard;
	JPasswordField password;
	static User user = new User();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login=new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		// 窗口显示在整个屏幕的中央位置
		this.setLocation((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		this.setSize(d.width / 3, d.height / 3);
		// 设置窗口标题
		this.setTitle("图书馆系统");
		// 设置窗口图标
		this.setIconImage(tk.getImage("images/Login.jpeg"));
		// 设置窗口尺寸不可以调整
		this.setResizable(false);

		// 设置布局方式
		this.setLayout(null);
		// 设置文本域组件
		bCenterCard = new JLabel("卡号：");
		bCenterCard.setBounds(50,50,100,30);
		bCenterPassword = new JLabel("密码：");
		bCenterPassword.setBounds(50,80,100,30);
		JLabel bNorth = new JLabel("欢迎登陆");
		bNorth.setBounds(225,15,100,30);
		// 设置按钮以及事件
		JButton bCenterLogin = new JButton("确认登陆");
		bCenterLogin.setBounds(250,50,100,30);
		bCenterLogin.addActionListener(new LoginHandeler());
		JButton bCenterChange = new JButton("修改密码");
		bCenterChange.setBounds(250,80,100,30);
		bCenterChange.addActionListener(new ChangeHandeler());
		JButton back = new JButton("返回");
		back.setBounds(380,65,100,30);
		back.addActionListener(new BackHandler());
		// 输入框
		usercard = new JTextField();
		usercard.setBounds(100,50,120,30);
		password = new JPasswordField();
		password.setBounds(100,80,120,30);
		// 添加
		this.add(bCenterCard);
		this.add(bCenterPassword);
		this.add(bNorth);
		this.add(bCenterLogin);
		this.add(bCenterChange);
		this.add(usercard);
		this.add(password);
		this.add(back);
		this.setVisible(true);
	}

	// 登陆按钮事件
	class LoginHandeler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Control control = new Control();
			
			user.setUsercard(usercard.getText().toString());
			user.setPassword(String.valueOf(password.getPassword()));    //password返回的是一个Char数组 要用String.valueof转换为string
		
			boolean flag = control.UserLogin(user);
			if (flag == true) {
				JOptionPane.showMessageDialog(null, "【成功啦】", "登录成功", JOptionPane.PLAIN_MESSAGE);
				UserMenu usermenu = new UserMenu(user);
				Login.this.dispose();
				

			} else {
				JOptionPane.showMessageDialog(null, "【失败啦】", "登录失败", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	
	class ChangeHandeler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Change change = new Change();
			
			Login.this.dispose();
		}
		
	}
	class BackHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			LoginChoice lg = new LoginChoice();
			lg.setVisible(true);
			Login.this.dispose();
		}
		
	}

}
