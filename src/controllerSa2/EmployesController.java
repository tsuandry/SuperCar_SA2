package controllerSa2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class EmployesController {
	
	public static void toutAfficher(JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "SELECT * FROM employes";
	         java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(RS));
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void ajouter(String Nom, String Prenom, String Tel, String Poste, String Mail, String Mdp, JTable table) throws SQLException {
		// TODO Auto-generated method stub
		boolean rs;
		String sql = "INSERT INTO employes (nom, prenom, telephone, Poste, mail, mdp) VALUES (?,?,?,?,?,?)";
		Connection con = null;
		con = bdconnect.getConnection(); // connection a la
		// BDD
		PreparedStatement pst = con.prepareStatement(sql); // preparation de la syntaxe SQL
		pst.setString(1,Nom);
		pst.setString(2,Prenom);
		pst.setString(3, Tel);
		pst.setString(4, Poste);
		pst.setString(5, Mail);
		pst.setString(6, Mdp);
		rs = pst.execute(); // execution de la syntaxe SQL
		if (rs == false) {
			JOptionPane.showMessageDialog(null, "l'employes a bien ete enregistrer");
			EmployesController.toutAfficher(table);
		} else {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
		
	}
	
	public static void supprEmployes(String Mail, JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "Delete FROM employes where mail='"+Mail+"'";
	        java.sql.Statement stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int RS = stmt.executeUpdate(sql);
			EmployesController.toutAfficher(table);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void modifEmployes(JTable table) {
		boolean rs;
		String sql;
		int row = table.getSelectedRow();
		//int col = table.getSelectedColumn();
          try {
        	  Connection conn = bdconnect.getConnection();
        	  sql = "UPDATE employes SET nom = ?, prenom = ?, telephone = ?, poste = ?, mail = ?, mdp = ? WHERE id = ? ";
        	  PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, (String) table.getValueAt(row, 1));
			st.setString(2, (String) table.getValueAt(row, 2));
			st.setInt(3, (int) table.getValueAt(row, 3));
			st.setString(4, (String) table.getValueAt(row, 4));
			st.setString(5, (String) table.getValueAt(row, 5));
			st.setString(6, (String) table.getValueAt(row, 6));
			st.setInt(7, (int) table.getValueAt(row, 0));
        	 rs = st.execute();
        	 st.close();
        	 if (rs == false) {
     			JOptionPane.showMessageDialog(null, "le modification a bien ete enregistrer");
     			EmployesController.toutAfficher(table);
     		} else {
     			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
     		}
          } catch (SQLException insertException) {
        	   System.out.println("Error:"+insertException.getMessage());
          }
        }

}
