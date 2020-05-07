package controllerSa2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class VendeurController {
	
	public static void toutAfficher(JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn =  bdconnect.getConnection();
			String sql = "SELECT * FROM vendeur";
	         java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(RS));
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void ajouter(String nom, String prenom, String adresse, String numero, String mail, JTable table) throws SQLException {
		// TODO Auto-generated method stub
		boolean rs;
		String sql = "INSERT INTO vendeur (nom, prenom, adresse, numero, mail) VALUES (?,?,?,?,?)";
		Connection con = null;
		con =  bdconnect.getConnection(); // connection a la
		// BDD
		PreparedStatement pst = con.prepareStatement(sql); // preparation de la syntaxe SQL
		pst.setString(1,nom);
		pst.setString(2,prenom);
		pst.setString(3, adresse);
		pst.setString(4, numero);
		pst.setString(5, mail);
		rs = pst.execute(); // execution de la syntaxe SQL
		if (rs == false) {
			JOptionPane.showMessageDialog(null, "le vendeur a bien ete enregistrer");
			VendeurController.toutAfficher(table);
		} else {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
		
	}
	
	public static void supprVendeur(String mail, JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn =  bdconnect.getConnection();
			String sql = "Delete FROM vendeur where mail='"+mail+"'";
	        java.sql.Statement stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int RS = stmt.executeUpdate(sql);
			VendeurController.toutAfficher(table);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void modifVendeur(JTable table) {
		boolean rs;
		String sql;
		int row = table.getSelectedRow();
		//int col = table.getSelectedColumn();
          try {
        	  Connection conn = bdconnect.getConnection();
        	  sql = "UPDATE vendeur SET nom = ?, prenom = ?, adresse = ?, numero = ?, mail = ? WHERE id = ? ";
        	  PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, (String) table.getValueAt(row, 1));
			st.setString(2, (String) table.getValueAt(row, 2));
			st.setString(3, (String) table.getValueAt(row, 3));
			st.setInt(4, (int) table.getValueAt(row, 4));
			st.setString(5, (String) table.getValueAt(row, 5));
			st.setInt(6, (int) table.getValueAt(row, 0));
        	 rs = st.execute();
        	 st.close();
        	 if (rs == false) {
     			JOptionPane.showMessageDialog(null, "le modification a bien ete enregistrer");
     			VendeurController.toutAfficher(table);
     		} else {
     			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
     		}
          } catch (SQLException insertException) {
        	   System.out.println("Error:"+insertException.getMessage());
          }
        }

}
