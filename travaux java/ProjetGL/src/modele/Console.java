package modele;

import java.util.Scanner;

import log.LoggerUtility;

import org.apache.log4j.Logger;

import visiteurs.VisiteurDeplacement;
import visiteurs.VisiteurDessinerElements;
import visiteurs.VisiteurPlacerAleatoirement;
import donnees.EspaceDepot;
import donnees.EspaceFabrique;

public class Console {
	private static Logger logger = LoggerUtility.getLogger(Console.class);
	Scanner scanner = new Scanner(System.in);
	int x, y, nbGardiens, nbIntrus , densiteObstacles ;
	EspaceFabrique fabrique = new EspaceFabrique();
	EspaceDepot depot = EspaceDepot.getInstance();
	
	
	VisiteurDessinerElements afficheur = new VisiteurDessinerElements(); 

	public void blablaDeBienvenue() {
		System.out.println("****************Début du jeu****************");
		System.out.println("****************LE GARDIEN DE PARC****************");
		System.out.println("\n\n");
		creationDeLaGrille();
	}

	public void creationDeLaGrille() {
		System.out.println("Saisissez les dimensions de votre grille du jeu");
		System.out.println("\n");
		System.out.println("Tout d'abord, choisissez un nombre pour les lignes de votre grille svp");

		x = scanner.nextInt();
		System.out.println("Choisissez un autre nombre pour les colonnes de votre grille svp");
		y = scanner.nextInt();

		System.out.println("Le format de votre grille est de " + x + " x " + y);
		System.out.println("\n\n");

		fabrique.creerGrille(x, y); // instancie la grille du jeu
		creationElements();
	}

	public void creationElements() {
		System.out.println("****************Création des éléments du jeu****************");
		System.out.println("Choisissez le nombre de gardiens à placer");
		nbGardiens = scanner.nextInt();
		fabrique.creerPlusieursGardiens(nbGardiens);
		System.out.println("Choisissez le nombre d'intrus à placer");
		nbIntrus = scanner.nextInt();
		fabrique.creerPlusieursIntrus(nbIntrus);
		System.out.println("Choisissez le nombre d'obstacles à placer");
		densiteObstacles = scanner.nextInt();
		fabrique.creerPlusieursObstacles(densiteObstacles);
		
		placementEtDessinDesElements();
	}
	

	public void placementEtDessinDesElements() {
		
		System.out.println("****************Placement des éléments****************");
		Grille grille = depot.getGrille();

		VisiteurPlacerAleatoirement placerAleatoire = new VisiteurPlacerAleatoirement();
		placerAleatoire.positionnerTousLesGardiens();
		placerAleatoire.positionnerTousLesIntrus();
		placerAleatoire.positionnerTousLesObstacles();

		System.out.println("\n\n");
		System.out.println("Légende :\n\nG = gardien\nI = intrus\nE = eau\nM = mur\nA = arbre");

		VisiteurDessinerElements dessineElements = new VisiteurDessinerElements();

		grille.accepteVisiteur(dessineElements);
		testDeplacement();
		
		

		System.out.println("\n\n");
		System.out.println("Test de positionnement aléatoire des gardiens sur la grille");
		System.out.println("\n\n");
		System.out.println("adios.");
	}
	
	public void testDeplacement(){
		int i ; 
		Grille grille = depot.getGrille();
		for(i=0 ; i<100 ; i++){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VisiteurDeplacement deplaceur = new VisiteurDeplacement() ; 
		deplaceur.deplacer();
		afficheur.visite(grille );
		
		
		}
	}

}
