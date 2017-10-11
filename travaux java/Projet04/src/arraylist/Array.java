package arraylist;
//on importe les éléments nécessaires
import javax.swing.*;
import java.util.*;


public class Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// définition de l'ArrayList
		ArrayList jeux = new ArrayList();
		
		// utilisé comme condition d'arrêt de la boucle
		
		boolean cont = false;
		do
		{
			cont = false; // réinitialiser cont
			// que veut faire l'utilisateur ?
			int choix = Integer.parseInt(JOptionPane.showInputDialog("Saisissez\n" + "1 pour ajouter un nouveau jeu\n" + "2 pour accéder à un jeu"));
			if(choix == 1)
			{
				// récupère le nom
				String nom;
				nom = JOptionPane.showInputDialog("Nom du jeu ?");
				
				//on l'ajoute
				jeux.add(nom);
				
			}
			
			if(choix == 2)
			{
				// on demande à l'utilisateur quel nom renvoyer
				int element = Integer.parseInt(JOptionPane.showInputDialog("Quel élément ?"));
				
				// ceci est affiché dans un nouveau JOptionPane
				
				String sortie = "Le nom du jeu est : \n";
				
				// concaténation et récupération de l'élément
				
				sortie+=((String)jeux.get(element));
				// on affiche dans le JOptionPane
				
				JOptionPane.showMessageDialog(null, sortie);
				
			}
			
			
			// saisie utilisateur pour la répétition
			String repeter = JOptionPane.showInputDialog("Recommencer ? (oui/non)");
			if(repeter.equals("oui"))
			{
				cont = true;
			}
		}while(cont); //continuer tant que cont a la valeur true
		
		

	}

}
