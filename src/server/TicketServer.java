package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import message.Message;

//主要功能：获取账户【账号】与【密码】
public class TicketServer {

	// 数据库基本接口
	static Connection con;
	static Statement sql;
	static ResultSet res;
	// 网络通信
	static ServerSocket server;
	static ObjectInputStream ois;
	static BufferedReader br;
	static PrintWriter pw;
	// 建立类的对象
	static LoginSQL lo = new LoginSQL();
	static TicketServer ticketserver = new TicketServer();
	// 用于储存接收到的账号、密码、姓名
	static String userNum;
	static String pwd;
	static String name;
	// 用于传输密码是否正确的信息
	private static String loginMessage = "false";
	private static String loginMessageP = "true";
	// 存取选择的出发点、终点、日期、时间
	static String Start;
	static String End;
	static String Year;
	static String Month;
	static String Day;
	static String Time;
	// 存取数据库表中数据
	static String time1;
	static String time2;
	static String time3;
	static String price1;
	static String price2;
	static String price3;
	static String ticket1;
	static String ticket2;
	static String ticket3;
	// 存取选择框的选择状态
	static String jr1 = "false";
	static String jr2 = "false";
	static String jr3 = "false";
	static String jr4 = "false";
	static String jr5 = "false";
	// 车票余量信息是否为0验证
	static String NoTicket = "false";

	int T = 0;
	String S = null;

	private void Reader() {
		try {
			// 创建一个socket与客户端对接
			Socket so = server.accept();
			System.out.println(so.getInetAddress().getHostAddress() + "客户端已连接");
			// 创建对象输入流并接收
			ois = new ObjectInputStream(so.getInputStream());
			// 缓冲输入流
			br = new BufferedReader(new InputStreamReader(so.getInputStream()));
			while (true) {
				// 将对象流中的对象暂存在one中
				Object one = ois.readObject();
				// 将one强转为Message类对象
				Message me = (Message) one;
				// 获取对象内的【账号】与【密码】
				userNum = me.getName();
				pwd = me.getPwd();

				System.out.println("客户端传来的账号信息:" + userNum);
				System.out.println("客户端传来的密码信息:" + pwd);

				// 连接数据库并验证登录信息
				lo.loginSql();

				System.out.println("账户信息验证状态" + loginMessage);
				System.out.println("登录密码检验状态" + loginMessageP);

				// 将账号及密码的验证结果返回给客户端
				try {
					pw = new PrintWriter(so.getOutputStream(), true);
					pw.println(loginMessage);
					System.out.println("已发送检验信息给客户端");
					if (loginMessage.equals("true")) {
						pw.println(name);
						System.out.println("已发送姓名给客户端：" + name);
						// 接收客户端的【出发地】、【终点】、【年份】、【月份】、【日期】、【时间】
						Start = br.readLine();
						End = br.readLine();
						Year = br.readLine();
						Month = br.readLine();
						Day = br.readLine();
						System.out.println("接收到的选择情况：");
						System.out.println("出发站：" + Start + "\t" + "终点站:" + End + "\t" + "年份:" + Year + "\t" + "月份:"
								+ Month + "\t" + "日期:" + Day);
						// 进行数据库查询当前车票状况
						lo.CXmessage();
						// 将数据库查询到的信息返回给客户端
						pw.println(time1);
						pw.println(time2);
						pw.println(time3);
						pw.println(price1);
						pw.println(price2);
						pw.println(price3);
						pw.println(ticket1);
						pw.println(ticket2);
						pw.println(ticket3);
						System.out.println("发送票务信息完成");
						// 接收选择框选择情况
						if (Start.equals("南方学院")) {
							jr1 = br.readLine();
							jr2 = br.readLine();
							jr3 = br.readLine();
							System.out.println("选择框选择情况：" + jr1 + "\t" + jr2 + "\t" + jr3);
						}
						if (Start.equals("中大")) {
							jr1 = br.readLine();
							jr4 = br.readLine();
							jr5 = br.readLine();
							System.out.println("选择框选择情况：" + jr1 + "\t" + jr4 + "\t" + jr5);
						}
						// 进行选票操作
						lo.CheckboxMessage();
						pw.println(NoTicket);
						pw.println(Time);
						// 当进行票数-1操作完成，就将订票信息存到数据库
						if (NoTicket.equals("false")) {
							lo.Ticketre();
						}
						System.out.println("已经将没票警告及乘车时间发送给客户端");

						break;// 事情做完了，跳出循环
					}

				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("数据库验证信息传递给客户端时出错");
				}

			}
			// 释放资源
			System.out.println("关闭资源语句即将运行");
			pw.close();
			br.close();
			ois.close();
			so.close();
			server.close();
			con.close();
			System.out.println("关闭资源语句已运行完毕");
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	// 验证信息正确
	public void MessageTrue() {

		loginMessage = "true";
	}

	// 验证信息错误
	public void MessageFalse() {
		loginMessageP = "false";
	}

	// 主方法
	public static void main(String[] args) {
		// 开启服务器
		try {
			// 创建服务器套接字，并决定接口号
			server = new ServerSocket(2333);
			System.out.println("服务器已开启");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 连接数据库
		lo.getConnection();

		TicketServer ts = new TicketServer();
		ts.Reader();

	}

}
