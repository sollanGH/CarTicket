package test1;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.FlowLayout;

import javax.swing.*;

public class TicketBooker extends UserLogin {
	// �����˵������������
	static Choice ch01;
	static Choice ch02;
	static JComboBox box01;
	static JComboBox box02;
	static JComboBox box03;
	static JPanel panel1;
	static JPanel panel2;
	// ��ȡѡ��ĳ����㡢�յ㡢���ڡ�ʱ��
	static String Start;
	static String End;
	static String Year;
	static String Month;
	static String Day;
	static String Time;
	// ��ȡ���ݿ��������
	static String time1;
	static String time2;
	static String time3;
	static String price1;
	static String price2;
	static String price3;
	static String ticket1;
	static String ticket2;
	static String ticket3;
	// ������ѡ��
	static Checkbox jr1 = new Checkbox("10��", false);
	static Checkbox jr2 = new Checkbox("14��", false);
	static Checkbox jr3 = new Checkbox("17��", false);
	static Checkbox jr4 = new Checkbox("13��", false);
	static Checkbox jr5 = new Checkbox("16��", false);

	// TicketBooker��Ĺ��췽��
	public TicketBooker() {

	}

	public void Ticket() {
		ActionlistenerCX CX = new ActionlistenerCX();// ����ѯ���¼��ഴ������
		ActionlistenerYD YD = new ActionlistenerYD();// ��Ԥ�����¼��ഴ������

		String st01 = "�Ϸ�ѧԺ";
		String st02 = "�д�";
		String st03[] = { "2016", "2017", "2018", "2019" };
		String st04[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		String st05[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "10", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		frame = new JFrame("��ƱԤ��");
		panel1 = new JPanel();
		panel2 = new JPanel();
		// panel2.setBackground(Color.pink);
		panel2.setLayout(null);
		// ������ǩ����������
		JLabel label = new JLabel();
		label.setText("·��");

		JButton button01 = new JButton("��ѯ");
		JButton button02 = new JButton("Ԥ��");
		// �������ĸ�ѡ�򣬲�������ΪString[]��
		box01 = new JComboBox(st03);
		box02 = new JComboBox(st04);
		box03 = new JComboBox(st05);
		// ���������ĸ�ѡ�򣬲�������ΪString����
		ch01 = new Choice();
		ch02 = new Choice();
		// �����б���
		ch01.add(st01);
		ch01.add(st02);
		ch02.add(st01);
		ch02.add(st02);
		// �����1��������
		panel1.setLayout(new FlowLayout());
		panel1.add(label);
		panel1.add(ch01);
		panel1.add(ch02);
		panel1.add(box01);
		panel1.add(box02);
		panel1.add(box03);
		panel1.add(button01);
		// �Ѹ������ӽ����
		frame.add(panel1, "North");
		frame.add(panel2);
		frame.add(button02, "South");

		button01.addActionListener(CX);// ����ѯ����ťע�����
		button02.addActionListener(YD);// ��Ԥ������ťע�����
		// ���ÿ�ܵ��������
		frame.setSize(600, 600);
		frame.setLocation(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// ��ʾ��ȡ���Ĳ�ѯ��Ϣ
	public void getMessageNF() {
		// ���������
		String[] columnNames = { "Ʊ��", "��Ʊ", "����ʱ��" };
		String[][] tableValues = { { price1, ticket1, time1 }, { price2, ticket2, time2 }, { price3, ticket3, time3 } };
		JTable table = new JTable(tableValues, columnNames);// �����ֱ�Ϊ ��ÿһ�е����ݡ�����������
		JScrollPane scrollPane = new JScrollPane(table);// �������뻬�������
		// �����2�������������������λ�á�
		panel2.add(scrollPane);// �����������ӵ����
		scrollPane.setBounds(90, 10, 400, 180);
		panel2.add(jr1);
		jr1.setBounds(140, 190, 100, 30);
		panel2.add(jr2);
		jr2.setBounds(240, 190, 100, 30);
		panel2.add(jr3);
		jr3.setBounds(340, 190, 100, 30);

		// System.out.println("10����Ʊ:" + ticket1);
		// System.out.println("14����Ʊ:" + ticket2);
		// System.out.println("17����Ʊ:" + ticket3);
	}

	public void getMessageZD() {
		// ���������
		String[] columnNames = { "Ʊ��", "��Ʊ", "����ʱ��" };
		String[][] tableValues = { { price1, ticket1, time1 }, { price2, ticket2, time2 }, { price3, ticket3, time3 } };
		JTable table = new JTable(tableValues, columnNames);// �����ֱ�Ϊ ��ÿһ�е����ݡ�����������
		JScrollPane scrollPane = new JScrollPane(table);// �������뻬�������
		// �����2�������������������λ�á�
		panel2.add(scrollPane);// �����������ӵ����
		scrollPane.setBounds(90, 10, 400, 180);
		panel2.add(jr1);
		jr1.setBounds(140, 190, 100, 30);
		panel2.add(jr4);
		jr4.setBounds(240, 190, 100, 30);
		panel2.add(jr5);
		jr5.setBounds(340, 190, 100, 30);
	}

	// ��ȡ������վ�������յ�վ���ķ���
	public void getStart() {
		Start = ch01.getSelectedItem();
		End = (String) ch02.getSelectedItem();
	}

	// ��ȡ����ݡ������·ݡ��������ڡ��ķ���
	public void getDay() {
		Year = (String) box01.getSelectedItem();
		Month = (String) box02.getSelectedItem();
		Day = (String) box03.getSelectedItem();

	}

	// public static void main(String[] args) {
	// TicketBooker sollan = new TicketBooker();
	// sollan.Ticket();
	// sollan.getConnection();
	// }
}
