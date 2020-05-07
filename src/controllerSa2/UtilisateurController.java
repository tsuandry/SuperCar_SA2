package controllerSa2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class UtilisateurController {
	
	public static void toutAfficher(JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "SELECT * FROM utilisateur";
	         java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(RS));
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void ajouter(String Nom, String Prenom, String Tel, String Mail, String Adresse, String Poste, String Mdp, JTable table) throws SQLException {
		// TODO Auto-generated method stub
		boolean rs;
		String sql = "INSERT INTO utilisateur (nom, prenom, telephone, mail, adresse, poste, mdp) VALUES (?,?,?,?,?,?,?)";
		Connection con = null;
		con = bdconnect.getConnection(); // connection a la
		// BDD
		PreparedStatement pst = con.prepareStatement(sql); // preparation de la syntaxe SQL
		pst.setString(1,Nom);
		pst.setString(2,Prenom);
		pst.setString(3, Tel);
		pst.setString(4, Mail);
		pst.setString(5, Adresse);
		pst.setString(6, Poste);
		pst.setString(7, Mdp);
		rs = pst.execute(); // execution de la syntaxe SQL
		if (rs == false) {
			JOptionPane.showMessageDialog(null, "l'utilisateur a bien ete enregistrer");
			UtilisateurController.toutAfficher(table);
		} else {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
		
	}

	public static void supprUtilisateur(String mail, JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "Delete FROM utilisateur where mail='"+mail+"'";
	        java.sql.Statement stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int RS = stmt.executeUpdate(sql);
			UtilisateurController.toutAfficher(table);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void modifUtilisateur(JTable table) {
		boolean rs;
		String sql;
		int row = table.getSelectedRow();
		//int col = table.getSelectedColumn();
          try {
        	  Connection conn = bdconnect.getConnection();
        	  sql = "UPDATE utilisateur SET nom = ?, prenom = ?, telephone = ?, mail = ?, adresse = ?, poste = ?, mdp = ? WHERE id = ? ";
        	  PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, (String) table.getValueAt(row, 1));
			st.setString(2, (String) table.getValueAt(row, 2));
			st.setInt(3, (int) table.getValueAt(row, 3));
			st.setString(4, (String) table.getValueAt(row, 4));
			st.setString(5, (String) table.getValueAt(row, 5));
			st.setString(6, (String) table.getValueAt(row, 6));
			st.setString(7, (String) table.getValueAt(row, 7));
			st.setInt(8, (int) table.getValueAt(row, 0));
        	 rs = st.execute();
        	 st.close();
        	 if (rs == false) {
     			JOptionPane.showMessageDialog(null, "le modification a bien ete enregistrer");
     			UtilisateurController.toutAfficher(table);
     		} else {
     			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
     		}
          } catch (SQLException insertException) {
        	   System.out.println("Error:"+insertException.getMessage());
          }
        }
	
}
