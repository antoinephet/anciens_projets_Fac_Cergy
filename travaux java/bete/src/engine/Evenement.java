package engine;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import outils.Outil;
import data.AttaqueCar;
import data.Bete;
import data.Case;
import data.Couple;
import data.DefenseCar;
import data.Grille;
import exceptions.InformationException;
import exceptions.PlacerException;

/**
 * Cette classe Contient les algorithmes de la classe grille, Elle initialise la
 * grille, et fait évoluer la grille, c'est à dire assure le déplacement des
 * bêtes
 * 
 * @author Irhad
 * 
 */
public class Evenement {

	private int niveauBete1;
	private int niveauBete2;

	/**
	 * Ces attributs représentent les caractéristiques d'attaques et de défense
	 * d'une bête. Les attributs ci-dessous permettent de creer une bête pendant
	 * que le programme tourne
	 * 
	 * @see Evenement#reproduction(Bete, Bete, boolean)
	 * @see Bete#Bete(int, int, int, int, int, int, int, int, int)
	 */

	/**
	 * L'attribut "pince" est un entier qui détermine cette capacité
	 * 
	 * @see AttaqueCar
	 */
	private int pince;

	/**
	 * L'attribut "venin" est un entier qui détermine cette capacité
	 * 
	 * @see AttaqueCar
	 */
	private int venin;

	/**
	 * L'attribut "machoir" est un entier qui détermine cette capacité
	 * 
	 * @see AttaqueCar
	 */
	private int machoir;

	/**
	 * L'attribut "feu" est un entier qui détermine cette capacité
	 * 
	 * @see AttaqueCar
	 */
	private int feu;

	/**
	 * L'attribut "carapace" est un entier qui détermine cette capacité
	 * 
	 * @see DefenseCar
	 */
	private int carapace;

	/**
	 * L'attribut "bouclier" est un entier qui détermine cette capacité
	 * 
	 * @see DefenseCar
	 */
	private int bouclier;

	/**
	 * L'attribut "epine" est un entier qui détermine cette capacité
	 * 
	 * @see DefenseCar
	 */
	private int epine;

	/**
	 * L'attribut "antipoison" est un entier qui détermine cette capacité
	 * 
	 * @see DefenseCar
	 */
	private int antipoison;

	/**
	 * L'attribut "energie" est un entier qui détermine l’énergie de la bête il
	 * est modifiable
	 * 
	 * @see Bete#setEnergie(int)
	 * @see Bete#getEnergie()
	 */
	private int energie;

	/**
	 * Cet attribut permet de choisir entre deux bête
	 * 
	 * @see Evenement#reproduction(Bete, Bete, boolean)
	 */
	private int aleatoir;

	/**
	 * cet attribut représente l’énergie maximum d'une bête
	 */
	private int energiMawNew;

	/**
	 * Cet attribut représente la ligne où se trouve une bête
	 */
	private int lg;

	/**
	 * Cet attribut représente la colonne où se trouve une bête
	 */
	private int cl;

	/**
	 * L'attribut "attaque1" (objet) est un ensemble de caractéristique Les
	 * caractéristiques d'attaques
	 * 
	 * @see AttaqueCar
	 */
	private AttaqueCar attaque1;

	/**
	 * L'attribut "defense1" (objet) est un ensemble de caractéristique Les
	 * caractéristiques de défense
	 * 
	 * @see DefenseCar
	 */
	private DefenseCar defense1;

	/**
	 * L'attribut "attaque2" (objet) est un ensemble de caractéristique Les
	 * caractéristiques d'attaques
	 * 
	 * @see AttaqueCar
	 */
	private AttaqueCar attaque2;

	/**
	 * L'attribut "defense1" (objet) est un ensemble de caractéristique Les
	 * caractéristiques de défense
	 * 
	 * @see DefenseCar
	 */
	private DefenseCar defense2;

	private int cont;

	/**
	 * Nombre de bête dans la grille
	 * 
	 * Il est modifiable
	 * 
	 * @see Evenement#setNourriture(int, ArrayList, Case[][])
	 * @see Evenement#getNbNourriture()
	 */
	private int nbNourriture;

	/**
	 * Nombre de case de la grille
	 * 
	 * Il n'est pas modifiable
	 */
	private int nbCase;

	/**
	 * Nombre de bête dans la grille
	 * 
	 * Il est modifiable
	 * 
	 * @see Evenement#setNbBete(int)
	 * @see Evenement#getNbBete()
	 */
	private int nbBete;

	/**
	 * Nombre de bête mâle dans la grille
	 * 
	 * Il est modifiable
	 * 
	 * @see Evenement#getNbBeteMale()
	 */
	private int nbBeteMale;

	/**
	 * Nombre de bête mâle dans la grille
	 * 
	 * Il est modifiable
	 * 
	 * @see Evenement#getNbBeteFemelle()
	 */
	private int nbBeteFemelle;

	/**
	 * L'attribut "voisins" est une collection contenant toutes les cases
	 * voisines libre d'une case en présence d'une bête
	 */
	private Map<Integer, Couple> voisins;

	/**
	 * Attribut de type MilieuCar, il sert à définir les caractéristiques d'un
	 * milieu dans la grille (désert,foret etc)
	 * 
	 * @see MilieuCar
	 */
	private MilieuCar milieu;

	/**
	 * l'attribut "betes" est la liste des bêtes présentes dans la grille
	 */
	private ArrayList<Bete> betes;

	/**
	 * l'attribut "betes" est la liste des bêtes présentes dans la grille Cette
	 * liste est une copie de "bêtes" avant le déplacement
	 * 
	 * @see Evenement#getInfoBete(int, int)
	 */
	private ArrayList<Bete> betesaAnce;

	/**
	 * l'attribut "grille" est une matrice d'objet de type "Case"
	 */
	private Case[][] grille;

	private String info;

	/**
	 * Coefficient d'attaque d'une bête par rapport à là où elle se trouve
	 * 
	 * @see MilieuCar
	 * @see MilieuCar#getAttaqueCoef(int, int)
	 */
	private int coefAttaque1;

	/**
	 * Coefficient d'attaque d'une bête par rapport à là où elle se trouve
	 * 
	 * @see MilieuCar
	 * @see MilieuCar#getDefenseCoef(int, int)
	 */
	private int coefDefense1;

	/**
	 * Coefficient d'attaque d'une bête par rapport à là où elle se trouve
	 * 
	 * @see MilieuCar
	 * @see MilieuCar#getAttaqueCoef(int, int)
	 */
	private int coefAttaque2;

	/**
	 * Coefficient d'attaque d'une bête par rapport à là où elle se trouve
	 * 
	 * @see MilieuCar
	 * @see MilieuCar#getDefenseCoef(int, int)
	 */
	private int coefDefense2;

	private int infoligne;
	private int infoColonne;

	private boolean trace;

	private int identifient;

	/**
	 * Le constructeur "Evenement" initialise initialise les différentes listes
	 * qui seront utilisée par la classe et initialise les principaux attribut
	 * de la classe
	 * 
	 * @param nbCase
	 *            Le nombre de case de la grille
	 * @param nbBete
	 *            Le nombre de bête au départ
	 * 
	 * @see Outil#pourcentage(int, int)
	 * @see Outil#choix(int, int)
	 */

	public Evenement(int nbCase, int nbBete)  {

		this.nbNourriture = Outil.pourcentage(nbBete, 25);
		this.nbCase = nbCase;
		this.nbBete = nbBete;

		grille = new Case[nbCase][nbCase];
		betes = new ArrayList<Bete>();

		initGrille();

		voisins = new HashMap<Integer, Couple>(); /*
												 * initialisation d'une
												 * initialisation d'une
												 * cordonnées des cases voisines
												 * libres d'une case en présence
												 * d'une bête
												 */

		milieu = new MilieuCar(nbCase);

		betesaAnce = new ArrayList<Bete>();
	}

	/**
	 * Elle ajoute les bêtes et la nourriture dans la grille
	 * 
	 * @see Evenement#ajoutBete()
	 * @see Evenement#ajoutNourriture()
	 */

	public void ajoutBeteNourriture() {
		ajoutBete();

		ajoutNourriture();

		affichage();

	}

	/**
	 * Elle affiche la grille en mode console et l'emplacement des nourritures
	 */

	public void affichage() {

		System.out.printf("\nEmplacement des bêtes \n");

		for (int i = 0; i < nbCase; i++) { // affichage des bêtes dansla grille

			for (int j = 0; j < nbCase; j++) {

				System.out.printf("%d", grille[i][j].isOccupe());

			}
			System.out.printf("\n");

		}

		System.out.printf("\nsexes \n\n");
		for (int i = 0; i < nbCase; i++) { // affichage des emplacements des
			// nourritures et leurs coefficients

			for (int j = 0; j < nbCase; j++) {

				System.out.printf("%d", grille[i][j].getCouple());

			}
			System.out.printf("\n");

		}

		System.out.printf("\ncaractéristiques \n\n");

		for (int i = 0; i < betes.size(); i++) { // affichages des
													// caractéristiques de
			// bêtes présentent dans la grille

			Bete b = betes.get(i);

			int ligne = b.getLigne();
			int colonne = b.getColonne();
			String string = b.toString();

			System.out.println("ligne :" + ligne + " " + "colonne :" + colonne
					+ " " + string);
		}

	}

	/**
	 * Elle ajoute la nourriture dans la grille
	 * 
	 * @see Case#getNourriture()
	 * @see Case#isOccupe()
	 */
	public void ajoutNourriture() {

		int dNourriture;
		int lg;
		int cl;

		betesaAnce = this.betes;

		cont = 0;

		while (cont < nbNourriture) { /*
									 * boucle pour ajouter la nourriture dans la
									 * grille
									 */

			lg = Outil.choix(0, nbCase - 1);
			cl = Outil.choix(0, nbCase - 1);

			int nourriture = grille[lg][cl].getNourriture();
			boolean occuper = grille[lg][cl].isOccupe() == 0;

			if (nourriture == 0 && occuper) { /*
											 * s'il n'y a pas de nourriture dans
											 * la case et que la case ne
											 * contient pas de bête
											 */

				dNourriture = Outil.choix(1, 10);

				grille[lg][cl].setNourriture(dNourriture);

				++cont;

			}

		}

	}

	/**
	 * Elle initialise les bêtes et les place dans la grille
	 */
	public void ajoutBete() {
		cont = 0;

		do {

			// cette fonction nous retourne un nombre comprise entre 0 et le
			// nombre de ligne

			lg = Outil.choix(0, nbCase - 1);
			cl = Outil.choix(0, nbCase - 1);

			try {

				if (grille[lg][cl].isOccupe() != 1) {

					Bete bet = new Bete();

					bet.setLigneColonne(lg, cl);

					betes.add(bet);

					int ligne = bet.getLigne();
					int colonne = bet.getColonne();

					grille[ligne][colonne].setOccupe(1);

					if (bet.getSexe() == "male")
						grille[ligne][colonne].setCouple(1);
					else
						grille[ligne][colonne].setCouple(3);

					System.out.println(bet.getEnergie());

					++cont;

				}

			} catch (ArrayIndexOutOfBoundsException f) {

				System.out.println(f.getMessage());

			}

		} while (cont < nbBete);
	}

	/**
	 * Elle assure le déplacement des bêtes dans la grille en tenant compte de
	 * leurs positions initiale Les bêtes se dépassent selon quatre directions;
	 * Nord, Sud, Est, Ouest
	 * 
	 * @see Case#setCouple(int)
	 * @see Case#setOccupe(int)
	 * @see Couple
	 * @see Evenement#setNourriture(int, ArrayList, Case[][])
	 * @see Evenement#setBete(Bete, int, ArrayList, Case[][])
	 * @see Evenement#combatReproduction()
	 */
	public void deplacement() {
		int lg;
		int cl;

		betesaAnce = new ArrayList<Bete>();
		betesaAnce = betes;

		System.out.println("\t");

		for (int i = 0; i < betes.size(); i++) {

			Bete bete = betes.get(i);

			cont = 0; // compteur pour compter le nombre de case voisine libre

			lg = bete.getLigne() - 1;
			cl = bete.getColonne();

			if (lg >= 0 && grille[lg][cl].isOccupe() < 2) { // test si la case
															// voisine nord de
															// "bete" est libre

				++cont;
				voisins.put(cont, new Couple(lg, cl));

			}

			lg = bete.getLigne() + 1;
			cl = bete.getColonne();

			if (lg < nbCase && grille[lg][cl].isOccupe() < 2) { // test si la
																// case voisine
																// sud de "bête"
																// est libre

				++cont;
				voisins.put(cont, new Couple(lg, cl));

			}

			lg = bete.getLigne();
			cl = bete.getColonne() - 1;

			if (cl >= 0 && grille[lg][cl].isOccupe() < 2) { // test si la case
															// voisine Est de
															// "bete" est libre

				++cont;
				voisins.put(cont, new Couple(lg, cl));

			}

			lg = bete.getLigne();
			cl = bete.getColonne() + 1;

			if (cl < nbCase && grille[lg][cl].isOccupe() < 2) { // test si la la
																// case voisine
																// Ouest de
																// "bete" est
																// libre

				++cont;
				voisins.put(cont, new Couple(lg, cl));

			}

			if (cont != 0) { // test s'il y a des cases voisines libre

				int choixV = Outil.choix(1, cont); // choisit parmis le nombre
													// de case voisine libre

				Couple couple = voisins.get(choixV); // reccupere la case
														// choisit

				lg = couple.getLigne();
				cl = couple.getColonne();

				int ligne2 = bete.getLigne();
				int colonne2 = bete.getColonne();

				if (infoligne == ligne2 && infoColonne == colonne2
						&& identifient == bete.getIdentifiant()) { // pour
																	// changer
																	// les
																	// coordonnées

					infoligne = lg;
					infoColonne = cl;
				}

				grille[ligne2][colonne2].setOccupe(-1); // réduit de 1 le nombre
														// de bête présentes
														// dans cette case car
														// la bête présente vas
														// se déplacer

				if (bete.getSexe() == "male")
					grille[ligne2][colonne2].setCouple(-1); // si la bête sui
															// s'est déplacé est
															// un mâle il réduit
															// de "1"; "1" par
															// convention
															// indique à la
															// méthode
															// "setCouple()" que
															// la case contient
															// un mâle

				else
					grille[ligne2][colonne2].setCouple(-3); // si la bête qui
															// s'est déplacé est
															// une femelle il
															// réduit de "3";
															// "3" par
															// convention
															// indique à la
															// méthode
															// "setCouple()"
															// case contient une
															// femelle

				bete.setLigneColonne(lg, cl);

				int nourriture = grille[lg][cl].getNourriture();

				if (grille[lg][cl].isOccupe() == 0 && bete.getEnergie() > 0
						&& nourriture == 0) { /*
											 * dimunition des points d"énergie
											 * de la bête si elle se rend à une
											 * case vide
											 */
					bete.setEnergie(-1);

				}

				if (nourriture > 0) { // le nombre de point d’énergie de la bête
										// augmente (nourriture dans la case)

					int ntr = nourriture + bete.getEnergie();

					if (ntr > bete.getEnergieMax())
						ntr = bete.getEnergieMax();

					bete.setEnergie(ntr);

					grille[lg][cl].setNourriture(0); // on enlève la nourriture
														// dans la case

					--nbNourriture;
				}

				grille[lg][cl].setOccupe(1); // augmente de 1 le nombre de bête
												// présente dans cette case qui
												// est la nouvelle case où s'est
												// rendu la bête

				if (bete.getSexe() == "male")
					grille[lg][cl].setCouple(1); // indique que c'est un mâle
													// qui s'est rendu dans la
													// case
				else
					grille[lg][cl].setCouple(3);// indique que c'est une femelle
												// qui s'est rendu dans la case

				System.out.println(grille[lg][cl].getCouple());

			}

			setBete(bete, i, betes, grille); // remet le nombre de bête à jour

			setNourriture(nbNourriture, betes, grille); // remet le nombre de
														// nourriture à jour

			voisins.clear();
		}

		combatReproduction(); // méthode qui assure le combat et la reproduction
								// entre deux bêtes

		affichage(); // affichage de la grille en mode console

	}

	/**
	 * Elle assure le combat et la reproduction entre deux bêtes de sexes
	 * différents ou de même sexe
	 * 
	 * @see Evenement#combat(Bete, Bete, int, int, int, int)
	 * @see Evenement#reproduction(Bete, Bete, boolean)
	 * @see Evenement#setBete(Bete, int, ArrayList, Case[][])
	 */
	public void combatReproduction() {

		boolean placement = false;

		for (int i = 0; i < betes.size(); i++) {

			Bete bete1 = betes.get(i);

			for (int j = i + 1; j < betes.size() - 1; j++) {

				Bete bete2 = betes.get(j);

				int ligne = bete1.getLigne();
				int ligne2 = bete2.getLigne();
				int colonne = bete1.getColonne();
				int colonne2 = bete2.getColonne();

				// deux bête de même sexe se trouve sur une même case
				// dans ce cas il y'a combat
				if (ligne == ligne2 && colonne == colonne2) {

					String sexe = bete2.getSexe();
					String sexe2 = bete1.getSexe();

					if (sexe2.equals(sexe)) {

						combat(bete1, bete2, ligne, colonne, ligne2, colonne2); // appelle
																				// de
																				// la
																				// methode
																				// qui
																				// qssure
																				// le
																				// combat

					} else {
						int pourcentage1 = Outil.pourcentage(
								bete1.getEnergieMax(), 50);
						int pourcentage2 = Outil.pourcentage(
								bete2.getEnergieMax(), 50);

						// deux bête de sexe diffèrent se trouve sur une même
						// case et ont 50 pour cent de leur énergie maximum
						// dans ce cas il y'a reproduction
						if (!sexe2.equals(sexe)
								&& (bete1.getEnergie() >= pourcentage1 && bete2
										.getEnergie() >= pourcentage2)) {

							attaque1 = bete1.getAttaque(); // premiere bête
							defense1 = bete1.getDefense();

							attaque2 = bete2.getAttaque(); // deuxieme bête
							defense2 = bete2.getDefense();

							reproduction(bete1, bete2, placement); // appelle de
																	// la
																	// méthode
																	// qui
																	// assure la
																	// reproduction

						}
					}

				}
				setBete(bete2, j, betes, grille); // mise à jour de le liste
													// contenant les bêtes
			}

			setBete(bete1, i, betes, grille);// mise à jour de le liste
												// contenant les bêtes

		}

	}

	/**
	 * Elle assure la reproduction en créant des bêtes et en les rajoutant dans
	 * la grille Ces bêtes sont construisent en fonction des caractéristiques de
	 * leurs parents
	 * 
	 * @param bete1
	 *            représente le premier parent
	 * @param bete2
	 *            représente le deuxième parent
	 * @param placement
	 * 
	 * @see Bete#Bete(int, int, int, int, int, int, int, int, int)
	 */
	public void reproduction(Bete bete1, Bete bete2, boolean placement) {

		bete1.setNbReproduction(1);
		bete2.setNbReproduction(1);

		aleatoir = Outil.choix(0, 1);

		/*
		 * choix des caractéristiques d'attaque chez l'un des deux parents
		 */
		if (aleatoir == 0)
			pince = attaque1.getPince();
		else
			pince = attaque2.getPince();

		aleatoir = Outil.choix(0, 1);

		if (aleatoir == 0)
			venin = attaque1.getVenin();
		else
			venin = attaque2.getVenin();

		aleatoir = Outil.choix(0, 1);

		if (aleatoir == 0)
			feu = attaque1.getFeu();
		else
			feu = attaque2.getFeu();

		aleatoir = Outil.choix(0, 1);

		if (aleatoir == 0)
			machoir = attaque1.getMachoir();
		else
			machoir = attaque2.getMachoir();

		aleatoir = Outil.choix(0, 1);

		// choix des caractéristiques de défense chez l'un des deux parent

		if (aleatoir == 0)
			bouclier = defense1.getBouclier();
		else
			bouclier = defense2.getBouclier();

		aleatoir = Outil.choix(0, 1);

		if (aleatoir == 0)
			carapace = defense1.getCarapace();
		else
			carapace = defense2.getCarapace();

		aleatoir = Outil.choix(0, 1);

		if (aleatoir == 0)
			epine = defense1.getEpine();
		else
			epine = defense2.getEpine();

		aleatoir = Outil.choix(0, 1);

		if (aleatoir == 0)
			antipoison = defense1.getAntiPoison();
		else
			antipoison = defense2.getAntiPoison();

		aleatoir = Outil.choix(0, 1);

		if (aleatoir == 0)
			energie = bete1.getEnergieMax();
		else
			energie = bete2.getEnergieMax();

		while (placement == false) {

			// cette fonction nous retourne un nombre
			// comprise entre 0 et le nombre de ligne

			lg = Outil.choix(0, nbCase - 1);
			cl = Outil.choix(0, nbCase - 1);

			// on place la bête dans une case vide,où il n'y a ni bête ni
			// nourriture
			if (grille[lg][cl].isOccupe() == 0
					&& grille[lg][cl].getNourriture() == 0) {

				System.err.println("reproduction");
				System.err
						.println("avant ajout nombre de bêtes" + betes.size());

				Bete bet = new Bete(energie, pince, venin, machoir, feu,
						carapace, bouclier, epine, antipoison);

				bet.setLigneColonne(lg, cl);

				betes.add(bet);

				System.err.println("pendant ajout nombre de bêtes"
						+ betes.size());

				grille[bet.getLigne()][bet.getColonne()].setOccupe(1);

				System.err.println("pendant ajout grille"
						+ grille[bet.getLigne()][bet.getColonne()].isOccupe());

				if (bet.getSexe() == "male")
					grille[bet.getLigne()][bet.getColonne()].setCouple(1);
				else
					grille[bet.getLigne()][bet.getColonne()].setCouple(3);

				placement = true;

				System.err
						.println("après ajout nombre de bêtes" + betes.size());

			}
		}
	}

	/**
	 * Elle assure le combat entre deux bête de même sexe dans une case
	 * 
	 * @param bete1
	 *            première bête
	 * @param bete2
	 *            deuxième bête
	 * @param ligne
	 *            la ligne où se trouve la première bête
	 * @param colonne
	 *            La colonne où se trouve la premier bête
	 * @param ligne2
	 *            la ligne où se trouve la deuxième bête
	 * @param colonne2
	 *            La colonne où se trouve la deuxième bête
	 * 
	 * @see MilieuCar#getAttaqueCoef(int, int)
	 * @see MilieuCar#getDefenseCoef(int, int)
	 * @see MilieuCar#milieu(int, int, int, int, String)
	 * @see Bete
	 */
	public void combat(Bete bete1, Bete bete2, int ligne, int colonne,
			int ligne2, int colonne2) {

		bete1.setNbCombat(1);
		bete2.setNbCombat(1);

		System.err.println("combat");

		attaque1 = bete1.getAttaque(); // caractéristiques d'attaque de la
										// première bête
		defense1 = bete1.getDefense(); // caractéristiques de défense de la
										// première bête

		attaque2 = bete2.getAttaque(); // caractéristiques d'attaque de la
										// deuxième bête
		defense2 = bete2.getDefense(); // caractéristiques de défense de la
										// deuxième bête

		coefAttaque1 = milieu.getAttaqueCoef(ligne, colonne); // coefficient
																// d'attaque de
																// la premier
																// bête en
																// fonction du
																// milieu où
																// elle se
																// trouve
																// (désert,foret,etc)
		coefDefense1 = milieu.getDefenseCoef(ligne, colonne); // coefficient de
																// défense de la
																// premier bête
																// en fonction
																// du milieu où
																// elle se
																// trouve
																// (désert,foret,etc)

		coefAttaque2 = milieu.getAttaqueCoef(ligne2, colonne2);// coefficient
																// d'attaque de
																// la deuxième
																// bête en
																// fonction du
																// milieu où
																// elle se
																// trouve
																// (désert,foret,etc)
		coefDefense2 = milieu.getDefenseCoef(ligne2, colonne2);// coefficient de
																// défense de la
																// deuxième bête
																// en fonction
																// du milieu où
																// elle se
																// trouve
																// (désert,foret,etc)

		// Comparaison des caractéristiques d'attaque et de
		// défense, en affectant à chacun le coefficient du milieu

		int feu1 = attaque1.getFeu();

		if (feu1 + coefAttaque1 > defense2.getBouclier() + coefDefense2) // Feu!=bouclier

			++niveauBete1;
		else {

			if (attaque2.getFeu() + coefAttaque2 > defense1.getBouclier()
					+ coefDefense1)

				++niveauBete2;
		}

		if (attaque1.getPince() + coefAttaque1 > defense2.getCarapace()
				+ coefDefense2) // pince !=
			// carapace

			++niveauBete1;
		else {

			if (attaque2.getPince() + coefAttaque2 > defense1.getCarapace()
					+ coefDefense1)

				++niveauBete2;
		}

		if (attaque1.getMachoir() + coefAttaque1 > defense2.getEpine()
				+ coefDefense2) // machoir !=epine

			++niveauBete1;
		else {

			if (attaque2.getMachoir() + coefAttaque2 > defense1.getEpine()
					+ coefDefense1)

				++niveauBete2;
		}

		if (attaque1.getVenin() + coefAttaque1 > defense2.getAntiPoison()
				+ coefDefense2) // venin != antipoison

			++niveauBete1;
		else {

			if (attaque2.getVenin() + coefAttaque2 > defense1.getAntiPoison()
					+ coefDefense1)

				++niveauBete2;
		}

		if (niveauBete1 > niveauBete2) { // bete1 gagne

			energiMawNew = bete2.getEnergieMax() / 2;

			int perte = bete2.getEnergie() - energiMawNew;
			if (perte <= 0)

				bete2.setEnergie1(0); // le vaincu perd la moitier des points
										// dénérgie

			int valeur = energiMawNew + bete1.getEnergie();
			if (valeur >= bete1.getEnergieMax()) // s'assure que la bête ne
													// depassera pas son énérgie
													// maximum
				valeur = bete1.getEnergieMax();

			bete1.setEnergie1(valeur); // le vainqueur gagne la moitier des
										// points perdu par le vaincu

		} else {

			if (niveauBete2 > niveauBete1) { // bete2 gagne

				energiMawNew = bete1.getEnergieMax() / 2;

				int perte = bete1.getEnergie() - energiMawNew;
				if (perte <= 0)

					bete1.setEnergie1(0); // le vaincu perd la moitier de ses
											// points d’énergie

				int valeur = energiMawNew + bete2.getEnergie();
				if (valeur >= bete2.getEnergieMax())// s'assure que la bête ne
													// dépassera pas son énergie
													// maximum
					valeur = bete2.getEnergieMax();

				bete2.setEnergie1(valeur); // le vainqueur gagne la moitier des
											// points perdu par le vaincu

			}

		}
	}

	/**
	 * Remet à jour la liste contenant toutes les bêtes, en enlevant une bête si
	 * elle est morte(elle n'a plu d’énergie)
	 * 
	 * @param bete
	 *            bête en question
	 * @param index
	 *            son index dans la liste
	 * @param betes
	 *            la liste de bête
	 * @param grille
	 *            La grille où se trouve les bêtes
	 */
	public void setBete(Bete bete, int index, ArrayList<Bete> betes,
			Case[][] grille) {

		if (bete.getEnergie() == 0) {

			System.err.println("griller");

			betes.remove(betes.get(index));

			setNbBete(betes.size());

			grille[bete.getLigne()][bete.getColonne()].setOccupe(-1);

			if (bete.getSexe() == "male")
				grille[bete.getLigne()][bete.getColonne()].setCouple(-1);
			else
				grille[bete.getLigne()][bete.getColonne()].setCouple(-3);
		}
	}

	/**
	 * remet à jour le nombre de nourriture dans la grille,
	 * 
	 * 
	 * @param nourriture
	 *            Le nombre de nourriture à l'instant "t"
	 * @param betes
	 *            le nombre de bête à l'instant "t"
	 * @param grille
	 *            La grille oû se trouve les bêtes et la nourriture
	 */
	public void setNourriture(int nourriture, ArrayList<Bete> betes,
			Case[][] grille) {

		int lg;
		int cl;
		int dNourriture;

		if (nourriture == 0) { // s'il n'y a plus de nourriture il en génère
								// "50%" par rapport aux bêtes présentes

			nbNourriture = Outil.pourcentage(betes.size(), 25);
			cont = 0;

			while (cont < nbNourriture) { // boucle pour ajouter la nourriture
											// dans la grille

				lg = Outil.choix(0, nbCase - 1);
				cl = Outil.choix(0, nbCase - 1);

				if (grille[lg][cl].getNourriture() == 0
						&& grille[lg][cl].isOccupe() == 0) { // s'il n'y a pas
																// de nourriture
																// dans la case
																// et que la
																// case ne
																// contient pas
																// de bête

					dNourriture = Outil.choix(1, 10); // densité de la
														// nourriture

					grille[lg][cl].setNourriture(dNourriture);

					cont++;

				}

			}
		}
	}

	/**
	 * Elle retourne le nombre de bête dans la grille
	 * 
	 * @return c'est un "String"
	 */
	public String getNbBete() {
		return String.valueOf(betes.size());
	}

	/**
	 * Elle met à jour le nombre de bête présente dans la grille
	 * 
	 * @param nbBete
	 *            Le nombre de bête dans la grille
	 */
	public void setNbBete(int nbBete) {
		this.nbBete = nbBete;
	}

	public String toString(int index) {

		return betes.get(index).toString1();
	}

	/**
	 * Elle retourne le nombre de bête Mâle dans la grille
	 * 
	 * @return c'est un "String"
	 */
	public String getNbBeteMale() {
		nbBeteMale = 0;

		int size = betes.size();
		for (int index = 0; index < size; index++) {

			if (betes.get(index).getSexe().equals("male"))

				++nbBeteMale;

		}

		return String.valueOf(nbBeteMale);

	}

	/**
	 * Elle retourne le nombre de bête femelle dans la grille
	 * 
	 * @return c'est un "String"
	 */
	public String getNbBeteFemelle() {
		nbBeteFemelle = 0;

		int size = betes.size();
		for (int index = 0; index < size; index++) {

			if (betes.get(index).getSexe().equals("femelle"))

				++nbBeteFemelle;

		}

		return String.valueOf(nbBeteFemelle);

	}

	/**
	 * Elle retourne le nombre de nourriture dans la grille
	 * 
	 * @return c'est un "String"
	 */
	public String getNbNourriture() {

		return String.valueOf(nbNourriture);

	}

	/**
	 * Elle retourne les informations concernant une bête; énergie, sexe,
	 * caractéristiques
	 * 
	 * @param i
	 *            Ligne sur laquelle se trouve la bête
	 * @param j
	 *            Colonne sur laquelle se trouve la bête
	 * 
	 * @return un champ de caractère
	 */
	public String getInfoBete(int i, int j) throws InformationException {
		info = "Impossible";
		
		if((i>=0 && i<nbCase) && (j>=0 && j<nbCase)){

		infoligne = i;
		infoColonne = j;

		int cpt = betesaAnce.size();

		for (int index = 0; index < cpt; index++) { // affichages des
													// caractéristiques de
													// bêtes présentent dans la
													// grille

			Bete bete = betesaAnce.get(index);

			if (bete.getLigne() == i && bete.getColonne() == j) {

				info = bete.toString1();
				identifient = bete.getIdentifiant();
			}

		}

		return info;
		
		}else{
			throw new InformationException(0,nbCase-1);
		}

	}

	/**
	 * Elle retourne un objet, l'objet de cette classe et de definir les
	 * caractéristiques des differentes parties de la grille
	 * 
	 * @return un objet de type MilieuCar, elle recupere cette objet dans la
	 *         classe "Evenement"
	 * 
	 * @see MilieuCar
	 */
	public MilieuCar getMilieuCar() {

		return milieu;
	}

	public void initGrille() {
		for (int i = 0; i < nbCase; i++) {

			for (int j = 0; j < nbCase; j++) {

				grille[i][j] = new Case(i, j);
			}

		}
	}

	/**
	 * Accesseur de la case de coordonnées "i" et "j"
	 * 
	 * @param i
	 *            la ligne où la case se trouve
	 * @param j
	 *            le colonne où la case se trouve
	 * 
	 * @return la case de coordonne :i j
	 * 
	 */
	public Case getCase(int i, int j) {

		return grille[i][j];
	}

	/**
	 * Elle retourne une ligne de la grille
	 */
	public int getInfoligne() {
		return infoligne;
	}

	/**
	 * Elle retourne une colonne de la grille
	 */
	public int getInfoColonne() {
		return infoColonne;
	}

	/**
	 * Elle retourne l'identifient de chaque bête
	 */
	public int getIdentifient() {
		return identifient;
	}

}