package controllerSa2;

import java.awt.Choice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class ModelController {
	
	public static void toutAfficher(JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn =  bdconnect.getConnection();
			String sql = "SELECT * FROM modele";
	         java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(RS));
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void ajouter(String NomModel, String Marque, JTable table) throws SQLException {
		// TODO Auto-generated method stub
		boolean rs;
		String sql = "INSERT INTO modele (marque, modele) VALUES (?,?)";
		Connection con = null;
		con =  bdconnect.getConnection(); // connection a la
		// BDD
		PreparedStatement pst = con.prepareStatement(sql); // preparation de la syntaxe SQL
		pst.setString(1,Marque);
		pst.setString(2,NomModel);
		rs = pst.execute(); // execution de la syntaxe SQL
		if (rs == false) {
			JOptionPane.showMessageDialog(null, "le modele a bien ete enregistrer");
			ModelController.toutAfficher(table);
		} else {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
		
	}

	public static void DestDeroul(Choice txtMarque) {
		// TODO Auto-generated method stub
		try{
	           Connection conn =  bdconnect.getConnection();
	           java.sql.Statement stmt = conn.createStatement();
	           java.sql.ResultSet RS = stmt.executeQuery("SELECT marque FROM marque");
	           while(RS.next()) {
	              txtMarque.addItem(RS.getString("Marque"));
	           }
	           RS.close();
	           stmt.close();
	           conn.close();
	        } catch(Exception e){
	            System.out.println("Connexion impossible: "+e);
	            System.exit(-1);  
	        }
		
	}
	
	public static void supprModele(String modele, JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn =  bdconnect.getConnection();
			String sql = "Delete FROM modele where modele='"+modele+"'";
	        java.sql.Statement stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int RS = stmt.executeUpdate(sql);
			ModelController.toutAfficher(table);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
