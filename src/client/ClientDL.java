package client;

import java.io.*;

import message.Message;

public class ClientDL extends UserLogin {
	// 发送【账号】与【密码】到服务器的方法
	public void UserMessage() {
		// 输出
		try {
			Message me1 = new Message();
			// 给Message对象添加值
			me1.setName(userNum);
			me1.setPwd(pwd);
			// 将Message对象到对象输出流中
			oos.writeObject(me1);
		} catch (IOException w) {
			w.printStackTrace();
			System.out.println("客户端输出账户信息错误");

		}
	}

}
