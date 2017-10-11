package ihm;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ihm extends JFrame{
	
	public Ihm(){
		
		// les regles du jeu, affiche les messages
	    JOptionPane.showMessageDialog(null,"Bienvenue dans le jeu!!");
	    JOptionPane.showMessageDialog(null,"But du jeu :\n\nLe joueur doit attraper les IPMONS");
	    JOptionPane.showMessageDialog(null,"Bonne partie!!");
	    
	    
	    
	    init();
		
	}

	private void init() {
		
		pack();
		setTitle("Le jeu");
		setSize(1020, 715);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);
		add(new Jeu());
	}
	

}
