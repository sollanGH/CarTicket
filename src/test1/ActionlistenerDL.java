package test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ActionlistenerDL extends UserLogin implements ActionListener {
	// 创建TicketBooker类对象，以便在本类使用TicketBooker类的变量
	TicketBooker tb = new TicketBooker();

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// 运行将文本框的账号及密码赋值给字符串变量的方法
		super.getUserNum();
		super.getpasstword();

		// 向数据库发送查询指令以及接收数据库反馈的信息
		try {
			sql = con.createStatement();// 必要的语句
			res = sql.executeQuery("select * from userlist");
			while (res.next()) {// 要获取结果while()是必须的
				String ID = res.getString("id");
				if (ID.equals(userNum)) {// 逐条验证数据库中账号和输入账号是否匹配
					String PW = res.getString("password");// 如果账号信息匹配，接着匹配密码信息

					if (PW.equals(pwd)) {
						frame.setVisible(false);// 开启下一个窗口后登录窗口不可视
						username = res.getString("name");//将数据库表中的【name】赋予username
						tb.Ticket(); // 按下按钮所触发的事件设为 运行TicketBooker类的Ticket()方法
					} else {
//						System.out.println("输入密码错误！");
//						new PasswordError();// 密码输入错误提示窗口
						JOptionPane.showMessageDialog(null,"密码输入错误！");
						break;
					}
				} else {
					// System.out.println("加载下一条信息......");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
