package arraylist;
//on importe les �l�ments n�cessaires
import javax.swing.*;
import java.util.*;


public class Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// d�finition de l'ArrayList
		ArrayList jeux = new ArrayList();
		
		// utilis� comme condition d'arr�t de la boucle
		
		boolean cont = false;
		do
		{
			cont = false; // r�initialiser cont
			// que veut faire l'utilisateur ?
			int choix = Integer.parseInt(JOptionPane.showInputDialog("Saisissez\n" + "1 pour ajouter un nouveau jeu\n" + "2 pour acc�der � un jeu"));
			if(choix == 1)
			{
				// r�cup�re le nom
				String nom;
				nom = JOptionPane.showInputDialog("Nom du jeu ?");
				
				//on l'ajoute
				jeux.add(nom);
				
			}
			
			if(choix == 2)
			{
				// on demande � l'utilisateur quel nom renvoyer
				int element = Integer.parseInt(JOptionPane.showInputDialog("Quel �l�ment ?"));
				
				// ceci est affich� dans un nouveau JOptionPane
				
				String sortie = "Le nom du jeu est : \n";
				
				// concat�nation et r�cup�ration de l'�l�ment
				
				sortie+=((String)jeux.get(element));
				// on affiche dans le JOptionPane
				
				JOptionPane.showMessageDialog(null, sortie);
				
			}
			
			
			// saisie utilisateur pour la r�p�tition
			String repeter = JOptionPane.showInputDialog("Recommencer ? (oui/non)");
			if(repeter.equals("oui"))
			{
				cont = true;
			}
		}while(cont); //continuer tant que cont a la valeur true
		
		

	}

}
