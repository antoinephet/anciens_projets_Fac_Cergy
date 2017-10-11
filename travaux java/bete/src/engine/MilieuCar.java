package engine;

import java.awt.Color;

import exceptions.EnvironnementException;

public class MilieuCar {

	private Couple environnement[][];
	private int coefAttaque;
	private int coefDefense;
	private int nbCase;
	private Color couleur[][];
	private Color couleur1 ;
	
	
	/**
	 * Ce constructeur cr�er une matrice de couple,

	 * ce couple correspond aux coefficient d'attaque et de d�fense d'une case
	 * et initialise les diff�rentes couleurs associ�es
	 * 
	 * @param nbCase
	 *               Le nombre de case de la grille 
	 */
		public MilieuCar(int nbCase) {

			this.nbCase = nbCase;
			environnement = new Couple[nbCase][nbCase];
			
			couleur = new Color [nbCase][nbCase];

			for (int i = 0; i < nbCase; i++) {

				for (int j = 0; j < nbCase; j++) {

					environnement[i][j] = new Couple(coefAttaque, coefDefense);
	                
				}

			}
		}
	    
		
		/**
		 * Elle d�finit les coefficients d'attaque et de d�fense de chaque partie de la grille 
		 * 
		 * @param xi
		 *           la ligne o� commence le milieu
		 * @param yi
		 *          la conne o� commence le milieu
		 * @param xj
		 *          la ligne o� finit le milieu
		 * @param yj
		 *          la colonne o� finit le milieu
		 * @param env
		 */
		public void milieu(int xi, int yi, int xj, int yj, String env) throws EnvironnementException { /*L'appelle de cette m�thode d�finit les caract�ristique
		                                                                 d'un milieu en augmentant ou en diminuant les caract�ristiques d'attaque
		                                                                  et de d�fense*/

	if(xi>=0 && yi<nbCase && xj >=0 && yj <nbCase){		
			int i, j;

			if (env == "montagne") {  //d�finit la montagne

				coefAttaque = 0; // augmentation d�fense
				coefDefense = -3;
				
				couleur1 = Color.gray;

			} else {

				if (env == "foret") { //d�finit la foret

					coefAttaque = 3;
					coefDefense = 0;
					
					couleur1 = Color.green;

				} else {
					if (env == "desert") { //d�finit le d�sert

						coefAttaque = 0;
						coefDefense = 3;
						
						couleur1 = Color.orange;					

					} else {
						if (env == "neutre") { //d�finit un espace neutre

							coefAttaque = 0;
							coefDefense = 0;
							
							couleur1 = null;					

						} 
					}
				}
				
			}

				for (i = xi; i <= xj; i++) {

					for (j = yi; j <= yj; j++) {

						environnement[i][j] = new Couple(coefAttaque, coefDefense);
						
						couleur[i][j] = couleur1;
					}

				}
	}else{
		
		throw new EnvironnementException(nbCase-1);
	}

		}
	    
		/**
		 * Elle retourne le coefficient de d�fense en fonction du milieu, l� o� se trouve la case
		 * 
		 * @param i
		 *         la ligne o� se trouve la case
		 * @param j
		 *         la colonne o� se trouve la case
		 * @return 
		 *         un entier, un facteur qui diminue ou augmente un caract�re de d�fense
		 */
		public int getDefenseCoef(int i, int j) {

			System.out.println("defense " + environnement[i][j].getDefense());
			return environnement[i][j].getDefense();
		}
	   
		/**
		 * Elle retourne le coefficient d�attaque en fonction du milieu, l� o� se trouve la case
		 * 
		 * @param i
		 *         la ligne o� se trouve la case
		 * @param j
		 *         la colonne o� se trouve la case
		 * @return 
		 *         un entier, un facteur qui diminue ou augmente un caract�re d'attaque
		 */
		public int getAttaqueCoef(int i, int j) {

			System.out.println("attaque " + environnement[i][j].getAttaque());

			return environnement[i][j].getAttaque();
		}
		
		
	    
		/**
		 * 
		 * 
		 * @param i
		 *         ligne o� se trouve la case
		 * @param j
		 *          colonne o� se trouve la case
		 * @return un objet de type "Color" qui est la couleur associ�e au milieu         
		 */
		public Color getCouleur(int i,int j) {
			return couleur[i][j];
		}
	    
		/**
		 * Cette classe cr�er un couple de deux entiers
		 * 
		 * @author Irhad
		 *
		 */
		private class Couple {

			private int defense;
			private int attaque;
	        
			/**
			 * Constructeur du couple
			 * 
			 * @param attaque
			 * @param defense
			 */
			private Couple(int attaque, int defense) {

				this.attaque = attaque;
				this.defense = defense;
			}
	        
			/**
			 * accesseur de l'attribut "defense"
			 */
			public int getDefense() {
				return defense;
			}
			
			/**
			 * accesseur de l'attribut "defense"
			 */
			public int getAttaque() {
				return attaque;
			}

		}

	}
