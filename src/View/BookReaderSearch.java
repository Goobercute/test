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

import Controler.Control;
import Model.Book;
import Model.User;
import View.BookAuthorSearch1.AuthorSearchHandler;
import View.BookAuthorSearch1.BackHandeler;

public class BookReaderSearch extends JFrame {
	private JPanel contentPane;
	public static int choice;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	Runnable runnable;
	JTextArea booknumber0;
	JTextField booknumber1;
	JTable booklist;
	 JScrollPane scrollPane;
	static User user1 = new User();
	static Object [][] result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReaderSearch bookReadersearch = new BookReaderSearch(user1);
					bookReadersearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	public BookReaderSearch(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		// 设置文本域组件
		booknumber0 = new JTextArea("输入你要查询的书籍书号：");
		booknumber1 = new JTextField(10);
		
		booklist = new JTable();
		scrollPane = new JScrollPane(booklist);
		add(scrollPane);
		String[] columnNames = { "用户", "书籍", "书号", "借阅时间", "归还时间" };
		DefaultTableModel tableModel=new DefaultTableModel(result,columnNames){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        booklist.setModel(tableModel);
		// 设置按钮
		JButton search = new JButton("确认查询");
		search.addActionListener(new AuthorSearchHandler());
		JButton back = new JButton("返回");
		back.addActionListener(new BackHandeler());
		// 布局
		BorderLayout borderlayout = new BorderLayout();
		this.setLayout(borderlayout);
		// 添加 北部
		JPanel centerPane1 = new JPanel();
		centerPane1.add(booknumber0);
		centerPane1.add(booknumber1);
		centerPane1.add(search);
		centerPane1.add(back);
		this.add(centerPane1, BorderLayout.NORTH);
		centerPane1.setLayout(new FlowLayout());
		// 添加 中部
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.setResizable(false);
		this.setVisible(true);

		user1.setPassword(user.getPassword());
		user1.setUsercard(user.getUsercard());
	}
	
	class BackHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method s
			BookSearch1 booksearch = new BookSearch1(user1);
			booksearch.setVisible(true);
			result= null;
			BookReaderSearch.this.dispose();
		}

	}
	class AuthorSearchHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Control control = new Control();
			Book book = new Book();
			User userresult =new User();
			//获得要搜索的书名
			book.setBookNumber(booknumber1.getText().toString());
			//返回结果
			List<User> list = control.Search5(book, user1);
			if (list.size()!=0) { 

			result = new Object [list.size()][5];
			for(int i=0;i<list.size();i++) {
				userresult = list.get(i);
				result[i][0]=userresult.getUsercard();
				result[i][1]=userresult.getBook1();
				result[i][2]=userresult.getBook1num();
				result[i][3]=userresult.getBook1borrowtime();
				result[i][4]=userresult.getBook1backtime();
			}
			BookReaderSearch.this.dispose();
			new BookReaderSearch(user1);
			}else {
				JOptionPane.showMessageDialog(null, "【失败啦】", "没有找到该书信息", JOptionPane.ERROR_MESSAGE);
			}
			
		}
}
}
