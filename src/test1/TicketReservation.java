package test1;

import java.awt.event.*;

import javax.swing.*;

public class TicketReservation extends ActionlistenerCX {// ��ƱԤ����ѯ
	
	//���췽��
	public TicketReservation() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("���Ѷ�Ʊ�ɹ���");
		JButton button = new JButton("�鿴��Ϣ");
		frame.setLayout(null);
		frame.add(label);
		label.setBounds(100, 20, 100, 20);
		frame.add(button);
		//���ð�ť�¼�
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) { // �鿴��Ʊ��Ϣ�¼�
				
				frame.setVisible(false);
				
				JFrame fr = new JFrame("Ʊ����Ϣ");
				JLabel lbN = new JLabel(username);
				JLabel lbS = new JLabel(Start);
				JLabel lbE = new JLabel(End);
				JLabel lbY = new JLabel(Year+"��");
				JLabel lbM = new JLabel(Month+"��");
				JLabel lbD = new JLabel(Day+"��");
				JLabel lbT = new JLabel(Time);

				JLabel lb6 = new JLabel("�˿�������");
				JLabel lb7 = new JLabel("������վ��");
				JLabel lb8 = new JLabel("�յ㳵վ��");
				JLabel lb9 = new JLabel("�������ڣ�");
				JLabel lb10 = new JLabel("����ʱ�䣺");

				fr.setLayout(null);

				fr.add(lbN);
				lbN.setBounds(120, 10, 300, 30);
				fr.add(lbS);
				lbS.setBounds(120, 60, 300, 30);
				fr.add(lbE);
				lbE.setBounds(120, 110, 300, 30);
				fr.add(lbY);
				lbY.setBounds(120, 160, 300, 30);
				fr.add(lbM);
				lbM.setBounds(180, 160, 300, 30);
				fr.add(lbD);
				lbD.setBounds(210, 160, 300, 30);
				fr.add(lbT);
				lbT.setBounds(120, 210, 300, 30);

				fr.add(lb6);
				lb6.setBounds(10, 10, 100, 30);
				fr.add(lb7);
				lb7.setBounds(10, 60, 100, 30);
				fr.add(lb8);
				lb8.setBounds(10, 110, 100, 30);
				fr.add(lb9);
				lb9.setBounds(10, 160, 100, 30);
				fr.add(lb10);
				lb10.setBounds(10, 210, 100, 30);

				fr.setBounds(700, 350, 400, 400);
				// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				fr.setVisible(true);
				
				new Ticketre();

			}
		});

		button.setBounds(98, 120, 88, 30);
		frame.setBounds(750, 350, 300, 200);
		frame.setVisible(true);
	}

	// public static void main(String[] args) {
	// TicketReservation sollan = new TicketReservation();
	// sollan.loginsql();
	// }
}
