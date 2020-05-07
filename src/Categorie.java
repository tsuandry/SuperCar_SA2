import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllerSa2.CategorieController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Categorie {

	JFrame frame;
	private JTextField txtCategorie;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categorie window = new Categorie();
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
	public Categorie() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Categorie(String role) {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCategorie = new JLabel("Categorie :");
		lblCategorie.setBounds(188, 45, 76, 14);
		frame.getContentPane().add(lblCategorie);

		txtCategorie = new JTextField();
		txtCategorie.setBounds(274, 42, 155, 20);
		frame.getContentPane().add(txtCategorie);
		txtCategorie.setColumns(10);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(175, 92, 89, 23);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CategorieController.ajouter(txtCategorie.getText(), table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnAjouter);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(340, 92, 89, 23);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CategorieController.supprCategorie(txtCategorie.getText(), table);
			}
		});
		frame.getContentPane().add(btnSupprimer);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 624, 196);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		CategorieController.toutAfficher(table);

		JButton button = new JButton("<");
		button.setBounds(603, 0, 41, 23);
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
