package creationJeux;

import java.util.*;

public class Grille {
	
	private int nbLig;
	private int nbCol;
	char [][] grille;
	
	
	
	public Grille(int nbLig, int nbCol) {
		
		this.nbLig = nbLig;
		this.nbCol = nbCol;
		grille = new char[nbLig][nbCol];
		
		for(int i = 0;i<nbLig;i++){
			for(int j = 0;j<nbCol;j++){
				
				grille[i][j] = '-';
				
			}
		}
		
	}
	
	public char getCase(int l,int c){
		
		return grille[l-1][c-1];
	}


	public void afficher(){
		
		System.out.println();
		
		for(int i = 0;i<nbLig;i++){
			for(int j = 0;j<nbCol;j++){
				
				System.out.print("|" + grille[i][j] );
				
			}
			System.out.println("|");
		}
		System.out.println();
		
		
	}
	
	public void placer(int l, int c , char t){
		
		l = l - 1;
		c = c - 1;
		
		if(l<0 || c<0 || l>nbLig || c>nbCol){
			
			System.out.print("Erreur!");
			return;
			
		}
		
		if(grille[l][c] == '-'){
			
			grille[l][c] = t;
			
			
		}
		else {
			
			System.out.println("Erreur, cette zone n'est pas vide!");
			
		}
		
		
	}
	
	public void deplacerH(){
		
		char tmp;
		for(int i = 0;i<nbLig;i++){
			for(int j = 0;j<nbCol;j++){
				
				if(grille[i][j] == 'J'){ // on cherche le joueur
					if(i-1 >=0 && grille[i-1][j] == '-'){ // on teste la position du joueur
						
						tmp = grille[i][j];
						grille[i][j] = '-'; // on vide la case
						grille[i-1][j] = tmp; // on déplace le perso
						
					}
					
					// S'il y a un monstre
						if(i-1 >=0 && grille[i-1][j] == 'M'){ // on teste la position du monstre
							tmp = grille[i][j];
							grille[i][j] = '-'; // on vide la case
							grille[i-1][j] = tmp; // on déplace le perso
						
						}
					
				}
				
				
			}
		}
		
	}
	
	
	public void deplacerB(){
		
		char tmp;
		for(int i = 0;i<nbLig;i++){
			for(int j = 0;j<nbCol;j++){
				
				if(grille[i][j] == 'J'){ // on cherche le joueur
					if(i+1 <= nbLig && grille[i+1][j] == '-'){ // on teste la position du joueur
						
						tmp = grille[i][j];
						grille[i][j] = '-'; // on vide la case
						grille[i+1][j] = tmp; // on déplace le perso
						return;
						
					}
					
				}
				
				
			}
		}
		
	}


	public void deplacerG(){
	
	char tmp;
	for(int i = 0;i<nbLig;i++){
		for(int j = 0;j<nbCol;j++){
			
			if(grille[i][j] == 'J'){ // on cherche le joueur
				if(j-1 >=0 && grille[i][j-1] == '-'){ // on teste la position du joueur
					
					tmp = grille[i][j];
					grille[i][j] = '-'; // on vide la case
					grille[i][j-1] = tmp; // on déplace le perso
					
				}
				
			}
			
			
		}
	}
	
	}
	
	public void deplacerD(){
		
		char tmp;
		for(int i = 0;i<nbLig;i++){
			for(int j = 0;j<nbCol;j++){
				
				if(grille[i][j] == 'J'){ // on cherche le joueur
					if(j+1 <=nbCol && grille[i][j+1] == '-'){ // on teste la position du joueur
						
						tmp = grille[i][j];
						grille[i][j] = '-'; // on vide la case
						grille[i][j+1] = tmp; // on déplace le perso
						break;
					}
					
				}
				
				
			}
		}
		
	}

}
