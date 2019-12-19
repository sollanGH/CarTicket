package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import client.TicketReservation;

public class LoginSQL extends TicketServer {

	// �������ݿ�ķ���
	public Connection getConnection() {
		// �������ݿ�����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// System.out.println("�����������سɹ���");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
		// �������ݿ�
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "520ycsqlbegen");
			// System.out.println("���ݿ����ӳɹ���");
		} catch (SQLException w) {
			w.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
		return con;
	}

	/*-------------------------------------------------------------------------------*/

	// ��֤�û���¼��Ϣ
	public void loginSql() {
		// �����ݿⷢ�Ͳ�ѯָ���Լ��������ݿⷴ������Ϣ
		try {
			sql = con.createStatement();// ��Ҫ�����
			res = sql.executeQuery("select * from userlist");
			while (res.next()) {// Ҫ��ȡ���while()�Ǳ����
				String ID = res.getString("id");
				if (ID.equals(userNum)) {// ������֤���ݿ����˺ź������˺��Ƿ�ƥ��
					String PW = res.getString("password");// ����˺���Ϣƥ�䣬����ƥ��������Ϣ

					if (PW.equals(pwd)) {
						// ����֤��ȷ�ķ���������TickeServer
						super.MessageTrue();
						System.out.println("Message is True!");
						name = res.getString("name");// �����ݿ���еġ�name������name
					} else {
						super.MessageFalse();
						System.out.println("�����������");
						break;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*----------------------------------------------------------------------------------------*/

	// ��ȡѡ��ĳ����ص㡢ʱ����Ϣ
	public void CXmessage() {
		int c = 1;
		// ��ѡ�������Ϊ���Ϸ�ѧԺ��ʱ
		if (Start.equals("�Ϸ�ѧԺ") && Day.equals("1")) {
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
						System.out.println("����վ���Ϸ�ѧԺ");
						System.out.println("ʱ�䣺" + time1);
						System.out.println("�۸�:" + price1);
						System.out.println("��Ʊ:" + ticket1);
						System.out.println();
						break;
					case 2:
						time2 = res.getString("time");
						price2 = res.getString("price");
						ticket2 = res.getString("ticket");
						System.out.println("����վ���Ϸ�ѧԺ");
						System.out.println("ʱ�䣺" + time2);
						System.out.println("�۸�:" + price2);
						System.out.println("��Ʊ:" + ticket2);
						System.out.println();
						break;
					case 3:
						time3 = res.getString("time");
						price3 = res.getString("price");
						ticket3 = res.getString("ticket");
						System.out.println("����վ���Ϸ�ѧԺ");
						System.out.println("ʱ�䣺" + time3);
						System.out.println("�۸�:" + price3);
						System.out.println("��Ʊ:" + ticket3);
						System.out.println();
						break;
					}
					c++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// ��ѡ�������Ϊ���д�ʱ
		if (Start.equals("�д�") && Day.equals("1")) {
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
						System.out.println("����վ���д�");
						System.out.println("ʱ�䣺" + time1);
						System.out.println("�۸�:" + price1);
						System.out.println("��Ʊ:" + ticket1);
						System.out.println();
						break;
					case 2:
						time2 = res.getString("time");
						price2 = res.getString("price");
						ticket2 = res.getString("ticket");
						System.out.println("����վ���д�");
						System.out.println("ʱ�䣺" + time2);
						System.out.println("�۸�:" + price2);
						System.out.println("��Ʊ:" + ticket2);
						System.out.println();
						break;
					case 3:
						time3 = res.getString("time");
						price3 = res.getString("price");
						ticket3 = res.getString("ticket");
						System.out.println("����վ���д�");
						System.out.println("ʱ�䣺" + time3);
						System.out.println("�۸�:" + price3);
						System.out.println("��Ʊ:" + ticket3);
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

	// ����ѡƱ����
	public void CheckboxMessage() {

		// ������վΪ�Ϸ�ѧԺʱ
		if (Start.equals("�Ϸ�ѧԺ"))

		{

			// ��ѡ��10�㵥ѡ�����������´���
			if (jr1.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from NF_start01 where time='10:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
						NoTicket = "true";// ûƱ����
						//
					} else {
						sql.executeUpdate("update nf_start01 set ticket=ticket-1 where time='10:00:00'");
						res = sql.executeQuery("select ticket from NF_start01 where time='10:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("�Ϸ�ѧԺ����10�����Ʊ��" + ticket);
						}
						Time = "10:00:00";

					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("���ݿ�Ʊ��-1����ʧ��");
				}
			} // 10��

			// ��ѡ��14�㵥ѡ�����������´���
			if (jr2.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from nf_start01 where time='14:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
						NoTicket = "true";// ûƱ����
						System.out.println("��Ʊ���ۿ�");
						// JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
					} else {
						sql.executeUpdate("update nf_start01 set ticket=ticket-1 where time='14:00:00'");
						res = sql.executeQuery("select ticket from NF_start01 where time='14:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("�Ϸ�ѧԺ����14�����Ʊ��" + ticket);
						}
						Time = "14:00:00";
						new TicketReservation();// ���Ʊ��-1�ɹ�������ʾ��Ʊ�ɹ�
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("���ݿ�Ʊ��-1����ʧ��");
				}
			} // 14��

			// ��ѡ��17�㵥ѡ�����������´���
			if (jr3.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from nf_start01 where time='17:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
						NoTicket = "true";// ûƱ����
						System.out.println("��Ʊ���ۿ�");
						// JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
					} else {
						sql.executeUpdate("update nf_start01 set ticket=ticket-1 where time='17:00:00'");
						res = sql.executeQuery("select ticket from nf_start01 where time='17:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("�Ϸ�ѧԺ����17�����Ʊ��" + ticket);
						}
						Time = "17:00:00";
						new TicketReservation();// ���Ʊ��-1�ɹ�������ʾ��Ʊ�ɹ�
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("���ݿ�Ʊ��-1����ʧ��");
				}

			} // 17��
		} // if nf

		// ������վΪ�д�ʱ
		if (Start.equals("�д�")) {

			// ��ѡ��10�㵥ѡ�����������´���
			if (jr1.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='10:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
						NoTicket = "true";// ûƱ����
						System.out.println("��Ʊ���ۿ�");
						// JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
					} else {
						sql.executeUpdate("update zd_start01 set ticket=ticket-1 where time='10:00:00'");
						res = sql.executeQuery("select ticket from zd_start01 where time='10:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("�д����10�����Ʊ��" + ticket);
						}
						Time = "10:00:00";
						new TicketReservation();// ���Ʊ��-1�ɹ�������ʾ��Ʊ�ɹ�
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("���ݿ�Ʊ��-1����ʧ��");
				}
			} // 10��

			// ��ѡ��13�㵥ѡ�����������´���
			if (jr4.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='13:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
						NoTicket = "true";// ûƱ����
						System.out.println("��Ʊ���ۿ�");
						// JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
					} else {
						sql.executeUpdate("update zd_start01 set ticket=ticket-1 where time='13:00:00'");
						res = sql.executeQuery("select ticket from zd_start01 where time='13:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("�д����14�����Ʊ��" + ticket);
						}
						Time = "13:00:00";
						new TicketReservation();// ���Ʊ��-1�ɹ�������ʾ��Ʊ�ɹ�
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("���ݿ�Ʊ��-1����ʧ��");
				}
			} // 13��

			// ��ѡ��16�㵥ѡ�����������´���
			if (jr5.equals("true")) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='16:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
						NoTicket = "true";// ûƱ����
						System.out.println("��Ʊ���ۿ�");
						// JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
					} else {
						sql.executeUpdate("update zd_start01 set ticket=ticket-1 where time='16:00:00'");
						res = sql.executeQuery("select ticket from zd_start01 where time='16:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("�д����16�����Ʊ��" + ticket);
						}
						Time = "16:00:00";
						new TicketReservation();// ���Ʊ��-1�ɹ�������ʾ��Ʊ�ɹ�
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("���ݿ�Ʊ��-1����ʧ��");
				}

			} // 16��

		} // if zd
	}

	/*-----------------------------------------------------------------------------------------*/
	// �����ݿ����ɶ�Ʊ��Ϣ��
	public void Ticketre() {
		// ���ݿ�������ݱ���Ҫ�е����Ų�����
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
			System.out.println("���ݲ�����ɣ�");
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
