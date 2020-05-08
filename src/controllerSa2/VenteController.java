package controllerSa2;

import java.awt.Choice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class VenteController {
	
	public static void DestVendeur(Choice txtVendeur) {
		// TODO Auto-generated method stub
		try{
	           Connection conn = bdconnect.getConnection();
	           java.sql.Statement stmt = conn.createStatement();
	           java.sql.ResultSet RS = stmt.executeQuery("SELECT nom FROM vendeur");
	           while(RS.next()) {
	              txtVendeur.addItem(RS.getString("nom"));
	           }
	           RS.close();
	           stmt.close();
	           conn.close();
	        } catch(Exception e){
	            System.out.println("Connexion impossible: "+e);
	            System.exit(-1);  
	        }
		
	}
	

	public static void DestMarque(Choice txtMarque) {
		// TODO Auto-generated method stub
		try{
	           Connection conn =  bdconnect.getConnection();
	           java.sql.Statement stmt = conn.createStatement();
	           java.sql.ResultSet RS = stmt.executeQuery("SELECT marque FROM marque");
	           while(RS.next()) {
	              txtMarque.addItem(RS.getString("marque"));
	           }
	           RS.close();
	           stmt.close();
	           conn.close();
	        } catch(Exception e){
	            System.out.println("Connexion impossible: "+e);
	            System.exit(-1);  
	        }
		
	}
	

	public static void ajouter(String vendeur, String marque, String modele, String client, String dateVente, JTable table) throws SQLException {
		// TODO Auto-generated method stub
		boolean rs;
		String sql = "INSERT INTO vente (vendeur, marque, modele, client, dateVente) VALUES (?,?,?,?,?)";
		Connection con = null;
		con =  bdconnect.getConnection(); // connection a la
		// BDD
		PreparedStatement pst = con.prepareStatement(sql); // preparation de la syntaxe SQL
		pst.setString(1,vendeur);
		pst.setString(2,marque);
		pst.setString(3,modele);
		pst.setString(4,client);
		pst.setString(5,dateVente);
		rs = pst.execute(); // execution de la syntaxe SQL
		if (rs == false) {
			String sql1 = "UPDATE stock SET stock.stock:=stock.stock-1 WHERE stock.marque = ? AND stock.modele = ?;";
			Connection con1 = null;
			con1 =  bdconnect.getConnection(); // connection a la
			// BDD
			PreparedStatement pst1 = con.prepareStatement(sql1); // preparation de la syntaxe SQL
			pst1.setString(1,marque);
			pst1.setString(2,modele);
			rs = pst1.execute();
			JOptionPane.showMessageDialog(null, "le vente a bien ete enregistrer");
			VenteController.toutAfficher(table);
		} else {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
		
	}
	
	public static void toutAfficher(JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn =  bdconnect.getConnection();
			String sql = "CALL afficherVente()";
	         java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(RS));
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
