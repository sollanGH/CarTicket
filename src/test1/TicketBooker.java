package test1;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.FlowLayout;

import javax.swing.*;

public class TicketBooker extends UserLogin {
	// 下拉菜单组件及面板组件
	static Choice ch01;
	static Choice ch02;
	static JComboBox box01;
	static JComboBox box02;
	static JComboBox box03;
	static JPanel panel1;
	static JPanel panel2;
	// 存取选择的出发点、终点、日期、时间
	static String Start;
	static String End;
	static String Year;
	static String Month;
	static String Day;
	static String Time;
	// 存取数据库表中数据
	static String time1;
	static String time2;
	static String time3;
	static String price1;
	static String price2;
	static String price3;
	static String ticket1;
	static String ticket2;
	static String ticket3;
	// 创建单选框
	static Checkbox jr1 = new Checkbox("10点", false);
	static Checkbox jr2 = new Checkbox("14点", false);
	static Checkbox jr3 = new Checkbox("17点", false);
	static Checkbox jr4 = new Checkbox("13点", false);
	static Checkbox jr5 = new Checkbox("16点", false);

	// TicketBooker类的构造方法
	public TicketBooker() {

	}

	public void Ticket() {
		ActionlistenerCX CX = new ActionlistenerCX();// 【查询】事件类创建对象
		ActionlistenerYD YD = new ActionlistenerYD();// 【预订】事件类创建对象

		String st01 = "南方学院";
		String st02 = "中大";
		String st03[] = { "2016", "2017", "2018", "2019" };
		String st04[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		String st05[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "10", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		frame = new JFrame("车票预订");
		panel1 = new JPanel();
		panel2 = new JPanel();
		// panel2.setBackground(Color.pink);
		panel2.setLayout(null);
		// 创建标签并设置内容
		JLabel label = new JLabel();
		label.setText("路线");

		JButton button01 = new JButton("查询");
		JButton button02 = new JButton("预订");
		// 带滑条的复选框，参数必须为String[]型
		box01 = new JComboBox(st03);
		box02 = new JComboBox(st04);
		box03 = new JComboBox(st05);
		// 不带滑条的复选框，参数必须为String类型
		ch01 = new Choice();
		ch02 = new Choice();
		// 增加列表项
		ch01.add(st01);
		ch01.add(st02);
		ch02.add(st01);
		ch02.add(st02);
		// 向面板1内添加组件
		panel1.setLayout(new FlowLayout());
		panel1.add(label);
		panel1.add(ch01);
		panel1.add(ch02);
		panel1.add(box01);
		panel1.add(box02);
		panel1.add(box03);
		panel1.add(button01);
		// 把各组件添加进框架
		frame.add(panel1, "North");
		frame.add(panel2);
		frame.add(button02, "South");

		button01.addActionListener(CX);// 【查询】按钮注册监听
		button02.addActionListener(YD);// 【预订】按钮注册监听
		// 设置框架的相关属性
		frame.setSize(600, 600);
		frame.setLocation(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// 显示获取到的查询信息
	public void getMessageNF() {
		// 定义表格组件
		String[] columnNames = { "票价", "余票", "发车时间" };
		String[][] tableValues = { { price1, ticket1, time1 }, { price2, ticket2, time2 }, { price3, ticket3, time3 } };
		JTable table = new JTable(tableValues, columnNames);// 参数分别为 【每一行的内容】、【列名】
		JScrollPane scrollPane = new JScrollPane(table);// 将表格加入滑轮面板中
		// 向面板2中添加相关组件，并设置位置。
		panel2.add(scrollPane);// 将滑轮面板添加到框架
		scrollPane.setBounds(90, 10, 400, 180);
		panel2.add(jr1);
		jr1.setBounds(140, 190, 100, 30);
		panel2.add(jr2);
		jr2.setBounds(240, 190, 100, 30);
		panel2.add(jr3);
		jr3.setBounds(340, 190, 100, 30);

		// System.out.println("10点余票:" + ticket1);
		// System.out.println("14点余票:" + ticket2);
		// System.out.println("17点余票:" + ticket3);
	}

	public void getMessageZD() {
		// 定义表格组件
		String[] columnNames = { "票价", "余票", "发车时间" };
		String[][] tableValues = { { price1, ticket1, time1 }, { price2, ticket2, time2 }, { price3, ticket3, time3 } };
		JTable table = new JTable(tableValues, columnNames);// 参数分别为 【每一行的内容】、【列名】
		JScrollPane scrollPane = new JScrollPane(table);// 将表格加入滑轮面板中
		// 向面板2中添加相关组件，并设置位置。
		panel2.add(scrollPane);// 将滑轮面板添加到框架
		scrollPane.setBounds(90, 10, 400, 180);
		panel2.add(jr1);
		jr1.setBounds(140, 190, 100, 30);
		panel2.add(jr4);
		jr4.setBounds(240, 190, 100, 30);
		panel2.add(jr5);
		jr5.setBounds(340, 190, 100, 30);
	}

	// 获取【出发站】、【终点站】的方法
	public void getStart() {
		Start = ch01.getSelectedItem();
		End = (String) ch02.getSelectedItem();
	}

	// 获取【年份】、【月份】、【日期】的方法
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
