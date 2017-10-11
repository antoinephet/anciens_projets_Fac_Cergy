package data;

import outils.Outil;

/**
 * Cette classe definit les caract�ristiques de d�fense
 * @author Irhad et Keita
 */

public class DefenseCar {
	/**
	 *L'attribut "carapace" est un entier qui d�termine cette capacit�
	 * cet Attribut est modifiable 
	 * 
	 * @see DefenseCar#setCarapace(int)
	 * @see DefenseCar#getCarapace()
	 */
	private int carapace;
	/**
	 *L'attribut "epine" est un entier qui d�termine cette capacit�
	 * il est modifiable 
	 * 
	 * @see DefenseCar#setEpine(int)
	 * @see DefenseCar#getEpine()
	 */
	private int epine;
	/**
	 *L'attribut "bouclier" est un entier qui d�termine cette capacit�
	 * il est modifiable 
	 * 
	 * @see DefenseCar#setBouclier(int)
	 * @see DefenseCar#getBouclier()
	 */
	private int bouclier;
	/**
	 *L'attribut "antipoison" est un entier qui d�termine cette capacit�
	 * il est modifiable 
	 * 
	 * @see DefenseCar#setAntiPoison(int)
	 * @see DefenseCar#getAntiPoison()
	 */
	private int antiPoison;
   
	/**
	 * Le constructeur "DefenseCar" initialise les caract�ristiques de fa�on al�atoir
	 * il ne prends pas de param�tre
	 * 
	 * @see Outil
	 */
	public DefenseCar() { // caract�ristiques de d�fense

		carapace = Outil.choix(0,100); // cette fonction donne un nombre
		                                // al�atoire compris entre 0 et 99
		epine = Outil.choix(0,100);
		bouclier = Outil.choix(0,100);
		antiPoison = Outil.choix(0,100);
	}
	
	/**
	 * Constructeur avec param�tre
	 * 
	 * Il initialise les attributs en fonction d'une densit� donn�e par ces parametres
	 * 
	 * @param carapace
	 * @param epine
	 * @param bouclier
	 * @param antipoison
	 */
	
	public DefenseCar(int carapace,int epine,int bouclier,int antipoison){
	
		this.carapace= (carapace*75)/100;
		this.epine= (epine*75)/100;
		this.bouclier= (bouclier*75)/100;
		this.antiPoison= (antipoison*75)/100;
	}
	
	/**
     * Elle retourne un attribut de la classe "DefenseCar"
     * 
     * @return carapace un attribut determin� par le constructeur
     */

	public int getCarapace() { 
		return carapace;
	}
	
	/**
     * Elle permet de changer l'attribut "carapace"
     * 
     * @param carapace  
     *                 indique de combien doit augmenter l'attribut "carapace"
     */

	public void setCarapace(int carapace) {
		this.carapace = this.carapace+carapace;
	}
	/**
     * Elle retourne un attribut de la classe "DefenseCar"
     * 
     * @return epine un attribut d�termine par le constructeur
     */

	public int getEpine() { // �pines
		return epine;
	}
	
	/**
     * Elle permet de changer l'attribut "epine"
     * 
     * @param epine  
     *              indique de combien doit augmenter l'attribut "epine"
     */

	public void setEpine(int epine) {
		this.epine = this.epine+epine;
	}
	
	/**
     * Elle retourne un attribut de la classe "DefenseCar"
     * 
     * @return immunite un attribut d�termin� par le constructeur
     */

	public int getBouclier() { // immunit�
		return bouclier;
	}
    
	/**
     * Elle permet de changer l'attribut "immunite"
     * 
     * @param immunite  
     *                 indique de combient doit augmenter l'attribut "immunite"
     */
	public void setBouclier(int bouclier) {
		this.bouclier = this.bouclier+bouclier;
	}
	
	/**
     * Elle retourne un attribut de  la classe "DefenseCar"
     * 
     * @return antipoison un attribut d�termin� par le constructeur
     */
	public int getAntiPoison() { // poison
		return antiPoison;
	}
	
	/**
     * Elle permet de changer l'attribut "antiPoison"
     * 
     * @param antiPoison  
     *                   indique de combien doit augmenter l'attribut "antiPoison"
     */

	public void setAntiPoison(int antiPoison) {
		this.antiPoison = this.antiPoison+antiPoison;
	}
	
	/**
     * Elle retourne tous les attributs de la classe "AttaqueCar"
     * 
     * @return l'ensemble des attributs de defenseCar sous forme d'une cha�ne de caract�re
     */

	public String toString() {
		return " les caract�ristiques de d�fense de la b�te sont : antipoison="
				+ antiPoison + ", carapace=" + carapace + ", �pine=" + epine
				+ ", bouclier=" + bouclier;
	}

}
