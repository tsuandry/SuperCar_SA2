package controllerSa2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class CategorieController {
	
	public static void toutAfficher(JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "SELECT * FROM categorie";
	         java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(RS));
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void ajouter(String categorie, JTable table) throws SQLException {
		// TODO Auto-generated method stub
		boolean rs;
		String sql = "INSERT INTO categorie (categorie) VALUES (?)";
		Connection con = null;
		con = bdconnect.getConnection(); // connection a la
		// BDD
		PreparedStatement pst = con.prepareStatement(sql); // preparation de la syntaxe SQL
		pst.setString(1,categorie);
		rs = pst.execute(); // execution de la syntaxe SQL
		if (rs == false) {
			JOptionPane.showMessageDialog(null, "la categorie a bien ete enregistrer");
			CategorieController.toutAfficher(table);
		} else {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
		
		
	}
	
	public static void supprCategorie(String categorie, JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();;
			String sql = "Delete FROM categorie where categorie='"+categorie+"'";
	        java.sql.Statement stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int RS = stmt.executeUpdate(sql);
			CategorieController.toutAfficher(table);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
