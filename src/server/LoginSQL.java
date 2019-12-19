package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import client.TicketReservation;

public class LoginSQL extends TicketServer {

	// 连接数据库的方法
	public Connection getConnection() {
		// 加载数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// System.out.println("数据驱动加载成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败！");
		}
		// 连接数据库
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "520ycsqlbegen");
			// System.out.println("数据库连接成功！");
		} catch (SQLException w) {
			w.printStackTrace();
			System.out.println("数据库连接失败！");
		}
		return con;
	}

	/*-------------------------------------------------------------------------------*/

	// 验证用户登录信息
	public void loginSql() {
		// 向数据库发送查询指令以及接收数据库反馈的信息
		try {
			sql = con.createStatement();// 必要的语句
			res = sql.executeQuery("select * from userlist");
			while (res.next()) {// 要获取结果while()是必须的
				String ID = res.getString("id");
				if (ID.equals(userNum)) {// 逐条验证数据库中账号和输入账号是否匹配
					String PW = res.getString("password");// 如果账号信息匹配，接着匹配密码信息

					if (PW.equals(pwd)) {
						// 将验证正确的反馈反馈给TickeServer
						super.MessageTrue();
						System.out.println("Message is True!");
						name = res.getString("name");// 将数据库表中的【name】赋予name
					} else {
						super.MessageFalse();
						System.out.println("密码输入错误！");
						break;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*----------------------------------------------------------------------------------------*/

	// 获取选择的出发地点、时间信息
	public void CXmessage() {
		int c = 1;
		// 当选择出发点为【南方学院】时
		if (Start.equals("南方学院") && Day.equals("1")) {
			try {
				sql = con.createStatement();
				res = sql.executeQuery("select * from nf_start01");
				while (res.next()) {
					switch (c) {
					case 1:
						time1 = res.getString("time");
						price1 = res.getString("price");
						ticket1 = res.getString("ticket");
						System.out.println();
						System.out.println("出发站：南方学院");
						System.out.println("时间：" + time1);
						System.out.println("价格:" + price1);
						System.out.println("余票:" + ticket1);
						System.out.println();
						break;
					case 2:
						time2 = res.getString("time");
						price2 = res.getString("price");
						ticket2 = res.getString("ticket");
						System.out.println("出发站：南方学院");
						System.out.println("时间：" + time2);
						System.out.println("价格:" + price2);
						System.out.println("余票:" + ticket2);
						System.out.println();
						break;
					case 3:
						time3 = res.getString("time");
						price3 = res.getString("price");
						ticket3 = res.getString("ticket");
						System.out.println("出发站：南方学院");
						System.out.println("时间：" + time3);
						System.out.println("价格:" + price3);
						System.out.println("余票:" + ticket3);
						System.out.println();
						break;
					}
					c++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 当选择出发点为【中大】时
		if (Start.equals("中大") && Day.equals("1")) {
			try {
				sql = con.createStatement();
				res = sql.executeQuery("select * from zd_start01");
				while (res.next()) {
					switch (c) {
					case 1:
						time1 = res.getString("time");
						price1 = res.getString("price");
						ticket1 = res.getString("ticket");
						System.out.println();
						System.out.println("出发站：中大");
						System.out.println("时间：" + time1);
						System.out.println("价格:" + price1);
						System.out.println("余票:" + ticket1);
						System.out.println();
						break;
					case 2:
						time2 = res.getString("time");
						price2 = res.getString("price");
						ticket2 = res.getString("ticket");
						System.out.println("出发站：中大");
						System.out.println("时间：" + time2);
						System.out.println("价格:" + price2);
						System.out.println("余票:" + ticket2);
						System.out.println();
						break;
					case 3:
						time3 = res.getString("time");
						price3 = res.getString("price");
						ticket3 = res.getString("ticket");
						System.out.println("出发站：中大");
						System.out.println("时间：" + time3);
						System.out.println("价格:" + price3);
						System.out.println("余票:" + ticket3);
						System.out.println();
						break;
					}
					c++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	/*----------------------------------------------------------------------------------*/

	// 进行选票操作
	public void CheckboxMessage() {

		// 当出发站为南方学院时
		if (Start.equals("南方学院"))

		{

			// 若选中10点单选框，则运行以下代码
			if (jr1.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from NF_start01 where time='10:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
						NoTicket = "true";// 没票警告
						//
					} else {
						sql.executeUpdate("update nf_start01 set ticket=ticket-1 where time='10:00:00'");
						res = sql.executeQuery("select ticket from NF_start01 where time='10:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("南方学院出发10点的余票：" + ticket);
						}
						Time = "10:00:00";

					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("数据库票数-1操作失败");
				}
			} // 10点

			// 若选中14点单选框，则运行以下代码
			if (jr2.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from nf_start01 where time='14:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
						NoTicket = "true";// 没票警告
						System.out.println("车票已售空");
						// JOptionPane.showMessageDialog(null, "车票已售完！");
					} else {
						sql.executeUpdate("update nf_start01 set ticket=ticket-1 where time='14:00:00'");
						res = sql.executeQuery("select ticket from NF_start01 where time='14:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("南方学院出发14点的余票：" + ticket);
						}
						Time = "14:00:00";
						new TicketReservation();// 如果票数-1成功，则显示订票成功
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("数据库票数-1操作失败");
				}
			} // 14点

			// 若选中17点单选框，则运行以下代码
			if (jr3.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from nf_start01 where time='17:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
						NoTicket = "true";// 没票警告
						System.out.println("车票已售空");
						// JOptionPane.showMessageDialog(null, "车票已售完！");
					} else {
						sql.executeUpdate("update nf_start01 set ticket=ticket-1 where time='17:00:00'");
						res = sql.executeQuery("select ticket from nf_start01 where time='17:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("南方学院出发17点的余票：" + ticket);
						}
						Time = "17:00:00";
						new TicketReservation();// 如果票数-1成功，则显示订票成功
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("数据库票数-1操作失败");
				}

			} // 17点
		} // if nf

		// 当出发站为中大时
		if (Start.equals("中大")) {

			// 若选中10点单选框，则运行以下代码
			if (jr1.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='10:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
						NoTicket = "true";// 没票警告
						System.out.println("车票已售空");
						// JOptionPane.showMessageDialog(null, "车票已售完！");
					} else {
						sql.executeUpdate("update zd_start01 set ticket=ticket-1 where time='10:00:00'");
						res = sql.executeQuery("select ticket from zd_start01 where time='10:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("中大出发10点的余票：" + ticket);
						}
						Time = "10:00:00";
						new TicketReservation();// 如果票数-1成功，则显示订票成功
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("数据库票数-1操作失败");
				}
			} // 10点

			// 若选中13点单选框，则运行以下代码
			if (jr4.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='13:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
						NoTicket = "true";// 没票警告
						System.out.println("车票已售空");
						// JOptionPane.showMessageDialog(null, "车票已售完！");
					} else {
						sql.executeUpdate("update zd_start01 set ticket=ticket-1 where time='13:00:00'");
						res = sql.executeQuery("select ticket from zd_start01 where time='13:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("中大出发14点的余票：" + ticket);
						}
						Time = "13:00:00";
						new TicketReservation();// 如果票数-1成功，则显示订票成功
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("数据库票数-1操作失败");
				}
			} // 13点

			// 若选中16点单选框，则运行以下代码
			if (jr5.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='16:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
						NoTicket = "true";// 没票警告
						System.out.println("车票已售空");
						// JOptionPane.showMessageDialog(null, "车票已售完！");
					} else {
						sql.executeUpdate("update zd_start01 set ticket=ticket-1 where time='16:00:00'");
						res = sql.executeQuery("select ticket from zd_start01 where time='16:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("中大出发16点的余票：" + ticket);
						}
						Time = "16:00:00";
						new TicketReservation();// 如果票数-1成功，则显示订票成功
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("数据库票数-1操作失败");
				}

			} // 16点

		} // if zd
	}

	/*-----------------------------------------------------------------------------------------*/
	// 在数据库生成订票信息表
	public void Ticketre() {
		// 数据库插入数据必须要有单引号才行呢
		String n1 = " '" + name + "'  ";
		String s1 = " '" + Start + "'  ";
		String e1 = " '" + End + "'  ";
		String y1 = " '" + Year + "'  ";
		String m1 = " '" + Month + "'  ";
		String d1 = " '" + Day + "'  ";
		String t1 = " '" + Time + "'  ";
		String p1 = " '" + price1 + "'  ";
		try {
			sql = con.createStatement();
			sql.executeUpdate("insert into ticketre (start,end,name,year,month,day,time,price)  values  (" + s1 + ","
					+ e1 + "," + n1 + "," + y1 + "," + m1 + "," + d1 + "," + t1 + "," + p1 + ")");
			System.out.println("数据插入完成！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("生成票务表数据失败！");
			System.out.println("姓名：" + n1);
			System.out.println("出发站：" + s1);
			System.out.println("终点站：" + e1);
			System.out.println("日期：" + d1);
			System.out.println("时间：" + t1);
			System.out.println("票价：" + p1);
			System.out.println();
		}
	}
}
