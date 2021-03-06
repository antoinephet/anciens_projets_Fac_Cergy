package modele;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import visiteurs.Visiteur;

public class Grille {

	private int nbLigne;
	private int nbColonne;
	private int cases;
	private int nbIntrus;
	private char[][] grille;
	Intrus tempIntrus;
	Gardien tempGardien;
	Mur tempMur;
	Arbre tempArbre;
	Eau tempEau;

	public Grille(int nbLigne, int nbColonne, int nbIntrus) {
		this.nbLigne = nbLigne;
		this.nbColonne = nbColonne;
		this.nbIntrus = nbIntrus;
	}

	public Grille(int lig, int col) {
		nbLigne = lig;
		nbColonne = col;
	}

	public void afficher() {
		// TODO Auto-generated method stub

		System.out.println();
		for (int i = 0; i < nbLigne; i++) {
			for (int j = 0; j < nbColonne; j++) {
				System.out.print(" |  " + grille[i][j]);
			}
			System.out.println(" | ");
		}
		System.out.println();

	}

	public int getCases(int lign, int colo) {
		return grille[lign - 1][colo - 1];
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

	// /**
	// * Place un intrus sur la grille
	// *
	// * @param lign
	// * @param colo
	// * @param intrus
	// */
	// public void placerIntrus(int lign, int colo, char intrus) {
	//
	// lign = lign - 1;
	// colo = colo - 1;
	//
	// if (lign < 0 || colo < 0 || lign > nbLigne || colo > nbColonne) {
	// System.out.println("erreur");
	// return;
	// }
	// if (grille[lign][colo] == '-') {
	//
	// grille[lign][colo] = intrus;
	//
	// } else {
	//
	// System.out.println("case vide");
	// return;
	// }
	// }

	/**
	 * @param lign
	 * @param colo
	 * @param gardien
	 */
	public void placerGardien(int lign, int colo, char gardien) {

		lign = lign - 1;
		colo = colo - 1;

		if (lign < 0 || colo < 0 || lign > nbLigne || colo > nbColonne) {
			System.out.println("erreur");
			return;
		}

		if (grille[lign][colo] == '-') {

			grille[lign][colo] = gardien;

		}

		else {

			System.out.println("case vide");
			return;
		}
	}

	// /**
	// * @param lign
	// * @param colo
	// * @param gardien
	// */
	// public void placerObjet(int lign, int colo, char gardien) {
	//
	// lign = lign - 1;
	// colo = colo - 1;
	//
	// if (lign < 0 || colo < 0 || lign > nbLigne || colo > nbColonne) {
	// System.out.println("erreur");
	// return;
	// }
	//
	// if (grille[lign][colo] == '-') {
	//
	// grille[lign][colo] = gardien;
	//
	// }
	//
	// else {
	//
	// System.out.println("case vide");
	// return;
	//
	// }
	// }

	public void deplacer() {
		char tmp;

		for (int i = 0; i < nbLigne; i++) {
			for (int j = 0; j < nbColonne; j++) {

				Case cace = new Case(i, j);

				if (grille[i][j] == 'G') { // on cherche un gardien
					if (i - 1 >= 0 && grille[i - 1][j] == '-') { // on teste la
																	// position
																	// du joueur
						tmp = grille[i][j];
						grille[i][j] = '-'; // on vide la case
						grille[i][j] = tmp; // on d�place le perso

					}
					if (i - 1 >= 0 && grille[i - 1][j] == 'I') {
						grille[i][j] = '-';
						collisionRepere();

					}
					if (grille[i][j] != '-') { // si la case n'est pas vide il y
												// a collision entre les
												// éléments
						collisionObstacle();
					}

				}
				if (grille[i][j] == 'I') {// on cherche l'intrus
					if (i - 1 >= 0 && grille[i - 1][j] == '-') {// on teste la
																// position de
																// l'intrus
						tmp = grille[i][j];
						grille[i][j] = '-'; // on vide la case
						grille[i - 1][j] = tmp; // on d�place le perso

					}
					if (i - 1 >= 0 && grille[i - 1][j] == 'G') {
						grille[i][j] = '-';
						collisionRepere();

					}
					if (i - 1 <= nbLigne || grille[i - 1][j] == 'E'
							|| grille[i - 1][j] == 'A'
							|| grille[i - 1][j] == 'M') {

						collisionObstacle();

					}

				}

			}
		}

	}

	public void collisionRepere() {
		System.out
				.println("\n Alerte collision! Le Gardien a rep�r� et attrap� l'intrus");
	}

	public void collisionObstacle() {
		System.out
				.println("\n Alerte collision! Le Gardien ou l'intrus ne peut pas passer");
	}

	// d�placement al�atoire des intrus


	// demande manuelle pour les d�placements des �l�ments
	public void deplacerManuel() {

		int i = 0;

		// String str = sc1.nextLine();

		// (int)(Math.random()*4+1);
		while (i < 100) {

			System.out
					.println("Vers où voulez vous vous déplacer ?\n\n1 : vers le haut\n2 : vers le bas \n3 : vers la droite\n4 : vers la gauche\n5 : quitter ");
			Scanner sc1 = new Scanner(System.in);
			int cmpt = sc1.nextInt();

			switch (cmpt) {
			case 1:
				deplacer();
				break;
			case 2:
				// deplacerVersLeBas();
				break;
			case 3:
				// deplacerDroite();
				break;
			case 4:
				// deplacerGauche();
				break;
			case 5:
				i = 100;
				break;

			default:
				System.out.println("Erreur!! Choisissez un autre chiffre svp");

			}
			try {
				// rafraichit l'écran de la console
				Runtime.getRuntime().exec("cmd /c cls");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// met à jour l'affichage de la grille
			afficher();
			i++;

		}

	}

	void accepteVisiteur(Visiteur v) {
		v.visite(this);
	}

}
