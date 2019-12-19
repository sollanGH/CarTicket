package test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//【预订】按钮相关事件
public class ActionlistenerYD extends ActionlistenerCX implements ActionListener {
	static int T;
	static String S;

	// 进行票数-1操作
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// 当出发站为南方学院时
		if (Start.equals("南方学院")) {

			// 若选中10点单选框，则运行以下代码
			if (jr1.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from NF_start01 where time='10:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
//						new SoldOut();
						JOptionPane.showMessageDialog(null, "车票已售完！");
					} else {
						sql.executeUpdate("update nf_start01 set ticket=ticket-1 where time='10:00:00'");
						res = sql.executeQuery("select ticket from NF_start01 where time='10:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("南方学院出发10点的余票：" + ticket);
						}
						Time = "10:00:00";
						new TicketReservation();// 如果票数-1成功，则显示订票成功
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("数据库票数-1操作失败");
				}
			} // 10点

			// 若选中14点单选框，则运行以下代码
			if (jr2.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from nf_start01 where time='14:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
						JOptionPane.showMessageDialog(null, "车票已售完！");
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
			if (jr3.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from nf_start01 where time='17:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
						JOptionPane.showMessageDialog(null, "车票已售完！");
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
			if (jr1.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='10:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
						JOptionPane.showMessageDialog(null, "车票已售完！");
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
			if (jr4.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='13:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
						JOptionPane.showMessageDialog(null, "车票已售完！");
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
			if (jr5.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='16:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// 将string型转换为int型
					if (T == 0) {
						JOptionPane.showMessageDialog(null, "车票已售完！");
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

}
