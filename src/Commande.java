import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controllerSa2.CommandeController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Commande {

	JFrame frame;
	private JTextField txtNComande;
	private JDateChooser txtDate;
	private JTable table;
	private JTextField txtModele;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commande window = new Commande();
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
	public Commande() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Commande(String role) {
		frame = new JFrame();
		frame.setBounds(100, 100, 723, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblFournisseur = new JLabel("Fournisseur :");
		lblFournisseur.setBounds(31, 33, 82, 14);
		frame.getContentPane().add(lblFournisseur);

		JLabel lblModele = new JLabel("Modele :");
		lblModele.setBounds(31, 68, 65, 14);
		frame.getContentPane().add(lblModele);

		JLabel lblEntrepot = new JLabel("Entrepot :");
		lblEntrepot.setBounds(31, 140, 82, 14);
		frame.getContentPane().add(lblEntrepot);

		Choice txtFournisseur = new Choice();
		txtFournisseur.setBounds(132, 27, 122, 20);
		CommandeController.DestFournisseur(txtFournisseur);
		frame.getContentPane().add(txtFournisseur);

		txtModele = new JTextField();
		txtModele.setBounds(132, 65, 122, 20);
		frame.getContentPane().add(txtModele);
		txtModele.setColumns(10);

		JLabel lblMarque = new JLabel("Marque :");
		lblMarque.setBounds(31, 104, 82, 14);
		frame.getContentPane().add(lblMarque);

		Choice txtMarque = new Choice();
		txtMarque.setBounds(132, 98, 122, 20);
		CommandeController.DestMarque(txtMarque);
		frame.getContentPane().add(txtMarque);

		Choice txtEntrepot = new Choice();
		txtEntrepot.setBounds(132, 134, 122, 20);
		CommandeController.DestEntrepot(txtEntrepot);
		frame.getContentPane().add(txtEntrepot);

		JLabel lblNCommande = new JLabel("N. Commande :");
		lblNCommande.setBounds(272, 33, 95, 14);
		frame.getContentPane().add(lblNCommande);

		JLabel lblDateCommande = new JLabel("Date Commande :");
		lblDateCommande.setBounds(271, 68, 109, 14);
		frame.getContentPane().add(lblDateCommande);

		JLabel lblEmployesNom = new JLabel("Employes nom :");
		lblEmployesNom.setBounds(272, 104, 116, 14);
		frame.getContentPane().add(lblEmployesNom);

		txtNComande = new JTextField();
		txtNComande.setBounds(412, 30, 122, 20);
		frame.getContentPane().add(txtNComande);
		txtNComande.setColumns(10);

		txtDate = new JDateChooser();
		txtDate.setDateFormatString("dd/MM/yyyy");
		txtDate.setBounds(412, 65, 122, 20);
		frame.getContentPane().add(txtDate);

		Choice txtEmployes = new Choice();
		txtEmployes.setBounds(412, 98, 122, 20);
		CommandeController.DestEmployes(txtEmployes);
		frame.getContentPane().add(txtEmployes);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(272, 140, 108, 14);
		frame.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(412, 137, 122, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		JButton btnAjouter = new JButton("+ Ajouter");
		btnAjouter.setBounds(587, 27, 108, 23);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CommandeController.ajouter(txtFournisseur.getSelectedItem().toString(), txtModele.getText(),
							txtMarque.getSelectedItem().toString(), txtEntrepot.getSelectedItem().toString(),
							((JTextField)txtDate.getDateEditor().getUiComponent()).getText(), txtEmployes.getSelectedItem().toString(), txtNombre.getText(), table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnAjouter);

		JButton btnXSupprimer = new JButton("x Supprimer");
		btnXSupprimer.setBounds(587, 95, 108, 23);
		btnXSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CommandeController.supprCommande(txtNComande.getText(), table);
			}
		});
		frame.getContentPane().add(btnXSupprimer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(606, 414, 89, 23);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CommandeController.modifCommande(table);
			}
		});
		frame.getContentPane().add(btnModifier);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 687, 241);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		frame.getContentPane().add(btnModifier);
		CommandeController.toutAfficher(table);

		JButton button = new JButton("<");
		button.setBounds(666, 0, 41, 23);
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
