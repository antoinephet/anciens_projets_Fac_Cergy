package visiteurs;

import modele.Arbre;
import modele.Eau;
import modele.Gardien;
import modele.Grille;
import modele.Intrus;
import modele.Mur;
import modele.Obstacle;

public class VisiteurDessinerElements implements Visiteur {

	@Override
	public void visite(Grille g) {
		String entete = "";

		System.out.print("   ");

		for (int j = 0; j <= g.getNbLigne(); j++) {
			entete = String.valueOf(j);
			entete = rendreEntetesAQuatreCaracteres(entete);
			System.out.print(entete);
		}
		
		System.out.print("\n");
		entete = "";
		
		for (int i = 0; i <= g.getNbColonne(); i++) {
			entete = String.valueOf(i);
			entete = rendreEntetesAQuatreCaracteres(entete);
			System.out.print(entete);
			System.out.print("|");
			for (int j = 0; j <= g.getNbLigne(); j++) {
				if (eDepot.rechercherGardien(i, j) != null )  {
					System.out.print(" G |");
				}
				else if(eDepot.rechercherIntrus(i, j) != null) {
					System.out.print(" I |");
				}
				else if(eDepot.rechercherObstacle(i, j) instanceof Arbre) {
					System.out.print(" A |");
				}
				else if(eDepot.rechercherObstacle(i, j) instanceof Mur) {
					System.out.print(" M |");
				}
				else if(eDepot.rechercherObstacle(i, j) instanceof Eau) {
					System.out.print(" E |");
				}
				
				else {
					System.out.print(" - |");
				}
			}
			System.out.println();
		}
	}

	@Override
	public void visite(Gardien g) {
	}
	
	
	private String rendreEntetesAQuatreCaracteres(String entete) {
		if (entete.length() == 1) {
			return "   " + entete;

		} else {
			if (entete.length() == 2) {
				return "  " + entete;
			} else {
				if (entete.length() == 3) {
					return " " + entete;
				}

			}

		}
		return entete;
	}

	@Override
	public void visite(Intrus i) {
		
	}

	@Override
	public void visite(Obstacle obstacle) {
		
	}

}
