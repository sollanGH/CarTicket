package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

import client.ActionlistenerDL;

public class UserLogin {
	// GUI组件
	static JFrame frame;
	static JButton button;
	static JTextField text;
	static JPasswordField password;
	static JLabel label01;
	static JLabel label02;
	static JLabel label03;
	// 网络通信
	static Socket socket;
	static ObjectOutputStream oos;
	static PrintWriter pw;
	static BufferedReader br;

	// 存储用户ID、姓名、密码
	static String userNum;
	static String name;
	static String pwd;
	// 退出信息
	static boolean Exit = true;

	// 获取输入的用户ID
	public void getUserNum() {
		userNum = text.getText();
	}

	// 获取输入的用户密码
	public void getpasstword() {
		pwd = password.getText();
	}

	// 主函数
	public static void main(String[] args) {
		// 创建按钮监听类对象
		ActionlistenerDL dl = new ActionlistenerDL();

		// 创建组件 框架、按钮、文本框、密码框、标签
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

		// 连接服务器
		try {
			// 服务器地址、端口号
			socket = new Socket("127.0.0.1", 2333);
			System.out.println("已连接到服务器");
			// 创建对象输出流
			oos = new ObjectOutputStream(socket.getOutputStream());
			// 创建字符输出流
			pw = new PrintWriter(socket.getOutputStream(), true);
			// 创建缓冲输入流
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException w) {
			w.printStackTrace();
			System.out.println("服务器连接异常");
		}
		// 接收返回的登录验证信息
		try {
			String s = null;
			while (true) {
				s = br.readLine();// 获取登录验证信息

				System.out.println("读取到的s：" + s);
				if (s.equals("true")) {
					System.out.println("客户端接收到登录验证信息true*********Successful User Login!!");
					name = br.readLine();// 获取姓名
					System.out.println("获取到的用户姓名是：" + name);
					frame.setVisible(false);// 开启下一个窗口后登录窗口不可视
					TicketBooker tb = new TicketBooker();
					tb.Ticket(); // 按下按钮所触发的事件设为 运行TicketBooker类的Ticket()方法
					break;// 所有事情做完以后，跳出循环
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码输入错误！");
				}

			}
			System.out.println("循环已跳出");
		} catch (IOException q) {
			System.out.println("获取服务器端验证消息失败！");
		}

	}
}
