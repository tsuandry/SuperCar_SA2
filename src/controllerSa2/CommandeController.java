package controllerSa2;

import java.awt.Choice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class CommandeController {
	
	public static void toutAfficher(JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "SELECT * FROM commande";
	         java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(RS));
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void ajouter(String fournisseur, String modele, String marque, String entrepot, String date, String employes, String nombre, JTable table) throws SQLException {
		// TODO Auto-generated method stub
		boolean rs;
		String sql = "INSERT INTO commande (fournisseur, modele, marque, entrepot, date, employes, nombre) VALUES (?,?,?,?,?,?,?)";
		Connection con = null;
		con = bdconnect.getConnection(); // connection a la
		// BDD
		PreparedStatement pst = con.prepareStatement(sql); // preparation de la syntaxe SQL
		pst.setString(1,fournisseur);
		pst.setString(2,modele);
		pst.setString(3,marque);
		pst.setString(4,entrepot);
		pst.setString(5,date);
		pst.setString(6,employes);
		pst.setString(7,nombre);
		rs = pst.execute(); // execution de la syntaxe SQL
		if (rs == false) {
			JOptionPane.showMessageDialog(null, "le commande a bien ete enregistrer");
			CommandeController.toutAfficher(table);
		} else {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
		
	}
	
	public static void DestFournisseur(Choice txtFournisseur) {
		// TODO Auto-generated method stub
		try{
	           Connection conn =bdconnect.getConnection();
	           java.sql.Statement stmt = conn.createStatement();
	           java.sql.ResultSet RS = stmt.executeQuery("SELECT nom FROM fournisseur");
	           while(RS.next()) {
	              txtFournisseur.addItem(RS.getString("nom"));
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
	           Connection conn = bdconnect.getConnection();
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
	
	public static void DestEmployes(Choice txtEmployes) {
		// TODO Auto-generated method stub
		try{
	           Connection conn = bdconnect.getConnection();
	           java.sql.Statement stmt = conn.createStatement();
	           java.sql.ResultSet RS = stmt.executeQuery("SELECT nom FROM employes");
	           while(RS.next()) {
	              txtEmployes.addItem(RS.getString("nom"));
	           }
	           RS.close();
	           stmt.close();
	           conn.close();
	        } catch(Exception e){
	            System.out.println("Connexion impossible: "+e);
	            System.exit(-1);  
	        }
		
	}
	
	public static void supprCommande(String NCommande, JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "Delete FROM commande where n_commande='"+NCommande+"'";
	        java.sql.Statement stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int RS = stmt.executeUpdate(sql);
			CommandeController.toutAfficher(table);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void modifCommande(JTable table) {
		boolean rs;
		String sql;
		int row = table.getSelectedRow();
		//int col = table.getSelectedColumn();
          try {
        	  Connection conn = bdconnect.getConnection();
        	  sql = "UPDATE commande SET fournisseur = ?, modele = ?, marque = ?, entrepot = ?, date = ?, employes = ?, nombre = ? WHERE n_commande = ? ";
        	  PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, (String) table.getValueAt(row, 1));
			st.setString(2, (String) table.getValueAt(row, 2));
			st.setString(3, (String) table.getValueAt(row, 3));
			st.setString(4, (String) table.getValueAt(row, 4));
			st.setString(5, (String) table.getValueAt(row, 5));
			st.setString(6, (String) table.getValueAt(row, 6));
			st.setInt(7, (int) table.getValueAt(row, 7));
			st.setInt(8, (int) table.getValueAt(row, 0));
        	 rs = st.execute();
        	 st.close();
        	 if (rs == false) {
     			JOptionPane.showMessageDialog(null, "le modification a bien ete enregistrer");
     			CommandeController.toutAfficher(table);
     		} else {
     			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
     		}
          } catch (SQLException insertException) {
        	   System.out.println("Error:"+insertException.getMessage());
          }
        }
	


}
