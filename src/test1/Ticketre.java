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
			// res = sql.executeQuery("select * from ticketre");// ��ѯ����
			// while (res.next()) {// ������while���
			// String n2 = res.getString("name");
			// String s2 = res.getString("start");
			// String e2 = res.getString("end");
			// String d2 = res.getString("day");
			// String t2 = res.getString("time");
			// String p2 = res.getString("price");
			// System.out.println("������" + n2);
			// System.out.println("����վ��" + s2);
			// System.out.println("�յ�վ��" + e2);
			// System.out.println("���ڣ�" + d2);
			// System.out.println("ʱ�䣺" + t2);
			// System.out.println("Ʊ�ۣ�" + p2);
			// System.out.println();
			// }
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����Ʊ�������ʧ�ܣ�");

			System.out.println("������" + n1);
			System.out.println("����վ��" + s1);
			System.out.println("�յ�վ��" + e1);
			System.out.println("���ڣ�" + d1);
			System.out.println("ʱ�䣺" + t1);
			System.out.println("Ʊ�ۣ�" + p1);
			System.out.println();
		}
	}

}
