package test1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JOptionPane;





public class Ihm extends JFrame{
	
	
	public Ihm(){
		
		
		// les regles du jeu, affiche les messages
	    JOptionPane.showMessageDialog(null,"Bienvenue dans le parc!!");
	    JOptionPane.showMessageDialog(null,"But du jeu :\n\nLes Gardiens doivent chasser les intrus du parc");
	    JOptionPane.showMessageDialog(null,"Bonne partie!!");
	    
		init();
		//cont.setBackground(Color.WHITE);
		
	}

	private void init() {
		pack();
		setTitle("Le jeu");
		setSize(1137, 715);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);
		add(new Jeu());
		//add(new JeuGardienParc());
		
		// mise en place du conteneur principal
	    
	   // cont = getContentPane();
	    //cont.setLayout(null);
	    
		
	    
		
	}
	

}
