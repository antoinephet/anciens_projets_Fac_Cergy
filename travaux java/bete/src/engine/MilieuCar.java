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
	 * Ce constructeur créer une matrice de couple,

	 * ce couple correspond aux coefficient d'attaque et de défense d'une case
	 * et initialise les différentes couleurs associées
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
		 * Elle définit les coefficients d'attaque et de défense de chaque partie de la grille 
		 * 
		 * @param xi
		 *           la ligne où commence le milieu
		 * @param yi
		 *          la conne où commence le milieu
		 * @param xj
		 *          la ligne où finit le milieu
		 * @param yj
		 *          la colonne où finit le milieu
		 * @param env
		 */
		public void milieu(int xi, int yi, int xj, int yj, String env) throws EnvironnementException { /*L'appelle de cette méthode définit les caractéristique
		                                                                 d'un milieu en augmentant ou en diminuant les caractéristiques d'attaque
		                                                                  et de défense*/

	if(xi>=0 && yi<nbCase && xj >=0 && yj <nbCase){		
			int i, j;

			if (env == "montagne") {  //définit la montagne

				coefAttaque = 0; // augmentation défense
				coefDefense = -3;
				
				couleur1 = Color.gray;

			} else {

				if (env == "foret") { //définit la foret

					coefAttaque = 3;
					coefDefense = 0;
					
					couleur1 = Color.green;

				} else {
					if (env == "desert") { //définit le désert

						coefAttaque = 0;
						coefDefense = 3;
						
						couleur1 = Color.orange;					

					} else {
						if (env == "neutre") { //définit un espace neutre

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
		 * Elle retourne le coefficient de défense en fonction du milieu, là où se trouve la case
		 * 
		 * @param i
		 *         la ligne où se trouve la case
		 * @param j
		 *         la colonne où se trouve la case
		 * @return 
		 *         un entier, un facteur qui diminue ou augmente un caractère de défense
		 */
		public int getDefenseCoef(int i, int j) {

			System.out.println("defense " + environnement[i][j].getDefense());
			return environnement[i][j].getDefense();
		}
	   
		/**
		 * Elle retourne le coefficient d’attaque en fonction du milieu, là où se trouve la case
		 * 
		 * @param i
		 *         la ligne où se trouve la case
		 * @param j
		 *         la colonne où se trouve la case
		 * @return 
		 *         un entier, un facteur qui diminue ou augmente un caractère d'attaque
		 */
		public int getAttaqueCoef(int i, int j) {

			System.out.println("attaque " + environnement[i][j].getAttaque());

			return environnement[i][j].getAttaque();
		}
		
		
	    
		/**
		 * 
		 * 
		 * @param i
		 *         ligne où se trouve la case
		 * @param j
		 *          colonne où se trouve la case
		 * @return un objet de type "Color" qui est la couleur associée au milieu         
		 */
		public Color getCouleur(int i,int j) {
			return couleur[i][j];
		}
	    
		/**
		 * Cette classe créer un couple de deux entiers
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
