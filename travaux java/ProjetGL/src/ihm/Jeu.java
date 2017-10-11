package ihm;


import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modele.Grille;

import console.Arbre;
import console.Buisson;
import console.Buisson1;
import console.Eau;
import console.Fontaine;
import console.Gardien;
import console.Gardien1;
import console.Gardien2;
import console.Gardien3;
import console.Gravier;
import console.Intrus;
import console.Intrus1;
import console.Intrus2;
import console.Mur;
import console.Pancarte;
import console.Portail;
import console.Statue;



	public class Jeu extends JPanel implements ActionListener{
	private int nbLigne = 30,nbColonne = 21; // private int nbLigne = 30,nbColonne = 21;
	private String grille[][] = new String[nbLigne][nbColonne];
	
	
	
	private static ArrayList<Arbre> arbres;
	private static ArrayList<Buisson> buissons;
	private static ArrayList<Buisson1> buissons1;
	private static ArrayList<Gardien> gardiens;
	private static ArrayList<Gardien1> gardiens1;
	private static ArrayList<Gardien2> gardiens2;
	private static ArrayList<Gardien3> gardiens3;
	
	private static ArrayList<Intrus> intruss;
	private static ArrayList<Intrus1> intruss1;
	private static ArrayList<Intrus2> intruss2;
	private static ArrayList<Eau> eaux;
	private static ArrayList<Gravier> graviers;
	private static ArrayList<Fontaine> fontaines;
	private static ArrayList<Mur> murs;
	private static ArrayList<Pancarte> pancartes;
	private static ArrayList<Portail> portails;
	private static ArrayList<Statue> statues;
	

	private console.Grille p;
	
	private Gardien gardien;
	private Gardien1 gardien1;
	private Gardien2 gardien2;
	private Gardien3 gardien3;
	private Intrus intrus;
	private Intrus1 intrus1;
	private Intrus2 intrus2;
	private Mur mur;
	private Arbre arbre;
	private Eau eau;
	private Buisson buisson;
	private Buisson1 buisson1;
	private Fontaine fontaine;
	private Gravier gravier;
	private Pancarte pancarte;
	private Portail portail;
	private Statue statue;
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
				System.out.println(gardien.toString());
				System.out.println(mur.toString());
				
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
		
		for(int i=0;i < murs.size();i++){
			mur = (Mur) murs.get(i);
			g2d.drawImage(mur.getMur(), mur.getX(), mur.getY(), null);
			
		}
		
		for(int i=0;i < arbres.size();i++){
			arbre = (Arbre) arbres.get(i);
			g2d.drawImage(arbre.getArbre(), arbre.getX(), arbre.getY(), null);
			
		}
		
		for(int i=0;i < eaux.size();i++){
			eau = (Eau) eaux.get(i);
			g2d.drawImage(eau.getEau(), eau.getX(), eau.getY(), null);
			
		}
		
		for(int i=0;i < buissons.size();i++){
			buisson = (Buisson) buissons.get(i);
			g2d.drawImage(buisson.getBuisson(), buisson.getX(), buisson.getY(), null);
			
		}
		
		for(int i=0;i < buissons1.size();i++){
			buisson1 = (Buisson1) buissons1.get(i);
			g2d.drawImage(buisson1.getBuisson1(), buisson1.getX(), buisson1.getY(), null);
			
		}
		
		for(int i=0;i < fontaines.size();i++){
			fontaine = (Fontaine) fontaines.get(i);
			g2d.drawImage(fontaine.getFontaine(), fontaine.getX(), fontaine.getY(), null);
			
		}
		
		for(int i=0;i < graviers.size();i++){
			gravier = (Gravier) graviers.get(i);
			g2d.drawImage(gravier.getGravier(), gravier.getX(), gravier.getY(), null);
			
		}
		
		for(int i=0;i < pancartes.size();i++){
			pancarte = (Pancarte) pancartes.get(i);
			g2d.drawImage(pancarte.getPancarte(), pancarte.getX(), pancarte.getY(), null);
			
		}
		
		for(int i=0;i < portails.size();i++){
			portail = (Portail) portails.get(i);
			g2d.drawImage(portail.getPortail(), portail.getX(), portail.getY(), null);
			
		}
		
		for(int i=0;i < statues.size();i++){
			statue = (Statue) statues.get(i);
			g2d.drawImage(statue.getStatue(), statue.getX(), statue.getY(), null);
			
		}
		
		for(int i=0;i < gardiens.size();i++){
			gardien = (Gardien) gardiens.get(i);
			g2d.drawImage(gardien.getGardien(), gardien.getX(), gardien.getY(), null);
			
		}
		
		for(int i=0;i < gardiens1.size();i++){
			gardien1 = (Gardien1) gardiens1.get(i);
			g2d.drawImage(gardien1.getGardien1(), gardien1.getX(), gardien1.getY(), null);
			
		}
		
		for(int i=0;i < gardiens2.size();i++){
			gardien2 = (Gardien2) gardiens2.get(i);
			g2d.drawImage(gardien2.getGardien2(), gardien2.getX(), gardien2.getY(), null);
			
		}
		
		for(int i=0;i < gardiens3.size();i++){
			gardien3 = (Gardien3) gardiens3.get(i);
			g2d.drawImage(gardien3.getGardien3(), gardien3.getX(), gardien3.getY(), null);
			
		}
		
		for(int i=0;i < intruss.size();i++){
			intrus = (Intrus) intruss.get(i);
			g2d.drawImage(intrus.getIntrus(), intrus.getX(), intrus.getY(), null);
			
		}
		
		for(int i=0;i < intruss1.size();i++){
			intrus1 = (Intrus1) intruss1.get(i);
			g2d.drawImage(intrus1.getIntrus1(), intrus1.getX(), intrus1.getY(), null);
			
		}
		
		for(int i=0;i < intruss2.size();i++){
			intrus2 = (Intrus2) intruss2.get(i);
			g2d.drawImage(intrus2.getIntrus2(), intrus2.getX(), intrus2.getY(), null);
			
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
			
			// si la taille de l'�cran est 12x12, alors le fichier Carte1.txt sera lu 
			if(nbLigne==12 && nbColonne==12){
				
				fr = new FileReader("Cartes/Carte4.txt");
				
			}
			
			// si la taille de l'�cran est 20x20, alors le fichier Carte2.txt sera lu 
			if(nbLigne==20 && nbColonne==20){
				
				fr = new FileReader("Cartes/Carte5.txt");
				
			}
			
			// si la taille de l'�cran est 30x21, alors le fichier Carte3.txt sera lu 
			if((nbLigne==30) && (nbColonne==21)){
				
				fr = new FileReader("Cartes/Carte6.txt");
				
			}
	
			int i = 0;
			int x=0, y = 0;
			
			
			arbres = new ArrayList<Arbre>();
			eaux = new ArrayList<Eau>();
			buissons = new ArrayList<Buisson>();
			buissons1 =  new ArrayList<Buisson1>();
			graviers = new ArrayList<Gravier>() ;
			fontaines =  new ArrayList<Fontaine>();
			murs = new ArrayList<Mur>();
			pancartes = new ArrayList<Pancarte>();
			portails = new ArrayList<Portail>();
			statues = new ArrayList<Statue>();
			
			gardiens = new ArrayList<Gardien>();
			gardiens1 = new ArrayList<Gardien1>();
			gardiens2 = new ArrayList<Gardien2>();
			gardiens3 = new ArrayList<Gardien3>();
			
			intruss = new ArrayList<Intrus>();
			intruss1 = new ArrayList<Intrus1>();
			intruss2 = new ArrayList<Intrus2>();
			
			
			
			while((i = fr.read()) != -1){
				char conv = (char) i; // la valeur en int convertit en char
				
				// si la lecture trouve la valeur "0" dans le fichier, alors la valeur change en "M"
				// et instance la classe Mur
				if(conv == '0'){
					grille[x][y] = "M";
					mur = new Mur(x * 34, y * 34);
					murs.add(mur);
					
				}
				
				// si la lecture trouve la valeur "1" dans le fichier, alors la valeur change en "A"
				// et instance la classe Arbre
				else if(conv == '1'){ // 
					
					grille[x][y] = "A";
					arbre = new Arbre(x * 34, y * 34);
					arbres.add(arbre);
				}
				
				// si la lecture trouve la valeur "2" dans le fichier, alors la valeur change en "E"
				// et instance la classe Eau
				else if(conv == '2'){
					grille[x][y] = "E";
					eau = new Eau(x * 34, y * 34);
					eaux.add(eau);
				}
				
				// si la lecture trouve la valeur "3" dans le fichier, alors la valeur change en "G"
				// et instance la classe Gardien
				else if(conv == '3'){
					
					grille[x][y] = "G";
					gardien = new Gardien(x * 34, y * 34);
					gardiens.add(gardien);
					
				}
				
				// si la lecture trouve la valeur "4" dans le fichier, alors la valeur change en "S"
				// et instance la classe Gardien
				else if(conv == '4'){
					grille[x][y] = "S";
					gardien1 = new Gardien1(x * 34, y * 34);
					gardiens1.add(gardien1);
					
				}
				
				else if(conv == '5'){
					grille[x][y] = "C";
					gardien2 = new Gardien2(x * 34, y * 34);
					gardiens2.add(gardien2);
					
				}
				
				// si la lecture trouve la valeur "6" dans le fichier, alors la valeur change en "P"
				// et instance la classe Gardien
				else if(conv == '6'){
					grille[x][y] = "P";
					gardien3 = new Gardien3(x * 34, y * 34);
					gardiens3.add(gardien3);
					
				}
				
				// si la lecture trouve la valeur "7" dans le fichier, alors la valeur change en "I"
				// et instance la classe intrus
				else if(conv == '7'){
					grille[x][y] = "I";
					intrus = new Intrus(x * 34, y * 34);
					intruss.add(intrus);
					
				}
				// si la lecture trouve la valeur "8" dans le fichier, alors la valeur change en "R"
				// et instance la classe intrus
				else if(conv == '8'){
					grille[x][y] = "R";
					intrus1 = new Intrus1(x * 34, y * 34);
					intruss1.add(intrus1);
					
				}
				
				// si la lecture trouve la valeur "9" dans le fichier, alors la valeur change en "D"
				// et instance la classe intrus
				else if(conv == '9'){
					grille[x][y] = "D";
					intrus2 = new Intrus2(x * 34, y * 34);
					intruss2.add(intrus2);
					
				}
				
				// si la lecture trouve la valeur "a" dans le fichier, alors la valeur change en "B"
				// et instance la classe Buisson
				else if(conv == 'a'){
					grille[x][y] = "B";
					buisson = new Buisson(x * 34, y * 34);
					buissons.add(buisson);
					
				}
				
				// si la lecture trouve la valeur "b" dans le fichier, alors la valeur change en "F"
				// et instance la classe Buisson1
				else if(conv == 'b'){
					grille[x][y] = "F";
					buisson1 = new Buisson1(x * 34, y * 34);
					buissons1.add(buisson1);
					
				}
				

				// si la lecture trouve la valeur "c" dans le fichier, alors la valeur change en "H"
				// et instance la classe Fontaine
				else if(conv == 'c'){
					grille[x][y] = "H";
					fontaine = new Fontaine(x * 34, y * 34);
					fontaines.add(fontaine);
					
				}
				
				// si la lecture trouve la valeur "d" dans le fichier, alors la valeur change en "J"
				// et instance la classe Gravier
				else if(conv == 'd'){
					grille[x][y] = "J";
					gravier = new Gravier(x * 34, y * 34);
					graviers.add(gravier);
					
				}
				

				// si la lecture trouve la valeur "e" dans le fichier, alors la valeur change en "F"
				// et instance la classe Pancarte
				else if(conv == 'e'){
					grille[x][y] = "F";
					pancarte = new Pancarte(x * 34, y * 34);
					pancartes.add(pancarte);
					
				}
				
				// si la lecture trouve la valeur "f" dans le fichier, alors la valeur change en "L"
				// et instance la classe Portail
				else if(conv == 'f'){
					grille[x][y] = "L";
					portail = new Portail(x * 34, y * 34);
					portails.add(portail);
					
				}
				
				// si la lecture trouve la valeur "g" dans le fichier, alors la valeur change en "N"
				// et instance la classe Statue
				else if(conv == 'g'){
					grille[x][y] = "N";
					statue = new Statue(x * 34, y * 34);
					statues.add(statue);
					
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
	
	// permet de dessiner la grille quadrillée dans L'IHM
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
		int height = getHeight();

		int scale = 34; // int scale = 100;
		for (int i = 0; i <= width; i += scale) {

			g.drawLine(i, 10, i, height); // g.drawLine(i, 20, i, height);

		}

		for (int i = scale; i <= height; i += scale) {

			g.drawLine(0, i, width, i); // g.drawLine(20, i, width, i);

		}

	}

	private int getWidth(int width) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getHeight(int height) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	/*
	 * 
	 * (@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP){
			 gardien.y = -34;
		}
		if(key == KeyEvent.VK_DOWN){
			gardien.y = +34;
		}
		if(key == KeyEvent.VK_LEFT){
			gardien.x = -34;
		}
		if(key == KeyEvent.VK_RIGHT){
			gardien.x = +34;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	 */

	
	
	
	
	
}
