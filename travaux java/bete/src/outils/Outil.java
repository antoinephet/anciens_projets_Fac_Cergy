package outils;

import data.AttaqueCar;

/**
 * Cette classe contient une méthode qui donne un nombre aléatoir
 * @author Irhad et Keita
 */
public class Outil { //permet de faire un choix aléatoire entre 0 et 99
	
	private static int  val;
	
	private static int  val1;
	/**
	 * C'est une méthode static
	 * Elle retourne un nombre aléatoir compris entre Zéro et le paramètre qu'elle a réçu 
	 * 
	 * @param val
	 * @return une valeur entiere aléatoir en utilisant la fonction random()
	 */
	public static int choix(int min, int max){ //retourne un nombre comprise en 0 et val
	   Outil.val=(int)(Math.random()*((max-min)+min)+1);    
	   
	   return val;
   }
	
	public static int pourcentage(int val,int prcentage){
		
	Outil.val1 = (int)((val*prcentage)/100);
	
	  return val1;
	}
	
}
