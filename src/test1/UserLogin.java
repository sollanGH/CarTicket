package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class UserLogin {
	// GUI���
	static JFrame frame;
	static JButton button;
	static JTextField text;
	static JPasswordField password;
	static JLabel label01;
	static JLabel label02;
	static JLabel label03;	
	// ���ݿ�����ӿ�
	static Connection con;
	static Statement sql;
	static ResultSet res;
	//�洢�û�ID������������
	static String userNum;
	static String username;
	static String pwd;

	// ��ȡ������û�ID
	public void getUserNum() {
		userNum = text.getText();
	}

	// ��ȡ������û�����
	public void getpasstword() {
		pwd = password.getText();
	}

	// �������ݿ�ķ���
	public Connection getConnection() {
		// �������ݿ�����
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("�����������سɹ���");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
		// �������ݿ�
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "520ycsqlbegen");
//			System.out.println("���ݿ����ӳɹ���");
		} catch (SQLException w) {
			w.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
		return con;
	}

	// ������
	public static void main(String[] args) {
		// ������ť���������
		ActionlistenerDL dl = new ActionlistenerDL();
		// �����������
		UserLogin login = new UserLogin();
		// �������ݿ�
		login.getConnection();
		//������� ��ܡ���ť���ı�������򡢱�ǩ
		frame = new JFrame("�û���¼");
		button = new JButton("��¼");
		text = new JTextField();
		password = new JPasswordField();
		label01 = new JLabel("�˺�");
		label02 = new JLabel("����");
		frame.setLayout(null);// �����ֹ���������Ϊ�գ�������Ĭ�ϵ�

		// ����˺��ı���
		frame.add(label01);
		label01.setBounds(250, 60, 50, 30);// ���á��˺š���X-Y���꣬�Լ���͸ߵĲ���
		frame.add(text);
		text.setBounds(250, 90, 150, 30);

		// ��������ı���
		frame.add(label02);
		label02.setBounds(250, 120, 50, 30);
		frame.add(password);
		password.setBounds(250, 150, 150, 30);

		// ��Ӱ�ť
		frame.add(button);
		button.setBounds(250, 200, 70, 40);

		button.addActionListener(dl);// �ԡ���¼����ťע������¼�
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocation(600, 300);
		frame.setVisible(true);
	}
}
