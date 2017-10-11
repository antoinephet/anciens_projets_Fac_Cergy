package data;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ihm.IHMGrille;
import ihm.Pam;
public class Fenetre extends JFrame {
	
	/**
	 * Cette attribut représente le nombre de bête présente dans la grille
	 * 
	 * Elle n'est pas modifiable
	 */
	private int nbBete;

	/**
	 * Cette attribut représente le nombre de case de la grille (nbCase*nbcase)
	 * 
	 * Elle n'est pas modifiable
	 */
	private int nbCase;
	
	private JPanel panneau = new JPanel();
	
	private IHMGrille IHMGrille;
	

	private JMenuBar menuBar = new JMenuBar();
	private JMenu t1 = new JMenu("Fichier");
	private JPanel t2 = new JPanel();
	private JMenuItem item1 = new JMenuItem("Ouvrir");
	private JMenuItem item2 = new JMenuItem("Fermer");
	private JMenuItem item3 = new JMenuItem("Pourcentage");
	private JMenuItem item4 = new JMenuItem("Environnement");


	public Fenetre() {
        super("Petites_Betes"+" BACARI Irhad & GIMBA Keita");
        
		IHMGrille = new IHMGrille(panneau);
		
		IHMGrille.init();
		
		t1.add(item1);
		t1.add(item2);
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Pam();
			}
		});
		
		
		
		t1.add(item2);
		
		t1.add(item3);
		t1.add(item4);
		menuBar.add(t1);
		t2.add(menuBar);
		setJMenuBar(menuBar);
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(950,630);
		
		this.setContentPane(panneau);
		
		setVisible(true);
		
	}
 
}
