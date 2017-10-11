package creationJeux;

import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// creation du perso+monstre et ses caractéristiques
		Personnage p1 = new Personnage();
		Monstre m1 = new Monstre();
		System.out.println("Début de la partie");
		System.out.println("Création du personnage");
		System.out.println("Affichage du personnage");
		
		System.out.println(p1.toString());
		
		System.out.println("Votre personnage se fait attaquer");
		System.out.println("il perd donc 15 points de vie");
		
		p1.setVie(85);
		System.out.println(p1.toString());
		
		System.out.println("Votre personnage se repose 2 minutes");
		p1.setReposer(2);
		System.out.println(p1.toString());
		
		
		
		System.out.println("Fin de la partie");
		
		System.out.println("------------------------------------------");
		
		System.out.println("Grilles instanciées");
		
		Grille g1 = new Grille(15,20);
		
		
		// Position du joueur
		g1.placer(3, 3, 'J');
		
		// Position de l'objet
		g1.placer(7, 6, 'O');
		
		// Position de l'objet
		g1.placer(10, 9, 'M');
		
		
		System.out.println("J = Joueur\nO = Objet\nM = Monstre\n- = Vide\n");
		// affichage de la grille
		g1.afficher();
		
		
		System.out.println("");
		System.out.println("Debut des tests");
		
		System.out.println(g1.getCase(7, 6) + " = affichage de l'objet O");
		System.out.println("Déplacement du joueur");
		/*g1.deplacerH();*/
		g1.afficher();
		
		System.out.println("------------------------------------------");
		System.out.println("Création Monstre");
		System.out.println("Affichage du Monstre");
		System.out.println(m1.toString());
		
		
		System.out.println("Attaques aléatoires du personnage");
		System.out.println(p1.attaquer());
		System.out.println(p1.attaquer());
		System.out.println(p1.attaquer());
		
		System.out.println("Vous gagnez 10 pts de force");
		p1.setForce(20);
		System.out.println(p1.attaquer());
		System.out.println(p1.attaquer());
		
		
		
		System.out.println("Affichage du Monstre");
		System.out.println(m1.toString());
		System.out.println("Vous attaquez le monstre");
		m1.setVie(m1.getVie() - p1.attaquer());
		System.out.println(m1.toString());
		
		
		System.out.println("------------------------------------------");
		System.out.println("Où vous voulez déplacer le perso ?\n1 = haut\n2 = bas\n3 = gauche\n4 = droite");
		System.out.println("Veuillez entrer un nombre : ");
		Scanner sc = new Scanner(System.in);
		int nb = sc.nextInt();
		
		switch(nb){
		case 1 : g1.deplacerH();break;
		case 2 : g1.deplacerB();break;
		case 3 : g1.deplacerG();break;
		case 4 : g1.deplacerD();break;
		default : System.out.println("Mauvais chiffre");
		g1.afficher();
		
		}
		g1.afficher();

	}

}
