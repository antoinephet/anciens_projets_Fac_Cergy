package training.tangara.chrono.before;

import java.awt.*;
import java.applet.*;




public class Layout extends Applet  { 
	private int nbLigne = 20 ;
	private int nbColonne = 20 ;

	
	public void init(){
		 
		 setLayout(new GridLayout(5,5));
		 
		 for (int i=0  ; i<nbLigne ; i++){
				for(int j=0 ; j<nbColonne ; j++){
					 Cellule cellules = new Cellule() ; 
					
				}
			}
		 
		 
	 }
	

}
