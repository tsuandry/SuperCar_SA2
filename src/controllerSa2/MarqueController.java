package controllerSa2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class MarqueController {


	public static void toutAfficher(JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "SELECT * FROM marque";
	         java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(RS));
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void ajouter(String Marque, JTable table) throws SQLException {
		// TODO Auto-generated method stubMercedes-Ben
		boolean rs;
		String sql = "INSERT INTO marque (marque) VALUES (?)";
		Connection con = null;
		con = bdconnect.getConnection(); // connection a la
		// BDD
		PreparedStatement pst = con.prepareStatement(sql); // preparation de la syntaxe SQL
		pst.setString(1,Marque);
		rs = pst.execute(); // execution de la syntaxe SQL
		if (rs == false) {
			JOptionPane.showMessageDialog(null, "la marque a bien ete enregistrer");
			MarqueController.toutAfficher(table);
		} else {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
		
	}
	
	public static void supprMarque(String marque, JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "Delete FROM marque where marque='"+marque+"'";
	        java.sql.Statement stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int RS = stmt.executeUpdate(sql);
			MarqueController.toutAfficher(table);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
