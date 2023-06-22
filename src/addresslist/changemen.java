package addresslist;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class changemen {
	static JFrame f= new JFrame();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		xiugai();
	}
	public static void xiugai(){
		final xiu g=new xiu("root","123456");
		f=new JFrame("修改药品信息");
		JPanel s1=new JPanel();
		JButton b1=new JButton("返回");
		JButton b2=new JButton("修改");
		JLabel a1,a3;
		final JTextField a2;
		final JTextField a4;
		a1=new JLabel("请输入药品名称");
		a2=new JTextField(15);
		a3=new JLabel("请输入药品编号");
		a4=new JTextField(15);
		s1.setLayout(null);
		a1.setBounds(new Rectangle(5, 20, 70, 30));
		a2.setBounds(new Rectangle(80, 20, 180, 30));
		a3.setBounds(new Rectangle(5, 60, 70, 30));
		a4.setBounds(new Rectangle(80, 60, 180, 30));
		b2.setBounds(new Rectangle(80, 100, 70, 30));
		b1.setBounds(new Rectangle(160, 100, 70, 30));
		s1.add(a1);
		s1.add(a2);
		s1.add(a3);
		s1.add(a4);
		s1.add(b1);
		s1.add(b2);
		f.add(s1);
		f.setSize(320,200);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		b1.addActionListener(new ActionListener(){
			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new home().zhu();
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				String name=a2.getText().trim();
				String phone=a4.getText().trim();
				String n1="update txl set phone='"+phone+"'where name='"+name+"'";
				g.anyoperate(n1);
				closeThis();
				JOptionPane.showMessageDialog(null, "修改成功！");;
			}
		});

	}
	public static void closeThis(){
		f.dispose();
	}
}
class xiu{
	String driverName="com.mysql.cj.jdbc.Driver";
	String dbURL = "jdbc:mysql://localhost:3306/message?serverTimezone=GMT%2B8";

	Connection dbConn;
	String userName = "root";
	String userPwd ="123456";
	Statement stmt;
	public xiu(String userName,String userPwd)
	{
		try {
			Class.forName(driverName);
			dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		}catch(Exception e) {
			System.out.println("错误1");
			e.printStackTrace();
		}
	}
	public void anyoperate(String sqls) {
		try {
			stmt=dbConn.createStatement();
			stmt.execute(sqls);
			stmt.close();
		}catch(Exception e) {
			System.out.println("错误2");
		}
	}

	public void insert(String sqls,String[] values) {
		try {
			PreparedStatement prepare=dbConn.prepareStatement(sqls);
			for(int i=0;i<values.length;i++)
				prepare.setString(i+1, values[i]);
			prepare.execute();
			prepare.close();
		}catch(Exception e) {

		}
	}
	public void query(String sqls)
	{
		try {
			stmt=dbConn.createStatement();
			ResultSet rset=stmt.executeQuery(sqls);
			while(rset.next())
			{
				for(int i=1;i<=4;i++) {
					System.out.println(rset.getString(i)+"\t");
				}
				System.out.println();
			}
			rset.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println("错误3");
		}
	}
	public void closeconn()
	{
		try {
			dbConn.close();
		}catch(Exception e) {
			System.out.println("错误4");
		}
	}
}
