package test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ActionlistenerDL extends UserLogin implements ActionListener {
	// ����TicketBooker������Ա��ڱ���ʹ��TicketBooker��ı���
	TicketBooker tb = new TicketBooker();

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// ���н��ı�����˺ż����븳ֵ���ַ��������ķ���
		super.getUserNum();
		super.getpasstword();

		// �����ݿⷢ�Ͳ�ѯָ���Լ��������ݿⷴ������Ϣ
		try {
			sql = con.createStatement();// ��Ҫ�����
			res = sql.executeQuery("select * from userlist");
			while (res.next()) {// Ҫ��ȡ���while()�Ǳ����
				String ID = res.getString("id");
				if (ID.equals(userNum)) {// ������֤���ݿ����˺ź������˺��Ƿ�ƥ��
					String PW = res.getString("password");// ����˺���Ϣƥ�䣬����ƥ��������Ϣ

					if (PW.equals(pwd)) {
						frame.setVisible(false);// ������һ�����ں��¼���ڲ�����
						username = res.getString("name");//�����ݿ���еġ�name������username
						tb.Ticket(); // ���°�ť���������¼���Ϊ ����TicketBooker���Ticket()����
					} else {
//						System.out.println("�����������");
//						new PasswordError();// �������������ʾ����
						JOptionPane.showMessageDialog(null,"�����������");
						break;
					}
				} else {
					// System.out.println("������һ����Ϣ......");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
