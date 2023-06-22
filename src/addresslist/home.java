package addresslist;

import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;

public class home {
	static JFrame f= new JFrame();
	static JFrame f1= new JFrame();
	public static void main(String[] args) {
		zhu();

	}
	public static void zhu(){
		JFrame f1=new JFrame("药品库");
		JPanel s1=new JPanel();
		JButton b1=new JButton("新建药品信息");
		JButton b2=new JButton("删除药品");
		JButton b3=new JButton("显示药品信息");
		JButton b4=new JButton("修改药品信息");
		s1.setLayout(new FlowLayout(FlowLayout.CENTER));
		s1.setLayout(null);
		b1.setBounds(new Rectangle(20, 30, 180, 40));
		b2.setBounds(new Rectangle(20, 60, 180, 40));
		b3.setBounds(new Rectangle(20, 90, 180, 40));
		b4.setBounds(new Rectangle(20, 120, 180, 40));
		s1.add(b1);
		s1.add(b2);
		s1.add(b3);
		s1.add(b4);
		f1.add(s1);
		f1.setContentPane(s1);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(235,250);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);
		b4.addActionListener(new ActionListener(){
			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
				closeThis1();
				new changemen().xiugai();
			}
		});
		b1.addActionListener(new ActionListener(){
			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
				closeThis1();
				new addmen().zengjia();
			}
		});
		b2.addActionListener(new ActionListener(){
			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
				closeThis1();
				new deletemen().shanchu();
			}
		});
		b3.addActionListener(new ActionListener(){
			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
				closeThis1();
				try {
					new show().xianshi();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	public static void closeThis1(){
		f1.dispose();
	}
}
