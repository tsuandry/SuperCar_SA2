import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllerSa2.EmployesController;

import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Employes {

	JFrame frame;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtTel;
	private JTextField txtId;
	private JTextField txtMail;
	private JTextField txtmdp;
	private JTable table;
	private JTextField txtPoste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employes window = new Employes();
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
	public Employes() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Employes(String role) {
		frame = new JFrame();
		frame.setBounds(100, 100, 718, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(24, 26, 46, 14);
		frame.getContentPane().add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(24, 61, 69, 14);
		frame.getContentPane().add(lblPrenom);

		JLabel lblTelephone = new JLabel("Telephone :");
		lblTelephone.setBounds(24, 97, 69, 14);
		frame.getContentPane().add(lblTelephone);

		JLabel lblIdentifiant = new JLabel("Identifiant :");
		lblIdentifiant.setBounds(24, 139, 69, 14);
		frame.getContentPane().add(lblIdentifiant);

		txtNom = new JTextField();
		txtNom.setBounds(106, 23, 125, 20);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtPrenom = new JTextField();
		txtPrenom.setBounds(106, 58, 125, 20);
		frame.getContentPane().add(txtPrenom);
		txtPrenom.setColumns(10);

		txtTel = new JTextField();
		txtTel.setBounds(106, 94, 125, 20);
		frame.getContentPane().add(txtTel);
		txtTel.setColumns(10);

		txtId = new JTextField();
		txtId.setBounds(103, 136, 128, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblPoste = new JLabel("Poste :");
		lblPoste.setBounds(288, 26, 46, 14);
		frame.getContentPane().add(lblPoste);

		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(288, 61, 46, 14);
		frame.getContentPane().add(lblEmail);

		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(288, 97, 88, 14);
		frame.getContentPane().add(lblMotDePasse);

		txtPoste = new JTextField();
		txtPoste.setBounds(372, 23, 125, 20);
		frame.getContentPane().add(txtPoste);
		txtPoste.setColumns(10);

		txtMail = new JTextField();
		txtMail.setBounds(372, 58, 125, 20);
		frame.getContentPane().add(txtMail);
		txtMail.setColumns(10);

		txtmdp = new JTextField();
		txtmdp.setBounds(372, 94, 125, 20);
		frame.getContentPane().add(txtmdp);
		txtmdp.setColumns(10);

		Button btnAjouter = new Button("+ Ajouter");
		btnAjouter.setBounds(584, 23, 70, 22);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					EmployesController.ajouter(txtNom.getText(), txtPrenom.getText(), txtTel.getText(),
							txtPoste.getText(), txtMail.getText(), txtmdp.getText(), table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnAjouter);

		Button supprimer = new Button("x Supprimer");
		supprimer.setBounds(584, 89, 70, 22);
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployesController.supprEmployes(txtMail.getText(), table);
			}
		});
		frame.getContentPane().add(supprimer);

		Button modifier = new Button("Modifier");
		modifier.setBounds(622, 392, 70, 22);
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployesController.modifEmployes(table);
			}
		});
		frame.getContentPane().add(modifier);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 682, 211);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		EmployesController.toutAfficher(table);

		JButton button = new JButton("<");
		button.setBounds(661, 0, 41, 23);
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
