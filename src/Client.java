import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controllerSa2.ClientController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Client {

	JFrame frame;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JDateChooser txtDateNaissance;
	private JTextField txtMail;
	private JTextField txtTelephone;
	private JTable table;
	private JTextField txtSexe;
	private JTextField txtPays;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public Client() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Client(String role) {
		frame = new JFrame();
		frame.setBounds(100, 100, 727, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(36, 24, 64, 14);
		frame.getContentPane().add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(36, 59, 83, 14);
		frame.getContentPane().add(lblPrenom);

		JLabel lblSexe = new JLabel("Sexe :");
		lblSexe.setBounds(36, 96, 64, 14);
		frame.getContentPane().add(lblSexe);

		JLabel lblDNaissance = new JLabel("D. Naissance :");
		lblDNaissance.setBounds(36, 130, 94, 14);
		frame.getContentPane().add(lblDNaissance);

		txtNom = new JTextField();
		txtNom.setBounds(129, 21, 137, 20);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtPrenom = new JTextField();
		txtPrenom.setBounds(129, 56, 137, 20);
		frame.getContentPane().add(txtPrenom);
		txtPrenom.setColumns(10);

		txtSexe = new JTextField();
		txtSexe.setBounds(129, 93, 137, 20);
		frame.getContentPane().add(txtSexe);
		txtSexe.setColumns(10);

		txtDateNaissance = new JDateChooser();
		txtDateNaissance.setDateFormatString("dd/MM/yyyy");
		txtDateNaissance.setBounds(129, 124, 137, 20);
		frame.getContentPane().add(txtDateNaissance);

		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(301, 24, 72, 14);
		frame.getContentPane().add(lblEmail);

		JLabel lblTelephone = new JLabel("Telephone :");
		lblTelephone.setBounds(301, 59, 83, 14);
		frame.getContentPane().add(lblTelephone);

		JLabel lblPays = new JLabel("Pays :");
		lblPays.setBounds(301, 96, 72, 14);
		frame.getContentPane().add(lblPays);

		txtMail = new JTextField();
		txtMail.setBounds(383, 21, 137, 20);
		frame.getContentPane().add(txtMail);
		txtMail.setColumns(10);

		txtTelephone = new JTextField();
		txtTelephone.setBounds(383, 56, 137, 20);
		frame.getContentPane().add(txtTelephone);
		txtTelephone.setColumns(10);

		JButton btnAjouter = new JButton("+ Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ClientController.ajouter(txtNom.getText(), txtPrenom.getText(), txtSexe.getText(),
							((JTextField)txtDateNaissance.getDateEditor().getUiComponent()).getText(), txtMail.getText(), txtTelephone.getText(), txtPays.getText(),
							table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		txtPays = new JTextField();
		txtPays.setBounds(383, 93, 137, 20);
		frame.getContentPane().add(txtPays);
		txtPays.setColumns(10);
		btnAjouter.setBounds(573, 20, 89, 23);
		frame.getContentPane().add(btnAjouter);

		JButton btnXSupprimer = new JButton("x Supprimer");
		btnXSupprimer.setBounds(573, 72, 89, 23);
		btnXSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientController.supprClient(table, txtMail.getText());
			}
		});
		frame.getContentPane().add(btnXSupprimer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(612, 413, 89, 23);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientController.modifClient(table);
			}
		});
		frame.getContentPane().add(btnModifier);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 691, 247);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		ClientController.toutAfficher(table);

		JButton button = new JButton("<");
		button.setBounds(670, 0, 41, 23);
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
