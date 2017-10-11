package jeu;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import reseau.Choix;
import reseau.Constantes;

@SuppressWarnings("serial")
public class EchangeCombat extends JDialog implements KeyListener, ActionListener,  Observer{
	private Joueur joueur;
	private JDialog f2 = new JDialog();	
	private Container cont;
	private JLabel label = new JLabel("Attendre le joueur adverse1");
	private JButton boutonChoisi;
	private JButton boutonChoixAdversaire;
	private JButton echange = new JButton("Echanger");
	private JButton combat = new JButton("Combattre");
	private JButton echangeA = new JButton("Echanger");
	private JButton combatA = new JButton("Combattre");
	private Color couleurBouton;
	
	public EchangeCombat(Joueur joueur){
		this.joueur = joueur;
		joueur.addObserver(this);
		f2.setBounds(250, 280, 380, 180);
		f2.setTitle("Effectuer un échange ou un combat?");
		
		cont = getContentPane();
	    cont.setLayout(new GridLayout(1,1));
	    cont.setLayout(null);
	    cont.setSize(200,200);
	    
	    echange.setSize(150, 20);
	    echange.setLocation(10, 30);
	    cont.add(echange);
		echange.addActionListener(this);
		
		combat.setSize(160, 20);
		combat.setLocation(185, 30);
	    cont.add(combat);
		combat.addActionListener(this);
		
		echangeA.setSize(150, 20);
		echangeA.setLocation(10, 110);
		cont.add(echangeA);
			
		combatA.setSize(160, 20);
		combatA.setLocation(185, 110);
		cont.add(combatA);
		
		label.setSize(160, 20);
		label.setLocation(100, 90);
	    cont.add(label);
	    if (!joueur.jouer && joueur.getEchangeCombat()==0) {
			echange.setEnabled(false);
			combat.setEnabled(false);
		}
	    label.setText("Choisissez une action1");
	    echangeA.setEnabled(false);
		combatA.setEnabled(false);
		
		f2.add(cont);
		f2.addKeyListener(this);
		f2.setResizable(false);
		f2.setModal(true);
		f2.setVisible(true);
		couleurBouton = echange.getBackground();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == echange){
			boutonChoisi = (JButton) e.getSource();
			boutonChoisi.setBackground(Color.YELLOW);
			joueur.choix = Choix.valueOf(boutonChoisi.getActionCommand());
			System.out.println(joueur.choix);
			joueur.out.println(Constantes.CHOIX + " " + boutonChoisi.getActionCommand());
			if(joueur.adversaire.choix == null)	label.setText("Attendre le joueur adverse");
			echange.setEnabled(false);
			combat.setEnabled(false);
			joueur.jouer = false;
			indiquerChoixAdversaire();
		}
		else if(e.getSource() == combat){
			boutonChoisi = (JButton) e.getSource();
			boutonChoisi.setBackground(Color.YELLOW);
			joueur.choix = Choix.valueOf(boutonChoisi.getActionCommand());
			System.out.println(joueur.choix);
			joueur.out.println(Constantes.CHOIX + " " + boutonChoisi.getActionCommand());
			if(joueur.adversaire.choix == null)	label.setText("Attendre le joueur adverse");
			echange.setEnabled(false);
			combat.setEnabled(false);
			joueur.jouer = false;
			indiquerChoixAdversaire();
		}
		
	}
	
	public void indiquerChoixAdversaire() {
		Choix choixAdversaire = joueur.adversaire.choix;

		if ((joueur.choix != null) &&( choixAdversaire != null)) {
			if (choixAdversaire == Choix.Echanger) boutonChoixAdversaire = echangeA;
			else if (choixAdversaire == Choix.Combattre) boutonChoixAdversaire = combatA;
			
			if((joueur.choix == Choix.Echanger) &&(choixAdversaire == Choix.Echanger)){
				label.setText("Echange en cours");
				boutonChoixAdversaire.setBackground(Color.GREEN);
			}
			else if((joueur.choix == Choix.Combattre) &&( choixAdversaire == Choix.Combattre)){
				label.setText("Combat en cours");
				boutonChoixAdversaire.setBackground(Color.GREEN);
			}
			else{
				label.setText("Mettez-vous d'accord!");
				boutonChoixAdversaire.setBackground(Color.RED);
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		int key = ke.getKeyCode();
		switch (key) {				    
		case  KeyEvent.VK_ESCAPE :
			f2.dispose();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

	@Override
	public void update(Observable arg0, Object arg1) {
		indiquerChoixAdversaire();		
		if (joueur.choix == Choix.Echanger && joueur.adversaire.choix == Choix.Echanger) {
			label.setText("Echange en cours");
			joueur.setEchangeCombat(1);
			joueur.adversaire.setEchangeCombat(1);
			joueur.choix = null;
			joueur.adversaire.choix = null;
		}
		else if (joueur.choix == Choix.Combattre && joueur.adversaire.choix == Choix.Combattre) {
			label.setText("Combat en cours");
			joueur.setEchangeCombat(1);
			joueur.adversaire.setEchangeCombat(1);
			joueur.choix = null;
			joueur.adversaire.choix = null;
		}
		else if ((joueur.choix == Choix.Combattre && joueur.adversaire.choix == Choix.Echanger) ||(joueur.adversaire.choix == Choix.Combattre && joueur.choix == Choix.Echanger)) {
			label.setText("Mettez-vous d'accord!");
			joueur.setEchangeCombat(1);
			joueur.adversaire.setEchangeCombat(1);
			joueur.choix = null;
			joueur.adversaire.choix = null;
		}
		else if (joueur.jouer) {
			if (boutonChoisi != null) boutonChoisi.setBackground(couleurBouton);
			echange.setEnabled(true);
			combat.setEnabled(true);

			joueur.setEchangeCombat(1);
			joueur.choix = null;
			label.setText("Choisissez une action2");
			if (boutonChoixAdversaire != null) 
				boutonChoixAdversaire.setBackground(couleurBouton); 
		}
		
	}
}
