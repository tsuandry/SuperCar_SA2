import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextField;

import controllerSa2.VenteController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Vente {

	JFrame frame;
	private JTextField txtClient;
	private JTextField txtDateVente;
	private JTable table;
	private JTextField txtModele;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vente window = new Vente();
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
	public Vente() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Vente(String role) {
		frame = new JFrame();
		frame.setBounds(100, 100, 723, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblVendeur = new JLabel("Vendeur :");
		lblVendeur.setBounds(221, 32, 56, 14);
		frame.getContentPane().add(lblVendeur);

		JLabel lblMarque = new JLabel("Marque :");
		lblMarque.setBounds(221, 76, 46, 14);
		frame.getContentPane().add(lblMarque);

		JLabel lblModele = new JLabel("Modele :");
		lblModele.setBounds(221, 119, 68, 14);
		frame.getContentPane().add(lblModele);

		JLabel lblClient = new JLabel("Client :");
		lblClient.setBounds(221, 170, 46, 14);
		frame.getContentPane().add(lblClient);

		JLabel lblDateDeVente = new JLabel("Date de vente :");
		lblDateDeVente.setBounds(221, 212, 87, 14);
		frame.getContentPane().add(lblDateDeVente);

		Choice txtVendeur = new Choice();
		txtVendeur.setBounds(312, 26, 133, 20);
		VenteController.DestVendeur(txtVendeur);
		frame.getContentPane().add(txtVendeur);

		Choice txtMarque = new Choice();
		txtMarque.setBounds(312, 70, 133, 20);
		VenteController.DestMarque(txtMarque);
		frame.getContentPane().add(txtMarque);

		txtModele = new JTextField();
		txtModele.setBounds(312, 116, 133, 20);
		frame.getContentPane().add(txtModele);
		txtModele.setColumns(10);

		txtClient = new JTextField();
		txtClient.setBounds(312, 167, 133, 20);
		frame.getContentPane().add(txtClient);
		txtClient.setColumns(10);

		txtDateVente = new JTextField();
		txtDateVente.setBounds(312, 209, 133, 20);
		frame.getContentPane().add(txtDateVente);
		txtDateVente.setColumns(10);

		JButton btnAjouter = new JButton("+ Ajouter");
		btnAjouter.setBounds(276, 237, 89, 23);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					VenteController.ajouter(txtVendeur.getSelectedItem().toString(),
							txtMarque.getSelectedItem().toString(), txtModele.getText(), txtClient.getText(),
							txtDateVente.getText(), table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnAjouter);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 271, 687, 156);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		VenteController.toutAfficher(table);

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
