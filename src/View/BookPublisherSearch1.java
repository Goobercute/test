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
import View.BookPublisherSearch.BackHandeler;
import View.BookPublisherSearch.PublisherSearchHandler;

public class BookPublisherSearch1 extends JFrame {
	private JPanel contentPane;
	public static int choice;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	Runnable runnable;
	JTextArea bookpublisher0;
	JTextField bookpubliser1;
	JTable booklist;
	 JScrollPane scrollPane;
	static User user1 = new User();
	static Object [][] result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookPublisherSearch1 bookpublishersearch = new BookPublisherSearch1(user1);
					bookpublishersearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public BookPublisherSearch1(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		// 设置文本域组件
		bookpublisher0 = new JTextArea("输入你要查询的出版社：");
		bookpubliser1 = new JTextField(10);
		
		booklist = new JTable();
		scrollPane = new JScrollPane(booklist);
		add(scrollPane);
		String[] columnNames = { "书名", "作者", "出版社", "书号", "数量" };
		
		
		DefaultTableModel tableModel=new DefaultTableModel(result,columnNames){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        booklist.setModel(tableModel);
		// 设置按钮
		JButton search = new JButton("确认查询");
		search.addActionListener(new PublisherSearchHandler());
		JButton back = new JButton("返回");
		back.addActionListener(new BackHandeler());
		// 布局
		BorderLayout borderlayout = new BorderLayout();
		this.setLayout(borderlayout);
		// 添加 北部
		JPanel centerPane1 = new JPanel();
		centerPane1.add(bookpublisher0);
		centerPane1.add(bookpubliser1);
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
			BookPublisherSearch1.this.dispose();
		}

	}

	class PublisherSearchHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Control control = new Control();
			Book book = new Book();
			Book bookresult =new Book();
			//获得要搜索的书名
			book.setBookPublisher(bookpubliser1.getText().toString());
			//返回结果
			List<Book> list = control.Search4(book, user1);
			if (list.size()!=0) { 

			result = new Object [list.size()][5];
			for(int i=0;i<list.size();i++) {
				bookresult = list.get(i);
				result[i][0]=bookresult.getBookName();
				result[i][1]=bookresult.getBookAuthor();
				result[i][2]=bookresult.getBookPublisher();
				result[i][3]=bookresult.getBookNumber();
				result[i][4]=bookresult.getBookShuliang();
			}
			BookPublisherSearch1.this.dispose();
			new BookPublisherSearch1(user1);
			}else {
				JOptionPane.showMessageDialog(null, "【失败啦】", "没有找到该书信息", JOptionPane.ERROR_MESSAGE);
			}
			
		}


	}
}
