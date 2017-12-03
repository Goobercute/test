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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controler.Control;
import Model.User;

public class Login extends JFrame {
	JTextArea bCenterCard;
	JTextArea bCenterPassword;
	JTextField usercard;
	JTextField password;
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
		this.setLayout(new BorderLayout());
		// 设置文本域组件
		bCenterCard = new JTextArea("卡号：");
		bCenterPassword = new JTextArea("密码：");
		JTextArea bNorth = new JTextArea("欢迎登陆");
		// 设置按钮以及事件
		JButton bCenterLogin = new JButton("确认登陆");
		bCenterLogin.addActionListener(new LoginHandeler());
		JButton bCenterChange = new JButton("修改密码");
		bCenterChange.addActionListener(new ChangeHandeler());
		// 输入框
		usercard = new JTextField();
		password = new JTextField();
		// 容器嵌套
		JPanel centerPanel = new JPanel();
		centerPanel.add(bCenterCard);
		centerPanel.add(bCenterPassword);

		JPanel centerPanel1 = new JPanel();
		centerPanel1.add(usercard);
		centerPanel1.add(password);

		JPanel centerPanel2 = new JPanel();
		centerPanel2.add(bCenterLogin);
		centerPanel2.add(bCenterChange);

		// 中部容器垂直方向
		BoxLayout centerBox = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
		centerPanel.setLayout(centerBox);
		// 中部容器输入框垂直方向
		BoxLayout centerBox1 = new BoxLayout(centerPanel1, BoxLayout.Y_AXIS);
		centerPanel1.setLayout(centerBox1);
		// 中部按钮垂直方向
		BoxLayout centerBox2 = new BoxLayout(centerPanel2, BoxLayout.Y_AXIS);
		centerPanel2.setLayout(centerBox2);

		// 中部总体水平方向
		JPanel Center = new JPanel();
		Center.add(centerPanel);
		Center.add(centerPanel1);
		Center.add(centerPanel2);
		BoxLayout centerBox3 = new BoxLayout(Center, BoxLayout.X_AXIS);
		Center.setLayout(centerBox3);
		// 添加
		this.add(bNorth, BorderLayout.NORTH);
		this.add(Center, BorderLayout.CENTER);

		this.setVisible(true);
	}

	// 登陆按钮事件
	class LoginHandeler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Control control = new Control();
			
			user.setUsercard(usercard.getText().toString());
			user.setPassword(password.getText().toString());
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


}
