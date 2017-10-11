package ater;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grille {

	private int nbLigne ;
	private int nbColonne ; 
	private int cases ;
	private int nbIntrus ; 
	//private ArrayList <Arbre >arbres ;
	//private ArrayList<Mur>murs ;
	//private ArrayList<Eau>eaux ; 
	private ArrayList<Gardien>gardiens ; 
	private ArrayList<Intrus> intrus ;
	private char [][] grille  ;
	Intrus tempIntrus;
	Gardien tempGardien;
	


	public Grille(int nbLigne, int nbColonne, int nbIntrus) {
		this.nbLigne = nbLigne;
		this.nbColonne = nbColonne;
		this.nbIntrus = nbIntrus;
	}
	
	public Grille  (int lig , int col){
		nbLigne= lig ;
		nbColonne = col ;
		
		grille = new char[nbLigne][nbColonne];
		
		for (int i=0  ; i<nbLigne ; i++){
			for(int j=0 ; j<nbColonne ; j++){
				grille[i][j] = '-' ;
				
			}
		}
	}
	
	
	public void afficher() {
		// TODO Auto-generated method stub
		
		System.out.println();
		for (int i=0  ; i<nbLigne ; i++){
			for(int j=0 ; j<nbColonne ; j++){
				System.out.print(" |  " + grille[i][j] );
				
			}
			System.out.println(" | ");
		
		} 
		System.out.println();
		
		
	}
	
	
	public int getCases(int lign , int colo) {
		return  grille[lign-1][colo-1] ;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}

	public int getNbLigne() {
		return nbLigne;
	}


	public int getNbColonne() {
		return nbColonne;
	}


	public int getNbIntrus() {
		return nbIntrus;
	}


	
	public void placerIntrus(int lign , int colo , char intrus ){
	    
		lign = lign - 1 ; 
		colo = colo - 1 ; 
		
		
		if(lign<0 || colo<0 || lign >nbLigne|| colo > nbColonne ){
			System.out.println("erreur");
			return;
		}
		if ( grille[lign][colo]=='-'){
			
			grille[lign][colo] = intrus ;
			
		}
		else {
			
			System.out.println("case vide");
			return ;
		}
	}
	public void placerGardien (int lign , int colo , char gardien ){
	    
		lign = lign - 1 ; 
		colo = colo - 1 ; 
		
		
		if(lign<0 || colo<0 || lign >nbLigne|| colo > nbColonne ){
			System.out.println("erreur");
			return;
		}
		
		if ( grille[lign][colo]=='-'){
			
			grille[lign][colo] = gardien ;
			
			
		}
		
		else {
			
			System.out.println("case vide");
			return ;
		}
	}
		public void placerObjet (int lign , int colo , char gardien ){
		    
			lign = lign - 1 ; 
			colo = colo - 1 ; 
			
			
			if(lign<0 || colo<0 || lign >nbLigne|| colo > nbColonne ){
				System.out.println("erreur");
				return;
			}
			
			if ( grille[lign][colo]=='-'){
				
				grille[lign][colo] = gardien ;
				
				
			}
			
			else {
				
				System.out.println("case vide");
				return ;
			
			}
		}	
		
		public void deplacerVersLeHaut(){
			char tmp ;
			
			for(int i = 0;i<nbLigne;i++){

				for(int j = 0;j<nbColonne;j++){
					if(grille[i][j] == 'G'){ // on cherche le joueur
						if(i-1 >=0 && grille[i-1][j] == '-'){ // on teste la position du joueur
							tmp = grille[i][j];
							grille[i][j] = '-'; // on vide la case
							grille[i-1][j] = tmp; // on d�place le perso
							
						}
						
					}
					if(grille[i][j] == 'I'){// on cherche l'intrus
						if(i-1 >=0 && grille[i-1][j] == '-'){// on teste la position de l'intrus
							tmp = grille[i][j];
							grille[i][j] = '-'; // on vide la case
							grille[i-1][j] = tmp; // on d�place le perso
							
						}

					}
					
				}
			}
			
		}
		
		public void deplacerVersLeBas(){
			char tmp ;
			for(int i = 0;i<nbLigne;i++){
				for(int j = 0;j<nbColonne;j++){
					
					if(grille[i][j] == 'G'){ // on cherche le joueur
						if(i+1 <= nbLigne && grille[i+1][j] == '-'){ // on teste la position du joueur
							tmp = grille[i][j];
							grille[i][j] = '-'; // on vide la case
							grille[i+1][j] = tmp; // on d�place le perso
							return;
						}

					}
					if(grille[i][j] == 'I'){// on cherche l'intrus
						if(i+1 <= nbLigne && grille[i+1][j] == '-'){// on teste la position de l'intrus
							tmp = grille[i][j];
							grille[i][j] = '-'; // on vide la case
							grille[i+1][j] = tmp; // on d�place le perso
							return;
							
						}

					}

				}

			}
			
		}
		public void deplacerDroite(){
			char tmp ;
			for(int i = 0;i<nbLigne;i++){
				for(int j = 0;j<nbColonne;j++){
					if(grille[i][j] == 'G'){ // on cherche le joueur
						if(j+1 <=nbColonne && grille[i][j+1] == '-'){ // on teste la position du joueur
							tmp = grille[i][j];
							grille[i][j] = '-'; // on vide la case
							grille[i][j+1] = tmp; // on d�place le perso
							break;
							
						}
						
					}
					if(grille[i][j] == 'I'){// on cherche l'intrus
						if(j+1 <=nbColonne && grille[i][j+1] == '-'){// on teste la position de l'intrus
							tmp = grille[i][j];
							grille[i][j] = '-'; // on vide la case
							grille[i][j+1] = tmp; // on d�place le perso
							break;
							
						}

					}
				}

			}
			
		}
		
		public void deplacerGauche(){
			char tmp ;
			for(int i = 0;i<nbLigne;i++){
				for(int j = 0;j<nbColonne;j++){
					if(grille[i][j] == 'G'){ // on cherche le joueur
						if(j-1 >=0 && grille[i][j-1] == '-'){ // on teste la position du joueur
							tmp = grille[i][j];
							grille[i][j] = '-'; // on vide la case
							grille[i][j-1] = tmp; // on d�place le perso
							
						}

					}
					if(grille[i][j] == 'I'){// on cherche l'intrus
						if(j-1 >=0 && grille[i][j-1] == '-'){// on teste la position de l'intrus
							tmp = grille[i][j];
							grille[i][j] = '-'; // on vide la case
							grille[i][j-1] = tmp; // on d�place le perso
							
						}

					}

				}

			}
			
		}
		
			//d�placement al�atoire des intrus 
			
			public void deplacerAleatoire(){
				
				int i=0;
				
				//(int)(Math.random()*4+1);
				while(i<100){
					
					// chiffre al�atoire compris entre 1 et 4
					int cmpt = (int)(Math.random()*4+1);
					
					switch (cmpt){
					
					case 1 : deplacerVersLeHaut(); 
					break ; 
									
					case 2 : deplacerVersLeBas();
					break ; 
									
					case 3 : deplacerDroite();
					break ; 
									
					case 4 : deplacerGauche();
					break ;  
								
					default : System.out.println("Erreur!! Choisissez un autre chiffre svp");
					
					}
					
					try {
						// rafraichit l'�cran de la console
						Runtime.getRuntime().exec("cmd /c cls");
						Thread.sleep(2000);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					// met � jour l'affichage de la grille
					afficher();
					i++;
					
				}
				
			}
			
			// demande manuelle pour les d�placements des �l�ments
			public void deplacerManuel(){
				
				int i=0;
				
				//String str = sc1.nextLine();
				
				//(int)(Math.random()*4+1);
				while(i<5){
					
					System.out.println("Vers o� voulez vous vous deplacer ?\n\n1 : vers le haut\n2 : vers le bas \n3 : vers la droite\n4 : vers la gauche\n5 : quitter ");
					Scanner sc1 = new Scanner(System.in);
					int cmpt = sc1.nextInt() ;
					
					switch (cmpt){
					
					case 1 : deplacerVersLeHaut(); 
					break ; 
									
					case 2 : deplacerVersLeBas();
					break ; 
									
					case 3 : deplacerDroite();
					break ; 
									
					case 4 : deplacerGauche();
					break ; 
					
					case 5 :i=5 ; 
					break ; 
								
					default : System.out.println("Erreur!! Choisissez un autre chiffre svp");
					
					}
					try {
						// rafraichit l'�cran de la console 
						Runtime.getRuntime().exec("cmd /c cls");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// met � jour l'affichage de la grille
					afficher();
					i++;
					
				}
				
		}
			
			public void update(){
				// mise en place des ennemis
				for(int i = 0;i < intrus.size();i++){
					tempIntrus = intrus.get(i);
					
					// si les ennemis atteignent le point x = 20, ils disparaissent
					if(tempIntrus.x < 20){
						removeIntrus(tempIntrus);
						
					}
					tempIntrus.update();
					
				}
			}
			
			
			public void draw(Graphics2D g2d){
				
				// dessine les intrus
				for(int i = 0;i < intrus.size();i++){
					
					tempIntrus = intrus.get(i);
					tempIntrus.draw(g2d);
				}
				
				// dessine les gardiens
				for(int i = 0;i < gardiens.size();i++){
					
					tempGardien = gardiens.get(i);
					tempGardien.draw(g2d);
				}
				
			}
			
			public void addIntrus(Intrus i){
				intrus.add(i);
				
			}
			
			public void removeIntrus(Intrus i){
				
				intrus.remove(i);
				
			}
			
			public void addGardien(Gardien i){
				gardiens.add(i);
				
			}
			
			public void removeGardien(Gardien i){
				
				gardiens.remove(i);
				
			}



}


