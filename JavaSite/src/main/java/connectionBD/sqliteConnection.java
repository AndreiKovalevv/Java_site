package connectionBD;

import java.sql.*;

public class sqliteConnection {	
	Connection conn = null;
	String url = "jdbc:sqlite:C:/Users/vagne/eclipse-workspace/JavaSite/src/main/dataBase/BD.db";
	
	public Connection dbConnector() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
			return conn;
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Кошмар");
			return null;
		}
	}
}
