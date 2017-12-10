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

import Controler.Control1;
import Model.User;

public class DeleteUser extends JFrame {
	private JPanel contentPane;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	JTextField usercard;
	User user = new User();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser u1 = new DeleteUser();
					u1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		setLayout(null);
		JLabel usercard0 = new JLabel("输入你要删除的用户卡号：");
		usercard0.setBounds(100, 100, 170, 30);
		usercard = new JTextField();
		usercard.setBounds(300, 100, 100, 30);
		JButton jb1 = new JButton("确认");
		jb1.addActionListener(new DeleteHandler());
		JButton jb2 = new JButton("返回");
		jb2.addActionListener(new BackHandeler());
		jb1.setBounds(200, 150, 100, 30);
		jb2.setBounds(200, 190, 100, 30);
		contentPane.add(usercard0);
		contentPane.add(usercard);
		contentPane.add(jb1);
		contentPane.add(jb2);
		setVisible(true);
	}

	class DeleteHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			user.setUsercard(usercard.getText());
			if(!usercard.getText().equals("")) {
				Control1 control1 = new Control1();
				if(control1.DeleteUser(user)) {
					JOptionPane.showMessageDialog(null, "【成功啦】", "删除成功", JOptionPane.PLAIN_MESSAGE);
					DeleteUser.this.dispose();
					new DeleteUser();
				}else {
					JOptionPane.showMessageDialog(null, "【失败啦】", "不在该用户", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "【失败啦】", "输入格式出错", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	class BackHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			UserManage usermanage = new UserManage();
			usermanage.setVisible(true);
			DeleteUser.this.dispose();
		}

	}

}
