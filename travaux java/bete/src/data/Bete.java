package data;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import outils.Outil;

import data.AttaqueCar;

/**
 * Cette classe definit une b�te
 * 
 * @author Irhad et Keita
 */
public class Bete {

	/**
	 * L'attribut "energie" est un entier qui d�termine l��nergie de la b�te il
	 * est modifiable
	 * 
	 * @see Bete#setEnergie(int)
	 * @see Bete#getEnergie()
	 */
	private int energie;

	/**
	 * L'attribut "sexe" est un entier qui d�termine le sexe de la b�te "0"
	 * c'est une femelle, "1" c'est un m�le il n'est pas modifiable
	 * 
	 * @see Bete#getEnergie()
	 */
	private int sexe; // 0 c'est un m�le, 1 c'est une femelle

	/**
	 * L'attribut "energieMax" est un entier qui d�termine l��nergie maximal de
	 * la b�te il n'est pas modifiable
	 * 
	 * @see Bete#getEnergie()
	 */
	private int energieMax;

	/**
	 * L'attribut "ligne" est un entier qui d�termine la ligne sur la quelle se
	 * trouve la b�te
	 * 
	 * il est modifiable
	 * 
	 * @see Bete#setLigne(int)
	 * @see Bete#getLigne()
	 */

	private int ligne;
	/**
	 * L'attribut "colonne" est un entier qui d�termine la colonne sur la quelle
	 * se trouve la b�te il est modifiable
	 * 
	 * @see Bete#setColonne(int)
	 * @see Bete#getColonne()
	 */

	private int colonne;
	/**
	 * L'attribut "attaque" (objet) est un ensemble de caract�ristique Les
	 * caract�ristiques d'attaque 
	 * Il ne sont pas modifiables
	 * 
	 * @see AttaqueCar#AttaqueCar()
	 */

	private AttaqueCar attaque;
	/**
	 * L'attribut "defense" (objet) est un ensemble de caract�ristique Les
	 * caract�ristiques de d�fense 
	 * 
	 * il ne sont pas modifiables
	 * 
	 * @see DefenseCar#DefenseCar()
	 */
	
	private DefenseCar defense;
	/**
	 * cet attribut repr�sente l'identifient de la b�te
	 */
	private int identifiant;
    
	/**
	 * Cet attribut repr�sente le nombre de fois que la b�te
	 * se sera battu
	 * 
	 * Il n'est pas modifiable
	 */
	private int nbCombat;
	
	/**
	 * Cet attribut repr�sente le nombre de fois que la b�te
	 * se sera reproduit
	 * 
	 * Il n'est pas modifiable
	 */
	private int nbReproduction;
	/**
	 * Le constructeur "Bete" initialise l'ensemble des caract�ristiques de la
	 * b�te Il attribut � la b�te une valeur �nerg�tique al�atoire Et d�termine de
	 * fa�on al�atoire le sexe de la b�te
	 * 
	 * @see Outil
	 */

	public Bete() {

		energie = Outil.choix(0,100);
		energieMax = energie;
		sexe = Outil.choix(0,2);
		attaque = new AttaqueCar();// construction des caract�ristiques
									// d'attaque
		defense = new DefenseCar();// construction des caract�ristiques
									// de d�fense
		identifiant = Outil.choix(1,2000);
	}

	/**
	 * Constructeur avec param�tre
	 * 
	 * Ce constructeur initialise les attributs en fonction d'une densit� donn�e
	 * par ces param�tres
	 * 
	 * @param energie
	 * @param pince
	 * @param venin
	 * @param machoir
	 * @param feu
	 * @param carapace
	 * @param bouclier
	 * @param epine
	 * @param antipoison
	 */

	public Bete(int energieMax, int pince, int venin, int machoir, int feu,
			int carapace, int bouclier, int epine, int antipoison) {

		this.energie = Outil.pourcentage(energieMax,55);
		this.energieMax = Outil.pourcentage(energieMax,55);
		this.sexe = Outil.choix(0,2);
		this.attaque = new AttaqueCar(pince, machoir, venin, feu);
		this.defense = new DefenseCar(carapace, epine, bouclier, antipoison);
		this.identifiant = Outil.choix(1,2000);;
	}

	/**
	 * Elle retourne l'objet "attaque"
	 */

	public AttaqueCar getAttaque() { // attaque
		return attaque;
	}

	/**
	 * Elle retourne l'objet "d�fense"
	 */

	public DefenseCar getDefense() { // d�fense
		return defense;
	}

	/**
	 * Elle retourne un attribut de la classe "B�te"
	 * 
	 * @return energie un attribut d�termin� par le constructeur
	 */
	public int getEnergie() { // energie
		return energie;
	}

	/**
	 * Elle permet de changer l'attribut "energie"
	 * 
	 * @param energie
	 *                indique de combien doit augmenter l'attribut "energie"
	 */
	public void setEnergie(int energie) {
		this.energie = this.energie + energie;
	}
	
	/**
	 * Elle permet de changer l'attribut "energie"
	 * Cette m�thode change "energie" 
	 * 
	 * @param energie
	 *                repr�sente la nouvelle valeur de l'attribut "energie"
	 */
	public void setEnergie1(int energie) {
		this.energie = energie;
	}

	/**
	 * Elle retourne un champ de caract�re qui est le sexe de la b�te
	 * 
	 * @return sex un champ de caract�re d�termin� par une valeur al�atoire
	 *         d�termin�e par "sexe"
	 * @see sexe
	 */
	public String getSexe() { // sex
		String sex;

		if (sexe == 1) {
			sex = "femelle";

		} else {
			sex = "male";
		}

		return sex;
	}

	/**
	 * Elle retourne un ensemble d'information concernant la b�te sous forme de
	 * champ de caract�re
	 */
	public String toString() {

		String sexe2 = getSexe();
		String string = attaque.toString();
		return "IDE "+identifiant+" cette b�te a comme caract�ristiques :�nergie=" + energie
				+ ", sexe=" + sexe2 + string
				+ defense.toString();
	}

	/**
	 * Elle retourne un attribut de la classe "B�te"
	 * 
	 * @return ligne, la ligne sur laquelle se trouve une b�te
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Elle permet de changer l'attribut "ligne" et "colonne" de la b�te
	 * 
	 * @param ligne
	 *                indique la nouvelle ligne sur laquelle se trouve la b�te
	 * @param colonne
	 *                indique la nouvelle colonne sur laquelle se trouve la b�te           
	 */
	public void setLigneColonne(int ligne, int colonne) {
		this.ligne = ligne;
		this.colonne = colonne;

	}

	/**
	 * Elle retourne un attribut de la classe "B�te"
	 * 
	 * @return colonne, la nouvelle colonne sur laquelle se trouve une b�te
	 */
	public int getColonne() {
		return colonne;
	}
    
	
	/**
	 * Elle retourne les informations  d'une b�te donn�e
	 * 
	 * @return un champ de caract�re, l'ensemble des informations de la b�te (sur l'interface graphique)
	 */
	public String toString1() {

		AttaqueCar at = getAttaque();
		DefenseCar def = getDefense();

		int ligne2 = getLigne();
		int colonne2 = getColonne();
		int energie2 = getEnergie();
		int pince = at.getPince();
		int machoir = at.getMachoir();
		int venin = at.getVenin();
		int feu = at.getFeu();
		int carapace = def.getCarapace();
		int bouclier = def.getBouclier();
		int antiPoison = def.getAntiPoison();
		
		return "IDE "+identifiant+" "+getSexe() + " (" + ligne2 + "*" + colonne2
				+ ") �nergie : " + energie2 + "\n Attaque: Pince * "
				+ pince + " M�choire * " + machoir
				+ "\n Venin * " + venin + " Feu * " + feu
				+ " D�fense: " + "Carapace * " + carapace
				+ " Bouclier * " + bouclier + " \n Anti-Poison * "
				+ antiPoison + "�pine * " + def.getEpine()+"\nCombat: "+getNbCombat()
				+" Reproduction "+getNbReproduction();
	}
    
	/**
	 * Elle retourne un attribut de la classe "B�te"
	 * 
	 * @return energieMax, l��nergie maximale de la b�te
	 */
	public int getEnergieMax() {
		return energieMax;
	}
    
	/**
	 * Elle retourne l'identifient de chaque b�te
	 * 
	 * @return un identifient diff�rent pour chaque b�te
	 */
	public int getIdentifiant() {
		return identifiant;
	}
    
	/**
	 * Elle retourne une valeur enti�re correspondant au nombre de fois 
	 * que la b�te s'est battue
	 */
	public int getNbCombat() {
		return nbCombat;
	}
    
	/**
	 * Elle permet de mettre � jour "nbCombat"
	 * 
	 * @param nbCombat
	 *                pour rajouter "this.nbCombat"
	 */
	public void setNbCombat(int nbCombat) {
		this.nbCombat = this.nbCombat+nbCombat;
	}
    
	/**
	 * Elle retourne une valeur enti�re correspondant au nombre de fois 
	 * que la b�te s'est reproduit
	 */
	public int getNbReproduction() {
		return nbReproduction;
	}
    
	/**
	 * Elle permet de mettre � jour "nbReproduction"
	 * 
	 * @param nbCombat
	 *                pour rajouter "this.nbReproduction"
	 */
	public void setNbReproduction(int nbReproduction) {
		this.nbReproduction = this.nbReproduction+nbReproduction;
	}
	
	
    
}
