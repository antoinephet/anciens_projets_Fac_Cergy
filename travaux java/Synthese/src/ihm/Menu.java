package ihm;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

// Classe qui crée un menu pour se connecter
public class Menu extends JFrame {

	// variables
	private JPanel contentPane;
	private JTextField txt_user;
	private JPasswordField txt_mdp;

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps= null;
	
	// Lance l'application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crée l'interface
	public Menu() throws Exception{
		
		setTitle("Authentification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConnexion.setBounds(152, 31, 99, 14);
		contentPane.add(lblConnexion);
		
		JLabel lblUtilisateur = new JLabel("utilisateur : ");
		lblUtilisateur.setBounds(42, 98, 81, 23);
		contentPane.add(lblUtilisateur);
		
		JLabel lblMdp = new JLabel("mot de passe : ");
		lblMdp.setBounds(42, 132, 98, 23);
		contentPane.add(lblMdp);
		
		txt_user = new JTextField();
		txt_user.setBounds(152, 99, 110, 20);
		contentPane.add(txt_user);
		txt_user.setColumns(10);
		
		JButton btn_ok = new JButton("OK!");
		btn_ok.setBounds(164, 196, 89, 23);
		contentPane.add(btn_ok);
		
		/*// lire les variables du fichier démo.properties
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
				
		String utilisateur = props.getProperty("utilisateur");
		String motDePasse = props.getProperty("motDePasse");
		String url = props.getProperty("url");*/
		
		// connexion à la base de données
		
		String utilisateur = "root";
		String motDePasse = "";
		String url = "jdbc:mysql://localhost:3306/synthese";
				
		
		conn = DriverManager.getConnection(url, utilisateur, motDePasse);
		
		// Jbutton OK pour valider la connexion
		// si les champs saisis (le nom de l'utilisateur et son mot de passe) appartiennent à la base de données
		// alors connexion accéptée sinon erreur
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "select * from utilisateur where nom_utilisateur=? and mdp=?";
				
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, txt_user.getText());
					ps.setString(2, txt_mdp.getText());
					rs=ps.executeQuery();
					if(rs.next()){
						
						JOptionPane.showMessageDialog(null, "vos identifiants sont valides");
						IHM frame = new IHM();
						frame.setVisible(true);
						
					}else{
						JOptionPane.showMessageDialog(null, "vos identifiants ne sont pas valides");
					}
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1);
				}
				/*IHM frame = new IHM();
				dispose();
				frame.setVisible(true);*/
				
				
			}		
		});
		
		txt_mdp = new JPasswordField();
		txt_mdp.setBounds(152, 133, 110, 22);
		contentPane.add(txt_mdp);
	}
}
