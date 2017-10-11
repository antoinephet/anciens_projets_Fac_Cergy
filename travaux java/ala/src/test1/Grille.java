package test1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Grille {
	// attributs de la classe
	String grille[][];
	int nbLigne,nbColonne,nb;
	private static ArrayList<Mur> murs;
	private static ArrayList<Eau> eaux;
	private static ArrayList<Arbre> arbres;
	
	
	boolean choixGardien1;
	boolean choixGardien2;
	boolean choixGardien3;
	boolean choixGardien4;
	
	Gardien gardien;
	Intrus intrus;
	Mur mur;
	Arbre arbre;
	Eau eau;
	FileReader fr;
	
	// constructeur par d�faut
	
	public Grille(int nbLigne,int nbColonne, int nb) {
		
		this.nbLigne = nbLigne;
		this.nbColonne = nbColonne;
		this.nb = nb;
	}
	
	
	// constructeur 
		public Grille(int ligne,int colonne) {
			
			int choix = 0;
			while(choix !=1 && choix !=2){
				
				// demande � l'utilisateur le choix pour la d�monstation
				choix = Integer.parseInt(JOptionPane.showInputDialog("Quel mode pour la d�monstation ?\n1) mode console\n2) mode Ihm"));
				System.out.println("Quel mode pour la d�monstation ?\n1) mode console\n2) mode Ihm");
				System.out.println("");
			    
				if(choix == 1){
					
					choixConsole();
					System.out.println("Vous avez choisi le mode console");
					System.out.println("");
					
				}
				
				if(choix == 2){
					choixIhm();
					System.out.println("Vous avez choisi le mode Ihm");
					System.out.println("");
					
			    }

			}

			grille = new String[nbLigne][nbColonne];
		}
		
		
			/*
			 * 
			 * m�thodes diff�rents choix pour la d�monstration du projet
			 * 
			 * 
			 */
		
			public void choixConsole(){
			
				// demande � l'utilisateur le choix de la taille de l'�cran soit al�atoirement ou manuel
				// si c'est un 1, choix al�atoire et prendra au hasard les dimensions du jeu
				//si c'est un 2, choix manuel et l'utilisateur aura 3 choix, soit il tapera soit 1,2 ou 3 selon ce qui est demand�
						
				System.out.println("Quel type de choix pour la taille de votre �cran ?\n1) al�atoire\n2) manuel");
				Scanner sc1 = new Scanner(System.in);
				int choix = sc1.nextInt() ;
						
				switch (choix){
						
				// choix al�atoire compris entre 1 et 2
						
				case 1 : System.out.println("vous avez choisi le mode manuel");
				int choix1 = (int)(Math.random()*2+1);
						
				switch (choix1){
						
					case 1 : nbLigne = nbColonne = 12;
					System.out.println("vous avez choisi 12x12");
					break ; 
										
					case 2 : nbLigne = nbColonne = 16;
					System.out.println("vous avez choisi 16x16");
					break ; 
										
					case 3 : nbLigne = nbColonne = 20;
					System.out.println("vous avez choisi 20x20");
					break ;
									
					default : System.out.println("Erreur!! Choisissez un autre chiffre svp");
						
						}
				break ; 
						
				// choix manuel
				case 2 : System.out.println("vous avez choisi le mode manuel");
				System.out.println("Choisissez les dimensions du jeu :\n1) 12x12\n2) 16x16\n3) 20x20");
				Scanner sc2 = new Scanner(System.in);
				int choice2 = sc2.nextInt() ;
						
				switch (choice2){
						
					case 1 : nbLigne = nbColonne = 12;
					System.out.println("vous avez choisi le format 12x12");
					break ; 
										
					case 2 : nbLigne = nbColonne = 16;
					System.out.println("vous avez choisi le format 16x16");
					break ; 
										
					case 3 : nbLigne = nbColonne = 20;
					System.out.println("vous avez choisi le format 20x20");
					break ;
					
									
					default : System.out.println("Erreur!! Choisissez un autre chiffre svp");
						
						}
				break ;
									
				default : System.out.println("Erreur!! Choisissez un autre chiffre svp");
						
				}
			
			}
		
			public void choixIhm(){
			
			int choix = 0;
			while(choix !=1 && choix !=2){
				
				// demande � l'utilisateur le choix pour la type de mode pour la r�solution de l'�cran : al�atoire ou manuel
				choix = Integer.parseInt(JOptionPane.showInputDialog("Quel type de choix pour la taille de votre �cran ?\n1) al�atoire\n2) manuel"));
				System.out.println("Quel type de choix pour la taille de votre �cran ?\n1) al�atoire\n2) manuel");
				System.out.println("");
			    
				// si 1, choix al�atoire
				if(choix == 1){
					JOptionPane.showMessageDialog(null,"vous avez choisi le mode al�atoire");
					int choix1 = (int)(Math.random()*2+1);
					if(choix1 == 1){
						
						nbLigne = nbColonne = 12;
						JOptionPane.showMessageDialog(null,"vous avez choisi le format 12x12");
						System.out.println("vous avez choisi le format 12x12");
						System.out.println("");
						
					}
					
					if(choix1 == 2){
						
						nbLigne = nbColonne = 20;
						JOptionPane.showMessageDialog(null,"vous avez choisi le format 20x20");
						System.out.println("vous avez choisi le format 20x20");
						System.out.println("");
						
					}
					if(choix1 == 3){
	
						nbLigne = 30; nbColonne = 21;
						JOptionPane.showMessageDialog(null,"vous avez choisi le format 30x21");
						System.out.println("vous avez choisi le format 30x21");
						System.out.println("");
	
					}
					
				}
				
				// si 2, choix manuel
				if(choix == 2){
					JOptionPane.showMessageDialog(null,"vous avez choisi le mode manuel");
					int choix2 = 0;
					while(choix2 != 1 && choix2 != 2 && choix2 != 3){
						
						choix2 = Integer.parseInt(JOptionPane.showInputDialog("Choisissez les dimensions du jeu :\n1) 12x12\n2) 16x16\n3) 20x20"));
						System.out.println("Choisissez les dimensions du jeu :\n1) 12x12\n2) 16x16\n3) 20x20");
						System.out.println("");
						
					}
					
					if(choix2 == 1){
						
						nbLigne = nbColonne = 12;
						JOptionPane.showMessageDialog(null,"vous avez choisi le format 12x12");
						System.out.println("vous avez choisi le format 12x12");
						System.out.println("");
						
					}
					
					if(choix2 == 2){
						
						nbLigne = nbColonne = 20;
						JOptionPane.showMessageDialog(null,"vous avez choisi le format 20x20");
						System.out.println("vous avez choisi le format 20x20");
						System.out.println("");
						
					}
					if(choix2 == 3){
	
						nbLigne = 30; nbColonne = 21;
						JOptionPane.showMessageDialog(null,"vous avez choisi le format 30x21");
						System.out.println("vous avez choisi le format 30x21");
						System.out.println("");
	
					}
					
				}
					
					
			  }
			
		}
		
		
		
		/*
		 * 
		 * M�thodes chargementFichier en mode console et mode IHM
		 * 
		 * 
		 */
		
		
		
		// m�thode permettant de lire les fichiers .txt du dossier Cartes
		public void chargementFichierConsole(){
			
			try{
				
				// si la taille de l'�cran est 12x12, alors le fichier Carte1.txt sera lu 
				if(nbLigne==12 && nbColonne==12){
					
					fr = new FileReader("Cartes/Carte1.txt");
					
				}
				
				// si la taille de l'�cran est 16x16, alors le fichier Carte2.txt sera lu 
				if(nbLigne==16 && nbColonne==16){
					
					fr = new FileReader("Cartes/Carte2.txt");
					
				}
				
				// si la taille de l'�cran est 20x20, alors le fichier Carte3.txt sera lu 
				if((nbLigne==20) && (nbColonne==20)){
					
					fr = new FileReader("Cartes/Carte3.txt");
					
				}
				
				
				
				int i = 0;
				int x=0, y = 0;
				
				murs = new ArrayList<Mur>();
				eaux = new ArrayList<Eau>();
				arbres = new ArrayList<Arbre>();
				
				
				while((i = fr.read()) != -1){
					char conv = (char) i; // la valeur en int convertit en char
					
					// si la lecture trouve la valeur "0" dans le fichier, alors la valeur change en "M"
					// et instance la classe Mur
					if(conv == '0'){
						grille[x][y] = "M";
						mur = new Mur(x, y);
						murs.add(mur);
						
					}
					
					// si la lecture trouve la valeur "1" dans le fichier, alors la valeur change en "A"
					// et instance la classe Arbre
					else if(conv == '1'){ // 
						
						grille[x][y] = "A";
						arbre = new Arbre(x, y);
						arbres.add(arbre);
					}
					
					// si la lecture trouve la valeur "2" dans le fichier, alors la valeur change en "E"
					// et instance la classe Eau
					else if(conv == '2'){
						grille[x][y] = "E";
						eau = new Eau(x, y);
						eaux.add(eau);
					}
					
					// si la lecture trouve la valeur "3" dans le fichier, alors la valeur change en "G"
					// et instance la classe Gardien
					else if(conv == '3'){
						
						grille[x][y] = "G";
						gardien = new Gardien(x, y);
						
					}
					
					// si la lecture trouve la valeur "4" dans le fichier, alors la valeur change en "S"
					// et instance la classe Gardien
					else if(conv == '4'){
						grille[x][y] = "S";
						gardien = new Gardien(x, y);
						
					}
					
					else if(conv == '5'){
						grille[x][y] = "C";
						gardien = new Gardien(x, y);
						
					}
					
					// si la lecture trouve la valeur "6" dans le fichier, alors la valeur change en "P"
					// et instance la classe Gardien
					else if(conv == '6'){
						grille[x][y] = "P";
						gardien = new Gardien(x, y);
						
					}
					
					// si la lecture trouve la valeur "7" dans le fichier, alors la valeur change en "I"
					// et instance la classe intrus
					else if(conv == '7'){
						grille[x][y] = "I";
						intrus = new Intrus(x, y);
						
					}
					// si la lecture trouve la valeur "8" dans le fichier, alors la valeur change en "R"
					// et instance la classe intrus
					else if(conv == '8'){
						grille[x][y] = "R";
						intrus = new Intrus(x, y);
						
					}
					
					// si la lecture trouve la valeur "9" dans le fichier, alors la valeur change en "D"
					// et instance la classe intrus
					else if(conv == '9'){
						grille[x][y] = "D";
						intrus = new Intrus(x, y);
						
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
			
		}
	

		// m�thode permettant de lire les fichiers .txt du dossier Cartes
				public void chargementFichierIhm(){
					
					try{
						
						// si la taille de l'�cran est 12x12, alors le fichier Carte1.txt sera lu 
						if(nbLigne==12 && nbColonne==12){
							
							fr = new FileReader("Cartes/Carte4.txt");
							
						}
						
						// si la taille de l'�cran est 16x16, alors le fichier Carte2.txt sera lu 
						if(nbLigne==16 && nbColonne==16){
							
							fr = new FileReader("Cartes/Carte5.txt");
							
						}
						
						// si la taille de l'�cran est 20x20, alors le fichier Carte3.txt sera lu 
						if((nbLigne==20) && (nbColonne==20)){
							
							fr = new FileReader("Cartes/Carte6.txt");
							
						}
						
						
						int i = 0;
						int x=0, y = 0;
						
						murs = new ArrayList<Mur>();
						eaux = new ArrayList<Eau>();
						arbres = new ArrayList<Arbre>();
						
						
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
								
							}
							
							// si la lecture trouve la valeur "4" dans le fichier, alors la valeur change en "S"
							// et instance la classe Gardien
							else if(conv == '4'){
								grille[x][y] = "S";
								gardien = new Gardien(x * 34, y * 34);
								
							}
							
							else if(conv == '5'){
								grille[x][y] = "C";
								gardien = new Gardien(x * 34, y * 34);
								
							}
							
							// si la lecture trouve la valeur "6" dans le fichier, alors la valeur change en "P"
							// et instance la classe Gardien
							else if(conv == '6'){
								grille[x][y] = "P";
								gardien = new Gardien(x * 34, y * 34);
								
							}
							
							// si la lecture trouve la valeur "7" dans le fichier, alors la valeur change en "I"
							// et instance la classe intrus
							else if(conv == '7'){
								grille[x][y] = "I";
								intrus = new Intrus(x * 34, y * 34);
								
							}
							// si la lecture trouve la valeur "8" dans le fichier, alors la valeur change en "R"
							// et instance la classe intrus
							else if(conv == '8'){
								grille[x][y] = "R";
								intrus = new Intrus(x * 34, y * 34);
								
							}
							
							// si la lecture trouve la valeur "9" dans le fichier, alors la valeur change en "D"
							// et instance la classe intrus
							else if(conv == '9'){
								grille[x][y] = "D";
								intrus = new Intrus(x * 34, y * 34);
								
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
					
				}
		

	
	/*
	 * 
	 * AFFICHAGE
	 * 
	 * 
	 */
	
	// methode qui affiche la grille du jeu
	public void affichage(){
		
		System.out.println();
		for (int i=0  ; i<nbLigne ; i++){
			for(int j=0 ; j<nbColonne ; j++){
				System.out.print(" |  " + grille[i][j] );
				
			}
			System.out.println(" | ");
		
		} 
		System.out.println();
		
	}
	
	/*
	 * 
	 * les m�thodes pour les diff�rents types de d�placements
	 * 
	 * 
	 */
	
	// methode qui permet de d�placer les personnage mobiles vers le haut
	public void deplacerHaut(){
		
		String vi ; // valeur interm�diaire
		
		
		for(int i = 0;i<nbLigne;i++){
			// gardien 1
			for(int j = 0;j<nbColonne;j++){
				if(grille[i][j] == "G" && choixGardien1){ // on cherche un gardien
					if(i-1 >=0 && grille[i-1][j] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i-1][j] = vi; // on d�place le gardien
						
					}if(i-1 >=0 && grille[i-1][j] == "I"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 >=0 && grille[i-1][j] == "R"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 >=0 && grille[i-1][j] == "D"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 <= nbLigne || grille[i-1][j] == "M" || grille[i-1][j] == "A" || grille[i-1][j] == "E"){
						
						collisionObstacle();
						
						
					}
					
				}
				// gardien 2
				if(grille[i][j] == "S" && choixGardien2){ // on cherche un gardien
					if(i-1 >=0 && grille[i-1][j] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i-1][j] = vi; // on d�place le gardien
						
					}if(i-1 >=0 && grille[i-1][j] == "I"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 >=0 && grille[i-1][j] == "R"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 >=0 && grille[i-1][j] == "D"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 <= nbLigne || grille[i-1][j] == "M" || grille[i-1][j] == "A" || grille[i-1][j] == "E"){
						
						collisionObstacle();
						
						
					}
					
				}
				
				// gardien 3
				if(grille[i][j] == "C" && choixGardien3){ // on cherche un gardien
					if(i-1 >=0 && grille[i-1][j] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i-1][j] = vi; // on d�place le gardien
						
					}if(i-1 >=0 && grille[i-1][j] == "I"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 >=0 && grille[i-1][j] == "R"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 >=0 && grille[i-1][j] == "D"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 <= nbLigne || grille[i-1][j] == "E" || grille[i-1][j] == "A" || grille[i-1][j] == "M"){
						
						collisionObstacle();
						
						
					}
					
				}
				// guardian 4
				if(grille[i][j] == "P" && choixGardien4){ // on cherche un gardien
					if(i-1 >=0 && grille[i-1][j] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i-1][j] = vi; // on d�place le gardien
						
					}if(i-1 >=0 && grille[i-1][j] == "I"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 >=0 && grille[i-1][j] == "R"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 >=0 && grille[i-1][j] == "D"){
						grille[i-1][j] = " ";
						collisionReperage();
						
						
					}if(i-1 <= nbLigne || grille[i-1][j] == "E" || grille[i-1][j] == "A" || grille[i-1][j] == "M"){
						
						collisionObstacle();
						
						
					}
					
				}
				// intrus 1
				if(grille[i][j] == "I"){//  on cherche l'intrus
					if(i-1 >=0 && grille[i-1][j] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i-1][j] = vi; // on d�place l'intrus
						
					}if(i-1 >=0 && grille[i-1][j] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 >=0 && grille[i-1][j] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 >=0 && grille[i-1][j] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 >=0 && grille[i-1][j] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 <= nbLigne || grille[i-1][j] == "E" || grille[i-1][j] == "A" || grille[i-1][j] == "M"){
						
						collisionObstacle();
						
						
					}


				}
				// intrus 2
				if(grille[i][j] == "R"){//  on cherche l'intrus
					if(i-1 >=0 && grille[i-1][j] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i-1][j] = vi; // on d�place l'intrus
						
					}if(i-1 >=0 && grille[i-1][j] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 >=0 && grille[i-1][j] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 >=0 && grille[i-1][j] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 >=0 && grille[i-1][j] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 <= nbLigne || grille[i-1][j] == "E" || grille[i-1][j] == "A" || grille[i-1][j] == "M"){
						
						collisionObstacle();
						
						
					}


				}
				// intrus 3
				if(grille[i][j] == "D"){//  on cherche l'intrus
					if(i-1 >=0 && grille[i-1][j] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i-1][j] = vi; // on d�place l'intrus
						
					}if(i-1 >=0 && grille[i-1][j] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 >=0 && grille[i-1][j] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 >=0 && grille[i-1][j] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 >=0 && grille[i-1][j] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(i-1 <= nbLigne || grille[i-1][j] == "E" || grille[i-1][j] == "A" || grille[i-1][j] == "M"){
						
						collisionObstacle();
						
						
					}


				}
				
			}
		}
		
		
		
	}
	
	// methode qui permet de d�placer les personnage mobiles vers le bas
	public void deplacerBas(){
		
		
		String vi ; // valeur interm�diaire
		for(int i = 0;i<nbLigne;i++){
			for(int j = 0;j<nbColonne;j++){
				
				if(grille[i][j] == "G" && choixGardien1){ // on cherche un gardien
					if(i+1 <= nbLigne && grille[i+1][j] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i+1][j] = vi; // on d�place le gardien
						return;
					}if(i+1 <=nbLigne && grille[i+1][j] == "I"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}if(i+1 <=nbLigne && grille[i+1][j] == "R"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}if(i+1 <=nbLigne && grille[i+1][j] == "D"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne || grille[i+1][j] == "E" || grille[i+1][j] == "A" || grille[i+1][j] == "M"){
						
						collisionObstacle();
						return;
						
					}


				}
				// gardien 2
				if(grille[i][j] == "S" && choixGardien2){ // on cherche un gardien
					if(i+1 <= nbLigne && grille[i+1][j] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i+1][j] = vi; // on d�place le gardien
						return;
					}if(i+1 <=nbLigne && grille[i+1][j] == "I"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}if(i+1 <=nbLigne && grille[i+1][j] == "R"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}if(i+1 <=nbLigne && grille[i+1][j] == "D"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne || grille[i+1][j] == "E" || grille[i+1][j] == "A" || grille[i+1][j] == "M"){
						
						collisionObstacle();
						return;
						
					}


				}
				// gardien 3
				if(grille[i][j] == "C" && choixGardien3){ // on cherche un gardien
					if(i+1 <= nbLigne && grille[i+1][j] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i+1][j] = vi; // on d�place le gardien
						return;
					}if(i+1 <=nbLigne && grille[i+1][j] == "I"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}if(i+1 <=nbLigne && grille[i+1][j] == "R"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}if(i+1 <=nbLigne && grille[i+1][j] == "D"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne || grille[i+1][j] == "E" || grille[i+1][j] == "A" || grille[i+1][j] == "M"){
						
						collisionObstacle();
						return;
						
					}


				}
				// gardien 4
				if(grille[i][j] == "P" && choixGardien4){ // on cherche un gardien
					if(i+1 <= nbLigne && grille[i+1][j] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i+1][j] = vi; // on d�place le gardien
						return;
					}if(i+1 <=nbLigne && grille[i+1][j] == "I"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}if(i+1 <=nbLigne && grille[i+1][j] == "R"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}if(i+1 <=nbLigne && grille[i+1][j] == "D"){
						grille[i+1][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne || grille[i+1][j] == "E" || grille[i+1][j] == "A" || grille[i+1][j] == "M"){
						
						collisionObstacle();
						return;
						
					}


				}
				// intrus 1
				if(grille[i][j] == "I"){// on cherche l'intrus
					if(i+1 <= nbLigne && grille[i+1][j] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i+1][j] = vi; // on d�place l'intrus
						return;
						
					}if(i+1 <= nbLigne && grille[i+1][j] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}if(i+1 <= nbLigne && grille[i+1][j] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne && grille[i+1][j] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne && grille[i+1][j] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne || grille[i+1][j] == "E" || grille[i+1][j] == "A" || grille[i+1][j] == "M"){
						
						collisionObstacle();
						return;
						
					}


				}
				// intrus 2
				if(grille[i][j] == "R"){// on cherche l'intrus
					if(i+1 <= nbLigne && grille[i+1][j] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i+1][j] = vi; // on d�place l'intrus
						return;
						
					}if(i+1 <= nbLigne && grille[i+1][j] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}if(i+1 <= nbLigne && grille[i+1][j] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne && grille[i+1][j] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne && grille[i+1][j] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne || grille[i+1][j] == "E" || grille[i+1][j] == "A" || grille[i+1][j] == "M"){
						
						collisionObstacle();
						return;
						
					}


				}
				// intrus 3
				if(grille[i][j] == "D"){// on cherche l'intrus
					if(i+1 <= nbLigne && grille[i+1][j] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i+1][j] = vi; // on d�place l'intrus
						return;
						
					}if(i+1 <= nbLigne && grille[i+1][j] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}if(i+1 <= nbLigne && grille[i+1][j] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne && grille[i+1][j] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne && grille[i+1][j] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						return;
						
					}
					if(i+1 <= nbLigne || grille[i+1][j] == "E" || grille[i+1][j] == "A" || grille[i+1][j] == "M"){
						
						collisionObstacle();
						return;
						
					}


				}

			}

		}
	
	}
	
	// methode qui permet de d�placer les personnage mobiles vers la gauche
	public void deplacerGauche(){
		
		String vi ; // valeur interm�diaire
		for(int i = 0;i<nbLigne;i++){
			for(int j = 0;j<nbColonne;j++){
				// gardien 1
				if(grille[i][j] == "G" && choixGardien1){ // on cherche un gardien
					if(j-1 >=0 && grille[i][j-1] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; //on vide la case
						grille[i][j-1] = vi; // on d�place le gardien
						
					}if(j-1 >=0 && grille[i][j-1] == "I"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "R"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "D"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}
					if(j-1 >=0 || grille[i][j-1] == "E" || grille[i][j-1] == "A" || grille[i][j-1] == "M"){
						
						collisionObstacle();
						
					}

				}
				// gardien 2
				if(grille[i][j] == "S" && choixGardien2){ // on cherche un gardien
					if(j-1 >=0 && grille[i][j-1] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; //on vide la case
						grille[i][j-1] = vi; // on d�place le gardien
						
					}if(j-1 >=0 && grille[i][j-1] == "I"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "R"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "D"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}
					if(j-1 >=0 || grille[i][j-1] == "E" || grille[i][j-1] == "A" || grille[i][j-1] == "M"){
						
						collisionObstacle();
						
					}

				}
				// gardien 3
				if(grille[i][j] == "C" && choixGardien3){ // on cherche un gardien
					if(j-1 >=0 && grille[i][j-1] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; //on vide la case
						grille[i][j-1] = vi; // on d�place le gardien
						
					}if(j-1 >=0 && grille[i][j-1] == "I"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "R"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "D"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}
					if(j-1 >=0 || grille[i][j-1] == "E" || grille[i][j-1] == "A" || grille[i][j-1] == "M"){
						
						collisionObstacle();
						
					}

				}
				// gardien 4
				if(grille[i][j] == "P" && choixGardien4){ // on cherche un gardien
					if(j-1 >=0 && grille[i][j-1] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; //on vide la case
						grille[i][j-1] = vi; // on d�place le gardien
						
					}if(j-1 >=0 && grille[i][j-1] == "I"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "R"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "D"){
						grille[i][j-1] = " ";
						collisionReperage();
						
					}
					if(j-1 >=0 || grille[i][j-1] == "E" || grille[i][j-1] == "A" || grille[i][j-1] == "M"){
						
						collisionObstacle();
						
					}

				}
				
				// intrus 1
				if(grille[i][j] == "I"){// on cherche l'intrus
					if(j-1 >=0 && grille[i][j-1] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i][j-1] = vi; // on d�place l'intrus
						
					}if(j-1 >=0 && grille[i][j-1] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						
					}
					if(j-1 >=0 || grille[i][j-1] == "E" || grille[i][j-1] == "A" || grille[i][j-1] == "M"){
						
						collisionObstacle();
						
					}

				}
				// intrus 2
				if(grille[i][j] == "R"){// finding intruder
					if(j-1 >=0 && grille[i][j-1] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i][j-1] = vi; // on d�place l'intrus
						
					}if(j-1 >=0 && grille[i][j-1] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						
					}
					if(j-1 >=0 || grille[i][j-1] == "E" || grille[i][j-1] == "A" || grille[i][j-1] == "M"){
						
						collisionObstacle();
						
					}

				}
				// intrus 3 
				if(grille[i][j] == "D"){// on cherche l'intrus
					if(j-1 >=0 && grille[i][j-1] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i][j-1] = vi; // on d�place l'intrus
						
					}if(j-1 >=0 && grille[i][j-1] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						
					}if(j-1 >=0 && grille[i][j-1] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						
					}
					if(j-1 >=0 || grille[i][j-1] == "E" || grille[i][j-1] == "A" || grille[i][j-1] == "M"){
						
						collisionObstacle();
						
					}

				}

			}

		}
	
	}
	
	// methode qui permet de d�placer les personnage mobiles vers la droite
	
	public void deplacerDroite(){
		
		String vi ;
		for(int i = 0;i<nbLigne;i++){
			for(int j = 0;j<nbColonne;j++){
				if(grille[i][j] == "G" && choixGardien1){ // on cherche un gardien
					if(j+1 <=nbColonne && grille[i][j+1] == " "){ // on teste la position du gardien
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i][j+1] = vi; // on d�place le gardien
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "I"){
						grille[i][j+1] = " ";
						collisionReperage();
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "R"){
						grille[i][j+1] = " ";
						collisionReperage();
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "D"){
						grille[i][j+1] = " ";
						collisionReperage();
						break;
						
					}
					if(j+1 <=nbColonne || grille[i][j+1] == "E" || grille[i][j+1] == "A" || grille[i][j+1] == "M"){
						
						collisionObstacle();
						break;
					}
					
				}
				// gardien 2
				if(grille[i][j] == "S" && choixGardien2){ // finding player
						if(j+1 <=nbColonne && grille[i][j+1] == " "){ // on teste la position du gardien
							vi = grille[i][j];
							grille[i][j] = " "; // on vide la case
							grille[i][j+1] = vi; // on d�place le gardien
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "I"){
							grille[i][j+1] = " ";
							collisionReperage();
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "R"){
							grille[i][j+1] = " ";
							collisionReperage();
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "D"){
							grille[i][j+1] = " ";
							collisionReperage();
							break;
							
						}
						if(j+1 <=nbColonne || grille[i][j+1] == "E" || grille[i][j+1] == "A" || grille[i][j+1] == "M"){
							
							collisionObstacle();
							break;
						}
					
				}
				// gardien 3
				if(grille[i][j] == "C" && choixGardien3){ // on cherche un gardien
						if(j+1 <=nbColonne && grille[i][j+1] == " "){ // on teste la position du gardien
							vi = grille[i][j];
							grille[i][j] = " "; // on vide la case
							grille[i][j+1] = vi; // on d�place le gardien
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "I"){
							grille[i][j+1] = " ";
							collisionReperage();
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "R"){
							grille[i][j+1] = " ";
							collisionReperage();
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "D"){
							grille[i][j+1] = " ";
							collisionReperage();
							break;
							
						}
						if(j+1 <=nbColonne || grille[i][j+1] == "E" || grille[i][j+1] == "A" || grille[i][j+1] == "M"){
							
							collisionObstacle();
							break;
						}
					
				}
				
				// gardien 4
				if(grille[i][j] == "P" && choixGardien4){ // on cherche un gardien
						if(j+1 <=nbColonne && grille[i][j+1] == " "){ // on teste la position du gardien
							vi = grille[i][j];
							grille[i][j] = " "; // on vide la case
							grille[i][j+1] = vi; // on d�place le gardien
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "I"){
							grille[i][j+1] = " ";
							collisionReperage();
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "R"){
							grille[i][j+1] = " ";
							collisionReperage();
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "D"){
							grille[i][j+1] = " ";
							collisionReperage();
							break;
							
						}
						if(j+1 <=nbColonne || grille[i][j+1] == "E" || grille[i][j+1] == "A" || grille[i][j+1] == "M"){
							
							collisionObstacle();
							break;
						}
					
				}
				
				// intrus 1
				
				if(grille[i][j] == "I"){// on cherche l'intrus
					if(j+1 <=nbColonne && grille[i][j+1] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i][j+1] = vi; // on d�place l'intrus
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}
					if(j+1 <=nbColonne || grille[i][j+1] == "E" || grille[i][j+1] == "A" || grille[i][j+1] == "M"){
						
						collisionObstacle();
						break;
					}

				}
				
				// intrus 2
				if(grille[i][j] == "R"){// on cherche l'intrus
					if(j+1 <=nbColonne && grille[i][j+1] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i][j+1] = vi; // on d�place l'intrus
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}
					if(j+1 <=nbColonne || grille[i][j+1] == "E" || grille[i][j+1] == "A" || grille[i][j+1] == "M"){
						
						collisionObstacle();
						break;
					}

				}
				// intrus 3
				if(grille[i][j] == "D"){// on cherche l'intrus
					if(j+1 <=nbColonne && grille[i][j+1] == " "){// on teste la position de l'intrus
						vi = grille[i][j];
						grille[i][j] = " "; // on vide la case
						grille[i][j+1] = vi; // on d�place l'intrus
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "G"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "S"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "C"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}if(j+1 <=nbColonne && grille[i][j+1] == "P"){
						grille[i][j] = " ";
						collisionReperage();
						break;
						
					}
					if(j+1 <=nbColonne || grille[i][j+1] == "E" || grille[i][j+1] == "A" || grille[i][j+1] == "M"){
						
						collisionObstacle();
						break;
					}

				}
			}

		}
		
	}
	
	/*
	 * 
	 * les m�thodes pour les d�placemnts al�atoires et manuelles
	 * 
	 * 
	 */
	
	
	// methode qui permet de d�placer al�atoirement les personnage mobiles
	public void deplacerAleatoire(){
		choixGardien1 = true; choixGardien2 = true; choixGardien3= true; choixGardien4 = true;
		int i=0;
		
		//(int)(Math.random()*4+1);
		while(i<100){
			
			// choix nombre compris entre 1 et 4
			int choix = (int)(Math.random()*4+1);
			
			switch (choix){
			
			case 1 : deplacerHaut();
			break ; 
							
			case 2 : deplacerBas();
			break ; 
							
			case 3 : deplacerGauche();
			break ; 
							
			case 4 : deplacerDroite();
			break ;  
						
			default : System.out.println("Erreur!! Choisissez un autre nombre!");
			
			}
			
			try {
				// rafraichit l'�cran
				Runtime.getRuntime().exec("cmd /c cls");
				Thread.sleep(2000);
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			// met � jour la grille
			affichage();
			i++;
			
		}
		
	}
	
	// methode qui permet de d�placer manuellement les personnage mobiles et choisir son gardien
	public void deplacementManuel(){
		
		int i=0;
		
		while(i<100){
			
			JOptionPane.showMessageDialog(null,"vous avez choisi le mode manuel");
			int choix2 = 0;
			while(choix2 != 1 && choix2 != 2 && choix2 != 3 && choix2 != 4 && choix2 != 5 && choix2 != 6){
				
				choix2 = Integer.parseInt(JOptionPane.showInputDialog("Quelle direction pour diriger le gardien ?\n\n1 : haut\n2 : bas \n3 : gauche\n4 : droite\n5 : choisir un autre gardien\n6 : quitter "));
				System.out.println("Quelle direction pour diriger le gardien ?\n\n1 : haut\n2 : bas \n3 : gauche\n4 : droite\n5 : choisir un autre gardien\n6 : quitter ");
				System.out.println("");
				
			}
			
			if(choix2 == 1){
				
				deplacerHaut();
				
			}
			
			if(choix2 == 2){
				
				deplacerBas();
				
			}
			if(choix2 == 3){

				deplacerGauche();

			}
			
			if(choix2 == 4){
				
				deplacerDroite();
				
			}
			
			// permet de choisir son gardien
			if(choix2 == 5){
				int choix1 = 0;
				while(choix1 != 1 && choix1 != 2 && choix1 != 3 && choix1 != 4){
					choix1 = Integer.parseInt(JOptionPane.showInputDialog("Choississez votre gardien\n\n1 : gardien G\n2 : gardien S\n3 : gardien C\n4 : gardien P"));
					System.out.println("Choississez votre gardien\n\n1 : gardien G\n2 : gardien S\n3 : gardien C\n4 : gardien P");
					System.out.println("");
					if(choix1 == 1){
						
						choixGardien1 = true; choixGardien2 = false;choixGardien3 = false;choixGardien4 = false;
						
					}
					
					if(choix1 == 2){
						
						choixGardien1 = false; choixGardien2 = true;choixGardien3 = false;choixGardien4 = false;
						
					}

					if(choix1 == 3){
	
						choixGardien1 = false; choixGardien2 = false;choixGardien3 = true;choixGardien4 = false;
	
					}
					if(choix1 == 4){
	
						choixGardien1 = false; choixGardien2 = false;choixGardien3 = false;choixGardien4 = true;
	
					}
					
					
				}
				
			}
			
			if(choix2 == 6){

				i=100 ;

			}
			
			
			try {
				// rafraichit l'�cran
				Runtime.getRuntime().exec("cmd /c cls");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// met � jour la grille
			affichage();
			i++;
			
		}
		
	}
	
	// methode qui signale une collision
	public void collisionReperage(){
		
		System.out.println("\n Alerte collision! Le Gardien a rep�r� et attrap� un intrus!!");
		
	}

	// methode qui signale une collision
	public void collisionObstacle(){
		
		System.out.println("\n Alerte collision! Le gardien ou l'intrus ne peut pas franchir cet obstacle!");
	
	}
	
	// mode IHM
	//
	
	
	
	public void draw(Graphics2D g2d){
		
		for(int i=0;i < murs.size();i++){
			mur = (Mur) murs.get(i);
			mur.draw(g2d);
			
		}
		
		//try{
			
			// g2d.drawImage(gardien.getImage(), gardien.getX(), gardien.getY(), null);
			
			
		// }catch(Exception ex){}
		
		//g.setColor(Color.BLACK);
		//g.setFont(levelFont);
		//g.drawString("Level : " + level, 10, 25);
		
	}
	
	
	

}
