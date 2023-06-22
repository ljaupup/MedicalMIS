package addresslist;

import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class deletemen {
	static JFrame f= new JFrame();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		shanchu();

	}
	public static void shanchu() {
		final operatedb op1=new operatedb("root","123456");
		f=new JFrame("删除药品");
		JPanel s1=new JPanel();
		JLabel a1;
		final JTextField a2;
		a1=new JLabel("请输入药品名称");
		a2=new JTextField(15);

		JButton b2=new JButton("删除");
		s1.add(a1);
		s1.add(a2);

		JButton b1=new JButton("返回");
		s1.setLayout(null);
		a1.setBounds(new Rectangle(10, 20, 80, 30));
		a2.setBounds(new Rectangle(80, 20, 180, 30));
		b2.setBounds(new Rectangle(60, 60, 70, 30));
		b1.setBounds(new Rectangle(140, 60, 70, 30));
		s1.add(b1);
		s1.add(b2);
		f.add(s1);
		f.setSize(300,150);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				String name=a2.getText().trim();

				String n1="delete from txl where name='"+name+"'";

				op1.anyoperate(n1);
				closeThis();
				JOptionPane.showMessageDialog(null, "删除成功！");;
			}

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
class operatedb
{

	String driverName="com.mysql.cj.jdbc.Driver";
	String dbURL = "jdbc:mysql://localhost:3306/message?serverTimezone=GMT%2B8";

	Connection dbConn;
	String userName = "root";
	String userPwd ="123456";
	Statement stmt;
	public operatedb(String userName,String userPwd)
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
			System.out.println("错误5");
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
