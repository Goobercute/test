package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginChoice extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginChoice();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginChoice() {
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

		this.setLayout(null);

		JLabel j1 = new JLabel("图书馆管理系统");
		j1.setFont(new Font("宋体", 0, 30));
		j1.setForeground(Color.red);
		j1.setBounds(200, 150, 250, 50);
		JButton Manager = new JButton("图书管理员登录");
		Manager.setBounds(125, 20, 150, 30);
		Manager.addActionListener(new ManagerLoginHandler());
		JButton Reader = new JButton("借阅者登录");
		Reader.setBounds(300, 20, 150, 30);
		Reader.addActionListener(new ReaderLoginHandler());

		JPanel jp = new JPanel();
		jp.setLayout(null);
		jp.add(Manager);
		jp.add(Reader);
		jp.add(j1);
		
		setContentPane(jp);	
		setVisible(true);
	}

	class ManagerLoginHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Login1 login = new Login1();
			LoginChoice.this.dispose();
		}

	}

	class ReaderLoginHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Login login = new Login();
			LoginChoice.this.dispose();
		}

	}

}
