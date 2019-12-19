package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

import client.ActionlistenerDL;

public class UserLogin {
	// GUI���
	static JFrame frame;
	static JButton button;
	static JTextField text;
	static JPasswordField password;
	static JLabel label01;
	static JLabel label02;
	static JLabel label03;
	// ����ͨ��
	static Socket socket;
	static ObjectOutputStream oos;
	static PrintWriter pw;
	static BufferedReader br;

	// �洢�û�ID������������
	static String userNum;
	static String name;
	static String pwd;
	// �˳���Ϣ
	static boolean Exit = true;

	// ��ȡ������û�ID
	public void getUserNum() {
		userNum = text.getText();
	}

	// ��ȡ������û�����
	public void getpasstword() {
		pwd = password.getText();
	}

	// ������
	public static void main(String[] args) {
		// ������ť���������
		ActionlistenerDL dl = new ActionlistenerDL();

		// ������� ��ܡ���ť���ı�������򡢱�ǩ
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

		// ���ӷ�����
		try {
			// ��������ַ���˿ں�
			socket = new Socket("127.0.0.1", 2333);
			System.out.println("�����ӵ�������");
			// �������������
			oos = new ObjectOutputStream(socket.getOutputStream());
			// �����ַ������
			pw = new PrintWriter(socket.getOutputStream(), true);
			// ��������������
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException w) {
			w.printStackTrace();
			System.out.println("�����������쳣");
		}
		// ���շ��صĵ�¼��֤��Ϣ
		try {
			String s = null;
			while (true) {
				s = br.readLine();// ��ȡ��¼��֤��Ϣ

				System.out.println("��ȡ����s��" + s);
				if (s.equals("true")) {
					System.out.println("�ͻ��˽��յ���¼��֤��Ϣtrue*********Successful User Login!!");
					name = br.readLine();// ��ȡ����
					System.out.println("��ȡ�����û������ǣ�" + name);
					frame.setVisible(false);// ������һ�����ں��¼���ڲ�����
					TicketBooker tb = new TicketBooker();
					tb.Ticket(); // ���°�ť���������¼���Ϊ ����TicketBooker���Ticket()����
					break;// �������������Ժ�����ѭ��
				} else {
					JOptionPane.showMessageDialog(null, "�û����������������");
				}

			}
			System.out.println("ѭ��������");
		} catch (IOException q) {
			System.out.println("��ȡ����������֤��Ϣʧ�ܣ�");
		}

	}
}
