package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import message.Message;

//��Ҫ���ܣ���ȡ�˻����˺š��롾���롿
public class TicketServer {

	// ���ݿ�����ӿ�
	static Connection con;
	static Statement sql;
	static ResultSet res;
	// ����ͨ��
	static ServerSocket server;
	static ObjectInputStream ois;
	static BufferedReader br;
	static PrintWriter pw;
	// ������Ķ���
	static LoginSQL lo = new LoginSQL();
	static TicketServer ticketserver = new TicketServer();
	// ���ڴ�����յ����˺š����롢����
	static String userNum;
	static String pwd;
	static String name;
	// ���ڴ��������Ƿ���ȷ����Ϣ
	private static String loginMessage = "false";
	private static String loginMessageP = "true";
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
	// ��ȡѡ����ѡ��״̬
	static String jr1 = "false";
	static String jr2 = "false";
	static String jr3 = "false";
	static String jr4 = "false";
	static String jr5 = "false";
	// ��Ʊ������Ϣ�Ƿ�Ϊ0��֤
	static String NoTicket = "false";

	int T = 0;
	String S = null;

	private void Reader() {
		try {
			// ����һ��socket��ͻ��˶Խ�
			Socket so = server.accept();
			System.out.println(so.getInetAddress().getHostAddress() + "�ͻ���������");
			// ��������������������
			ois = new ObjectInputStream(so.getInputStream());
			// ����������
			br = new BufferedReader(new InputStreamReader(so.getInputStream()));
			while (true) {
				// ���������еĶ����ݴ���one��
				Object one = ois.readObject();
				// ��oneǿתΪMessage�����
				Message me = (Message) one;
				// ��ȡ�����ڵġ��˺š��롾���롿
				userNum = me.getName();
				pwd = me.getPwd();

				System.out.println("�ͻ��˴������˺���Ϣ:" + userNum);
				System.out.println("�ͻ��˴�����������Ϣ:" + pwd);

				// �������ݿⲢ��֤��¼��Ϣ
				lo.loginSql();

				System.out.println("�˻���Ϣ��֤״̬" + loginMessage);
				System.out.println("��¼�������״̬" + loginMessageP);

				// ���˺ż��������֤������ظ��ͻ���
				try {
					pw = new PrintWriter(so.getOutputStream(), true);
					pw.println(loginMessage);
					System.out.println("�ѷ��ͼ�����Ϣ���ͻ���");
					if (loginMessage.equals("true")) {
						pw.println(name);
						System.out.println("�ѷ����������ͻ��ˣ�" + name);
						// ���տͻ��˵ġ������ء������յ㡿������ݡ������·ݡ��������ڡ�����ʱ�䡿
						Start = br.readLine();
						End = br.readLine();
						Year = br.readLine();
						Month = br.readLine();
						Day = br.readLine();
						System.out.println("���յ���ѡ�������");
						System.out.println("����վ��" + Start + "\t" + "�յ�վ:" + End + "\t" + "���:" + Year + "\t" + "�·�:"
								+ Month + "\t" + "����:" + Day);
						// �������ݿ��ѯ��ǰ��Ʊ״��
						lo.CXmessage();
						// �����ݿ��ѯ������Ϣ���ظ��ͻ���
						pw.println(time1);
						pw.println(time2);
						pw.println(time3);
						pw.println(price1);
						pw.println(price2);
						pw.println(price3);
						pw.println(ticket1);
						pw.println(ticket2);
						pw.println(ticket3);
						System.out.println("����Ʊ����Ϣ���");
						// ����ѡ���ѡ�����
						if (Start.equals("�Ϸ�ѧԺ")) {
							jr1 = br.readLine();
							jr2 = br.readLine();
							jr3 = br.readLine();
							System.out.println("ѡ���ѡ�������" + jr1 + "\t" + jr2 + "\t" + jr3);
						}
						if (Start.equals("�д�")) {
							jr1 = br.readLine();
							jr4 = br.readLine();
							jr5 = br.readLine();
							System.out.println("ѡ���ѡ�������" + jr1 + "\t" + jr4 + "\t" + jr5);
						}
						// ����ѡƱ����
						lo.CheckboxMessage();
						pw.println(NoTicket);
						pw.println(Time);
						// ������Ʊ��-1������ɣ��ͽ���Ʊ��Ϣ�浽���ݿ�
						if (NoTicket.equals("false")) {
							lo.Ticketre();
						}
						System.out.println("�Ѿ���ûƱ���漰�˳�ʱ�䷢�͸��ͻ���");

						break;// ���������ˣ�����ѭ��
					}

				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("���ݿ���֤��Ϣ���ݸ��ͻ���ʱ����");
				}

			}
			// �ͷ���Դ
			System.out.println("�ر���Դ��伴������");
			pw.close();
			br.close();
			ois.close();
			so.close();
			server.close();
			con.close();
			System.out.println("�ر���Դ������������");
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	// ��֤��Ϣ��ȷ
	public void MessageTrue() {

		loginMessage = "true";
	}

	// ��֤��Ϣ����
	public void MessageFalse() {
		loginMessageP = "false";
	}

	// ������
	public static void main(String[] args) {
		// ����������
		try {
			// �����������׽��֣��������ӿں�
			server = new ServerSocket(2333);
			System.out.println("�������ѿ���");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		// �������ݿ�
		lo.getConnection();

		TicketServer ts = new TicketServer();
		ts.Reader();

	}

}
