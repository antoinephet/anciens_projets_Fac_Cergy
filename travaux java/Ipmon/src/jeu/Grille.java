package jeu;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Grille {
	
	// attributs de la classe
		private String grille[][];
		private int nbLigne,nbColonne,nb;
		private static ArrayList<Arbre> arbres;
		
		private Joueur joueur;
		private Ipmon ipmon;
		private Dresseur dresseur;
		private Arbre arbre;
		private FileReader fr;
		
		private boolean choixGardien1;
		private boolean active;
		
		
		public Grille(int nbLigne, int nbColonne, int nb) {
			
			
			this.nbLigne = nbLigne;
			this.nbColonne = nbColonne;
			this.nb = nb;
		}
		
		// constructeur 
		public Grille(int ligne,int colonne){
			
			choixConsole();
			grille = new String[nbLigne][nbColonne];
			
			
		}
		
		
		public void choixConsole(){
			nbLigne = nbColonne = 20;
			System.out.println("on vous a choisi le format 20x20");System.out.println("\n");
		}
		
		
		public void chargerFichier(){
			
			
			
			try{
				
				
				// si la taille de l'�cran est 20x20, alors le fichier Carte3.txt sera lu 
				if((nbLigne==20) && (nbColonne==20)){
					
					fr = new FileReader("Cartes/Carte1.txt");
					
				}
				
				
				int i = 0;
				int x=0, y = 0;
				
				arbres = new ArrayList<Arbre>();
				
				
				while((i = fr.read()) != -1){
					char conv = (char) i; // la valeur en int convertit en char
					
					// si la lecture trouve la valeur "0" dans le fichier, alors la valeur change en "A"
					// et instance la classe Arbre
					if(conv == '0'){
						grille[x][y] = "A";
						arbre = new Arbre(x, y);
						arbres.add(arbre);
						
					}
					
					// si la lecture trouve la valeur "1" dans le fichier, alors la valeur change en "J"
					// et instance la classe Joueur
					else if(conv == '1'){ // 
						
						grille[x][y] = "J";
						joueur = new Joueur(x, y);
						
					}
					
					// si la lecture trouve la valeur "2" dans le fichier, alors la valeur change en "I"
					// et instance la classe Ipmon
					else if(conv == '2'){
						grille[x][y] = "I";
						ipmon = new Ipmon(x, y);
						
					}
					
					// si la lecture trouve la valeur "3" dans le fichier, alors la valeur change en "D"
					// et instance la classe Dresseur
					else if(conv == '3'){
						
						grille[x][y] = "D";
						dresseur = new Dresseur(x, y);
						
					}
					

					// si la lecture trouve la valeur " " dans le fichier, alors la valeur change en " " donc pas de valeur
					
					else if(conv == ' '){
						grille[x][y] = " ";
					}
					else if(conv == '\r' || conv == '\n'){
						x--;
					}
					
					if(x == nbLigne-1){ // si on atteint le x maximum, on incr�mente le y
						y++;
						x=0;
					}
					else {
						x++;
					}
					
				}
				
			}catch(Exception ex){}
			
			
		}
		
		
		public void affichage(){
			
			System.out.println();
			for (int i=0  ; i<nbLigne ; i++){
				for(int j=0 ; j<nbColonne ; j++){
					System.out.print(" |  " + grille[i][j] );
					
				}
				System.out.println(" | ");
			
			} 
			System.out.println();
			
		}
		
		public void deplacerHaut(){
			
			String vi ; // valeur interm�diaire
			
			
			for(int i = 0;i<nbLigne;i++){
				// joueur
				for(int j = 0;j<nbColonne;j++){
					if(grille[i][j] == "J" && choixGardien1){ // on cherche un joueur
						if(i-1 >=0 && grille[i-1][j] == " "){ // on teste la position du joueur
							vi = grille[i][j];
							grille[i][j] = " "; // on vide la case
							grille[i-1][j] = vi; // on d�place le joueur
							
						}if(i-1 >=0 && grille[i-1][j] == "I"){
							grille[i-1][j] = " ";
							collisionReperage();
							
							
						}if(i-1 >=0 && grille[i-1][j] == "D"){
							grille[i-1][j] = " ";
							collisionReperage();
							
							
							
						}if(i-1 <= nbLigne || grille[i-1][j] == "A"){
							
							collisionObstacle();
							
							
						}
						
					}
					
					
					// ipmon
					if(grille[i][j] == "I" && active){//  on cherche l'ipmon
						if(i-1 >=0 && grille[i-1][j] == " "){// on teste la position de l'ipmon
							vi = grille[i][j];
							grille[i][j] = " "; // on vide la case
							grille[i-1][j] = vi; // on d�place l'ipmon
							
						}if(i-1 >=0 && grille[i-1][j] == "J"){
							grille[i][j] = " ";
							collisionReperage();
							
							
						}if(i-1 <= nbLigne || grille[i-1][j] == "A"){
							
							collisionObstacle();
							
							
						}


					}
					
				}
			}
			
			
			
		}
		
		// methode qui permet de d�placer les personnage mobiles vers le bas
		public void deplacerBas(){
			
			
			String vi ; // valeur interm�diaire
			for(int i = 0;i<nbLigne;i++){
				for(int j = 0;j<nbColonne;j++){
					
					if(grille[i][j] == "J" && choixGardien1){ // on cherche un joueur
						if(i+1 <= nbLigne && grille[i+1][j] == " "){ // on teste la position du joueur
							vi = grille[i][j];
							grille[i][j] = " "; // on vide la case
							grille[i+1][j] = vi; // on d�place le joueur
							return;
						}if(i+1 <=nbLigne && grille[i+1][j] == "I"){
							grille[i+1][j] = " ";
							collisionReperage();
							return;
							
						}if(i+1 <=nbLigne && grille[i+1][j] == "D"){
							grille[i+1][j] = " ";
							collisionReperage();
							return;
							
						}
						if(i+1 <= nbLigne || grille[i+1][j] == "A"){
							
							collisionObstacle();
							return;
							
						}


					}
					
					
					
					// ipmon
					if(grille[i][j] == "I" && active){// on cherche l'ipmon
						if(i+1 <= nbLigne && grille[i+1][j] == " "){// on teste la position de l'ipmon
							vi = grille[i][j];
							grille[i][j] = " "; // on vide la case
							grille[i+1][j] = vi; // on d�place l'ipmon
							return;
							
						}if(i+1 <= nbLigne && grille[i+1][j] == "J"){
							grille[i][j] = " ";
							collisionReperage();
							return;
							
						}
						if(i+1 <= nbLigne || grille[i+1][j] == "A"){
							
							collisionObstacle();
							return;
							
						}


					}


				}

			}
		
		}
		
		// methode qui permet de d�placer les personnage mobiles vers la gauche
		public void deplacerGauche(){
			
			String vi ; // valeur interm�diaire
			for(int i = 0;i<nbLigne;i++){
				for(int j = 0;j<nbColonne;j++){
					// joueur 1
					if(grille[i][j] == "J" && choixGardien1){ // on cherche un joueur
						if(j-1 >=0 && grille[i][j-1] == " "){ // on teste la position du joueur
							vi = grille[i][j];
							grille[i][j] = " "; //on vide la case
							grille[i][j-1] = vi; // on d�place le joueur
							
						}if(j-1 >=0 && grille[i][j-1] == "I"){
							grille[i][j-1] = " ";
							collisionReperage();
							
						}if(j-1 >=0 && grille[i][j-1] == "D"){
							grille[i][j-1] = " ";
							collisionReperage();
							
						}
						if(j-1 >=0 || grille[i][j-1] == "A"){
							
							collisionObstacle();
							
						}

					}
					
					
					// ipmon
					if(grille[i][j] == "I" && active){// on cherche l'ipmon
						if(j-1 >=0 && grille[i][j-1] == " "){// on teste la position de l'ipmon
							vi = grille[i][j];
							grille[i][j] = " "; // on vide la case
							grille[i][j-1] = vi; // on d�place l'ipmon
							
						}if(j-1 >=0 && grille[i][j-1] == "J"){
							grille[i][j] = " ";
							collisionReperage();
							
						}
						if(j-1 >=0 || grille[i][j-1] == "A"){
							
							collisionObstacle();
							
						}

					}
					

				}

			}
		
		}
		
		// methode qui permet de d�placer les personnage mobiles vers la droite
		
		public void deplacerDroite(){
			
			String vi ;
			for(int i = 0;i<nbLigne;i++){
				for(int j = 0;j<nbColonne;j++){
					if(grille[i][j] == "J" && choixGardien1){ // on cherche un joueur
						if(j+1 <=nbColonne && grille[i][j+1] == " "){ // on teste la position du joueur
							vi = grille[i][j];
							grille[i][j] = " "; // on vide la case
							grille[i][j+1] = vi; // on d�place le joueur
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "I"){
							grille[i][j+1] = " ";
							collisionReperage();
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "D"){
							grille[i][j+1] = " ";
							collisionReperage();
							break;
							
						}
						if(j+1 <=nbColonne || grille[i][j+1] == "A"){
							
							collisionObstacle();
							break;
						}
						
					}
					
					
					
					// ipmon
					
					if(grille[i][j] == "I" && active){// on cherche l'ipmon
						if(j+1 <=nbColonne && grille[i][j+1] == " "){// on teste la position de l'ipmon
							vi = grille[i][j];
							grille[i][j] = " "; // on vide la case
							grille[i][j+1] = vi; // on d�place l'ipmon
							break;
							
						}if(j+1 <=nbColonne && grille[i][j+1] == "D"){
							grille[i][j] = " ";
							collisionReperage();
							break;
							
						}
						if(j+1 <=nbColonne || grille[i][j+1] == "A"){
							
							collisionObstacle();
							break;
						}

					}
					

				}

			}
			
		}
		
		/*
		 * 
		 * les m�thodes pour les d�placemnts al�atoires et manuelles
		 * 
		 * 
		 */
		
		// methode qui permet de d�placer manuellement les personnage mobiles et choisir son gardien
		public void deplacementManuel(){
			
			int i=0;
			
			while(i<100){
				choixGardien1 = true;
				active=false;
				
				int choix2 = 0;
				while(choix2 != 1 && choix2 != 2 && choix2 != 3 && choix2 != 4 && choix2 != 5){
					
					choix2 = Integer.parseInt(JOptionPane.showInputDialog("Quelle direction pour diriger le joueur ?\n\n1 : haut\n2 : bas \n3 : gauche\n4 : droite\n5 : quitter "));
					System.out.println("Quelle direction pour diriger le joueur ?\n\n1 : haut\n2 : bas \n3 : gauche\n4 : droite\n5 : quitter ");
					System.out.println("");
					
				}
				
				if(choix2 == 1){
					
					deplacerHaut();
					
				}
				
				if(choix2 == 2){
					
					deplacerBas();
					
				}
				if(choix2 == 3){

					deplacerGauche();

				}
				
				if(choix2 == 4){
					
					deplacerDroite();
					
				}
				
				
				
				if(choix2 == 5){

					i=100 ;
					System.out.println("Vous avez quitté le mode manuel");System.out.println("\n");
					System.out.println("On passe en mode aléatoire");

				}
				
				
				//try {
					// rafraichit l'�cran
					
					/* à utiliser seulement sous linux
					 * 
					 * if(System.getProperty("os.name" ).startsWith("Windows" ))
					    Runtime.getRuntime().exec("cls" );
					  else
					    Runtime.getRuntime().exec("clear" );
					 * 
					 */
					
					//if(System.getProperty("os.name" ).startsWith("Windows" ))
					   // Runtime.getRuntime().exec("cls" );
					 // else
					    //Runtime.getRuntime().exec("clear" );
					//Runtime.getRuntime().exec("cmd /c cls");
					//Runtime.getRuntime().exec( "command /c cls" ) ;
					
				//} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}
				// met � jour la grille
				affichage();
				i++;
				
			}
			
		}
		
		// methode qui signale une collision
		public void collisionReperage(){
			
			System.out.println("\n Alerte collision! Le joueur a crois� un ipmon!!");
			
		}

		// methode qui signale une collision
		public void collisionObstacle(){
			
			System.out.println("\n Alerte collision! Le joueur ne peut pas franchir cet obstacle!");
		
		}
		
				
				
			
		
		
		

}
