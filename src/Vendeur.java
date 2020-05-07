import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllerSa2.VendeurController;

import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Vendeur {

	JFrame frame;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAdresse;
	private JTextField txtNumero;
	private JTable table;
	private JTextField txtMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendeur window = new Vendeur();
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
	public Vendeur() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Vendeur(String role) {
		frame = new JFrame();
		frame.setBounds(100, 100, 719, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(35, 32, 46, 14);
		frame.getContentPane().add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(35, 77, 46, 14);
		frame.getContentPane().add(lblPrenom);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(35, 126, 61, 14);
		frame.getContentPane().add(lblAdresse);

		JLabel lblNumero = new JLabel("Numero :");
		lblNumero.setBounds(35, 171, 61, 14);
		frame.getContentPane().add(lblNumero);

		txtNom = new JTextField();
		txtNom.setBounds(141, 29, 133, 20);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtPrenom = new JTextField();
		txtPrenom.setBounds(141, 74, 133, 20);
		frame.getContentPane().add(txtPrenom);
		txtPrenom.setColumns(10);

		txtAdresse = new JTextField();
		txtAdresse.setBounds(141, 123, 133, 20);
		frame.getContentPane().add(txtAdresse);
		txtAdresse.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(141, 168, 133, 20);
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblMail = new JLabel("Mail :");
		lblMail.setBounds(321, 32, 46, 14);
		frame.getContentPane().add(lblMail);

		Button ajouter = new Button("+ Ajouter");
		ajouter.setBounds(623, 24, 70, 22);
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					VendeurController.ajouter(txtNom.getText(), txtPrenom.getText(), txtAdresse.getText(),
							txtNumero.getText(), txtMail.getText(), table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(ajouter);

		Button Supprimer = new Button("x Supprimer");
		Supprimer.setBounds(623, 99, 70, 22);
		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VendeurController.supprVendeur(txtMail.getText(), table);
			}
		});
		frame.getContentPane().add(Supprimer);

		Button modifier = new Button("Modifier");
		modifier.setBounds(623, 414, 70, 22);
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VendeurController.modifVendeur(table);
			}
		});
		frame.getContentPane().add(modifier);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 211, 683, 206);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		VendeurController.toutAfficher(table);

		txtMail = new JTextField();
		txtMail.setBounds(424, 29, 133, 20);
		frame.getContentPane().add(txtMail);
		txtMail.setColumns(10);

		JButton button = new JButton("<");
		button.setBounds(662, 0, 41, 23);
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
