package training.tangara.chrono.before;

import java.util.ArrayList;
import java.awt.*;
import java.applet.*;


public class Gril {

	private int nbLigne ;
	private int nbColonne ; 
	private float densiteObstacle ; 
	private int nbIntrus ; 
	//private ArrayList <Arbre >arbres ;
	//private ArrayList<Mur>murs ;
	//private ArrayList<Eau>eaux ; 
	//private ArrayList<Gardien>gardiens ; 
	//private ArrayList<Intrus>intrus ;
	private char [][] grille  ;


	public Gril(int nbLigne, int nbColonne, float densiteObstacle,
			int nbIntrus) {
		super();
		this.nbLigne = nbLigne;
		this.nbColonne = nbColonne;
		this.densiteObstacle = densiteObstacle;
		this.nbIntrus = nbIntrus;
	}
	
	public Gril  (int lig , int col){
		nbLigne= lig ;
		nbColonne = col ;
		
		grille = new char[nbLigne][nbColonne];
		
		for (int i=0  ; i<nbLigne ; i++){
			for(int j=0 ; j<nbColonne ; j++){
				grille[i][j] = 'h' ;
				
			}
		}
	}
	
	public void afficher() {
		// TODO Auto-generated method stub
		
		System.out.println();
		for (int i=0  ; i<nbLigne ; i++){
			for(int j=0 ; j<nbColonne ; j++){
				System.out.print(" |  " + grille[i][j] );
				
			}
			System.out.println(" | ");
		
		} 
		System.out.println();
		
		
	}
	
	/**public void dessin (){
		grille.setColor();
		
	}*/


	/*public Gril(ArrayList<Arbre> arbres, ArrayList<Mur> murs,
			ArrayList<Eau> eaux, ArrayList<Gardien> gardiens,
			ArrayList<Intrus> intrus) {
		super();
		this.arbres = arbres;
		this.murs = murs;
		this.eaux = eaux;
		this.gardiens = gardiens;
		this.intrus = intrus;
	}*/


	public int getNbLigne() {
		return nbLigne;
	}


	public int getNbColonne() {
		return nbColonne;
	}


	public float getDensiteObstacle() {
		return densiteObstacle;
	}


	public int getNbIntrus() {
		return nbIntrus;
	}


	/*public ArrayList<Arbre> getArbres() {
		return arbres;
	}*/


	/*public ArrayList<Mur> getMurs() {
		return murs;
	}*/


	/*public ArrayList<Eau> getEaux() {
		return eaux;
	}*/


	/*public ArrayList<Gardien> getGardiens() {
		return gardiens;
	}*/


	/*public ArrayList<Intrus> getIntrus() {
		return intrus;
	}*/


	/*public void setGardiens(ArrayList<Gardien> gardiens) {
		this.gardiens = gardiens;
	}*/


	/*public void setIntrus(ArrayList<Intrus> intrus) {
		this.intrus = intrus;
	}*/
	
	

}


