package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controler.Control1;
import Model.Book;
import Model.User;

public class SearchUser extends JFrame {
	private JPanel contentPane;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	Runnable runnable;
	JTextArea user0;
	JTextField user1;
	JTable userlist;
	JScrollPane scrollPane;
	static Object[][] result;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUser u1 = new SearchUser();
					u1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SearchUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		// 设置文本域组件
		user0 = new JTextArea("输入要查询的用户卡号：");
		user1 = new JTextField(10);
		userlist = new JTable();
		scrollPane = new JScrollPane(userlist);
		add(scrollPane);
		String[] columnNames = { "卡号", "姓名", "book1", "借书时间", "还书时间", "book2", "借书时间", "还书时间", "book3", "借书时间",
				"还书时间" };
		DefaultTableModel tableModel=new DefaultTableModel(result,columnNames){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        userlist.setModel(tableModel);
     // 设置按钮
     		JButton search = new JButton("确认查询");
     		search.addActionListener(new SearchHandler());
     		JButton back = new JButton("返回");
     		back.addActionListener(new BackHandeler());
     		// 布局
     		BorderLayout borderlayout = new BorderLayout();
     		this.setLayout(borderlayout);
     		// 添加 北部
     		JPanel centerPane1 = new JPanel();
     		centerPane1.add(user0);
     		centerPane1.add(user1);
     		centerPane1.add(search);
     		centerPane1.add(back);
     		this.add(centerPane1, BorderLayout.NORTH);
     		centerPane1.setLayout(new FlowLayout());
     		// 添加 中部
     		this.add(scrollPane, BorderLayout.CENTER);
     		
   
     		this.setVisible(true);
	}
	class BackHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			UserManage usermanage = new UserManage();
			usermanage.setVisible(true);
			SearchUser.this.dispose();
		}

	}

	class SearchHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Control1 control1 = new Control1();
			User user = new User();
			User userresult =new User();
			//获得要搜索的书名
			user.setUsercard(user1.getText().toString());
			//返回结果
			List<User> list = control1.Search(user);
			if (list.size()!=0) { 

			result = new Object [list.size()][11];
			for(int i=0;i<list.size();i++) {
				userresult = list.get(i);
				result[i][0]=userresult.getUsercard();
				result[i][1]=userresult.getName();
				result[i][2]=userresult.getBook1();
				result[i][3]=userresult.getBook1borrowtime();
				result[i][4]=userresult.getBook1backtime();
				result[i][5]=userresult.getBook2();
				result[i][6]=userresult.getBook2borrowtime();
				result[i][7]=userresult.getBook2backtime();
				result[i][8]=userresult.getBook3();
				result[i][9]=userresult.getBook3borrowtime();
				result[i][10]=userresult.getBook3backtime();
			}
			SearchUser.this.dispose();
			new SearchUser();
			}else {
				JOptionPane.showMessageDialog(null, "【失败啦】", "没有找到该用户信息", JOptionPane.ERROR_MESSAGE);
			}
			
		}

	
	}
}
