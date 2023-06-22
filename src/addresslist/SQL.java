package addresslist;


import java.sql.*;

public class SQL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{

		String driverName="com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/message?serverTimezone=GMT%2B8";
		String userName = "root";
		String userPwd ="123456";
		Connection dbConn;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL1 = "jdbc:mysql://localhost:3306/message?serverTimezone=GMT%2B8";
			String userName1 = "root";
			String userPwd1 ="123456";
			dbConn=DriverManager.getConnection(dbURL1,userName1,userPwd1);

			System.out.print("正确");

			dbConn.close();
		}catch(Exception e) {
			System.out.print("错误");
			e.printStackTrace();
		}
	}
}
