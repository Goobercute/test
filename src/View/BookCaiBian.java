package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controler.Control1;
import Model.Book;

public class BookCaiBian extends JFrame {
	private JPanel contentPane;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	java.awt.TextField bookname1; // 使用java.awt.TextField 才可以进行文本框监测
	java.awt.TextField booknumber1;
	java.awt.TextField bookpublisher1;
	java.awt.TextField bookauthor1;
	java.awt.TextField bookshuliang1;
	Book book = new Book();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookCaiBian b1 = new BookCaiBian();
					b1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public BookCaiBian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		setLayout(null);
		this.setResizable(false);
		JLabel info = new JLabel("若该书号已经存在，则默认修改信息");
		info.setBounds(350, 30, 250, 30);
		// 书名
		JLabel bookname = new JLabel("输入书名");
		bookname.setBounds(50, 30, 100, 30);
		// 书名输入提示文字
		JLabel name0 = new JLabel("*此项不得为空");
		name0.setForeground(Color.red);
		name0.setBounds(50, 55, 100, 30);
		// 书名输入框
		bookname1 = new java.awt.TextField();
		bookname1.setBounds(160, 30, 120, 30);
		bookname1.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent e) {
				if (bookname1.getText().equals("")) {
					name0.setText("*此项不得为空");
					name0.setForeground(Color.red);
				} else {
					name0.setText("*输入格式正确");
					name0.setForeground(Color.green);
					book.setBookName(bookname1.getText().toString());
					System.out.println(book.getBookName());
				}

			}

		});
		// 书号
		JLabel booknumber = new JLabel("输入书号");
		booknumber.setBounds(50, 80, 100, 30);
		// 书号输入提示
		JLabel number0 = new JLabel("*此项不得为空");
		number0.setForeground(Color.red);
		number0.setBounds(50, 105, 100, 30);
		// 书号输入框
		booknumber1 = new java.awt.TextField();
		booknumber1.setBounds(160, 80, 120, 30);
		booknumber1.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent e) {
				if (booknumber1.getText().equals("")) {
					number0.setText("*此项不得为空");
					number0.setForeground(Color.red);
				} else {
					number0.setText("*输入格式正确");
					number0.setForeground(Color.green);
					book.setBookNumber(booknumber1.getText().toString());
					System.out.println(book.getBookNumber());
				}

			}

		});
		// 出版社
		JLabel bookpublisher = new JLabel("输入出版社");
		bookpublisher.setBounds(50, 130, 100, 30);
		// 出版社提示
		JLabel publisher0 = new JLabel("*此项不得为空");
		publisher0.setForeground(Color.red);
		publisher0.setBounds(50, 155, 100, 30);
		// 出版社输入框
		bookpublisher1 = new java.awt.TextField();
		bookpublisher1.setBounds(160, 130, 120, 30);
		bookpublisher1.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent e) {
				if (bookpublisher1.getText().equals("")) {
					publisher0.setText("*此项不得为空");
					publisher0.setForeground(Color.red);
				} else {
					publisher0.setText("*输入格式正确");
					publisher0.setForeground(Color.green);
					book.setBookPublisher(bookpublisher1.getText().toString());
					System.out.println(book.getBookPublisher());
				}

			}

		});
		// 作者
		JLabel bookauthor = new JLabel("输入作者");
		bookauthor.setBounds(50, 180, 100, 30);
		// 作者输入提示
		JLabel author0 = new JLabel("*此项不得为空");
		author0.setForeground(Color.red);
		author0.setBounds(50, 205, 100, 30);
		// 作者输入框
		bookauthor1 = new java.awt.TextField();
		bookauthor1.setBounds(160, 180, 120, 30);
		bookauthor1.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent e) {
				if (bookauthor1.getText().equals("")) {
					author0.setText("*此项不得为空");
					author0.setForeground(Color.red);
				} else {
					author0.setText("*输入格式正确");
					author0.setForeground(Color.green);
					book.setBookAuthor(bookauthor1.getText().toString());
					System.out.println(book.getBookAuthor());
				}

			}

		});
		// 数量
		JLabel bookshuliang = new JLabel("输入书的数量");
		bookshuliang.setBounds(50, 230, 100, 30);
		// 数量提示框
		JLabel shuliang0 = new JLabel("*此项不得为空");
		shuliang0.setForeground(Color.red);
		shuliang0.setBounds(50, 255, 100, 30);
		// 数量输入框
		bookshuliang1 = new java.awt.TextField();
		bookshuliang1.setBounds(160, 230, 120, 30);
		bookshuliang1.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent e) {
				if (bookshuliang1.getText().equals("")) {
					shuliang0.setText("*此项不得为空");
					shuliang0.setForeground(Color.red);
				} else {
					if (isNumeric(bookshuliang1.getText())) {
						shuliang0.setText("*输入格式正确");
						shuliang0.setForeground(Color.green);
						book.setBookShuliang(Integer.parseInt(bookshuliang1.getText()));
						System.out.println(book.getBookShuliang());
					} else {
						shuliang0.setText("*请输入数字");
						shuliang0.setForeground(Color.red);
					}
				}
			}

		});
		// 按钮
		JButton sure = new JButton("确定");
		sure.setBounds(400, 100, 100, 30);
		sure.addActionListener(new SureHandeler());
		JButton back = new JButton("返回");
		back.setBounds(400, 150, 100, 30);
		back.addActionListener(new BackHandeler());

		contentPane.add(info);
		contentPane.add(bookname);
		contentPane.add(bookname1);
		contentPane.add(booknumber);
		contentPane.add(booknumber1);
		contentPane.add(bookpublisher);
		contentPane.add(bookpublisher1);
		contentPane.add(bookshuliang);
		contentPane.add(bookshuliang1);
		contentPane.add(bookauthor);
		contentPane.add(bookauthor1);
		contentPane.add(name0);
		contentPane.add(number0);
		contentPane.add(publisher0);
		contentPane.add(author0);
		contentPane.add(shuliang0);
		contentPane.add(sure);
		contentPane.add(back);
		setVisible(true);
	}

	// 判断字符串是否为数字
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	// 返回
	class BackHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			ManagerMenu managermenu = new ManagerMenu();
			managermenu.setVisible(true);
			BookCaiBian.this.dispose();
		}
	}

	class SureHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println(book.getBookAuthor());
			if (!bookname1.getText().equals("") && !bookauthor1.getText().equals("")
					&& !bookpublisher1.getText().equals("") && !booknumber1.getText().equals("")
					&& !bookshuliang1.getText().equals("") && isNumeric(bookshuliang1.getText())) {
				Control1 control1 = new Control1();
				if (control1.BookCaibian(book)) {
					JOptionPane.showMessageDialog(null, "【成功啦】", "入库成功", JOptionPane.PLAIN_MESSAGE);
					BookCaiBian.this.dispose();
					new BookCaiBian();
				}else {
					JOptionPane.showMessageDialog(null, "【失败啦】", "入库错误", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "【失败啦】", "格式输入错误", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
