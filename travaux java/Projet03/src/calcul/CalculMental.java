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
		
		// nombre de demi-secondes accord�s � l'utilisateur
		int difficulte;
		difficulte = Integer.parseInt(JOptionPane.showInputDialog("A quel pont etes vous dou� ? \n" + "1 = je suis un petit genie! \n" + "10 = je ne suis pas vraiment dou�."));
		
		// indique a la boucle s'il faut continuer ou pas
		
		boolean cont = false;
		
		// le contenu de la methode main est encadr� dans une boucle while
		
		do
		{
			
			//r�initialise la variable cont � false
			cont = false;
			
			// nombre al�atoires pour l'�quation 
			
			int num1 = (int)(Math.round(Math.random()*10));
			
			// la boucle do... while sert � �viter l'exception. num2 doit �tre d�clar� �
			// l'ext�rieur de cette boucle
			int num2;
			do
			{
				//initialisation de num2
				num2 = (int)(Math.round(Math.random()*10));
				
				
			}while(num2 == 0);
			
			// nombre al�atoire pour le signe
			int signe = (int)(Math.round(Math.random()*3));
			
			// contiendra la r�ponse
			int reponse;
			
			// rend l'affichage plus lisible
			System.out.println("\n\n/*****");
			if(signe == 0){
				//affiche la question et calcule la r�ponse
				System.out.println(num1+" fois "+num2);
				reponse = num1*num2;
				
			}
			else if(signe == 1){
				//affiche la question et calcule la r�ponse
				System.out.println(num1+" divis� "+num2);
				reponse = num1/num2;
			}
			
			else if(signe == 2){
				//affiche la question et calcule la r�ponse
				System.out.println(num1+" plus "+num2);
				reponse = num1 + num2;
			}
			
			else if(signe == 3){
				//affiche la question et calcule la r�ponse
				System.out.println(num1+" moins "+num2);
				reponse = num1 - num2;
			}
			
			else {
				//affiche la question et calcule la r�ponse
				System.out.println(num1+" % "+num2);
				reponse = num1 % num2;
			}
			
			// rend l'affichage plus lisible
			System.out.println("********\n");
			
			//d�compte pour la difficult� - on utilise une boucle for
			for(int i = difficulte;i >=0;i--){
				// affichage du temps restant
				System.out.println(i+"...");
				// on attend une demi-seconde par 
				// niveau de difficult�
				Thread.sleep(500);
				
				
			}
			
			// affiche la r�ponse
			System.out.println("REPONSE : "+reponse);
			// demande � l'utilisateur s'il veut rejouer
			String encore;
			encore = JOptionPane.showInputDialog("Rejouer ? (oui/non)");
			// si l'utilisateur r�pond oui, on passe la valeur de cont � true
			if(encore.equals("oui")){
				cont = true;
			}
				
			
		}while(cont); // on continue tant que cont a la valeur true
	}

}
