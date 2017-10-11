package reseau;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ServeurIpmon {
	private JoueurServeur[] lesJoueurs;
	private int numSuivant = 0;
	
	public ServeurIpmon(JoueurServeur[] lesJoueurs) {
		this.lesJoueurs = lesJoueurs;
	}
	
	public void ajouterJoueur(Socket socket) {
		lesJoueurs[numSuivant] = new JoueurServeur(socket, numSuivant, this);
		numSuivant++;
		if (numSuivant == 2) donnerFeuVert(); // Si 4 joueurs se sont connectés
	}
	
	public void donnerFeuVert() {
		for (int i =0; i<lesJoueurs.length; i++) lesJoueurs[i].envoyerNumero();
	}

	public static void main(String[] arg) throws Exception {
		int port = 8083;
		ServerSocket receptionniste =  new ServerSocket();
		
		try {
		   //Serveur
			JFrame f = new JFrame();      
		    f.setTitle("Serveur21");
		    f.setResizable(false);
		      
		    receptionniste =  new ServerSocket(port); // On définit un serveur sur le port 8081
		    JoueurServeur[] lesJoueurs = new JoueurServeur[2]; // On crée un tableau de 4 JoueurServeur
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    f.getContentPane().add(new JLabel("    IP " + java.net.InetAddress.getLocalHost().getHostAddress() + " Port " + port));
		    f.pack();
		    f.setSize(200, 100);
		    f.setVisible(true);
		 
		    ServeurIpmon serveur = new ServeurIpmon(lesJoueurs);
		    for (int i =0; i<2; i++)serveur.ajouterJoueur(receptionniste.accept());
		 
		    new ServeurIpmon(lesJoueurs);
		}
		catch(IOException ioe){ 
			JOptionPane.showMessageDialog (null, " Port : " + port + " est déjà utilisé" , "Serveur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void attendre() {
		try {
			Thread.sleep(3000);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public void chercherChoix(){
		attendre();
		Choix choix0 = lesJoueurs[0].choix;
		Choix choix1 = lesJoueurs[1].choix;
		if (choix0 == Choix.Echanger) {
			if (choix1 ==  Choix.Echanger) lancerEchange(0);
		}
			
	}

	void lancerEchange(int numJoueur) {
		lesJoueurs[numJoueur].enEchange();
		lesJoueurs[1 - numJoueur].enEchange();		
	}
	
	public void prevenirAdversaire(int numero) {
		Choix choix = lesJoueurs[numero].choix;
			lesJoueurs[1 - numero].out.println(Constantes.CHOIX_ADVERSAIRE + " " + choix);
	}
	
	public void examinerChoix() { // Les joueurs se déplcanet quand tout le monde a choisi sa position
		boolean fait = ((lesJoueurs[0].choix == Choix.Echanger) && (lesJoueurs[1].choix  == Choix.Echanger));
		if (fait ==true) System.out.println("L'échange va commencer");
		else System.out.println("Il n'y a personne pour faire un échange pour le moment");
		boolean fait2 = ((lesJoueurs[0].choix == Choix.Combattre) && (lesJoueurs[1].choix  == Choix.Combattre));
		if (fait2 ==true) System.out.println("Le combat va commencer");
		else System.out.println("Il n'y a personne pour faire un combat pour le moment");
		
		if (fait || fait2) {
			chercherChoix();
			annulerChoix();
		}
	}
	
	public void annulerChoix() { //On remet à 0
		lesJoueurs[0].choix = null;
		lesJoueurs[1].choix = null;
	}

}
