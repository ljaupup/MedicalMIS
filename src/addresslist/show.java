package addresslist;

import java.awt.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class show {
	static JFrame f= new JFrame();
	public static void main(String[] args) throws IOException {
		xianshi();
	}

	public static void xianshi()throws IOException{
		String driverName="com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/message?serverTimezone=GMT%2B8";
		String userName = "root";
		String userPwd ="123456";
		String s1;
		Connection dbConn;
		try {
			Class.forName(driverName);

			dbConn=DriverManager.getConnection(dbURL,userName,userPwd);

			Statement stmt=dbConn.createStatement();
			s1="select id,name,phone,birth from txl";


			f=new JFrame("显示界面");
			Object[][] rowData=new Object[10][4];
			ResultSet rs=stmt.executeQuery(s1);
			int i=0;
			while(rs.next()) {
				rowData[i][0]=rs.getString("id");
				rowData[i][1]=rs.getString("name");
				rowData[i][2]=rs.getString("phone");
				rowData[i][3]=rs.getString("birth");
				i++;
			}
			String[] columnNames= {"序号","药品名称","药品编号","登记日期"};
			JTable jt1=new JTable(rowData,columnNames);
			JScrollPane js1=new JScrollPane(jt1);
			JPanel jp4=new JPanel(new GridLayout(0,1));
			jp4.add(js1);
			//JButton b1=new JButton("返回");
			//jp4.add(b1);
			f.setContentPane(jp4);
			f.setSize(400,200);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			f.setResizable(false);
			dbConn.close();

		/*b1.addActionListener(new ActionListener(){
			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
			closeThis();
			new home().zhu();
				}
			});*/
		}catch(Exception e) {
			System.out.print("错误");
			e.printStackTrace();
		}
	}
	public static void closeThis(){
		f.dispose();
	}


}