package test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
//����ѯ����ť����¼�
public class ActionlistenerCX extends TicketBooker implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent q) {
		int c = 1;
		getDay();// ʹ�ø����ж���ķ�������ȡ�ˡ���ݡ������·ݡ��������ڡ�ֵ
		getStart();// ʹ�ø����ж���ķ�������ȡ�ˡ�����վ�������յ�վ��ֵ
		
		//��ѡ�������Ϊ���Ϸ�ѧԺ��ʱ
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
//						System.out.println();
//						System.out.println("����վ���Ϸ�ѧԺ");
//						System.out.println("ʱ�䣺" + time1);
//						System.out.println("�۸�:" + price1);
//						System.out.println("��Ʊ:" + ticket1);
//						System.out.println();
						break;
					case 2:
						time2 = res.getString("time");
						price2 = res.getString("price");
						ticket2 = res.getString("ticket");
//						System.out.println("����վ���Ϸ�ѧԺ");
//						System.out.println("ʱ�䣺" + time2);
//						System.out.println("�۸�:" + price2);
//						System.out.println("��Ʊ:" + ticket2);
//						System.out.println();
						break;
					case 3:
						time3 = res.getString("time");
						price3 = res.getString("price");
						ticket3 = res.getString("ticket");
//						System.out.println("����վ���Ϸ�ѧԺ");
//						System.out.println("ʱ�䣺" + time3);
//						System.out.println("�۸�:" + price3);
//						System.out.println("��Ʊ:" + ticket3);
//						System.out.println();
						break;
					}
					c++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//�����ݿ��е���Ϣ��ȡ������TicketBooker������ʾ�������Ϣ�ķ���
			getMessageNF();
		}
		
		//��ѡ�������Ϊ���д�ʱ
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
//						System.out.println();
//						System.out.println("����վ���д�");
//						System.out.println("ʱ�䣺" + time1);
//						System.out.println("�۸�:" + price1);
//						System.out.println("��Ʊ:" + ticket1);
//						System.out.println();
						break;
					case 2:
						time2 = res.getString("time");
						price2 = res.getString("price");
						ticket2 = res.getString("ticket");
//						System.out.println("����վ���д�");
//						System.out.println("ʱ�䣺" + time2);
//						System.out.println("�۸�:" + price2);
//						System.out.println("��Ʊ:" + ticket2);
//						System.out.println();
						break;
					case 3:
						time3 = res.getString("time");
						price3 = res.getString("price");
						ticket3 = res.getString("ticket");
						System.out.println("����վ���д�");
//						System.out.println("ʱ�䣺" + time3);
//						System.out.println("�۸�:" + price3);
//						System.out.println("��Ʊ:" + ticket3);
//						System.out.println();
						break;
					}
					c++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//�����ݿ��е���Ϣ��ȡ������TicketBooker������ʾ�������Ϣ�ķ���
			getMessageZD();
		}
	}

}
