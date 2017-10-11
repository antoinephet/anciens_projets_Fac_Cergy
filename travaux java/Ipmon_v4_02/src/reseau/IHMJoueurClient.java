package reseau;
import ihm.Jeu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import jeu.Joueur;


@SuppressWarnings("serial")
public class IHMJoueurClient  extends JFrame implements ActionListener, Observer {
	//private JButton enEchange = new JButton(new ImageIcon("dresseur.jpg"));
	private JLabel action = new JLabel("attendre");
	
	private JoueurClient joueur = new JoueurClient();

	public IHMJoueurClient(JoueurClient joueur) {
		this.joueur = joueur;
		joueur.addObserver(this);
		
		// les regles du jeu, affiche les messages
	    JOptionPane.showMessageDialog(null,"Bienvenue!", "Le jeu va bientôt commencer!", JOptionPane.INFORMATION_MESSAGE);
	    boolean ok = false;
	    ok = false;
	    String pseudo = null;
	    while (!ok){
		    try{
		    	
		    		pseudo = JOptionPane.showInputDialog(null, "Pseudo du joueur ?", "Sélection du pseudo du joueur", JOptionPane.QUESTION_MESSAGE);
		    		if(!pseudo.equals("")) ok=true;
		    	
			}
			catch(Exception e){} 
	    }
    	joueur.setPseudo(pseudo);
	    
	    JOptionPane.showMessageDialog(null,"Merci pour ta participation, bonne partie!!", "Bon jeu!", JOptionPane.INFORMATION_MESSAGE);
	    init(joueur);
	    //enEchange.setActionCommand(Choix.ECHANGER.toString());
	}

	/*public void actionPerformed(ActionEvent evt) {
		boutonChoisi = (JButton) evt.getSource();
		boutonChoisi.setBackground(Color.RED);
		joueur.choix = Choix.valueOf(boutonChoisi.getActionCommand());
		//joueur.out.println(Constantes.CHOIX + " " + boutonChoisi.getActionCommand());
		action.setText("attendre");
		enEchange.setEnabled(false);
		//indiquerChoixAdversaire();
	}

	public void indiquerChoixAdversaire() {

	}*/
	
	private void init(Joueur j) {
		pack();
		setTitle("Le jeu");
		setSize(1020, 715);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		//add(enEchange);
		add(new Jeu(j, this));
		setVisible(true);
		JOptionPane.showMessageDialog(null,"Appuyez sur la touche H pour connaitre la liste des commandes !", "Aide au jeu", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
	
}
