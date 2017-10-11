package jeu;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import reseau.Choix;
import reseau.JoueurClient;
import reseau.JoueurServeur;
import jeu.Ipmon;


public class Joueur extends ChoseAbstraite  implements Runnable{
	
	public Joueur adversaire;
	
	protected BufferedReader in;
	public PrintStream out;
	
	public boolean jouer;
	protected boolean jeuFini;
	public Choix choix;
	
	private Image joueur;
	private ImageIcon iJoueur = new ImageIcon("images/joueur.png");
	
	protected int numero;
	protected String pseudo = "Dresseur";
	protected ArrayList<Ipmon> ipmons = new ArrayList<Ipmon>();
	private int nombreIpmon =0;
	protected int echangeCombatEffectue =0;
	
	public Joueur() {
		this.joueur = iJoueur.getImage();
		this.numero =0;
	}

	public Joueur(Socket socket) {
		try {
			this.joueur = iJoueur.getImage();
			this.numero =0;
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		(new Thread(this)).start();
		adversaire = new Joueur();
	}

	public Joueur(Socket socket, int numero) {
		this(socket);
		this.joueur = iJoueur.getImage();
		this.numero = numero;
		(new Thread(this)).start();
		adversaire = new Joueur();
	}
	
	public Image getJoueur(){ return joueur;}
	
	public String getPseudo() { return pseudo;}
	
	public int getNumero(){	return numero;}
	
	public int getEchangeCombat(){	return echangeCombatEffectue;}
	
	public void setPseudo(String p) { this.pseudo = p;}
	
	public void setNumero(int n) { this.numero = n;}
	
	public void setEchangeCombat(int n) { this.echangeCombatEffectue = n;}
	
	public void ajoutIpmon(Ipmon ipmon){
		if(nombreIpmon<6){
			ipmons.add(ipmon);
			nombreIpmon++;
		}
	}
	
	public ArrayList<Ipmon> listeIpmons(){ return ipmons;}

	public int getNombreIpmon(){ return nombreIpmon;}
	
	public void setNombreIpmon(int nb){	this.nombreIpmon= nb;}
	
	public void aGagne() {
		//nbPoints = nbPoints + 1;
		choix = null;
		adversaire.choix = null;
		jouer = true;
	}
	
	public void aPerdu() {
		choix = null;
		adversaire.choix = null;
		//adversaire.nbPoints = adversaire.nbPoints + 1;
		jouer = true;
	}
	
	@Override
	public String toString() {
		String liste="Vide";
		if (!ipmons.isEmpty()){
			liste = "";
			for (int i=0; i <ipmons.size();i++){
				liste = liste + ipmons.get(i).getNom() + "\n";
			}
		}
		return "Joueur n°"+ numero +": " + pseudo + " [" + x + "," + y + "]\nListe Ipmons:\n" + liste;
	}

	@Override
	public void run() {}

	public void enEchange() {
		choix = null;
		adversaire.choix = null;
		jouer = true;
		jeuFini = true;
		JFrame echange = new JFrame();      
		echange.setTitle("Echange");
		echange.setResizable(false);
	      
		echange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		echange.pack();
		echange.setSize(200, 100);
		echange.setVisible(true);
		echange.dispose();
	}
}
