package test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//��Ԥ������ť����¼�
public class ActionlistenerYD extends ActionlistenerCX implements ActionListener {
	static int T;
	static String S;

	// ����Ʊ��-1����
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// ������վΪ�Ϸ�ѧԺʱ
		if (Start.equals("�Ϸ�ѧԺ")) {

			// ��ѡ��10�㵥ѡ�����������´���
			if (jr1.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from NF_start01 where time='10:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
//						new SoldOut();
						JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
					} else {
						sql.executeUpdate("update nf_start01 set ticket=ticket-1 where time='10:00:00'");
						res = sql.executeQuery("select ticket from NF_start01 where time='10:00:00'");
						while (res.next()) {
							String ticket = res.getString("ticket");
							System.out.println("�Ϸ�ѧԺ����10�����Ʊ��" + ticket);
						}
						Time = "10:00:00";
						new TicketReservation();// ���Ʊ��-1�ɹ�������ʾ��Ʊ�ɹ�
					}
				} catch (SQLException q) {
					q.printStackTrace();
					System.out.println("���ݿ�Ʊ��-1����ʧ��");
				}
			} // 10��

			// ��ѡ��14�㵥ѡ�����������´���
			if (jr2.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from nf_start01 where time='14:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
						JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
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
			if (jr3.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from nf_start01 where time='17:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
						JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
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
			if (jr1.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='10:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
						JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
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
			if (jr4.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='13:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
						JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
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
			if (jr5.getState()) {
				try {
					sql = con.createStatement();
					res = sql.executeQuery("select ticket from zd_start01 where time='16:00:00'");
					while (res.next()) {
						S = res.getString("ticket");
					}
					T = Integer.parseInt(S);// ��string��ת��Ϊint��
					if (T == 0) {
						JOptionPane.showMessageDialog(null, "��Ʊ�����꣡");
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

}
