package outils;

import data.AttaqueCar;

/**
 * Cette classe contient une m�thode qui donne un nombre al�atoir
 * @author Irhad et Keita
 */
public class Outil { //permet de faire un choix al�atoire entre 0 et 99
	
	private static int  val;
	
	private static int  val1;
	/**
	 * C'est une m�thode static
	 * Elle retourne un nombre al�atoir compris entre Z�ro et le param�tre qu'elle a r��u 
	 * 
	 * @param val
	 * @return une valeur entiere al�atoir en utilisant la fonction random()
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
