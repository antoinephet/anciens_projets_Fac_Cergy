package visiteurs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import donnees.EspaceDepot;
import log.LoggerUtility;
import modele.Case;
import modele.Gardien;
import modele.Grille;
import modele.Intrus;
import modele.Obstacle;

public class VisiteurDeplacement implements Visiteur {
	private static Logger logger = LoggerUtility.getLogger(VisiteurDeplacement.class);

	Grille grille = eDepot.getGrille();

	public VisiteurDeplacement() {
		super();
	}

	public void deplacer() {
		char tmp;

		ArrayList<Gardien> gardiens = new ArrayList<Gardien>();
		gardiens.addAll(eDepot.getGardiens());

		for (Gardien gardien : gardiens) {
			mouvementAleatoireGardien(gardien);
		}

		ArrayList<Intrus> intrus = eDepot.getIntrus();
		intrus.addAll(eDepot.getIntrus());

		for (Intrus intruss : intrus) {
			mouvementAleatoireIntrus(intruss);
		}

	}

	private void mouvementAleatoireIntrus(Intrus intruss) {

		int cmpt = nombreAleatoire(1, 4);

		switch (cmpt) {

		case 1://déplacement vers le haut
			if (grille.getNbLigne() >= intruss.getY() - 1 && 0 <= intruss.getY() - 1){
				if(positionTraversable(intruss.getX() ,intruss.getY() - 1) == true){
				intruss.setY(intruss.getY() - 1);
			logger.info("intruss positionné à ( "+intruss.getX()+" ; "+intruss.getY()+" )"); 
				}}
			break;

		case 2:// vers le bas 
			if (grille.getNbLigne() >= intruss.getY() + 1 && 0 <= intruss.getY() + 1){
				if(positionTraversable(intruss.getX() ,intruss.getY() + 1) == true){
				intruss.setY(intruss.getY() + 1);
			logger.info("intruss positionné à ( "+intruss.getX()+" ; "+intruss.getY()+" )"); 
				}}
			break;

		case 3:// vers la droite 
			if (grille.getNbColonne() >= intruss.getX() + 1 && 0 <= intruss.getX() + 1){
				if(positionTraversable(intruss.getX()+1 ,intruss.getY()) == true){
				intruss.setX(intruss.getX() + 1);
			logger.info("intruss positionné à ( "+intruss.getX()+" ; "+intruss.getY()+" )"); 
				}}
			break;

		case 4://vers la gauche
			if (grille.getNbColonne() >= intruss.getX() - 1 && 0 <= intruss.getX() - 1){
				if(positionTraversable(intruss.getX()-1 ,intruss.getY() ) == true){
				intruss.setX(intruss.getX() - 1);
			logger.info("intruss positionné à ( "+intruss.getX()+" ; "+intruss.getY()+" )"); 
					}
			}
			break;

		}

	}

	private boolean positionTraversable(int x, int y) {
		Case uneCase = eDepot.rechercherCase(x, y);
		if (uneCase == null) {
			return false;
		}
		return uneCase.isTraversabiliteObstacle();
	}

	private void mouvementAleatoireGardien(Gardien gardien) {

		// (int)(Math.random()*4+1);

		int cmpt = nombreAleatoire(1, 4);

		switch (cmpt) {

		case 1: // déplacement vers le haut
			if (grille.getNbLigne() >= gardien.getY() - 1 && 0 <= gardien.getY() - 1){
				if(positionTraversable(gardien.getX() ,gardien.getY() - 1) == true){
					gardien.setY(gardien.getY() - 1);
				}
			}
			break;

		case 2: // déplacement vers le bas
			if (grille.getNbLigne() >= gardien.getY() + 1 && 0 <= gardien.getY() + 1){
				
				if(positionTraversable(gardien.getX() ,gardien.getY() + 1) == true){
				gardien.setY(gardien.getY() + 1);
				}
			}
			break;

		case 3: // déplacement vers la droite
			if (grille.getNbColonne() >= gardien.getX() + 1 && 0 <= gardien.getX() + 1){
				if(positionTraversable(gardien.getX()+1 ,gardien.getY()) == true){
				gardien.setX(gardien.getX() + 1);
				}
			}
			break;

		case 4: // déplacement vers la gauche
			if (grille.getNbColonne() >= gardien.getX() - 1 && 0 <= gardien.getX() - 1){
				if(positionTraversable(gardien.getX()-1 ,gardien.getY() ) == true){
				gardien.setX(gardien.getX() - 1);
				}
			}
			break;

		}
	}

	/*
	 * génère un nombre aléatoire entre deux valeurs
	 * 
	 * @param min ma valeur minimale.
	 * 
	 * @param max ma valeur maximale.
	 * 
	 * @return nombre nombre aléatoire compris entre min et max
	 */
	public int nombreAleatoire(int min, int max) {
		return (int) ((Math.random() * (max + 1 - min)) + min);
	}

	@Override
	public void visite(Grille g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visite(Gardien g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visite(Intrus i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visite(Obstacle obstacle) {
		// TODO Auto-generated method stub

	}
}