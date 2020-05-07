import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Acceuil_employes {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil_employes window = new Acceuil_employes();
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
	public Acceuil_employes() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Acceuil_employes(String role) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 411, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 181, 153);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGestion = new JLabel("Gestion");
		lblGestion.setFont(new Font("Wide Latin", Font.PLAIN, 10));
		lblGestion.setBounds(10, 0, 80, 14);
		panel.add(lblGestion);
		
		JButton btnClients = new JButton("Clients");
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client window = new Client(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnClients.setBounds(48, 42, 89, 23);
		panel.add(btnClients);
		
		JButton btnStocks = new JButton("Stocks");
		btnStocks.setBounds(48, 96, 89, 23);
		btnStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock window = new Stock(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel.add(btnStocks);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(201, 11, 181, 153);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblVoitures = new JLabel("Voitures");
		lblVoitures.setFont(new Font("Wide Latin", Font.PLAIN, 11));
		lblVoitures.setBounds(10, 0, 98, 14);
		panel_1.add(lblVoitures);
		
		JButton btnVentes = new JButton("Ventes");
		btnVentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vente window = new Vente(role);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnVentes.setBounds(42, 64, 89, 23);
		panel_1.add(btnVentes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 175, 372, 155);
		frame.getContentPane().add(panel_2);
	}

}
