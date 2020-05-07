import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllerSa2.MarqueController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Marque {

	JFrame frame;
	private JTextField txtMarque;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marque window = new Marque();
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
	public Marque() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Marque(String role) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMarque = new JLabel("Marque :");
		lblMarque.setBounds(93, 35, 54, 14);
		frame.getContentPane().add(lblMarque);

		txtMarque = new JTextField();
		txtMarque.setBounds(170, 32, 148, 20);
		frame.getContentPane().add(txtMarque);
		txtMarque.setColumns(10);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(10, 80, 89, 23);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MarqueController.ajouter(txtMarque.getText(), table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnAjouter);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(335, 80, 89, 23);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MarqueController.supprMarque(txtMarque.getText(), table);
			}
		});
		frame.getContentPane().add(btnSupprimer);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 414, 136);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		MarqueController.toutAfficher(table);

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
