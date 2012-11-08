package ai.arpwatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class JdbcLan {

	JdbcLan() {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://ubokho1.ibrae/laninfo";
            String name = "laninfo";
            String password = "laninfo00";
            try {
                Connection con = DriverManager.getConnection(url, name, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
}
