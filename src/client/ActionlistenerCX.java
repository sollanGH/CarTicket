package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//����ѯ����ť����¼�
public class ActionlistenerCX extends TicketBooker implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent q) {

		getDay();// ʹ�ø����ж���ķ�������ȡ�ˡ���ݡ������·ݡ��������ڡ�ֵ
		getStart();// ʹ�ø����ж���ķ�������ȡ�ˡ�����վ�������յ�վ��ֵ
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
		System.out.println("����ѡ����Ϣ���");
		// ��ȡ���ݿ��е���Ϣ
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
			System.out.println("���յ����������ݿ��ڵ���Ϣ��");
			System.out.println("ʱ��1��" + time1 + "\t" + "ʱ��2��" + time2 + "\t" + "ʱ��3��" + time3 + "\n" + "Ʊ��1��" + price1
					+ "\t" + "Ʊ��2��" + price2 + "\t" + "Ʊ��3��" + price3 + "\n" + "��Ʊ1��" + ticket1 + "\t" + "��Ʊ2��"
					+ ticket2 + "\t" + "��Ʊ3��" + ticket3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// �����ݿ��е���Ϣ��ȡ������TicketBooker������ʾ�������Ϣ�ķ���
		
		//�д����ʱ
		if (Start.equals("�д�")) {
			getMessageZD();
		}
		//�Ϸ�ѧԺ����ʱ
		if (Start.equals("�Ϸ�ѧԺ")) {
			getMessageNF();
		}
	}

}
