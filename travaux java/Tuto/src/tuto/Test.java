package tuto;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// on crée la grille
		Grille g1 = new Grille(12,9);
		
		
		
		// on place le joueur
		
		g1.placer(1, 1, 'J');
		
		g1.placer(3, 2, 'O');
		g1.placer(3, 1, 'O');
		g1.placer(5, 3, 'M');
		
		// on affiche la grille
		
		System.out.println("J = joueur\nO = objet\nM = monstre\n- = vide");
		g1.afficher();

		/*System.out.println();
		*System.out.println();
		*System.out.println();
		
		
		Grille g2 = new Grille(5,5);
		g2.afficher();
		*/
		
		

	}

}
