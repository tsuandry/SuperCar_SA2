import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllerSa2.ModelController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Choice;

public class Modele {

	JFrame frame;
	private JTextField txtNomModele;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modele window = new Modele();
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
	public Modele() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Modele(String role) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNomModele = new JLabel("Nom modele :");
		lblNomModele.setBounds(60, 11, 79, 14);
		frame.getContentPane().add(lblNomModele);

		txtNomModele = new JTextField();
		txtNomModele.setBounds(161, 8, 139, 20);
		frame.getContentPane().add(txtNomModele);
		txtNomModele.setColumns(10);

		JLabel lblMarque = new JLabel("Marque :");
		lblMarque.setBounds(60, 42, 79, 14);
		frame.getContentPane().add(lblMarque);

		Choice txtMarque = new Choice();
		txtMarque.setBounds(161, 36, 139, 20);
		ModelController.DestDeroul(txtMarque);
		frame.getContentPane().add(txtMarque);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(10, 86, 89, 23);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ModelController.ajouter(txtNomModele.getText(), txtMarque.getSelectedItem().toString(), table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnAjouter);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(335, 86, 89, 23);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModelController.supprModele(txtNomModele.getText(), table);
			}
		});
		frame.getContentPane().add(btnSupprimer);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 414, 187);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		ModelController.toutAfficher(table);

		JButton button = new JButton("<");
		button.setBounds(393, 0, 41, 23);
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
