package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//【查询】按钮相关事件
public class ActionlistenerCX extends TicketBooker implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent q) {

		getDay();// 使用父类中定义的方法，获取了【年份】、【月份】、【日期】值
		getStart();// 使用父类中定义的方法，获取了【出发站】、【终点站】值
		pw.println(Start);
		pw.println(End);
		pw.println(Year);
		pw.println(Month);
		pw.println(Day);
		System.out.println(Start);
		System.out.println(End);
		System.out.println(Year);
		System.out.println(Month);
		System.out.println(Day);
		System.out.println("发送选择信息完毕");
		// 获取数据库中的信息
		try {
			time1 = br.readLine();
			time2 = br.readLine();
			time3 = br.readLine();
			price1 = br.readLine();
			price2 = br.readLine();
			price3 = br.readLine();
			ticket1 = br.readLine();
			ticket2 = br.readLine();
			ticket3 = br.readLine();
			System.out.println("接收到服务器数据库内的信息：");
			System.out.println("时间1：" + time1 + "\t" + "时间2：" + time2 + "\t" + "时间3：" + time3 + "\n" + "票价1：" + price1
					+ "\t" + "票价2：" + price2 + "\t" + "票价3：" + price3 + "\n" + "余票1：" + ticket1 + "\t" + "余票2："
					+ ticket2 + "\t" + "余票3：" + ticket3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 将数据库中的信息提取后运行TicketBooker类中显示【表格】信息的方法
		
		//中大出发时
		if (Start.equals("中大")) {
			getMessageZD();
		}
		//南方学院出发时
		if (Start.equals("南方学院")) {
			getMessageNF();
		}
	}

}
