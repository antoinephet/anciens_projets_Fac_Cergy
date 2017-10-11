package donnees;


import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import visiteurs.VisiteurPlacerAleatoirement;
import log.LoggerUtility;
import modele.Arbre;
import modele.Case;
import modele.Eau;
import modele.Gardien;
import modele.Grille;
import modele.Intrus;
import modele.Mur;
import modele.Obstacle;

public class EspaceDepot {
	private static Logger logger = LoggerUtility.getLogger(EspaceDepot.class);

	public static EspaceDepot instance = new EspaceDepot();
	private ArrayList<Gardien> gardiens = new ArrayList<Gardien>();
	private ArrayList<Intrus> intrus = new ArrayList<Intrus>();
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	private Grille grille;
	private int nbCaseMax = 1000 ;
	private Case[][] cas = new Case[nbCaseMax][nbCaseMax] ;
	public int caseCourant = 0 ; 	

	
	private EspaceDepot() {
	}
	public static EspaceDepot getInstance() {
		return instance;
	}
	
	public ArrayList<Gardien> getGardiens() {
		return gardiens;
	}
	
	public void enregistrerGardien(Gardien g) {
		gardiens.add(g);
	}
	/** Recherche un Gardien sur la Grille à la position x et y 
	 * @param x la ligne de la grille
	 * @param y la colonne de la grille
	 * @return null ou le gardien si il est positionné à l'endroit recherché
	 */
	public Gardien rechercherGardien(int x, int y) {
		for (Iterator<Gardien> it = gardiens.iterator(); it.hasNext();) {
			Gardien g = it.next();
			if(g.getX()==x && g.getY()==y){
				return g ;
			}
		}
		return null;
	}

	public ArrayList<Intrus> getIntrus() {
		return intrus;
	}
	public void enregistrerIntrus(Intrus i) {
		intrus.add(i);
		
	}

	public Intrus rechercherIntrus(int x, int y) {
		for (Iterator<Intrus> it = intrus.iterator(); it.hasNext();) {
			Intrus g = it.next();
			if(g.getX()==x && g.getY()==y){
				return g ;
			}
		}
		return null;
	}
	
	public void enregistrerCase(Case cases) {
			cas[cases.getX()][cases.getY()] = cases;
	}
	
	public Case rechercherCase(int x , int y ){
		logger.info("REcherche de case � "+x+" ; "+y);
		return cas[x][y];
	}


	public void enregisterGrille(Grille grille) {
		this.grille = grille;
	}

	public Grille getGrille() {
		return grille ;
	}
	
	//ajout sur la grille l'obstacle arbre
	
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	
	public void enregistrerObstacle(Obstacle obstacle) {
		obstacles.add(obstacle);
	}
	
	public Obstacle rechercherObstacle(int x, int y) {
		for (Iterator<Obstacle> it = obstacles.iterator(); it.hasNext();) {
			Obstacle Obstacle = it.next();
			if(Obstacle.getX()==x && Obstacle.getY()==y){
				return Obstacle ;
			}
		}
		return null;
	}
	public Case rechercherCase(Case debut) {
		// TODO Auto-generated method stub
		return null;
	}

}
