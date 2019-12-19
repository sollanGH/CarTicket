package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class UserLogin {
	// GUI组件
	static JFrame frame;
	static JButton button;
	static JTextField text;
	static JPasswordField password;
	static JLabel label01;
	static JLabel label02;
	static JLabel label03;	
	// 数据库基本接口
	static Connection con;
	static Statement sql;
	static ResultSet res;
	//存储用户ID、姓名、密码
	static String userNum;
	static String username;
	static String pwd;

	// 获取输入的用户ID
	public void getUserNum() {
		userNum = text.getText();
	}

	// 获取输入的用户密码
	public void getpasstword() {
		pwd = password.getText();
	}

	// 连接数据库的方法
	public Connection getConnection() {
		// 加载数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("数据驱动加载成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败！");
		}
		// 连接数据库
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "520ycsqlbegen");
//			System.out.println("数据库连接成功！");
		} catch (SQLException w) {
			w.printStackTrace();
			System.out.println("数据库连接失败！");
		}
		return con;
	}

	// 主函数
	public static void main(String[] args) {
		// 创建按钮监听类对象
		ActionlistenerDL dl = new ActionlistenerDL();
		// 创建本类对象
		UserLogin login = new UserLogin();
		// 连接数据库
		login.getConnection();
		//创建组件 框架、按钮、文本框、密码框、标签
		frame = new JFrame("用户登录");
		button = new JButton("登录");
		text = new JTextField();
		password = new JPasswordField();
		label01 = new JLabel("账号");
		label02 = new JLabel("密码");
		frame.setLayout(null);// 将布局管理器设置为空，而不是默认的

		// 添加账号文本框
		frame.add(label01);
		label01.setBounds(250, 60, 50, 30);// 设置【账号】的X-Y坐标，以及宽和高的参数
		frame.add(text);
		text.setBounds(250, 90, 150, 30);

		// 添加密码文本框
		frame.add(label02);
		label02.setBounds(250, 120, 50, 30);
		frame.add(password);
		password.setBounds(250, 150, 150, 30);

		// 添加按钮
		frame.add(button);
		button.setBounds(250, 200, 70, 40);

		button.addActionListener(dl);// 对【登录】按钮注册监听事件
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocation(600, 300);
		frame.setVisible(true);
	}
}
