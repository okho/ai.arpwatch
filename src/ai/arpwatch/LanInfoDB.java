package ai.arpwatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			//Statement st = con.createStatement();
			//String query = "select * from arp";
			//ResultSet rs = st.executeQuery(query);
			//printResults(rs);
			//con.close();
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

	public String sIP(String textIP) {
		String res="", ip, mac , timecreate, timelast;
	
	    try {
	    	
	    	
	    	PreparedStatement st = con.prepareStatement ("select * from arp where ip = ?"); 
	    	st.setString (1, textIP); 
	    	
		    //Statement st = con.createStatement();
		    //String query = "select * from arp where ip = " + textIP;
		    ResultSet rs = st.executeQuery();

		    while (rs.next()) {
		    	ip = rs.getString("ip");
		    	mac = rs.getString("mac");
		    	timecreate = rs.getString("timecreate");
		    	//timelast = rs.getDouble("timelast");
		    	timelast = rs.getString("timelast");
		    	res += "\n******************************";
		    	res += "\nIP: " + ip;
		    	res += "\nMAC: " + mac;
		    	res += "\nTimeCreate: " + timecreate;
		    	res += "\nTimeLast: " + timelast;
		    	res += "\n******************************";
		    	
		    }
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	    return res;
	    
	}

}
