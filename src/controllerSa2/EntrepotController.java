package controllerSa2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class EntrepotController {
	
	public static void toutAfficher(JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "SELECT * FROM entrepot";
	         java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(RS));
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}


	public static void ajouter(String nom, String adresse, String telephone, JTable table) throws SQLException {
		// TODO Auto-generated method stub
		boolean rs;
		String sql = "INSERT INTO entrepot (nom, adresse, telephone) VALUES (?,?,?)";
		Connection con = null;
		con = bdconnect.getConnection(); // connection a la
		// BDD
		PreparedStatement pst = con.prepareStatement(sql); // preparation de la syntaxe SQL
		pst.setString(1,nom);
		pst.setString(2,adresse);
		pst.setString(3, telephone);
		rs = pst.execute(); // execution de la syntaxe SQL
		if (rs == false) {
			JOptionPane.showMessageDialog(null, "l'entrepot a bien ete enregistrer");
			EntrepotController.toutAfficher(table);
		} else {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
		
	}
	
	public static void supprEntrepot(String telephone, JTable table) {
		// TODO Auto-generated method stub
		try {
			Connection conn = bdconnect.getConnection();
			String sql = "Delete FROM entrepot where telephone='"+telephone+"'";
	        java.sql.Statement stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int RS = stmt.executeUpdate(sql);
			EntrepotController.toutAfficher(table);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void modifEntrepot(JTable table) {
		boolean rs;
		String sql;
		int row = table.getSelectedRow();
		//int col = table.getSelectedColumn();
          try {
        	  Connection conn = bdconnect.getConnection();
        	  sql = "UPDATE entrepot SET nom = ?, adresse = ?, telephone = ? WHERE id = ? ";
        	  PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, (String) table.getValueAt(row, 1));
			st.setString(2, (String) table.getValueAt(row, 2));
			st.setInt(3, (int) table.getValueAt(row, 3));
			st.setInt(4, (int) table.getValueAt(row, 0));
        	 rs = st.execute();
        	 st.close();
        	 if (rs == false) {
     			JOptionPane.showMessageDialog(null, "le modification a bien ete enregistrer");
     			EntrepotController.toutAfficher(table);
     		} else {
     			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
     		}
          } catch (SQLException insertException) {
        	   System.out.println("Error:"+insertException.getMessage());
          }
        }
	
		
	
}
