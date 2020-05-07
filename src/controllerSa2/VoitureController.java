package controllerSa2;

import java.awt.Choice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class VoitureController {
	
	public static void toutAfficher(JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "SELECT * FROM voiture";
	         java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(RS));
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void DestDeroul(Choice txtModele) {
		// TODO Auto-generated method stub
		try{
	           Connection conn = bdconnect.getConnection();
	           java.sql.Statement stmt = conn.createStatement();
	           java.sql.ResultSet RS = stmt.executeQuery("SELECT modele FROM modele");
	           while(RS.next()) {
	              txtModele.addItem(RS.getString("modele"));
	           }
	           RS.close();
	           stmt.close();
	           conn.close();
	        } catch(Exception e){
	            System.out.println("Connexion impossible: "+e);
	            System.exit(-1);  
	        }
		
	}
	
	public static void DestCategorie(Choice txtCategorie) {
		// TODO Auto-generated method stub
		try{
	           Connection conn = bdconnect.getConnection();
	           java.sql.Statement stmt = conn.createStatement();
	           java.sql.ResultSet RS = stmt.executeQuery("SELECT categorie FROM categorie");
	           while(RS.next()) {
	              txtCategorie.addItem(RS.getString("categorie"));
	           }
	           RS.close();
	           stmt.close();
	           conn.close();
	        } catch(Exception e){
	            System.out.println("Connexion impossible: "+e);
	            System.exit(-1);  
	        }
		
	}
	public static void DestEntrepot(Choice txtEntrepot) {
		// TODO Auto-generated method stub
		try{
	           Connection conn = bdconnect.getConnection();
	           java.sql.Statement stmt = conn.createStatement();
	           java.sql.ResultSet RS = stmt.executeQuery("SELECT nom FROM entrepot");
	           while(RS.next()) {
	              txtEntrepot.addItem(RS.getString("nom"));
	           }
	           RS.close();
	           stmt.close();
	           conn.close();
	        } catch(Exception e){
	            System.out.println("Connexion impossible: "+e);
	            System.exit(-1);  
	        }
		
	}
	
	public static void ajouter(String marque, String modele, String categorie, String entrepot, JTable table) throws SQLException {
		// TODO Auto-generated method stub
		boolean rs;
		String sql = "INSERT INTO voiture (marque, modele, categorie, entrepot) VALUES (?,?,?,?)";
		Connection con = null;
		con = bdconnect.getConnection(); // connection a la
		// BDD
		PreparedStatement pst = con.prepareStatement(sql); // preparation de la syntaxe SQL
		pst.setString(1,marque);
		pst.setString(2,modele);
		pst.setString(3, categorie);
		pst.setString(4, entrepot);
		rs = pst.execute(); // execution de la syntaxe SQL
		if (rs == false) {
			JOptionPane.showMessageDialog(null, "la voiture a bien ete enregistrer");
			VoitureController.toutAfficher(table);
		} else {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
		
	}
	
	public static void supprVoiture(String identifiant, JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "Delete FROM voiture where id='"+identifiant+"'";
	        java.sql.Statement stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int RS = stmt.executeUpdate(sql);
			VoitureController.toutAfficher(table);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void modifVoiture(JTable table) {
		boolean rs;
		String sql;
		int row = table.getSelectedRow();
		//int col = table.getSelectedColumn();
          try {
        	  Connection conn = bdconnect.getConnection();
        	  sql = "UPDATE voiture SET marque = ?, modele = ?, categorie = ?, entrepot = ? WHERE id = ? ";
        	  PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, (String) table.getValueAt(row, 1));
			st.setString(2, (String) table.getValueAt(row, 2));
			st.setString(3, (String) table.getValueAt(row, 3));
			st.setString(4, (String) table.getValueAt(row, 4));
			st.setInt(5, (int) table.getValueAt(row, 0));
        	 rs = st.execute();
        	 st.close();
        	 if (rs == false) {
     			JOptionPane.showMessageDialog(null, "le modification a bien ete enregistrer");
     			VoitureController.toutAfficher(table);
     		} else {
     			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
     		}
          } catch (SQLException insertException) {
        	   System.out.println("Error:"+insertException.getMessage());
          }
        }

}
