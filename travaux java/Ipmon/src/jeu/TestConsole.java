package jeu;

public class TestConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("****************Début de jeu****************");
		System.out.println("****************IPMON****************");
		System.out.println("");
		
		System.out.println("Bienvenue dans le jeu!!");
		System.out.println("But du jeu :\n\nLes joueurs doivent attraper les IPMONS");
		System.out.println("\n\n");
		System.out.println("Bonne partie!!");
		System.out.println("\n\n");
		
		Grille g = new Grille(0,0);
		
		
		g.chargerFichier();
		
		System.out.println("\n\n");
		System.out.println("Affichage...");
		System.out.println("\n\n");
		System.out.println("Le joueur est représenté par J");
		System.out.println("Et les IPMONS sont représentés par I");
		System.out.println("Les arbres = A");
		
		System.out.println("\n\n");
		
		g.affichage();
		
		System.out.println("\n\n");
		System.out.println("Test des mouvements manuels des gardiens et des intrus...");
		System.out.println("\n\n");
		
		g.deplacementManuel();
		
		
		
		System.out.println("\n\n");
		System.out.println("Test des mouvements alï¿½atoire des gardiens et des intrus...");
		System.out.println("\n\n");

	}

}
