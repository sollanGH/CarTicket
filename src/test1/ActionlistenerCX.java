package test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
//【查询】按钮相关事件
public class ActionlistenerCX extends TicketBooker implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent q) {
		int c = 1;
		getDay();// 使用父类中定义的方法，获取了【年份】、【月份】、【日期】值
		getStart();// 使用父类中定义的方法，获取了【出发站】、【终点站】值
		
		//当选择出发点为【南方学院】时
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
//						System.out.println();
//						System.out.println("出发站：南方学院");
//						System.out.println("时间：" + time1);
//						System.out.println("价格:" + price1);
//						System.out.println("余票:" + ticket1);
//						System.out.println();
						break;
					case 2:
						time2 = res.getString("time");
						price2 = res.getString("price");
						ticket2 = res.getString("ticket");
//						System.out.println("出发站：南方学院");
//						System.out.println("时间：" + time2);
//						System.out.println("价格:" + price2);
//						System.out.println("余票:" + ticket2);
//						System.out.println();
						break;
					case 3:
						time3 = res.getString("time");
						price3 = res.getString("price");
						ticket3 = res.getString("ticket");
//						System.out.println("出发站：南方学院");
//						System.out.println("时间：" + time3);
//						System.out.println("价格:" + price3);
//						System.out.println("余票:" + ticket3);
//						System.out.println();
						break;
					}
					c++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//将数据库中的信息提取后运行TicketBooker类中显示【表格】信息的方法
			getMessageNF();
		}
		
		//当选择出发点为【中大】时
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
//						System.out.println();
//						System.out.println("出发站：中大");
//						System.out.println("时间：" + time1);
//						System.out.println("价格:" + price1);
//						System.out.println("余票:" + ticket1);
//						System.out.println();
						break;
					case 2:
						time2 = res.getString("time");
						price2 = res.getString("price");
						ticket2 = res.getString("ticket");
//						System.out.println("出发站：中大");
//						System.out.println("时间：" + time2);
//						System.out.println("价格:" + price2);
//						System.out.println("余票:" + ticket2);
//						System.out.println();
						break;
					case 3:
						time3 = res.getString("time");
						price3 = res.getString("price");
						ticket3 = res.getString("ticket");
						System.out.println("出发站：中大");
//						System.out.println("时间：" + time3);
//						System.out.println("价格:" + price3);
//						System.out.println("余票:" + ticket3);
//						System.out.println();
						break;
					}
					c++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//将数据库中的信息提取后运行TicketBooker类中显示【表格】信息的方法
			getMessageZD();
		}
	}

}
