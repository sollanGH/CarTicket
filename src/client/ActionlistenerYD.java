package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

//��Ԥ������ť����¼�
public class ActionlistenerYD extends TicketBooker implements ActionListener {

	// ����Ʊ��-1����
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// �д����ʱ
		if (Start.equals("�д�")) {
			if (jr1.getState()) {
				cb1 = "true";
			}
			if (jr4.getState()) {
				cb4 = "true";
			}
			if (jr5.getState()) {
				cb5 = "true";
			}
			// ����ѡ���ѡ��������͸�������
			pw.println(cb1);
			pw.println(cb4);
			pw.println(cb5);
			System.out.println("�Ѿ���ѡ���ѡ��������͸�������");
		}
		// �Ϸ�ѧԺ����ʱ
		if (Start.equals("�Ϸ�ѧԺ")) {
			if (jr1.getState()) {
				cb1 = "true";
			}
			if (jr2.getState()) {
				cb2 = "true";
			}
			if (jr3.getState()) {
				cb3 = "true";
			}
			// ����ѡ���ѡ��������͸�������
			pw.println(cb1);
			pw.println(cb2);
			pw.println(cb3);
			System.out.println("�Ѿ���ѡ���ѡ��������͸�������");
		}
		try {
			NoTicket=br.readLine();
			Time=br.readLine();
			System.out.println("���յ���ûƱ���棺"+NoTicket);
			System.out.println("ѡ��ĳ˳�ʱ�䣺"+Time);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//�������Ʊ
		if(NoTicket.equals("false")) {
			new TicketReservation();// ���Ʊ��-1�ɹ�������ʾ��Ʊ�ɹ�
		}else{
			JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
		}

	}

}
