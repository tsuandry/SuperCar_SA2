import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextField;

import controllerSa2.ModelController;
import controllerSa2.VoitureController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Voiture {

	JFrame frame;
	private JTextField txtIdentifiant;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voiture window = new Voiture();
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
	public Voiture() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Voiture(String role) {
		frame = new JFrame();
		frame.setBounds(100, 100, 719, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMarque = new JLabel("Marque :");
		lblMarque.setBounds(43, 24, 61, 14);
		frame.getContentPane().add(lblMarque);

		JLabel lblModele = new JLabel("Modele :");
		lblModele.setBounds(43, 61, 61, 14);
		frame.getContentPane().add(lblModele);

		JLabel lblCategorie = new JLabel("Categorie :");
		lblCategorie.setBounds(43, 101, 61, 14);
		frame.getContentPane().add(lblCategorie);

		JLabel lblEntrepot = new JLabel("Entrepot  :");
		lblEntrepot.setBounds(324, 24, 69, 14);
		frame.getContentPane().add(lblEntrepot);

		JLabel lblIdentifiant = new JLabel("identifiant :");
		lblIdentifiant.setBounds(324, 101, 69, 14);
		frame.getContentPane().add(lblIdentifiant);

		Choice txtMarque = new Choice();
		txtMarque.setBounds(110, 24, 125, 20);
		ModelController.DestDeroul(txtMarque);
		frame.getContentPane().add(txtMarque);

		Choice txtModele = new Choice();
		txtModele.setBounds(110, 61, 125, 20);
		VoitureController.DestDeroul(txtModele);
		frame.getContentPane().add(txtModele);

		Choice txtCategorie = new Choice();
		txtCategorie.setBounds(110, 101, 125, 20);
		VoitureController.DestCategorie(txtCategorie);
		frame.getContentPane().add(txtCategorie);

		Choice txtEntrepot = new Choice();
		txtEntrepot.setBounds(399, 18, 125, 20);
		VoitureController.DestEntrepot(txtEntrepot);
		frame.getContentPane().add(txtEntrepot);

		txtIdentifiant = new JTextField();
		txtIdentifiant.setBounds(399, 98, 125, 20);
		frame.getContentPane().add(txtIdentifiant);
		txtIdentifiant.setColumns(10);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(588, 20, 89, 23);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					VoitureController.ajouter(txtMarque.getSelectedItem().toString(),
							txtModele.getSelectedItem().toString(), txtCategorie.getSelectedItem().toString(),
							txtEntrepot.getSelectedItem().toString(), table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnAjouter);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(588, 97, 89, 23);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VoitureController.supprVoiture(txtIdentifiant.getText(), table);
			}
		});
		frame.getContentPane().add(btnSupprimer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(604, 366, 89, 23);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VoitureController.modifVoiture(table);
			}
		});
		frame.getContentPane().add(btnModifier);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 683, 235);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		VoitureController.toutAfficher(table);

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
