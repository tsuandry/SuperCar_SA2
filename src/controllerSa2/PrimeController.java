package controllerSa2;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class PrimeController {

	public static void toutAfficher(JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn =  bdconnect.getConnection();
			String sql = "SELECT * FROM prime";
	         java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(RS));
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
