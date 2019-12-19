package server;

import java.sql.*;
import java.sql.Statement;
	//此类为外挂，能将车票为0的车次的车票变为5
public class SoldOut {

	static Connection con;
	static Statement sql;
	static ResultSet res;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException w) {
			w.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "520ycsqlbegen");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void setNFticket() {
		try {
			sql = con.createStatement();
			sql.executeUpdate("update nf_start01 set ticket=5 where ticket=0");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setZDticket() {
		try {
			sql = con.createStatement();
			sql.executeUpdate("update zd_start01 set ticket=5 where ticket=0");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SoldOut sollan=new SoldOut();
		sollan.getConnection();
		sollan.setNFticket();
		sollan.setZDticket();
	}
}
