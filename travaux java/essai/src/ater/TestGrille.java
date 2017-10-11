package ater;

import java.util.Scanner;

public class TestGrille {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		//String str = sc1.nextLine();
		int x,y;
		System.out.println("****************D�but du jeu****************");
		System.out.println("****************LE GARDIEN DE PARC****************");
		System.out.println("\n\n");
		System.out.println("Saisissez les dimensions de votre grille du jeu");
		System.out.println("\n");
		System.out.println("Tout d'abord, choisissez un nombre pour les lignes de votre grille svp");
		
		Scanner sc1 = new Scanner(System.in);
		x = sc1.nextInt();
		System.out.println("Choisissez un autre nombre pour les colonnes de votre grille svp");
		Scanner sc2 = new Scanner(System.in);
		y = sc2.nextInt();
		
		System.out.println("Le format de votre grille est de "+ x +" x " + y);
		System.out.println("\n\n");
		
		
		// instance de la grille du jeu
		Grille gl = new Grille( x , y);
		
		System.out.println("****************Cr�ation des �l�ments du jeu****************");
		System.out.println("****************Placement des �l�ments****************");
		System.out.println("\n\n");
		System.out.println("L�gende :\n\nG = gardien\nI = intrus\nE= eau\nM = mur\nA = arbre");
		
		// position des intrus
		gl.placerIntrus(2, 4, 'I');
		
		// position des gardiens
		gl.placerGardien(3, 7, 'G');
		gl.placerGardien(2, 6, 'G');
		gl.placerGardien(1, 7, 'G');
		
		// position des obstacles
		gl.placerObjet(3, 2, 'E');
		gl.placerObjet(1, 1, 'M');
		gl.placerObjet(4, 5, 'A');
		gl.placerObjet(5, 5, 'E');
		gl.placerObjet(6, 2, 'M');
		
		
		gl.afficher();
		
		gl.deplacerManuel();
		
		System.out.println("\n\n");
		System.out.println("Test des d�placements al�atoires des gardiens et des intrus...");
		System.out.println("\n\n");
		
		gl.deplacerAleatoire();
		
		

	}
		
		
		
	
	}


