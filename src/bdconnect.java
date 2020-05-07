import java.sql.Connection;
import java.sql.DriverManager;


public class bdconnect {
	
	public static Connection getConnection() {
		Connection con;
		try {
		con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sp2", "root", "");
		return con;
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
		
	}

}
