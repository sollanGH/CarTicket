package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

//【预订】按钮相关事件
public class ActionlistenerYD extends TicketBooker implements ActionListener {

	// 进行票数-1操作
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// 中大出发时
		if (Start.equals("中大")) {
			if (jr1.getState()) {
				cb1 = "true";
			}
			if (jr4.getState()) {
				cb4 = "true";
			}
			if (jr5.getState()) {
				cb5 = "true";
			}
			// 将【选择框】选择情况发送给服务器
			pw.println(cb1);
			pw.println(cb4);
			pw.println(cb5);
			System.out.println("已经将选择框选择情况发送个服务器");
		}
		// 南方学院出发时
		if (Start.equals("南方学院")) {
			if (jr1.getState()) {
				cb1 = "true";
			}
			if (jr2.getState()) {
				cb2 = "true";
			}
			if (jr3.getState()) {
				cb3 = "true";
			}
			// 将【选择框】选择情况发送给服务器
			pw.println(cb1);
			pw.println(cb2);
			pw.println(cb3);
			System.out.println("已经将选择框选择情况发送个服务器");
		}
		try {
			NoTicket=br.readLine();
			Time=br.readLine();
			System.out.println("接收到的没票警告："+NoTicket);
			System.out.println("选择的乘车时间："+Time);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//如果还有票
		if(NoTicket.equals("false")) {
			new TicketReservation();// 如果票数-1成功，则显示订票成功
		}else{
			JOptionPane.showMessageDialog(null, "车票已售完！");
		}

	}

}
