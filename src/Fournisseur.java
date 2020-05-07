import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllerSa2.FournisseurController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Fournisseur {

	JFrame frame;
	private JTextField txtNom;
	private JTextField txtAdresse;
	private JTextField txtTelephone;
	private JTextField txtMail;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fournisseur window = new Fournisseur();
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
	public Fournisseur() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Fournisseur(String role) {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(115, 11, 65, 14);
		frame.getContentPane().add(lblNom);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(115, 49, 65, 14);
		frame.getContentPane().add(lblAdresse);

		JLabel lblTelephone = new JLabel("Telephone :");
		lblTelephone.setBounds(115, 92, 84, 14);
		frame.getContentPane().add(lblTelephone);

		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(115, 131, 65, 14);
		frame.getContentPane().add(lblEmail);

		txtNom = new JTextField();
		txtNom.setBounds(218, 8, 273, 20);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtAdresse = new JTextField();
		txtAdresse.setBounds(218, 46, 273, 20);
		frame.getContentPane().add(txtAdresse);
		txtAdresse.setColumns(10);

		txtTelephone = new JTextField();
		txtTelephone.setBounds(218, 89, 273, 20);
		frame.getContentPane().add(txtTelephone);
		txtTelephone.setColumns(10);

		txtMail = new JTextField();
		txtMail.setBounds(218, 128, 273, 20);
		frame.getContentPane().add(txtMail);
		txtMail.setColumns(10);

		JButton btnAjouter = new JButton("+ Ajouter");
		btnAjouter.setBounds(134, 174, 89, 23);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FournisseurController.ajouter(txtNom.getText(), txtAdresse.getText(), txtTelephone.getText(),
							txtMail.getText(), table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnAjouter);

		JButton btnXSupprimer = new JButton("x Supprimer");
		btnXSupprimer.setBounds(379, 174, 112, 23);
		btnXSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FournisseurController.supprFournisseur(txtMail.getText(), table);
			}
		});
		frame.getContentPane().add(btnXSupprimer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(605, 327, 89, 23);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FournisseurController.modifFournisseur(table);
			}
		});
		frame.getContentPane().add(btnModifier);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 205, 684, 129);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		FournisseurController.toutAfficher(table);

		JButton button = new JButton("<");
		button.setBounds(648, 7, 46, 23);
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
