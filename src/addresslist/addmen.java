package addresslist;


import java.awt.Rectangle;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;


public class addmen {
	static JFrame f= new JFrame();
	public static void main(String[] args)   throws IOException {
		// TODO Auto-generated method stub
		zengjia();
	}
	public static void zengjia() {
		final tianjia tj=new tianjia("root","123456");
		f=new JFrame("新建药品信息");
		JPanel s1=new JPanel();
		JLabel a1,a3,a5,a7;
		final JTextField a2;
		final JTextField a4;
		final JTextField a6;
		final JTextField a8;
		a1=new JLabel("序号");
		a2=new JTextField(16);
		a3=new JLabel("药品名称");
		a4=new JTextField(16);
		a5=new JLabel("药品编号");
		a6=new JTextField(16);
		a7=new JLabel("登记日期");
		a8=new JTextField(16);
		JButton b1=new JButton("返回");
		JButton b2=new JButton("添加");
		s1.setLayout(null);
		a1.setBounds(new Rectangle(10, 60, 70, 30));
		a2.setBounds(new Rectangle(80, 60, 180, 30));
		a3.setBounds(new Rectangle(10, 110, 70, 30));
		a4.setBounds(new Rectangle(80, 110, 180, 30));
		a5.setBounds(new Rectangle(10, 160, 70, 30));
		a6.setBounds(new Rectangle(80, 160, 180, 30));
		a7.setBounds(new Rectangle(10, 210, 70, 30));
		a8.setBounds(new Rectangle(80, 210, 180, 30));
		b2.setBounds(new Rectangle(90, 260, 60, 30));
		b1.setBounds(new Rectangle(160, 260, 60, 30));
		s1.add(a1);
		s1.add(a2);
		s1.add(a3);
		s1.add(a4);
		s1.add(a5);
		s1.add(a6);
		s1.add(a7);
		s1.add(a8);

		s1.add(b1);
		s1.add(b2);
		f.add(s1);
		f.setSize(300,400);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {


				String id=a2.getText();
				String name=a4.getText();
				String phone=a6.getText();
				String birth=a8.getText();
				String v1[]= {"id","name","phone","birth"};
				String n1="insert into txl values('"+id+"','"+name+"','"+phone+"','"+birth+"')";
				tj.insert(n1,v1);
				tj.anyoperate(n1);
				closeThis();
				JOptionPane.showMessageDialog(null, "添加成功！");;}

		});

		b1.addActionListener(new ActionListener(){
			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new home().zhu();
			}
		});
	}
	public static void closeThis(){
		f.dispose();
	}
}
class tianjia
{

	String driverName="com.mysql.cj.jdbc.Driver";
	String dbURL = "jdbc:mysql://localhost:3306/message?serverTimezone=GMT%2B8";

	Connection dbConn;
	String userName = "root";
	String userPwd ="123456";
	Statement stmt;
	public tianjia(String userName,String userPwd)
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