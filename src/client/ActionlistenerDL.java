package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import client.one.UserLogin;

public class ActionlistenerDL extends UserLogin implements ActionListener {
	// ����TicketBooker������Ա��ڱ���ʹ��TicketBooker��ı���
	TicketBooker tb = new TicketBooker();

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// ���н��ı�����˺ż����븳ֵ���ַ��������ķ���
		super.getUserNum();
		super.getpasstword();
		// �����û������롾���롿���͸�������
		ClientDL c = new ClientDL();
		try {
			c.UserMessage();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�û���Ϣ����ʧ�ܣ�");
		}

	}
}
