package ai.arpwatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LanInfoDB {
	private Connection con;

	public LanInfoDB() {
        String url = "jdbc:mysql://ubokho1.ibrae/laninfo" +
                    "?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
		String name = "laninfo";
		String password = "laninfo00";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, name, password);
			Statement st = con.createStatement();
			String query = "select * from arp";
			ResultSet rs = st.executeQuery(query);
			printResults(rs);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void printResults(ResultSet rs) throws SQLException {
		String ip, mac , timecreate, timelast;
		
		while (rs.next()) {
			ip = rs.getString("ip");
			mac = rs.getString("mac");
			timecreate = rs.getString("timecreate");
			//timelast = rs.getDouble("timelast");
			timelast = rs.getString("timelast");
			System.out.println("******************************");
			System.out.println("IP: " + ip);
			System.out.println("MAC: " + mac);
			System.out.println("TimeCreate: " + timecreate);
			System.out.println("TimeLast: " + timelast);
			System.out.println("******************************");
		}
	}

	public static void main(String[] args) {
		
	}
}
