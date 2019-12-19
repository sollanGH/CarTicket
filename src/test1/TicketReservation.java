package test1;

import java.awt.event.*;

import javax.swing.*;

public class TicketReservation extends ActionlistenerCX {// 车票预订查询
	
	//构造方法
	public TicketReservation() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("您已订票成功！");
		JButton button = new JButton("查看信息");
		frame.setLayout(null);
		frame.add(label);
		label.setBounds(100, 20, 100, 20);
		frame.add(button);
		//设置按钮事件
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) { // 查看订票信息事件
				
				frame.setVisible(false);
				
				JFrame fr = new JFrame("票务信息");
				JLabel lbN = new JLabel(username);
				JLabel lbS = new JLabel(Start);
				JLabel lbE = new JLabel(End);
				JLabel lbY = new JLabel(Year+"年");
				JLabel lbM = new JLabel(Month+"月");
				JLabel lbD = new JLabel(Day+"日");
				JLabel lbT = new JLabel(Time);

				JLabel lb6 = new JLabel("乘客姓名：");
				JLabel lb7 = new JLabel("出发车站：");
				JLabel lb8 = new JLabel("终点车站：");
				JLabel lb9 = new JLabel("发车日期：");
				JLabel lb10 = new JLabel("出发时间：");

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
