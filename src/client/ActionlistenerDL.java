package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import client.one.UserLogin;

public class ActionlistenerDL extends UserLogin implements ActionListener {
	// 创建TicketBooker类对象，以便在本类使用TicketBooker类的变量
	TicketBooker tb = new TicketBooker();

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// 运行将文本框的账号及密码赋值给字符串变量的方法
		super.getUserNum();
		super.getpasstword();
		// 将【用户名】与【密码】传送给服务器
		ClientDL c = new ClientDL();
		try {
			c.UserMessage();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("用户信息发送失败！");
		}

	}
}
