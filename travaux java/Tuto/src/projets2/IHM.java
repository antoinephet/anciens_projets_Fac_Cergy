package projets2;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Dimension;

/**Créé l'interface graphique du programme.
 */
public class IHM extends JFrame{
	private static final long serialVersionUID = -576898196694301064L;
	private JLabel jlCheminExe, jlCheminArbo, jlAffichageCheminExe, jlAffichageCheminArbo, jlTaille, jlTaille2, jlPages, jlPages2, jlNom;
	private JButton jbChangerCheminExe, jbChangerCheminArbo, jbLancerScan, jbRecherche, jbReset;
	private JFileChooser jfcCheminExe, jfcCheminArbo;
	private TableauModel model;
	private JTable jtDocsPDF;
	private JPanel jpGlobal, jpMoteurDeRecherche, jpScanArbo, jpHaut;
	private JTextField jtfTailleMin, jtfTailleMax, jtfPagesMin, jtfPagesMax, jtfNom;
	private JCheckBox jcbTaille, jcbPages, jcbNom;

	private File repertoireDepart;
	private boolean [] sensTri;
	private boolean rechercheEffectue;
	private String cheminArbo;
	private String cheminExe;
	private ArrayList<PDFDocument> pdfsRecherche;

	private ScanArborescence scanArborescence;
	private Tri tri;


	public IHM(String titre){
		super(titre);
		scanArborescence = new ScanArborescence();
		tri = new Tri();

		cheminArbo = scanArborescence.readChemin(cheminArbo, "CheminArbo.txt");
		cheminExe = scanArborescence.readChemin(cheminExe, "CheminExe.txt");
		scanArborescence.readListePDF();

		sensTri = new boolean [7];
		rechercheEffectue = false;
		Arrays.fill(sensTri,true);

		init();	
		actualiserTableau(scanArborescence.EPDFD.getPdfs());
		setSize(960,540);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	/**Ajoute et gère le placement des éléments de l'interface graphique. 
	 */
	public void init() {
		//Init des labels
		jlCheminExe = new JLabel("Chemin de l'exécutable : ");
		jlCheminArbo = new JLabel("Chemin de l'arborescence : ");
		jlAffichageCheminExe = new JLabel();
		jlAffichageCheminArbo = new JLabel();

		//ecriture des labels
		jlAffichageCheminArbo.setText(cheminArbo);
		jlAffichageCheminExe.setText(cheminExe);

		//Init des bouttons
		jbChangerCheminExe = new JButton("Parcourir ...");
		jbChangerCheminExe.addActionListener(new ActionChangerCheminExe());
		jbChangerCheminExe.setPreferredSize(new Dimension(100,23));
		jbChangerCheminArbo = new JButton("Parcourir ...");
		jbChangerCheminArbo.addActionListener(new ActionChangerCheminArbo());
		jbChangerCheminArbo.setPreferredSize(new Dimension(100,23));
		jbLancerScan = new JButton("Lancer le scan");
		jbLancerScan.addActionListener(new ActionLancerScan());

		//Init des selecteurs de fichier/dossier
		jfcCheminExe = new JFileChooser();
		jfcCheminArbo = new JFileChooser();

		//n'accepte que les fichiers executable (.exe)
		jfcCheminExe.removeChoosableFileFilter(jfcCheminExe.getAcceptAllFileFilter());
		FileNameExtensionFilter filtreExe = new FileNameExtensionFilter("Executable (.exe)", "exe");
		jfcCheminExe.setFileFilter(filtreExe);

		//n'accepte que les repertoire
		jfcCheminArbo.removeChoosableFileFilter(jfcCheminArbo.getAcceptAllFileFilter());
		FileNameExtensionFilter filtreRepertoire = new FileNameExtensionFilter("Répertoire", ".");
		jfcCheminArbo.setFileFilter(filtreRepertoire);

		//Init du tableau
		model = new TableauModel(scanArborescence.EPDFD.getPdfs());
		jtDocsPDF = new JTable(model);
		centrerTableau(jtDocsPDF);

		//ouverture fichier PDF		
		jtDocsPDF.addMouseListener(new ActionOuvertureInfo());
		jtDocsPDF.getTableHeader().addMouseListener(new ActionTri());

		//moteur de recherche
		jlTaille = new JLabel("Taille (en Mo) comprise entre : ");
		jlTaille2 = new JLabel(" et ");
		jlPages = new JLabel("Nombre de pages compris entre : ");
		jlPages2 = new JLabel(" et ");
		jlNom = new JLabel("Nom à chercher : ");

		jtfTailleMin = new JTextField(5);
		jtfTailleMin.setMinimumSize(new Dimension(40,20));
		jtfTailleMax = new JTextField(5);
		jtfTailleMax.setMinimumSize(new Dimension(40,20));
		jtfPagesMin = new JTextField(5);
		jtfPagesMin.setMinimumSize(new Dimension(40,20));
		jtfPagesMax = new JTextField(5);
		jtfPagesMax.setMinimumSize(new Dimension(40,20));
		jtfNom = new JTextField(100);
		jtfNom.setMinimumSize(new Dimension(40,20));

		jbRecherche = new JButton("Lancer");
		jbRecherche.addActionListener(new ActionLancerRecherche());

		jbReset = new JButton("Reset");
		jbReset.addActionListener(new ActionResetRecherche());

		jcbTaille = new JCheckBox();
		jcbPages = new JCheckBox();
		jcbNom = new JCheckBox();


		//ajout des elements
		jpGlobal = new JPanel(new GridBagLayout());
		jpScanArbo = new JPanel(new GridBagLayout());
		jpMoteurDeRecherche = new JPanel(new GridBagLayout());
		jpHaut = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;

		//ajout des elements de scan arbo
		gbc.insets = new Insets(2,2,2,2); 

		ajoutComposant(jpScanArbo, jlCheminExe,  gbc,  0,  0,  2,  1,  GridBagConstraints.LINE_START,  GridBagConstraints.NONE);
		ajoutComposant(jpScanArbo, jbChangerCheminExe, gbc,  1,  0,  GridBagConstraints.REMAINDER,  1,  GridBagConstraints.EAST,  GridBagConstraints.NONE);
		ajoutComposant(jpScanArbo,  jlAffichageCheminExe,  gbc, 0,  1,  GridBagConstraints.REMAINDER, 1, GridBagConstraints.LINE_START, GridBagConstraints.NONE);
		ajoutComposant(jpScanArbo,  jlCheminArbo, gbc, 0,  2,  2,  1,  GridBagConstraints.LINE_START, GridBagConstraints.NONE);
		ajoutComposant(jpScanArbo,  jbChangerCheminArbo,  gbc,  1,  2,  GridBagConstraints.REMAINDER,  1,  GridBagConstraints.EAST,  GridBagConstraints.NONE);
		ajoutComposant(jpScanArbo,  jlAffichageCheminArbo,  gbc,  0,  3,  GridBagConstraints.REMAINDER,  1,  GridBagConstraints.LINE_START,  GridBagConstraints.NONE);
		ajoutComposant(jpScanArbo,  jbLancerScan,  gbc,  0,  4,  GridBagConstraints.REMAINDER,  1,  GridBagConstraints.CENTER,  GridBagConstraints.NONE);


		//1ere ligne du moteur de recherche : recherche par taille
		gbc.insets = new Insets(0, 15, 10, 10);

		ajoutComposant(jpMoteurDeRecherche,  jcbTaille,  gbc,  0,  0,  1,  1,  GridBagConstraints.LINE_START,  GridBagConstraints.NONE);
		ajoutComposant(jpMoteurDeRecherche,  jlTaille,  gbc,  GridBagConstraints.RELATIVE,  0,  3,  1,  GridBagConstraints.CENTER,  GridBagConstraints.HORIZONTAL);
		ajoutComposant(jpMoteurDeRecherche,  jtfTailleMin,  gbc,  GridBagConstraints.RELATIVE,  0,  1,  1,  GridBagConstraints.CENTER,  GridBagConstraints.HORIZONTAL);
		ajoutComposant(jpMoteurDeRecherche,  jlTaille2,  gbc,  GridBagConstraints.RELATIVE,  0,  1,  1,  GridBagConstraints.CENTER,  GridBagConstraints.HORIZONTAL);
		ajoutComposant(jpMoteurDeRecherche,  jtfTailleMax,  gbc,  GridBagConstraints.RELATIVE,  0,  1,  1,  GridBagConstraints.CENTER,  GridBagConstraints.HORIZONTAL);


		//2em ligne du moteur de recherche : recherche par nombre de pages
		ajoutComposant(jpMoteurDeRecherche,  jcbPages, gbc,  0,  1,  1,  1,  GridBagConstraints.LINE_START,  GridBagConstraints.NONE);
		ajoutComposant(jpMoteurDeRecherche,  jlPages,  gbc,  GridBagConstraints.RELATIVE,  1,  3,  1,  GridBagConstraints.CENTER,  GridBagConstraints.HORIZONTAL);
		ajoutComposant(jpMoteurDeRecherche,  jtfPagesMin,  gbc,  GridBagConstraints.RELATIVE,  1,  1,  1,  GridBagConstraints.CENTER,  GridBagConstraints.HORIZONTAL);
		ajoutComposant(jpMoteurDeRecherche,  jlPages2,  gbc,  GridBagConstraints.RELATIVE,  1,  1,  1,  GridBagConstraints.CENTER,  GridBagConstraints.HORIZONTAL);
		ajoutComposant(jpMoteurDeRecherche,  jtfPagesMax,  gbc,  GridBagConstraints.RELATIVE,  1,  1,  1,  GridBagConstraints.CENTER,  GridBagConstraints.HORIZONTAL);


		//3em ligne du moteur de recherche : recherche par nom
		ajoutComposant(jpMoteurDeRecherche, jcbNom, gbc, 0, 2, 1, 1, GridBagConstraints.LINE_START,  GridBagConstraints.NONE);
		ajoutComposant(jpMoteurDeRecherche, jlNom, gbc, GridBagConstraints.RELATIVE, 2,  3,  1,  GridBagConstraints.CENTER,  GridBagConstraints.HORIZONTAL);
		ajoutComposant(jpMoteurDeRecherche, jtfNom, gbc, GridBagConstraints.RELATIVE, 2, GridBagConstraints.REMAINDER, 1, GridBagConstraints.CENTER,  GridBagConstraints.HORIZONTAL);


		//4em ligne du moteur de recherche : boutons lancer et reset
		ajoutComposant(jpMoteurDeRecherche, jbRecherche, gbc, 1, 3, 3, 1, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
		ajoutComposant(jpMoteurDeRecherche, jbReset, gbc, 4, 3, 4, 1, GridBagConstraints.LINE_END, GridBagConstraints.HORIZONTAL);


		//ajout panel scanArbo et moteurRecherche dans le panel du haut
		gbc.insets = new Insets(5, 5, 5, 5);

		ajoutComposant(jpHaut, jpScanArbo, gbc, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		JSeparator jsep = new JSeparator(SwingConstants.VERTICAL);
		ajoutComposant(jpHaut, jsep, gbc, GridBagConstraints.RELATIVE, 0, 0, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		ajoutComposant(jpHaut, jpMoteurDeRecherche, gbc, 1, 0, 1, 1, GridBagConstraints.LINE_END, GridBagConstraints.BOTH);


		//ajout panel haut et bas dans le panel principal
		gbc.insets = new Insets(0,0,0,0); 		

		gbc.weighty = 0;
		ajoutComposant(jpGlobal, jpHaut, gbc, 0, 0, GridBagConstraints.REMAINDER, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
		gbc.weighty = 1;
		ajoutComposant(jpGlobal, new JScrollPane(jtDocsPDF), gbc, 0, 1, GridBagConstraints.REMAINDER, GridBagConstraints.REMAINDER, GridBagConstraints.SOUTH, GridBagConstraints.BOTH);

		getContentPane().add(jpGlobal);
	}

	/**Centre les éléments du tableau fourni en paramètre.
	 * 
	 * @param table : tableau (Jtable) 
	 */
	private void centrerTableau(JTable table) {
		DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
		custom.setHorizontalAlignment(JLabel.CENTER); 
		for (int i=2 ; i<table.getColumnCount() ; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(custom); 
		}
	}

	/**Ré-actualise le tableau grâce à l'ArrayList fourni en paramètre.
	 * 
	 * @param pdfs : ArrayList de PDFDocument
	 */
	private void actualiserTableau (ArrayList<PDFDocument> pdfs) {
		model.setData(pdfs);
	}


	/**Méthode utilisée pour faciliter l'ajout de composants à un panneau grâce à un Gridbaglayout.
	 * 
	 * @param jp : Panneau dans lequel on ajoute un composant
	 * @param c : Composant à ajouter
	 * @param gbc : GridbagConstraints utilisé pour l'ajout
	 * @param gridx0 
	 * @param gridy0
	 * @param gridwidth0 
	 * @param gridheight0
	 * @param anchor0
	 * @param fill0
	 * 
	 * @see GridBagConstraints
	 * @see GridBagLayout
	 */
	private void ajoutComposant(JPanel jp, Component c, GridBagConstraints gbc, int gridx0, int gridy0, int gridwidth0, int gridheight0, int anchor0, 
			int fill0) {
		gbc.gridx = gridx0;
		gbc.gridy = gridy0;
		gbc.gridwidth = gridwidth0;
		gbc.gridheight = gridheight0;
		gbc.anchor = anchor0;
		gbc.fill = fill0;
		jp.add(c, gbc);
	}

	/**Moteur de recherche permettant de rechercher par date, taille et nombre de pages.
	 * 
	 * 
	 * @param tailleMin 
	 * @param tailleMax 
	 * @param rechercheParTaille : type boolean, indique si la recherche par taille est activée 
	 * @param nbPagesMin 
	 * @param nbPagesMax 
	 * @param rechercheParPages : type boolean, indique si la recherche par nombre de pages est activée
	 * @param nom
	 * @param rechercheParNom : type boolean, indique si la recherche par nom est activée
	 * @return une ArrayList de PDFDocument qui répondent aux critères de la recherche
	 */
	private ArrayList<PDFDocument> moteurDeRecherche (double tailleMin, double tailleMax, boolean rechercheParTaille, int nbPagesMin, int nbPagesMax,
			boolean rechercheParPages, String nom, boolean rechercheParNom) {
		ArrayList<PDFDocument> alEntrante = new ArrayList<PDFDocument>(scanArborescence.EPDFD.getPdfs());
		ArrayList<PDFDocument> alSupprression = new ArrayList<PDFDocument>();
		ArrayList<PDFDocument> alSortante = new ArrayList<PDFDocument>(scanArborescence.EPDFD.getPdfs());
		if(rechercheParNom) {
			for(PDFDocument pdfd : alEntrante) {
				if(!(pdfd.getNom().contains(nom))) 
					alSupprression.add(pdfd);
			}			
		}

		if(rechercheParPages) {
			for(PDFDocument pdfd : alEntrante) {
				if(pdfd.getNombreDePages() < nbPagesMin || pdfd.getNombreDePages() > nbPagesMax) 
					alSupprression.add(pdfd);

			}			
		}

		if(rechercheParTaille) {
			for(PDFDocument pdfd : alEntrante) {
				if(pdfd.getTaille() < tailleMin || pdfd.getTaille() > tailleMax) 
					alSupprression.add(pdfd);
			}
		}	
		alSortante.removeAll(alSupprression);
		return alSortante;
	}


	/**Tri le tableau de fichiers PDF en fonction de sur quel entête l'utilisateur a cliqué.</br></br>
	 * Au 1er clic, trie par ordre croissant.</br>
	 * au 2eme clic, trie par ordre décroissant.</br>
	 */
	class ActionTri extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			int colonne = jtDocsPDF.columnAtPoint(e.getPoint());
			ArrayList <PDFDocument> alATrier;
			ArrayList <PDFDocument> alTrie;
			boolean remplacerListePrincipale;
			if(rechercheEffectue) {
				alATrier = pdfsRecherche; 
				remplacerListePrincipale = false;
			}
			else {
				alATrier = scanArborescence.EPDFD.getPdfs();
				remplacerListePrincipale = true;
			}
			boolean sens = sensTri[colonne];
			switch (colonne) {
			case 0:
				alTrie = tri.triParEmplacement(alATrier, sens);
				actualiserTableau(alTrie);
				break;
			case 1:
				alTrie = tri.triParNom(alATrier, sens);
				actualiserTableau(alTrie);
				break;
			case 2:
				alTrie = tri.triParNbPages(alATrier, sens);
				actualiserTableau(alTrie);
				break;
			case 3:
				alTrie = tri.triParTaille(alATrier, sens);
				actualiserTableau(alTrie);
				break;
			case 4:
				alTrie = tri.triParDate(alATrier, sens);
				actualiserTableau(alTrie);
				break;
			case 5:
				alTrie = tri.triParCryptage(alATrier, sens);
				actualiserTableau(alTrie);
				break;			
			case 6:
				alTrie = tri.triParVersion(alATrier, sens);
				actualiserTableau(alTrie);
				break;
			default:
				throw new IllegalArgumentException();
			}
			if(remplacerListePrincipale) 
				scanArborescence.EPDFD.setPdfs(alTrie);
			else
				pdfsRecherche = alTrie;

			Arrays.fill(sensTri,true);
			sensTri[colonne] = sens^true;
		}
	}

	/**
	 * Ouvre une fenêtre d'information sur le fichier PDF sur double-clic de l'utilisateur.</br>
	 * Possibilité d'ouvrir le PDF via la fenêtre d'information.
	 */
	class ActionOuvertureInfo extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			JTable target = (JTable)e.getSource();
			int ligne = target.getSelectedRow();
			if(e.getClickCount() == 2) {
				PDFDocument pdfd;
				if(rechercheEffectue) {
					pdfd = pdfsRecherche.get(ligne);
				}
				else {
					pdfd = scanArborescence.EPDFD.getPdfs().get(ligne);
				}
				String[] choices = {"Ouvrir", "Annuler"};
				int reponse = JOptionPane.showOptionDialog(null, pdfd, "Description du fichier PDF", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE ,
						null, choices, null);
				if(reponse == 0) {
					String[] commands = {cheminExe,pdfd.getEmplacement() + "\\" + pdfd.getNom()};
					try {
						Runtime.getRuntime().exec(commands);
					} catch (IOException ee) {
						JOptionPane.showMessageDialog(null, "Impossible d'ouvrir le fichier PDF, vérifiez le chemin de l'exécutable", "Message", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}


	/**Permet de changer le chemin de l'exécutable à utiliser pour ouvrir un fichier PDF.
	 */
	class ActionChangerCheminExe implements ActionListener {
		public void actionPerformed(ActionEvent ae) {	
			int retour = jfcCheminExe.showOpenDialog(rootPane);
			if(retour == JFileChooser.APPROVE_OPTION){
				cheminExe = jfcCheminExe.getSelectedFile().getAbsolutePath();
				jlAffichageCheminExe.setText(cheminExe);
				scanArborescence.saveChemin(cheminExe, "CheminExe.txt");
			}
		}
	} 

	/**Permet de changer le chemin de l'arborescence à scanner.
	 */
	class ActionChangerCheminArbo implements ActionListener {
		public void actionPerformed(ActionEvent ae) {	
			jfcCheminArbo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int retour = jfcCheminArbo.showOpenDialog(rootPane);
			if(retour == JFileChooser.APPROVE_OPTION ){
				cheminArbo = jfcCheminArbo.getSelectedFile().getAbsolutePath();
				jlAffichageCheminArbo.setText(cheminArbo);
				repertoireDepart = jfcCheminArbo.getSelectedFile();
				scanArborescence.saveChemin(cheminArbo, "CheminArbo.txt");
			}
		}
	} 

	/**Permet de lancer un scan de l'arborescence choisie, et donne la durée de la recherche à la fin de celle ci.
	 */
	class ActionLancerScan implements ActionListener {
		public void actionPerformed(ActionEvent ae) {	
			jcbNom.setSelected(false);
			jcbPages.setSelected(false);
			jcbTaille.setSelected(false);
			long startTime = System.currentTimeMillis();
			if(cheminArbo.length()!=0) {
				repertoireDepart = new File(cheminArbo);
			}
			scanArborescence.EPDFD.clearPdfs();

			scanArborescence.parcoursArbo(repertoireDepart);
			
			scanArborescence.EPDFD.setPdfs(tri.triParNom(scanArborescence.EPDFD.getPdfs(), true));
			ArrayList<PDFDocument> alPDFD = new ArrayList<PDFDocument>(scanArborescence.EPDFD.getPdfs());
			
			actualiserTableau(alPDFD);
			if(alPDFD.size() !=0)
				scanArborescence.saveListePDF();
			int nbPDF = alPDFD.size();
			if(nbPDF==0)
				JOptionPane.showMessageDialog(null, "Recherche effectuée en : " + (System.currentTimeMillis() - startTime) +"ms.\nAucun fichier PDF n'a été trouvé.", "Message", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "Recherche effectuée en : " + (System.currentTimeMillis() - startTime) +"ms.\n" + alPDFD.size() + " fichiers PDF ont été trouvés.");
		}	
	}

	/**Fait appel au moteur de recherche en fonction des cases cochées et des informations saisies dans les champs de texte.</br>
	 * Gère les erreurs de saisie (nombre négatif, minimum supérieur au maximum, caractère non valide).
	 */
	class ActionLancerRecherche implements ActionListener {
		public void actionPerformed(ActionEvent ae) {	
			rechercheEffectue = true;
			boolean rechercheParNom = jcbNom.isSelected();
			boolean rechercheParPages = jcbPages.isSelected();
			boolean rechercheParTaille = jcbTaille.isSelected();

			String nom = "";
			double tailleMin = 0, tailleMax = Double.MAX_VALUE;
			int nbPagesMin = 0, nbPagesMax = Integer.MAX_VALUE;

			if(rechercheParNom && jtfNom.getText().length() != 0)
				nom = jtfNom.getText();

			if(rechercheParTaille) {
				String strTailleMin = jtfTailleMin.getText();
				if(strTailleMin.length() != 0) {
					try {			
						tailleMin = (Double.parseDouble(strTailleMin) *1024*1024);
						if(tailleMin < 0) {
							JOptionPane.showMessageDialog(null, "Saisie non valide : " + strTailleMin + "\nSeuls les nombres positifs sont acceptés." , "Erreur", JOptionPane.ERROR_MESSAGE);
							jtfTailleMin.setText("0");
						}
					}
					catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Saisie non valide : " + strTailleMin + "\nSeuls les caractères '1' '2' '3' '4' '5' '6' '7' '8' '9' '.' sont autorisés.", "Erreur", JOptionPane.ERROR_MESSAGE);
						jtfTailleMin.setText("0");
					}
				}
				else
					jtfTailleMin.setText("0");
				String strTailleMax = jtfTailleMax.getText();
				if(strTailleMax.length() != 0 && !(strTailleMax.equals("Max"))) {
					try {	
						tailleMax = (Double.parseDouble(strTailleMax)) *1012*1024;
						if(tailleMax < 0) {
							JOptionPane.showMessageDialog(null, "Saisie non valide : " + strTailleMax + "\nSeuls les nombres positifs sont acceptés" , "Erreur", JOptionPane.ERROR_MESSAGE);
							jtfTailleMax.setText("0");
						}
					}
					catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Saisie non valide : " + strTailleMax + "\nSeuls les caractères '1' '2' '3' '4' '5' '6' '7' '8' '9' '.' sont autorisés.", "Erreur", JOptionPane.ERROR_MESSAGE);
						jtfTailleMax.setText("0");
					}
				}
				else
					jtfTailleMax.setText("Max");
				if(tailleMin>tailleMax) {
					JOptionPane.showMessageDialog(null, "Saisie non valide :\nLa taille minimale est supérieur à la taille maximale." , "Erreur", JOptionPane.ERROR_MESSAGE);
					jtfTailleMin.setText("");
					jtfTailleMax.setText("");
					tailleMin = 0;
					tailleMax = Double.MAX_VALUE;
					jcbTaille.setSelected(false);
				}
			}
			else {
				jtfTailleMin.setText("");
				jtfTailleMax.setText("");
			}

			if(rechercheParPages) {
				String strPagesMin = jtfPagesMin.getText();
				if(strPagesMin.length() != 0){
					try {
						nbPagesMin = Integer.parseInt(strPagesMin);
						if(nbPagesMin < 0) {
							JOptionPane.showMessageDialog(null, "Saisie non valide : " + strPagesMin + "\nSeuls les nombres positifs sont acceptés." , "Erreur", JOptionPane.ERROR_MESSAGE);
							jtfPagesMin.setText("0");
						}
					}
					catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Saisie non valide : " + strPagesMin + "\nSeuls les caractères '1' '2' '3' '4' '5' '6' '7' '8' '9' sont autorisés.", "Erreur", JOptionPane.ERROR_MESSAGE);
						jtfPagesMin.setText("0");
					}
				}
				else
					jtfPagesMin.setText("0");
				String strPagesMax = jtfPagesMax.getText();
				if(strPagesMax.length() != 0 && !(strPagesMax.equals("Max"))) {
					try {
						nbPagesMax = Integer.parseInt(strPagesMax);
						if(nbPagesMax < 0) {
							JOptionPane.showMessageDialog(null, "Saisie non valide : " + strPagesMax + "\nSeuls les nombres positifs sont acceptés." , "Erreur", JOptionPane.ERROR_MESSAGE);
							jtfPagesMax.setText("0");
						}
					}
					catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Saisie non valide : " + strPagesMax + "\nSeuls les caractères '1' '2' '3' '4' '5' '6' '7' '8' '9' sont autorisés.", "Erreur", JOptionPane.ERROR_MESSAGE);
						jtfPagesMax.setText("0");
					}
				}
				else
					jtfPagesMax.setText("Max");
				if(nbPagesMin>nbPagesMax) {
					JOptionPane.showMessageDialog(null, "Saisie non valide :\nLe nombre de pages minimal est supérieur au nombre de pages maximal." , "Erreur", JOptionPane.ERROR_MESSAGE);
					jtfPagesMin.setText("");
					jtfPagesMax.setText("");
					nbPagesMin = 0;
					nbPagesMax = Integer.MAX_VALUE;
					jcbPages.setSelected(false);
				}
			}
			else {
				jtfPagesMin.setText("");
				jtfPagesMax.setText("");
			}

			pdfsRecherche = moteurDeRecherche(tailleMin, tailleMax, rechercheParTaille, nbPagesMin, nbPagesMax, rechercheParPages, nom, rechercheParNom);
			actualiserTableau(tri.triParNom(pdfsRecherche,true));
		}
	}

	/**Reset la recherche :</br>
	 * Décoche les cases, efface le texte dans les champs de texte, et ré-actualise le tableau avec l'ensemble des PDF trouvés.
	 */
	class ActionResetRecherche implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			rechercheEffectue = false;
			jtfTailleMin.setText("");
			jtfTailleMax.setText("");
			jtfPagesMin.setText("");
			jtfPagesMax.setText("");
			jtfNom.setText("");

			jcbTaille.setSelected(false);
			jcbPages.setSelected(false);
			jcbNom.setSelected(false);
			actualiserTableau(scanArborescence.EPDFD.getPdfs());
		}
	}
}