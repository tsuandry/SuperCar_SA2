import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Connexion {
	String role;

	private JFrame frame;
	private JTextField txtMail;
	private JPasswordField txtMdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion window = new Connexion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 377, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(71, 45, 48, 14);
		frame.getContentPane().add(lblEmail);

		txtMail = new JTextField();
		txtMail.setBounds(129, 42, 222, 20);
		frame.getContentPane().add(txtMail);
		txtMail.setColumns(10);

		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(36, 98, 92, 14);
		frame.getContentPane().add(lblMotDePasse);

		txtMdp = new JPasswordField();
		txtMdp.setBounds(129, 95, 222, 20);
		frame.getContentPane().add(txtMdp);

		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(128, 187, 109, 23);
		btnConnexion.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String userName = txtMail.getText();
				@SuppressWarnings("deprecation")
				String password = txtMdp.getText();

				if (userName.trim().length() == 0 || password.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Remplissez tous les champs SVP");
				} else {

					try {
						Connection connection = bdconnect.getConnection();

						PreparedStatement st = (PreparedStatement) connection
								.prepareStatement("Select * from utilisateur where mail=? and mdp=?");

						st.setString(1, userName);
						st.setString(2, password);

						ResultSet rs = st.executeQuery();
						if (rs.next()) {
							JOptionPane.showMessageDialog(btnConnexion, "Vous vous etes connecte avec succes");
							role = rs.getString(7);

							if (role.equals("Admin")) {
								Acceuil_admin window = new Acceuil_admin(role);
								window.frame.setVisible(true);
								frame.setVisible(false);

							} else if (role.equals("Manager")) {
								Acceuil_manager window = new Acceuil_manager(role);
								window.frame.setVisible(true);
								frame.setVisible(false);
							} else if (role.equals("Employes")) {
								Acceuil_employes window = new Acceuil_employes(role);
								window.frame.setVisible(true);
								frame.setVisible(false);
							}

						} else {
							JOptionPane.showMessageDialog(btnConnexion, "Mail ou mot de passe incorrecte");
						}
					} catch (SQLException sqlException) {
						sqlException.printStackTrace();
					}
				}
			}
		});
		frame.getContentPane().add(btnConnexion);

	}
}
