package mairie;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class Ihm extends JFrame {
	
	// attributs de la classe
	
	private Container cont;
	private JLabel inseeLabel = new JLabel("Veullez saisir le code INSEE svp : ");
	private JTextField inseeField = new JTextField("");
	private JPanel bleu = new JPanel();
	private JButton lancer = new JButton("Lancer");
	private JButton quitter = new JButton("Quitter");
	private JTextArea resultatField = new JTextArea("");
	private EnsembleFichierXml infos;
	private JScrollPane scroll = new JScrollPane(resultatField);
	

	public Ihm(){
		
		
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
	    /*cont.add(inseeLabel);
	    cont.add(inseeField);*/
	    cont.add(lancer);
	    cont.add(quitter);
	    
	    
	    bleu.setBounds(0, 0, 950, 300);
	    /*inseeLabel.setBounds(20, 20, 310, 30);
	    cont.setComponentZOrder(inseeLabel,0);
	    
	    inseeField.setBounds(335, 20, 450, 30);
	    cont.setComponentZOrder(inseeField,0);*/
	    
	    lancer.setBounds(250, 230, 200, 50);
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
	
	
	private void initStyleCouleur() {
		bleu.setBackground(new Color(25, 85, 144));
	    
	    inseeLabel.setFont(new Font("Arial", Font.ITALIC, 15));
	}
	
	
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
	// puis rechercher la fichier xml et enfin le lire  
	
	private class Lancer implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			
			try{
				String saisie = JOptionPane.showInputDialog("Veuillez saisir le code Insee : ");
				String ligne;
				String str1 = "mairie-";
				String str2 = "-01.xml";
				String str4 = str1 + saisie + str2;
				
				//creation des flux
				BufferedReader in=new BufferedReader(new FileReader(str4));
				
				resultatField.read(in,null);
				in.close();
				resultatField.requestFocus();
				
			}
			catch(IOException e1){
				e1.printStackTrace();
			}
			
		}
		
	}

	
	
	
	
}
	
	


