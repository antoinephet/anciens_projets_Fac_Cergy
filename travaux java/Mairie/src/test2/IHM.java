package test2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;




public class IHM extends JFrame{
	
	
	// attributs de la classe
	
		private Container cont;
		private JLabel inseeLabel = new JLabel("Veullez saisir le code INSEE : ");
		private JLabel nomLabel = new JLabel("Veullez saisir le nom de la mairie : ");
		private JLabel codePostalLabel = new JLabel("Veullez saisir le code postal : ");
		private JTextField inseeField = new JTextField("");
		private JTextField codePostalField = new JTextField("");
		private JTextField nomField = new JTextField("");
		private JPanel bleu = new JPanel();
		private JButton lancer = new JButton("Lancer");
		private JButton quitter = new JButton("Quitter");
		private JTextArea resultatField = new JTextArea("");
		private JScrollPane scroll = new JScrollPane(resultatField);
		private static ArrayList<Mairie> MairieList;
		
		

		public IHM(){
			
			
			super("Annuaire informatique");
			
			initLayout();
			
		    initStyleCouleur();

		    initActions();

		    JOptionPane.showMessageDialog(null,"Bienvenue à l'annuaire informatique!!\nCliquez sur OK pour continuer");
		    
			
		}

		

		private void initLayout() {
			setSize(980,630); // taille de la fenêtre
		    setVisible(true); // rendre visible
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    // mise en place du conteneur principal
		    
		    cont = getContentPane();
		    cont.setLayout(null);
		    
		    
		    // ajout des composants
		    
		    cont.add(bleu);
		    cont.add(inseeLabel);
		    cont.add(inseeField);
		    cont.add(nomLabel);
		    cont.add(nomField);
		    cont.add(codePostalLabel);
		    cont.add(codePostalField);
		    cont.add(lancer);
		    cont.add(quitter);
		    
		    // position des composants
		    
		    bleu.setBounds(0, 0, 950, 300);
		    inseeLabel.setBounds(20, 20, 310, 30);
		    cont.setComponentZOrder(inseeLabel,0);
		    
		    inseeField.setBounds(335, 20, 450, 30);
		    cont.setComponentZOrder(inseeField,0);
		    
		    nomLabel.setBounds(20, 80, 310, 30);
		    cont.setComponentZOrder(nomLabel,0);
		    
		    nomField.setBounds(335, 80, 450, 30);
		    cont.setComponentZOrder(nomField,0);
		    
		    codePostalLabel.setBounds(20, 130, 310, 30);
		    cont.setComponentZOrder(codePostalLabel,0);
		    
		    codePostalField.setBounds(335, 135, 450, 30);
		    cont.setComponentZOrder(codePostalField,0);
		    
		    lancer.setBounds(300, 230, 200, 50);
		    cont.setComponentZOrder(lancer,0);
		    
		    quitter.setBounds(550, 230, 200, 50);
		    cont.setComponentZOrder(quitter,0);
		    
		    resultatField.setBounds(0, 301, 950, 290);
		    /*cont.add(resultatField);*/
		    
		    cont.add(scroll);
		    cont.setComponentZOrder(scroll,0);
		    scroll.setBounds(0, 301, 950, 290);
		    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		
		// Style et police des composants
		
		private void initStyleCouleur() {
			bleu.setBackground(new Color(25, 85, 144));
		    
		    inseeLabel.setFont(new Font("Arial", Font.ITALIC, 15));
		    nomLabel.setFont(new Font("Arial", Font.ITALIC, 15));
		    codePostalLabel.setFont(new Font("Arial", Font.ITALIC, 15));
		}
		
		
		// initialisations des Actions événementielles
		private void initActions() {
			lancer.addActionListener(new Lancer());
		    quitter.addActionListener(new QuitterAction(this));
		}

		
		
		// méthode décrivant au bouton "Quitter" de fermer le logiciel
		
		private class QuitterAction implements ActionListener {
			
			private JFrame window;

			public QuitterAction(JFrame window) {
				this.window = window;
			}

			
			public void actionPerformed(ActionEvent e) {
				window.dispose();
			}

		}
		
		// méthode permettant au bouton "Lancer" d'exécuter le programme, c'est à dire, saisir le code Insee
		// puis rechercher le fichier xml et enfin le lire  
		
		private class Lancer implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				
				String codeInsee = inseeField.getText();
				String nom = nomField.getText();
				String codePostal = codePostalField.getText();
				
				
				Document document = null;
				DocumentBuilderFactory factory = null;
				DocumentBuilder builder = null;
				MairieList = new ArrayList<Mairie>();
				//Chemin de location du jeu de donnees reduit
				String pat = "C:\\Users\\PHETRAMPHAND\\Desktop\\jeu_de_donnees_reduit";
				File di   = new File(pat);
				String[] fl = di.list();
				int j;
				String filename;
				String name, insee, postalCode, phone, mail, website; 

				for (j=0; j < fl.length; j++)
				{
					filename=""+fl[j];
					System.out.println(""+filename);
					if (!filename.startsWith("mairie") || !filename.endsWith(".xml")) continue;
					
					
					try{
						factory = DocumentBuilderFactory.newInstance();
						builder = factory.newDocumentBuilder();
						document = builder.parse(pat +"\\" + filename);
						name = document.getElementsByTagName("Nom").item(0).getTextContent();
						insee = document.getElementsByTagName("Organisme").item(0).getAttributes().item(0).getNodeValue();
						postalCode = document.getElementsByTagName("CodePostal").item(0).getTextContent();
						phone = document.getElementsByTagName("Téléphone").item(0).getTextContent();
						if (document.getElementsByTagName("Email").getLength()>0) {
							mail = document.getElementsByTagName("Email").item(0).getTextContent();
						} else mail = "";
						if (document.getElementsByTagName("Url").getLength()>0) {
							website = document.getElementsByTagName("Url").item(0).getTextContent();
						} else website = "";
						Mairie mai = new Mairie(name, insee,postalCode,phone,mail,website);
						MairieList.add(mai);
						
						// Recherche par le code Insee
						if(!codeInsee.equals("")){
							
							for (int i = 0; i <= MairieList.size() - 1; i++) {
								mai = MairieList.get(i);
								if(mai.getInsee().equals(codeInsee)){
									
									String line = ("Nom : " + mai.getName()
									+ "\n" + "Insee : " + mai.getInsee()
									+ "\n" + "Code Postal : " + mai.getPostalCode()
									+ "\n" + "Email : " + mai.getMail()
									+ "\n" + "SiteWeb : " + mai.getWebsite());
									
									resultatField.setText(line);
									
								} 
							}

							
						}
						
						// Recherche par le nom de la mairie
						if(!nom.equals("")){
							
							for (int i = 0; i <= MairieList.size() - 1; i++) {
								mai = MairieList.get(i);
								if(mai.getName().equals(nom)){
									
									String line = ("Nom : " + mai.getName()
									+ "\n" + "Insee : " + mai.getInsee()
									+ "\n" + "Code Postal : " + mai.getPostalCode()
									+ "\n" + "Email : " + mai.getMail()
									+ "\n" + "SiteWeb : " + mai.getWebsite());
									
									resultatField.setText(line);
									
								} 
							}

							
						}
						
						
						// Recherche par le code postal
						if(!codePostal.equals("")){
							
							for (int i = 0; i <= MairieList.size() - 1; i++) {
								mai = MairieList.get(i);
								if(mai.getPostalCode().equals(codePostal)){
									
									String line = ("Nom : " + mai.getName()
									+ "\n" + "Insee : " + mai.getInsee()
									+ "\n" + "Code Postal : " + mai.getPostalCode()
									+ "\n" + "Email : " + mai.getMail()
									+ "\n" + "SiteWeb : " + mai.getWebsite());
									
									resultatField.setText(line);
									
								} 
							}

							
						}
						
						
						
					}catch(Exception e1){
						e1.printStackTrace();
					}
					 
					
					}

				
			}
			
		}
		
		
		
	public static void main(String[] args) {
		
		new IHM();
		
		

	}

}
