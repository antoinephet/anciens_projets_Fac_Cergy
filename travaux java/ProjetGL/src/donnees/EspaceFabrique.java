package donnees;

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

public class EspaceFabrique {
	EspaceDepot eDepot = EspaceDepot.getInstance();
	private static Logger logger = LoggerUtility.getLogger(EspaceFabrique.class);

	public EspaceFabrique() {
	}

	public void creerGrille(int lig, int col) {
		for (int i = 0; i < lig; i++) {
			for (int j = 0; j < col; j++) {
				Case uneCase = new Case(i, j);
				eDepot.enregistrerCase(uneCase);
				logger.info("case enregistrée à ( "+uneCase.getX()+" ; "+uneCase.getY()+" )"); 
			}
		}

		eDepot.enregisterGrille(new Grille(lig, col));
	}

	private void enregisterGrille(Grille grille) {
	}

	public Gardien creerGardien() {
		return new Gardien();
	}

	public void creerPlusieursGardiens(int nbGardiens) {
		for (int i = 1; i <= nbGardiens; i++) {
			eDepot.enregistrerGardien(creerGardien());
			System.out.println("Gardien crÃ©e : " + i);
		}
	}

	public Intrus creerIntrus() {
		return new Intrus();
	}

	public void creerPlusieursIntrus(int nbIntrus) {
		for (int i = 1; i <= nbIntrus; i++) {
			eDepot.enregistrerIntrus(creerIntrus());
			System.out.println("Intrus crÃ©e : " + i);
		}
	}

	// creation de l'arbre

	public Obstacle creerObstacle(String typeObstacle) {
		Obstacle obstacle;
		if (typeObstacle == "eau") {
			return obstacle = new Eau();
		} else if (typeObstacle == "mur") {
			return obstacle = new Mur();
		} else {
			return obstacle = new Arbre();
		}
	}

	public void creerPlusieursObstacles(int densiteObstacles) {
		for (int i = 1; i <= densiteObstacles; i++) {
			eDepot.enregistrerObstacle(creerObstacle("eau"));
			eDepot.enregistrerObstacle(creerObstacle("mur"));
			eDepot.enregistrerObstacle(creerObstacle("arbre"));
			System.out.println("Obstacle crÃ©e : " + i);
		}
	}

}
