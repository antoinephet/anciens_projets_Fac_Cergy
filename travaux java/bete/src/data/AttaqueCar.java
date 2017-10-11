package data;

import outils.Outil;

/**
 * Cette classe définit les caractéristiques d'attaque
 * @author Irhad et Keita
 */

public class AttaqueCar {
	/**
	 * L'attribut "pince" est un entier qui détermine cette capacité
	 * il est modifiable 
	 * 
	 * @see AttaqueCar#setPince(int) 
	 * @see AttaqueCar#getPince()
	 */
	private int pince;
	/**
	 *L'attribut "machoir" est un entier qui détermine cette capacité
	 * il est modifiable
	 * 
	 * @see AttaqueCar#setMachoir(int)
	 * @see AttaqueCar#getMachoir()
	 */
	private int machoir;
	/**
	 *L'attribut "venin" est un entier qui détermine cette capacité
	 * il est modifiable
	 * 
	 * @see AttaqueCar#setVenin(int)
	 * @see AttaqueCar#getVenin()
	 */
	private int venin;
	/**
	 *L'attribut "feu" est un entier qui détermine cette capacité
	 * il est modifiable
	 * 
	 * @see AttaqueCar#setFeu(int)  
	 * @see AttaqueCar#getFeu()
	 */
	private int feu;
	
	
	/**
	 * Le constructeur "AttaqueCar" initialise les caractéristiques de façon aléatoir
	 * il ne prends pas de paramètre
	 * 
	 * @see Outil
	 */
	public AttaqueCar() {
      
		pince = Outil.choix(0,100);
		machoir = Outil.choix(0,100);
		venin = Outil.choix(0,100);
		feu = Outil.choix(0,100);
	}
	
	/**
	 * Constructeur avec parametre
	 * 
	 * Il initilise les attributs en fonction d'une densité donnée par ces parametres
	 * 
	 * @param pince 
	 * @param machoir
	 * @param venin
	 * @param feu
	 */
	
   public AttaqueCar(int pince,int machoir, int venin,int feu){
	   
	    this.pince = (pince*75)/100;
		this.machoir = (machoir*75)/100;
		this.venin = (venin*75)/100;
		this.feu = (feu*75)/100;
   }
    /**
     * Elle retourne un attribut de la classe "AttaqueCar"
     * 
     * @return pince un attribut determiné par le constructeur
     */
	public int getPince() {
		return pince;
	}
	
	/**
     * Elle permet de changer l'attribut "pince" 
     * 
     * @param pince  
     *              indique de combient doit augmenter l'attribut "pince"
     */

	public void setPince(int pince) {
		this.pince = this.pince+pince;
	}
	/**
     * Elle retourne un attribut de "AttaqueCar"
     * 
     * @return machoir est un attribut déterminé par le constructeur
     */

	public int getMachoir() {
		return machoir;
	}
	/**
     * Elle permet de changer l'attribut "machoir"
     * 
     * @param machoir  
     *                indique de combient doit augmenter l'attribut "machoir"
     */

	public void setMachoir(int machoir) {
		this.machoir = this.machoir+machoir;
	}
	
	/**
     * Elle retourne un attribut de "AttaqueCar"
     * 
     * @return venin est un attribut déterminé par le constructeur
     */

	public int getVenin() {
		return venin;
	}
	
	/**
     * Elle permet de changer l'attribut "venin"
     * 
     * @param venin  
     *                indique de combien doit augmenter l'attribut "venin"
     */

	public void setVenin(int venin) {
		this.venin = venin;
	}
	
	/**
     * Elle retourne un attribut de "AttaqueCar"
     * 
     * @return feu est un attribut déterminé par le constructeur
     */

	public int getFeu() { 
		return feu;
	}
	
	/**
     * Elle permet de changer l'attribut "feu"
     * 
     * @param feu  
     *                indique de combien doit augmenter l'attribut "feu"
     */

	public void setFeu(int feu) {
		this.feu = feu;
	}
	
	/**
     * Elle retourne toutes les attributs de "AttaqueCar"
     * 
     * @return l'ensemble des attributs de AttaqueCar sous forme d'une chaîne de caractère
     */

	public String toString() {
		return " les caractéristiques d'attaque de la bête sont : feu=" + feu
				+ ", machoir=" + machoir + ", pince=" + pince + ", venin="
				+ venin;
	}

}
