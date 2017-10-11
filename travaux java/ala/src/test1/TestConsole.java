package test1;



public class TestConsole {


	public static void main(String[] args) {
		
		System.out.println("****************D�but de jeu****************");
		System.out.println("****************Gardien de parc****************");
		System.out.println("");
		
		Grille g = new Grille(0,0);
		
		g.chargementFichierConsole();
		
		g.affichage();
		
		System.out.println("\n\n");
		System.out.println("Affichage...");
		System.out.println("\n\n");
		System.out.println("Les gardiens sont repr�sent�s par G,S,C et P");
		System.out.println("Et les Intrus sont repr�sent�s par I,R et D");
		System.out.println("Les murs = M; Les arbres = A; l'eau = E");
		
		System.out.println("\n\n");
		
		g.affichage();
		
		System.out.println("\n\n");
		System.out.println("Test des mouvements manuels des gardiens et des intrus...");
		System.out.println("\n\n");
		
		g.deplacementManuel();
		
		
		System.out.println("\n\n");
		System.out.println("Test des mouvements al�atoire des gardiens et des intrus...");
		System.out.println("\n\n");
		
		g.deplacerAleatoire();
	}

}
