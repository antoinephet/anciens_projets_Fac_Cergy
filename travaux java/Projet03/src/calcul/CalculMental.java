package calcul;
// permetre la recuperation de saisies utilisateur
import javax.swing.*;


public class CalculMental {

	/**
	 * @param args
	 */
	
	// methode main (throw Exception) est necessaire pour Thread.sleep()
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		// nombre de demi-secondes accordés à l'utilisateur
		int difficulte;
		difficulte = Integer.parseInt(JOptionPane.showInputDialog("A quel pont etes vous doué ? \n" + "1 = je suis un petit genie! \n" + "10 = je ne suis pas vraiment doué."));
		
		// indique a la boucle s'il faut continuer ou pas
		
		boolean cont = false;
		
		// le contenu de la methode main est encadré dans une boucle while
		
		do
		{
			
			//réinitialise la variable cont à false
			cont = false;
			
			// nombre aléatoires pour l'équation 
			
			int num1 = (int)(Math.round(Math.random()*10));
			
			// la boucle do... while sert à éviter l'exception. num2 doit être déclaré à
			// l'extérieur de cette boucle
			int num2;
			do
			{
				//initialisation de num2
				num2 = (int)(Math.round(Math.random()*10));
				
				
			}while(num2 == 0);
			
			// nombre aléatoire pour le signe
			int signe = (int)(Math.round(Math.random()*3));
			
			// contiendra la réponse
			int reponse;
			
			// rend l'affichage plus lisible
			System.out.println("\n\n/*****");
			if(signe == 0){
				//affiche la question et calcule la réponse
				System.out.println(num1+" fois "+num2);
				reponse = num1*num2;
				
			}
			else if(signe == 1){
				//affiche la question et calcule la réponse
				System.out.println(num1+" divisé "+num2);
				reponse = num1/num2;
			}
			
			else if(signe == 2){
				//affiche la question et calcule la réponse
				System.out.println(num1+" plus "+num2);
				reponse = num1 + num2;
			}
			
			else if(signe == 3){
				//affiche la question et calcule la réponse
				System.out.println(num1+" moins "+num2);
				reponse = num1 - num2;
			}
			
			else {
				//affiche la question et calcule la réponse
				System.out.println(num1+" % "+num2);
				reponse = num1 % num2;
			}
			
			// rend l'affichage plus lisible
			System.out.println("********\n");
			
			//décompte pour la difficulté - on utilise une boucle for
			for(int i = difficulte;i >=0;i--){
				// affichage du temps restant
				System.out.println(i+"...");
				// on attend une demi-seconde par 
				// niveau de difficulté
				Thread.sleep(500);
				
				
			}
			
			// affiche la réponse
			System.out.println("REPONSE : "+reponse);
			// demande à l'utilisateur s'il veut rejouer
			String encore;
			encore = JOptionPane.showInputDialog("Rejouer ? (oui/non)");
			// si l'utilisateur répond oui, on passe la valeur de cont à true
			if(encore.equals("oui")){
				cont = true;
			}
				
			
		}while(cont); // on continue tant que cont a la valeur true
	}

}
