package tuto;

import java.util.*;


public class Grille {
	
	// Attributs
	
	private int nbLig;
	private int nbCol;
	private char [][] grille;
	
	// Constructeurs
	
	public Grille(int n, int p){
		
		nbLig = n;
		nbCol = p;
		grille = new char[nbLig][nbCol];
		
		for(int i=0;i<nbLig;i++){
			for(int j=0;j<nbCol;j++){
				
				grille [i][j] = '.';
				
			}
		}
		
				
	}
	
	
	public void afficher(){
		
		System.out.println();
		for(int i=0;i<nbLig;i++){
			for(int j=0;j<nbCol;j++){
				
				System.out.print(" | " + grille [i][j]);
				
			}
			
			System.out.println(" | ");
		}
		
		System.out.println();
	
		
	}
	
	
	
	public void placer(int l, int c, char t){
		
		l = l - 1;
		c = c - 1;
		
		// On teste si on se trouve bien sur la grille
		
		if(l<0 || c<0 || l>nbLig || c>nbCol){
			
			System.out.println("Erreur de placement!!");
			return;
				
		}
		
		if(grille[l][c] == '.'){
			
			grille[l][c] = t;
		}
		
		else {
			System.out.println("Erreur, cette zone n'est pas vide!!");
		}
			
	}
	
	
	

}
