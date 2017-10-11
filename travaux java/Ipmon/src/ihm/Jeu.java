package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JPanel;



import jeu.Arbre;
import jeu.Dresseur;
import jeu.Grille;
import jeu.Ipmon;
import jeu.Joueur;

public class Jeu extends JPanel implements ActionListener{
	
	
	private int nbLigne = 30,nbColonne = 21; // private int nbLigne = 30,nbColonne = 21;
	private String grille[][] = new String[nbLigne][nbColonne];
	
	
	private static ArrayList<Arbre> arbres;
	private static ArrayList<Joueur> joueurs;
	private static ArrayList<Ipmon> ipmons;
	private static ArrayList<Dresseur> dresseurs;

	

	private Grille g;
	
	private Joueur joueur;
	private Ipmon ipmon;
	private Arbre arbre;
	private Dresseur dresseur;

	private FileReader fr;
	
	public Jeu(){
		
		//requestFocus();
		//setFocusable(true);
		setBackground(Color.WHITE);
		
		//p = new console.Grille(1122, 714);
		//p.choixIhm();
		chargerCarte();
		
		
		System.out.println();
		for (int i=0  ; i<nbLigne ; i++){
			for(int j=0 ; j<nbColonne ; j++){
				System.out.println(joueur.toString());
				System.out.println(arbre.toString());
				
			}
			
		
		} 
		System.out.println();
		
	}
		//g1 = new Grille(1122, 714);
		//lancerJeu();
		
	
	//public void lancerJeu(){
		//g1.chargementFichierIhm();
		
	//}
	
	//dessine les objets instanciés dans la grille
	public void paint(Graphics g){
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		
		
		for(int i=0;i < arbres.size();i++){
			arbre = (Arbre) arbres.get(i);
			g2d.drawImage(arbre.getArbre(), arbre.getX(), arbre.getY(), null);
			
		}
		
		for(int i=0;i < joueurs.size();i++){
			joueur = (Joueur) joueurs.get(i);
			g2d.drawImage(joueur.getJoueur(), joueur.getX(), joueur.getY(), null);
			
		}
		
		for(int i=0;i < ipmons.size();i++){
			ipmon = (Ipmon) ipmons.get(i);
			g2d.drawImage(ipmon.getIpmon(), ipmon.getX(), ipmon.getY(), null);
			
		}
		
		for(int i=0;i < dresseurs.size();i++){
			dresseur = (Dresseur) dresseurs.get(i);
			g2d.drawImage(dresseur.getDresseur(), dresseur.getX(), dresseur.getY(), null);
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
	}
	
	//lit les fichiers et instancie les objets 
	public void chargerCarte(){
		
		try{	
			
			
			// si la taille de l'�cran est 30x21, alors le fichier Carte2.txt sera lu 
			if((nbLigne==30) && (nbColonne==21)){
				
				fr = new FileReader("Cartes/Carte2.txt");
				
			}
	
			int i = 0;
			int x=0, y = 0;
			
			
			arbres = new ArrayList<Arbre>();

			
			joueurs = new ArrayList<Joueur>();
			ipmons = new ArrayList<Ipmon>();
			dresseurs = new ArrayList<Dresseur>();
			
			while((i = fr.read()) != -1){
				char conv = (char) i; // la valeur en int convertit en char
				
				// si la lecture trouve la valeur "0" dans le fichier, alors la valeur change en "A"
				// et instance la classe Arbre
				if(conv == '0'){
					grille[x][y] = "A";
					arbre = new Arbre(x * 34, y * 34);
					arbres.add(arbre);
					
				}
				
				// si la lecture trouve la valeur "1" dans le fichier, alors la valeur change en "J"
				// et instance la classe Joueur
				else if(conv == '1'){ // 
					
					grille[x][y] = "J";
					joueur = new Joueur(x * 34, y * 34);
					joueurs.add(joueur);
				}
				
				// si la lecture trouve la valeur "2" dans le fichier, alors la valeur change en "I"
				// et instance la classe Ipmon
				else if(conv == '2'){
					grille[x][y] = "I";
					ipmon = new Ipmon(x * 34, y * 34);
					ipmons.add(ipmon);
				}
				
				// si la lecture trouve la valeur "3" dans le fichier, alors la valeur change en "D"
				// et instance la classe Dresseur
				else if(conv == '3'){
					
					grille[x][y] = "D";
					dresseur = new Dresseur(x * 34, y * 34);
					dresseurs.add(dresseur);
					
				}	
				
				// si la lecture trouve la valeur " " dans le fichier, alors la valeur change en " " donc pas de valeur
				
				else if(conv == ' '){
					grille[x][y] = " ";
				}
				else if(conv == '\r' || conv == '\n'){
					x--;
				}
				
				if(x == nbLigne-1){ // si on atteint le x maximum, on incr�mente le y
					y++;
					x=0;
				}
				else {
					x++;
				}
				
			}
			
		}catch(Exception ex){}
		repaint();
	}



}
