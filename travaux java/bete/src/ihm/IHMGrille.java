package ihm;

import ihm.Bouton;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.AttaqueCar;
import data.Case;
import data.Grille;

import engine.MilieuCar;
import exceptions.EnvironnementException;
import exceptions.InformationException;
import exceptions.PlacerException;

/**
 * Classe concernant l'intrface graphique
 * 
 * @author Bacari Keita
 *
 */
public class IHMGrille implements Runnable {

	private JPanel panelColonne = new JPanel();
	private JPanel panelLigne = new JPanel();
	private JPanel panelColonne1 = new JPanel();
	private JPanel panelLigne1 = new JPanel();
	/**
	 * Panel concernant le changement d'environnement
	 */
	private JPanel top = new JPanel();
	private JComboBox combo = new JComboBox();
	private JLabel label = new JLabel("Environnement");
	private JLabel xi = new JLabel("Xi");
	private JLabel yi = new JLabel("Yi");
	private JLabel xj = new JLabel("Xj");
	private JLabel yj = new JLabel("Yj");
	private JButton envi = new JButton("Valider");
	private JTextField xiText = new JTextField(1);
	private JTextField yiText = new JTextField(1);
	private JTextField xjText = new JTextField(1);
	private JTextField yjText = new JTextField(1);
	private JPanel env = new JPanel();
    private JPanel infoEnv = new JPanel();
    private JPanel infoEn = new JPanel();
    private JPanel jp7 = new JPanel();
	/*
	 * Les label des images de la page d'accueil
	 */
	private JLabel labTextMale = new JLabel("B�te M�le");
	private JLabel labTextFemelle = new JLabel("B�te Femelle");
	private JLabel labTextNourr = new JLabel("Nourriture");

     
	/*
	 * Panel pour la legende
	 */
	 private JPanel legendes = new JPanel();
	 private JLabel l1 = new JLabel("Dessert");
	    private JLabel l2 = new JLabel("For�t");
	    private JLabel l3 = new JLabel("Montagne");
	    private JLabel l4 = new JLabel("Neutre");
	    private JLabel l5 = new JLabel("La legende");	    
	    private JPanel top6 = new JPanel();
		   private JPanel top1 = new JPanel();
		   private JPanel top2 = new JPanel();
		    private JPanel top3 = new JPanel();
		   private  JPanel top4 = new JPanel();
		    private JPanel ok1 = new JPanel();
		    private JPanel top5 =new JPanel();
		    
		    private Font fon = new Font(Font.MONOSPACED,Font.BOLD,20);  

	/**
	 * information sur la  grille
	 */
	private static final long serialVersionUID = 1L;

	private JTextField b�tesText = new JTextField(2);
	private JTextField b�teMaleText = new JTextField(2);
	private JTextField b�teFemelleText = new JTextField(2);
	private JTextField nourritureText = new JTextField(2);
	
	/**
	 * Information par rapport a chaque case de la Grille
	 * a partir de leur cordonnee
	 */
	private JTextField lg = new JTextField(2);
	private JTextField cl = new JTextField(2);
	private TextArea zone =new TextArea(15,5);
	private JPanel paneArea = new JPanel();
	private JPanel g = new JPanel();
	private JButton b = new JButton("Cordonnee");
	/*
	 * Panel pour information sur la grille
	 */
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	private JPanel jp5 = new JPanel();
	
	private JPanel jp6 = new JPanel();
	
	private JPanel chEnvironnement = new JPanel();
	

	private JPanel panelGauche = new JPanel();
	private JPanel jp4 = new JPanel();
	private JPanel container = new JPanel();
	
	
    /*
     * les quatres panel � gauche
     */
	private JPanel couleurLegendes = new JPanel();
    private JPanel infoGrille = new JPanel();
   
	private	JPanel infoG = new JPanel();
	
	/**
	 * Declaration GridBadgLayout
	 */
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints constraints = new GridBagConstraints();

	private int nbBete;

	/**
	 * La methode servant � determiner le nombre de case dans la grille
	 * 
	 */
	private int nbCase;

	private JPanel panneau;

	private Grille grille;
/**
 * Les Buttons pour les manoeuvres
 */
	private JButton play;
	private JButton placer;
	private JButton recom;
	
 /**
  * le container des Buttons
  */
	private JPanel util = new JPanel();
	private JPanel util1 = new JPanel();
	private JPanel util2 = new JPanel();
	private JPanel util3 = new JPanel();
	/**
	 * Panel pour la Grille
	 */
	private JPanel cellules = new JPanel();
	private JPanel image = new JPanel();
	private JPanel info = new JPanel();
    /**
     * Champ de texte pour dessiner la grille avec les B�tes
     */
	private JTextField texf1 = new JTextField(5);
	private JTextField texf2 = new JTextField(5);
	private JLabel label1 =new JLabel("Case:");
	private JLabel label2 =new JLabel("Bete:");
	
	private JPanel celluleMere = new JPanel();
	
	/*
	 * Matrice de type Jpanel pour former les petites cases
	 */
	private JPanel dessin[][];
	/**
	 * Les images � utulis�
	 */
   //newImageIcon( getClass() .getResource( "/images/pack_editors.png" ));
	
	private ImageIcon imageIconMale = new ImageIcon("images/b�te_m�le.png");

	private ImageIcon imageIconFemelle = new ImageIcon("images/b�te_femelle.png");

	private ImageIcon imageIconNourriture = new ImageIcon("images/gateau.png");
     /*
      * pour les fonts
      */
	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 29);
	private Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 29);
	private boolean stop = true;

	private IHMGrille instance = this;

	private int i, j;
	private String envirnmt;
	
	private JLabel coordn;
	
	private JPanel pause = new JPanel();
	private JPanel pan1 = new JPanel();
	private JPanel bouton = new JPanel();
	private JPanel pl = new JPanel();

	public IHMGrille(JPanel container) {
		initCellules();

		panneau = new JPanel();
		
		b�tesText.setEditable(false);
		b�teMaleText.setEditable(false);
		b�teFemelleText.setEditable(false);
		nourritureText.setEditable(false);
		
		infoEn.add(xi);
		infoEn.add(xiText);
		infoEn.add(yi);
		infoEn.add(yiText);
		infoEn.add(xj);
		infoEn.add(xjText);
		infoEn.add(yj);
		infoEn.add(yjText);
		
		b.setText("Cordonn�e");
		g.add(b);
		g.add(lg);
		g.add(cl);

		zone.setBackground(SystemColor.inactiveCaptionText);
		zone.setFont(new java.awt.Font("Comic Sans MS", 5, 15));
		zone.setForeground(Color.WHITE);
		zone.setBackground(SystemColor.inactiveCaptionText);
	     zone.setFont(new java.awt.Font("Comic Sans MS", 5, 13));
		zone.setForeground(Color.WHITE);
		

		zone.setEditable(false);
		combo.setPreferredSize(new Dimension(100, 20));
		combo.addItem("montagne");
		combo.addItem("desert");
		combo.addItem("foret");
		combo.addItem("neutre");
	   
		legendes.setBackground(Color.white);
		legendes.setLayout(new BorderLayout());
		  
		    couleurLegendes.setLayout(new GridLayout(5,1));
		    top3.setBackground(Color.GRAY);
		    top1.setBackground(Color.ORANGE);
		    top2.setBackground(Color.GREEN);
		    top5.setBackground(Color.BLUE);
		   
		    top1.setLayout(new FlowLayout(FlowLayout.CENTER));
		    top2.setLayout(new FlowLayout(FlowLayout.CENTER));
		    top3.setLayout(new FlowLayout(FlowLayout.CENTER));
		    top4.setLayout(new FlowLayout(FlowLayout.CENTER));
		    l5.setFont(fon);
		    
		    top5.add(l5);
		    top1.add(l1);
		    top2.add(l2);
		    top3.add(l3);
		    top4.add(l4); 
		    couleurLegendes.add(top5);
		    couleurLegendes.add(top1);
		    couleurLegendes.add(top2);
		    couleurLegendes.add(top3);
		    couleurLegendes.add(top4);
		    legendes.add(couleurLegendes, BorderLayout.CENTER);

		top.add(label);
		top.add(combo);

		jp7.add(envi, FlowLayout.LEFT);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp5.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp6.setLayout(new FlowLayout(FlowLayout.LEFT));

	
		infoGrille.setLayout(new GridLayout(4, 1));
		infoEnv.setLayout(new GridLayout(3, 1));
		infoG.setLayout(new GridLayout(2, 1));
        /*
         * Pour color�e les bordures du contenant toutes les donnee � gauche
         */
		jp4.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		infoG.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		infoEnv.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		infoGrille.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		/*
		 * Pour color�e les bordure du panel des renseignement des couleurs
		 */
		top4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		top1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		top2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		top3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jp4.setLayout(new GridLayout(4, 1));
 
		jp1.add(new JLabel(" B�te : "));
		jp1.add(b�tesText);
		jp2.add(new JLabel(" B�te m�le  : "));
		jp2.add(b�teMaleText);
		jp3.add(new JLabel("B�te femelle  : "));
		jp3.add(b�teFemelleText);
		jp5.add(new JLabel("Nourriture "));
		jp5.add(nourritureText);
		
		infoGrille.add(jp1);
		infoGrille.add(jp2);
		infoGrille.add(jp3);
		infoGrille.add(jp5);

		infoEnv.add(top);
		infoEnv.add(infoEn);
		infoEnv.add(jp7);

		infoG.add(g);
		infoG.add(zone);

		jp4.add(infoGrille);
		jp4.add(infoG);
		jp4.add(infoEnv);
		jp4.add(legendes);

		panelGauche.setLayout(new BorderLayout());
		panelGauche.add(panneau);

		container.setLayout(new BorderLayout());
		container.setLayout(new GridLayout(1, 2));
		container.setLayout(gridbag);

		buildConstraints(constraints, 0, 0, 1, 2, 0, 40);
		constraints.fill = GridBagConstraints.VERTICAL;
		constraints.anchor = GridBagConstraints.EAST;
		gridbag.setConstraints(jp4, constraints);
		container.add(jp4);

		buildConstraints(constraints, 1, 0, 1, 1, 60, 60);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.EAST;
		gridbag.setConstraints(panelGauche, constraints);
		container.add(panelGauche);

	

	}
/**
 * m�thode sert a positionn� les composant selon la largeur ,le longueur dans la grille
 * 
 * @param gbc
 * @param gx
 * @param gy
 * @param gw
 * @param gh
 * @param wx
 * @param wy
 */
	void buildConstraints(GridBagConstraints gbc, int gx, int gy, int gw,
			int gh, int wx, int wy) {

		gbc.gridx = gx;
		gbc.gridy = gy;
		gbc.gridwidth = gw;
		gbc.gridheight = gh;
		gbc.weightx = wx;
		gbc.weighty = wy;

	}

	// grille irhad

	/**
	 * Elle sert � initiliser la fen�tre en pla�ant
	 */
	public void init() {

		play = new JButton("PLAY");
		placer = new JButton("PLACER");
		recom = new JButton("RECOMMENCER");

		recom.setToolTipText("Recommencer");

		panneau.setLayout(new BorderLayout());
		
		panelColonne.setLayout(new GridLayout(1, nbCase));
		panelLigne.setLayout(new GridLayout(nbCase, 1));
		celluleMere.setLayout(new BorderLayout());
    
		util.setBackground(Color.cyan);
		panelColonne.setBackground(Color.white);
		panelLigne.setBackground(Color.WHITE);
		panelColonne1.setBackground(Color.white);
		panelLigne1.setBackground(Color.WHITE);

		pause.setBackground(Color.GRAY);
		pan1.setBackground(Color.CYAN);
		pl.setBackground(Color.GRAY);

		bouton.setLayout(new GridLayout(4, 1));
        pl.add(placer);
		util.add(label1);
		util.add(texf1);

		pan1.add(label2);
		pan1.add(texf2);
		pause.add(recom);
		pause.add(play);

		bouton.add(util);
		bouton.add(pan1);
		bouton.add(pause);
		bouton.add(pl);

		play.addActionListener(new ActionStopPlay());
		placer.addActionListener(new ActionPlacer());
		recom.addActionListener(new ActionRecommencer());
		b.addActionListener(new ActionInformation());
		envi.addActionListener(new ActionAnvironnement());
		combo.addItemListener(new ItemEnvironnment());

		panneau.add(bouton, BorderLayout.SOUTH);
		celluleMere.add(cellules, BorderLayout.CENTER);
		panneau.add(celluleMere, BorderLayout.CENTER);

	}

	/**
	 * Elle ecrit les coordonn�es de la grille, ligne (� gauche de la grille) et
	 * colonne (au dessus de le grille)
	 */
	public void coordonnees() {

		panelColonne.removeAll();
		panelLigne.removeAll();

		for (int i = 0; i < nbCase; i++) {

			coordn = new JLabel(String.valueOf(i));

			coordn.setFont(font1);

			panelColonne.add(coordn);

		}

		for (int j = 0; j < nbCase; j++) {
			coordn = new JLabel(String.valueOf(j));

			coordn.setFont(font1);

			panelLigne.add(coordn);
		}

		celluleMere.add(panelColonne, BorderLayout.NORTH);
		celluleMere.add(panelLigne, BorderLayout.WEST);
		celluleMere.add(panelColonne1, BorderLayout.SOUTH);
		celluleMere.add(panelLigne1, BorderLayout.EAST);

		panelColonne.updateUI();
		panelLigne.updateUI();
	}

	/**
	 * Elle affiche trois images, � l'endroit sera la grille
	 */
	public void initCellules() {

		ImageIcon iconMale = new ImageIcon(imageIconMale.getImage()
				.getScaledInstance(200, 400, 0));

		ImageIcon iconFemelle = new ImageIcon(imageIconFemelle.getImage()
				.getScaledInstance(200, 400, 0));

		ImageIcon iconNourriture = new ImageIcon(imageIconNourriture.getImage()
				.getScaledInstance(200, 400, 0));

		JLabel labelMal = new JLabel(iconMale);
		JLabel labelfemme = new JLabel(iconFemelle);
		JLabel labelNourr = new JLabel(iconNourriture);

		JLabel labTextMale = new JLabel("B�te M�le");
		JLabel labTextFemelle = new JLabel("B�te Femelle");
		JLabel labTextNourr = new JLabel("Nourriture");

		labTextFemelle.setFont(font);
		labTextMale.setFont(font);
		labTextNourr.setFont(font);

		cellules.setLayout(new BorderLayout());
		info.setLayout(new GridLayout(1, 3));

		image.add(labelMal);
		image.add(labelNourr);
		image.add(labelfemme);

		info.add(labTextMale);
		info.add(labTextNourr);
		info.add(labTextFemelle);

		cellules.add(image);
		cellules.add(info, BorderLayout.SOUTH);

		cellules.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	/**
	 * Cette m�thode affiche la grille et les b�tes pr�sentes, elle affiche
	 * aussi les nourritures dans la grille; elle permet �galement d'observer le
	 * deplacement des b�tes
	 * 
	 * @see Grille#getCase(int, int)
	 * @see Grille#nbBeteCase(int, int)
	 * @see Case#getCouple()
	 */
	public void environnement() {
		try {
			ImageIcon iconMale = new ImageIcon(imageIconMale.getImage()
					.getScaledInstance(25, 25, 0));

			ImageIcon iconFemelle = new ImageIcon(imageIconFemelle.getImage()
					.getScaledInstance(25, 25, 0));

			ImageIcon iconNourriture = new ImageIcon(imageIconNourriture
					.getImage().getScaledInstance(25, 25, 0));

			cellules.removeAll(); // reinitialisation du panneau

			cellules.setLayout(new GridLayout(nbCase, nbCase));

			for (int i = 0; i < nbCase; i++) {
				for (int j = 0; j < nbCase; j++) {

					dessin[i][j] = new JPanel();

					if (grille.nbBeteCase(i, j) == 2) { // test si la case
														// contient
														// deux b�tes

						if (grille.getCase(i, j).getCouple() == 2) { // Test si
																		// la
																		// case
																		// contient
																		// deux
																		// m�les
																		// voir
																		// la
																		// classe
																		// "Case"

							dessin[i][j].setLayout(new GridLayout(1, 2));

							JLabel label = new JLabel(iconMale);

							JLabel label1 = new JLabel(iconMale);

							dessin[i][j].add(label);
							dessin[i][j].add(label1);

						} else {
							if (grille.getCase(i, j).getCouple() == 4) { // Test
																			// si
																			// la
																			// case
																			// contient
																			// m�les
																			// et
																			// une
																			// femelle
																			// voir
																			// la
																			// classe
																			// "Case"

								dessin[i][j].setLayout(new GridLayout(1, 2));

								JLabel label = new JLabel(iconMale);

								JLabel label1 = new JLabel(iconFemelle);

								dessin[i][j].add(label);
								dessin[i][j].add(label1);

							} else {
								if (grille.getCase(i, j).getCouple() == 6) { // Test
																				// si
																				// la
																				// case
																				// sontient
																				// deux
																				// femelle

									dessin[i][j]
											.setLayout(new GridLayout(1, 2));

									JLabel label = new JLabel(iconFemelle);

									JLabel label1 = new JLabel(iconFemelle);

									label.setToolTipText(grille.getCase(i, j)
											.toString());

									dessin[i][j].add(label);
									dessin[i][j].add(label1);

								}
							}
						}

					} else {

						if (grille.nbBeteCase(i, j) == 1) { // Test si la case
															// contient une b�te

							if (grille.getCase(i, j).getCouple() == 1) { // Test
																			// si
																			// la
																			// case
																			// sontient
																			// un
																			// m�le
																			// Par
																			// convention
																			// 1
																			// indique
																			// que
																			// la
																			// case
																			// est
																			// occup�e
																			// par
																			// un
																			// m�le
																			// voir
																			// classe
																			// "Case"

								dessin[i][j].setLayout(new GridLayout(1, 2));

								JLabel label = new JLabel(iconMale);

								dessin[i][j].add(label);

							} else {
								if (grille.getCase(i, j).getCouple() == 3) { // Test
																				// si
																				// la
																				// case
																				// sontient
																				// une
																				// femelles
																				// Par
																				// convention
																				// 3
																				// indique
																				// que
																				// la
																				// case
																				// est
																				// occup�e
																				// par
																				// un
																				// m�le
																				// voir
																				// classe
																				// "Case"

									dessin[i][j]
											.setLayout(new GridLayout(1, 2));

									JLabel label = new JLabel(iconFemelle);

									dessin[i][j].add(label);

								}
							}

						} else { // case vide

							JLabel label = new JLabel();

							dessin[i][j].add(label);
						}
					}

					if (grille.getCase(i, j).getNourriture() > 0) { // placement
																	// de
																	// la
																	// nourriture
						JLabel label = new JLabel(iconNourriture);

						dessin[i][j].add(label);
					}

					dessin[i][j].setBorder(BorderFactory
							.createLineBorder(Color.black));
					cellules.add(dessin[i][j]);

					dessin[i][j].setToolTipText(grille.getCase(i, j)
							.getCordonn�esCase());

				}

			}

			cellules.updateUI(); // Mise a jour du panneau

		} catch (IllegalArgumentException f) {

			System.out.println("Entrez le nombre de b�te et de case");
			
			new ExceptionMessage("Entrez le nombre de b�te et de case");			

		}
	}

	/**
	 * Elle fait tourner le programme infiniment Contient la m�thode qui affiche
	 * la grille, elle rappele la m�thode qui affiche la grille en un lapse de
	 * temps indiquer dans "Thread.sleep(1050)"
	 * 
	 * @see IHMGrille#environnement()
	 * @see IHMGrille#environnement1()
	 */
	public void run() {
		try {
			while (!stop && Integer.valueOf(grille.getNbBete()) > 0) {
				try {
					Thread.sleep(1050); // 1 second = 1/100 second.
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				environnement1();

				if (grille.getIdentifient() != 0) {

					int infoColonne = grille.getInfoColonne();
					int infoLigne = grille.getInfoLigne();

					try {

						String infoBete = grille.getInfoBete(infoLigne,
								infoColonne);

						zone.setText(infoBete);
						dessin[infoLigne][infoColonne]
								.setBackground(Color.CYAN);

					} catch (InformationException exp) {

						System.out.println(exp.toString());
						
						new ExceptionMessage(exp.toString());

					}
				}

				String nbBete1 = grille.getNbBete();
				String nbBete2 = grille.getNbBeteMale();
				String nbBete3 = grille.getNbBeteFemelle();
				String nbBete4 = grille.getNbNourriture();

				b�tesText.setText(nbBete1);
				b�teMaleText.setText(nbBete2);
				b�teFemelleText.setText(nbBete3);
				nourritureText.setText(nbBete4);
			}

		} catch (NullPointerException exp) {

			System.out.println("Entrez le nombre de b�te et de case");
			
			new ExceptionMessage("Entrez le nombre de case et de b�te");

		}

	}

	/**
	 * Cette classe active le bouton "Play", qui lance le programme Ce bouton
	 * permet de lancer et de stopper le programme
	 * 
	 * @author Irhad
	 * 
	 */
	private class ActionStopPlay implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (!stop) {
				stop = true;
				play.setText(" Play ");
			} else {
				stop = false;
				play.setText(" Pause ");

				Thread chronoThread = new Thread(instance);
				chronoThread.start();
			}
		}

	}

	/**
	 * Cette classe active le bouton "Placer"
	 * 
	 * @author Irhad
	 * 
	 */
	private class ActionPlacer implements ActionListener {

		/**
		 * Elle active le bouton "Placer" et appelle la m�thode qui dessine la
		 * grille
		 * 
		 * @see IHMGrille#environnement2()
		 */
		public void actionPerformed(ActionEvent e) {

			String text = texf2.getText();
			String text2 = texf1.getText();

			try {
				nbBete = Integer.valueOf(text);
				nbCase = Integer.valueOf(text2);
				try {

					grille = new Grille(nbBete, nbCase);
					dessin = new JPanel[nbCase][nbCase];

					environnement2();

					String nbBete1 = grille.getNbBete();
					String nbBete2 = grille.getNbBeteMale();
					String nbBete3 = grille.getNbBeteFemelle();
					String nbBete4 = grille.getNbNourriture();

					b�tesText.setText(nbBete1);
					b�teMaleText.setText(nbBete2);
					b�teFemelleText.setText(nbBete3);
					nourritureText.setText(nbBete4);

					placer.setText("Next");

				} catch (PlacerException f) {

					System.out.println(f.toString());
					
					new ExceptionMessage(f.toString());
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Entrez le nombre de case et de b�te");
				
				new ExceptionMessage("Entrez le nombre de case et de b�te");
			}

		}

	}

	/**
	 * Cette classe ctive le bouton "Recommencer"
	 * 
	 * @author Irhad
	 * 
	 */
	private class ActionRecommencer implements ActionListener {

		/**
		 * Elle arrete l'annimationn et replace les b�tes
		 * 
		 * @see Grille#Grille(int, int)
		 */
		public void actionPerformed(ActionEvent e) {
			stop = true;
			play.setText(" play ");

			try {

				grille = new Grille(nbBete, nbCase);
			} catch (PlacerException e1) {

				System.out.println(e1.toString());
				
				new ExceptionMessage(e1.toString());
			}
		}

	}

	/**
	 * Active le bouton "coordonn�es", permetant d'afficher les informations
	 * d'une b�te
	 * 
	 * @author Irhad
	 * 
	 */
	private class ActionInformation implements ActionListener {

		/**
		 * elle active le bouton "coordonn�es" et affiche les informations d'une
		 * b�te
		 * 
		 * @see Grille#getInfoBete(int, int)
		 */
		public void actionPerformed(ActionEvent e) {

			String text = lg.getText();
			String text2 = cl.getText();

			try {

				i = Integer.valueOf(text);
				j = Integer.valueOf(text2);
				try {
					String infoBete = grille.getInfoBete(i, j);

					zone.setText(infoBete); // affiche les informations de
													// la b�te
													// pr�sente dans la
													// case (i,j)

					dessin[i][j].setBackground(Color.CYAN);

				} catch (InformationException exf) {

					System.out.println(exf.toString());
                    
					new ExceptionMessage("Rentrez les coordonn�es de la case o� se trouve la b�te");
				}

			} catch (NumberFormatException nfe) {

				System.out
						.println("Rentrez les coordonn�es de la case o� se trouve la b�te");
               
				new ExceptionMessage("Rentrez les coordonn�es de la case o� se trouve la b�te");
			}

		}

	}

	class ItemEnvironnment implements ItemListener {

		public void itemStateChanged(ItemEvent e) {

			Object item = e.getItem();
			envirnmt = String.valueOf(item);

			System.out.println("�v�nement d�clench� sur : " + item);
		}
	}

	/**
	 * Active le bouton qui definit l'environnement
	 * 
	 * @author Irhad
	 * 
	 */
	class ActionAnvironnement implements ActionListener {

		/**
		 * Ective le bouton qui definit l'environnement
		 * 
		 * @see IHMGrille#paintEnvironnement()
		 * @see Grille#getMilieuCar()
		 * @see MilieuCar#milieu(int, int, int, int, String)
		 */
		public void actionPerformed(ActionEvent e) {

			int xi, yi;
			int xj, yj;
			try {

				String text = xiText.getText();
				String text2 = xjText.getText();
				String text3 = yiText.getText();
				String text4 = yjText.getText();

				xi = Integer.valueOf(text);

				xj = Integer.valueOf(text2);

				yi = Integer.valueOf(text3);

				yj = Integer.valueOf(text4);

				try {
					
					MilieuCar milieuCar = grille.getMilieuCar();
					milieuCar.milieu(xi, yi, xj, yj, envirnmt);

					paintEnvironnement();

				} catch (EnvironnementException exp) {

					System.out.println(exp.toString());
					
					new ExceptionMessage(exp.toString());
				}

			} catch (NumberFormatException exp) {

				System.out.println("Entrez les limites de l'environnement");
				
				new ExceptionMessage("Entrez les limites de l'environnement");
			}

		}

	}

	/**
	 * Elle affiche la grille en respectant la nouvelle position des b�tes grace
	 * � la m�thode "deplacement"
	 * 
	 * @see Grille#deplacement()
	 * @see IHMGrille#environnement()
	 * @see IHMGrille#paintEnvironnement()
	 */
	public void environnement1() {
		grille.deplacement();
		environnement();
		paintEnvironnement();
	}

	/**
	 * Elle affiche la grille en appellent "environnement", et le coordonn�es
	 * 
	 * @see IHMGrille#coordonnees()
	 * @see IHMGrille#environnement()
	 */
	public void environnement2() {
		coordonnees();
		environnement();
		paintEnvironnement();
	}

	/**
	 * Elle definit la couleur de l'environnement, dans la grille en mettant la
	 * couleur associ�e � chaque environnement
	 * 
	 * @see MilieuCar#getCouleur(int, int)
	 */
	public void paintEnvironnement() {

		for (int i = 0; i < nbCase; i++) {
			for (int j = 0; j < nbCase; j++) {

				MilieuCar milieuCar = grille.getMilieuCar();
				Color couleur = milieuCar.getCouleur(i, j);

				dessin[i][j].setBackground(couleur);
			}
		}
	}

}
