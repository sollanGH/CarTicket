package client;

import java.io.*;

import message.Message;

public class ClientDL extends UserLogin {
	// ���͡��˺š��롾���롿���������ķ���
	public void UserMessage() {
		// ���
		try {
			Message me1 = new Message();
			// ��Message�������ֵ
			me1.setName(userNum);
			me1.setPwd(pwd);
			// ��Message���󵽶����������
			oos.writeObject(me1);
		} catch (IOException w) {
			w.printStackTrace();
			System.out.println("�ͻ�������˻���Ϣ����");

		}
	}

}
