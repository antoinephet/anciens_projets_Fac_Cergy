package data;

import outils.Outil;

/**
 * Cette classe construit un couple 
 * @author Irhad et Keita
 */
public class Couple {
	
	/**
	 *L'attribut "ligne" est un entier qui représente la ligne d'une grille
	 * il est modifiable 
	 * 
	 * @see Couple#getLigne() 
	 * @see Couple#setLigne(int)
	 */
	private int ligne;
	
	/**
	 *L'attribut "colonne" est un entier qui représente la colonne d'une grille
	 * il est modifiable 
	 * 
	 * @see Couple#getColonne() 
	 * @see Couple#setColonne(int)
	 */
	private int colonne;
	
	
	/**
	 * Le constructeur "Couple" initialise les coordonnées : ligne et colonne 
	 * il prend comme paramètres :
	 * 
	 * @param ligne
	 * @param colonne
	 */
	public Couple(int ligne, int colonne) {

		this.ligne=ligne;
		this.colonne=colonne;

	}
	   
	 /**
     * Elle retourne un attribut de la classe "Couple"
     * 
     * @return ligne
     */
	public int getLigne() {
		return ligne;
	}
	
	 /**
     * Elle retourne un attribut de la classe "Couple"
     * 
     * @return colonne
     */
	public int getColonne() {
		return colonne;
	}

}
