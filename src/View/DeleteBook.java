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
import Model.Book;

public class DeleteBook extends JFrame {
	private JPanel contentPane;
	Book book = new Book();
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	JTextField booknumber;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					DeleteBook deletebook = new DeleteBook();
					deletebook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		Point p = new Point((d.width - d.width / 3) / 2, (d.height - d.height / 3) / 2);
		Dimension dbutton = new Dimension(d.width / 24, d.height / 24);
		this.setLocation(p);
		this.setSize(d.width / 3, d.height / 3);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lb1 = new JLabel("要删除的书的书号");
		JButton jb1 = new JButton("确定清除库存");
		JButton jb2 = new JButton("返回");
		jb2.setBounds(175,190,120,30);
		booknumber = new JTextField();
		lb1.setBounds(100,100,120,30);
		jb2.addActionListener(new BackHandler());
		booknumber.setBounds(250,100,120,30);
		jb1.setBounds(175,150,120,30);
		jb1.addActionListener(new DeleteHandler());
		contentPane.add(lb1);
		contentPane.add(booknumber);
		contentPane.add(jb1);
		contentPane.add(jb2);
		setVisible(true);
	}
	
	class DeleteHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			book.setBookNumber(booknumber.getText());
			if(book.getBookNumber().equals("")) {
				JOptionPane.showMessageDialog(null, "【失败啦】", "输入错误", JOptionPane.ERROR_MESSAGE);
			}else {
				Control1 control1 = new Control1();
				if(control1.Delete(book)) {
					JOptionPane.showMessageDialog(null, "【成功啦】", "删除成功", JOptionPane.PLAIN_MESSAGE);
					DeleteBook.this.dispose();
					new DeleteBook();
				}else {
					JOptionPane.showMessageDialog(null, "【失败啦】", "删除错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
	
	class BackHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			ManagerMenu managermenu = new ManagerMenu();
			managermenu.setVisible(true);
			DeleteBook.this.dispose();
		}
		
	}

}
