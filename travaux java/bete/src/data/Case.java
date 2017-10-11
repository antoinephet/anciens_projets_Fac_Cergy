package data;

import java.util.ArrayList;

import java.util.List;

import outils.Outil;

/**
 * Cette classe construit une case
 * 
 * @author Irhad et Keita
 */
public class Case {

	/**
	 * L'attribut "ligne" est un entier qui repr�sente la ligne sur laquelle se
	 * trouve la case dans une grille Il est modifiable
	 * 
	 * @see Case#getLigne()
	 * @see Case#setLigne(int)
	 */
	private int ligne;

	/**
	 * L'attribut "colonne" est un entier qui repr�sente la colonne sur laquelle
	 * se trouve la case dans une grille Il est modifiable
	 * 
	 * @see Case#getColonne()
	 * @see Case#setColonne(int)
	 */
	private int colonne;

	/**
	 * L'attribut "occupe" est un entier qui indique le nombre de b�te pr�sente
	 * dans une case il est modifiable
	 * 
	 * "0" il y a pas de b�te "1" il y a une seule b�te "2" il y a deux b�tes
	 * 
	 * @see Case#isOccupe()
	 * @see Case#setOccupe(int)
	 */
	private int occupe = 0;

	/**
	 * L'attribut "couple" est un entier qui indique les combinaisons
	 * possibles(1,2,3,4,6) des b�te dans une case (m�le et femelle, m�le et
	 * m�le femelle et femelle)
	 * 
	 * 1 : c'est un m�le 3 : c'est une femelle 2 : m�le et m�le 4 : m�le et
	 * femelle 6 : femelle et femelle
	 * 
	 * il est modifiable
	 * 
	 * @see Case#setCouple(int)
	 * @see Case#getCouple()
	 */

	private int couple;
	/**
	 * L'attribut "nourriture" indique la densit� d'une nourriture
	 * 
	 * @see Case#setNourriture(int)
	 * @see Case#getNourriture()
	 */

	private int nourriture = 0;

	/**
	 * Ce constructeur initialise les coordonn�es d'une case Et prend comme
	 * param�tre :
	 * 
	 * @param ligne
	 * @param colonne
	 */

	public Case(int ligne, int colonne) {

		this.ligne = ligne;
		this.colonne = colonne;

	}

	/**
	 * Elle retourne un attribut de la classe "Case"
	 * 
	 * @return ligne, l'une des valeurs de la classe "Case"
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Elle retourne un attribut de la classe "Case"
	 * 
	 * @return colonne, l'une des valeurs de la classe "Case"
	 */
	public int getColonne() {
		return colonne;
	}

	/**
	 * Elle retourne un attribut de la classe "Case"
	 * 
	 * @return occupe indique le nombre de b�te pr�sente dans une case
	 */
	public int isOccupe() {
		return occupe;
	}
    
	/**
	 * Elle remet � jour le nombre de b�te pr�sente dans une case
	 * 
	 * @param occup1
	 *               repr�sente le nombre de b�te ajout� dans une case
	 */
	
	public void setOccupe(int occupe1) {
		this.occupe = occupe + occupe1;
	}

	/**
	 * elle retourne la combinaison d'une case donn�e
	 * 
	 * @return couple qui est une combinaison de sexe des b�tes pr�sentent dans
	 *         une case (m�le et femelle, m�le et m�le femelle et femelle)
	 */
	public int getCouple() {
		return couple;
	}

	/**
	 * Elle remet � jour une case, en indiquant le sexe d'une b�te ou des b�tes
	 * pr�sentes
	 * 
	 * 1 : c'est un m�le 
	 * 3 : c'est une femelle 
	 * 2 : m�le et m�le 
	 * 4 : m�le et femelle 
	 * 6 : femelle et femelle
	 * 
	 * @param occup1
	 */
	public void setCouple(int sexe1) {

		this.couple = couple + sexe1;
	}

	/**
	 * retourne un attribut de la classe "Case"
	 * 
	 * @return la densit� d'une nourriture
	 */

	public int getNourriture() {
		return nourriture;
	}

	/**
	 * Cet m�thode met � jour la densit� de l'attribut "nourriture"
	 * 
	 * @param nourriture
	 *                  densit� de l'attribut "this.nourriture"
	 */
	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}

	public String getCordonn�esCase() {

		return String.valueOf("Ligne :" + ligne + " " + "Colonne :" + colonne);
	}
}
