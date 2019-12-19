package test1;

import java.sql.SQLException;

public class Ticketre extends ActionlistenerYD {

	public Ticketre() {
		String n1 = " '" + username + "'  ";
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
			// res = sql.executeQuery("select * from ticketre");// 查询数据
			// while (res.next()) {// 必须用while语句
			// String n2 = res.getString("name");
			// String s2 = res.getString("start");
			// String e2 = res.getString("end");
			// String d2 = res.getString("day");
			// String t2 = res.getString("time");
			// String p2 = res.getString("price");
			// System.out.println("姓名：" + n2);
			// System.out.println("出发站：" + s2);
			// System.out.println("终点站：" + e2);
			// System.out.println("日期：" + d2);
			// System.out.println("时间：" + t2);
			// System.out.println("票价：" + p2);
			// System.out.println();
			// }
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
