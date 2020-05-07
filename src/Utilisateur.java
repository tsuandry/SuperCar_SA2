import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllerSa2.UtilisateurController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Utilisateur {

	JFrame frame;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtTel;
	private JTextField txtMail;
	private JTextField txtAdresse;
	private JTextField txtPoste;
	private JTable table;
	private JPasswordField txtMdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Utilisateur window = new Utilisateur();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param role
	 */
	public Utilisateur() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Utilisateur(String role) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 718, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(20, 11, 46, 14);
		frame.getContentPane().add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(20, 36, 74, 14);
		frame.getContentPane().add(lblPrenom);

		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setBounds(20, 61, 88, 14);
		frame.getContentPane().add(lblTelephone);

		txtNom = new JTextField();
		txtNom.setBounds(118, 8, 139, 20);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtPrenom = new JTextField();
		txtPrenom.setBounds(118, 33, 139, 20);
		frame.getContentPane().add(txtPrenom);
		txtPrenom.setColumns(10);

		txtTel = new JTextField();
		txtTel.setBounds(118, 58, 139, 20);
		frame.getContentPane().add(txtTel);
		txtTel.setColumns(10);

		JLabel lblMail = new JLabel("Mail :");
		lblMail.setBounds(356, 11, 76, 14);
		frame.getContentPane().add(lblMail);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(356, 36, 76, 14);
		frame.getContentPane().add(lblAdresse);

		JLabel lblPoste = new JLabel("Poste :");
		lblPoste.setBounds(356, 61, 76, 14);
		frame.getContentPane().add(lblPoste);

		txtMail = new JTextField();
		txtMail.setBounds(486, 8, 139, 20);
		frame.getContentPane().add(txtMail);
		txtMail.setColumns(10);

		txtAdresse = new JTextField();
		txtAdresse.setBounds(486, 33, 139, 20);
		frame.getContentPane().add(txtAdresse);
		txtAdresse.setColumns(10);

		txtPoste = new JTextField();
		txtPoste.setBounds(486, 58, 139, 20);
		frame.getContentPane().add(txtPoste);
		txtPoste.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 682, 136);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		UtilisateurController.toutAfficher(table);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					UtilisateurController.ajouter(txtNom.getText(), txtPrenom.getText(), txtTel.getText(),
							txtMail.getText(), txtAdresse.getText(), txtPoste.getText(), txtMdp.getText(), table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAjouter.setBounds(60, 124, 89, 23);
		frame.getContentPane().add(btnAjouter);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(278, 124, 113, 23);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UtilisateurController.supprUtilisateur(txtMail.getText(), table);
			}
		});
		frame.getContentPane().add(btnSupprimer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(517, 124, 89, 23);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UtilisateurController.modifUtilisateur(table);
			}
		});
		frame.getContentPane().add(btnModifier);

		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(190, 90, 88, 14);
		frame.getContentPane().add(lblMotDePasse);

		txtMdp = new JPasswordField();
		txtMdp.setBounds(293, 87, 139, 20);
		frame.getContentPane().add(txtMdp);

		JButton button = new JButton("<");
		button.setBounds(661, 7, 41, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
			}
		});
		frame.getContentPane().add(button);
	}
}
