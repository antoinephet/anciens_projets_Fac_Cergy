package ater;



import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ihm extends JFrame{
	
	private Container cont;
	
	
	public Ihm(){
		
		
		// les regles du jeu, affiche les messages
	    JOptionPane.showMessageDialog(null,"Bienvenue dans le parc!!");
	    JOptionPane.showMessageDialog(null,"But du jeu :\n\nLes Gardiens doivent chasser les intrus du parc");
	    JOptionPane.showMessageDialog(null,"Commandes du jeu :\n\nP - permet de prendre en main un gardien");
	    JOptionPane.showMessageDialog(null,"Commandes du jeu(suite) :\n\nC - permet de revenir au mode automatique");
	    JOptionPane.showMessageDialog(null,"Bonne partie!!");
	    
		initLayout();
		//cont.setBackground(Color.WHITE);
		
	}

	private void initLayout() {
		pack();
		setTitle("Le jeu");
		setSize(1137, 715);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);
		add(new JeuGardienParc());
		
		// mise en place du conteneur principal
	    
	   // cont = getContentPane();
	    //cont.setLayout(null);
	    
		
	    
		
	}
}
