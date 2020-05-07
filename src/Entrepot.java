import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllerSa2.EntrepotController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Entrepot {

	JFrame frame;
	private JTextField txtNom;
	private JTextField txtAdresse;
	private JTextField txtTelephone;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrepot window = new Entrepot();
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
	public Entrepot() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Entrepot(String role) {
		frame = new JFrame();
		frame.setBounds(100, 100, 693, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(142, 29, 46, 14);
		frame.getContentPane().add(lblNom);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(142, 69, 67, 14);
		frame.getContentPane().add(lblAdresse);

		JLabel lblTelephone = new JLabel("Telephone :");
		lblTelephone.setBounds(142, 115, 67, 14);
		frame.getContentPane().add(lblTelephone);

		txtNom = new JTextField();
		txtNom.setBounds(248, 26, 264, 20);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtAdresse = new JTextField();
		txtAdresse.setBounds(248, 66, 264, 20);
		frame.getContentPane().add(txtAdresse);
		txtAdresse.setColumns(10);

		txtTelephone = new JTextField();
		txtTelephone.setBounds(248, 112, 264, 20);
		frame.getContentPane().add(txtTelephone);
		txtTelephone.setColumns(10);

		JButton btnAjouter = new JButton("+ Ajouter");
		btnAjouter.setBounds(120, 158, 116, 23);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					EntrepotController.ajouter(txtNom.getText(), txtAdresse.getText(), txtTelephone.getText(), table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnAjouter);

		JButton btnXSupprimer = new JButton("x Supprimer");
		btnXSupprimer.setBounds(396, 158, 116, 23);
		btnXSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EntrepotController.supprEntrepot(txtTelephone.getText(), table);
			}
		});
		frame.getContentPane().add(btnXSupprimer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(578, 328, 89, 23);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EntrepotController.modifEntrepot(table);
			}
		});
		frame.getContentPane().add(btnModifier);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 657, 140);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		EntrepotController.toutAfficher(table);

		JButton button = new JButton("<");
		button.setBounds(636, 0, 41, 23);
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
