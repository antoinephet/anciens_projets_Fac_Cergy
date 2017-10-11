package data;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import outils.Outil;

import data.AttaqueCar;

/**
 * Cette classe definit une bête
 * 
 * @author Irhad et Keita
 */
public class Bete {

	/**
	 * L'attribut "energie" est un entier qui détermine l’énergie de la bête il
	 * est modifiable
	 * 
	 * @see Bete#setEnergie(int)
	 * @see Bete#getEnergie()
	 */
	private int energie;

	/**
	 * L'attribut "sexe" est un entier qui détermine le sexe de la bête "0"
	 * c'est une femelle, "1" c'est un mâle il n'est pas modifiable
	 * 
	 * @see Bete#getEnergie()
	 */
	private int sexe; // 0 c'est un mâle, 1 c'est une femelle

	/**
	 * L'attribut "energieMax" est un entier qui détermine l’énergie maximal de
	 * la bête il n'est pas modifiable
	 * 
	 * @see Bete#getEnergie()
	 */
	private int energieMax;

	/**
	 * L'attribut "ligne" est un entier qui détermine la ligne sur la quelle se
	 * trouve la bête
	 * 
	 * il est modifiable
	 * 
	 * @see Bete#setLigne(int)
	 * @see Bete#getLigne()
	 */

	private int ligne;
	/**
	 * L'attribut "colonne" est un entier qui détermine la colonne sur la quelle
	 * se trouve la bête il est modifiable
	 * 
	 * @see Bete#setColonne(int)
	 * @see Bete#getColonne()
	 */

	private int colonne;
	/**
	 * L'attribut "attaque" (objet) est un ensemble de caractéristique Les
	 * caractéristiques d'attaque 
	 * Il ne sont pas modifiables
	 * 
	 * @see AttaqueCar#AttaqueCar()
	 */

	private AttaqueCar attaque;
	/**
	 * L'attribut "defense" (objet) est un ensemble de caractéristique Les
	 * caractéristiques de défense 
	 * 
	 * il ne sont pas modifiables
	 * 
	 * @see DefenseCar#DefenseCar()
	 */
	
	private DefenseCar defense;
	/**
	 * cet attribut représente l'identifient de la bête
	 */
	private int identifiant;
    
	/**
	 * Cet attribut représente le nombre de fois que la bête
	 * se sera battu
	 * 
	 * Il n'est pas modifiable
	 */
	private int nbCombat;
	
	/**
	 * Cet attribut représente le nombre de fois que la bête
	 * se sera reproduit
	 * 
	 * Il n'est pas modifiable
	 */
	private int nbReproduction;
	/**
	 * Le constructeur "Bete" initialise l'ensemble des caractéristiques de la
	 * bête Il attribut à la bête une valeur énergétique aléatoire Et détermine de
	 * façon aléatoire le sexe de la bête
	 * 
	 * @see Outil
	 */

	public Bete() {

		energie = Outil.choix(0,100);
		energieMax = energie;
		sexe = Outil.choix(0,2);
		attaque = new AttaqueCar();// construction des caractéristiques
									// d'attaque
		defense = new DefenseCar();// construction des caractéristiques
									// de défense
		identifiant = Outil.choix(1,2000);
	}

	/**
	 * Constructeur avec paramètre
	 * 
	 * Ce constructeur initialise les attributs en fonction d'une densité donnée
	 * par ces paramètres
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
	 * Elle retourne l'objet "défense"
	 */

	public DefenseCar getDefense() { // défense
		return defense;
	}

	/**
	 * Elle retourne un attribut de la classe "Bête"
	 * 
	 * @return energie un attribut déterminé par le constructeur
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
	 * Cette méthode change "energie" 
	 * 
	 * @param energie
	 *                représente la nouvelle valeur de l'attribut "energie"
	 */
	public void setEnergie1(int energie) {
		this.energie = energie;
	}

	/**
	 * Elle retourne un champ de caractère qui est le sexe de la bête
	 * 
	 * @return sex un champ de caractère déterminé par une valeur aléatoire
	 *         déterminée par "sexe"
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
	 * Elle retourne un ensemble d'information concernant la bête sous forme de
	 * champ de caractère
	 */
	public String toString() {

		String sexe2 = getSexe();
		String string = attaque.toString();
		return "IDE "+identifiant+" cette bête a comme caractéristiques :énergie=" + energie
				+ ", sexe=" + sexe2 + string
				+ defense.toString();
	}

	/**
	 * Elle retourne un attribut de la classe "Bête"
	 * 
	 * @return ligne, la ligne sur laquelle se trouve une bête
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Elle permet de changer l'attribut "ligne" et "colonne" de la bête
	 * 
	 * @param ligne
	 *                indique la nouvelle ligne sur laquelle se trouve la bête
	 * @param colonne
	 *                indique la nouvelle colonne sur laquelle se trouve la bête           
	 */
	public void setLigneColonne(int ligne, int colonne) {
		this.ligne = ligne;
		this.colonne = colonne;

	}

	/**
	 * Elle retourne un attribut de la classe "Bête"
	 * 
	 * @return colonne, la nouvelle colonne sur laquelle se trouve une bête
	 */
	public int getColonne() {
		return colonne;
	}
    
	
	/**
	 * Elle retourne les informations  d'une bête donnée
	 * 
	 * @return un champ de caractère, l'ensemble des informations de la bête (sur l'interface graphique)
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
				+ ") Énergie : " + energie2 + "\n Attaque: Pince * "
				+ pince + " Mâchoire * " + machoir
				+ "\n Venin * " + venin + " Feu * " + feu
				+ " Défense: " + "Carapace * " + carapace
				+ " Bouclier * " + bouclier + " \n Anti-Poison * "
				+ antiPoison + "Épine * " + def.getEpine()+"\nCombat: "+getNbCombat()
				+" Reproduction "+getNbReproduction();
	}
    
	/**
	 * Elle retourne un attribut de la classe "Bête"
	 * 
	 * @return energieMax, l’énergie maximale de la bête
	 */
	public int getEnergieMax() {
		return energieMax;
	}
    
	/**
	 * Elle retourne l'identifient de chaque bête
	 * 
	 * @return un identifient diffèrent pour chaque bête
	 */
	public int getIdentifiant() {
		return identifiant;
	}
    
	/**
	 * Elle retourne une valeur entière correspondant au nombre de fois 
	 * que la bête s'est battue
	 */
	public int getNbCombat() {
		return nbCombat;
	}
    
	/**
	 * Elle permet de mettre à jour "nbCombat"
	 * 
	 * @param nbCombat
	 *                pour rajouter "this.nbCombat"
	 */
	public void setNbCombat(int nbCombat) {
		this.nbCombat = this.nbCombat+nbCombat;
	}
    
	/**
	 * Elle retourne une valeur entière correspondant au nombre de fois 
	 * que la bête s'est reproduit
	 */
	public int getNbReproduction() {
		return nbReproduction;
	}
    
	/**
	 * Elle permet de mettre à jour "nbReproduction"
	 * 
	 * @param nbCombat
	 *                pour rajouter "this.nbReproduction"
	 */
	public void setNbReproduction(int nbReproduction) {
		this.nbReproduction = this.nbReproduction+nbReproduction;
	}
	
	
    
}
