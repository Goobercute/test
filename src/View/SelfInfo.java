package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controler.Control;
import Model.User;
import View.BookPublisherSearch.BackHandeler;

public class SelfInfo extends JFrame {
	private JPanel contentPane;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	static User user1 = new User();
	JTextArea usercard0;
	JTextField usercard1;
	JTextArea name0;
	JTextField name1;
	JTable selfinfo;
	JScrollPane scrollPane;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelfInfo selfinfo = new SelfInfo(user1);
					selfinfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SelfInfo(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		// 设置文本域组件
		usercard0 = new JTextArea("卡号：");
		usercard1 = new JTextField();
		usercard1.setEnabled(false);
		name0 = new JTextArea("姓名：");
		name1 = new JTextField();
		name1.setEnabled(false);
		// 获取用户信息
		Control control = new Control();
		user1.setPassword(user.getPassword());
		user1.setUsercard(user.getUsercard());
		List<User> list = control.SelfInfo(user1);
		Object[][] result = new Object[list.size()][9];
		User userresult = list.get(0);
		result[0][0] = userresult.getBook1();
		result[0][1] = userresult.getBook1borrowtime();
		result[0][2] = userresult.getBook1backtime();
		result[0][3] = userresult.getBook2();
		result[0][4] = userresult.getBook2borrowtime();
		result[0][5] = userresult.getBook2backtime();
		result[0][6] = userresult.getBook3();
		result[0][7] = userresult.getBook3borrowtime();
		result[0][8] = userresult.getBook3backtime();
	
	usercard1.setText(userresult.getUsercard());
	name1.setText(userresult.getName());
	// 设置表格
	selfinfo=new JTable();
	scrollPane=new JScrollPane(selfinfo);

	add(scrollPane);
		String[] columnNames = { "书名1", "借书时间", "归还时间", "书名2", "借书时间", "归还时间","书名3", "借书时间", "归还时间" };

		DefaultTableModel tableModel = new DefaultTableModel(result, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		selfinfo.setModel(tableModel);
		
		JButton back = new JButton("返回");
		back.addActionListener(new BackHandeler());
		
		//添加组件
		JPanel contentPane1 = new JPanel();
		JPanel contentPane2 = new JPanel();
		contentPane2.add(usercard0);
		contentPane2.add(usercard1);
		contentPane2.add(name0);
		contentPane2.add(name1);
		contentPane2.add(back);
		
		BorderLayout borderlayout = new BorderLayout();
		this.setLayout(borderlayout);
		this.add(contentPane2, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		this.setResizable(false);

	}

	class BackHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method s
			UserMenu usermenu = new UserMenu(user1);
			usermenu.setVisible(true);
			SelfInfo.this.dispose();
		}

	}

}
