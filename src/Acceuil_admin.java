import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class Acceuil_admin {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil_admin window = new Acceuil_admin();
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
	public Acceuil_admin() {

	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	public Acceuil_admin(String role) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 790, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.GRAY);
		panel.setBounds(48, 31, 196, 214);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAdministrateur = new JLabel("Administrateur");
		lblAdministrateur.setFont(new Font("Wide Latin", Font.BOLD, 10));
		lblAdministrateur.setBounds(10, 0, 155, 14);
		panel.add(lblAdministrateur);
		
		JButton btnUtilisateur = new JButton("Utilisateur");
		btnUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Utilisateur window = new Utilisateur(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnUtilisateur.setBounds(39, 25, 113, 23);
		panel.add(btnUtilisateur);
		
		JButton btnEmployes = new JButton("Employes");
		btnEmployes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employes window = new Employes(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnEmployes.setBounds(39, 59, 113, 23);
		panel.add(btnEmployes);
		
		JButton btnVendeur = new JButton("Vendeur");
		btnVendeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vendeur window = new Vendeur(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnVendeur.setBounds(39, 93, 113, 23);
		panel.add(btnVendeur);
		
		JButton btnPrime = new JButton("Primes");
		btnPrime.setBounds(39, 127, 113, 23);
		btnPrime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Prime window = new Prime(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel.add(btnPrime);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(296, 31, 196, 214);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblGestion = new JLabel("Gestion");
		lblGestion.setFont(new Font("Wide Latin", Font.PLAIN, 10));
		lblGestion.setBounds(10, 0, 98, 14);
		panel_1.add(lblGestion);
		
		JButton btnStock = new JButton("Stock");
		btnStock.setBounds(47, 22, 114, 23);
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock window = new Stock(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_1.add(btnStock);
		
		JButton btnEntrepot = new JButton("Entrepot");
		btnEntrepot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entrepot window = new Entrepot(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnEntrepot.setBounds(47, 56, 114, 23);
		panel_1.add(btnEntrepot);
		
		JButton btnFournisseur = new JButton("Fournisseur");
		btnFournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fournisseur window = new Fournisseur(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnFournisseur.setBounds(47, 90, 114, 23);
		panel_1.add(btnFournisseur);
		
		JButton btnCommande = new JButton("Commande");
		btnCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Commande window = new Commande(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCommande.setBounds(47, 124, 114, 23);
		panel_1.add(btnCommande);
		
		JButton btnClient = new JButton("Client");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client window = new Client(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnClient.setBounds(47, 158, 114, 23);
		panel_1.add(btnClient);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(48, 256, 444, 169);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblVoitures = new JLabel("Voitures");
		lblVoitures.setFont(new Font("Wide Latin", Font.PLAIN, 10));
		lblVoitures.setBounds(10, 0, 80, 14);
		panel_2.add(lblVoitures);
		
		JButton btnVoitures = new JButton("Voitures");
		btnVoitures.setBounds(42, 34, 113, 23);
		btnVoitures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Voiture window = new Voiture(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_2.add(btnVoitures);
		
		JButton btnModeles = new JButton("Modeles");
		btnModeles.setBounds(42, 87, 113, 23);
		btnModeles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modele window = new Modele(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_2.add(btnModeles);
		
		JButton btnMarque = new JButton("Marque");
		btnMarque.setBounds(42, 135, 113, 23);
		btnMarque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Marque window = new Marque(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_2.add(btnMarque);
		
		JButton btnCategories = new JButton("Categories");
		btnCategories.setBounds(296, 34, 113, 23);
		btnCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Categorie window = new Categorie(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_2.add(btnCategories);
		
		JButton btnVentes = new JButton("Ventes");
		btnVentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vente window = new Vente(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnVentes.setBounds(296, 87, 113, 23);
		panel_2.add(btnVentes);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(533, 31, 213, 394);
		frame.getContentPane().add(panel_3);
	}
}
