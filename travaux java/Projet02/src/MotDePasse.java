
// permettre la saisie utilisateur

import javax.swing.*;

// permettre l'acces aux fichiers
import java.io.*;

public class MotDePasse {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String saisie;
		saisie = JOptionPane.showInputDialog("1 pour initialiser le mot de passe,\n"+"2 pour chercher le message");
		
		//fichier modifie et lu
		
		File fichier = new File("motdepasse.mdp");
		
		// faut-il saisir et lire le mot de passe ?
		
		if(saisie.equals("1"))
		{
			// on veut modifier le mot de passe
			
			// recupere le nouveau mot de passe
			String p = JOptionPane.showInputDialog("Saisissez le nouveau mot de passe");
			
			// ces deux lignes initialisent l'écriture dans le fichier 
			
			FileOutputStream fluxSortie = new FileOutputStream(fichier);
			PrintWriter sortie = new PrintWriter(fluxSortie);
			
			// ecrit le mot de passe dans le fichier
			
			sortie.println(p);
			
			// on ferme tout
			
			sortie.flush();
			sortie.close();
			fluxSortie.close();
		
		
		

	}
		
		// si l'utilisateur veut trouver le mot de passe
		
		else {
			// il faut d'abord le recuperer
			
			FileReader fr = new FileReader(fichier);
			BufferedReader tampon = new BufferedReader(fr);
			
			//le mot de passe du fichier
			
			String passe = tampon.readLine();
			
			// recupere l'essai de l'utilisateur
			
			String passeUtilisateur;
			passeUtilisateur = JOptionPane.showInputDialog("Saisissez votre essai...");
			
			// testez le mot de passe
			
			if(passe.equals(passeUtilisateur))
			{
				// si c'est correct
				
				JOptionPane.showMessageDialog(null,"CORRECT !!!!");
			}
			else {
				// si c'est faux
				
				JOptionPane.showMessageDialog(null,"RATE !!!!");
			}
			
		}

}
}