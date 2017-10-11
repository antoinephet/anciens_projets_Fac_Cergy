package data;

import java.awt.Graphics;

import java.awt.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.omg.PortableInterceptor.INACTIVE;

import engine.Evenement;
import engine.MilieuCar;
import exceptions.InformationException;
import exceptions.PlacerException;

import outils.Outil;

/**
 * Cette classe permet de construire une grille (matrice "de Case")
 * 
 * @author Irhad et Keita
 * 
 */
public class Grille {

	/**
	 * l'attribut "nbBete" d�termine le nombre de b�te dans la grille
	 * 
	 * Il est modifiable
	 * 
	 * @see Grille#getNbBete()
	 * @see Grille#setNbBete()
	 * 
	 * @see Evenement#getNbBete()
	 * @see Evenement#setNbBete(int)
	 */

	private int nbBete;

	/**
	 * l'attribut "nbCase" d�termine le nombre de ligne de la grille
	 * 
	 * Il n'est pas modifiable
	 */
	private int nbCase;

	/**
	 * Cette attribut est un objet; la classe "Evenement" renferme tous les
	 * algorithmes de la classe grille
	 * 
	 * @see Evenement
	 */
	private Evenement evenement;

	/**
	 * constructeur, initialise la grille; rajoute les b�tes et dessine la
	 * grille
	 * 
	 * @param nbBete
	 *            le nombre de b�te a mettre dans la grille, au d�part
	 * 
	 * @param nbCase
	 *            le nombre de ligne de la grille
	 * 
	 * @see Grille#nbBete
	 * @see Grille#nbCase
	 */
	public Grille(int nbBete, int nbCase) throws PlacerException {

		if (nbCase<=12 && nbBete > 0 && nbCase > 0 && nbBete <= ((nbCase * nbCase) * 75) / 100) {
			this.nbBete = nbBete;
			this.nbCase = nbCase;

			evenement = new Evenement(this.nbCase, this.nbBete);

			evenement.ajoutBeteNourriture();
		} else {
			throw new PlacerException(((nbCase * nbCase) * 75) / 100);
		}

	}

	/**
	 * Elle permet de deplacer les b�tes dans la grille en tenant compte de
	 * leurs positions initiale
	 * 
	 * @see Evenement#deplacement()
	 */
	public void deplacement() {

		evenement.deplacement();

	}

	/**
	 * Elle permet de recuperer le nombre de b�te dans une case donn�e
	 * 
	 * @param lg
	 *            Ligne sur la quelle se trouve la case
	 * @param cl
	 *            colonne sur la quelle se trouve la case
	 * 
	 * @return le nombre de b�te pr�sente dans la case
	 * 
	 * @see Case#isOccupe()
	 */
	public int nbBeteCase(int lg, int cl) {

		Case case1 = evenement.getCase(lg, cl);
		return case1.isOccupe();
	}

	/**
	 * Elle retourne le nombre de b�te dans la grille
	 * 
	 * @return Elle r�cup�re cette valeur dans la classe "Evenement"
	 * 
	 * @see Evenement#getNbBete()
	 */
	public String getNbBete() {

		return evenement.getNbBete();
	}

	/**
	 * Elle met � jour le nombre de b�te pr�sente dans la grille
	 * 
	 * @see Evenement#getNbBete()
	 */
	public void setNbBete() {

		String nbBete2 = evenement.getNbBete();
		this.nbBete = Integer.valueOf(nbBete2);
	}

	/**
	 * Elle retourne le nombre de b�te M�le dans la grille
	 * 
	 * @return Elle r�cup�re cette valeur dans la classe "Evenement"
	 * 
	 * @see Evenement#getNbBeteMale()
	 */
	public String getNbBeteMale() {

		return evenement.getNbBeteMale();

	}

	/**
	 * Elle retourne le nombre de b�te femelle dans la grille
	 * 
	 * @return Elle r�cup�re cette valeur dans la classe "Evenement"
	 * 
	 * @see Evenement#getNbBeteFemelle()
	 */
	public String getNbBeteFemelle() {

		return evenement.getNbBeteFemelle();

	}

	/**
	 * Elle retourne le nombre de nourriture dans la grille
	 * 
	 * @return Elle r�cup�re cette valeur dans la classe "Evenement"
	 * 
	 * @see Evenement#getNbNourriture()
	 */
	public String getNbNourriture() {

		return evenement.getNbNourriture();

	}

	/**
	 * Elle retourne les informations concernant une b�te; �nergie, sexe,
	 * caract�ristiques
	 * 
	 * @param i
	 *            Ligne sur laquelle se trouve la b�te
	 * @param j
	 *            Colonne sur laquelle se trouve la b�te
	 * 
	 * @return un champ de caract�re
	 * 
	 * @see Evenement#getInfoBete(int, int)
	 */
	public String getInfoBete(int i, int j) throws InformationException {

		if ((i >= 0 && i < nbCase) && (j >= 0 && j < nbCase)) {
			
			return evenement.getInfoBete(i, j);
			
		}else{
			throw new InformationException(0,nbCase-1);
		}

	}

	/**
	 * Elle retourne un objet, l'objet de cette classe et de definir les
	 * caract�ristiques des diff�rentes parties de la grille
	 * 
	 * @return un objet de type MilieuCar�, elle r�cup�re cette objet dans la
	 *         classe "Evenement"
	 * 
	 * @see MilieuCar
	 * @see Evenement#getMilieuCar()
	 */
	public MilieuCar getMilieuCar() {

		return evenement.getMilieuCar();
	}

	/**
	 * Elle permet de r�cup�rer une case d'une matrice de type "Case"
	 * 
	 * @param i
	 *            ligne de la matrice
	 * @param j
	 *            Colonne de la matrice
	 * 
	 * @return un objet de type "case", elle r�cup�re cette case dans la classe
	 *         "Evenement"
	 * 
	 * @see Evenement#getCase(int, int)
	 */
	public Case getCase(int i, int j) {

		return evenement.getCase(i, j);
	}

	/**
	 * Elle retourne une ligne de la grille
	 */
	public int getInfoLigne() {
		return evenement.getInfoligne();
	}

	/**
	 * Elle retourne une colonne de la grille
	 */
	public int getInfoColonne() {
		return evenement.getInfoColonne();
	}

	public int getIdentifient() {
		return evenement.getIdentifient();
	}
}