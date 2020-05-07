import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

public class Acceuil_manager {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil_manager window = new Acceuil_manager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param role 
	 */
	public Acceuil_manager() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Acceuil_manager(String role) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 609, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 28, 220, 197);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGestion = new JLabel("Gestion");
		lblGestion.setFont(new Font("Wide Latin", Font.PLAIN, 10));
		lblGestion.setBounds(10, 0, 81, 14);
		panel.add(lblGestion);
		
		JButton btnStock = new JButton("Stock");
		btnStock.setBounds(52, 25, 116, 23);
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock window = new Stock(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel.add(btnStock);
		
		JButton btnEntrepot = new JButton("Entrepot");
		btnEntrepot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entrepot window = new Entrepot(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnEntrepot.setBounds(52, 59, 116, 23);
		panel.add(btnEntrepot);
		
		JButton btnFournisseur = new JButton("Fournisseur");
		btnFournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fournisseur window = new Fournisseur(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnFournisseur.setBounds(52, 93, 116, 23);
		panel.add(btnFournisseur);
		
		JButton btnCommande = new JButton("Commande");
		btnCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Commande window = new Commande(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCommande.setBounds(52, 127, 116, 23);
		panel.add(btnCommande);
		
		JButton btnClients = new JButton("Clients");
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client window = new Client(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnClients.setBounds(52, 161, 116, 23);
		panel.add(btnClients);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(240, 28, 343, 197);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblVoitures = new JLabel("Voitures");
		lblVoitures.setFont(new Font("Wide Latin", Font.PLAIN, 10));
		lblVoitures.setBounds(10, 0, 81, 14);
		panel_1.add(lblVoitures);
		
		JButton btnVoitures = new JButton("Voitures");
		btnVoitures.setBounds(20, 25, 106, 23);
		btnVoitures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Voiture window = new Voiture(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_1.add(btnVoitures);
		
		JButton btnCategories = new JButton("Categories");
		btnCategories.setBounds(20, 96, 106, 23);
		btnCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Categorie window = new Categorie(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_1.add(btnCategories);
		
		JButton btnModel = new JButton("Modele");
		btnModel.setBounds(20, 163, 106, 23);
		btnModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modele window = new Modele(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_1.add(btnModel);
		
		JButton btnMarque = new JButton("Marque");
		btnMarque.setBounds(202, 25, 106, 23);
		btnMarque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Marque window = new Marque(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_1.add(btnMarque);
		
		JButton btnVentes = new JButton("Ventes");
		btnVentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vente window = new Vente(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnVentes.setBounds(202, 96, 106, 23);
		panel_1.add(btnVentes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 236, 573, 180);
		frame.getContentPane().add(panel_2);
	}
}
