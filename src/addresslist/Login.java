package addresslist;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Login{
	static JFrame f= new JFrame();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deng();
	}
	public static void deng(){
		JFrame f= new JFrame();
		JPanel s1;
		JLabel a1,a3,t;
		final JTextField a2;
		JButton b1,b2;
		f=new JFrame("药品库");
		s1=new JPanel();
		t=new JLabel("    药品库系统",SwingConstants.CENTER);
		a1=new JLabel("用户名:");
		a2=new JTextField(16);
		a3=new JLabel("密码 :");
		final JPasswordField a4 = new JPasswordField(16);
		b1=new JButton("登录");
		b2=new JButton("重置");
		Font font = new Font("宋体",Font.BOLD,30);
		t.setFont(font);
		s1.add(t);
		s1.add(a1);
		s1.add(a2);
		s1.add(a3);
		s1.add(a4);
		s1.add(b1);
		s1.add(b2);
		f.add(s1);
		f.setSize(300,300);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		s1.setLayout(null);
		a1.setBounds(new Rectangle(20, 60, 50, 30));
		a2.setBounds(new Rectangle(80, 60, 180, 30));
		a3.setBounds(new Rectangle(20, 110, 50, 30));
		a4.setBounds(new Rectangle(80, 110, 180, 30));
		b1.setBounds(new Rectangle(50, 160, 80, 30));
		b2.setBounds(new Rectangle(150, 160, 80, 30));
		b1.addActionListener(new ActionListener(){
			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
				String q1=a2.getText();//获取输入的用户名
				String q2=String.valueOf(a4.getPassword());
				if(q1.equals("root")&&q2.equals("123456")) {
					closeThis();
					new home().zhu();
				}
				else
					JOptionPane.showMessageDialog(null, "用户名或密码输入错误！");;
			}
		});
		b2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				a2.setText("");
				a4.setText("");
			}
		});
	}
	public static void closeThis(){
		f.dispose();
	}
}
